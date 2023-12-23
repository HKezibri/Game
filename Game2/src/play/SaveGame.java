package play;
import java.io.*;
import representation.Node;

public class SaveGame {
	
	 public static void saveGame(Node currentNode, String fileName) {
	        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
	            oos.writeObject(currentNode);
	            System.out.println("Partie sauvegardée avec succès.");
	        } catch (IOException e) {
	            e.printStackTrace();
	            System.out.println("Erreur lors de la sauvegarde de la partie.");
	        }
	    }

	    public static Node loadGame(String fileName) {
	        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
	            Node loadedNode = (Node) ois.readObject();
	            System.out.println("Partie chargée avec succès.");
	            return loadedNode;
	        } catch (IOException | ClassNotFoundException e) {
	            e.printStackTrace();
	            System.out.println("Erreur lors du chargement de la partie.");
	            return null;
	        }
	    }

}
