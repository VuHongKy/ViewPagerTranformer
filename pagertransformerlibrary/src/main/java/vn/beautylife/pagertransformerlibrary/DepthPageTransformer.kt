package vn.beautylife.pagertransformerlibrary

import android.view.View
import kotlin.math.abs

/**
 * beautiful
 */
class DepthPageTransformer(private val fadeAnimation: Boolean = false) : BaseTransformer() {
    companion object {
        const val MIN_SCALE = 0.75f
    }

    override fun onTransform(page: View, position: Float) {
        when {
            // This page is way off-screen to the left
            position < -1f -> page.alpha = 0f
            position <= 0f -> {
                // Use the default slide transition when moving to the left page
                page.run {
                    alpha = 1f
                    translationX = 0f
                    scaleX = 1f
                    scaleY = 1f
                }
            }
            position <= 1f -> {
                val scaleFactor = MIN_SCALE + (1 - MIN_SCALE) * (1 - abs(position))
                page.run {
                    alpha = if (fadeAnimation) 1f - position else 1f // Fade the page out
                    pivotY = 0.5f * height // use it if you want next page zoomed from central of screen
                    translationX = width * (-position) // Counteract the default slide transition
                    scaleX = scaleFactor // Scale the page down (between MIN_SCALE and 1)
                    scaleY = scaleFactor
                }
            }
            // This page is way off-screen to the right (position > 1)
            else -> page.alpha = 0f
        }
    }

    override fun isPagingEnabled() = true

}