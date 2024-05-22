package com.example.spring.using.Kotlin.datasource.mock

import com.example.spring.using.Kotlin.model.Bank
import com.example.spring.using.Kotlin.datasource.BankDataSource
import org.springframework.stereotype.Repository

@Repository
class MockDataSource: BankDataSource {
     val bankFirst = listOf(
         Bank("12345", 0.0, 1),
         Bank("10101", 13.5,4),
         Bank("54231", 3.60,6)
     )
    override fun retrieveBanks(): Collection<Bank> {
        return bankFirst
    }

    override fun retrieveBank(accountNumber: String): Bank {
        return bankFirst.firstOrNull() { it.accountNumber == accountNumber  } ?: throw NoSuchElementException("There is no account with the given account Number")
    }
}