package com.example.spring.using.Kotlin.service

import com.example.spring.using.Kotlin.datasource.BankDataSource
import com.example.spring.using.Kotlin.model.Bank
import org.springframework.stereotype.Service

@Service
class BankService(val dataSource: BankDataSource) {
    fun getBanks(): Collection<Bank>{
        return dataSource.retrieveBanks()
    }

    fun getBank(accountNumber: String): Bank = dataSource.retrieveBank(accountNumber)
}