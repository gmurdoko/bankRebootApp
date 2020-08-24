package com.example.bank_reboot.domain.user.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bank_reboot.R
import com.example.bank_reboot.domain.transaction.recycle_view.TransactionRecycleAdapter
import com.example.bank_reboot.domain.transaction.view_model.TransactionViewModel
import kotlinx.android.synthetic.main.fragment_user_transaction_history.*


class UserTransactionHistoryFragment : Fragment() {
    private val transactionViewModel by activityViewModels<TransactionViewModel>()
    private lateinit var transactionRecycleAdapter: TransactionRecycleAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_user_transaction_history, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        transaction_list_recycle_view.layoutManager = LinearLayoutManager(activity)
        transactionViewModel.getAllTransaction()
        transactionViewModel.allTransaction.observe(viewLifecycleOwner, Observer {
            transactionRecycleAdapter = TransactionRecycleAdapter(it, activity)
            transaction_list_recycle_view.adapter = transactionRecycleAdapter
        })
    }
}