package org.dscnitrourkela.elaichi.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import okhttp3.Credentials
import org.dscnitrourkela.elaichi.api.data.Mail
import org.dscnitrourkela.elaichi.api.data.ParsedMail
import org.dscnitrourkela.elaichi.others.Resource
import org.dscnitrourkela.elaichi.repository.MailRepository
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
//    private val dataStoreRepository: DataStoreRepository,
    private val mailRepository: MailRepository,
) : ViewModel() {

    var mails = emptyList<Mail>()

    var parsedMails = emptyList<ParsedMail>()

    fun getMails(request: String, month: Int) = viewModelScope.launch {
        mails = mailRepository.getMails(request, month)
    }


    suspend fun login(roll: String, password: String): Resource<List<Mail>> {
        mailRepository.setCredential(Credentials.basic(roll, password))
        return mailRepository.login()
    }

    fun getParsedMails(conversationId: Int) = viewModelScope.launch {
        parsedMails = mailRepository.getParsedMails(conversationId)
    }

}