package org.model;

public class ProcessingFee {
	private String clientId;
	private String transactionType;
	private long transactionDate;
	private String priority;
	private double fee;
	
	public ProcessingFee(String clientId , String transactionType , long transactionDate , String priority){
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


}
