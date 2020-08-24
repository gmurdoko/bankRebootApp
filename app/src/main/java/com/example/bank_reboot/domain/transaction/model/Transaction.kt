package com.example.bank_reboot.domain.transaction.model

class Transaction(
    val trans_id: Int = 0,
    val user_owner_id: Int = 0,
    val trans_date: String = "",
    val destination: String = "",
    val amount: Int = 0,
    val description: String = ""

)