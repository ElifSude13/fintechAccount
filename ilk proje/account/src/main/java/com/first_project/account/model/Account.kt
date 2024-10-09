package com.first_project.account.model

import com.first_project.account.model.Customer
import jakarta.persistence.*
import java.util.UUID
import java.math.BigDecimal
import java.time.LocalDateTime

@Entity
data class Account(
    @Id
    @GeneratedValue
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
        customer = customer
    )
}