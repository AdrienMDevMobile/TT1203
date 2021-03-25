package com.micheladrien.tt1203.data

import com.micheladrien.tt1203.data.model.Exercise
import com.micheladrien.tt1203.data.model.ExerciseList
import javax.inject.Inject

class SampleExerciseListProvider @Inject constructor() : ExerciseListProvider {
    override suspend fun getExerciseList(): ExerciseList {
        return getExerciseList2()

    }

    fun getExerciseList2(): ExerciseList {
        val list = ArrayList<Exercise>()
        list.add(0, Exercise(0, "image0", "name0"))
        list.add(1, Exercise(1, "image1", "name1"))
        list.add(2, Exercise(2, "image2", "name2"))
        list.add(3, Exercise(3, "image3", "name3"))
        list.add(4, Exercise(4, "image4", "name4"))
        list.add(5, Exercise(5, "image5", "name5"))
        list.add(6, Exercise(6, "image6", "name6"))
        list.add(7, Exercise(7, "image7", "name7"))
        list.add(8, Exercise(8, "image8", "name8"))
        list.add(9, Exercise(9, "image9", "name9"))
        return ExerciseList(list)

    }
}