package com.first_project.account.dto;

import java.time.LocalDateTime
import java.math.BigDecimal
import java.util.UUID

data class AccountDto(
    val id: UUID?,
    val balance : BigDecimal? = BigDecimal.ZERO,
    val creationDate : LocalDateTime?,
    val customer : AccountCustomerDto?,
    val transactions: Set<TransactionDto>?
)