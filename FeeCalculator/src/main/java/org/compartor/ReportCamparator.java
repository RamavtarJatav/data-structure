package org.compartor;

import java.util.Comparator;

import org.model.ProcessingFee;

public class ReportCamparator implements Comparator<ProcessingFee> {

	public int compare(ProcessingFee p1, ProcessingFee p2) {
		// TODO Auto-generated method stub

		int val = p1.getClientId().compareTo(p2.getClientId());

		if (val != 0) {
			return val;
		} else {
			val = p1.getTransactionType().compareTo(p2.getTransactionType());
			if (val != 0) {
				return val;
			} else {
				if (p1.getTransactionDate() > p2.getTransactionDate()) {
					return 1;
				} else if (p1.getTransactionDate() < p2.getTransactionDate()) {
					return -1;
				} else {
					return p1.getPriority().compareTo(p2.getPriority());
				}
			}
		}
	}
}
