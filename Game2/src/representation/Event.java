package representation;

public interface Event {
	
	
	 /**
     * Affiche l'event.
     */
	 public void display();
	 
	 /**
     * Permet de choisir le prochain event.
     * @return Le prochain event choisi.
     */
	 public Event chooseNext();
}
