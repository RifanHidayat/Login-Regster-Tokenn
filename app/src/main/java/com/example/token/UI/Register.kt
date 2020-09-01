package com.example.token.UI

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.token.R
import com.example.token.UI.presenter.InterfacePresenter
import com.example.token.UI.presenter.MainPresenter
import com.example.token.view.MainView
import kotlinx.android.synthetic.main.activity_register.*

class Register : AppCompatActivity(),MainView {
    lateinit var presenter: InterfacePresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        presenter=MainPresenter(this)
        btnregister.setOnClickListener {
            val intent = Intent(applicationContext, Login::class.java)
            startActivity(intent)
            finish()
        }
        btnlogin.setOnClickListener {

            presenter.onRegister(edusername.text.toString(),edemail.text.toString(),edpasswor.text.toString())
        }
    }
    override fun pesan(message: String) {
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show()
    }

    override fun pindah() {


    }
}