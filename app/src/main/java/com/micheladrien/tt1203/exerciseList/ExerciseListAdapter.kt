package com.micheladrien.tt1203.exerciseList

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.toolbox.ImageLoader
import com.android.volley.toolbox.NetworkImageView
import com.micheladrien.tt1203.R
import com.micheladrien.tt1203.data.model.ExerciseList
import com.micheladrien.tt1203.volley.ImageVolleyRequest


class ExerciseListAdapter(private val context: Context?, private val exerciseList: ExerciseList) : RecyclerView.Adapter<ExerciseListVH>()  {

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
        loadImage(holder.image, exerciseList.data[position].image_url)
    }

    //RecyclerView calls this method to get the size of the data set.
    // For example, in an address book app, this might be the total number of addresses.
    // RecyclerView uses this to determine when there are no more items that can be displayed.
    override fun getItemCount() = exerciseList.data.size

    private fun loadImage(imageHolder : NetworkImageView, url : String) {
        if (url == "") {
            //Toast.makeText(this, "Please enter a URL", Toast.LENGTH_LONG).show()
            imageHolder.setImageResource(android.R.drawable.ic_dialog_alert)
            return
        }
        val imageLoader = context?.let { it1 -> ImageVolleyRequest.getInstance(it1)?.imageLoader }
        imageLoader?.get(url, ImageLoader.getImageListener(imageHolder,
                android.R.drawable.ic_menu_report_image, android.R.drawable.ic_dialog_alert))
        imageHolder.setImageUrl(url, imageLoader)
    }


}

