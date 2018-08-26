package org.processing;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.compartor.ReportCamparator;
import org.configuration.CONSTANT;
import org.model.ProcessingFee;
import org.model.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
   Processing Rules:
   1. Intraday transactions: Intra-day transactions are the ones where security (like IBM Equity) is bought
      & sold on the same day. Intra-day transactions will have two transactions having same Client Id,
      Security Id, & Transaction Date but opposite Transaction Type i.e. one transaction would be ‘Sell’ & 
      other would be ‘Buy’. Each ‘intra-day transaction should be charged $10 for both the Buy & Sell legs.
   2. Normal transactions: A nominal fee is charged to process each transaction. Fee calculation is based on
      following rules:$500 for a transaction with high priority (denoted by the priority field in the transaction).
      $100 for a transaction with normal priority and Transaction Type is Sell and Withdraw. $50 for a transaction
       with normal priority and Transaction Type Code is buy and sell;.
  
 * */

public class RuleProcessor implements Processor {
	private static final Logger LOG = LoggerFactory.getLogger(RuleProcessor.class);

	private Map<ProcessingFee, Double> report = new TreeMap<ProcessingFee, Double>(new ReportCamparator());
   
	public RuleProcessor() {
	
	}
	@Override
	public void process(Map<Long, List<Transaction>> transactionListbyDate) {
		LOG.debug("{}", new Object[] { " processing input data start" });
		try {
			for (Map.Entry<Long, List<Transaction>> entrySet : transactionListbyDate.entrySet()) {
				List<Transaction> trlst = entrySet.getValue();
				int n = trlst.size();

				for (int i = 0; i < n; i++) {
					Transaction tr = trlst.get(i);
					ProcessingFee pr = new ProcessingFee(tr.getClientId(), tr.getTransactionType(),
							tr.getDate(), tr.getPriorityFlag());

					boolean intraday = false;

					for (int j = i - 1; j >= 0; j--) {
						Transaction trpre = trlst.get(j);
						if (tr.getTransactionType().equals("SELL") && trpre.getTransactionType().equals("BUY")
								&& (tr.getClientId().equals(trpre.getClientId()))
								&& tr.getSecurityId().equals(trpre.getSecurityId())) {
							intraday = true;
							break;
						}

					}
					if (intraday) {
						intraDayAddFee(pr);
						intraday = false;
						continue;
					}

					if (tr.getPriorityFlag().equals(CONSTANT.HIGH_PRIORITY)) {
						addFee(pr, CONSTANT.HIGH_PRIORITY_FEE);
					} else if (tr.getPriorityFlag().equals(CONSTANT.NORMAL_PRIORITY)) {
						if (tr.getTransactionType().equals(CONSTANT.DEPOSIT)) {
							addFee(pr, CONSTANT.DEPOSIT_FEE);
						} else if (tr.getTransactionType().equals(CONSTANT.WITHDRAW)) {
							addFee(pr, CONSTANT.WITHDRAW_FEE);
						} else if (tr.getTransactionType().equals(CONSTANT.SELL)) {
							addFee(pr, CONSTANT.SELL_FEE);
						} else if (tr.getTransactionType().equals(CONSTANT.BUY)) {
							addFee(pr, CONSTANT.BUY_FEE);
						}
					} else {
						LOG.error("{}", new Object[] { "Invalid priority flag = " + tr.getPriorityFlag() });

					}

				}

			}

			LOG.debug("{}", new Object[] { "Input data processing successful" });

		} catch (Exception e) {
			LOG.error("{}", new Object[] { "Execption in processing input data", e.getMessage(), e });

		}

	}

	void intraDayAddFee(ProcessingFee pr) {
		LOG.debug("{}", new Object[] { "Intra Day add fee Transaction processing start " });
		try {
			ProcessingFee prprev = new ProcessingFee(pr.getClientId(), "BUY",
					pr.getTransactionDate(), pr.getPriority());
			report.put(prprev, report.get(prprev) - CONSTANT.BUY_FEE + CONSTANT.INTRADAY_FEE);
			Double prfee = report.get(pr);
			if (prfee == null) {
				report.put(pr, (double) CONSTANT.INTRADAY_FEE);
			} else {
				report.put(pr, prfee + CONSTANT.INTRADAY_FEE);
			}
		} catch (Exception e) {
			LOG.error("{}", new Object[] { "Intra Day  add fee Transaction exception ", e.getMessage(), e });

		}
		LOG.debug("{}", new Object[] { "Intra Day add fee Transaction processing end " });

	}

	void addFee(ProcessingFee pr, double fee) {
		
		LOG.debug("{}", new Object[] { "Add fee Transaction processing start " });

		try {
		if (report.containsKey(pr)) {
			double newFee = fee + report.get(pr);
			report.put(pr, newFee);
		} else {
			report.put(pr, fee);
		}
		
		LOG.debug("{}", new Object[] { "Add fee Transaction processing end " });

		}catch(Exception e) {
			LOG.error("{}", new Object[] { "Intra Day Transaction exception ", e.getMessage(), e });

		}
	}

	@Override
	public Map<ProcessingFee, Double> getProcessedData() {
		return Collections.unmodifiableMap(report);
	}

}
