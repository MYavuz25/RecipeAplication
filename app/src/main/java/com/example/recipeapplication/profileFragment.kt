package com.example.recipeapplication

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.recipeapplication.databinding.FragmentProfileBinding
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

class profileFragment : Fragment() {
    private lateinit var binding: FragmentProfileBinding
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?


    ): View? {
        binding=FragmentProfileBinding.inflate(inflater,container,false)
        return binding.root



    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        auth=Firebase.auth
        val currentUser=auth.currentUser
        if (currentUser!=null){
            binding.hesapAcilmamisGorunum.visibility=View.GONE
            binding.girisYaptKtanSonrakiGoruntu.visibility=View.VISIBLE
        }
        binding.girisYapUyeOlbutonu.setOnClickListener {
            val intent=Intent(context,loginActivity::class.java)
            startActivity(intent)
        }
        binding.singOutButton.setOnClickListener {
            auth.signOut()
            binding.hesapAcilmamisGorunum.visibility=View.VISIBLE
            binding.girisYaptKtanSonrakiGoruntu.visibility=View.GONE
        }


    }



}