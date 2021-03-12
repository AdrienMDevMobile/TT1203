package com.micheladrien.tt1203.tools

import com.micheladrien.tt1203.di.BaseApplication
import dagger.hilt.android.testing.CustomTestApplication

@CustomTestApplication(BaseApplication::class)
interface HiltTestApplication