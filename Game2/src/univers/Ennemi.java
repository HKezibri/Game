package univers;

public class Ennemi extends PersonnageDeBase implements Combattant {
	
		 // Attributs
		 private String nom;
		 private int force, defense;
		 private int pointsDeVie;
		
		 // Constructeur
		 public Ennemi(String nom, int force, int pointsDeVie) {
		     super(nom, 1, pointsDeVie); 
		     this.nom = nom;
		     this.force = force;
		     this.pointsDeVie = pointsDeVie;
		 }
		 
		 /**
	     * Méthode pour effectuer une attaque.
	     *
	     * @param degat   Les dégâts infligés par l'attaque.
	     * @param defense La valeur de défense du personnage attaqué.
	     * @return True si l'attaque réussit, sinon False.
	     */
	    @Override
	    public boolean attaquer(int degat, int defense) {
	        // Implémentation de l'attaque de l'ennemi
	        int degatsInfliges = force - defense;

	        if (degatsInfliges > 0) {
	            System.out.println(nom + " attaque et inflige " + degatsInfliges + " points de dégâts !");
	            return true;
	        } else {
	            System.out.println(nom + " attaque, mais le personnage se défend efficacement.");
	            return false;
	        }
	    }
		
		 @Override
		 // Méthode pour infliger des dégâts au personnage
		 public void subirDegats(int degats) {
		     pointsDeVie -= degats;
		     if (pointsDeVie <= 0) {
		    	 System.out.println(nom + " a été vaincu !");
		     }
		 }
		 
		 @Override
	     public void defendre() {
	      	System.out.println(nom + " se met en position de défense !");
	     };
	     
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
		
		
		
		 @Override
		 public void afficherCaracteristiques() {
		     System.out.println("Ennemi : " + nom + ", Force : " + force + ", Points de Vie : " + pointsDeVie);
		 }
		 
		 
		 public int getForce(){
			 return force;
		 }
		 
		 public int getDefense(){
			 return defense;
		 }
		 
		 
}



