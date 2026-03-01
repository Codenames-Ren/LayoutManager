package layoutmanager;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author Ren
 */

public class MyGridLayout extends JFrame {

    public MyGridLayout() {
        setTitle("Grid Layout - Dashboard Menu");
        setSize(500,350);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        
        getContentPane().setBackground(Theme.BG_MAIN);

        JPanel gridPanel = new JPanel(new GridLayout(2, 3, 15, 15));
        gridPanel.setBackground(Theme.BG_MAIN);
        gridPanel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));

        gridPanel.add(menuCard("Apparel"));
        gridPanel.add(menuCard("Electronics"));
        gridPanel.add(menuCard("Accessories"));
        gridPanel.add(menuCard("Bill"));
        gridPanel.add(menuCard("Hobby"));
        gridPanel.add(menuCard("Books"));

        add(gridPanel);
    }

    private JPanel menuCard(String title) {
        JPanel card = new JPanel(new BorderLayout());
        card.setBackground(Theme.BG_PANEL);

        JLabel label = new JLabel(title, SwingConstants.CENTER);
        label.setForeground(Theme.TEXT);
        label.setFont(Theme.FONT_TITLE);

        card.add(label, BorderLayout.CENTER);

        card.setCursor(new Cursor(Cursor.HAND_CURSOR));

        card.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                card.setBackground(Theme.BTN);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                card.setBackground(Theme.BG_PANEL);
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                JOptionPane.showMessageDialog(card, title + " clicked");
            }
        });

        return card;
    }

    public static void main(String[] args) {
        new MyGridLayout().setVisible(true);
    }
}