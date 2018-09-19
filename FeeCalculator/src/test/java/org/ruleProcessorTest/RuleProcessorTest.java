package org.ruleProcessorTest;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.compartor.ReportCamparator;
import org.junit.Test;
import org.model.ProcessingFee;
import org.model.Transaction;
import org.processing.Processor;
import org.processing.RuleProcessor;

//import org.processing.RuleProcessor;

public class RuleProcessorTest {
	
	@Test
	public void intraDayTransactionTrue() {
	   
		List<Transaction> transactionList = new ArrayList<Transaction>();
		transactionList.add(new Transaction("ABCDEFGH1", "C1" ,"SEC1" ,"BUY" , 111111110000l, 100d, "N"));
		transactionList.add(new Transaction("ABCDEFGH1", "C1" ,"SEC1" ,"SELL" , 111111110000l, 100d, "N"));
		Map<Long , List<Transaction>> transactionListMapbyDate = new TreeMap<Long , List<Transaction>>();
		transactionListMapbyDate.put(111111110000l, transactionList);	
		
		Processor ruleProcessor = new RuleProcessor();
		ruleProcessor.process(transactionListMapbyDate);
		
		
		Map<ProcessingFee,Double> processingFeeMap = new TreeMap<ProcessingFee, Double>(new ReportCamparator()); 
		processingFeeMap.put(new ProcessingFee("C1" , "BUY", 111111110000l, "N"), 10d);
		processingFeeMap.put(new ProcessingFee("C1" , "SELL", 111111110000l, "N"), 10d);
		assertEquals(ruleProcessor.getProcessedData(), processingFeeMap);
		
		
	}
	
	@Test
	public void nonIntraDayTransactionTrue() {
	   
		List<Transaction> transactionList = new ArrayList<Transaction>();
		transactionList.add(new Transaction("ABCDEFGH1", "C1" ,"SEC1" ,"BUY" , 111111110000l, 100d, "N"));
		
		List<Transaction> transactionList1 = new ArrayList<Transaction>();
		transactionList1.add(new Transaction("ABCDEFGH1", "C1" ,"SEC1" ,"SELL" , 111111120000l, 100d, "N"));
		Map<Long , List<Transaction>> transactionListMapbyDate = new TreeMap<Long , List<Transaction>>();
		transactionListMapbyDate.put(111111110000l, transactionList);
		transactionListMapbyDate.put(111111120000l, transactionList1);
		
		Processor ruleProcessor = new RuleProcessor();
		ruleProcessor.process(transactionListMapbyDate);
		
		
		Map<ProcessingFee,Double> processingFeeMap = new TreeMap<ProcessingFee, Double>(new ReportCamparator()); 
		processingFeeMap.put(new ProcessingFee("C1" , "BUY", 111111110000l, "N"), 50d);
		processingFeeMap.put(new ProcessingFee("C1" , "SELL", 111111120000l, "N"), 100d);
		assertEquals(ruleProcessor.getProcessedData(), processingFeeMap);
		
		
		
	}
	
	@Test
	public void highPriorityTransactionTrue() {
	   
		List<Transaction> transactionList = new ArrayList<Transaction>();
		transactionList.add(new Transaction("ABCDEFGH1", "C1" ,"SEC1" ,"BUY" , 111111110000l, 100d, "Y"));
		transactionList.add(new Transaction("ABCDEFGH1", "C2" ,"SEC1" ,"SELL" , 111111110000l, 100d, "Y"));
		transactionList.add(new Transaction("ABCDEFGH1", "C3" ,"SEC1" ,"DEPOSIT" , 111111110000l, 100d, "Y"));
		transactionList.add(new Transaction("ABCDEFGH1", "C4" ,"SEC1" ,"WITHDRAW" , 111111110000l, 100d, "Y"));
		Map<Long , List<Transaction>> transactionListMapbyDate = new TreeMap<Long , List<Transaction>>();
		transactionListMapbyDate.put(111111110000l, transactionList);	
		
		Processor ruleProcessor = new RuleProcessor();
		ruleProcessor.process(transactionListMapbyDate);
		
		
		Map<ProcessingFee,Double> processingFeeMap = new TreeMap<ProcessingFee, Double>(new ReportCamparator()); 
		processingFeeMap.put(new ProcessingFee("C1" , "BUY", 111111110000l, "Y"), 500d);
		processingFeeMap.put(new ProcessingFee("C2" , "SELL", 111111110000l, "Y"), 500d);
		processingFeeMap.put(new ProcessingFee("C3" , "DEPOSIT", 111111110000l, "Y"), 500d);
		processingFeeMap.put(new ProcessingFee("C4" , "WITHDRAW", 111111110000l, "Y"), 500d);
		assertEquals(ruleProcessor.getProcessedData(), processingFeeMap);
		
		
	}
	
