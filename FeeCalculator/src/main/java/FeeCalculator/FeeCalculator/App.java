package FeeCalculator.FeeCalculator;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import org.compartor.TransactionDateComparator;
import org.configuration.Constant;
import org.model.Transaction;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		
        Set<Transaction> listTransaction = new TreeSet<Transaction>(new TransactionDateComparator());
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
					Transaction.Builder builder = new Transaction.Builder(data[0], data[1], data[2], data[3], date.getTime(),
							data[5]);
					builder.setPriorityFlag(data[6]);
					Transaction  transaction = builder.build();
					
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
