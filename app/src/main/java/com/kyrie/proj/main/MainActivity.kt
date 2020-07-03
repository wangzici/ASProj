package com.kyrie.proj.main

import android.os.Bundle
import com.kyrie.proj.common.ui.component.BaseActivity
import com.kyrie.proj.main.logic.MainActivityLogic

class MainActivity : BaseActivity(), MainActivityLogic.ActivityProvider {
    var activityLogic: MainActivityLogic? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        activityLogic = MainActivityLogic(this)
    }
}
