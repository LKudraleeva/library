package com.company.library.screen.library;

import io.jmix.ui.screen.*;
import com.company.library.entity.Library;

@UiController("Library.browse")
@UiDescriptor("library-browse.xml")
@LookupComponent("librariesTable")
public class LibraryBrowse extends StandardLookup<Library> {
}