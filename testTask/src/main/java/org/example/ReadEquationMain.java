package org.example;

import org.example.dao.EquationDAOImpl;
import org.example.services.EquationServiceImpl;

import java.util.Scanner;
 class ReadEquationMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Оберіть операцію для пошуку(1/2/3): ");
        System.out.println("1.Переглянути усі рівняння;");
        System.out.println("2.Переглянути усі рівняння з одним коренем;");
        System.out.println("3.Пошук за коренем.");
        int searchRequest = scanner.nextInt();
        String root1;
        String root2;

        switch (searchRequest) {
            case 1 -> System.out.println(new EquationServiceImpl(new EquationDAOImpl()).readAll());
            case 2 -> System.out.println(new EquationServiceImpl(new EquationDAOImpl()).readAllEquationsWithOneRoot());
            case 3 -> {
                System.out.println("Ви б хотіли б ввести 1 чи два корені?(1/2)");
                int rootsNumber = scanner.nextInt();
                if (rootsNumber == 1) {
                    System.out.println("Введіть заданий корінь: ");
                    scanner = new Scanner(System.in);
                    root1 = scanner.nextLine();
                    System.out.println(new EquationServiceImpl(new EquationDAOImpl()).readByRoot(root1));
                } else if (rootsNumber == 2) {
                    scanner = new Scanner(System.in);
                    System.out.println("Введіть перший корінь: ");
                    root1 = scanner.nextLine();
                    System.out.println("Введіть другий корінь: ");
                    root2 = scanner.nextLine();
                    System.out.println(new EquationServiceImpl(new EquationDAOImpl()).readByRoot(root1, root2));
                }
            }
        }
    }
}
