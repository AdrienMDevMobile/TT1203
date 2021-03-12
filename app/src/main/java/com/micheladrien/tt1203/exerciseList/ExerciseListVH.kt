package com.micheladrien.tt1203.exerciseList

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.micheladrien.tt1203.R

class ExerciseListVH (val view: View) : RecyclerView.ViewHolder(view) {
    val tv_image_exercise : TextView
    val tv_exercise_name : TextView

    init {
        tv_image_exercise = view.findViewById(R.id.img_exercise)
        tv_exercise_name = view.findViewById(R.id.tv_exercise_name)
    }

}