package com.kyrie.proj.common.ui.tab

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import androidx.fragment.app.Fragment

/**
 * Created by Kyrie
 * Date: 2020/7/1
 * Fragment的操作内聚
 */
class HiFragmentTabView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {
    var hiTabViewAdapter: HiTabViewAdapter? = null
    var currPosition: Int = -1

    public fun setAdapter(hiTabViewAdapter: HiTabViewAdapter) {
        if (this.hiTabViewAdapter != null) {
            return
        }
        this.hiTabViewAdapter = hiTabViewAdapter
    }

    public fun setCurrentItem(position: Int) {
        hiTabViewAdapter?.let {
            if (position < 0 || position > it.getCount()) {
                return
            }
            it.instantiateItem(this, position)
        }
    }

    public fun getCurrentItem(): Int {
        return currPosition
    }

    public fun getCurrentFragment(): Fragment? {
        requireNotNull(hiTabViewAdapter) { "please call seaAdapter first" }
        return hiTabViewAdapter?.currFragment
    }
}