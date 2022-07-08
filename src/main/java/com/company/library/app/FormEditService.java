package com.company.library.app;

import com.company.library.entity.*;
import io.jmix.core.DataManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

@Service
public class FormEditService {
    @Autowired
    private DataManager dataManager;


    //дата выдачи книги до даты возвращения
    public boolean incorrectDates(LocalDate startDate, LocalDate endDate){
        return endDate.isBefore(startDate);
    }


    public boolean alreadyTakeBook(Reader reader, Book book, LocalDate issuanceDate, LocalDate returnDate){
        List<Form> formsList = reader.getForms();
        for (Form f:formsList){
            if(book.getLibrary().equals(f.getBook().getLibrary())){
                if((issuanceDate.isAfter(f.getIssuanceDate()) && returnDate.isBefore(f.getReturnDate())) ||
                        (issuanceDate.isAfter(f.getIssuanceDate()) && issuanceDate.isBefore(f.getReturnDate())) ||
                        (returnDate.isAfter(f.getIssuanceDate()) && returnDate.isBefore(f.getReturnDate())) ||
                        (issuanceDate.isBefore(f.getIssuanceDate()) && returnDate.isAfter(f.getReturnDate()))){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean hasTheSameBook(Reader reader, Book book, LocalDate issuanceDate, LocalDate returnDate){
        List<Form> formsList = reader.getForms();
       for (Form f:formsList){
           if(book.getAuthor().equals(f.getBook().getAuthor()) && book.getTitle().equals(f.getBook().getTitle())) {
               if((issuanceDate.isAfter(f.getIssuanceDate()) && returnDate.isBefore(f.getReturnDate())) ||
                       (issuanceDate.isAfter(f.getIssuanceDate()) && issuanceDate.isBefore(f.getReturnDate())) ||
                       (returnDate.isAfter(f.getIssuanceDate()) && returnDate.isBefore(f.getReturnDate())) ||
                       (issuanceDate.isBefore(f.getIssuanceDate()) && returnDate.isAfter(f.getReturnDate()))){
                   return true;
               }
           }
       }
       return false;
    }

    //возвращает случайного сотрудника библиотеки
    public Worker findWorkerFromLibrary(Library library) {
        List<Worker> workerList = library.getWorkers();
        Random rand = new Random();
        return workerList.get(rand.nextInt(workerList.size()));
    }

}