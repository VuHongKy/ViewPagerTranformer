package vn.beautylife.pagertransformerlibrary

import android.view.View

/**
 * Very beautiful
 */
class StackTransformer : BaseTransformer() {

    override fun onTransform(page: View, position: Float) {
        page.run { translationX = if (position < 0f) 0f else -width * position }
    }

}