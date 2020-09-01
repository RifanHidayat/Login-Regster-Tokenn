package Cooky.rifanhdiyat.com.database


import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory





object RetrofitClient {
    private const val BASE_URL = "http://18.141.178.15:8080/"
    private var retrofit: Retrofit? = null
    fun getApiClient(): Retrofit? {
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return retrofit
    }
}