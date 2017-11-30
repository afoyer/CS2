public class IntGrid2D implements IIntGrid2D{
    private int upleftx;
    private int uplefty;
    private int downrightx;
    private int downrighty;
    int width;
    int height;
    private char[][] grid;


    public IntGrid2D(int ulx, int uly, int drx, int dry, char fill ){
        upleftx = ulx;
        uplefty = uly;
        downrightx = drx;
        downrighty = dry;
        if (ulx < 0 && drx > 0){
            width = Math.abs(ulx) + drx + 1;

        }
        if (uly > 0 && dry < 0){
            height = Math.abs(dry) + uly + 1;
        }
        else{
            width = Math.abs(ulx) +Math.abs(drx);
            height = Math.abs(uly) + Math.abs(drx);
        }
        grid = new char[width][height];
        System.out.println(width);
        System.out.println(height);
        for (int i = 0; i < grid.length; i++){
            for (int j = 0 ; j < grid.length; j++){
                grid[i][j] = fill;
            }
        }
    }
    public void setPoint(IIntPoint2D p, char v){
        grid[p.getX()+ Math.abs(upleftx)][-(p.getY())+Math.abs(uplefty)] = v;

    }
    public char getPoint(IIntPoint2D p){
        return grid[p.getX()+ Math.abs(upleftx)][-(p.getY())+Math.abs(uplefty)];
    }
    public IIntPoint2D getUpperLeftCorner(){
        return new IntPoint2D(upleftx, uplefty);
    }
    public IIntPoint2D getLowerRightCorner(){
        return new IntPoint2D(downrightx, downrighty);
    }
}
