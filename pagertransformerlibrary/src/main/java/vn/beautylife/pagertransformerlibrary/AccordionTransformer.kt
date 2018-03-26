package vn.beautylife.pagertransformerlibrary

import android.view.View

/**
 * Created by vuhon on 26-Mar-18.
 */
class AccordionTransformer : BaseTransformer() {

    override fun onTransform(page: View, position: Float) {
        page.run {
            pivotX = if (position < 0f) 0f else width.toFloat()
            scaleX = if (position < 0f) 1f + position else 1f - position
        }
    }

}