package vn.beautylife.viewpagertransform

import android.support.annotation.DrawableRes
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_image.*

class ImageListAdapter(private val imageList: List<Int>): RecyclerView.Adapter<ImageListAdapter.MyViewHolder>() {
    private var clickListener: ((Int) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(parent, clickListener)
    }

    override fun getItemCount() = imageList.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(imageList[position])
    }

    fun setOnItemClickListener(listener: (Int) -> Unit) {
        clickListener = listener
    }

    class MyViewHolder private constructor(override val  containerView: View?,
                                           clickListener: ((Int) -> Unit)? = null) : RecyclerView.ViewHolder(containerView), LayoutContainer {
        companion object {
            operator fun invoke(parent: ViewGroup, clickListener: ((Int) -> Unit)?): MyViewHolder {
                val view = LayoutInflater.from(parent.context)
                        .inflate(R.layout.item_image, parent, false)
                return MyViewHolder(view, clickListener)
            }
        }

        init {
            clickListener?.let {
                containerView?.setOnClickListener { it(adapterPosition) }
            }
        }

        fun bind(@DrawableRes imageResId: Int) {
            Glide.with(image)
                    .load(imageResId)
                    .apply(RequestOptions.centerCropTransform())
                    .into(image)
        }
    }

}