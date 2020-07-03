package com.kyrie.proj.common.ui.tab

import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.wzt.ui.tab.bottom.HiTabBottomInfo

/**
 * Created by Kyrie
 * Date: 2020/7/1
 *
 */
class HiTabViewAdapter(
    private val mInfoList: MutableList<HiTabBottomInfo<*>>,
    private val mFragmentManager: FragmentManager
) {
    var currFragment : Fragment? = null

    fun instantiateItem(container: View, position: Int) {
        val transaction = mFragmentManager.beginTransaction()
        currFragment?.let {
            transaction.hide(it)
        }
        val tag = "${container.id}:${position}"
        var fragment = mFragmentManager.findFragmentByTag(tag)
        if (fragment != null) {
            transaction.show(fragment)
        } else {
            fragment = getItem(position)
            if (!fragment.isAdded) {
                transaction.add(container.id, fragment, tag)
            }
        }
        currFragment = fragment
        transaction.commitAllowingStateLoss()
    }

    private fun getItem(position: Int): Fragment {
        return mInfoList[position].fragment.newInstance()
    }

    fun getCount(): Int {
        return mInfoList.size
    }
}