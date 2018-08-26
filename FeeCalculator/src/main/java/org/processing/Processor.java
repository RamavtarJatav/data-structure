package org.processing;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.model.ProcessingFee;
import org.model.Transaction;

public interface Processor {

	void process(Map<Long, List<Transaction>> transactionListbyDate);

	Map<ProcessingFee, Double> getProcessedData();

}
