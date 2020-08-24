package com.example.bank_reboot.domain.transaction.repository

import androidx.lifecycle.MutableLiveData
import com.example.bank_reboot.domain.transaction.api.TransactionAPI
import com.example.bank_reboot.domain.transaction.model.Transaction
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TransactionRepository (val transactionAPI: TransactionAPI){
    val transactionList: MutableLiveData<List<Transaction>> = MutableLiveData<List<Transaction>>()

    fun getAllTransaction(){
        transactionAPI.getAllTransaction().enqueue(object : Callback<List<Transaction>>{
            override fun onFailure(call: Call<List<Transaction>>, t: Throwable) {
                t.printStackTrace()
            }

            override fun onResponse(
                call: Call<List<Transaction>>,
                response: Response<List<Transaction>>
            ) {
                transactionList.value = response.body() as List<Transaction>
            }

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