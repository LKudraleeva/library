package com.company.library.screen.bookorder;

import com.company.library.entity.Book;
import com.company.library.entity.BookOrder;
import com.company.library.entity.Library;
import io.jmix.ui.Notifications;
import io.jmix.ui.component.DataGrid;
import io.jmix.ui.component.HasValue;
import io.jmix.ui.component.data.datagrid.ContainerDataGridItems;
import io.jmix.ui.model.CollectionContainer;
import io.jmix.ui.screen.*;
import org.springframework.beans.factory.annotation.Autowired;

@UiController("BookOrder.edit")
@UiDescriptor("book-order-edit.xml")
@EditedEntityContainer("bookOrderDc")
public class BookOrderEdit extends StandardEditor<BookOrder> {
    @Autowired
    private DataGrid<Book> booksDataGrid;

    @Autowired
    private CollectionContainer<Book> bookDc;

    @Autowired
    private Notifications notifications;


    @Subscribe
    public void onInit(InitEvent event) {
        booksDataGrid.setItems(new ContainerDataGridItems<>(bookDc));
    }

    @Subscribe("libraryField")
    public void onLibraryFieldValueChange(HasValue.ValueChangeEvent<Library> event) {
        if(event.getValue() != null) {
            bookDc.setItems(event.getValue().getBooks());
            booksDataGrid.setItems(new ContainerDataGridItems<>(bookDc));
            booksDataGrid.repaint();

            notifications.create()
                    .withCaption("Books Updated")
                    .show();
        }
    }

    @Subscribe("booksDataGrid")
    public void onTableSelectEventSelection(DataGrid.SelectionEvent<Book> event) {
        notifications.create()
                .withCaption("bebebebebbe")
                .show();

        //todo добавление книги в список, далее на нажатие кнопки ок передача в сервис, и там создание формуляров и добавление в бд
    }

    @Subscribe
    public void onBeforeCommitChanges(BeforeCommitChangesEvent event) {
        //todo здесь вызов метода сервиса для массива книг, добавить все проверика на null и empty (Collections.isEmpty)
    }

}