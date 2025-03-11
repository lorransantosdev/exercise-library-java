package org.libraryLorran;

import org.libraryLorran.controller.LibraryController;
import org.libraryLorran.services.LibraryService;
import org.libraryLorran.services.LoanService;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class App {
    public static void main(String[] args) {
        LibraryService libraryService = new LibraryService();
        LoanService loanService = new LoanService();
        LibraryController controller = new LibraryController(libraryService, loanService);
        controller.start();
        System.out.println("Sistema encerrado.");
    }
}