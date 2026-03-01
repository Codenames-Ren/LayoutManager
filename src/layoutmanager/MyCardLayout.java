package layoutmanager;
import javax.swing.*;
import java.awt.*;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

/**
 *
 * @author Ren
 */

public class MyCardLayout extends JFrame {

    private CardLayout cardLayout;
    private JPanel cardPanel;

    public MyCardLayout() {
        setTitle("Card Layout - Login/Register");
        setSize(420,320);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        
        getContentPane().setBackground(Theme.BG_MAIN);

        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);
        cardPanel.setBackground(Theme.BG_MAIN);

        cardPanel.add(createLoginCard(), "login");
        cardPanel.add(createRegisterCard(), "register");

        add(cardPanel);
    }

    private JPanel createLoginCard() {
        JPanel panel = new JPanel(new GridLayout(5,1,10,10));
        panel.setBackground(Theme.BG_PANEL);
        panel.setBorder(BorderFactory.createEmptyBorder(20,40,20,40));

        panel.add(createLabel("Login"));
        panel.add(new JTextField());
        panel.add(new JPasswordField());

        JButton loginBtn = createButton("Login");
        panel.add(loginBtn);

        JButton switchBtn = createButton("Go to Register");
        switchBtn.addActionListener(e -> cardLayout.show(cardPanel, "register"));
        panel.add(switchBtn);

        return panel;
    }

    private JPanel createRegisterCard() {
        JPanel panel = new JPanel(new GridLayout(6,1,10,10));
        panel.setBackground(Theme.BG_PANEL);
        panel.setBorder(BorderFactory.createEmptyBorder(20,40,20,40));

        panel.add(createLabel("Register"));
        panel.add(new JTextField());  
        panel.add(new JTextField());  
        panel.add(new JPasswordField());

        JButton registerBtn = createButton("Register");
        panel.add(registerBtn);

        JButton switchBtn = createButton("Back to Login");
        switchBtn.addActionListener(e -> cardLayout.show(cardPanel, "login"));
        panel.add(switchBtn);

        return panel;
    }

    private JLabel createLabel(String text){
        JLabel lbl = new JLabel(text, SwingConstants.CENTER);
        lbl.setForeground(Theme.TEXT);
        lbl.setFont(Theme.FONT_TITLE);
        return lbl;
    }

    private JButton createButton(String text) {
        JButton btn = new JButton(text);
        btn.setBackground(Theme.BTN);
        btn.setForeground(Theme.TEXT);
        btn.setFocusPainted(false);
        btn.setBorderPainted(false);
        return btn;
    }

    public static void main(String[] args) {
        new MyCardLayout().setVisible(true);
    }
}