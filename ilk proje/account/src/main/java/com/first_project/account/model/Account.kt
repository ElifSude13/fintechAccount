package com.first_project.account.model

import com.first_project.account.model.Customer
import jakarta.persistence.*
import java.util.UUID
import java.math.BigDecimal
import java.time.LocalDateTime

@Entity
data class Account(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: UUID = UUID.randomUUID(),
    val balance : BigDecimal? = BigDecimal.ZERO,
    val creationDate : LocalDateTime = LocalDateTime.now(),

    @ManyToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    @JoinColumn(name = "customer_id", nullable = false)
    val customer : Customer? = null,

    @OneToMany(mappedBy = "account", fetch = FetchType.LAZY)
    val transaction: Set<Transaction> = emptySet()
) {
    constructor(customer: Customer, balance: BigDecimal?, creationDate: LocalDateTime) : this(
        UUID.randomUUID(),
        customer = customer,
        balance = balance,
        creationDate = creationDate
    )

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Account

        if (id != other.id) return false
        if (balance != other.balance) return false
        if (creationDate != other.creationDate) return false
        if (customer != other.customer) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + (balance?.hashCode() ?: 0)
        result = 31 * result + creationDate.hashCode()
        result = 31 * result + (customer?.hashCode() ?: 0)

        return result
    }
}