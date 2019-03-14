
public class BtsPoint {

	private double x;
	private double y;
	
	public double getX () {return x;}
	public double getY () {return y;}
	
	public void setX (double X) {this.x = X;}
	public void setY (double Y) {this.y = Y;}
	
	public BtsPoint(double X,double Y) {
		this.x = X;
		this.y = Y;	
	}
	
	public BtsPoint(double Z) {
		this.x = Z;
		this.y = Z;	
	}
}
