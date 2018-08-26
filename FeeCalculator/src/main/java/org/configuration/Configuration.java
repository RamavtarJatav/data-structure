package org.configuration;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Configuration {
	private static final Logger LOG = LoggerFactory.getLogger(Configuration.class);

	private static final String DEFAULT = "application.properties";

	private static final String DEFAULT_HEADER = "Different properties ";

	private Properties properties = new Properties();

	private static Configuration configuration;

	private Configuration() {

	}
    
	public static Configuration getStandard()  {
		
		if (configuration == null) {
			try {
				createStandardwithFile(new File(DEFAULT));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return configuration;
	}

	static void createStandardwithFile(File file) throws IOException {
		configuration = new Configuration();
		if (file.exists()) {
			configuration.load(file);
		} else {
			configuration.store(file);
		}
	}

	public void load(File file) throws IOException {
		InputStream inputStream = new FileInputStream(file);
		properties.load(inputStream);
	}

	public void store(File file) throws IOException {
		store(file, DEFAULT_HEADER);
	}

	public void store(File file, String header) throws IOException {
		if (file == null) {
			throw new NullPointerException();
		} else {
			DefaultConfig.setDefaults(configuration);
			properties.store(new FileWriter(file), header);
		}
	}

	public void set(String key, String value) {
		properties.put(key, value);
	}
	
	public String getString(String key) {
		return properties.getProperty(key);
	}
	
	public float getFloat(String key) {
		return  Float.parseFloat(properties.getProperty(key));
	}
	
   public Properties getProperties() {
	   return this.properties;
   }

	public class Keys {
		public static final String INPUT_FILE_DIRECTORY = "INPUT_FILE_DIRECTORY";
		public static final String OUTPUT_FILE_DIRECTORY = "OUTPUT_FILE_DIRECTORY";
		public static final String INPUT_FILE_NAME = "INPUT_FILE_NAME";
		public static final String INPUT_FILE_DATE_FORMAT = "INPUT_FILE_DATE_FORMAT";

		public static final String OUTPUT_FILE_NAME = "OUTPUT_FILE_NAME";
		public static final String INPUT_FILE_TYPE = "INPUT_FILE_TYPE";
		public static final String OUTPUT_FILE_TYPE = "OUTPUT_FILE_TYPE";

		// Fee for various Transaction

		public static final String BUY_FEE = "BUY_FEE";
		public static final String SELL_FEE = "BUY_FEE";
		public static final String DEPOSIT_FEE = "DEPOSIT_FEE";
		public static final String WITHDRAW_FEE = "WITHDRAW_FEE";
		public static final String INTRADAY_FEE = "INTRADAY_FEE";
		public static final String HIGH_PRIORITY_FEE = "HIGH_PRIORITY_FEE";

		// Various kind of Transaction

		public static final String DEPOSIT = "DEPOSIT";
		public static final String WITHDRAW = "WITHDRAW";
		public static final String BUY = "BUY";
		public static final String SELL = "SELL";
		public static final String HIGH_PRIORITY = "HIGH_PRIORITY";
		public static final String NORMAL_PRIORITY = "NORMAL_PRIORITY";

		public static final String CSV = "CSV";
		public static final String XML = "XML";
		public static final String EXCEL = "EXCEL";
		public static final String PIPEDELIMITED = "PIPEDELIMITED";

	}

}
