package org.example.services;

import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

    public static boolean toValidate(String equation) {
        return (isValidEquation(equation) &&
                isValidParentheses(equation) &&
                hasConsecutiveOperators(equation) &&
                validateEdgeOperators(equation));
    }

    private static boolean isValidParentheses(String equation) {
        Stack<Character> stack = new Stack<>();

        for (char c : equation.toCharArray()) {
            if (c == '=' && !stack.isEmpty()) {
                return false;
            }
            if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                if (stack.isEmpty() || stack.pop() != '(') {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    private static boolean isValidEquation(String expression) {
        String regex = "^[x\\d+\\-/*().]+={1}[x\\d+\\-/*().]+$";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(expression);

        return matcher.find();
    }

    private static boolean hasConsecutiveOperators(String expression) {
        String regex = "[+*/-][+*/]";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(expression);
        return !matcher.find();
    }

    public static boolean validateEdgeOperators(String expression) {
        expression = expression.replace("(", "");
        expression = expression.replace(")", "");
        String[] partsOfEquation = expression.split("=");
        return hasEdgeOperators(partsOfEquation[0]) && hasEdgeOperators(partsOfEquation[1]);
    }

    private static boolean hasEdgeOperators(String partOfEquation) {
        char[] expressionCharArray = partOfEquation.toCharArray();
        if (expressionCharArray[0] == '+' || expressionCharArray[0] == '*' || expressionCharArray[0] == '/') {
            return false;
        }
        return expressionCharArray[expressionCharArray.length - 1] != '+' &&
                expressionCharArray[expressionCharArray.length - 1] != '*' &&
                expressionCharArray[expressionCharArray.length - 1] != '/' &&
                expressionCharArray[expressionCharArray.length - 1] != '-';
    }

    public static boolean rootValidate(String root) {
        String regex = "^-?\\d+.{1}\\d+$";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(root);

        return matcher.find();
    }

}
