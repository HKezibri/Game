package representation;

public class NodeDecorator implements Event {
	
	protected Event decoratedEvent;

	/**
     * Constructeur de NodeDecorator.
     * @param decoratedEvent l'event à décorer.
     */
    public NodeDecorator(Event decoratedEvent) {
        this.decoratedEvent = decoratedEvent;
    }

    /**
     * Affiche l'event décoré.
     */
    @Override
    public void display() {
        decoratedEvent.display();
    }

    /**
     * Permet de choisir le prochain event à partir de l'event décoré.
     * @return le prochain event choisi.
     */
    @Override
    public Event chooseNext() {
        return decoratedEvent.chooseNext();
    }
	
}
