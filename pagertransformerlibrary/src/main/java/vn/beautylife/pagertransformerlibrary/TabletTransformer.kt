package vn.beautylife.pagertransformerlibrary

import android.graphics.Camera
import android.graphics.Matrix
import android.view.View
import kotlin.math.abs

/**
 * beautiful
 */
class TabletTransformer : BaseTransformer() {
    private val OFFSET_MATRIX = Matrix()
    private val OFFSET_CAMERA = Camera()
    private val OFFSET_TEMP = floatArrayOf(0f, 0f)

    override fun onTransform(page: View, position: Float) {
        val rotation = (if (position < 0f) 30f else -30f) * abs(position)
        page.run {
            translationX = getOffsetXForRotation(rotation, width, height)
            pivotX = 0.5f * width
            pivotY = 0f
            rotationY = rotation
        }
    }

    private fun getOffsetXForRotation(degrees: Float, width: Int, height: Int): Float {
        OFFSET_MATRIX.reset()
        OFFSET_CAMERA.run {
            save()
            rotateY(abs(degrees))
            getMatrix(OFFSET_MATRIX)
            restore()
        }
        OFFSET_MATRIX.run {
            preTranslate(-0.5f * width, -0.5f * height)
            postTranslate(0.5f * width, 0.5f * height)
            OFFSET_TEMP[0] = width.toFloat()
            OFFSET_TEMP[1] = height.toFloat()
            mapPoints(OFFSET_TEMP)
        }
        return (width - OFFSET_TEMP[0]) * (if (degrees > 0f) 1f else -1f)
    }

}