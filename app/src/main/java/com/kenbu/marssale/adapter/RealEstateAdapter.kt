package com.kenbu.marssale.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.kenbu.marssale.R
import com.kenbu.marssale.model.RealEstateModel

/**
 * Adapter For Catalog RecyclerView
 *
 * @property estateModel
 */
class RealEstateAdapter(private val estateModel: ArrayList<RealEstateModel>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val estateBinding = DataBindingUtil.inflate<ViewDataBinding>(
            LayoutInflater.from(parent.context), R.layout.item_layout, parent, false
        )
        return AdapterViewHolder(estateBinding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as AdapterViewHolder).onBind(estateModel[position])
    }

    override fun getItemCount(): Int {
        return estateModel.size
    }
}