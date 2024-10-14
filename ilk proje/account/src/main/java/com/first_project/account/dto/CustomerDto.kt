package com.first_project.account.dto;

import java.util.*

data class CustomerDto(
    val id: String?,
    val name: String?,
    val surname: String?,
    val accounts: Set<CustomerAccountDto>? 
)