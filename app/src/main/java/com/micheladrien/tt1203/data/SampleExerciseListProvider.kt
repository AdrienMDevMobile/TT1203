package com.micheladrien.tt1203.data

import com.micheladrien.tt1203.data.model.Exercise
import com.micheladrien.tt1203.data.model.ExerciseList
import javax.inject.Inject

class SampleExerciseListProvider @Inject constructor() : ExerciseListProvider {
    override suspend fun getExerciseList(): ExerciseList {
        val list = ArrayList<Exercise>()
        list.add(0, Exercise(0, "image0", "name0"))
        list.add(1, Exercise(1, "image1", "name1"))
        list.add(2, Exercise(0, "image2", "name0"))
        list.add(3, Exercise(1, "image3", "name1"))
        list.add(4, Exercise(0, "image4", "name0"))
        list.add(5, Exercise(1, "image5", "name1"))
        list.add(6, Exercise(0, "image6", "name0"))
        list.add(7, Exercise(1, "image7", "name1"))
        list.add(8, Exercise(0, "image8", "name0"))
        list.add(9, Exercise(1, "image9", "name1"))
        return ExerciseList(list)

    }
}