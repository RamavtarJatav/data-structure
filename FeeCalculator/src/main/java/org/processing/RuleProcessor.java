package org.processing;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.processing.Filer;
import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;

import org.model.ProcessingFee;
import org.model.Transaction;

public class RuleProcessor implements Processor{
	List<ProcessingFee> report = new ArrayList<ProcessingFee>();

	@Override
	public void process(Map<Long, List<Transaction>> transactionListbyDate) {
		for (Map.Entry<Long, List<Transaction>> entrySet : transactionListbyDate.entrySet()) {
			long time = entrySet.getKey();
			List<Transaction> trlst = entrySet.getValue();
			int n = trlst.size();
			Transaction tr = trlst.get(0);
			ProcessingFee pr = new ProcessingFee(tr.getClientId(), tr.getTransactionType(), tr.getDate(),
					tr.getPriorityFlag());

			if (tr.getPriorityFlag().equals("Y")) {
				pr.setProcessingFee(500);
			} else if (tr.getPriorityFlag().equals("N")) {
				if (tr.getTransactionType().equals("DEPOSIT")) {
					pr.setProcessingFee(50);
				} else if (tr.getTransactionType() == "WITHDRAW") {
					pr.setProcessingFee(100);
				} else if (tr.getTransactionType() == "SELL") {
					pr.setProcessingFee(100);
				} else if (tr.getTransactionType() == "BUY") {
					pr.setProcessingFee(50);
				}
			} else {
				// invalid transaction
			}

			for (int i = 1; i < n; i++) {
				tr = trlst.get(i);
				pr = new ProcessingFee(tr.getClientId(), tr.getTransactionType(), tr.getDate(),
						tr.getPriorityFlag());
				boolean intraday = false;

				for (int j = i - 1; j >= 0; j--) {
					Transaction trpre = trlst.get(j);
					if (tr.getTransactionType() == "BUY" && trpre.getTransactionType() == "SELL"
							&& (tr.getClientId().equals(trpre.getClientId()))
							&& tr.getSecurityId().equals(trpre.getSecurityId())) {
						intraday = true;
						break;
					} else if (tr.getTransactionType() == "SELL" && trpre.getTransactionType() == "BUY"
							&& (tr.getClientId().equals(trpre.getClientId()))
							&& tr.getSecurityId().equals(trpre.getSecurityId())) {
						intraday = true;
						break;
					}

				}
				if (intraday) {
					pr.setProcessingFee(10);
					intraday = false;
					continue;
				}

				if (tr.getPriorityFlag().equals("Y")) {
					pr.setProcessingFee(500);
				} else if (tr.getPriorityFlag().equals("N")) {
					if (tr.getTransactionType().equals("DEPOSIT")) {
						pr.setProcessingFee(50);
					} else if (tr.getTransactionType() == "WITHDRAW") {
						pr.setProcessingFee(100);
					} else if (tr.getTransactionType() == "SELL") {
						pr.setProcessingFee(100);
					} else if (tr.getTransactionType() == "BUY") {
						pr.setProcessingFee(50);
					}
				} else {
					// invalid transaction
				}

			}

		}
		
		
	}

	@Override
	public List<ProcessingFee> getProcessedData() {
		// TODO Auto-generated method stub
		return report;
	}

}
