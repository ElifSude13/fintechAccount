package com.firstProject.account.dto;

import com.firstProject.account.moderç.Transaction;
import org.springframework.stereotype.Component;

@Component
public class TransactionDtoConverter {
    
    public TransactionDto convert(Transaction from){
        return new Transaction(from.getId(), from.getTransactionType(), from.getAmount(), 
        from.getTransactionDate( ));
    }
}
