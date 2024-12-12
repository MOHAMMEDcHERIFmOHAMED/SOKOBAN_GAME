import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import java.util.ArrayList;


public class Game {
    private JFrame frame;
    private JLabel playerLabel;
    private Player player;
    private  ArrayList<Crate> crates = new ArrayList<>();
    private Area area;

    public Game() {
        initializeGame();
    }
    public ArrayList<Crate> getCrates() {
        return crates; // Provide access to crates
    }
    
    // Initialize the game setup
    private void initializeGame() {
        // Create area and player
        area = new Area();
        
        player = new Player(2, 2, area);

        // Load player image
        ImageIcon playerIcon = new ImageIcon("Program\\imgs\\char.png");
        Image playerImage = playerIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        playerLabel = new JLabel(new ImageIcon(playerImage));
        playerLabel.setBounds(player.getY() * 100, player.getX() * 100, 100, 100);

        // Set up the frame
        frame = new JFrame("SOKOBAN");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setSize(600, 600);

        // Render the walls and add the player
        area.renderWalls(frame);
        frame.add(playerLabel);

        // Add key listener for player movement
        addKeyListener();

        // Make frame visible
        frame.setVisible(true);
    }

    // Add key listener for player movement
    private void addKeyListener() {
        frame.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_LEFT:
                        player.move(0, -1, playerLabel); // Left: decrease Y (column)
                        break;
                    case KeyEvent.VK_RIGHT:
                        player.move(0, 1, playerLabel); // Right: increase Y (column)
                        break;
                    case KeyEvent.VK_UP:
                        player.move(-1, 0, playerLabel); // Up: decrease X (row)
                        break;
                    case KeyEvent.VK_DOWN:
                        player.move(1, 0, playerLabel); // Down: increase X (row)
                        break;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {}
        });
    }

    public static void main(String[] args) {
        new Game(); // Start the game
    }
}
