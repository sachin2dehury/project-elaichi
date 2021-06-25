package org.dscnitrourkela.elaichi.ui.activities

import androidx.activity.viewModels
import androidx.annotation.NonNull
import androidx.lifecycle.lifecycleScope
import dagger.hilt.android.AndroidEntryPoint
import io.flutter.embedding.android.FlutterFragmentActivity
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.plugin.common.MethodChannel
import io.flutter.plugins.GeneratedPluginRegistrant
import kotlinx.coroutines.launch
import org.dscnitrourkela.elaichi.R
import org.dscnitrourkela.elaichi.others.Status
import org.dscnitrourkela.elaichi.others.debugLog
import org.dscnitrourkela.elaichi.ui.viewmodels.MainViewModel

@AndroidEntryPoint
class MainActivity : FlutterFragmentActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun configureFlutterEngine(@NonNull flutterEngine: FlutterEngine) {
        GeneratedPluginRegistrant.registerWith(flutterEngine)
        MethodChannel(flutterEngine.dartExecutor.binaryMessenger, CHANNEL)
            .setMethodCallHandler { call, result ->
                if (call.method.equals("startOwlMail", ignoreCase = true)) {
                    login("117cr0160", "Sachin@2017")
                }
                if (call.method.equals("getMails", ignoreCase = true)) {

                    result.success(viewModel.mails.size)
                }
            }
    }

    //TODO Change the hardcoded email password
    private fun login(roll: String = "", password: String = "") =
        lifecycleScope.launch {
            val result = viewModel.login(roll, password)
            debugLog(result)
            when (result.status) {
                Status.SUCCESS -> {
                    debugLog("Logged In")
                    getMails()
                }
                Status.ERROR -> {
                    //TODO Show Error
                }
                Status.LOADING -> {
                    //TODO Show Progress Bar
                }
            }
        }

    private fun getMails() = viewModel.getMails(getString(R.string.inbox), 0).invokeOnCompletion {
        debugLog(viewModel.mails)
    }

    private fun getParsedMails(conversationId: Int) =
        viewModel.getParsedMails(conversationId).invokeOnCompletion {
            debugLog(viewModel.parsedMails)
        }

    companion object {
        private const val CHANNEL = "org.dscnitrourkela.elaichi"
    }
}
