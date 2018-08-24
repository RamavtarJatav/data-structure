package FeeCalculator.FeeCalculator;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.configuration.CONSTANT;
import org.filereader.CSVFileReader;
import org.filereader.Reader;
import org.filewriter.CSVFileWriter;
import org.filewriter.OutputFileWriter;
import org.model.ProcessingFee;
import org.model.Transaction;
import org.processing.Processor;
import org.processing.RuleProcessor;

/**
 * Hello world!
 *
 */
public class App {

	public static void main(String[] args) {

		String fileType = CONSTANT.INPUT_FILE_TYPE;
		Map<Long/* date */ , List<Transaction>> transactionListbyDate = null;
		switch (fileType) {
		case "CSV":
			Reader reader = new CSVFileReader();
			reader.read();
			transactionListbyDate = reader.getTransactionListbyDate();
			break;

		case "XML":
		case "EXCEL":
		case "PIPEDELIMIED":
		default:

		}

		Processor processor = new RuleProcessor();
		processor.process(transactionListbyDate);
		Set<ProcessingFee> feeprocessingList = processor.getProcessedData();

		switch (CONSTANT.OUTPUT_FILE_TYPE) {
		case "CSV":
			OutputFileWriter writer = new CSVFileWriter();
			writer.write(feeprocessingList);
			break;

		case "XML":
		case "EXCEL":
		case "PIPEDELIMIED":
		default:
		}

	}
}
