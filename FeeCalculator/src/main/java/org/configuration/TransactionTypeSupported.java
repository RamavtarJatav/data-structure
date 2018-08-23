package org.configuration;

public enum TransactionTypeSupported {
	DEPOSITED("DEPOSITED"), WITHDRAW("WITHDRAW"), SELL("SELL"), BUY("BUY");

	public String type;
	
	TransactionTypeSupported(String type) {
         this.type = type;
	}

}
