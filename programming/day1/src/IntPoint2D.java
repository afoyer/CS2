public class IntPoint2D implements IIntPoint2D {
    int x;
    int y;
    public IntPoint2D(int _x, int _y){
        x = _x;
        y = _y;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public int manhattanDistance(IIntPoint2D o){
        return Math.abs(x- o.getX()) + Math.abs(y- o.getY());
    }
    public double distance(IIntPoint2D o){
        double total = (Math.pow(x-o.getX(), 2)) + (Math.pow(y - o.getY(), 2));
        return Math.sqrt(total);
    }
    public String toString(){
        String coord = "(" + x + "," + y + ")";
        return coord;
    }
    public boolean equals(IntPoint2D o){
        return x == o.getX() && y == o.getY();
    }
    public int hashcode(){
        return (x<<16)+y;
    }
}
//Hello!
