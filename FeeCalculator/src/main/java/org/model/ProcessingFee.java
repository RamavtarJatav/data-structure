package org.model;

public class ProcessingFee {
	private String clientId;
	private String transactionType;
	private long transactionDate;
	private String priority;
	private double fee;

	public ProcessingFee(String clientId, String transactionType, long transactionDate, String priority) {
		this.clientId = clientId;
		this.transactionType = transactionType;
		this.transactionDate = transactionDate;
		this.priority = priority;

	}

	public double getProcessingFee() {
		return fee;
	}

	public void setProcessingFee(double processingFee) {
		this.fee = processingFee;
	}

	public String getClientId() {
		return clientId;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public long getTransactionDate() {
		return transactionDate;
	}

	public String getPriority() {
		return priority;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + this.clientId.hashCode();
		result = prime * result + this.transactionType.hashCode();
		result = prime * result + (int) this.transactionDate;
		result = prime * result + this.priority.hashCode();

		return result;
	}

	@Override
	public boolean equals(Object obj) {

		if (!(obj instanceof ProcessingFee)) {
			return false;
		} else {
			ProcessingFee ot = (ProcessingFee) obj;
			if (this.clientId == ot.clientId && this.transactionType == ot.transactionType
					&& this.transactionDate == ot.transactionDate && this.priority == ot.getPriority()) {
				  return true;
			}else {
				return false;
			}

		}

	}
}
