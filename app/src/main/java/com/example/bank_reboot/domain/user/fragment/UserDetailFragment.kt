package com.example.bank_reboot.domain.user.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.bank_reboot.R
import com.example.bank_reboot.domain.user.view_model.UserViewModel
import kotlinx.android.synthetic.main.fragment_user_detail.*


class UserDetailFragment : Fragment() {

    private val userViewModel by activityViewModels<UserViewModel>()
    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_user_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        userViewModel.getUserByID(1)
        userViewModel.user.observe(viewLifecycleOwner, Observer {
            balance_user_datail.text = it.balance.toString()
        })
        navController = Navigation.findNavController(view)
        history_button.setOnClickListener{
            Navigation.findNavController(view).navigate(R.id.action_userDetailFragment_to_userTransactionHistoryFragment)
        }
        transfer_to_button.setOnClickListener{
            Navigation.findNavController(view).navigate(R.id.action_userDetailFragment_to_userTransferToFragment)
        }
    }
}