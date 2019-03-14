public class BtsEdge {

	private BtsPoint startPoint;
	private BtsPoint endPoint;
	
	public BtsPoint getStartPoint () {return startPoint;}
	public BtsPoint getEndPoint () {return endPoint;}
	
	public void setStartPoint (BtsPoint X) {this.startPoint = X;}
	public void setEndPoint (BtsPoint Y) {this.endPoint = Y;}
	
	public BtsEdge(BtsPoint S,BtsPoint E) {
		this.startPoint = S;
		this.endPoint = E;	
	}
}
