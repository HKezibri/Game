package play;

import univers.*;
import java.util.Scanner;
import representation.*;

public class Main {
    public static Player player;
    public static boolean isRunning;
    public static Scanner scanner = new Scanner(System.in);
    public static Node act1;
    public static Node act2;
    public static Node act3;
    public static Node act4;
    public static Node finalAct;

    public static void main(String[] args) {
        // Initialize enemies
        Ennemi AnimalSauvage = new Ennemi("Animal Sauvage", 5, 30);
        Ennemi dragon = new Ennemi("Dragon", 20, 15);
        Ennemi goblin = new Ennemi("Goblin", 8, 30);
        Ennemi anaconda = new Ennemi("Anaconda", 5, 30);
        Ennemi loup = new Ennemi("Loup", 5, 30);

        // Initialize decision nodes
        DecisionNode act1 = new DecisionNode("Vous commencez le jeu pour la recherche du cristale. Vous trouvez une carte détaillée.", new InnerNode("Vous prenez la carte"), new InnerNode("Continuer sans carte"), false, loup);
        DecisionNode act2 = new DecisionNode("Deux chemins s'offrent à vous : ", new InnerNode("Vous pénétrez dans la forêt sombre."),  new InnerNode("Vous découvrez une grotte mystérieuse."), false, goblin);
        DecisionNode act3 = new DecisionNode("Ooh il y a un golin devant vous. Vous allez faire quoi? ", new InnerNode("Vous décidez d'affronter le goblin."),  new InnerNode("Vous essayez de passer/defendre"), true, goblin);
        DecisionNode act4 = new DecisionNode("Vous avez survécu à la première épreuve. Vous pénétrez dans la forêt sombre.", new InnerNode("Vous traversez le vieux pont."), new InnerNode("Vous décidez de nager à travers la rivière."), false, anaconda);
        DecisionNode act5 = new DecisionNode("Shuut! Un dragon endormi dans quelques metres", new InnerNode("Vous décidez d'affronter le dragon féroce."), new InnerNode("Vous essayez de passer furtivement devant le dragon."), true, dragon);
        DecisionNode act6 = new DecisionNode("Quelques kilometre encore pour atteindre l'objectif. Continuer?", new TerminalNode("Vous atteignez le sommet de la montagne et accomplissez votre quête."), new TerminalNode("Vous entrez dans la salle du trône et découvrez le cristal perdu."), false, dragon);
      

      
        // Start the game
        startGame();
    }

	public static int readUserChoice(String prompt, int choixUser) {
	    int input;
	    do {
	        System.out.println(prompt);
	        try {
	            input = Integer.parseInt(scanner.next());
	        } catch (Exception e) {
	            input = -1;
	            System.out.println("Entrez svp un entier");
	        } finally {
	            scanner.nextLine(); // Consume the newline character
	        }

	    } while (input < 1 || input > choixUser);

	    return input;
	}
	//methode pour netoyer la console
	public static void clearConsole() {
		for(int i = 0; i < 100; i++ ) {
			System.out.println();
		}
	}

	//methode pour print un separateur
	public static void printSeparator(int n) {
		for(int i = 0; i < n; i++)
			System.out.print("*");
		System.out.println();	
	}
	
	//methode pour stoper game jusqu'a le user entre qlq chose
	public static void anythingToContinue() {
		System.out.println("Taper qlq chose pour continuer..");
		scanner.next();	
	}
	
	public static void characterInfo() {
	        // Afficher les informations sur le personnage
	        clearConsole();
	        printSeparator(40);
	        printSeparator(30);
	        System.out.println("DESCRIPTION PERSONNAGE ");
	        player.afficherCaracteristiques();
	        printSeparator(20);
	        anythingToContinue();
	 }

