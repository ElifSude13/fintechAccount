package com.firstProject.account.dto;

import java.time.LocalDateTime
import java.math.BigDecimal

data class AccountDto(
    val id: String,
    val balance : BigDecimal? = BigDecimal.ZERO,
    val creationDate : LocalDateTime,
    val customer : AccountCustomerDto?,
    val transactions: Set<TrensactionDto>
)