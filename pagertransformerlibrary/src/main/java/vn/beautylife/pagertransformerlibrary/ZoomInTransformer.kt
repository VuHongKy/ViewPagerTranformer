package vn.beautylife.pagertransformerlibrary

import android.view.View
import kotlin.math.abs

/**
 * beautiful
 */
class ZoomInTransformer : BaseTransformer() {

    override fun onTransform(page: View, position: Float) {
        val scaleFactor = if (position < 0f) 1f + position else abs(1f - position)
        page.run {
            scaleX = scaleFactor
            scaleY = scaleFactor
            pivotX = width * 0.5f
            pivotY = height * 0.5f
            alpha = if (position < -1f || position > 1f) 0f else 1f - (scaleFactor - 1f)
        }
    }

}