package edu.ccrm;

import edu.ccrm.cli.Menu;

public class CCRMApp {
    public static void main(String[] args) {
        System.out.println("Welcome to Campus Course & Records Manager (CCRM)");
        Menu menu = new Menu();
        menu.start();
    }
}
