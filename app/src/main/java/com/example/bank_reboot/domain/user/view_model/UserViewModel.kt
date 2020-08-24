package com.example.bank_reboot.domain.user.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.bank_reboot.config.retrofit.RetrofitBuilder
import com.example.bank_reboot.domain.user.api.UserAPI
import com.example.bank_reboot.domain.user.model.User
import com.example.bank_reboot.domain.user.repository.UserRepository

class UserViewModel : ViewModel(){
    private val userRepository: UserRepository
    init {
        val userAPI = RetrofitBuilder.createRetrofit().create(UserAPI::class.java)
        userRepository = UserRepository(userAPI)
    }

    val user : LiveData<User> = userRepository.user

    fun getUserByID(id: Int){
        userRepository.getUserByID(id)
    }
}