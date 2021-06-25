package org.dscnitrourkela.elaichi.ui.viewmodels

//@HiltViewModel
//class SplashViewModel @Inject constructor(
//    private val dataStoreRepository: DataStoreRepository,
//    private val mailRepository: MailRepository,
//) : ViewModel() {
//
//    private val _forceUpdate = MutableLiveData(false)
//
//    val isLoggedIn = _forceUpdate.switchMap {
//        dataStoreRepository.readCredential(R.string.key_token)
//            .asLiveData(viewModelScope.coroutineContext).map { token ->
//                if (token.isNullOrEmpty()) {
//                    false
//                } else {
//                    mailRepository.setToken(token)
//                    true
//                }
//            }.switchMap { loggedIn ->
//                dataStoreRepository.readCredential(R.string.key_credential)
//                    .asLiveData(viewModelScope.coroutineContext).map { credential ->
//                        if (credential.isNullOrEmpty()) {
//                            loggedIn
//                        } else {
//                            mailRepository.setCredential(credential)
//                            true
//                        }
//                    }
//            }
//    }
//
//    fun syncState() = _forceUpdate.postValue(true)
//}