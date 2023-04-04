package produit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProduitDAO {

    private Connection connection;

    public ProduitDAO(Connection connection) {
        this.connection = connection;
    }

    public void ajouterProduit(Produit produit) {
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO produits (nom, prix) VALUES (?, ?)");
            statement.setString(1, produit.getNom());
            statement.setDouble(2, produit.getPrix());
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public List<Produit> getProduitList() {
        List<Produit> produits = new ArrayList<>();
        try {
            ResultSet rs = connection.createStatement().executeQuery("SELECT * FROM produits");
            while (rs.next()) {
                Produit produit = new Produit();
                produit.setId(rs.getInt("id"));
                produit.setNom(rs.getString("nom"));
                produit.setPrix(rs.getDouble("prix"));
                produits.add(produit);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return produits;
    }

    public void supprimerProduit(Produit produit) {
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "DELETE FROM produits WHERE id = ?");
            statement.setInt(1, produit.getId());
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}