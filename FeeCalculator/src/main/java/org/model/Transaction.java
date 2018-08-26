package org.model;

import java.util.Date;

public class Transaction {
	private String externalId;
	private String clientId;
	private String securityId;
	private String transactionType;
	private long date;
	private double marketValue;
	private String priorityFlag;

	public Transaction(String externalId, String clientId, String securityId, String transactionType, long date,
			double marketValue, String priorityFlag) {

		this.externalId = externalId;
		this.clientId = clientId;
		this.securityId = securityId;
		this.transactionType = transactionType;
		this.date = date;
		this.marketValue = marketValue;
		this.priorityFlag = priorityFlag;

	}

	public String getExternalId() {
		return externalId;
	}

	public String getClientId() {
		return clientId;
	}

	public String getSecurityId() {
		return securityId;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public long getDate() {
		return date;
	}

	public double getMarketValue() {
		return marketValue;
	}

	public String getPriorityFlag() {
		return priorityFlag;
	}

	public static class Builder {

		private String externalId;
		private String clientId;
		private String securityId;
		private String transactionType;
		private long date;
		private double marketValue;
		private String priorityFlag;

		public Builder(String externalId, String clientId, String securityId, String transactionType, long date,
				double marketValue) {
			this.externalId = externalId;
			this.clientId = clientId;
			this.securityId = securityId;
			this.transactionType = transactionType;
			this.date = date;
			this.marketValue = marketValue;
		}

		public Builder setPriorityFlag(String priorityFlag) {
			this.priorityFlag = priorityFlag;
			return this;
		}

		public Transaction build() {
			return new Transaction(externalId, clientId, securityId, transactionType, date, marketValue, priorityFlag);
		}

	}

	@Override
	public String toString() {
		return "[ externalId = " + externalId + "," + "clientId = " + clientId + "," + "securityId  = " + securityId
				+ "," + "transactionType = " + transactionType + "," + "date = " + date + "," + "marketValue = "
				+ marketValue + "priorityFlag = " + priorityFlag + " ]";
	}

}
