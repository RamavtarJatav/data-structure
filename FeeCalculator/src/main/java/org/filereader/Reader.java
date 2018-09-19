package org.filereader;

import java.util.List;
import java.util.Map;

import org.model.Transaction;

public interface Reader {
	
	
	void read();
	Map<Long/* date */ , List<Transaction>> getTransactionListbyDate(); 

}
