package com.first_project.account.model

import jakarta.persistence.*
import java.util.UUID
import com.first_project.account.model.Account

@Entity
data class Customer(
    @Id
    @GeneratedValue
    val id: UUID = UUID.randomUUID(),
    val name: String? = null,
    val surname: String? = null,

    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
    val accounts: Set<Account>? = emptySet()
) {
    constructor(UUID: UUID, Elif_Sude: String, Meydan: String) : this(
        id = UUID,
        name = Elif_Sude,
        surname = Meydan
    ) {

    }
}