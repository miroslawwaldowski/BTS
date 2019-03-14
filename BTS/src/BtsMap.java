import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

public class BtsMap {

	public static Image BtsMapImage () {
		BufferedImage bufferedImage = new BufferedImage(Panel.WIDTH, Panel.HEIGHT,BufferedImage.TYPE_4BYTE_ABGR );
		Graphics g = bufferedImage.getGraphics();
		
		double factor = Panel.WIDTH / (2*Bts.citySize); 
		int IntImageCitySize = (int)(factor*Bts.citySize);
		int IntImageBtsRange = (int)(factor*Bts.btsRange);
		
		g.setColor(Color.black);
		g.drawOval(0, 0, 2*IntImageCitySize, 2*IntImageCitySize);
		
		for (BtsPoint element : Bts.BtsList) {	
			int x1 = (int)(factor*element.getX());
			int y1 = (int)(factor*element.getY());
			int dotSize = 2;
			g.setColor(Color.RED);
			g.fillRect(x1-dotSize, y1-dotSize, 2*dotSize, 2*dotSize);
			g.setColor(Color.black);
			int x = x1-IntImageBtsRange;
			int y = y1-IntImageBtsRange;
			g.drawOval(x,y,2*IntImageBtsRange,2*IntImageBtsRange);		
		}
		
		for (BtsEdge element : Bts.EdgeList) {
			g.setColor(Color.BLUE);		
			int x1 = (int)(factor*element.getStartPoint().getX());
			int y1 = (int)(factor*element.getStartPoint().getY());
			int x2 = (int)(factor*element.getEndPoint().getX());
			int y2 = (int)(factor*element.getEndPoint().getY());		
			g.drawLine(x1, y1, x2, y2);
		}
		return bufferedImage;
	}
}
