package representation;

/*@author Kezibri Hiba*/


import univers.*;
import play.Main;



public class DecisionNode extends InnerNode {

	 private Node Outcome1;
     private Node Outcome2;
     private boolean hasCombat;
     private Ennemi enemy;

     /**
      * Construit un DecisionNode avec la description, les résultats possibles, et les informations sur le combat données.
      * @param description la description du DecisionNode.
      * @param Outcome1 le premier résultat possible.
      * @param Outcome2 le deuxième résultat possible.
      * @param hasCombat indique si un combat est nécessaire.
      * @param enemy l'ennemi impliqué dans le combat.
      */
     public DecisionNode(String description, Node Outcome1, Node Outcome2, boolean hasCombat, Ennemi enemy) {
        super(description);
        this.Outcome1 = Outcome1;
        this.Outcome2 = Outcome2;
        this.hasCombat = hasCombat;
        this.enemy = enemy;
     }
     
     /**
      * Indique si un combat est nécessaire pour ce DecisionNode.
      * @return true si un combat est nécessaire, false sinon.
      */    
     public boolean hasCombat() {
         return false;  //true si un combat est nécessaire pour ce nœud
     }

     /**
      * Permet de choisir le prochain nœud en fonction de la décision de l'utilisateur.
      * @return Le nœud choisi en fonction de la décision de l'utilisateur.
      */
     @Override
     public Node chooseNext() {
    	        
        int choix = Main.readUserChoice("Quelle décision prenez-vous?\n"
        		    + "1. Choisir: " + getOutcome1().getDescription() 
        		    + "\n2. Choisir: " + getOutcome2().getDescription(), 2);
 
        switch (choix) {
            case 1:
                return Outcome1;
            case 2:
                return Outcome2;
            default:
                System.out.println("Choix invalide. Revenez au nœud actuel.");
                return this;
        }
     }
     
     /**
      * Getter renvoie le outcome1 possible.
      * @return le outcome1 possible.
      */
     public Node getOutcome1(){
    	 return Outcome1;
     }
     
     /**
      * Setter définit le outcome1 possible.
      * @param node le nœud à définir comme le outcome1.
      */
     public void setOutcome1(Node node){
    	 this.Outcome1 = node;
     }
     
     /**
      * Setter définit le outcome2 possible.
      * @param node le nœud à définir comme le outcome2.
      */
     public void setOutcome2(Node node){
    	 this.Outcome2 = node;
     }
     /**
      * Getter renvoie le outcome2 possible.
      * @return le outcome2 possible.
      */
     public Node getOutcome2(){
    	 return Outcome2;
     }
     
     /**
      * Getter Indique si un combat est nécessaire pour ce DecisionNode.
      * @return true si un combat est nécessaire, false sinon.
      */
     public boolean getHasCombat() {
         return hasCombat;
     }

     /**
      * Setter Définit si un combat est nécessaire pour ce DecisionNode.
      * @param hasCombat true si un combat est nécessaire, false sinon.
      */
     public void setHasCombat(boolean hasCombat) {
         this.hasCombat = hasCombat;
     }
     
     /**
      * Getter Renvoie l'ennemi impliqué dans le combat, le cas échéant.
      * @return L'ennemi impliqué dans le combat.
      */
     public Ennemi getEnemy() {
         return enemy;
     }
     
     /**
      * Renvoie une représentation sous forme de chaîne de caractères du DecisionNode.
      * @return Une représentation sous forme de chaîne de caractères du DecisionNode.
      */
     @Override
     public String toString() {
         return "DecisionNode[id=" + getId() + ", description=" + getDescription() + "]";
     }

     /**
      * Vérifie si ce DecisionNode est égal à un autre objet.
      * @param obj L'objet à comparer avec ce DecisionNode.
      * @return true si les objets sont égaux, false sinon.
      */
     @Override
     public boolean equals(Object obj) {
         if (this == obj) return true;
         if (obj == null || getClass() != obj.getClass()) return false;
         DecisionNode decisionNode = (DecisionNode) obj;
         return getId() == decisionNode.getId();
     }
     
     
}

