package representation;
import java.io.Serializable;

/** classe  Node, représente un nœud du graphe de l’histoire. Il présente une situation au joueur d'apres les differents attributs et methodes 
@author Kezibri Hiba
*/

public abstract class Node implements Event, Serializable {
	
	private String Description;
	private int Id;
	private static int nbr = 1;
	

    
	/**
     * Constructeur avec la description du nœud.
     * @param desc La description du nœud.
     */
    public Node(String desc){
    	this.Description = desc;
        this.Id = nbr++;
    }
	
    //Getters and Setters
    /**
     * Getter Renvoie la description du nœud.
     * @return La description du nœud.
     */
    public String getDescription() {
    	return this.Description;
    }
    
    /**
     * Setter définit la description du nœud.
     * @param desc La nouvelle description du nœud.
     * @return La nouvelle description du nœud.
     */
    public String setDescription(String desc) {
    	return this.Description = desc;	
    }
    
    /**
     * Getter renvoie l'identifiant du nœud.
     * @return L'identifiant du nœud.
     */
    public int getId() {
		return Id;
	}
    
    /** Méthode qui affiche la description du nœud.
	*/
  	public void display() {
  		System.out.println("Description: "+ Description);
  	};
  	
  	/**
     * Méthode abstraite pour choisir le prochain événement ou nœud.
     * @return le prochain événement ou nœud choisi.
     */
  	public abstract Event chooseNext() ;
  	//public abstract Node  chooseNext() ;
  	
    
  	/**
     * Renvoie une représentation sous forme de chaîne de caractères du nœud.
     *
     * @return Une représentation sous forme de chaîne de caractères du nœud.
     */
	 public String toString() {
	        return "Node[id=" + Id + ", description=" + Description + "]";
	 }
    

    
    /**
     * Vérifie si ce nœud est égal à un autre objet.
     * @param obj L'objet à comparer avec ce nœud.
     * @return true si les objets sont égaux, false sinon.
     */
     public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Node node = (Node) obj;
        return Id == node.Id;
    }
    
    

}
