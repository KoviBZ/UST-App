package com.ustapp.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ustapp.R
import com.ustapp.network.dto.UserData

class MainActivity : AppCompatActivity(), MainView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onProfileLoadedSuccess(userData: UserData) {
        TODO("Not yet implemented")
    }

    override fun onProfileLoadedFailure(throwable: Throwable) {
        TODO("Not yet implemented")
    }
}
