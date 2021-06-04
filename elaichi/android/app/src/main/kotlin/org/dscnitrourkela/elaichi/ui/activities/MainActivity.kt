package org.dscnitrourkela.elaichi.ui.activities

import androidx.annotation.NonNull
import androidx.lifecycle.asLiveData
import dagger.hilt.android.AndroidEntryPoint
import io.flutter.embedding.android.FlutterFragmentActivity
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.plugin.common.MethodChannel
import io.flutter.plugins.GeneratedPluginRegistrant
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import okhttp3.Credentials
import org.dscnitrourkela.elaichi.R
import org.dscnitrourkela.elaichi.others.debugLog
import org.dscnitrourkela.elaichi.repository.MailRepository
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : FlutterFragmentActivity() {

    @Inject
    lateinit var mailRepository: MailRepository

    override fun configureFlutterEngine(@NonNull flutterEngine: FlutterEngine) {
        GeneratedPluginRegistrant.registerWith(flutterEngine)
        MethodChannel(flutterEngine.dartExecutor.binaryMessenger, CHANNEL)
            .setMethodCallHandler { call, result ->
                if (call.method.equals("startOwlMail", ignoreCase = true)) {
                    login()
                }
                if (call.method.equals("getMails", ignoreCase = true)) {
                    val list = getMails()
                    debugLog(list)
                    result.success(list?.size)
                }
                if (call.method.equals("getParsedMails", ignoreCase = true)) {
                    result.success(getParsedMails(0))
                    //pass the conversation id to this
                }
            }
    }

    fun getMails() =
        flow {
            emit(mailRepository.getMails(getString(R.string.inbox), 0).first())
        }.asLiveData().value

    //TODO Change the hardcoded email password
    fun login(roll: String = "Roll no", password: String = "Password.") {
        mailRepository.setCredential(Credentials.basic(roll, password))
        flow { emit(mailRepository.login()) }
        debugLog("Ho gaya login, aage badho")
    }

    fun getParsedMails(conversationId: Int) =
        flow {
            emit(mailRepository.getParsedMails(conversationId).first())
        }.asLiveData().value

    companion object {
        private const val CHANNEL = "org.dscnitrourkela.elaichi"
    }
}
