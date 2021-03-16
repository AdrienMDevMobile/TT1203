package com.micheladrien.tt1203.exerciseList

import android.util.Log
import androidx.lifecycle.*
import com.micheladrien.tt1203.data.ExerciseListProvider
import com.micheladrien.tt1203.data.model.ExerciseList
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.ArrayList
import javax.inject.Inject

@HiltViewModel
class ExerciseListViewModel @Inject constructor (private val exerciseListProvider: ExerciseListProvider) : ViewModel() {
    private val _exercisesLiveData = MutableLiveData<ExerciseList>()
    val exercisesLiveData: LiveData<ExerciseList> = _exercisesLiveData

    init{
        Log.d("testAmi", "Init VM")

        viewModelScope.launch(Dispatchers.Main){
            Log.d("testAmi", "Launch scope")
            _exercisesLiveData.postValue(exerciseListProvider.getExerciseList())
            //val exList : ExerciseList = ApiCallClass(applicationContext).getListEx()
            //for(exercise in exList.data) mTxtViewResult.append("\n 1 id : " + exercise.id + " url : " + exercise.image_url + " name : " + exercise.name)
        }

    }
}