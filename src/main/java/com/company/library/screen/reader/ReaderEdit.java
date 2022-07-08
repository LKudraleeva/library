package com.company.library.screen.reader;

import io.jmix.ui.screen.*;
import com.company.library.entity.Reader;

@UiController("Reader.edit")
@UiDescriptor("reader-edit.xml")
@EditedEntityContainer("readerDc")
public class ReaderEdit extends StandardEditor<Reader> {
}