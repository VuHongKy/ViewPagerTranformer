package vn.beautylife.pagertransformerlibrary

import android.support.annotation.IdRes
import android.view.View

/**
 * Very beautiful
 */
class ParallaxPageTransformer(@IdRes private val viewToParallax: Int) : BaseTransformer() {

    override fun onTransform(page: View, position: Float) {
        when (position) {
            in -1f..1f -> {
                page.run {
                    findViewById<View>(viewToParallax).translationX = -position * width/2
                }
            }
            else -> page.alpha = 1f
        }
    }

    override fun isPagingEnabled() = true

}