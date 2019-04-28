package com.tk.omokolataiwo.refersher.data.api

import com.serjltt.moshi.adapters.DeserializeOnly
import com.serjltt.moshi.adapters.SerializeOnly
import com.serjltt.moshi.adapters.Wrapped
import com.squareup.moshi.Moshi
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit


open class BaseRetrofitModule {
    private val okHttpClient = OkHttpClient.Builder()
        .connectTimeout(60, TimeUnit.SECONDS)
        .build()
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://jsonplaceholder.typicode.com/")
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(MoshiConverterFactory.create(buildMoshiAdapter()))
        .client(okHttpClient)
        .build()

    private fun buildMoshiAdapter() = Moshi.Builder()
        .add(Wrapped.ADAPTER_FACTORY)
        .add(SerializeOnly.ADAPTER_FACTORY)
        .add(DeserializeOnly.ADAPTER_FACTORY)
        .build()

    fun getRetrofit() : Retrofit = retrofit
}