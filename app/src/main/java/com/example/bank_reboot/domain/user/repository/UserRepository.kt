package com.example.bank_reboot.domain.user.repository

import androidx.lifecycle.MutableLiveData
import com.example.bank_reboot.domain.user.api.UserAPI
import com.example.bank_reboot.domain.user.model.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserRepository (val userAPI: UserAPI){
    val user: MutableLiveData<User> = MutableLiveData<User>()

    fun getUserByID(id: Int){
        userAPI.getUserByID(id).enqueue(object :Callback<User>{
            override fun onFailure(call: Call<User>, t: Throwable) {
                t.printStackTrace()
            }

            override fun onResponse(call: Call<User>, response: Response<User>) {
                if (response.body() != null){
                    user.value = response.body()
                } else {
                    user.value = User(0,0,0,0)
                }
            }

        })
    }
}