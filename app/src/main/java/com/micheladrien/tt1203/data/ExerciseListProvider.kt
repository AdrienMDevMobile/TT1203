package com.micheladrien.tt1203.data

import com.micheladrien.tt1203.data.model.ExerciseList

interface ExerciseListProvider {
    fun getExerciseList():ExerciseList
}