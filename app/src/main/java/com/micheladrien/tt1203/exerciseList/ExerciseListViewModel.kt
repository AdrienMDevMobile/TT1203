package com.micheladrien.tt1203.exerciseList

import androidx.lifecycle.*
import com.micheladrien.tt1203.data.ExerciseListProvider
import com.micheladrien.tt1203.data.SharedPrefListProvider
import com.micheladrien.tt1203.data.model.ExerciseList
import com.micheladrien.tt1203.util.EspressoIdlingRessource
import com.micheladrien.tt1203.volley.internetConnection.Variables
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ExerciseListViewModel @Inject constructor (private val exerciseListProvider: ExerciseListProvider, private val spp : SharedPrefListProvider) : ViewModel() {

    private val _exercisesLiveData = MutableLiveData<ExerciseList>()
    val exercisesLiveData: LiveData<ExerciseList> = _exercisesLiveData

    init{

        EspressoIdlingRessource.increment()
        viewModelScope.launch(Dispatchers.IO){

            if(!Variables.isNetworkConnected) {
                //Gets data from SharedPreferences
                _exercisesLiveData.postValue(spp.getSharedPreferences())
                //Wait for the Network to come.
                while (!Variables.isNetworkConnected) {
                    Thread.sleep(5000)
                }
            }

            val listExercises = exerciseListProvider.getExerciseList()
            _exercisesLiveData.postValue(listExercises)
            EspressoIdlingRessource.decrement()

            spp.putSharedPreferences(listExercises)
            //val exList : ExerciseList = ApiCallClass(applicationContext).getListEx()
            //for(exercise in exList.data) mTxtViewResult.append("\n 1 id : " + exercise.id + " url : " + exercise.image_url + " name : " + exercise.name)
        }


    }

}