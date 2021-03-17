package com.micheladrien.tt1203.tools

import com.micheladrien.tt1203.data.ExerciseListProvider
import com.micheladrien.tt1203.data.SampleExerciseListProvider
import com.micheladrien.tt1203.di.AppModule
import com.micheladrien.tt1203.volley.ImageVolleyLoader
import com.micheladrien.tt1203.volley.myImageLoader
import dagger.Binds
import dagger.Module
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn
import javax.inject.Singleton

@Module
@TestInstallIn(
    components = [SingletonComponent::class],
    replaces = [AppModule::class]
)
abstract class TestModule {

    @Singleton
    @Binds
    abstract fun bindExerciseListProvider(
        dataProvider : SampleExerciseListProvider
    ) : ExerciseListProvider

    @Singleton
    @Binds
    abstract fun bindImageLoader(
            imageLoader : TestImageLoader
    ) : myImageLoader

}