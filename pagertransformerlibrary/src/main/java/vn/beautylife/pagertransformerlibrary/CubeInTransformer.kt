package vn.beautylife.pagertransformerlibrary

import android.view.View

/**
 * ...building
 */
class CubeInTransformer : BaseTransformer() {

    override fun onTransform(page: View, position: Float) {
        page.run {
            // Rotate the fragment on the left or right edge
            pivotX = if (position > 0f) 0f else width.toFloat()
            pivotY = 0f
            rotationY = -90f * position
        }
    }

    override fun isPagingEnabled() = true

}