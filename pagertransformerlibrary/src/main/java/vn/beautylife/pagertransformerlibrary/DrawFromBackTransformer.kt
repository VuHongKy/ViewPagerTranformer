package vn.beautylife.pagertransformerlibrary

import android.view.View
import kotlin.math.abs
import kotlin.math.min

/**
 * So so
 */
class DrawFromBackTransformer : BaseTransformer() {
    companion object {
        const val MIN_SCALE = 0.75f
    }

    override fun onTransform(page: View, position: Float) {
        when (position) {
            in -1f..0f -> {
                val scaleFactor = MIN_SCALE + (1f - MIN_SCALE) * (1f - abs(position))
                page.run {
                    alpha = 1f + position
                    translationX = width * (-position)
                    scaleX = scaleFactor
                    scaleY = scaleFactor
                }
            }
            in 0f..0.3f -> {
                val scaleFactor = MIN_SCALE + min(0.3f - position, 1f - MIN_SCALE)
                page.run {
                    alpha = 1f
                    translationX = width * position
                    scaleX = scaleFactor
                    scaleY = scaleFactor
                }
            }
            in 0.3f..0.5f -> {
                page.run {
                    alpha = 1f
                    translationX = width * position
                    scaleX = MIN_SCALE
                    scaleY = MIN_SCALE
                }
            }
            in 0.5f..1f -> {
                page.run {
                    alpha = 0f
                    translationX = width * (-position)
                }
            }
            else -> page.alpha = 0f
        }
    }

}