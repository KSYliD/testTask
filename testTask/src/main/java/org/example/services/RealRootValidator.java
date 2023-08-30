package org.example.services;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class RealRootValidator {
    public static boolean checkOneRoot(String equation, String root) {
        if (Validator.rootValidate(root)) {
            String[] partsOfEquation = equation.split("=");
            Expression expression1 = new ExpressionBuilder(partsOfEquation[0])
                    .variables("x")
                    .build()
                    .setVariable("x", Double.parseDouble(root));

            Expression expression2 = new ExpressionBuilder(partsOfEquation[1])
                    .variables("x")
                    .build()
                    .setVariable("x", Double.parseDouble(root));
            double result = expression1.evaluate();
            double result1 = expression2.evaluate();

            return result == result1;
        } else return false;
    }

    public static boolean checkTwoRoots(String equation, String root1, String root2) {
        return checkOneRoot(equation, root1) && checkOneRoot(equation, root2);
    }
}
