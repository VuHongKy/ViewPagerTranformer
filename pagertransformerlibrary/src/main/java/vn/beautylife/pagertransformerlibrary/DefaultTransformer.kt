package vn.beautylife.pagertransformerlibrary

import android.view.View

/**
 * So so
 */
class DefaultTransformer : BaseTransformer() {

    override fun onTransform(page: View, position: Float) {}

    override fun isPagingEnabled() = true

}