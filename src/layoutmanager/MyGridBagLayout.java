package layoutmanager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author Ren
 */

public class MyGridBagLayout extends JFrame {

    public MyGridBagLayout() {
        setTitle("Grid Bag Layout - Form Biodata");
        setSize(480,360);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        
        getContentPane().setBackground(Theme.BG_MAIN);

        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(Theme.BG_PANEL);
        panel.setBorder(BorderFactory.createEmptyBorder(20,25,20,25));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8,8,8,8);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Title
        gbc.gridx = 1; gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.CENTER;

        JLabel title = new JLabel("Biodata", SwingConstants.CENTER);
        title.setForeground(Theme.TEXT);
        title.setFont(Theme.FONT_TITLE);

        panel.add(title, gbc);

        gbc.gridwidth = 1;

        // Name
        gbc.gridx = 0; gbc.gridy = 1;
        panel.add(createLabel("Name"), gbc);

        gbc.gridx = 1;
        panel.add(createField(), gbc);

        // Email
        gbc.gridx = 0; gbc.gridy = 2;
        panel.add(createLabel("Email"), gbc);

        gbc.gridx = 1;
        panel.add(createField(), gbc);

        // Phone
        gbc.gridx = 0; gbc.gridy = 3;
        panel.add(createLabel("Phone"), gbc);

        gbc.gridx = 1;
        panel.add(createField(), gbc);

        // Address
        gbc.gridx = 0; gbc.gridy = 4;
        panel.add(createLabel("Address"), gbc);

        gbc.gridx = 1;
        panel.add(createField(), gbc);

        // Buttons
        gbc.gridx = 1; gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.NONE;

        JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 0));
        btnPanel.setBackground(Theme.BG_PANEL);

        btnPanel.add(createButton("Save"));
        btnPanel.add(createButton("Reset"));

        panel.add(btnPanel, gbc);

        add(panel);
    }

    private JLabel createLabel(String text) {
        JLabel lbl = new JLabel(text);
        lbl.setForeground(Theme.TEXT);
        lbl.setFont(Theme.FONT_NORMAL);
        return lbl;
    }

    private JTextField createField() {
        JTextField field = new JTextField(18);
        field.setBackground(Color.WHITE);
        return field;
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

    public static void main(String[] args) {
        new MyGridBagLayout().setVisible(true);
    }
}
