package org.filewriter;

import java.util.List;

import org.model.ProcessingFee;

public interface OutputFileWriter {
    void write(List<ProcessingFee> feeproclist);
}
