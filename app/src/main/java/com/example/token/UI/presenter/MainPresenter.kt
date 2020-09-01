package com.example.token.UI.presenter

import Cooky.rifanhdiyat.com.database.APiInterface
import Cooky.rifanhdiyat.com.database.RetrofitClient
import com.example.token.model.Respon
import com.example.token.view.MainView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainPresenter(private  val  mainView: MainView):InterfacePresenter{
    override fun onLogin(username: String, password: String) {
        when{
            username.isEmpty()->{
                mainView.pesan("username anda kosong")
            }
            password.isEmpty()->{
                mainView.pesan("password anda kosong")
            }
            else-> login(username,password)
        }

    }
    private fun  login(username: String, password: String){

        val api= RetrofitClient.getApiClient()?.create(APiInterface::class.java)
        val request= api?.login(username,password)
        request?.enqueue(object : Callback<Respon> {
            override fun onFailure(call: Call<Respon>, t: Throwable) {

                mainView.pesan("koneksi bermasalah $t")


            }

            override fun onResponse(call: Call<Respon>, response: Response<Respon>) {

                val sukses=response.body()?.statusCode
                val msg=response.body()?.message

                if (sukses=="200"){
                    mainView.pesan(msg+"")
                    mainView.pindah()
                }else{
                    mainView.pesan(msg+"")

                }

            }
        })



    }

    override fun onRegister(username: String, email: String, password: String) {

        when{
            username.isEmpty()->{
                mainView.pesan("username anda kosong")
            }
            email.isEmpty()->{
                mainView.pesan("email anda kosong")
            }
            password.isEmpty()->{
                mainView.pesan("password anda kosong")
            }
            else-> register(username,email,password)
        }
    }
        fun register(username: String,email: String,password: String){

            val api= RetrofitClient.getApiClient()?.create(APiInterface::class.java)
            val request= api?.register(username,email,password)
            request?.enqueue(object : Callback<Respon> {
                override fun onFailure(call: Call<Respon>, t: Throwable) {
                    mainView.pesan("koneksi bermasalah $t")
                }

                override fun onResponse(call: Call<Respon>, response: Response<Respon>) {

                    val sukses=response.body()?.statusCode
                    val msg=response.body()?.message

                    if (sukses=="200"){
                        mainView.pesan(msg+"")
                        mainView.pindah()
                    }else{
                        mainView.pesan(msg+"")

                    }

                }
            })

        }


}