package org.example.model;

public class Equation {
    private final String equation;
    private String root1;
    private String root2;

    public Equation(String equation, String root1, String root2) {
        this.equation = equation;
        this.root1 = root1;
        this.root2 = root2;
    }

    public Equation(String equation, String root1) {
        this.equation = equation;
        this.root1 = root1;
    }

    public Equation(String equation) {
        this.equation = equation;
    }

    public String getEquation() {
        return equation;
    }

    public String getRoot1() {
        return root1;
    }

    public String getRoot2() {
        return root2;
    }

    @Override
    public String toString() {
        if (root2 == null && root1==null) {
            return "equation = " + equation + '\n';
        } else if(root2==null){
            return "equation = " + equation +", root1 = " + root1 + '\n';
        }
        return "equation = " + equation + ", root1 = " + root1 +", root2 = " + root2 + '\n';
    }
}
