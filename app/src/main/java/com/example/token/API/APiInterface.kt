package Cooky.rifanhdiyat.com.database


import com.example.token.model.Respon
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
import retrofit2.Call

interface APiInterface{
    @FormUrlEncoded
    @POST("login")
    fun login(
        @Field("username") username:String,
        @Field("password") password: String): Call<Respon>

    @FormUrlEncoded
    @POST("register")
    fun register(

        @Field("username") username:String,
        @Field("email") email:String,
        @Field("password") password: String): Call<Respon>


}