package FeeCalculator.FeeCalculator;

import org.configuration.CONSTANT;
import org.filereader.CSVFileReader;
import org.filereader.Reader;
import org.filewriter.CSVFileWriter;
import org.filewriter.OutputFileWriter;
import org.processing.Processor;
import org.processing.RuleProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GenericFileProcessorBuilder {
	private static final Logger LOG = LoggerFactory.getLogger(GenericFileProcessorBuilder.class);

	private String INPUT_FILE_TYPE = CONSTANT.INPUT_FILE_TYPE;
	private String OUTPUT_FILE_TYPE = CONSTANT.OUTPUT_FILE_TYPE;
	private Reader reader;
	private Processor processor;
	private OutputFileWriter outputFileWriter;

	public GenericFileProcessor build() {
		LOG.debug("{}", new Object[] { "start of building of GenericFileProcessor " });
		try {
			switch (INPUT_FILE_TYPE) {
			case CONSTANT.CSV:
				this.reader = new CSVFileReader();
				break;
			case CONSTANT.XML:
			case CONSTANT.EXCEL:
			case CONSTANT.PIPEDELIMITED:
			default:

			}

			this.processor = new RuleProcessor();

			switch (OUTPUT_FILE_TYPE) {
			case CONSTANT.CSV:
				outputFileWriter = new CSVFileWriter();
				break;
			case CONSTANT.XML:
			case CONSTANT.EXCEL:
			case CONSTANT.PIPEDELIMITED:
			default:
			}

			LOG.debug("{}", new Object[] { " creation of GenericFileProcessor " });

			return new GenericFileProcessor(reader, processor, outputFileWriter);
		} catch (Exception e) {
			LOG.error("{}", new Object[] { " Exception GenericFileProcessor ", e.getMessage(), e });

		}
		
		return null;

	}

}
