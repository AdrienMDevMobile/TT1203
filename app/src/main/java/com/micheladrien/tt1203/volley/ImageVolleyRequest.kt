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

class ImageVolleyRequest private constructor(private val context: Context) {
    private var requestQueue: RequestQueue?
    val imageLoader: ImageLoader

    fun getRequestQueue(): RequestQueue {
        if (requestQueue == null) {
            val cache: Cache = DiskBasedCache(context.cacheDir, 10 * 1024 * 1024)
            val network: Network = BasicNetwork(HurlStack())
            requestQueue = RequestQueue(cache, network)
            requestQueue!!.start()
        }
        return requestQueue!!
    }

    companion object {
        private var customVolleyRequest: ImageVolleyRequest? = null
        //private val context: Context

        @Synchronized
        fun getInstance(context: Context): ImageVolleyRequest? {
            if (customVolleyRequest == null) {
                customVolleyRequest = ImageVolleyRequest(context)
            }
            return customVolleyRequest
        }
    }

    init {
        requestQueue = getRequestQueue()
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
}