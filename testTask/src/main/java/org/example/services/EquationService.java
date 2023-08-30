package org.example.services;

import org.example.model.Equation;

import java.util.List;

public interface EquationService {
    boolean create(Equation equation);
    List<Equation> readAll();
    List<Equation> readAllEquationsWithOneRoot();
    List<Equation> readByRoot(String root);
    List<Equation> readByRoot(String root1, String root2);
}
