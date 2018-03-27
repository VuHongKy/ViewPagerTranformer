package vn.beautylife.pagertransformerlibrary

import android.view.View

/**
 * beautiful
 */
class RotateUpTransformer : BaseTransformer() {

    companion object {
        const val ROT_MOD = -15f
    }

    override fun onTransform(page: View, position: Float) {
        val rotation = ROT_MOD * position
        page.run {
            pivotX = 0.5f * width
            pivotY = 0f
            translationX = 0f
            this.rotation = rotation
        }
    }

    override fun isPagingEnabled() = true

}