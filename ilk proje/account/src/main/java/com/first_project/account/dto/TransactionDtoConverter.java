package com.first_project.account.dto;

import org.springframework.stereotype.Component;

import com.first_project.account.moderç.Transaction;

@Component
public class TransactionDtoConverter {
    
    public TransactionDto convert(Transaction from){
        return new Transaction(from.getId(), from.getTransactionType(), from.getAmount(), 
        from.getTransactionDate( ));
    }
}
