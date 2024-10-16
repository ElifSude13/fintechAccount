package com.first_project.account.model

import jakarta.persistence.*
import java.util.UUID
import java.math.BigDecimal
import java.time.LocalDateTime

@Entity
class Transaction(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: UUID = UUID.randomUUID(),
    val transactionType: TransactionType? = TransactionType.INITIAL,
    val amount:  BigDecimal? = null,
    val transactionDate: LocalDateTime? = null,

    @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = [CascadeType.ALL])
    @JoinColumn(name = "account_id", nullable = false)
    val account: Account
){
    constructor() : this(
        UUID.randomUUID(),
        transactionType = TransactionType.INITIAL,
        amount = null,
        transactionDate = null,
        account = Account()
    )

    constructor(amount: BigDecimal, transactionDate: LocalDateTime, account: Account) : this(
        UUID.randomUUID(),
        transactionType = TransactionType.INITIAL,
        amount = amount,
        transactionDate = transactionDate,
        account = account
    )

    override fun equals(other: Any?): Boolean {
        if(this === other) return true
        if(javaClass != other?.javaClass) return false

        other as Transaction

        if(id != other.id) return false
        if(transactionType != other.transactionType) return false 
        if(amount != other.amount) return false
        if(transactionDate != other.transactionDate) return false
        if(account != other.account) return false 

        return true
     }

     override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + (transactionType?.hashCode() ?: 0)
        result = 31 * result + (amount?.hashCode() ?: 0)
        result = 31 * result + (transactionDate?.hashCode() ?: 0)
        
        return result
     } 
}

enum class TransactionType{
    INITIAL, TRANSFER
}