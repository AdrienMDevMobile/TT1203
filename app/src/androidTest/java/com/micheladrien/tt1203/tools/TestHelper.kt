package com.micheladrien.tt1203.tools

/*
import androidx.test.platform.app.InstrumentationRegistry.getInstrumentation
import androidx.test.uiautomator.UiDevice
import androidx.test.uiautomator.UiObject
import androidx.test.uiautomator.UiSelector
import org.junit.Assert

object TestHelper {
    var APP_PACKAGE_NAME = "com.micheladrien.android.uiautomatortestingsample"

    var mDevice: UiDevice = UiDevice.getInstance(getInstrumentation())
    fun byId(id: String): UiObject {
        return mDevice.findObject(
            UiSelector()
                .resourceId(APP_PACKAGE_NAME.toString() + ":id/" + id)
        )
    }

    fun viewId(id: String): String {
        return APP_PACKAGE_NAME.toString() + ":id/" + id
    }

    @Throws(Exception::class)
    fun checkActionBarTitle(title: String) {
        val tvActionBarTitle: UiObject = mDevice.findObject(
            UiSelector()
                .resourceId(APP_PACKAGE_NAME.toString() + ":id/tvActionBarTitle")
        )
        Assert.assertEquals(title.toUpperCase(), tvActionBarTitle.getText())
    }

    @Throws(Exception::class)
    fun verifyText(id: String, title: String?) {
        val tvActionBarTitle: UiObject = mDevice.findObject(
            UiSelector()
                .resourceId(APP_PACKAGE_NAME.toString() + ":id/" + id)
        )
        Assert.assertEquals(title, tvActionBarTitle.getText())
    }

    @Throws(Exception::class)
    fun clickAndWait(id: String) {
        val cancelButton: UiObject = byId(id)
        cancelButton.clickAndWaitForNewWindow()
    }

    fun resourceId(resourceId: String): String {
        return APP_PACKAGE_NAME.toString() + ":id/" + resourceId
    }

    fun getRowItem(itemIndex: Int, resourceId: String): UiSelector {
        return UiSelector()
            .resourceId(resourceId(resourceId))
            .enabled(true).instance(itemIndex)
    }
}*/