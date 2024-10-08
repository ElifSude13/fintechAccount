package com.firstProject.account.dto

import com.firstProject.account.model.TransactionType
import java.math.BigDecimal
import java.time.LocalDateTime

data class TrensactionDto(
    val id: String?,
    val transactionType: TransactionType? = TransactionType.INITIAL,
    val amount: BigDecimal?,
    val transactionDate: LocalDateTime?
)