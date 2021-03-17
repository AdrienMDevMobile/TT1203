package com.micheladrien.tt1203.exerciseList

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.toolbox.ImageLoader
import com.android.volley.toolbox.NetworkImageView
import com.micheladrien.tt1203.R
import com.micheladrien.tt1203.data.model.ExerciseList
import com.micheladrien.tt1203.volley.ImageVolleyLoader
import com.micheladrien.tt1203.volley.myImageLoader


class ExerciseListAdapter(private val exerciseList: ExerciseList, private val myImageLoader: myImageLoader) : RecyclerView.Adapter<ExerciseListVH>()  {

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

        //holder.tv_image_exercise.text = exerciseList.data[position].image_url
        holder.tv_exercise_name.text = exerciseList.data[position].name
        myImageLoader.loadImage(holder.image, exerciseList.data[position].image_url)
    }

    override fun getItemCount() = exerciseList.data.size



}

