package vn.beautylife.viewpagertransform

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter

class ImagePagerAdapter(fm: FragmentManager, private val imgList: List<Int>) : FragmentStatePagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return ImageFragment(imgList[position])
    }

    override fun getCount() = imgList.size

}