package org.filewriter;

import java.util.Map;
import org.model.ProcessingFee;
/*
 * output file writer interface
 */

public interface OutputFileWriter {
    void write(final Map<ProcessingFee, Double> feeproclist);
}
