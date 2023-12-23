package representation;

import java.util.List;
import java.util.Random;
import java.util.ArrayList;

/**
 * Représente un nœud dans un arbre de décision introduisant un élément de chance.
 * Le ChanceNode peut avoir plusieurs nœuds suivants, et le nœud suivant est choisi de manière aléatoire.
 *
 * @author Kezibri Hiba
 */

public class ChanceNode extends InnerNode {

	private List<Node> nextNodes;
	
	 /**
     * Construit un ChanceNode avec la description donnée.
     * @param description La description du ChanceNode.
     */
    public ChanceNode(String description) {
        super(description);
        this.nextNodes = new ArrayList<>();
    }
    
    /**
     * Méthode setter définit la liste des nœuds suivants pour ce ChanceNode.
     * @param nextNodes La liste des nœuds suivants à définir.
     */
    public void setNextNodes(List<Node> nextNodes) {
        this.nextNodes = nextNodes;
    }
    
    /**
     * Méthode getter Renvoie la liste des nœuds suivants pour ce ChanceNode.
     * @return La liste des nœuds suivants.
     */
    public List<Node> getNextNodes() {
        return nextNodes;
    }

    
    /**
     * Méthode choisit et renvoie le prochain nœud de manière aléatoire parmi la liste des nœuds suivants.
     * @return Le prochain nœud choisi de manière aléatoire.
     */
    @Override
    public Node chooseNext() {
        Random rand = new Random();

        if (nextNodes.isEmpty()) {
            System.out.println("Aucun nœud suivant disponible.");
            return null; // Ou lancer une exception pour indiquer l'absence de nœud suivant
        }

        int choix = rand.nextInt(nextNodes.size());
        return nextNodes.get(choix);
    }
    
    /**
     * Méthode renvoie une représentation sous forme de chaîne de caractères du ChanceNode.
     * @return Une représentation sous forme de chaîne de caractères du ChanceNode.
     */
    @Override
    public String toString() {
        return "ChanceNode[id=" + getId() + ", description=" + getDescription() + "]";
    }

    /**
     * Méthode vérifie si ce ChanceNode est égal à un autre objet.
     * @param obj L'objet à comparer avec ce ChanceNode.
     * @return true si les objets sont égaux, false sinon.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        ChanceNode chanceNode = (ChanceNode) obj;
        return getId() == chanceNode.getId();
    }
}
