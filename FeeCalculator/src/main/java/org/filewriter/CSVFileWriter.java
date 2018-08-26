package org.filewriter;

import java.io.FileWriter;
import java.io.IOException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Set;

import org.configuration.CONSTANT;
import org.model.ProcessingFee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CSVFileWriter implements OutputFileWriter {
	private static final Logger LOG = LoggerFactory.getLogger(CSVFileWriter.class);
	private String DELIMITER = ",";
	private String OUTPUT_FILE = CONSTANT.OUTPUT_FILE_DIRECTORY+ CONSTANT.OUTPUT_FILE_NAME;

	@Override
	public void write(Map<ProcessingFee, Double> feeprocMap) {
		LOG.debug("{}",
				new Object[] { " start of writing processed date to output File ", OUTPUT_FILE });

		String NEW_LINE_SEPARATOR = "\n";
		FileWriter fileWriter = null;
		try {
			fileWriter = new FileWriter(OUTPUT_FILE);
		} catch (IOException e1) {

			LOG.error("{}", new Object[] { " Exception in creating output File ", OUTPUT_FILE});
		}

		try {
			for (Map.Entry<ProcessingFee, Double> entrySet : feeprocMap.entrySet()) {

				fileWriter.append(entrySet.getKey().getClientId());
				fileWriter.append(DELIMITER);
				fileWriter.append(entrySet.getKey().getTransactionType());
				fileWriter.append(DELIMITER);

				Date date = new Date(entrySet.getKey().getTransactionDate());
				Format format = new SimpleDateFormat(CONSTANT.INPUT_FILE_DATE_FORMAT);
				fileWriter.append(format.format(date));

				fileWriter.append(DELIMITER);
				fileWriter.append(entrySet.getKey().getPriority());
				fileWriter.append(DELIMITER);
				fileWriter.append(String.valueOf(entrySet.getValue()));
				fileWriter.append(NEW_LINE_SEPARATOR);
			}

		} catch (Exception e) {
			LOG.error("{}", new Object[] { " Exception in writing to output File = " + OUTPUT_FILE,
					e.getMessage(), e });
		}

		try {
			fileWriter.flush();

		} catch (IOException e) {
			LOG.error("{}",
					new Object[] { " Exception in flusihing data to output File = " + OUTPUT_FILE,
							e.getMessage(), e });
		} finally {
			try {
				fileWriter.close();
			} catch (IOException e) {
				LOG.error("{}", new Object[] { " Exception in closing output File = " + OUTPUT_FILE,
						e.getMessage(), e });
			}
		}
		LOG.debug("{}",
				new Object[] { " writing processed data to output File sucessful ", OUTPUT_FILE });

	}
}
