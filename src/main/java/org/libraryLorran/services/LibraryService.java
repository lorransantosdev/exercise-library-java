package org.libraryLorran.services;


import org.libraryLorran.model.Book;
import org.libraryLorran.model.Member;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class LibraryService {
    List<Book> books = new ArrayList<>();
    List<Member> members = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public boolean removeBook(String title) {
        books.removeIf(book -> book.getTitle().equalsIgnoreCase(title));
        return false;
    }

    public void registerMember(Member member) {
        if (members.contains(member)) {
            System.out.println("Este usuário já foi registrado");
        } else {
            members.add(member);
            System.out.println();
        }
    }

    public Optional<Member> findMemberbyId(int memberId) {
        return members.stream()
                .filter(member -> members.contains(member.getMemberId()))
                .findFirst();
    }

    public List<Book> findListAvaliableBooks() {
        return books;
    }


}
