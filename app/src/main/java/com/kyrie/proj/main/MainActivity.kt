package com.kyrie.proj.main

import android.os.Bundle
import com.kyrie.proj.common.ui.component.BaseActivity

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
