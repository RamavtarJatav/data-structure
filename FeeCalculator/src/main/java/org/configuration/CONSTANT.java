package org.configuration;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CONSTANT {
	private static final Logger LOG = LoggerFactory.getLogger(CONSTANT.class);
	public static String INPUT_FILE_DIRECTORY = "INPUT_FILE_LOCATION";
	public static String OUTPUT_FILE_DIRECTORY = "OUTPUT_FILE_LOCATION";
	public static String INPUT_FILE_NAME = "INPUT_FILE_NAME";
	public static String OUTPUT_FILE_NAME = "OUTPUT_FILE_NAME";
	public static String INPUT_FILE_TYPE = "INPUT_FILE_TYPE";
	public static String OUTPUT_FILE_TYPE = "OUTPUT_FILE_TYPE";
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
		INPUT_FILE_DIRECTORY = prop.getProperty("INPUT_FILE_DIRECTORY");
		OUTPUT_FILE_DIRECTORY = prop.getProperty("OUTPUT_FILE_DIRECTORY");
		INPUT_FILE_NAME = prop.getProperty("INPUT_FILE_NAME");
		OUTPUT_FILE_NAME = prop.getProperty("OUTPUT_FILE_NAME");
		INPUT_FILE_TYPE = prop.getProperty("INPUT_FILE_TYPE");
		OUTPUT_FILE_TYPE = prop.getProperty("OUTPUT_FILE_TYPE");
	}

}
