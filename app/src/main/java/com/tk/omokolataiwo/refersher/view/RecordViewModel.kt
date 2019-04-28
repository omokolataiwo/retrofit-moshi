package com.tk.omokolataiwo.refersher.view

import com.tk.omokolataiwo.refersher.data.repository.OnlineStore
import io.reactivex.Observable

class RecordViewModel(private val onlineStore: OnlineStore) {

    fun getRecord(): Observable<Todo> = onlineStore
        .getRecord()
        .flatMap {
            Observable.just(it)
        }
        .onErrorResumeNext { throwable: Throwable -> Observable.error(handleError(throwable)) }

    val handleError = { exception: Throwable ->
        Exception(exception)
    }

}