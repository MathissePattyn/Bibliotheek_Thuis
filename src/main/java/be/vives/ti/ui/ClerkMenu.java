package be.vives.ti.ui;

import be.vives.ti.model.Clerk;
import be.vives.ti.model.User;
import be.vives.ti.service.Bibliotheek;

import java.util.Scanner;

public class ClerkMenu extends UserMenu{
    public ClerkMenu(Clerk clerk, Bibliotheek bib) {
        super(clerk, bib);
    }

    @Override
    public void showMenu() {
        Scanner scanner = new Scanner(System.in);
    }
}
