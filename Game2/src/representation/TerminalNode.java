package representation;

/*@author Kezibri Hiba*/

public class TerminalNode extends Node{
	
	
	/**
     * Constructeur de TerminalNode avec la description donnée.
     * @param description La description du TerminalNode.
     */
	 public TerminalNode(String description) {
	        super(description);
	 }
	 
	 
	 /**
     * La méthode chooseNext choisit le nœud terminal qui est dans ce cas le même objet.
     * @return un nœud terminal ne mène nulle part, il renvoie simplement lui-même.
     */
	 @Override
	 public Node chooseNext() {
	        return this;
	    }
	 
	 /**
     * Renvoie une représentation sous forme de chaîne de caractères du TerminalNode.
     * @return une représentation sous forme de chaîne de caractères du TerminalNode.
     */
	 @Override
	 public String toString() {
        return "TerminalNode[id=" + getId() + ", description=" + getDescription() + "]";
	 }

	 /**
     * Vérifie si ce TerminalNode est égal à un autre objet.
     * @param obj l'objet à comparer avec ce TerminalNode.
     * @return true si les objets sont égaux, false sinon.
     */
    @Override
	 public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        TerminalNode terminalNode = (TerminalNode) obj;
        return getId() == terminalNode.getId();
	 }

}
