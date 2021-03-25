package com.micheladrien.tt1203.data

import android.content.Context
import android.content.SharedPreferences
import android.content.SharedPreferences.Editor
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.micheladrien.tt1203.data.model.ExerciseList
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

//private val context: Context,
class SharedPrefListProvider @Inject constructor(private val gson: Gson, @ApplicationContext private val context: Context) {
    val MyPREFERENCES = "FUOFFLINE"
    val keyList = "FUList"
    val typeExerciseList = object : TypeToken<ExerciseList>() {}.type

    fun putSharedPreferences(list : ExerciseList){
        val sharedpreferences: SharedPreferences =
            context.getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE)
        val editor: Editor = sharedpreferences.edit()
        editor.clear()
        editor.putString(keyList, gson.toJson(list))
        editor.commit()
    }

    fun getSharedPreferences() : ExerciseList {


        val sharedpreferences: SharedPreferences =
            context.getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE)
        val stringList = sharedpreferences.getString(keyList, """{ "data": [ { "id": 0, "name": "0", "image_url": "" } ] }""")
        /*stringList?.let {
            gson.fromJson(stringList, typeExerciseList )
        } */
        return gson.fromJson(stringList, typeExerciseList )

    }

}