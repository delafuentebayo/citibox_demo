package com.jmdelafuente.citiboxdemo.activities.MainActivity

import android.content.Context
import android.provider.ContactsContract
import java.util.*
import javax.inject.Inject
import kotlin.collections.ArrayList

class MainPresenter
@Inject
constructor(): MainContract.Presenter{


    private lateinit var view: MainContract.View



    override fun attach(view: MainContract.View) {
        this.view = view

    }

}