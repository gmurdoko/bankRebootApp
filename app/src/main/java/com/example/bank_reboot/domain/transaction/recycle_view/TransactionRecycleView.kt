package com.example.bank_reboot.domain.transaction.recycle_view

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.bank_reboot.R
import com.example.bank_reboot.domain.transaction.model.Transaction

class TransactionRecycleAdapter(
    val transactionList: List<Transaction>,
    val getActivity: FragmentActivity?
) : RecyclerView.Adapter<TransactionViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransactionViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_transaction_history_layout, parent, false)
        return TransactionViewHolder(view)
    }

    override fun getItemCount(): Int {
        return transactionList.size
    }

    override fun onBindViewHolder(holder: TransactionViewHolder, position: Int) {
        holder.amount_transfer.text = transactionList[position].amount.toString()
        holder.date_transfer.text = transactionList[position].trans_date
    }

}

class TransactionViewHolder(v: View) : RecyclerView.ViewHolder(v) {
    val amount_transfer = v.findViewById<TextView>(R.id.balance_history_list)
    val date_transfer = v.findViewById<TextView>(R.id.date_transaction_history_list)
}