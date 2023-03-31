package com.example.fitmeal_app.ui.resep

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.example.fitmeal_app.databinding.AdapterCategoryBinding

class CategoryAdapter (
    var categories: ArrayList<CategoryData>,
    var listener: OnAdapterListener?,
        ): RecyclerView.Adapter<CategoryAdapter.ViewHolder>()
{

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(AdapterCategoryBinding.inflate(
        LayoutInflater.from(parent.context), parent, false))


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val category = categories[position]
        holder.binding.textCategory.text = category.name
        holder.itemView.setOnClickListener{
            listener?.onClick(category)
        }
    }

    override fun getItemCount() = categories.size

    class ViewHolder(val binding: AdapterCategoryBinding): RecyclerView.ViewHolder(binding.root)

    interface OnAdapterListener{
        fun onClick(category: CategoryData)
    }
}