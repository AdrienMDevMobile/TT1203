package com.micheladrien.tt1203.volley

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Bitmap
import androidx.collection.LruCache
import com.android.volley.Cache
import com.android.volley.Network
import com.android.volley.RequestQueue
import com.android.volley.toolbox.*
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class ImageVolleyLoader @Inject constructor(private val requestQueue: RequestQueue) : myImageLoader {
    //@ApplicationContext private val context: Context,
    //private var requestQueue: RequestQueue?
    private val imageLoader: ImageLoader

    /*
    private fun getRequestQueue(): RequestQueue {
        if (requestQueue == null) {
            val cache: Cache = DiskBasedCache(context.cacheDir, 10 * 1024 * 1024)
            val network: Network = BasicNetwork(HurlStack())
            requestQueue = RequestQueue(cache, network)
            requestQueue!!.start()
        }
        return requestQueue!!
    }*/

    init {
        //requestQueue = getRequestQueue()
        imageLoader = ImageLoader(requestQueue,
                object : ImageLoader.ImageCache {
                    private val cache: LruCache<String, Bitmap> = LruCache<String, Bitmap>(20)
                    override fun getBitmap(url: String): Bitmap? {
                        return cache.get(url)
                    }

                    override fun putBitmap(url: String, bitmap: Bitmap) {
                        cache.put(url, bitmap)
                    }
                })
    }

    /*
    companion object {
        private var customVolleyRequest: ImageVolleyLoader? = null
        //private val context: Context


        fun getInstance(context: Context): ImageVolleyLoader? {
            if (customVolleyRequest == null) {
                customVolleyRequest = ImageVolleyLoader(context)
            }
            return customVolleyRequest
        }
    } */

    @SuppressLint("ResourceAsColor")
    override fun loadImage(imageHolder : NetworkImageView, url : String) {

        if (url == "") {
            //Toast.makeText(this, "Please enter a URL", Toast.LENGTH_LONG).show()
            imageHolder.setImageResource(android.R.drawable.ic_dialog_alert)
            return
        }
        //val imageLoader = context?.let { it1 -> ImageVolleyLoader.getInstance(it1)?.imageLoader }
        imageLoader.get(url, ImageLoader.getImageListener(imageHolder,
                android.R.drawable.ic_menu_report_image, android.R.drawable.ic_dialog_alert))
        imageHolder.setImageUrl(url, imageLoader)

    }
}