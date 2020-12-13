package com.tom.enhanceit.ui.list

import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.launchActivity
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.runner.AndroidJUnit4
import com.tom.enhanceit.R
import com.tom.enhanceit.app.PresenterMock
import com.tom.enhanceit.app.PresenterMockFails
import com.tom.enhanceit.core.AppSchedulers
import com.tom.enhanceit.util.RecyclerViewMatcher
import org.junit.After
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.core.context.loadKoinModules
import org.koin.core.context.unloadKoinModules
import org.koin.dsl.module
import org.koin.test.KoinTest

@RunWith(AndroidJUnit4::class)
class MainActivityTest : KoinTest {

    private lateinit var scenario: ActivityScenario<MainActivity>
    private lateinit var activity: MainActivity

    private val mainModule = module {
        single<PresenterSpaceX> { PresenterMock() }
        single { AppSchedulers() }
    }
    private val mainModuleFails = module {
        single<PresenterSpaceX> { PresenterMockFails() }
        single { AppSchedulers() }
    }


    @After
    fun after() {
        scenario.close()
        unloadKoinModules(mainModule)
    }

    @Test
    fun whenCallSpaceXAndLoadRegularWay() {
        //Assert
        loadKoinModules(mainModule)
        // Act
        launchMainActivity()

        // Assert
        onView(RecyclerViewMatcher(R.id.recycler).atPosition(0)).check(
            matches(
                hasDescendant(
                    withText("SpaceX")
                )
            )
        )
    }

    @Test
    fun whenCallSpaceXAndSomethingFails() {
        loadKoinModules(mainModuleFails)

        launchMainActivity()

        //Assert
        onView(withText(R.string.try_again)).check(matches(isDisplayed()))
    }


    private fun launchMainActivity() {
        scenario = launchActivity()
        scenario.onActivity {
            activity = it
        }
    }
}