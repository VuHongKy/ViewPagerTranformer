package vn.beautylife.pagertransformerlibrary

import android.view.View

/**
 * Created by vuhon on 26-Mar-18.
 */
class DefaultTransformer : BaseTransformer() {

    override fun onTransform(page: View, position: Float) {}

    override fun isPagingEnabled() = true

}