package org.filereader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.configuration.CONSTANT;
import org.model.Transaction;

public class CSVFileReader implements Reader {
	Map<Long/* date */ , List<Transaction>> transactionListbyDate = new TreeMap<Long, List<Transaction>>();

	public void open() {
		// Reader filereader = new FileReader(Constant.INPUT_FILE_LOCATION);

	}

	public void read() {
		// TODO Auto-generated method stub
		String line = "";
		String cvsSplitBy = ",";
		try {
			BufferedReader br = new BufferedReader(new FileReader(CONSTANT.INPUT_FILE_DIRECTORY + CONSTANT.INPUT_FILE_NAME));
			String header = br.readLine();
			while ((line = br.readLine()) != null) {
				String[] data = line.split(",");
				String pattern = "dd/MM/yyyy";
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

				Date date = null;
				try {
					date = simpleDateFormat.parse(data[4]);

				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Transaction.Builder builder = new Transaction.Builder(data[0], data[1], data[2], data[3],
						date.getTime(), data[5]);
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
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Map<Long/* date */ , List<Transaction>> getTransactionListbyDate() {
		return transactionListbyDate;
	}

	public void close() {
		// TODO Auto-generated method stub

	}

}
