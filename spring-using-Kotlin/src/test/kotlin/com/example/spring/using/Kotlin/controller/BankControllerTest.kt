package com.example.spring.using.Kotlin.controller

import com.example.spring.using.Kotlin.model.Bank
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get
import org.springframework.test.web.servlet.post

@SpringBootTest
@AutoConfigureMockMvc
class BankControllerTest @Autowired constructor(
     val mockMvc: MockMvc,
     val objectMapper: ObjectMapper
){



    val baseUrl = "/api/banks"

    @Test
    fun `should return all banks`(){
        //given
        mockMvc.get("/api/banks")
            .andDo { println() }
            .andExpect {
                status{ isOk()}
                content { contentType(MediaType.APPLICATION_JSON) }
                jsonPath("$[0].accountNumber"){value("12345")}
            }

        //when


        //then
    }

    @Nested
    @DisplayName("getBank()")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    inner class GetBank{
        @Test
        fun `should return the bank with the account number`(){
            val accountNumber = "12345"
            //when given
            mockMvc.get("/api/banks/$accountNumber")
                .andDo { println() }
                .andExpect {
                    status { isOk() }
                    content { contentType(MediaType.APPLICATION_JSON) }
                    jsonPath("$.trust"){value("0.0")}
                    jsonPath("$.transaction"){value("1")}
                }
        }

        @Test
        fun `should return Not Found if the account number does not exists`(){
            //given
            val accountNumber = "does_not_exist"
            val baseUrl = "/api/banks"
            mockMvc.get("$baseUrl/$accountNumber")
                .andDo { print() }
                .andExpect { status { isNotFound() } }
        }
    }

    @Nested
    @DisplayName("POST /api/banks")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    inner class PostNewBank{


        @Test
        fun `Should add new Bank`(){
            //given
            val newBank = Bank("45678", 11.0,17)

            //when
            mockMvc.post(baseUrl){
                contentType = MediaType.APPLICATION_JSON
                content = objectMapper.writeValueAsString(newBank)
            }
                //then
                .andDo { print() }
                .andExpect {
                    status { isCreated() }
                    content { contentType(MediaType.APPLICATION_JSON) }
                    jsonPath("$.accountNumber"){value("45678")}
                    jsonPath("$.trust"){value(11.0)}
                    jsonPath("$.transaction"){value(17)}
                }
        }
    }





}