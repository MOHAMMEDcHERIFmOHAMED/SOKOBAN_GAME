import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
public class Area {
    // Map Legend
    // '#' => Wall
    // '.' => Point (goal for boxes)
    // ' ' => Empty space
    // '$' => Crate (box)
    // '@' => Player
        // ImageIcon wallIcon = new ImageIcon("Program\\src\\char.png");
        // Image wallImage = wallIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        // wallLabel = new JLabel(new ImageIcon(wallImage));
        // wallLabel.setBounds(player.getY() * 100, player.getX() * 100, 100, 100);
    char[][] area = {
            {'#', '#', '#', '#', '#', '#'},
            {'#', ' ', '$', ' ', ' ', '#'},
            {'#', ' ', ' ', '.', '$', '#'},
            {'#', ' ', ' ', '#', ' ', '#'},
            {'#', ' ', '@', ' ', '.', '#'},
            {'#', ' ', ' ', ' ',' ', '#'},
            {'#', '#', '#', '#', '#', '#'}
    };

    public boolean isWall(int i, int j) {
        return area[i][j] == '#';
    }

    public boolean isCoin(int i, int j) {
        return area[i][j] == '.';
    }
  public boolean isCrate(int i, int j) {
        return area[i][j] == '$';
    }
  public boolean isEmpty(int i, int j) {
        return area[i][j] == ' ';
    }
    public boolean isInBounds(int x, int y) {
        boolean result = (y >= 0 && y < area.length) && (x >= 0 && x < area[0].length);
        // debugging line
        System.out.println("Checking bounds for (" + x + ", " + y + "): " + result);
        return result;    
    }
    
    public void updateArea(int oldX, int oldY, int newX, int newY, char symbol) {
        area[oldX][oldY] = ' '; // Clear old position
        area[newX][newY] = symbol; // Set new position
    }
    

    // Add walls to the frame
    public void renderWalls(JFrame frame) {
        int tileSize = 100; 
        // wall Icon 
        ImageIcon wallIcon = new ImageIcon("Program\\imgs\\wall.png");
        Image scaledWallImage = wallIcon.getImage().getScaledInstance(tileSize, tileSize, Image.SCALE_SMOOTH);
        wallIcon = new ImageIcon(scaledWallImage); 
         // Crate Icon 
         ImageIcon crateIcon = new ImageIcon("Program\\imgs\\crate.png");
         Image scaledCrateImage = crateIcon.getImage().getScaledInstance(tileSize, tileSize, Image.SCALE_SMOOTH);
         crateIcon = new ImageIcon(scaledCrateImage); 
        // Coin Icon 
        ImageIcon coinIcon = new ImageIcon("Program\\imgs\\poin.jpg");
        Image scaledCoinImage = coinIcon.getImage().getScaledInstance(tileSize, tileSize, Image.SCALE_SMOOTH);
        coinIcon = new ImageIcon(scaledCoinImage); 
        // Empty space Icon 
        ImageIcon emptyIcon = new ImageIcon("Program\\imgs\\empty.png");
        Image scaledemptyImage = emptyIcon.getImage().getScaledInstance(tileSize, tileSize, Image.SCALE_SMOOTH);
        emptyIcon = new ImageIcon(scaledemptyImage); 

        for (int i = 0; i < area.length; i++) {
            for (int j = 0; j < area[i].length; j++) {
                if (isWall(i, j)) {
                    JLabel wallLabel = new JLabel(wallIcon);
                    wallLabel.setBounds(j * tileSize, i * tileSize, tileSize, tileSize);
                    frame.add(wallLabel);
                }
                if(isCrate( i, j)){
                    JLabel crateLabel = new JLabel(crateIcon);
                    crateLabel.setBounds(j * tileSize, i * tileSize, tileSize, tileSize);
                    frame.add(crateLabel);
                }
                if(isCoin( i, j)){
                    JLabel coinLabel = new JLabel(coinIcon);
                    coinLabel.setBounds(j * tileSize, i * tileSize, tileSize, tileSize);
                    frame.add(coinLabel);
                }
                // if(isEmpty( i, j)){
                //     JLabel emptyLabel = new JLabel(emptyIcon);
                //     emptyLabel.setBounds(j * tileSize, i * tileSize, tileSize, tileSize);
                //     frame.add(emptyLabel);
                // }
            }
        }
    }
    
}
