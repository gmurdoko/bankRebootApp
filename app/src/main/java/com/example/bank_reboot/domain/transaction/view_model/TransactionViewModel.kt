package com.example.bank_reboot.domain.transaction.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.bank_reboot.config.retrofit.RetrofitBuilder
import com.example.bank_reboot.domain.transaction.api.TransactionAPI
import com.example.bank_reboot.domain.transaction.model.Transaction
import com.example.bank_reboot.domain.transaction.repository.TransactionRepository

class TransactionViewModel : ViewModel(){
private val transactionRepository: TransactionRepository

    init {
        val transactionApi =  RetrofitBuilder.createRetrofit().create(TransactionAPI::class.java)
        transactionRepository = TransactionRepository(transactionApi)
    }
    val allTransaction : LiveData<List<Transaction>> = transactionRepository.transactionList
    fun getAllTransaction(){
        transactionRepository.getAllTransaction()
    }
    fun createTransaction(transaction: Transaction){
        transactionRepository.createTransaction(transaction)
    }
}