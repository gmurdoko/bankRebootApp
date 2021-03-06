package com.example.bank_reboot.domain.transaction.repository

import androidx.lifecycle.MutableLiveData
import com.example.bank_reboot.domain.transaction.api.TransactionAPI
import com.example.bank_reboot.domain.transaction.model.Transaction
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TransactionRepository (val transactionAPI: TransactionAPI){
    val transactionList: MutableLiveData<List<Transaction>> = MutableLiveData<List<Transaction>>()

    fun getAllTransaction(){
        transactionAPI.getAllTransaction().enqueue(object : Callback<Any>{
            override fun onFailure(call: Call<Any>, t: Throwable) {
                t.printStackTrace()
            }

            override fun onResponse(call: Call<Any>, response: Response<Any>) {
                val responseData = response.body()
                val gson = Gson()
                transactionList.value=gson.fromJson(gson.toJson(responseData),Array<Transaction>::class.java).toList()
            }
//            override fun onFailure(call: Call<List<Transaction>>, t: Throwable) {
//                t.printStackTrace()
//            }
//
//            override fun onResponse(
//                call: Call<List<Transaction>>,
//                response: Response<Any>
//            ) {
//                t.printStackTrace()t.printStackTrace()
//            }

        })
    }

    fun createTransaction(transaction: Transaction){
        transactionAPI.createTransaction(transaction).enqueue(object : Callback<Transaction>{
            override fun onFailure(call: Call<Transaction>, t: Throwable) {
                t.printStackTrace()
            }

            override fun onResponse(call: Call<Transaction>, response: Response<Transaction>) {
                val responseData = response.body()


            }

        })
    }
}