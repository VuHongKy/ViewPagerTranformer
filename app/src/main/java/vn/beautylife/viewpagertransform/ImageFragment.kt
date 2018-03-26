package vn.beautylife.viewpagertransform

import android.os.Bundle
import android.support.annotation.DrawableRes
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.fragment_image.*

class ImageFragment : Fragment() {
    private var imageResId: Int? = null

    companion object {
        private const val ARG_IMAGE_URI = "image_uri"

        operator fun invoke(@DrawableRes imageUri: Int) = ImageFragment().apply {
            arguments = Bundle().apply {
                putInt(ARG_IMAGE_URI, imageUri)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        imageResId = arguments?.getInt(ARG_IMAGE_URI)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_image, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Glide.with(this)
                .load(imageResId)
                .apply(RequestOptions.fitCenterTransform())
                .into(image)
    }
}