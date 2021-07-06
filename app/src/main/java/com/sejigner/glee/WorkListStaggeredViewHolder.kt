package com.sejigner.glee

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.list_item_grid_work.view.*
import java.util.*

class WorkListStaggeredViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val mRandom = Random()
    fun bindView(workModel: WorkModel) {
        itemView.tv_writer_name.text = workModel.userName
        itemView.tv_count_like.text = workModel.likeCount.toString()
        Glide.with(itemView.context).load(workModel.workPicture!!).into(itemView.iv_work)
        Glide.with(itemView.context).load(workModel.userPicture!!).into(itemView.iv_writer_image)
    }
}