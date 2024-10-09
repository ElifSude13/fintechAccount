package com.first_project.account.dto;

import java.math.BigDecimal
import java.time.LocalDateTime
import java.util.UUID

data class CustomerAccountDto(
    val id: UUID,
    var balance:  BigDecimal? = BigDecimal.ZERO,
    val transactions: Set<TransactionDto>?,
    val creationDate: LocalDateTime
)