package org.configuration;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Constant {
	private static final Logger LOG = LoggerFactory.getLogger(Constant.class);
	public static String INPUT_FILE_LOCATION = "INPUT_FILE_LOCATION";
	public static String OUTPUT_FILE_LOCATION = "OUTPUT_FILE_LOCATION";
	public static String INPUT_FILE_TYPE = "CSV";
	public static String OUTPUT_FILE_TYPE = "CSV";
	static {
		Properties prop = new Properties();
		InputStream input = null;
		// ClassLoader classLoader = Constant.class.getClass().getClassLoader();
		// @SuppressWarnings("static-access")
		// String url =
		// classLoader.getSystemResource("app.properties").getFile();
		try {
			input = new FileInputStream("application.properties");
			prop.load(input);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		INPUT_FILE_LOCATION = prop.getProperty("INPUT_FILE_LOCATION");
		OUTPUT_FILE_LOCATION = prop.getProperty("OUTPUT_FILE_LOCATION");
		INPUT_FILE_TYPE = prop.getProperty("CSV");
		OUTPUT_FILE_TYPE = prop.getProperty("CSV");
	}

}
