package vn.beautylife.viewpagertransform

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_transformer_name.*

class TransformerNameAdapter(private val nameList: List<String>,
                             private var selectedPosition: Int) : RecyclerView.Adapter<TransformerNameAdapter.MyViewHolder>() {
    private var clickListener: ((Int) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(parent, clickListener)
    }

    override fun getItemCount() = nameList.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(nameList[position], selectedPosition)
    }

    fun setOnItemClickListener(listener: (Int) -> Unit) {
        clickListener = listener
    }

    fun selectItem(position: Int) {
        val oldSelectedPos = selectedPosition
        selectedPosition = position
        notifyItemChanged(oldSelectedPos)
        notifyItemChanged(selectedPosition)
    }

    class MyViewHolder private constructor(override val containerView: View?,
                                           clickListener: ((Int) -> Unit)? = null) : RecyclerView.ViewHolder(containerView), LayoutContainer {
        companion object {
            operator fun invoke(parent: ViewGroup, clickListener: ((Int) -> Unit)?) : MyViewHolder {
                val view = LayoutInflater.from(parent.context)
                        .inflate(R.layout.item_transformer_name, parent, false)
                return MyViewHolder(view, clickListener)
            }
        }

        init {
            clickListener?.let {
                containerView?.setOnClickListener { it(adapterPosition) }
            }
        }

        fun bind(transformerName: String, selectedPosition: Int) {
            lblTransformerName.run {
                isSelected = selectedPosition == adapterPosition
                text = transformerName.substringAfterLast(".")
            }
        }

    }

}