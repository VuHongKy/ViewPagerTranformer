package vn.beautylife.pagertransformerlibrary

import android.view.View

/**
 * So so
 */
class FlipVerticalTransformer : BaseTransformer() {

    override fun onTransform(page: View, position: Float) {
        val rotation = -180f * position
        page.run {
            visibility = if (-90f <= rotation && rotation <= 90f) View.VISIBLE else View.INVISIBLE
            pivotX = width * 0.5f
            pivotY = height * 0.5f
            rotationX = rotation
        }
    }

}