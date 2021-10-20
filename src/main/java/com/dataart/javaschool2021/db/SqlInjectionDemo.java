package com.dataart.javaschool2021.db;

import com.dataart.javaschool2021.db.auth.AuthProcessor;
import com.dataart.javaschool2021.db.auth.HibernateAuthProcessor;
import com.dataart.javaschool2021.db.auth.PreparedStatementAuthProcessor;
import com.dataart.javaschool2021.db.auth.StatementAuthProcessor;

import java.util.Scanner;

public class SqlInjectionDemo {
    public static void main(String[] args) {
        AuthProcessor authProcessor =
//                new StatementAuthProcessor();
//         new PreparedStatementAuthProcessor();
         new HibernateAuthProcessor();

        String loggedUser = null;

        do {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.print("Username: ");
                String userName = scanner.nextLine();
                System.out.print("Password: ");
                String password = scanner.nextLine();

                loggedUser = authProcessor.performLogin(userName, password);
                if (loggedUser != null) {
                    System.out.printf("Hello, %s\n", loggedUser);
                } else {
                    System.out.println("Failed!!!");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } while (loggedUser == null);
    }
}
