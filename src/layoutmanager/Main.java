package layoutmanager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author Ren
 */

public class Main extends JFrame {

    public Main() {
        setTitle("Layout Manager");
        setSize(420,360);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        getContentPane().setBackground(Theme.BG_MAIN);
        setLayout(new BorderLayout());

        add(createHeader(), BorderLayout.NORTH);
        add(createMenuGrid(), BorderLayout.CENTER);
    }

    private JPanel createHeader() {
        JPanel header = new JPanel();
        header.setBackground(Theme.BG_PANEL);
        header.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        JLabel title = new JLabel("Layout Manager");
        title.setForeground(Theme.TEXT);
        title.setFont(Theme.FONT_TITLE);

        header.add(title);
        return header;
    }

    private JPanel createMenuGrid() {
        JPanel grid = new JPanel(new GridLayout(3,3,12,12));
        grid.setBackground(Theme.BG_MAIN);
        grid.setBorder(BorderFactory.createEmptyBorder(15,15,15,15));

        grid.add(menuCard("Border Layout", () -> new MyBorderLayout().setVisible(true)));
        grid.add(menuCard("Flow Layout", () -> new MyFlowLayout().setVisible(true)));
        grid.add(menuCard("Grid Layout", () -> new MyGridLayout().setVisible(true)));
        grid.add(menuCard("Card Layout", () -> new MyCardLayout().setVisible(true)));
        grid.add(menuCard("Grid Bag Layout", () -> new MyGridBagLayout().setVisible(true)));
        grid.add(menuCard("Box Layout", () -> new MyBoxLayout().setVisible(true)));
        grid.add(menuCard("Combo Layout", () -> new MyComboLayout().setVisible(true)));

        return grid;
    }

    private JPanel menuCard(String text, Runnable action) {
        JPanel card = new JPanel(new BorderLayout());
        card.setBackground(Theme.BG_PANEL);
        card.setCursor(new Cursor(Cursor.HAND_CURSOR));

        JLabel label = new JLabel(text, SwingConstants.CENTER);
        label.setForeground(Theme.TEXT);
        label.setFont(Theme.FONT_NORMAL);

        card.add(label, BorderLayout.CENTER);

        card.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                card.setBackground(Theme.BTN);
            }
            public void mouseExited(MouseEvent e) {
                card.setBackground(Theme.BG_PANEL);
            }
            public void mouseClicked(MouseEvent e) {
                action.run();
            }
        });

        return card;
    }

    public static void main(String[] args) {
        new Main().setVisible(true);
    }
}
