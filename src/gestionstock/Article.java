package gestionstock;

public class Article {
    
    private String codeBarres;
    private String nom;
    private int quantiteInitiale;
    private int quantiteEntree;
    private int quantiteSortie;

    public Article(String codeBarres, String nom, int quantiteInitiale) {
        this.codeBarres = codeBarres;
        this.nom = nom;
        this.quantiteInitiale = quantiteInitiale;
        this.quantiteEntree = 0;
        this.quantiteSortie = 0;
    }
    
    public String getCodeBarres(){
        return codeBarres;
    }

    public String getNom() {
        return nom;
    }

    public int getQuantiteInitiale() {
        return quantiteInitiale;
    }

    public int getQuantiteEntree() {
        return quantiteEntree;
    }

    public int getQuantiteSortie() {
        return quantiteSortie;
    }
    
    public void setCodeBarres(String codeBarres) {
        this.codeBarres = codeBarres;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setQuantiteInitiale(int quantiteInitiale) {
        this.quantiteInitiale = quantiteInitiale;
    }

    public void setQuantiteEntree(int quantiteEntree) {
        this.quantiteEntree = quantiteEntree;
    }

    public void setQuantiteSortie(int quantiteSortie) {
        this.quantiteSortie = quantiteSortie;
    }
    
    public static void main(String[] args) {
    	Article a = new Article("1","p1",1);
    	System.out.println(a.getNom());
    }
   
}
