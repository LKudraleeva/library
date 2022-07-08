package com.company.library.screen.form;

import io.jmix.ui.screen.*;
import com.company.library.entity.Form;

@UiController("Form_.browse")
@UiDescriptor("form-browse.xml")
@LookupComponent("formsTable")
public class FormBrowse extends StandardLookup<Form> {
}