package vn.beautylife.pagertransformerlibrary

import android.support.v4.view.ViewPager
import android.view.View

/**
 * Base of all transformer, if you want to use default transformer, call DefaultTransformer, not use this class
 */
abstract class BaseTransformer : ViewPager.PageTransformer {

    /**
     * Called each {@link #transformPage(android.view.View, float)}.
     *
     * @param page
     * @param position
     */
    protected abstract fun onTransform(page: View, position: Float)

    override fun transformPage(page: View, position: Float) {
        onPreTransform(page, position)
        onTransform(page, position)
        onPostTransform(page, position)
    }

    /**
     * Called each {@link #transformPage(android.view.View, float)} before {{@link #onTransform(android.view.View, float)} is called.
     *
     * @param page
     * @param position
     */
    open fun onPreTransform(page: View, position: Float) {
        page.run {
            rotationX = 0f
            rotationY = 0f
            rotation = 0f
            scaleX = 1f
            scaleY = 1f
            pivotX = 0f
            pivotY = 0f
            translationY = 0f
            translationX = if (isPagingEnabled()) 0f else -width * position
            alpha = if (!hideOffscreenPages() || (position > -1f && position < 1f)) 1f else 0f
        }
    }

    /**
     * Called each {@link #transformPage(android.view.View, float)} call after {@link #onTransform(android.view.View, float)} is finished.
     *
     * @param page
     * @param position
     */
    open fun onPostTransform(page: View, position: Float) {}

    /**
     * If the position offset of a fragment is less than negative one or greater than one, returning true will set the
     * visibility of the fragment to {@link android.view.View#GONE}. Returning false will force the fragment to {@link android.view.View#VISIBLE}.
     *
     * @return
     */
    open fun hideOffscreenPages() = true

    /**
     * Indicates if the default animations of the view pager should be used.
     *
     * @return
     */
    open fun isPagingEnabled() = false

}