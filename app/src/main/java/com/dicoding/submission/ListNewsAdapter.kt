package com.dicoding.submission

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class ListNewsAdapter(private val listNews: ArrayList<News>) : RecyclerView.Adapter<ListNewsAdapter.ListViewHolder>() {

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        var tvDetail: TextView = itemView.findViewById(R.id.tv_item_detail)
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_row_news, viewGroup, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val news = listNews[position]

        Glide.with(holder.itemView.context)
            .load(news.photo)
            .apply(RequestOptions())
            .into(holder.imgPhoto)

        holder.tvName.text = news.name
        holder.tvDetail.text = news.detail

        val mContent = holder.itemView.context

        holder.itemView.setOnClickListener {
            val moveDetail = Intent(mContent, Detail::class.java)
            moveDetail.putExtra(Detail.EXTRA_NAME, news.name)
            moveDetail.putExtra(Detail.EXTRA_PHOTO, news.photo)
            moveDetail.putExtra(Detail.EXTRA_CONTENT, news.detail)
            mContent.startActivity(moveDetail)
        }
    }

    override fun getItemCount(): Int {
        return listNews.size
    }
}