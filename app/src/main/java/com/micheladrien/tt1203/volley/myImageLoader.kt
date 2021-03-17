package com.micheladrien.tt1203.volley

import com.android.volley.toolbox.ImageLoader
import com.android.volley.toolbox.NetworkImageView

interface myImageLoader {
    //fun getImageLoader() : ImageLoader
    fun loadImage(imageHolder : NetworkImageView, url : String)
}