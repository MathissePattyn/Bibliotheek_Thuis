package be.vives.ti.ui;

import be.vives.ti.model.User;
import be.vives.ti.service.Bibliotheek;

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
}
