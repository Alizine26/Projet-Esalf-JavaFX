package login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO {

    // requêtes SQL pour la table login
    private static final String INSERT_SQL = "INSERT INTO login(username, password) VALUES(?, ?)";
    private static final String SELECT_SQL = "SELECT * FROM login WHERE username = ? AND password = ?";

    // connection à la base de données
    private final Connection connection;

    public LoginDAO(Connection connection) {
        this.connection = connection;
    }

    // méthode pour insérer un nouvel enregistrement dans la table login
    public void insert(Login login) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(INSERT_SQL);
        statement.setString(1, login.getUsername());
        statement.setString(2, login.getPassword());
        statement.executeUpdate();
        statement.close();
    }

    // méthode pour vérifier les informations de connexion de l'utilisateur
    public boolean validate(Login login) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(SELECT_SQL);
        statement.setString(1, login.getUsername());
        statement.setString(2, login.getPassword());
        ResultSet resultSet = statement.executeQuery();
        boolean result = resultSet.next();
        resultSet.close();
        statement.close();
        return result;
    }
}