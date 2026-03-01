package layoutmanager;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author Ren
 */
public class MyFlowLayout extends JFrame{
    public MyFlowLayout(){
        setTitle("Flow Layout - Search Toolbar");
        setSize(600,200);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        
        getContentPane().setBackground(Theme.BG_MAIN);
        setLayout(new FlowLayout());
        
        add(createToolbar());
    }
    
    private JPanel createToolbar() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 20));
        panel.setBackground(Theme.BG_PANEL);
        
        JLabel label = new JLabel("Search : ");
        label.setForeground(Theme.TEXT);
        label.setFont(Theme.FONT_NORMAL);
        
        JTextField field = new JTextField(20);
        
        JButton searchBtn = createButton("Search");
        JButton resetBtn = createButton("Reset");
        JButton addBtn = createButton("Filter");
        
        panel.add(label);
        panel.add(field);
        panel.add(searchBtn);
        panel.add(resetBtn);
        panel.add(addBtn);
        
        return panel;
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
        new MyFlowLayout().setVisible(true);
    }
}
