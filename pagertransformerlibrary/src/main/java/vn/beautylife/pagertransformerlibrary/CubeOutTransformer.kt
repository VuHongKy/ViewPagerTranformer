package vn.beautylife.pagertransformerlibrary

import android.view.View

/**
 * Very beautiful
 */
class CubeOutTransformer : BaseTransformer() {

    override fun onTransform(page: View, position: Float) {
        page.run {
            pivotX = if (position < 0f) width.toFloat() else 0f
            pivotY = 0.5f * height
            rotationY = 90f * position
        }
    }

    override fun isPagingEnabled() = true

}