	@Test
	public void normalPriorityTransactionTrue() {
	   
		List<Transaction> transactionList = new ArrayList<Transaction>();
		transactionList.add(new Transaction("ABCDEFGH1", "C1" ,"SEC1" ,"BUY" , 111111110000l, 100d, "N"));
		transactionList.add(new Transaction("ABCDEFGH1", "C1" ,"SEC1" ,"SELL" , 111111110000l, 100d, "N"));
		transactionList.add(new Transaction("ABCDEFGH1", "C1" ,"SEC1" ,"DEPOSIT" , 111111110000l, 100d, "N"));
		transactionList.add(new Transaction("ABCDEFGH1", "C1" ,"SEC1" ,"WITHDRAW" , 111111110000l, 100d, "N"));
		Map<Long , List<Transaction>> transactionListMapbyDate = new TreeMap<Long , List<Transaction>>();
		transactionListMapbyDate.put(111111110000l, transactionList);	
		
		Processor ruleProcessor = new RuleProcessor();
		ruleProcessor.process(transactionListMapbyDate);
		
		
		Map<ProcessingFee,Double> processingFeeMap = new TreeMap<ProcessingFee, Double>(new ReportCamparator()); 
		processingFeeMap.put(new ProcessingFee("C1" , "BUY", 111111110000l, "N"), 10d);
		processingFeeMap.put(new ProcessingFee("C1" , "SELL", 111111110000l, "N"), 10d);
		processingFeeMap.put(new ProcessingFee("C1" , "DEPOSIT", 111111110000l, "N"), 50d);
		processingFeeMap.put(new ProcessingFee("C1" , "WITHDRAW", 111111110000l, "N"), 100d);
		assertEquals(ruleProcessor.getProcessedData(), processingFeeMap);
		
		
	}
	
	@Test
	public void normalPriorityDifferentDateTransactionTrue() {
	   
		List<Transaction> transactionList = new ArrayList<Transaction>();
		transactionList.add(new Transaction("ABCDEFGH1", "C1" ,"SEC1" ,"BUY" , 111111110000l, 100d, "N"));
		
		List<Transaction> transactionList1 = new ArrayList<Transaction>();
		transactionList1.add(new Transaction("ABCDEFGH1", "C2" ,"SEC1" ,"SELL" , 111111120000l, 100d, "N"));
		
		List<Transaction> transactionList2 = new ArrayList<Transaction>();
		transactionList2.add(new Transaction("ABCDEFGH1", "C3" ,"SEC1" ,"DEPOSIT" , 111111130000l, 100d, "N"));
		
		List<Transaction> transactionList3 = new ArrayList<Transaction>();
		transactionList3.add(new Transaction("ABCDEFGH1", "C4" ,"SEC1" ,"WITHDRAW" , 111111140000l, 100d, "N"));
		
		
		
		Map<Long , List<Transaction>> transactionListMapbyDate = new TreeMap<Long , List<Transaction>>();
		transactionListMapbyDate.put(111111110000l, transactionList);	
		transactionListMapbyDate.put(111111120000l, transactionList1);	
		transactionListMapbyDate.put(111111130000l, transactionList2);	
		transactionListMapbyDate.put(111111140000l, transactionList3);	
		
		
		Processor ruleProcessor = new RuleProcessor();
		ruleProcessor.process(transactionListMapbyDate);
		
		
		Map<ProcessingFee,Double> processingFeeMap = new TreeMap<ProcessingFee, Double>(new ReportCamparator()); 
		processingFeeMap.put(new ProcessingFee("C1" , "BUY", 111111110000l, "N"), 50d);
		processingFeeMap.put(new ProcessingFee("C2" , "SELL", 111111120000l, "N"), 100d);
		processingFeeMap.put(new ProcessingFee("C3" , "DEPOSIT", 111111130000l, "N"), 50d);
		processingFeeMap.put(new ProcessingFee("C4" , "WITHDRAW", 111111140000l, "N"), 100d);
		assertEquals(ruleProcessor.getProcessedData(), processingFeeMap);
		
		
	}
	
