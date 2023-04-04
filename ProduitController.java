package produit;

import java.util.ArrayList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class ProduitController {

    @FXML
    private TextField produitNomTextField;

    @FXML
    private TextField produitPrixTextField;

    @FXML
    private TableView<Produit> produitTableView;

    @FXML
    private TableColumn<Produit, String> nomColumn;

    @FXML
    private TableColumn<Produit, Double> prixColumn;

    @FXML
    private void initialize() {
        nomColumn.setCellValueFactory(cellData -> cellData.getValue().nomProperty());
        prixColumn.setCellValueFactory(cellData -> cellData.getValue().prixProperty().asObject());
        updateProduitTableView();
    }

    @FXML
    private void handleAjouterProduit() {
        String nom = produitNomTextField.getText();
        double prix = Double.parseDouble(produitPrixTextField.getText());
        Produit produit = new Produit(nom, prix);
        produitDAO.ajouterProduit(produit);
        updateProduitTableView();
    }

    private void updateProduitTableView() {
        produitTableView.setItems(produitDAO.getProduitList());
    }
}