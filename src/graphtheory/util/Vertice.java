package graphtheory.util;

public class Vertice {
	 private double x;
	    private double y;
	    private int id;

	    public Vertice(int id, double x, double y) {
	        this.x = x;
	        this.y = y;
	        this.id = id;
	    }

	    public double getX() {
	        return x;
	    }

	    public void setX(int x) {
	        this.x = x;
	    }

	    public double getY() {
	        return y;
	    }

	    public void setY(int y) {
	        this.y = y;
	    }

	    public int getId() {
	        return id;
	    }

	    public void setId(int id) {
	        this.id = id;
	    }
	    
	    /**
	     * @param u
	     * @param v
	     * @return double
	     */
	    public static double DistanciaEntre2Vertices(Vertice u, Vertice v) {
	        return (double) Math.sqrt(Math.pow(u.getX() - v.getX(), 2) + Math.pow(u.getY() - v.getY(), 2));
	    }

		@Override
		public String toString() {
			return "Vertice [x=" + x + ", y=" + y + ", id=" + id + "]";
		}
	    
	    
	    
	    
}
