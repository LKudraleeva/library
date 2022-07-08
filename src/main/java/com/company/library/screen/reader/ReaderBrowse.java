package com.company.library.screen.reader;

import io.jmix.ui.screen.*;
import com.company.library.entity.Reader;

@UiController("Reader.browse")
@UiDescriptor("reader-browse.xml")
@LookupComponent("readersTable")
public class ReaderBrowse extends StandardLookup<Reader> {
}