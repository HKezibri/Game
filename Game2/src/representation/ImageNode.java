package representation;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class ImageNode extends NodeDecorator {
	
	private String imagePath;

    public ImageNode(Event decoratedEvent, String imagePath) {
        super(decoratedEvent);
        this.imagePath = imagePath;
    }

    @Override
    public void display() {
        decoratedEvent.display();
        displayImage();
    }

    private void displayImage() {
        ImageIcon icon = new ImageIcon(imagePath);
        JOptionPane.showMessageDialog(null, "", "Image", JOptionPane.INFORMATION_MESSAGE, icon);
    }
}
