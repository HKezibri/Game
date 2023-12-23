package univers;


// Énumération Arme

public enum Arme {
	
	    EPPE("Épée", 10),
	    ARC("Arc", 8),
	    BATON("Bâton", 6),
	    DAGUE("Dague", 7);

	    // Attributs
	    private final String nom;
	    private final int force;

	    // Constructeur
	    Arme(String nom, int force) {
	        this.nom = nom;
	        this.force = force;
	    }

	    // Méthode pour obtenir le nom de l'arme
	    public String getNom() {
	        return nom;
	    }

	    // Méthode pour obtenir la force de l'arme
	    public int getForce() {
	        return force;
	    }
	

}
