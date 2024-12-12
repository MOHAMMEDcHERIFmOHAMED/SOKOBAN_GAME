import javax.swing.JLabel;

public class Position {
    private int X, Y;
    private Area area;
    private Game game; // Add a reference to the Game instance
    private final int width = 100;
    private final int height = 100;

    public Position(int x, int y, Area area, Game game) {
        this.X = x;
        this.Y = y;
        this.area = area;
        this.game = game; // Initialize the Game instance
    }
    public Position(int x, int y, Area area) {
        this.X = x;
        this.Y = y;
        this.area = area;
    }

    public void setX(int x) { this.X = x; }
    public void setY(int y) { this.Y = y; }
    public int getX() { return X; }
    public int getY() { return Y; }

    public void move(int dx, int dy, JLabel imagelable) {
        int newX = X + dx;
        int newY = Y + dy;

        System.out.println("Attempting to move to (" + newX + ", " + newY + ")");

        if (area.isInBounds(newX, newY)) {
            if (area.isCrate(newX, newY)) {
                // Check if the crate can be moved
                for (Crate crate : game.getCrates()) { // Access crates through Game
                    if (crate.getX() == newX && crate.getY() == newY) {
                        if (crate.moveCrate(dx, dy)) {
                            // Move player after successful crate move
                            this.X = newX;
                            this.Y = newY;
                            imagelable.setBounds(Y * width, X * height, width, height);
                            System.out.println("Player and crate moved to: (" + X + ", " + Y + ")");
                            return;
                        }
                    }
                }
                System.out.println("Crate movement blocked.");
            } else if (!area.isWall(newX, newY)) {
                // Move player if not blocked
                this.X = newX;
                this.Y = newY;
                imagelable.setBounds(Y * width, X * height, width, height);
                System.out.println("Moved to: (" + X + ", " + Y + ")");
            } else {
                System.out.println("Blocked by wall.");
            }
        } else {
            System.out.println("Out of bounds.");
        }
    }

    public void displayPos() {
        System.out.println("DX: " + X + " DY: " + Y);
    }
}
