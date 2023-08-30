package org.example.dao;

import org.example.model.Equation;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EquationDAOImpl implements EquationDAO {

    static final String DATABASE_URL = "jdbc:mysql://localhost:3306/testtask";
    static final String USER = "springstudent";
    static final String PASSWORD = "springstudent";

    @Override
    public boolean create(Equation equation) {
        String createSQL = "INSERT INTO `testtask`.`equation` (`Equation`, `root1`, `root2`) VALUES (?, ?, ?);";
        try (Connection con = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
             PreparedStatement ps = con.prepareStatement(createSQL)) {
            ps.setString(1, equation.getEquation());
            ps.setString(2, equation.getRoot1());
            ps.setString(3, equation.getRoot2());
            int result = ps.executeUpdate();
            if(result > 0) return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Equation> readAll() {
        String readSQL = "SELECT * FROM testtask.equation;";
        return getEquations(readSQL);
    }

    @Override
    public List<Equation> readAllEquationsWithOneRoot() {
        String readSQL = "SELECT * FROM testtask.equation WHERE root2 is null AND root1 is not null;";
        return getEquations(readSQL);
    }

    private List<Equation> getEquations(String readSQL) {
        List<Equation> result = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(readSQL)) {

            createEquationFormResultSet(result, rs);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }


    @Override
    public List<Equation> readByRoot(String root) {
        String readSQL = "SELECT * FROM testtask.equation WHERE root1 = ?";
        List<Equation> result = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
             PreparedStatement ps = connection.prepareStatement(readSQL)) {
            ps.setString(1, root);
            getEquationFromResultSet(result, ps);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Equation> readByRoot(String theRoot1, String theRoot2) {
        String readSQL = "SELECT * FROM testtask.equation WHERE root1 = ? AND root2= ?";
        List<Equation> result = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
             PreparedStatement ps = connection.prepareStatement(readSQL)) {
            ps.setString(1, theRoot1);
            ps.setString(2, theRoot2);
            getEquationFromResultSet(result, ps);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    private void getEquationFromResultSet(List<Equation> result, PreparedStatement ps) throws SQLException {
        try (ResultSet rs = ps.executeQuery()) {
            createEquationFormResultSet(result, rs);
        }
    }

    private void createEquationFormResultSet(List<Equation> result, ResultSet rs) throws SQLException {
        while (rs.next()) {
            String equation = rs.getString(2);
            String root1 = rs.getString(3);
            String root2 = rs.getString(4);

            if (root1 != null && root2 != null) {
                result.add(new Equation(equation, root1, root2));
            } else if (root1 != null) {
                result.add(new Equation(equation, root1));
            } else {
                result.add(new Equation(equation));
            }
        }
    }

}