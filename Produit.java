package produit;

public class Produit {
    private String nom;
    private String prix;
public Produit(String nom, String prix)  {
    this.nom = nom;
    this.prix =prix;
}

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrix() {
        return prix;
    }

    public void setPrix(String prix) {
        this.prix = prix;
    }

    @Override
    public String toString() {
        return nom+"        "+prix;
    }
}
