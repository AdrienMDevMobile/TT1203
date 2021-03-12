package com.micheladrien.tt1203.exerciseList

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.micheladrien.tt1203.data.ExerciseListProvider
import com.micheladrien.tt1203.data.model.ExerciseList
import dagger.hilt.android.lifecycle.HiltViewModel
import java.util.ArrayList
import javax.inject.Inject

@HiltViewModel
class ExerciseListViewModel @Inject constructor (private val exerciseListProvider: ExerciseListProvider) : ViewModel() {
    private val _exercisesLiveData = MutableLiveData<ExerciseList>()
    val exercisesLiveData: LiveData<ExerciseList> = _exercisesLiveData

    init{
        _exercisesLiveData.postValue(exerciseListProvider.getExerciseList())
    }
}