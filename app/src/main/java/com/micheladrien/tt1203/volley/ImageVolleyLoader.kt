package com.micheladrien.tt1203.volley

import android.content.Context
import android.graphics.Bitmap
import androidx.collection.LruCache
import com.android.volley.Cache
import com.android.volley.Network
import com.android.volley.RequestQueue
import com.android.volley.toolbox.BasicNetwork
import com.android.volley.toolbox.DiskBasedCache
import com.android.volley.toolbox.HurlStack
import com.android.volley.toolbox.ImageLoader
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class ImageVolleyLoader @Inject constructor(private val requestQueue: RequestQueue) : myImageLoader {
    //@ApplicationContext private val context: Context,
    //private var requestQueue: RequestQueue?
    private val imageLoader: ImageLoader

    override fun getImageLoader(): ImageLoader {
        return imageLoader
    }

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
}