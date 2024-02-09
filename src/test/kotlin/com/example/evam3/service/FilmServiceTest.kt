package com.example.evam3.service

import com.example.evam3.entity.Film
import com.example.evam3.repository.FilmRepository
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class FilmServiceTest {

    @InjectMocks
    lateinit var filmService: FilmService//clae que se va a probar

    @Mock   //objeto simulado
    lateinit var filmRepository: FilmRepository

    val filmMock = Film().apply {
        id=1
        title="0301707030"
        director="Juan"
        duration= 2L
    }

    @Test
    fun saveFilmCorrect(){
        Mockito.`when`(filmRepository.save(Mockito.any(Film::class.java))).thenReturn(filmMock)
        val response = filmService.save(filmMock)
        Assertions.assertEquals(response.id, filmMock.id)
    }


    @Test
    fun saveClientWhenFullnameIsBlank(){

        Assertions.assertThrows(Exception::class.java) {
            filmMock.apply { title=" "}
            Mockito.`when`(filmRepository.save(Mockito.any(Film::class.java))).thenReturn(filmMock)
            filmService.save(filmMock)
        }

    }
}