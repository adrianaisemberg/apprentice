package com.adrianaisemberg.apprentice.recycler_view

import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.RecyclerView
import com.adrianaisemberg.apprentice.utils.activity
import com.adrianaisemberg.apprentice.utils.layoutInflater

/**
 * a generic recycler adapter that encapsulates data-binding of view-holders
 *
 * @param TViewHolder the type of the view-holder
 * @param TItemBinding the type of the data-binding object
 * @property layoutId the view layout id
 */
abstract class ItemsRecyclerAdapter<
        TViewHolder : RecyclerView.ViewHolder,
        TItemBinding : ViewDataBinding>(@LayoutRes private val layoutId: Int) :
    RecyclerView.Adapter<TViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TViewHolder {
        val binding = DataBindingUtil.inflate<TItemBinding>(
            parent.context.layoutInflater(),
            layoutId,
            parent,
            false
        ).apply {
            lifecycleOwner = this.root.activity() as LifecycleOwner
        }
        return createViewHolder(binding)
    }

    protected abstract fun createViewHolder(binding: TItemBinding): TViewHolder
}
