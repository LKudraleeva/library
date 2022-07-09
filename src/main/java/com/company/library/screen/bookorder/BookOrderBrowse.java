package com.company.library.screen.bookorder;

import io.jmix.ui.screen.*;
import com.company.library.entity.BookOrder;

@UiController("BookOrder.browse")
@UiDescriptor("book-order-browse.xml")
@LookupComponent("bookOrdersTable")
public class BookOrderBrowse extends StandardLookup<BookOrder> {
}