package org.configuration;

public class DefaultConfig {

	static void setDefaults(Configuration config) {
		// input file related configuration
		config.set(Configuration.Keys.INPUT_FILE_DIRECTORY, "input/");
		config.set(Configuration.Keys.INPUT_FILE_NAME, "input.csv");
		config.set(Configuration.Keys.INPUT_FILE_TYPE, "CSV");
		config.set(Configuration.Keys.INPUT_FILE_DATE_FORMAT, "MM/dd/yyyy");

		// output file configuration
		config.set(Configuration.Keys.OUTPUT_FILE_DIRECTORY, "output/");
		config.set(Configuration.Keys.OUTPUT_FILE_NAME, "output.csv");
		config.set(Configuration.Keys.OUTPUT_FILE_TYPE, "CSV");
		config.set(Configuration.Keys.INPUT_FILE_DIRECTORY, "input/");

		// Fee for various kind of Transaction
		config.set(Configuration.Keys.INTRADAY_FEE, "10");
		config.set(Configuration.Keys.BUY_FEE, "50");
		config.set(Configuration.Keys.SELL_FEE, "100");
		config.set(Configuration.Keys.DEPOSIT_FEE, "50");
		config.set(Configuration.Keys.WITHDRAW_FEE, "100");
		config.set(Configuration.Keys.HIGH_PRIORITY_FEE, "500");

		// Type of Transaction
		config.set(Configuration.Keys.BUY, "BUY");
		config.set(Configuration.Keys.SELL, "SELL");
		config.set(Configuration.Keys.DEPOSIT, "DEPOSIT");
		config.set(Configuration.Keys.WITHDRAW, "WITHDRAW");
		config.set(Configuration.Keys.HIGH_PRIORITY, "Y");
		config.set(Configuration.Keys.NORMAL_PRIORITY, "N");

	}

}
