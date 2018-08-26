package org.filewriter;

import java.util.Map;
import java.util.Set;

import org.model.ProcessingFee;

public interface OutputFileWriter {
    void write(final Map<ProcessingFee, Double> feeproclist);
}
