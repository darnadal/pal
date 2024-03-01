package com.example.pal

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class ItemsAdapter(private val context: Context, private val items: List<ABCItem>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        const val TEXT_TYPE = 0
        const val IMAGE_TYPE = 1
        const val VIDEO_TYPE = 2
    }

    override fun getItemViewType(position: Int): Int {
        return when (items[position].abcData.type) {
            "text" -> TEXT_TYPE
            "image" -> IMAGE_TYPE
            "video" -> VIDEO_TYPE
            else -> throw IllegalArgumentException("Invalid type of data: ${items[position].abcData.type}")
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            TEXT_TYPE -> TextViewHolder(inflater.inflate(R.layout.item_text, parent, false))
            IMAGE_TYPE -> ImageViewHolder(inflater.inflate(R.layout.item_image, parent, false))
            VIDEO_TYPE -> VideoViewHolder(inflater.inflate(R.layout.item_video, parent, false))
            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = items[position].abcData
        when (holder) {
            is TextViewHolder -> {
                holder.textView.text = item.title
            }
            is ImageViewHolder -> {
                item.images?.let {
                    if (it.isNotEmpty()) {
                        Glide.with(context).load(it[0].url).into(holder.imageView)
                    }
                }
            }
            is VideoViewHolder -> {
                // Pour intégrer une vidéo YouTube, vous aurez besoin d'une vue spécifique ou d'une intégration via YouTube API.
                // Exemple : holder.videoContainer.setVideoURI(Uri.parse(item.videos))
            }
        }
    }

    override fun getItemCount(): Int = items.size

    class TextViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.textViewItem)
    }

    class ImageViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageView: ImageView = view.findViewById(R.id.imageViewItem)
    }

    class VideoViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val videoContainer: FrameLayout = view.findViewById(R.id.videoContainer)
    }
}
