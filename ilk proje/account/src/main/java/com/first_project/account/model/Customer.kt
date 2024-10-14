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
    constructor(Elif_Sude: String, Meydan: String) : this(
        UUID.randomUUID(),
        name = Elif_Sude,
        surname = Meydan
    )

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Customer

        if (id != other.id) return false
        if (name != other.name) return false
        if (surname != other.surname) return false
        if (accounts != other.accounts) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + (name?.hashCode() ?: 0)
        result = 31 * result + (surname?.hashCode() ?: 0)
        return result
    }
}