package org.filewriter;

import java.util.Set;

import org.model.ProcessingFee;

public interface OutputFileWriter {
    void write(final Set<ProcessingFee> feeproclist);
}
