package com.micheladrien.tt1203.data

import com.android.volley.Response
import com.micheladrien.tt1203.data.model.ExerciseList

interface ExerciseListProvider {
    suspend fun getExerciseList() : ExerciseList
}