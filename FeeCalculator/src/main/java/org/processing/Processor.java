package org.processing;

import java.util.List;
import java.util.Map;


import org.model.ProcessingFee;
import org.model.Transaction;
/*
 * File processor interface
 */

public interface Processor {

	void process(Map<Long, List<Transaction>> transactionListbyDate);

	Map<ProcessingFee, Double> getProcessedData();

}
