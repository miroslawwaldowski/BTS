
public class BtsPoint {

	private double x;
	private double y;
	private int name;
	
	public double getX () {return x;}
	public double getY () {return y;}
	public int getName () {return name;}
	
	public void setX (double X) {this.x = X;}
	public void setY (double Y) {this.y = Y;}
	public void setName (int Name) {this.name = Name;}
	
	public BtsPoint(double X,double Y, int Name) {
		this.x = X;
		this.y = Y;	
		this.name = Name;
	}
	
	public BtsPoint(double Z) {
		this.x = Z;
		this.y = Z;	
	}
}
