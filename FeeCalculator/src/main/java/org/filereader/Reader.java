package org.filereader;

import java.util.List;
import java.util.Map;

import org.model.Transaction;

public interface Reader {
	
	void open();
	void read();
	void close();
	Map<Long/* date */ , List<Transaction>> getTransactionListbyDate(); 

}
