package com.example.pal

import android.view.View
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TextViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val textView: TextView = view.findViewById(R.id.textViewItem)
}

class ImageViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val imageView: ImageView = view.findViewById(R.id.imageViewItem)
}

class VideoViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val videoContainer: FrameLayout = view.findViewById(R.id.videoContainer)
}