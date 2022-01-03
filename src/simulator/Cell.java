package simulator;

public class Cell {
    private int row, column;
    private boolean alive;

    public Cell(int row, int column) {
        this.row = row;
        this.column = column;
        alive = false;
    }

    public void changeState() {
        if(alive) {alive = false;} else {alive = true;}
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public boolean isAlive() {
        return alive;
    }
}
