package com.tom.enhanceit.ui.list

import com.nhaarman.mockitokotlin2.whenever
import com.tom.enhanceit.model.Launch
import io.reactivex.Single
import junit.framework.Assert.assertEquals
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class ListPresenterTest {

    @InjectMocks
    lateinit var presenter: ListPresenter

    @Mock
    lateinit var repository: SpaceXRepository


    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun `when repo calls api to get launches then we get list of launches`() {
        // Arrange
        val launch = Launch("", null, null, false)
        val listLaunches = listOf(launch)
        whenever(repository.getLaunches()).thenReturn(Single.just(listLaunches))
        // Act
        val result = presenter.getLaunches().blockingGet()

        // Assert
        assertEquals(1, result.size)
        Assert.assertEquals(launch, result[0])
    }

    @Test(expected = RuntimeException::class)
    fun `when repo calls api to get launches then we get runtime exception`() {
        // Arrange
        whenever(repository.getLaunches()).thenReturn(Single.error(RuntimeException()))
        // Act
        presenter.getLaunches().blockingGet()

    }

}