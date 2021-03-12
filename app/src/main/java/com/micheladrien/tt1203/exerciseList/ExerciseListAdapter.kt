package com.micheladrien.tt1203.exerciseList

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.micheladrien.tt1203.R
import com.micheladrien.tt1203.data.model.ExerciseList

class ExerciseListAdapter (private val exerciseList: ExerciseList) : RecyclerView.Adapter<ExerciseListVH>()  {

    //The method creates and initializes the ViewHolder and its associated View,
    // but does not fill in the view's contents—the ViewHolder has not yet been bound to specific data.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExerciseListVH {
        // create a new view
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.exercise_view_item, parent, false)
        // set the view's size, margins, paddings and layout parameters

        return ExerciseListVH(view)

    }

    //The method fetches the appropriate data and uses the data to fill in the view holder's layout.
    override fun onBindViewHolder(holder: ExerciseListVH, position: Int) {

        holder.tv_image_exercise.text = exerciseList.data[position].image_url
        holder.tv_exercise_name.text = exerciseList.data[position].name

    }

    //RecyclerView calls this method to get the size of the data set.
    // For example, in an address book app, this might be the total number of addresses.
    // RecyclerView uses this to determine when there are no more items that can be displayed.
    override fun getItemCount() = exerciseList.data.size

}

