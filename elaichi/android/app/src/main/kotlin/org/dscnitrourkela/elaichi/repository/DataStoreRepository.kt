package org.dscnitrourkela.elaichi.repository

//class DataStoreRepository(
//    private val context: Context,
//    private val dataStore: DataStore<Preferences>
//) {
//
//    suspend fun saveCredential(key: Int, value: String) =
//        dataStore.edit { settings ->
//            settings[stringPreferencesKey(context.getString(key))] = value
//        }
//
//    suspend fun saveState(key: Int, value: Boolean) =
//        dataStore.edit { settings ->
//            settings[booleanPreferencesKey(context.getString(key))] = value
//        }
//
//    fun readCredential(key: Int) =
//        flow { emit(dataStore.data.first()[stringPreferencesKey(context.getString(key))]) }
//
//    fun readState(key: Int) =
//        flow { emit(dataStore.data.first()[booleanPreferencesKey(context.getString(key))]) }
//
//    suspend fun resetLogin() {
//        saveCredential(R.string.key_credential, "")
//        saveCredential(R.string.key_token, "")
//        saveState(R.string.key_should_sync, false)
//    }
//}