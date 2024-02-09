package com.example.evam3.service

import com.example.evam3.entity.Film
import com.example.evam3.entity.Scene
import com.example.evam3.repository.FilmRepository
import com.example.evam3.repository.SceneRepository
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.springframework.boot.test.context.SpringBootTest
import java.math.BigDecimal

@SpringBootTest
class SceneServiceTest {

    @InjectMocks
    lateinit var sceneService: SceneService//clae que se va a probar

    @Mock   //objeto simulado
    lateinit var sceneRepository: SceneRepository

    val sceneMock = Scene().apply {
        id=1
        description="0301707030"
        budget=0.0
        minutes= BigDecimal("5")
        film_id= 2
    }

    @Test
    fun saveSceneCorrect(){
        Mockito.`when`(sceneRepository.save(Mockito.any(Scene::class.java))).thenReturn(sceneMock)
        val response = sceneService.save(sceneMock)
        Assertions.assertEquals(response.id, sceneMock.id)
    }


    @Test
    fun saveClientWhenFullnameIsBlank(){

        Assertions.assertThrows(Exception::class.java) {
            sceneMock.apply { description=" "}
            Mockito.`when`(sceneRepository.save(Mockito.any(Scene::class.java))).thenReturn(sceneMock)
            sceneService.save(sceneMock)
        }

    }
}