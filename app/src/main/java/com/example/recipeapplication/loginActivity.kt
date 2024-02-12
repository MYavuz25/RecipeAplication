package com.example.recipeapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.recipeapplication.databinding.ActivityLoginBinding

class loginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)



    }
    fun girisYap(view: View){
        //giris yapma kodları
        Toast.makeText(this,"giriş Yap",Toast.LENGTH_LONG).show()
    }
    fun uyeOl(view: View){
        //üye olma işlemleri yapılacak
        Toast.makeText(this,"uye ol",Toast.LENGTH_LONG).show()

    }
}