	 public static void printMenu() {
	        // Afficher le menu principal
	        clearConsole();
	        printSeparator(40);
	        printSeparator(30);
	        System.out.println("Choisir une action : ");
	        printSeparator(20);
	        System.out.println("(1) Continuer l'histoire");
	        System.out.println("(2) Description du personnage");
	        System.out.println("(3) Quitter ");
	 }
    public static void startGame() {
        boolean flag = false;
        String Name;
        clearConsole();
        printSeparator(40);
        printSeparator(30);
        System.out.println("LA QUÊTE DU CRISTAL PERDU");
        System.out.println("=== Histoire ===");
        System.out.println("L'histoire se déroule dans un monde médiéval fantastique où la magie et l'aventure règnent en maîtres. \nLe royaume est menacé par l'obscurité,"
        		+ "et le joueur incarne un jeune aventurier en quête du légendaire \"Cristal Perdu\", \nune relique magique qui pourrait sauver le royaume de la destruction.");
        printSeparator(40);
        printSeparator(30);
        anythingToContinue();

        do {
            clearConsole();
            printSeparator(30);
            System.out.println("C'est quoi votre nom?");
            Name = scanner.next();
            printSeparator(30);
            clearConsole();
            printSeparator(30);
            System.out.println("Bienvenu " + Name + ".\nVous voulez garder ce nom?");
            System.out.println("(1) Oui!");
            System.out.println("(2) Non, je veux le changer");
            int input = readUserChoice("-> ", 2);
            if (input == 1) {
                flag = true;
            }

        } while (!flag);

        player = new Player(Name, 80,50);
        isRunning = true;
        while (isRunning) {
            // Afficher le menu principal
            printMenu();
            int choice = readUserChoice("-> ", 3);

            switch (choice) {
                case 1:
                    continueJourney();
                    break;
                case 2:
                    // Afficher les informations sur le personnage
                    characterInfo();
                    break;
                case 3:
                    // Quitter le jeu
                    isRunning = false;
                    System.out.println("Au revoir !");
                    break;
            }
        }
    }

  
    public static void combatWithEnemy(Ennemi enemy) {
        // Combat
        while (player.estVivant() && enemy.estVivant()) {
            // Afficher les options de combat
            System.out.println("Que voulez-vous faire ?");
            System.out.println("1. Attaquer");
            System.out.println("2. Défendre");
            int combatChoice = readUserChoice("-> ", 2);

            switch (combatChoice) {
                case 1:
                    // Attaque du joueur
                    player.attaquer(enemy.getForce(), enemy.getDefense());
                    // Attaque de l'ennemi
                    if (enemy.estVivant()) {
                        enemy.attaquer(player.getForce(), player.getDefense());
                    }
                    break;
                case 2:
                    // Défense du joueur
                    player.defendre();
                    // Attaque de l'ennemi réduite
                    if (enemy.estVivant()) {
                        enemy.attaquer(player.getForce(), player.getDefense() + 5);
                    }
                    break;
            }
        }

        if (player.estVivant()) {
            System.out.println("Vous avez vaincu l'ennemi !");
        } else {
            System.out.println("Vous avez été vaincu par l'ennemi. Fin du jeu.");
            isRunning = false;
        }
    }
    public static void continueJourney() {
    	clearConsole();
	    printSeparator(40);
	    printSeparator(30);
	    System.out.println("L'aventure continue...");
	
	    // Assuming you have a variable to track the current decision node
	    Node currentDecision = act1;
	
	    while (currentDecision instanceof DecisionNode) {
	        DecisionNode currentDecisionNode = (DecisionNode) currentDecision;
	
	        // Display the current decision and options
	        System.out.println(currentDecisionNode.getDescription());
	        System.out.println("(1) " + currentDecisionNode.getOutcome1().getDescription());
	        System.out.println("(2) " + currentDecisionNode.getOutcome2().getDescription());
	
	        // Get the user's choice
	        int choice = readUserChoice("-> ", 2);
	
	        // Update the current decision based on the user's choice
	        if (choice == 1) {
	            currentDecision = currentDecisionNode.getOutcome1();
	        } else {
	            currentDecision = currentDecisionNode.getOutcome2();
	        }
	
	        // Check if there's an enemy in the current decision
	        if (currentDecision instanceof DecisionNode && ((DecisionNode) currentDecision).getHasCombat() == true) {
	            Ennemi enemy = ((DecisionNode) currentDecision).getEnemy();
	            combatWithEnemy(enemy);
	        }
	    }
	
	    // Check if it's a terminal node
	    if (currentDecision instanceof TerminalNode) {
	        System.out.println(((TerminalNode) currentDecision).getDescription());
	        isRunning = false;  // End the game
	    }
	
	    anythingToContinue();
	}	
}
