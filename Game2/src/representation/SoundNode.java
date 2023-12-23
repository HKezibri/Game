package representation;
import javax.sound.sampled.*;

public class SoundNode extends NodeDecorator {
	private String soundPath;

    public SoundNode(Event decoratedEvent, String soundPath) {
        super(decoratedEvent);
        this.soundPath = soundPath;
    }

    @Override
    public void display() {
        decoratedEvent.display();
        playSound();
    }

    private void playSound() {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new java.io.File(soundPath));
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
