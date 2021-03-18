package com.micheladrien.tt1203.di

import com.micheladrien.tt1203.data.APIExerciseListProvider
import com.micheladrien.tt1203.data.ExerciseListProvider
import com.micheladrien.tt1203.volley.ImageVolleyLoader
import com.micheladrien.tt1203.volley.myImageLoader
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
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

    @Singleton
    @Binds
    abstract fun bindImageLoader(
            imageLoader : ImageVolleyLoader
    ) : myImageLoader


}