package org.filewriter;


import java.io.FileWriter;
import java.io.IOException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import org.configuration.CONSTANT;
import org.model.ProcessingFee;

public class CSVFileWriter implements OutputFileWriter {

	@Override
	public void write(Set<ProcessingFee> feeproclist) {
		String COMMA_DELIMITER = ",";

		String NEW_LINE_SEPARATOR = "\n";
		FileWriter fileWriter = null;
		try {
			fileWriter = new FileWriter(CONSTANT.OUTPUT_FILE_DIRECTORY);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        
		//feeproclist.sort(new ReportCamparator());
		
		for (ProcessingFee processingFee : feeproclist) {

			try {
				fileWriter.append(processingFee.getClientId());
				fileWriter.append(COMMA_DELIMITER);

				fileWriter.append(processingFee.getTransactionType());
				fileWriter.append(COMMA_DELIMITER);

				Date date = new Date(processingFee.getTransactionDate());
				Format format = new SimpleDateFormat("dd/MM/yyyy");

				fileWriter.append(format.format(date));
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(String.valueOf(processingFee.getProcessingFee()));
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(processingFee.getPriority());
				fileWriter.append(NEW_LINE_SEPARATOR);

			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		try {
			fileWriter.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				fileWriter.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		

	}
}
