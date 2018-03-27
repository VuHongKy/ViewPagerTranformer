package vn.beautylife.pagertransformerlibrary

import android.view.View
import kotlin.math.abs
import kotlin.math.max

/**
 * So so
 */
class ForegroundToBackgroundTransformer : BaseTransformer() {

    override fun onTransform(page: View, position: Float) {
        val scaleFactor = max(if (position > 0f) 1f else abs(1f + position), 0.5f)
        val width = page.width
        val height = page.height
        page.run {
            scaleX = scaleFactor
            scaleY = scaleFactor
            pivotX = 0.5f * width
            pivotY = 0.5f * height
            translationX = if (position > 0f) width * position else -width * position * 0.25f
        }
    }

}