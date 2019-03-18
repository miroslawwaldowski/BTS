import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

public class Bts {

	public static double citySize;	//promien
	public static int btsQuantity;
	public static double btsRange;	//promien	
	public static double x,y,minY,maxY;
	public static int name;
	
	public static List<BtsPoint> BtsList = new ArrayList<BtsPoint>();
	public static List<BtsEdge> EdgeList = new ArrayList<BtsEdge>();
	
	public static void calculation() {
		
		BtsList.clear();
		EdgeList.clear();
		
		for (int i=0;i<btsQuantity;i++) {
			
			x =(Math.random()*2*citySize);			
			minY=citySize-Math.sqrt((citySize*citySize)-((x-citySize)*(x-citySize)));
			maxY=citySize+Math.sqrt((citySize*citySize)-((x-citySize)*(x-citySize)));
			y = minY + (Math.random() * ((maxY - minY)));
			name = i+1;
			BtsPoint point = new BtsPoint(x, y,name);
			BtsList.add(point);
		}
		
		for (int i=0;i<BtsList.size();i++) {
			for (int k=i+1;k<BtsList.size();k++) {
				double distance = Math.sqrt( Math.pow((BtsList.get(i).getX()-BtsList.get(k).getX()), 2) + Math.pow((BtsList.get(i).getY()-BtsList.get(k).getY()), 2));

				if (distance<=(2*btsRange)){
					BtsEdge edge = new BtsEdge(BtsList.get(i), BtsList.get(k));
					EdgeList.add(edge);
				}			
			}
		}
		System.out.println(BtsList.size());	
		System.out.println(EdgeList.size());
	}
	
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				new MainWindow();
			}
		});
	}
}
