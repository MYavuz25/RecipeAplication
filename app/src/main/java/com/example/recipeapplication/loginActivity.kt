package com.example.recipeapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.recipeapplication.databinding.ActivityLoginBinding
import com.google.common.base.MoreObjects.ToStringHelper
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

class loginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        auth=Firebase.auth


    }
    fun girisYap(view: View){
        //giris yapma kodları
        val email=binding.emailEditText.text.toString()
        val password=binding.passwordEditText.text.toString()
        if (email.isNotEmpty()&&password.isNotEmpty()){
            auth.signInWithEmailAndPassword(email,password).addOnSuccessListener {
                //Success

                val intent=Intent(this@loginActivity,MainActivity::class.java)
                startActivity(intent)
                finish()
            }.addOnFailureListener {
                //Fail
                Toast.makeText(this@loginActivity,it.localizedMessage,Toast.LENGTH_LONG).show()
            }
        }else{
            Toast.makeText(this@loginActivity,"Enter an E-mail and password!",Toast.LENGTH_LONG).show()
        }


    }
    fun uyeOl(view: View){
        //üye olma işlemleri yapılacak

        val email=binding.emailEditText.text.toString()
        val password=binding.passwordEditText.text.toString()

        if (email.isNotEmpty()&& password.isNotEmpty()){
            auth.createUserWithEmailAndPassword(email,password).addOnSuccessListener {
                //success
                val intent=Intent(this,MainActivity::class.java)
                startActivity(intent)
                finish()
            }.addOnFailureListener {
                //Fail
                Toast.makeText(this@loginActivity,it.localizedMessage,Toast.LENGTH_LONG).show()
            }
        }else{
            Toast.makeText(this@loginActivity,"Enter an E-mail and password!",Toast.LENGTH_LONG).show()
        }


    }
}