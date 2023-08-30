package org.example.services;

import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

    public static boolean toValidate(String equation){
        return (isValidEquation(equation) &&
                isValidParentheses(equation) &&
                hasConsecutiveOperators(equation));
    }

    public static boolean isValidParentheses(String equation) {
        Stack<Character> stack = new Stack<>();

        for (char c : equation.toCharArray()) {
            if(c=='=' && !stack.isEmpty()){
                return false;
            }
            if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                if (stack.isEmpty() || stack.pop() != '(' ) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    public static boolean isValidEquation(String expression){
        String regex = "^[x\\d+\\-/*().]+={1}[x\\d+\\-/*().]+$";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(expression);

        return matcher.find();
    }

    public static boolean hasConsecutiveOperators(String expression) {
        String regex = "[+*/-][+*/]";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(expression);
        return !matcher.find();
    }

}
