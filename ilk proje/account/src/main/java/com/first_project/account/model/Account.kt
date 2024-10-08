package com.firstProject.account.model

import java.util.UUID
import java.math.BigDecimal
import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class Account(
    @Id
    @GeneratedValue
    val id: UUID = UUID.randomUUID(),
    val balance : BigDecimal? = BigDecimal.ZERO,
    val creationDate : LocalDateTime, 

    @ManyToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    @JoinColumn(name = "customer_id", nullable = false)
    val customer : Customer?,

    @OneToMany(mappedBy = "account", fetch = FetchType.LAZY)
    val transaction: Set<Transaction> 
) {

}