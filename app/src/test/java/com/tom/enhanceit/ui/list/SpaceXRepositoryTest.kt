package com.tom.enhanceit.ui.list

import com.nhaarman.mockitokotlin2.whenever
import com.tom.enhanceit.api.SpaceXAPI
import com.tom.enhanceit.model.Launch
import io.reactivex.Single
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class SpaceXRepositoryTest {

    @InjectMocks lateinit var repository: SpaceXRepository
    @Mock lateinit var api: SpaceXAPI

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun `when api is called then we get valid result`() {
        // Arrange
        val launch = Launch("",null,null,false)
        whenever(api.getLaunches()).thenReturn(Single.just(listOf(launch)))

        // Act
        val result = repository.getLaunches().blockingGet()

        // Assert
        assertEquals(1, result.size)
        assertEquals(launch , result[0])
    }

}