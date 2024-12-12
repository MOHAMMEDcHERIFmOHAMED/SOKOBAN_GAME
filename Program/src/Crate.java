import javax.swing.JLabel;

public class Crate {
    private int x, y;
    private Area area;
    private JLabel crateLabel; // JLabel for the crate

    private final int width = 100; // Size of one grid cell (example)
    private final int height = 100;

    public Crate(int x, int y, Area area, JLabel crateLabel) {
        this.x = x;
        this.y = y;
        this.area = area;
        this.crateLabel = crateLabel;
        updateLabelPosition(); // Initialize label position
    }

    public int getX() { return x; }
    public int getY() { return y; }

    public boolean moveCrate(int dx, int dy) {
        int newX = x + dx;
        int newY = y + dy;

        // Check if the new position is valid
        if (area.isInBounds(newX, newY) && !area.isWall(newX, newY) && !area.isCrate(newX, newY)) {
            // Update crate's position
            this.x = newX;
            this.y = newY;
            updateLabelPosition(); // Update GUI position
            area.updateArea(x - dx, y - dy, x, y, '$'); // Update area map

            System.out.println("Crate moved to: (" + x + ", " + y + ")");
            return true;
        } else {
            System.out.println("Crate cannot be moved to: (" + newX + ", " + newY + ")");
            return false;
        }
    }

    private void updateLabelPosition() {
        // Update the JLabel's position in the GUI
        crateLabel.setBounds(y * width, x * height, width, height);
    }
}
