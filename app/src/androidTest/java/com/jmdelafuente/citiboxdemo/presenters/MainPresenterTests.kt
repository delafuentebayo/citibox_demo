package com.jmdelafuente.citiboxdemo.presenters

import androidx.test.runner.AndroidJUnit4
import com.jmdelafuente.citiboxdemo.activities.MainActivity.MainPresenter
import com.jmdelafuente.citiboxdemo.mocks.NetworkControllerMock
import com.jmdelafuente.citiboxdemo.views.MainViewMock
import org.junit.Assert.assertEquals

import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class MainPresenterTests {

    @Test
    fun getCharactersOk() {
        val networkControllerMock = NetworkControllerMock()
        val viewMainMock = MainViewMock()
        val presenter = MainPresenter(networkControllerMock)
        presenter.attach(viewMainMock)
        presenter.getEpisodes()
        assertEquals(viewMainMock.episodesTest.size, 4)
        assertEquals(viewMainMock.episodesTest[0].code, "1")
        assertEquals(viewMainMock.episodesTest[1].code, "2")
        assertEquals(viewMainMock.episodesTest[3].code, "127")

    }

    @Test
    fun getCharactersKo() {
        val networkControllerMock = NetworkControllerMock()
        val viewMainMock = MainViewMock()
        val presenter = MainPresenter(networkControllerMock)
        presenter.attach(viewMainMock)
        networkControllerMock.makeCallFails = true
        presenter.getEpisodes()
        assertEquals(viewMainMock.showError, true)


    }


}