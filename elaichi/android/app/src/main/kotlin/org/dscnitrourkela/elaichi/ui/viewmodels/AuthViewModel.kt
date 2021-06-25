package org.dscnitrourkela.elaichi.ui.viewmodels

//
//@HiltViewModel
//class AuthViewModel @Inject constructor(
//    private val dataStoreRepository: DataStoreRepository,
//    private val mailRepository: MailRepository,
//) : ViewModel() {
//
//    private val _loginStatus = MutableLiveData<Resource<List<Mail>>>()
//    val loginStatus: LiveData<Resource<List<Mail>>> = _loginStatus
//
//    fun login(credential: String) {
//        _loginStatus.postValue(Resource.loading(null))
//        if (credential.isEmpty()) {
//            _loginStatus.postValue(Resource.error("Please fill out all the fields", null))
//            return
//        }
//        mailRepository.setCredential(credential)
//        CoroutineScope(viewModelScope.coroutineContext).launch {
//            val result = mailRepository.login()
//            _loginStatus.postValue(result)
//        }
//    }
//
//    fun saveLogIn() = CoroutineScope(Dispatchers.IO).launch {
//        dataStoreRepository.apply {
//            mailRepository.getCredential().let { saveCredential(R.string.key_credential, it) }
//            mailRepository.getToken().let { saveCredential(R.string.key_token, it) }
//            saveState(R.string.key_should_sync, true)
//        }
//    }
//
//    fun resetLogin() = viewModelScope.launch {
//        dataStoreRepository.resetLogin()
//        mailRepository.resetLogin()
//    }
//}