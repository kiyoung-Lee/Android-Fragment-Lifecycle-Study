package com.example.stickersampleapp.common

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import io.reactivex.disposables.CompositeDisposable
import org.jetbrains.anko.toast

open class BaseAppCompatActivity : AppCompatActivity(), BaseView {

    lateinit var disposable: CompositeDisposable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        disposable = CompositeDisposable()
    }

    override fun onStop() {
        super.onStop()
        disposable.clear()
    }

    override fun makeToast(message: String) {
        toast(message)
    }
}