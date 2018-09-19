package org.configuration;

import java.util.Properties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CONSTANT {
	private static final Logger LOG = LoggerFactory.getLogger(CONSTANT.class);
	public static String INPUT_FILE_DIRECTORY = "INPUT_FILE_LOCATION";
	public static String OUTPUT_FILE_DIRECTORY = "OUTPUT_FILE_LOCATION";
	public static String INPUT_FILE_NAME = "INPUT_FILE_NAME";
	public static String INPUT_FILE_DATE_FORMAT = "dd/MM/yyyy";

	public static String OUTPUT_FILE_NAME = "OUTPUT_FILE_NAME";
	public static String INPUT_FILE_TYPE = "INPUT_FILE_TYPE";
	public static String OUTPUT_FILE_TYPE = "OUTPUT_FILE_TYPE";

	// Fee for various Transaction

	public static float BUY_FEE = 50;
	public static float SELL_FEE = 100;
	public static float DEPOSIT_FEE = 50;
	public static float WITHDRAW_FEE = 100;
	public static float INTRADAY_FEE = 10;
	public static float HIGH_PRIORITY_FEE = 500;

	// Various kind of Transaction

	public static final String DEPOSIT = "DEPOSIT";
	public static final String WITHDRAW = "WITHDRAW";
	public static final String BUY = "BUY";
	public static final String SELL = "SELL";
	public static final String HIGH_PRIORITY = "Y";
	public static final String NORMAL_PRIORITY = "N";

	// various types of file type

	public static final String CSV = "CSV";
	public static final String XML = "XML";
	public static final String EXCEL = "EXCEL";
	public static final String PIPEDELIMITED = "PIPEDELIMITED";

	static {
		try {
			Configuration config = Configuration.getStandard();
			Properties prop = config.getProperties();
			INPUT_FILE_DIRECTORY = prop.getProperty("INPUT_FILE_DIRECTORY");
			OUTPUT_FILE_DIRECTORY = prop.getProperty("OUTPUT_FILE_DIRECTORY");
			INPUT_FILE_NAME = prop.getProperty("INPUT_FILE_NAME");
			OUTPUT_FILE_NAME = prop.getProperty("OUTPUT_FILE_NAME");
			INPUT_FILE_TYPE = prop.getProperty("INPUT_FILE_TYPE");
			OUTPUT_FILE_TYPE = prop.getProperty("OUTPUT_FILE_TYPE");
			INPUT_FILE_DATE_FORMAT = prop.getProperty("INPUT_FILE_DATE_FORMAT");

			BUY_FEE = Float.parseFloat(prop.getProperty("BUY_FEE"));
			SELL_FEE = Float.parseFloat(prop.getProperty("SELL_FEE"));
			DEPOSIT_FEE = Float.parseFloat(prop.getProperty("DEPOSIT_FEE"));
			WITHDRAW_FEE = Float.parseFloat(prop.getProperty("WITHDRAW_FEE"));
			INTRADAY_FEE = Float.parseFloat(prop.getProperty("INTRADAY_FEE"));
			HIGH_PRIORITY_FEE = Float.parseFloat(prop.getProperty("HIGH_PRIORITY_FEE"));
		} catch (Exception e) {
			LOG.error("{}",
					new Object[] { " Exception in setting  Constant data ", e.getMessage() , e });

		}

	}

}
