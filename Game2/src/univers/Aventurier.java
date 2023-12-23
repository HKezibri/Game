package univers;

/**
 * Cette classe représente un aventurier dans le jeu. Un aventurier possède un nom, un niveau,
 * des points de vie et une arme. Il peut attaquer, subir des dégâts et se défendre.
 */

public class Aventurier extends PersonnageDeBase implements Combattant{
	
	private Arme arme; // L'arme que possède l'aventurier.
	private String nom;
	private int niveau;
	private int pointsDeVie;
	
	 /**
     * Constructeur de la classe Aventurier.
     *
     * @param nom Le nom de l'aventurier.
     * @param niveau Le niveau de l'aventurier.
     * @param pointsDeVie Les points de vie de l'aventurier.
     * @param arme L'arme de l'aventurier.
     */	
	 public Aventurier(String nom, int niveau, int pointsDeVie, Arme arme) { 
		 super(nom, niveau, pointsDeVie);
		 this.arme = arme;
	 }
	 
	 /**
     * Méthode générique pour afficher les caractéristiques du chevalier.
     */
	@Override
    public void afficherCaracteristiques() {
        System.out.println("Aventurier : " + this.getNom() +
        				   ", Niveau : " + this.getNiveau() +
        				   ", Points de Vie : " + this.getPointsDeVie() +
        				   "Force de l'arme : " +arme.getForce());
    }
	

	 /**
     * Méthode pour infliger des dégâts à l'aventurier.
     *
     * @param degats Les dégâts infligés à l'aventurier.
     */
    public void subirDegats(int degats) {
        pointsDeVie -= degats;
        if (pointsDeVie <= 0) {
        	System.out.println(nom + " Vous êtes vaincu !");
        }
    }
    
    /**
     * Méthode pour vérifier si l'aventurier est vivant.
     *
     * @return True si l'aventurier est vivant, sinon False.
     */
    @Override
    public boolean estVivant() {
    	if (pointsDeVie > 0) {
	        return true;
	    } else {
	        return false;
	    }
    };
    
    
    /**
     * Méthode pour effectuer une attaque.
     *
     * @param degat Les dégâts infligés par l'attaque.
     * @param defense La valeur de défense de l'ennemi.
     * @return True si l'attaque réussit, sinon False.
     */
    @Override
	public boolean attaquer(int degat, int defense) {
    	int degatsInfliges = arme.getForce() - defense;

        if (degatsInfliges > 0) {
            System.out.println(nom + " attaque et inflige " + degatsInfliges + " points de dégâts !");
            return true;
        } else {
            System.out.println(nom + " attaque, mais l'ennemi se défend efficacement.");
            return false;
        }
    };
    
    @Override
    public void defendre() {
    	System.out.println(nom + " se met en position de défense !");
    };
    
    // Getter pour le champ "niveau"
    public int getNiveau() {
        return niveau;
    }

    // Setter pour le champ "niveau"
    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }
    
	
	


}
