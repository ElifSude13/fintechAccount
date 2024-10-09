package com.first_project.account.dto

import java.math.BigDecimal
import java.util.UUID

data class CreateAccountRequest (
    val customerId: UUID,
    val initialCredit: BigDecimal
)
