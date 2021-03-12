package com.micheladrien.tt1203.data

import com.micheladrien.tt1203.data.model.Exercise
import com.micheladrien.tt1203.data.model.ExerciseList
import javax.inject.Inject

class APIExerciseListProvider @Inject constructor() : ExerciseListProvider {
    override fun getExerciseList(): ExerciseList {
        val list = ArrayList<Exercise>()
        list.add(0, Exercise(0, "image20", "name20"))
        list.add(1, Exercise(1, "image10", "name10"))
        list.add(1, Exercise(2, "XXXXX", "XXXXX"))
        return ExerciseList(list)

    }
}