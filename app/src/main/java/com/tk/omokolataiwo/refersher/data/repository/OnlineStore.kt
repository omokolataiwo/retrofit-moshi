package com.tk.omokolataiwo.refersher.data.repository

import android.util.Log
import com.tk.omokolataiwo.refersher.data.api.ApiService
import com.tk.omokolataiwo.refersher.data.api.BaseRetrofitModule
import com.tk.omokolataiwo.refersher.view.Todo
import io.reactivex.Observable

class OnlineStore(retrofitModule: BaseRetrofitModule) {
    private val retrofit = retrofitModule.getRetrofit()
   private val apiService = retrofit.create(ApiService::class.java)

    fun getRecord(): Observable<Todo> {
        return apiService.getRecord()
    }
}