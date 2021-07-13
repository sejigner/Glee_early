package com.sejigner.glee

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import kotlinx.android.synthetic.main.list_item_grid_work.view.*
import java.util.*

class WorkListStaggeredViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bindView(workModel: WorkModel) {
        itemView.tv_writer_name.text = workModel.userName
        itemView.tv_count_like.text = workModel.likeCount.toString()
        GlideApp.with(itemView.context).load(workModel.workPicture!!).into(itemView.iv_work)
        GlideApp.with(itemView.context).load(workModel.userPicture!!).into(itemView.iv_writer_image)
        GlideApp.with(itemView.context).load(workModel.likeIcon!!).into(itemView.iv_like)
    }
}