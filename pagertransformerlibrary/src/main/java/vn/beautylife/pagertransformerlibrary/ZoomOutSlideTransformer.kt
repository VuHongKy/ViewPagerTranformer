package vn.beautylife.pagertransformerlibrary

import android.view.View
import kotlin.math.abs
import kotlin.math.max

class ZoomOutSlideTransformer(private val fadeAnimation: Boolean = false) : BaseTransformer() {
    companion object {
        const val MIN_SCALE = 0.85f
        const val MIN_ALPHA = 0.5f
    }

    override fun onTransform(page: View, position: Float) {
        when {
            // This page is way off-screen to the left
            position < -1f -> page.alpha = 0f
            position <= 1f -> {
                val scaleFactor = max(MIN_SCALE, 1 - abs(position))
                val vertMargin = page.height * (1 - scaleFactor) / 2
                val horzMargin = page.width * (1 - scaleFactor) / 2
                page.run {
                    pivotY = 0.5f * height

                    // Modify the default slide transition to shrink the page as well
                    translationX = if (position < 0) horzMargin - vertMargin / 2 else vertMargin - horzMargin / 2

                    // Scale the page down (between MIN_SCALE and 1) (SCALE)
                    scaleX = scaleFactor
                    scaleY = scaleFactor

                    // Fade the page relative to its size (ALPHA)
                    alpha = if (fadeAnimation) MIN_ALPHA + (scaleFactor - MIN_SCALE) / (1 - MIN_SCALE) * (1 - MIN_ALPHA) else 1f
                }
            }
            // This page is way off-screen to the right (position > 1)
            else -> page.alpha = 0f
        }
    }

}