package com.company.library.screen.form;

import com.company.library.app.FormEditService;
import com.company.library.entity.Form;
import io.jmix.ui.Notifications;
import io.jmix.ui.screen.*;
import org.springframework.beans.factory.annotation.Autowired;

@UiController("Form_.edit")
@UiDescriptor("form-edit.xml")
@EditedEntityContainer("formDc")
public class FormEdit extends StandardEditor<Form> {

    @Autowired
    private FormEditService formEditService;

    @Autowired
    private Notifications notifications;

    @Autowired
    private MessageBundle messageBundle;


    @Subscribe
    public void onBeforeCommitChanges(BeforeCommitChangesEvent event) {
        Form form = getEditedEntity();

        form.setWorker(formEditService.findWorkerFromLibrary(form.getBook().getLibrary()));

        if(formEditService.incorrectDates(form.getIssuanceDate(), form.getReturnDate())){
            notifications.create().withCaption(messageBundle.getMessage("formEdit.caption.wrongDates")).show();
            event.preventCommit();
        }else if (formEditService.alreadyTakeBook(form.getReader(),form.getBook(),form.getIssuanceDate(),form.getReturnDate())){
            notifications.create().withCaption(messageBundle.getMessage("formEdit.caption.hasAlreadyTakeBookFromLibrary")).show();
            event.preventCommit();
        }else if(formEditService.hasTheSameBook(form.getReader(), form.getBook(), form.getIssuanceDate(), form.getReturnDate())){
            notifications.create().withCaption(messageBundle.getMessage("formEdit.caption.sameBook")).show();
            event.preventCommit();
        }


    }

}