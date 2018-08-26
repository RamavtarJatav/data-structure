package FeeCalculator.FeeCalculator;

import java.util.List;
import java.util.Map;

import org.filereader.Reader;
import org.filewriter.OutputFileWriter;
import org.model.ProcessingFee;
import org.model.Transaction;
import org.processing.Processor;

/*
 * the Gerneric file processr read the input file and read it and process it according to rule book.
 *  and generate reuqired output file.
 */
public class GenericFileProcessor {

	private  Reader reader;
	private  Processor processor;
	private  OutputFileWriter outputFileWriter;

	public GenericFileProcessor(Reader reader, Processor processor, OutputFileWriter outputFileWriter) {
		this.reader = reader ;
		this.processor = processor;
		this.outputFileWriter = outputFileWriter;

	}
	
	void process() {
		reader.read();
		Map<Long/* date */ , List<Transaction>> transactionListbyDate = reader.getTransactionListbyDate();
		processor.process(transactionListbyDate);
		Map<ProcessingFee, Double>  feeprocessingList = processor.getProcessedData();
		outputFileWriter.write(feeprocessingList);
		
	}
}
