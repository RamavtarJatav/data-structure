package org.compartor;

import java.util.Comparator;

import org.model.Transaction;

public class TransactionDateComparator implements Comparator<Transaction> {

	public int compare(Transaction t1, Transaction t2) {
		// TODO Auto-generated method stub
		if(t1.getDate() > t2.getDate()){
            return 1;
        } else {
            return -1;
        } 
	}

}