	@Test
	public void normalPrioritySameClientDiffenentSecuirtyIdTransactionTrue() {
	   
		List<Transaction> transactionList = new ArrayList<Transaction>();
		transactionList.add(new Transaction("ABCDEFGH1", "C1" ,"SEC1" ,"BUY" , 111111110000l, 100d, "N"));
		transactionList.add(new Transaction("ABCDEFGH1", "C1" ,"SEC2" ,"BUY" , 111111110000l, 100d, "N"));
		transactionList.add(new Transaction("ABCDEFGH1", "C1" ,"SEC3" ,"BUY" , 111111110000l, 100d, "N"));
		transactionList.add(new Transaction("ABCDEFGH1", "C1" ,"SEC4" ,"BUY" , 111111110000l, 100d, "N"));
		Map<Long , List<Transaction>> transactionListMapbyDate = new TreeMap<Long , List<Transaction>>();
		transactionListMapbyDate.put(111111110000l, transactionList);	
		
		Processor ruleProcessor = new RuleProcessor();
		ruleProcessor.process(transactionListMapbyDate);
		
		
		Map<ProcessingFee,Double> processingFeeMap = new TreeMap<ProcessingFee, Double>(new ReportCamparator()); 
		processingFeeMap.put(new ProcessingFee("C1" , "BUY", 111111110000l, "N"), 200d);
		assertEquals(ruleProcessor.getProcessedData(), processingFeeMap);
		
		
	}
	
	@Test
	public void normalPrioritySameClientDiffenentSecuirtyIdTransaction1True() {
	   
		List<Transaction> transactionList = new ArrayList<Transaction>();
		transactionList.add(new Transaction("ABCDEFGH1", "C1" ,"SEC1" ,"BUY" , 111111110000l, 100d, "N"));
		transactionList.add(new Transaction("ABCDEFGH1", "C1" ,"SEC2" ,"BUY" , 111111110000l, 100d, "N"));
		transactionList.add(new Transaction("ABCDEFGH1", "C2" ,"SEC3" ,"SELL" , 111111110000l, 100d, "N"));
		transactionList.add(new Transaction("ABCDEFGH1", "C2" ,"SEC4" ,"SELL" , 111111110000l, 100d, "N"));
		Map<Long , List<Transaction>> transactionListMapbyDate = new TreeMap<Long , List<Transaction>>();
		transactionListMapbyDate.put(111111110000l, transactionList);	
		
		Processor ruleProcessor = new RuleProcessor();
		ruleProcessor.process(transactionListMapbyDate);
		
		
		Map<ProcessingFee,Double> processingFeeMap = new TreeMap<ProcessingFee, Double>(new ReportCamparator()); 
		processingFeeMap.put(new ProcessingFee("C1" , "BUY", 111111110000l, "N"), 100d);
		processingFeeMap.put(new ProcessingFee("C2" , "SELL", 111111110000l, "N"), 200d);
		assertEquals(ruleProcessor.getProcessedData(), processingFeeMap);
		
		
	}
	
	@Test
	public void normalandHighPrioritySameClientDiffenentSecuirtyIdTransactionTrue() {
	   
		List<Transaction> transactionList = new ArrayList<Transaction>();
		transactionList.add(new Transaction("ABCDEFGH1", "C1" ,"SEC1" ,"BUY" , 111111110000l, 100d, "N"));
		transactionList.add(new Transaction("ABCDEFGH1", "C1" ,"SEC2" ,"BUY" , 111111110000l, 100d, "Y"));
		transactionList.add(new Transaction("ABCDEFGH1", "C2" ,"SEC3" ,"SELL" , 111111110000l, 100d, "N"));
		transactionList.add(new Transaction("ABCDEFGH1", "C2" ,"SEC4" ,"SELL" , 111111110000l, 100d, "Y"));
		Map<Long , List<Transaction>> transactionListMapbyDate = new TreeMap<Long , List<Transaction>>();
		transactionListMapbyDate.put(111111110000l, transactionList);	
		
		Processor ruleProcessor = new RuleProcessor();
		ruleProcessor.process(transactionListMapbyDate);
		
		
		Map<ProcessingFee,Double> processingFeeMap = new TreeMap<ProcessingFee, Double>(new ReportCamparator()); 
		processingFeeMap.put(new ProcessingFee("C1" , "BUY", 111111110000l, "N"), 50d);
		processingFeeMap.put(new ProcessingFee("C1" , "BUY", 111111110000l, "Y"), 500d);
		processingFeeMap.put(new ProcessingFee("C2" , "SELL", 111111110000l, "N"), 100d);
		processingFeeMap.put(new ProcessingFee("C2" , "SELL", 111111110000l, "Y"), 500d);
		assertEquals(ruleProcessor.getProcessedData(), processingFeeMap);
		
		
	}
	
	
	
	

}
