package representation;

import java.util.ArrayList;
import play.*;
import java.util.List;
import java.util.Scanner;

public class InnerNode extends Node {
    private List<Node> nextNodes;
    
    
    /**
     * Construit un InnerNode avec la description donnée.
     * @param description la description du InnerNode.
     */
    public InnerNode(String description) {
        super(description);
        this.nextNodes = new ArrayList<>();
    }

    /**
     * Construit un InnerNode avec la description donnée et une liste de nœuds suivants.
     *
     * @param description la description du InnerNode.
     * @param nxtNodes la liste des nœuds suivants.
     */
    public InnerNode(String description, List<Node> nxtNodes) {
        super(description);
        this.nextNodes = nxtNodes;
    }

    /**
     * Ajoute un nœud à la liste des nœuds suivants.
     * @param nextNode le nœud à ajouter à la liste.
     */
    public void addNextNode(Node nextNode) {
        nextNodes.add(nextNode);
    }

    
    /**
     * Permet à l'utilisateur de choisir le prochain nœud parmi les options disponibles.
     * @return le nœud choisi par l'utilisateur.
     */
    @Override
    public Node chooseNext() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Vous êtes dans le nœud interne : " + getDescription());
        System.out.println("Voici les options disponibles :");

        for (int i = 0; i < nextNodes.size(); i++) {
            System.out.println((i + 1) + ". " + nextNodes.get(i).getDescription());
        }

        // Check if there is an integer available to read
        if (scanner.hasNextInt()) {
            int choix = scanner.nextInt();

            if (choix >= 1 && choix <= nextNodes.size()) {
                return nextNodes.get(choix - 1);
            } else {
                System.out.println("Choix invalide. Revenez au nœud actuel.");
                return this;
            }
        } else {
            System.out.println("Entrée invalide. Revenez au nœud actuel.");
            return this;
        }
    }
    
    /**
     * Définit le prochain nœud en remplaçant la liste des nœuds suivants par un seul nœud.
     * @param nextNode le nœud à définir comme le prochain nœud.
     */
    public void setNextNode(Node nextNode) {
        nextNodes.clear();
        nextNodes.add(nextNode);
    }
    /*@Override
    public Event chooseNext() {
        System.out.println("Voici les options disponibles :");
        for (int i = 0; i < nextNodes.size(); i++) {
            System.out.println((i + 1) + ". " + nextNodes.get(i).getDescription());
        }

        int userChoice = Main.readUserChoice("-> ", nextNodes.size());

        // Ensure the user's choice is within the valid range
        if (userChoice >= 1 && userChoice <= nextNodes.size()) {
            return nextNodes.get(userChoice - 1);
        } else {
            System.out.println("Choix invalide. Fin du jeu.");
            Main.isRunning = false;
            return null;
        }
    }*/
    
    /**
     * Renvoie une représentation sous forme de chaîne de caractères du InnerNode.
     * @return Une représentation sous forme de chaîne de caractères du InnerNode.
     */
    @Override
    public String toString() {
        return "InnerNode[id=" + getId() + ", description=" + getDescription() + "]";
    }
    
    
    /**
     * Vérifie si ce InnerNode est égal à un autre objet.
     * @param obj l'objet à comparer avec ce InnerNode.
     * @return true si les objets sont égaux, false sinon.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        InnerNode innerNode = (InnerNode) obj;
        return getId() == innerNode.getId();
    }
}
