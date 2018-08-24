package org.processing;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import javax.annotation.processing.Filer;
import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;

import org.compartor.ReportCamparator;
import org.model.ProcessingFee;
import org.model.Transaction;

public class RuleProcessor implements Processor {
	Map<ProcessingFee, Double> report = new TreeMap<ProcessingFee, Double>(new ReportCamparator());

	@Override
	public void process(Map<Long, List<Transaction>> transactionListbyDate) {
		for (Map.Entry<Long, List<Transaction>> entrySet : transactionListbyDate.entrySet()) {
			long time = entrySet.getKey();
			List<Transaction> trlst = entrySet.getValue();
			int n = trlst.size();

			for (int i = 0; i < n; i++) {
				Transaction tr = trlst.get(i);
				ProcessingFee pr = new ProcessingFee(tr.getClientId(), tr.getTransactionType(), tr.getDate(),
						tr.getPriorityFlag());

				boolean intraday = false;

				for (int j = i - 1; j >= 0; j--) {
					Transaction trpre = trlst.get(j);
					if (tr.getTransactionType().equals("BUY") && trpre.getTransactionType().equals("SELL")
							&& (tr.getClientId().equals(trpre.getClientId()))
							&& tr.getSecurityId().equals(trpre.getSecurityId())) {
						intraday = true;
						break;
					} else if (tr.getTransactionType().equals("SELL") && trpre.getTransactionType().equals("BUY")
							&& (tr.getClientId().equals(trpre.getClientId())
									&& tr.getSecurityId().equals(trpre.getSecurityId()))) {
						intraday = true;
						break;
					}

				}
				if (intraday) {
					if (report.containsKey(pr)) {
						double newFee = 10 + report.get(pr);
						pr.setProcessingFee(newFee);
						report.put(pr, newFee);
					} else {
						pr.setProcessingFee(10);
						report.put(pr, 10d);
					}

					intraday = false;
					continue;
				}

				if (tr.getPriorityFlag().equals("Y")) {
					pr.setProcessingFee(500);
				} else if (tr.getPriorityFlag().equals("N")) {
					if (tr.getTransactionType().equals("DEPOSIT")) {
						pr.setProcessingFee(50);
					} else if (tr.getTransactionType().equals("WITHDRAW")) {
						pr.setProcessingFee(100);
					} else if (tr.getTransactionType().equals("SELL")) {
						pr.setProcessingFee(100);
					} else if (tr.getTransactionType().equals("BUY")) {
						pr.setProcessingFee(50);
					}
				} else {
					// invalid transaction
				}

				report.put(pr, pr.getProcessingFee());

			}

		}

	}

	@Override
	public Set<ProcessingFee> getProcessedData() {
		// TODO Auto-generated method stub
		return report.keySet();
	}

}
