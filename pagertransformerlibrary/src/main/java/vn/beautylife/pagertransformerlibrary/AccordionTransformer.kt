package vn.beautylife.pagertransformerlibrary

import android.view.View

/**
 * beautiful
 */
class AccordionTransformer : BaseTransformer() {

    override fun onTransform(page: View, position: Float) {
        page.run {
            pivotX = if (position < 0f) 0f else width.toFloat()
            scaleX = if (position < 0f) 1f + position else 1f - position
        }
    }

}