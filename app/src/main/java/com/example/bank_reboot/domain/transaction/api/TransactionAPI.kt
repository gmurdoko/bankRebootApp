package com.example.bank_reboot.domain.transaction.api

import com.example.bank_reboot.domain.transaction.model.Transaction
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface TransactionAPI {

    @GET("tansactions")
    fun getAllTransaction():Call<List<Transaction>>

    @POST("transaction")
    fun createTransaction(@Body transaction: Transaction): Call<Transaction>
}