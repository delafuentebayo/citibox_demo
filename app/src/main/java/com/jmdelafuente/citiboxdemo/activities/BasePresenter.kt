package com.jmdelafuente.citiboxdemo.activities

interface BasePresenter<in T> {
    fun attach(view: T)
}