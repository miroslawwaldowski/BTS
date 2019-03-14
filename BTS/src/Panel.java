import java.awt.*;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Panel extends JPanel {
	
	public static final int HEIGHT = 550;
    public static final int WIDTH = 550;
	
	public Panel() {
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		this.setBackground(Color.LIGHT_GRAY);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(BtsMap.BtsMapImage (), 0, 0, this);
	}
	
}
