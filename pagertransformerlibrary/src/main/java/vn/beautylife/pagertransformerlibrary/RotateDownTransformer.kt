package vn.beautylife.pagertransformerlibrary

import android.view.View

/**
 * beautiful
 */
class RotateDownTransformer : BaseTransformer() {

    companion object {
        const val ROT_MOD = -15f
    }

    override fun onTransform(page: View, position: Float) {
        val rotation = ROT_MOD * position * (-1.25f)
        page.run {
            pivotX = 0.5f * width
            pivotY = height.toFloat()
            this.rotation = rotation
        }
    }

    override fun isPagingEnabled() = true

}