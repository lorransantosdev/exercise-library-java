package org.libraryLorran.controller;

import org.libraryLorran.model.Book;
import org.libraryLorran.services.LibraryService;
import org.libraryLorran.services.LoanService;

import java.util.Scanner;

public class LibraryController {
    private final LibraryService libraryService;
    private final LoanService loanService;
    private final Scanner scanner;

    public LibraryController(LibraryService libraryService, LoanService loanService) {
        this.libraryService = libraryService;
        this.loanService = loanService;
        this.scanner = new Scanner(System.in);
    }

    public String askTitleBook() {
        return scanner.nextLine();
    }

    public void start() {
        boolean runningSystem = true;
        while (runningSystem) {
            showMenu();
            int option = scanner.nextInt();
            switch (option) {
                case 1 -> addBook();
                case 2 -> removeBook();
            }
        }
    }

    public void showMenu() {
        System.out.println("\n=== Sistema Biblioteca ===");
        System.out.println("1. Adicionar Livro");
        System.out.println("2. Remover Livro");
        System.out.println("3. Registrar Membro");
        System.out.println("4. Realizar Empréstimo");
        System.out.println("5. Devolver Livro");
        System.out.println("6. Listar Livros Disponíveis");
        System.out.println("7. Sair");
        System.out.print("Escolha uma opção: ");
    }

    public void addBook() {
        System.out.println("Digite o title do livro");
        String title = askTitleBook();
        System.out.println("Digite o autor do livro");
        String author = scanner.nextLine();
        System.out.println("Digite o ISBN do livro");
        int isbn = scanner.nextInt();
        libraryService.addBook(new Book(title, author, isbn));
    }

    public void removeBook() {
        System.out.println("Insira o titulo do livro para remove-lo");
        String title = askTitleBook();
        if (libraryService.removeBook(title)) {
            System.out.println("Livro: " + title + " removido com sucesso");
        } else {
            System.out.println("Há alguma formação errada, confira a lista de livros.");
            libraryService.findListAvaliableBooks();
        }
    }


}
