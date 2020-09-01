package com.example.token.UI.presenter

interface InterfacePresenter {
    fun onLogin(username:String,password: String)
    fun onRegister(username:String,email:String,password: String)
}