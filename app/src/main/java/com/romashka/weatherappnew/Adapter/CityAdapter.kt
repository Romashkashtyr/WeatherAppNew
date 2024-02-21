package com.romashka.weatherappnew.Adapter

import android.content.Intent
import android.icu.util.Calendar
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.romashka.weatherappnew.Activity.MainActivity
import com.romashka.weatherappnew.databinding.CityViewholderBinding
import com.romashka.weatherappnew.databinding.ForecastViewholderBinding
import com.romashka.weatherappnew.model.CityResponseApi
import com.romashka.weatherappnew.model.ForecastResponseApi
import java.text.SimpleDateFormat

class CityAdapter: RecyclerView.Adapter<CityAdapter.ViewHolder>() {
    private lateinit var binding: CityViewholderBinding





    inner class ViewHolder: RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityAdapter.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        binding = CityViewholderBinding.inflate(inflater, parent, false)
        return ViewHolder()
    }

    override fun getItemCount() = differ.currentList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val binding = CityViewholderBinding.bind(holder.itemView)
        binding.cityTxt.text = differ.currentList[position].name
        binding.root.setOnClickListener {
            val intent = Intent(binding.root.context, MainActivity::class.java)
            intent.putExtra("lat", differ.currentList[position].lat)
            intent.putExtra("lng", differ.currentList[position].lon)
            intent.putExtra("name", differ.currentList[position].name)
            binding.root.context.startActivity(intent)
        }

    }

    private val differCallback =
        object : DiffUtil.ItemCallback<CityResponseApi.CityResponseApiItem>(){
            override fun areItemsTheSame(
                oldItem: CityResponseApi.CityResponseApiItem,
                newItem: CityResponseApi.CityResponseApiItem
            ): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(
                oldItem: CityResponseApi.CityResponseApiItem,
                newItem: CityResponseApi.CityResponseApiItem
            ): Boolean {
                return oldItem == newItem
            }

        }

    val differ = AsyncListDiffer(this, differCallback)
}