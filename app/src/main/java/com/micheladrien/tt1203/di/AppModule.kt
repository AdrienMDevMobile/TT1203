package com.micheladrien.tt1203.di

import android.content.Context
import com.android.volley.RequestQueue
import com.android.volley.toolbox.Volley
import com.micheladrien.tt1203.data.APIExerciseListProvider
import com.micheladrien.tt1203.data.ExerciseListProvider
import com.micheladrien.tt1203.data.SampleExerciseListProvider
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {

    @Singleton
    @Binds
    abstract fun bindExerciseListProvider(
        dataProvider : APIExerciseListProvider
    ) : ExerciseListProvider

}