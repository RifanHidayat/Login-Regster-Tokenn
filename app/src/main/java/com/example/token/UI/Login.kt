package com.example.token.UI

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.token.R
import com.example.token.UI.presenter.InterfacePresenter
import com.example.token.UI.presenter.MainPresenter
import com.example.token.view.MainView
import kotlinx.android.synthetic.main.activity_login.*

class Login : AppCompatActivity() ,MainView{
    lateinit var presenter:InterfacePresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter=MainPresenter(this)
        setContentView(R.layout.activity_login)
        btnlogin.setOnClickListener {
            presenter.onLogin(edusername.text.toString(),edpassword.text.toString())
        }
         register.setOnClickListener {
             val intent = Intent(applicationContext, Register::class.java)
             startActivity(intent)
             finish()
         }
    }

    override fun pesan(message: String) {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show()
    }

    override fun pindah() {
        val intent = Intent(applicationContext, Home::class.java)
        startActivity(intent)
        finish()

    }
}