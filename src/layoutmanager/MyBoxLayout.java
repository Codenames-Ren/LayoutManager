package layoutmanager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author Ren
 */

public class MyBoxLayout extends JFrame{
    public MyBoxLayout() {
        setTitle("Box Layout - Navigation Bar");
        setSize(600,90);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        
        getContentPane().setBackground(Theme.BG_PANEL);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));
        
        add(createMenu("Home"));
        add(createMenu("Products"));
        add(createMenu("About"));
        add(createMenu("Contact"));
        add(createMenu("Order History"));
        
        add(Box.createHorizontalGlue());
        add(createMenu("Profile"));
    }
    
    private JPanel createMenu(String text){
        JPanel item = new JPanel();
        item.setBackground(Theme.BG_PANEL);
        item.setBorder(BorderFactory.createEmptyBorder(10,15,10,15));
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
    
    public static void main(String[] args) {
        new MyBoxLayout().setVisible(true);
    }
}
