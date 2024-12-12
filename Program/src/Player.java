import javax.swing.JLabel;

public class Player extends Position {
    Position position ;
    // int width = 100;  // Image width
    // int height = 100;

    public Player(int x, int y, Area area) {
        super(x, y, area);
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
    // public void movePlayer(int dx, int dy,JLabel imagelable) {
    //     // check if the required position is not a wall and inside the board
    //     this.move(dx,dy);
    //     imagelable.setBounds(dx, dy,width ,height);
    // }
}
