package org.filereader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.configuration.CONSTANT;
import org.model.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CSVFileReader implements Reader {
	private static final Logger LOG = LoggerFactory.getLogger(CSVFileReader.class);

	private String INPUT_FILE = CONSTANT.INPUT_FILE_DIRECTORY + CONSTANT.INPUT_FILE_NAME;
	private String INPUT_FILE_DATEFORMAT = CONSTANT.INPUT_FILE_DATE_FORMAT;
	private String csvSplitBy = ",";
	private Map<Long/* date */ , List<Transaction>> transactionListbyDate = new TreeMap<Long, List<Transaction>>();

	public void read() {
		LOG.debug("{}", new Object[] { " Input File reading start" });
		String line = "";

		try (BufferedReader br = new BufferedReader(new FileReader(INPUT_FILE))) {

			// Skiping header
			br.readLine();

			while ((line = br.readLine()) != null) {
				
				/*
                 * data[0] = ExternalId;
                 * data[1] = clientId;
                 * data[2] = securityId;
                 * data[3] = transaction type i.e. withdraw, deposit, sell , buy
                 * data[4] = date format i.e. MM/dd/yyyy
                 * data[5] = market value
                 * data[6] = priority flag i.e high priority(Y) , normal priority(n);
                 */
				String[] data = line.split(csvSplitBy);
                 
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat(INPUT_FILE_DATEFORMAT);
				Date date = null;
				try {
					date = simpleDateFormat.parse(data[4]);
				} catch (ParseException e) {
					LOG.error("{}", new Object[] { "Parsing date exception dateformat = " + INPUT_FILE_DATEFORMAT });
				}
                
				Transaction.Builder builder = new Transaction.Builder(data[0], data[1], data[2], data[3],
						date.getTime(), Double.parseDouble(data[5]));
				builder.setPriorityFlag(data[6]);
				Transaction transaction = builder.build();

				List<Transaction> transactionList = transactionListbyDate.get(transaction.getDate());

				if (transactionList == null) {
					List<Transaction> translist = new ArrayList<Transaction>();
					translist.add(transaction);
					transactionListbyDate.put(transaction.getDate(), translist);
				} else {
					transactionList.add(transaction);
				}
			}

			LOG.debug("{}", new Object[] { " input File reading successful", INPUT_FILE });

		} catch (Exception e) {
			LOG.error("{}",
					new Object[] { "reading input file exception = " + INPUT_FILE_DATEFORMAT, e.getMessage(), e });

		}
	}

	public Map<Long/* date */ , List<Transaction>> getTransactionListbyDate() {
		return Collections.unmodifiableMap(transactionListbyDate);
	}

}
