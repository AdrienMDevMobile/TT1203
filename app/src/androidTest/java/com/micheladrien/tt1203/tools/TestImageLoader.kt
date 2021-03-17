package com.micheladrien.tt1203.tools

import com.android.volley.toolbox.NetworkImageView
import com.micheladrien.tt1203.volley.myImageLoader
import javax.inject.Inject

class TestImageLoader @Inject constructor() : myImageLoader {
    override fun loadImage(imageHolder: NetworkImageView, url: String) {
        imageHolder.setImageResource(android.R.drawable.ic_media_play)
    }
}