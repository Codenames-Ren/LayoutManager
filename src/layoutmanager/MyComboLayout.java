package layoutmanager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author Ren
 */

public class MyComboLayout extends JFrame {

    public MyComboLayout() {
        setTitle("Combo Layout - E-Commerce UI");
        setSize(800,500);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        getContentPane().setBackground(Theme.BG_MAIN);
        setLayout(new BorderLayout());

        add(createNavbar(), BorderLayout.NORTH);
        add(createContent(), BorderLayout.CENTER);
        add(createFooter(), BorderLayout.SOUTH);
    }

    private JPanel createNavbar() {
        JPanel nav = new JPanel();
        nav.setBackground(Theme.BG_PANEL);
        nav.setLayout(new BoxLayout(nav, BoxLayout.X_AXIS));
        nav.setBorder(BorderFactory.createEmptyBorder(8,15,8,15));

        nav.add(menu("Home"));
        nav.add(menu("Products"));
        nav.add(menu("Categories"));
        nav.add(menu("Deals"));
        
        nav.add(menu("Profile"));

        return nav;
    }

    private JPanel menu(String text) {
        JPanel item = new JPanel();
        item.setBackground(Theme.BG_PANEL);
        item.setBorder(BorderFactory.createEmptyBorder(8,15,8,15));
        item.setCursor(new Cursor(Cursor.HAND_CURSOR));

        JLabel label = new JLabel(text);
        label.setForeground(Theme.TEXT);

        item.add(label);

        item.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                item.setBackground(Theme.BTN);
            }
            public void mouseExited(MouseEvent e) {
                item.setBackground(Theme.BG_PANEL);
            }
        });

        return item;
    }

    private JPanel createContent() {
        JPanel content = new JPanel(new BorderLayout());
        content.setBackground(Theme.BG_MAIN);

        content.add(createFilterBar(), BorderLayout.NORTH);
        content.add(createProductGrid(), BorderLayout.CENTER);

        return content;
    }

    private JPanel createFilterBar() {
        JPanel filter = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
        filter.setBackground(Theme.BG_PANEL);

        filter.setBorder(BorderFactory.createEmptyBorder(0, 55, 0, 0));
        filter.add(new JTextField(15));
        filter.add(createButton("🔎︎"));
        filter.add(createButton("Filter"));

        return filter;
    }
    
    private JButton createButton(String text) {
        JButton btn = new JButton(text);
        btn.setBackground(Theme.BTN);
        btn.setForeground(Theme.TEXT);
        btn.setFocusPainted(false);
        btn.setBorderPainted(false);

        btn.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                btn.setBackground(Theme.BTN_HOVER);
            }
            public void mouseExited(MouseEvent e) {
                btn.setBackground(Theme.BTN);
            }
        });

        return btn;
    }

    private JPanel createProductGrid() {
        JPanel grid = new JPanel(new GridLayout(2,4,15,15));
        grid.setBackground(Theme.BG_MAIN);
        grid.setBorder(BorderFactory.createEmptyBorder(15,15,15,15));

        for (int i = 1; i <= 8; i++) {
            grid.add(productCard("Item " + i));
        }

        return grid;
    }

    private JPanel createFooter() {
        JPanel footer = new JPanel(new FlowLayout(FlowLayout.CENTER));
        footer.setBackground(Theme.BG_PANEL);

        JLabel text = new JLabel("© 2026 Bayu Sukma");
        text.setForeground(Theme.TEXT);

        footer.add(text);
        return footer;
    }

    private JPanel productCard(String title) {
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
        new MyComboLayout().setVisible(true);
    }
}
