package com.first_project.account.dto

import com.first_project.account.model.TransactionType
import java.math.BigDecimal
import java.time.LocalDateTime
import java.util.*

data class TransactionDto(
    val id: UUID?,
    val transactionType: TransactionType? = TransactionType.INITIAL,
    val amount: BigDecimal?,
    val transactionDate: LocalDateTime?
)