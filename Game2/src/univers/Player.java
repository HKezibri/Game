package univers;

import play.*;

/**
 * La classe Player représente un joueur dans le jeu.
 * Elle étend la classe PersonnageDeBase et implémente l'interface Combattant.
 */

public class Player extends PersonnageDeBase implements Combattant{
	
	protected PersonnageDeBase personnageChoisi;
	
	private String nom;
	private int niveau, force, defense;
	private int pointsDeVie;
	
	
	/**
     * Constructeur de la classe Player.
     *
     * @param nom Le nom du joueur.
     */
	public Player(String nom, int force, int defense) {
		super(nom, 1, 100);
		this.defense = defense;
		this.force = force;
		this.nom = nom;
		choisirAction();
	}
	
	/**
     * Méthode pour choisir une arme pour le joueur.
     *
     * @return L'arme choisie par le joueur.
     */
    public Arme choisirArme() {
    	
    	int user_input = Main.readUserChoice("Choisissez une arme pour l'Aventurier :\n" +
                "1. Épée\n" +
                "2. Arc\n" +
                "3. Bâton\n" +
                "4. Dague", 4);

        switch (user_input) {
            case 1:
                return Arme.EPPE;
            case 2:
                return Arme.ARC;
            case 3:
                return Arme.BATON;
            case 4:
                return Arme.DAGUE;
            default:
                System.out.println("Choix d'arme invalide. Retour au Chevalier.");
                return Arme.EPPE; // Par défaut, le Chevalier utilise une épée
        }
    }


    /**
     * Méthode pour choisir le personnage du joueur.
     */
    public void choisirAction() {

        int user_input = Main.readUserChoice("Choisissez votre personnage :\n" +
                "1. Chevalier\n" +
                "2. Aventurier\n" +
                "3. Alchimiste\n", 3);

        switch (user_input) {
            case 1:
                System.out.println("Vous avez choisi le Chevalier.");
                personnageChoisi = new Chevalier("NomChevalier", 1, 100);
                break;
            case 2:
                System.out.println("Vous avez choisi l'Aventurier.");
                Arme armeAventurier = choisirArme();
                personnageChoisi = new Aventurier("NomAventurier", 1, 100, armeAventurier);
                break;
            case 3:
                System.out.println("Vous avez choisi l'Alchimiste.");
                personnageChoisi = new Alchimiste("NomAlchimiste", 1, 100);
                break;
            default:
                System.out.println("Choix invalide.");
                //gestion d'erreur ici
                break;
        }

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
    
    //Getters and Setters
    
    /**
     * Renvoie le nom du joueur.
     * @return Le nom du joueur.
     */
    public String getNom() {
        return nom;
    }
    
    /**
     * Renvoie le niveau du joueur.
     * @return le niveau du joueur.
     */
    public int getNiveau() {
        return niveau;
    }

    /**
     * Renvoie PointsDeVie du joueur.
     * @return PointsDeVie du joueur.
     */
    public int getPointsDeVie() {
        return pointsDeVie;
    }
    
    /**
     * Renvoie la force du joueur.
     * @return la force du joueur.
     */
	 public int getForce(){
		 return force;
	 }
	 
    /**
     * Renvoie le defense du joueur.
     * @return le defense du joueur.
     */
	 public int getDefense(){
		 return defense;
	 }
	 
	 /**
     * Affiche les caractéristiques du joueur.
     */
    public void afficherCaracteristiques() {
        System.out.println("Nom : " + getNom()+ ", Force : " + getForce() + ", Defense : " + getDefense());
    }
    
    
	    
	   
	   

}
