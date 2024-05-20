package com.example.spring.using.Kotlin.datasource.mock

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Assertions.*
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.Test

class MockDataSourceTest{

    private  val mockDataSource = MockDataSource()

    @Test
    fun `should provide a collection of banks`(){
        //given


        //when
        val banks = mockDataSource.retrieveBanks()

        //then
        Assertions.assertThat(banks).isNotEmpty()
        Assertions.assertThat(banks.size).isGreaterThan(2)

    }
    @Test
    fun `should provide some mock data` (){
        val banks = mockDataSource.retrieveBanks()

        //then
        Assertions.assertThat(banks).allMatch{it.accountNumber.isNotBlank()}
    }
}