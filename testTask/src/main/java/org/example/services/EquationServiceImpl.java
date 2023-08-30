package org.example.services;

import org.example.dao.EquationDAO;
import org.example.model.Equation;

import java.util.List;

public class EquationServiceImpl implements EquationService {

    private final EquationDAO equationDAO;

    public EquationServiceImpl(EquationDAO equationDAO) {
        this.equationDAO = equationDAO;
    }


    @Override
    public boolean create(Equation equation) {
        if (Validator.toValidate(equation.getEquation()))
            return equationDAO.create(equation);
        return false;
    }

    @Override
    public List<Equation> readAll() {
        return equationDAO.readAll();
    }

    @Override
    public List<Equation> readAllEquationsWithOneRoot() {
        return equationDAO.readAllEquationsWithOneRoot();
    }

    @Override
    public List<Equation> readByRoot(String root) {
        return equationDAO.readByRoot(root);
    }

    @Override
    public List<Equation> readByRoot(String root1, String root2) {
        return equationDAO.readByRoot(root1, root2);
    }
}
