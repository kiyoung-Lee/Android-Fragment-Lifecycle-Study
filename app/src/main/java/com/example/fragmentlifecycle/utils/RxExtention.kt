package com.example.stickersampleapp.utils

import io.reactivex.Maybe
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

fun Disposable.disposeIn(disposable: CompositeDisposable) {
    disposable.add(this)
}

fun <R> Single<R>.subscribeOnIoThread(): Single<R> {
    return this
        .compose { upstream ->
            upstream.subscribeOn(Schedulers.io())
        }
}

fun <R> Single<R>.observeOnMainThread(): Single<R> {
    return this
        .compose { upstream ->
            upstream.observeOn(AndroidSchedulers.mainThread())
        }
}

fun <R> Maybe<R>.subscribeOnIoThread(): Maybe<R> {
    return this
        .compose { upstream ->
            upstream.subscribeOn(Schedulers.io())
        }
}

fun <R> Maybe<R>.observeOnMainThread(): Maybe<R> {
    return this
        .compose { upstream ->
            upstream.observeOn(AndroidSchedulers.mainThread())
        }
}

fun <R> Observable<R>.subscribeOnIoThread(): Observable<R> {
    return this
        .compose { upstream ->
            upstream.subscribeOn(Schedulers.io())
        }
}

fun <R> Observable<R>.observeOnMainThread(): Observable<R> {
    return this
        .compose { upstream ->
            upstream.observeOn(AndroidSchedulers.mainThread())
        }
}