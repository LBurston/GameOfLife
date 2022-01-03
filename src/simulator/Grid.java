package simulator;

public class Grid {

    private int width, height;
    private Cell[][] grid;

    public Grid(int width, int height) {
        this.width = width;
        this.height = height;
        grid = new Cell[width][height];
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
    //    public void clear() {
//        for(int row = 0; row < height; row++) {
//            for(int column = 0; column < width; column++) {
//
//            }
//        }
//    }

}
