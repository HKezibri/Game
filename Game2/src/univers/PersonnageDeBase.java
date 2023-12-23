package univers;


//Classe abstraite représentant le personnage de base
public abstract class PersonnageDeBase {
	
	 // Attributs communs à tous les personnages de base
	 private String nom;
	 private int niveau,pointsDeVie;
	
	 // Constructeur pour initialiser les attributs
	 public PersonnageDeBase(String nom, int niveau, int pointsDeVie) {
	     this.nom = nom;
	     this.niveau = niveau;
	     this.pointsDeVie = pointsDeVie;
	 }
	 
	// Méthode générique pour afficher les caractéristiques du personnage
    public void afficherCaracteristiques() {
        System.out.println("Nom : " + nom + ", Niveau : " + niveau + ", Points de Vie : " + pointsDeVie);
    }
	
	 

	 // Méthodes getters et setters pour accéder et modifier les attributs
	 public String getNom() {
	     return nom;
	 }
	
	 public void setNom(String nom) {
	     this.nom = nom;
	 }
	
	 public int getNiveau() {
	     return niveau;
	 }
	
	 public void setNiveau(int niveau) {
	     this.niveau = niveau;
	 }
	
	 public int getPointsDeVie() {
	     return pointsDeVie;
	 }
	
	 public void setPointsDeVie(int pointsDeVie) {
	     this.pointsDeVie = pointsDeVie;
	 }
}

