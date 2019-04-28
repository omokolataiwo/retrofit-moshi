package com.tk.omokolataiwo.refersher.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.tk.omokolataiwo.refersher.R
import com.tk.omokolataiwo.refersher.data.api.BaseRetrofitModule
import com.tk.omokolataiwo.refersher.data.repository.OnlineStore
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MainActivity : AppCompatActivity() {
    private lateinit var tvTitle: TextView
    private val compositeDisposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tvTitle = findViewById(R.id.tv_title)
        val subscribe = RecordViewModel(OnlineStore(BaseRetrofitModule()))
            .getRecord()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                updateUI(it)
            }, {})
        compositeDisposable.add(subscribe)
    }

    fun updateUI(todo: Todo) {
       tvTitle.text = todo.title
    }
}
