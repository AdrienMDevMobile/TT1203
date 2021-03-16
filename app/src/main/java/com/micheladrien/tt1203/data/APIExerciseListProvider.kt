package com.micheladrien.tt1203.data

import android.content.Context
import android.util.Log
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.JsonDeserializationContext
import com.google.gson.reflect.TypeToken
import com.micheladrien.tt1203.data.model.Exercise
import com.micheladrien.tt1203.data.model.ExerciseList
import com.micheladrien.tt1203.volley.URLs
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.suspendCancellableCoroutine
import org.json.JSONObject
import javax.inject.Inject
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException


class APIExerciseListProvider @Inject constructor(@ApplicationContext private val context: Context) : ExerciseListProvider{
// @MyRequestQueue private val queue : RequestQueue

    val queue : RequestQueue by lazy {
        Log.d("TestAmi", "Init VM")
        Volley.newRequestQueue(context)
    }

    @ExperimentalCoroutinesApi
    override suspend fun getExerciseList() : ExerciseList {

        Log.d("TestAmi", "Nous sommes dans le getExerciseList")

        val URL: String = "https://s3-us-west-1.amazonaws.com/fizzup/files/public/sample.json"

        val typeExerciseList = object : TypeToken<ExerciseList>() {}.type

        return suspendCancellableCoroutine { continuation ->
            try {
                // Sucess Listner
                val success = Response.Listener<JSONObject> { response ->
                    if (continuation.isActive) {
                        //continuation.resume(Gson().fromJson(response.getJSONArray("data").toString(), typeExerciseList ))
                        continuation.resume(Gson().fromJson(response.toString(), typeExerciseList ))
                    }
                }

                // Error Listner
                val error = Response.ErrorListener {
                    if (continuation.isActive) {
                        continuation.resume(ExerciseList(ArrayList<Exercise>()))
                    }
                }

                val jsonObjectRequest =
                        JsonObjectRequest(Request.Method.GET, URL, null, success, error)

                queue.add(jsonObjectRequest)

            } catch (e: Exception) {
                e.printStackTrace()
                if (continuation.isActive) {
                    if (continuation.isActive) {
                        continuation.resumeWithException(e)
                    }
                }
            }
        }
    }

}
//https://www.youtube.com/watch?v=SlpnqikLS40
//https://www.youtube.com/watch?v=y2xtLqP8dSQ
//https://www.journaldev.com/17198/android-volley-tutorial
//https://www.thecrazyprogrammer.com/2016/07/android-volley-tutorial.html
