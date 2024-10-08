package com.firstProject.account.model

import javax.persistence.*
import java.util.UUID
import com.firstProject.account.model.Account

@Entity
data class Customer(
    @Id
    @GeneratedValue
    val id: UUID = UUID.randomUUID(),
    val name: String?,
    val surname: String?,

    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
    val accounts: Set<Account>?
){

}