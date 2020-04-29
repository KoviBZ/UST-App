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
import com.ustapp.utils.Constants

class CVAdapter(
    private val context: Context
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    lateinit var itemsList: List<Pair<String, String>>

    fun setItems(itemsList: List<Pair<String, String>>) {
        this.itemsList = itemsList
    }

    override fun getItemCount(): Int = itemsList.size

    override fun getItemViewType(position: Int): Int {
        return when (itemsList[position].first) {
            Constants.PHOTO_HEADER -> 0
            Constants.SECTION_HEADER -> 1
            Constants.SKILL_ROW -> 2
            else -> 3
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            0 -> AvatarViewHolder(inflateView(parent, viewType))
            1 -> SectionViewHolder(inflateView(parent, viewType))
            2 -> SkillRowViewHolder(inflateView(parent, viewType))
            else -> RowViewHolder(inflateView(parent, viewType))
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder.itemViewType) {
            0 -> {
                val viewHolder1 = holder as AvatarViewHolder
                viewHolder1.bind(itemsList[position])
            }
            1 -> {
                val viewHolder1 = holder as SectionViewHolder
                viewHolder1.bind(itemsList[position])
            }
            2 -> {
                val viewHolder2 = holder as SkillRowViewHolder
                viewHolder2.bind(itemsList[position])
            }
            else -> {
                val viewHolder3 = holder as RowViewHolder
                viewHolder3.bind(itemsList[position])
            }
        }
    }

    private fun inflateView(parent: ViewGroup, viewType: Int): View {
        val layoutRes: Int = when (viewType) {
            0 -> R.layout.view_avatar_holder
            1 -> R.layout.view_section_holder
            2 -> R.layout.view_skill_holder
            else -> R.layout.view_personal_data_row
        }

        return LayoutInflater.from(context).inflate(layoutRes, parent, false)
    }

    inner class AvatarViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private var avatarPhoto: ImageView = itemView.findViewById(R.id.avatar_photo)

        fun bind(userData: Pair<String, String>) {
            Glide.with(context)
                .load(userData.second)
                .placeholder(R.drawable.ic_launcher)
                .into(avatarPhoto)
        }
    }

    inner class SectionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private var header: TextView = itemView.findViewById<TextView>(R.id.section_header)

        fun bind(userData: Pair<String, String>) {
            header.text = userData.second
        }
    }

    inner class RowViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private var label: TextView = itemView.findViewById<TextView>(R.id.label)
        private var fieldValue: TextView = itemView.findViewById<TextView>(R.id.value_field)

        fun bind(userData: Pair<String, String>) {
            label.text = userData.first
            fieldValue.text = userData.second
        }
    }

    inner class SkillRowViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private var skillText: TextView = itemView.findViewById<TextView>(R.id.skill_text)

        fun bind(userData: Pair<String, String>) {
            skillText.text = String.format(context.getString(R.string.skill_row_text), userData.second)
        }
    }
}