package com.example.evam3.service

import com.example.evam3.entity.Characters
import com.example.evam3.entity.Scene
import com.example.evam3.repository.CharactersRepository
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
class CharactersServiceTest {

    @InjectMocks
    lateinit var charactersService: CharactersService//clae que se va a probar

    @Mock   //objeto simulado
    lateinit var charactersRepository: CharactersRepository

    val charactersMock = Characters().apply {
        id=1
        description="0301707030"
        cost=BigDecimal.ZERO
        scene_id= 123L

    }

    @Test
    fun saveCharactersCorrect(){
        Mockito.`when`(charactersRepository.save(Mockito.any(Characters::class.java))).thenReturn(charactersMock)
        val response = charactersService.save(charactersMock)
        Assertions.assertEquals(response.id, charactersMock.id)
    }


    @Test
    fun saveClientWhenFullnameIsBlank(){

        Assertions.assertThrows(Exception::class.java) {
            charactersMock.apply { description=" "}
            Mockito.`when`(charactersRepository.save(Mockito.any(Characters::class.java))).thenReturn(charactersMock)
            charactersService.save(charactersMock)
        }

    }
}