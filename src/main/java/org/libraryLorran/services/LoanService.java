package org.libraryLorran.services;

import org.libraryLorran.model.Book;
import org.libraryLorran.model.Loan;
import org.libraryLorran.model.Member;

import java.util.ArrayList;
import java.util.List;

public class LoanService {
    List<Loan> loans = new ArrayList<>();

    public void loanBook(Member member, Book book) {
        loans.add(new Loan(member, book));
        System.out.println("Empréstimo realizado com sucesso.");
    }

    public boolean returnBook(Member member, Book book) {
        if (verifyExistMember(member) && verifyExistBook(book)) {
            loans.removeIf(loan -> loan.getMember().equals(member) && loan.getBook().equals(book));
            return true;
        }
        return false;
    }

    public boolean verifyExistMember(Member member) {
        if (!member.getName().isBlank() && member.getName().contains(member.getName())) {
            return true;
        }
        return false;
    }

    public boolean verifyExistBook(Book book) {
        if (!book.getTitle().isBlank() && book.getTitle().contains(book.getTitle())) {
            return true;
        }
        return false;
    }
}
