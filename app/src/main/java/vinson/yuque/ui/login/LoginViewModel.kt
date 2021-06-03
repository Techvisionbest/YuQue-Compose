package vinson.yuque.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import vinson.yuque.data.RetrofitClient

class LoginViewModel: ViewModel() {

    private val _username = MutableLiveData("")
    val username: LiveData<String> = _username

    private val _password = MutableLiveData("")
    val password: LiveData<String> = _password

    fun onUsernameChange(newValue: String){
        _username.value = newValue
    }

    fun onPasswordChange(newValue: String){
        _password.value = newValue
    }

    fun tryLogin(){
        viewModelScope.launch {
            val info = RetrofitClient.service.fetchUserInfo()
        }
    }
}