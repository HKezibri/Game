package univers;

/**
 * Cette classe représente un chevalier dans le jeu. Un chevalier possède un nom, un niveau,
 * des points de vie. Il peut attaquer, subir des dégâts et se défendre.
 */

public class Chevalier extends PersonnageDeBase implements Combattant {
	
	private String nom;
	private int niveau;
	private int pointsDeVie;
	
	
	/**
     * Constructeur de la classe Chevalier.
     *
     * @param nom Le nom du chevalier.
     * @param niveau Le niveau du chevalier.
     * @param pointsDeVie Les points de vie du chevalier.
     */
	public Chevalier(String nom, int niveau, int pointsDeVie) { 
		 super(nom, niveau, pointsDeVie);
	 }
	 
	/**
     * Méthode générique pour afficher les caractéristiques du chevalier.
     */
	@Override
    public void afficherCaracteristiques() {
        System.out.println("Aventurier : " + this.getNom() +
        				   ", Niveau : " + this.getNiveau() +
        				   ", Points de Vie : " + this.getPointsDeVie()
        				   );
    }
	

	/**
     * Méthode pour infliger des dégâts au chevalier.
     *
     * @param degats Les dégâts infligés au chevalier.
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
    	 int degatsInfliges = degat - defense;

         if (degatsInfliges > 0) {
             System.out.println(nom + " attaque et inflige " + degatsInfliges + " points de dégâts !");
             return true;
         } else {
             System.out.println(nom + " attaque, mais l'ennemi se défend efficacement.");
             return false;
         }
    };
    
    /**
     * Méthode pour effectuer une défense.
     */
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
