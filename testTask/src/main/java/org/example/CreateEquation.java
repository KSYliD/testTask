package org.example;

import org.example.dao.EquationDAOImpl;
import org.example.model.Equation;
import org.example.services.EquationServiceImpl;
import org.example.services.RealRootValidator;
import org.example.services.Validator;

import java.util.Scanner;

public class CreateEquation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть математичне рівняння: ");
        String equation = scanner.nextLine();
        if (equation.isEmpty()) {
            System.out.println("Ви нічого не ввели!");
        } else if (!Validator.toValidate(equation)) {
            System.out.println("Введене рівняння хибне");
        } else {
            System.out.println("Чи бажаєте Ви ввести корні рівняння?(Так/Ні): ");
            String answer = scanner.nextLine();
            if (answer.equalsIgnoreCase("Так")) {
                System.out.println("Ви бажаєте ввести 1 чи 2 корні?(1/2): ");
                int numberOfRoots = scanner.nextInt();
                if (numberOfRoots == 1) {
                    System.out.println("Введіть корінь рівняння: ");
                    scanner = new Scanner(System.in);
                    String root1 = scanner.nextLine();
                    if (RealRootValidator.checkOneRoot(equation, root1)) {
                        if (new EquationServiceImpl(new EquationDAOImpl()).create(new Equation(equation, root1))) {
                            System.out.println("Рівняння успішно додано до бази");
                        } else System.out.println("Щось пішло не так...");
                    }else System.out.println("Неправильно заданий корінь, перезапустіть програму та спробуйте ще");
                } else if (numberOfRoots == 2) {
                    scanner = new Scanner(System.in);
                    System.out.println("Введіть перший корінь рівняння: ");
                    String root1 = scanner.nextLine();
                    System.out.println("Введіть другий корінь рівняння: ");
                    String root2 = scanner.nextLine();
                    if (RealRootValidator.checkTwoRoots(equation, root1, root2)) {
                        if (new EquationServiceImpl(new EquationDAOImpl()).create(new Equation(equation, root1, root2))) {
                            System.out.println("Рівняння успішно додано до бази");
                        } else System.out.println("Щось пішло не так...");
                    }else System.out.println("Неправильно заданий корінь, перезапустіть програму та спробуйте ще");
                } else System.out.println("Некоректні дані, перезапустіть програму та спробуйте ще раз");
            } else if (answer.equalsIgnoreCase("Ні")) {
                new EquationServiceImpl(new EquationDAOImpl()).create(new Equation(equation));
            } else System.out.println("Ваша відповідь некоректна!");
        }
    ReadEquation.read();
    }
}