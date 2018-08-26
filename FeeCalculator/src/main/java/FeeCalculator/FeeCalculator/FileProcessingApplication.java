package FeeCalculator.FeeCalculator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileProcessingApplication {
	private static final Logger LOG = LoggerFactory.getLogger(FileProcessingApplication.class);


	public static void main(String[] args) {
		LOG.debug("{}", new Object[] { "Starting of application" });

		GenericFileProcessorBuilder GenericFileProcessorBuilder = new GenericFileProcessorBuilder();
		GenericFileProcessor genericFileProcessor = GenericFileProcessorBuilder.build();
		genericFileProcessor.process();
		
		LOG.debug("{}", new Object[] { "Shutting Down application" });


	}
}
