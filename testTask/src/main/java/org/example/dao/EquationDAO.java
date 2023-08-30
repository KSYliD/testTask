package org.example.dao;

import org.example.model.Equation;

import java.util.List;

public interface EquationDAO {
    boolean create(Equation equation);
    List<Equation> readAll();
    List<Equation> readAllEquationsWithOneRoot();
    List<Equation> readByRoot(String root);
    List<Equation> readByRoot(String root1, String root2);


}
