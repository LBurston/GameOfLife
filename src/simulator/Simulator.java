package simulator;

public class Simulator {

    private static final int DEFAULT_WIDTH = 150;
    private static final int DEFAULT_HEIGHT = 100;

    private Grid grid;

    private int step;

    private GameWindow window;


    public static void main(String[] args) {
        Simulator currentSim = new Simulator();
        currentSim.Simulator();
    }

    private void Simulator() {
        Simulator(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }

    private void Simulator(int width, int height) {
        if(width <= 2 || height <= 2) {
            System.out.println("You must have at least 3 rows and columns.");
            System.out.println("Using default values of " + DEFAULT_WIDTH + "x" + DEFAULT_HEIGHT + "...");
        }

        grid = new Grid(width,height);
        window = new GameWindow(width,height);

        reset();
    }

    public void reset() {
        step = 0;
    }

}
