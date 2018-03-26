package vn.beautylife.pagertransformerlibrary

import android.support.v4.view.ViewPager
import android.view.View

/**
 * Created by vuhon on 26-Mar-18.
 */
abstract class BaseTransformer : ViewPager.PageTransformer {

    protected abstract fun onTransform(page: View, position: Float)

    override fun transformPage(page: View, position: Float) {
        onPreTransform(page, position)
        onTransform(page, position)
        onPostTransform(page, position)
    }

    open fun onPreTransform(page: View, position: Float) {
        page.run {
            rotationX = 0f
            rotationY = 0f
            rotation = 0f
            scaleX = 1f
            scaleY = 1f
            pivotX = 0f
            pivotY = 0f
            translationY = 0f
            translationX = if (isPagingEnabled()) 0f else -width * position
            alpha = if (!hideOffscreenPages() || (position > -1f && position < 1f)) 1f else 0f
        }
    }

    open fun onPostTransform(page: View, position: Float) {}

    open fun hideOffscreenPages() = true

    open fun isPagingEnabled() = false

}