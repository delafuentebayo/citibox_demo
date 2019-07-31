package com.jmdelafuente.citiboxdemo.presenters

import androidx.test.runner.AndroidJUnit4
import com.jmdelafuente.citiboxdemo.activities.EpisodeDetailActivity.EpisodeDetailPresenter
import com.jmdelafuente.citiboxdemo.enums.StatusFilter
import com.jmdelafuente.citiboxdemo.mocks.NetworkControllerMock
import com.jmdelafuente.citiboxdemo.views.EpisodeDetailMock
import org.junit.Assert.assertEquals

import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class EpisodeDetailPresenterTests {

    @Test
    fun getCharactersOk() {
        val networkControllerMock = NetworkControllerMock()
        val viewEpisodeDetailMock = EpisodeDetailMock()
        val presenter = EpisodeDetailPresenter(networkControllerMock)
        presenter.attach(viewEpisodeDetailMock)
        val urls: ArrayList<String> = ArrayList()
        urls.add("https://rickandmortyapi.com/api/character/1")
        urls.add("https://rickandmortyapi.com/api/character/2")
        urls.add("https://rickandmortyapi.com/api/character/127")
        presenter.getCharacters(urls)
        assertEquals(networkControllerMock.characters.size, 3)
        assertEquals(networkControllerMock.characters[0], 1)
        assertEquals(networkControllerMock.characters[1], 2)
        assertEquals(networkControllerMock.characters[2], 127)

    }

    @Test
    fun getCharactersKo() {
        val networkControllerMock = NetworkControllerMock()
        val viewEpisodeDetailMock = EpisodeDetailMock()
        val presenter = EpisodeDetailPresenter(networkControllerMock)
        presenter.attach(viewEpisodeDetailMock)
        val urls: ArrayList<String> = ArrayList()
        urls.add("https://rickandmortyapi.com/api/character/1")
        urls.add("https://rickandmortyapi.com/api/character/2")
        urls.add("https://rickandmortyapi.com/api/character/127")
        networkControllerMock.makeCallFails = true
        presenter.getCharacters(urls)
        assertEquals(viewEpisodeDetailMock.showError, true)
    }
    @Test
    fun changeFilter1() {
        val networkControllerMock = NetworkControllerMock()
        val viewEpisodeDetailMock = EpisodeDetailMock()
        val presenter = EpisodeDetailPresenter(networkControllerMock)
        presenter.attach(viewEpisodeDetailMock)
        val urls: ArrayList<String> = ArrayList()
        urls.add("https://rickandmortyapi.com/api/character/1")
        urls.add("https://rickandmortyapi.com/api/character/2")
        urls.add("https://rickandmortyapi.com/api/character/7")
        urls.add("https://rickandmortyapi.com/api/character/8")
        presenter.getCharacters(urls)
        presenter.changedFilter(StatusFilter.ALL)
        assertEquals(viewEpisodeDetailMock.charactersTest.size, 4)
    }

    @Test
    fun changeFilter2() {
        val networkControllerMock = NetworkControllerMock()
        val viewEpisodeDetailMock = EpisodeDetailMock()
        val presenter = EpisodeDetailPresenter(networkControllerMock)
        presenter.attach(viewEpisodeDetailMock)
        val urls: ArrayList<String> = ArrayList()
        urls.add("https://rickandmortyapi.com/api/character/1")
        urls.add("https://rickandmortyapi.com/api/character/2")
        urls.add("https://rickandmortyapi.com/api/character/7")
        urls.add("https://rickandmortyapi.com/api/character/8")
        presenter.getCharacters(urls)
        presenter.changedFilter(StatusFilter.ALIVE)
        assertEquals(viewEpisodeDetailMock.charactersTest.size, 2)
    }

    @Test
    fun changeFilter3() {
        val networkControllerMock = NetworkControllerMock()
        val viewEpisodeDetailMock = EpisodeDetailMock()
        val presenter = EpisodeDetailPresenter(networkControllerMock)
        presenter.attach(viewEpisodeDetailMock)
        val urls: ArrayList<String> = ArrayList()
        urls.add("https://rickandmortyapi.com/api/character/1")
        urls.add("https://rickandmortyapi.com/api/character/2")
        urls.add("https://rickandmortyapi.com/api/character/3")
        urls.add("https://rickandmortyapi.com/api/character/4")
        presenter.getCharacters(urls)
        presenter.changedFilter(StatusFilter.DIED)
        assertEquals(viewEpisodeDetailMock.charactersTest.size, 1)
    }

    @Test
    fun changeFilter4() {
        val networkControllerMock = NetworkControllerMock()
        val viewEpisodeDetailMock = EpisodeDetailMock()
        val presenter = EpisodeDetailPresenter(networkControllerMock)
        presenter.attach(viewEpisodeDetailMock)
        val urls: ArrayList<String> = ArrayList()
        urls.add("https://rickandmortyapi.com/api/character/1")
        urls.add("https://rickandmortyapi.com/api/character/2")
        urls.add("https://rickandmortyapi.com/api/character/7")
        urls.add("https://rickandmortyapi.com/api/character/8")
        presenter.getCharacters(urls)
        presenter.changedFilter(StatusFilter.UNKNOWN)
        assertEquals(viewEpisodeDetailMock.charactersTest.size, 1)
    }

}