package com.example.bank_reboot.domain.user.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.bank_reboot.R
import kotlinx.android.synthetic.main.fragment_user_transfer_done.*
import kotlinx.android.synthetic.main.fragment_user_transfer_to.*


class UserTransferDoneFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_user_transfer_done, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        done_button_transfer_done.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_userTransferDoneFragment_pop)
        }
    }
}