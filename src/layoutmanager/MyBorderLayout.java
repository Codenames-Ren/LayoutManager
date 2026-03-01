package layoutmanager;

import javax.swing.*;
import java.awt.*;

/** 
 *
 * @author Ren
 */

public class MyBorderLayout extends JFrame {

    public MyBorderLayout() {
        setTitle("Border Layout - App Dashboard");
        setSize(600,400);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        getContentPane().setBackground(Theme.BG_MAIN);
        setLayout(new BorderLayout());

        add(createHeader(), BorderLayout.NORTH);
        add(createMainArea(), BorderLayout.CENTER);
        add(createFooter(), BorderLayout.SOUTH);
    }

    private JPanel createHeader() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(Theme.BG_PANEL);

        JLabel title = new JLabel("My Application", SwingConstants.CENTER);
        title.setForeground(Theme.TEXT);
        title.setFont(Theme.FONT_TITLE);

        panel.add(title, BorderLayout.CENTER);
        return panel;
    }

    private JPanel createMainArea() {
        JPanel main = new JPanel(new BorderLayout());
        main.setBackground(Theme.BG_MAIN);

        main.add(createSidebar(), BorderLayout.WEST);
        main.add(createContent(), BorderLayout.CENTER);

        return main;
    }

    private JPanel createSidebar() {
        JPanel panel = new JPanel(new GridLayout(4,1,5,5));
        panel.setBackground(Theme.BG_PANEL);
        panel.setPreferredSize(new Dimension(120,0));

        panel.add(menuButton("Home"));
        panel.add(menuButton("Users"));
        panel.add(menuButton("Settings"));
        panel.add(menuButton("Logout"));

        return panel;
    }

    private JPanel createContent() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(Theme.BG_MAIN);

        JPanel wrapper = new JPanel(new BorderLayout());
        wrapper.setBackground(Theme.BG_MAIN);
        wrapper.setBorder(BorderFactory.createEmptyBorder(0, -60, 0, 0)); 
 
        JLabel text = new JLabel("Welcome to dashboard", SwingConstants.CENTER);
        text.setForeground(Theme.TEXT);

        wrapper.add(text, BorderLayout.CENTER);
        panel.add(wrapper, BorderLayout.CENTER);

        return panel;
    }
    private JPanel createFooter() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel.setBackground(Theme.BG_PANEL);

        JLabel copy = new JLabel("© Bayu Sukma");
        copy.setForeground(Theme.TEXT);

        panel.add(copy);
        return panel;
    }

    private JButton menuButton(String text) {
        JButton btn = new JButton(text);
        btn.setBackground(Theme.BTN);
        btn.setForeground(Theme.TEXT);
        btn.setFocusPainted(false);
        btn.setBorderPainted(false);
        return btn;
    }

    public static void main(String[] args) {
        new MyBorderLayout().setVisible(true);
    }
}