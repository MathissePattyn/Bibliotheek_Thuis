package be.vives.ti.ui;

import be.vives.ti.model.User;
import be.vives.ti.service.Bibliotheek;

import java.sql.SQLOutput;
import java.util.Scanner;

public abstract class UserMenu {
    protected User user;
    protected Bibliotheek bib;
    protected Scanner scanner;

    public UserMenu(User user, Bibliotheek bib, Scanner scanner) {
        this.user = user;
        this.bib = bib;
        this.scanner = scanner;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Bibliotheek getBib() {
        return bib;
    }

    public void setBib(Bibliotheek bib) {
        this.bib = bib;
    }

    public abstract void showMenu();

    public void addBoek(){
        System.out.println("Gelieve een Isbn nummer in te geven");
        String isbn = scanner.nextLine();
        bib.addBoekViaIsbn(isbn);
    }

    public void verwijderBoek(){
        System.out.println("Gelieve een Isbn nummer in te geven");
        String isbn = scanner.nextLine();
        bib.verwijderBoekViaISBN(isbn);
    }

    public void getDetailsBoek(){
        System.out.println("Gelieve een isbn nummer in te geven");
        String isbn = scanner.nextLine();
        System.out.println(bib.getDetailsVanBoek(isbn));
    }
}
