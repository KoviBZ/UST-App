package com.ustapp.views

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ustapp.R
import com.ustapp.network.dto.BaseUserData
import com.ustapp.network.dto.UserPersonalData
import org.w3c.dom.Text

class CVAdapter(
    private val context: Context
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    lateinit var itemsList: List<Pair<String, String>>

    fun setItems(itemsList: List<Pair<String, String>>) {
        this.itemsList = itemsList
    }

    override fun getItemCount(): Int = itemsList.size

    override fun getItemViewType(position: Int): Int {
        return if (itemsList[position].first == "Header") {
            0
        } else {
            1
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            0 -> SectionViewHolder(inflateView(parent, viewType))
            else -> RowViewHolder(inflateView(parent, viewType))
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder.itemViewType) {
            0 -> {
                val viewHolder0 = holder as SectionViewHolder
                viewHolder0.bind(itemsList[position])
            }
            1 -> {
                val viewHolder1 = holder as RowViewHolder
                viewHolder1.bind(itemsList[position])
            }
        }
    }

    private fun inflateView(parent: ViewGroup, viewType: Int): View {
        return when (viewType) {
            0 -> LayoutInflater.from(context).inflate(R.layout.view_section_holder, parent, false)
            else -> LayoutInflater.from(context)
                .inflate(R.layout.view_personal_data_row, parent, false)
        }
    }

    inner class AvatarViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private var avatarPhoto: ImageView = itemView.findViewById(R.id.avatar_photo)

        fun bind(userData: BaseUserData) { //TODO change
            (userData as? UserPersonalData)?.apply {
                avatarPhoto.setImageResource(R.drawable.ic_launcher)
//                Glide.with(context).load(this.avatarUrl).into(avatarPhoto)
            }
        }
    }

    inner class SectionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private var header: TextView = itemView.findViewById<TextView>(R.id.section_header)

        fun bind(userData: Pair<String, String>) { //TODO change
            header.text = userData.second
        }
    }

    inner class RowViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private var label: TextView = itemView.findViewById<TextView>(R.id.label)
        private var field_value: TextView = itemView.findViewById<TextView>(R.id.value_field)

        fun bind(userData: Pair<String, String>) { //TODO change
            label.text = userData.first
            field_value.text = userData.second
        }
    }
}