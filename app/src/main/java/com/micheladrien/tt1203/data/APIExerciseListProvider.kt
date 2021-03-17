package com.micheladrien.tt1203.data

import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.micheladrien.tt1203.data.model.Exercise
import com.micheladrien.tt1203.data.model.ExerciseList
import com.micheladrien.tt1203.volley.URLs
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.suspendCancellableCoroutine
import org.json.JSONObject
import javax.inject.Inject
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException


//class APIExerciseListProvider @Inject constructor(@ApplicationContext private val context: Context) : ExerciseListProvider{
class APIExerciseListProvider @Inject constructor(private val queue: RequestQueue, private val gson: Gson) : ExerciseListProvider{
// @MyRequestQueue private val queue : RequestQueue

    /*
    val queue : RequestQueue by lazy {
        Log.d("TestAmi", "Init VM")
        Volley.newRequestQueue(context)
    } */

    @ExperimentalCoroutinesApi
    override suspend fun getExerciseList() : ExerciseList {

        val URL: String = URLs.BASE_URL + URLs.LIST_URL

        val typeExerciseList = object : TypeToken<ExerciseList>() {}.type

        return suspendCancellableCoroutine { continuation ->
            try {
                // Sucess Listner
                val success = Response.Listener<JSONObject> { response ->
                    if (continuation.isActive) {
                        //continuation.resume(Gson().fromJson(response.getJSONArray("data").toString(), typeExerciseList ))
                        continuation.resume(gson.fromJson(response.toString(), typeExerciseList ))
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