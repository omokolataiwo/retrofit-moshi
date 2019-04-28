package com.tk.omokolataiwo.refersher.data.api

import com.tk.omokolataiwo.refersher.view.Todo
import retrofit2.http.*
import io.reactivex.Observable



interface ApiService {
    @GET("todos/1")
    fun getRecord(): Observable<Todo>
}
