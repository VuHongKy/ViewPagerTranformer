package vn.beautylife.pagertransformerlibrary

import android.view.View
import kotlin.math.abs

class ZoomOutTransformer : BaseTransformer() {

    override fun onTransform(page: View, position: Float) {
        val scaleFactor = 1f + abs(position)
        page.run {
            scaleX = scaleFactor
            scaleY = scaleFactor
            pivotX = 0.5f * width
            pivotY = 0.5f * height
            alpha = if (position < -1f || position > 1f) 0f else 1f - (scaleFactor - 1f)
            if (position == -1f) translationX = width * (-1f)
        }
    }

}