package com.company.library.screen.library;

import io.jmix.ui.screen.*;
import com.company.library.entity.Library;

@UiController("Library.edit")
@UiDescriptor("library-edit.xml")
@EditedEntityContainer("libraryDc")
public class LibraryEdit extends StandardEditor<Library> {
}