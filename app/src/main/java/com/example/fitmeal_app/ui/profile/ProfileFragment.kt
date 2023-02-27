package com.example.fitmeal_app.ui.profile

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.fitmeal_app.databinding.FragmentProfileBinding
import com.example.fitmeal_app.preferences.PrefManager
import com.example.fitmeal_app.ui.login.LoginActivity
import com.example.fitmeal_app.ui.login.LoginData

class ProfileFragment : Fragment(), ProfileView{

    private lateinit var binding: FragmentProfileBinding
    private lateinit var presenter: ProfilePresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        presenter = ProfilePresenter(this, PrefManager(requireContext()))
        return binding.root
    }

//    override fun onActivityCreated(savedInstanceState: Bundle?) {
//        super.onActivityCreated(savedInstanceState)
//
//    }

    override fun user(user: LoginData) {

        binding.textName.text = user.name
        binding.textEmail.text = user.email
    }

    override fun setupListener() {
        binding.buttonLogout.setOnClickListener{
            presenter.logout()
        }

    }

    override fun logout() {
        Toast.makeText(requireContext(),"keluar", Toast.LENGTH_LONG).show()
        startActivity(Intent(requireActivity(),LoginActivity::class.java))
        requireActivity().finish()
    }


}