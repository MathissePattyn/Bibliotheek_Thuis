package be.vives.ti.ui;

import be.vives.ti.model.User;
import be.vives.ti.service.Bibliotheek;

import java.util.Scanner;

public class LidMenu extends UserMenu{
    public LidMenu(User user, Bibliotheek bib, Scanner scanner) {
        super(user, bib, scanner);
    }

    @Override
    public void showMenu() {

    }
}
