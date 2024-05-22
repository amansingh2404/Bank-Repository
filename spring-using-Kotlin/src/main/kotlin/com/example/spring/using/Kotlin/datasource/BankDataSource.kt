package com.example.spring.using.Kotlin.datasource

import com.example.spring.using.Kotlin.model.Bank

interface BankDataSource {
    fun retrieveBanks(): Collection<Bank>
     fun retrieveBank(accountNumber: String): Bank
}