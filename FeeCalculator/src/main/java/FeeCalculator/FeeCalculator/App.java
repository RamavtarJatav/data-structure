package FeeCalculator.FeeCalculator;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import org.compartor.TransactionDateComparator;
import org.configuration.Constant;
import org.configuration.TransactionTypeSupported;
import org.model.ProcessingFee;
import org.model.Transaction;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {

		Map<Long/* date */ , List<Transaction>> transactionListbyDate = new TreeMap<Long, List<Transaction>>();
		List<ProcessingFee> report = new ArrayList<ProcessingFee>();
		String line = "";
		String cvsSplitBy = ",";
		try {
			BufferedReader br = new BufferedReader(new FileReader(Constant.INPUT_FILE_LOCATION));
			try {
				String header = br.readLine();

				while ((line = br.readLine()) != null) {
					String[] data = header.split(",");
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

				// transaction processor
				for (Map.Entry<Long, List<Transaction>> entrySet : transactionListbyDate.entrySet()) {
					long time = entrySet.getKey();
					List<Transaction> trlst = entrySet.getValue();
					int n = trlst.size();
					Transaction tr = trlst.get(0);
					ProcessingFee pr = new ProcessingFee(tr.getClientId(), tr.getTransactionType(), tr.getDate(),
							tr.getPriorityFlag());

					if (tr.getPriorityFlag().equals("Y")) {
						pr.setProcessingFee(500);
					} else if (tr.getPriorityFlag().equals("N")) {
						if (tr.getTransactionType().equals("DEPOSIT")) {
							pr.setProcessingFee(50);
						} else if (tr.getTransactionType() == "WITHDRAW") {
							pr.setProcessingFee(100);
						} else if (tr.getTransactionType() == "SELL") {
							pr.setProcessingFee(100);
						} else if (tr.getTransactionType() == "BUY") {
							pr.setProcessingFee(50);
						}
					} else {
						// invalid transaction
					}

					for (int i = 1; i < n; i++) {
						tr = trlst.get(i);
						pr = new ProcessingFee(tr.getClientId(), tr.getTransactionType(), tr.getDate(),
								tr.getPriorityFlag());
						boolean intraday = false;

						for (int j = i - 1; j >= 0; j--) {
							Transaction trpre = trlst.get(j);
							if (tr.getTransactionType() == "BUY" && trpre.getTransactionType() == "SELL"
									&& (tr.getClientId().equals(trpre.getClientId()))
									&& tr.getSecurityId().equals(trpre.getSecurityId())) {
								intraday = true;
								break;
							} else if (tr.getTransactionType() == "SELL" && trpre.getTransactionType() == "BUY"
									&& (tr.getClientId().equals(trpre.getClientId()))
									&& tr.getSecurityId().equals(trpre.getSecurityId())) {
								intraday = true;
								break;
							}

						}
						if (intraday) {
							pr.setProcessingFee(10);
							intraday = false;
							continue;
						}

						if (tr.getPriorityFlag().equals("Y")) {
							pr.setProcessingFee(500);
						} else if (tr.getPriorityFlag().equals("N")) {
							if (tr.getTransactionType().equals("DEPOSIT")) {
								pr.setProcessingFee(50);
							} else if (tr.getTransactionType() == "WITHDRAW") {
								pr.setProcessingFee(100);
							} else if (tr.getTransactionType() == "SELL") {
								pr.setProcessingFee(100);
							} else if (tr.getTransactionType() == "BUY") {
								pr.setProcessingFee(50);
							}
						} else {
							// invalid transaction
						}

					}

				}
				final String COMMA_DELIMITER = ",";

				final String NEW_LINE_SEPARATOR = "\n";

				for (ProcessingFee processingFee : report) {
					FileWriter fileWriter = null;
					try {
						fileWriter = new FileWriter(Constant.OUTPUT_FILE_LOCATION);
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

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
