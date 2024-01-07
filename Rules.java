package quiz.application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Rules extends JFrame implements ActionListener{

    String name;
    JButton QUIZ1, back, QUIZ2, QUIZ3;
    
    Rules(String name) {
        this.name = name;
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("Welcome " + name + " to Simple Minds");
        heading.setBounds(50, 20, 700, 30);
        heading.setFont(new Font("Viner Hand ITC", Font.BOLD, 28));
        heading.setForeground(new Color(30, 144, 254));
        add(heading);
        
        JLabel rules = new JLabel();
        rules.setBounds(20, 90, 700, 350);
        rules.setFont(new Font("Tahoma", Font.PLAIN, 16));
        rules.setText(
            "<html>"+ 
                "1. Don't stress" + "<br><br>" +
                "2. Do your best" + "<br><br>" +
                "3. Forget the rest" + "<br><br>" +
                "Good Luck ....." + "<br><br>" +
            "<html>");
        add(rules);
        
        back = new JButton("Back");
        back.setBounds(100, 500, 100, 30);
        back.setBackground(new Color(30, 144, 254));
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
        QUIZ1 = new JButton("QUIZ1");
        QUIZ1.setBounds(250, 500, 100, 30);
        QUIZ1.setBackground(new Color(30, 144, 254));
        QUIZ1.setForeground(Color.WHITE);
        QUIZ1.addActionListener(this);
        add(QUIZ1);
        
        QUIZ2 = new JButton("QUIZ2");
        QUIZ2.setBounds(400, 500, 100, 30);
        QUIZ2.setBackground(new Color(30, 144, 254));
        QUIZ2.setForeground(Color.WHITE);
        QUIZ2.addActionListener(this);
        add(QUIZ2);
       
        
        QUIZ3 = new JButton("QUIZ3");
        QUIZ3.setBounds(550, 500, 100, 30);
        QUIZ3.setBackground(new Color(30, 144, 254));
        QUIZ3.setForeground(Color.WHITE);
        QUIZ3.addActionListener(this);
        add(QUIZ3);
        
        
        setSize(800, 650);
        setLocation(350, 100);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == QUIZ1) {
            setVisible(false);
            new Quiz(name);
        } else if (ae.getSource() == QUIZ2) {
            setVisible(false);
            new Quiz2(name);
        } else if (ae.getSource() == QUIZ3) {
            setVisible(false);
            new Quiz(name);
        }
        else {
            setVisible(false);
            new Login();
        }
    }
   
    
    
    
    public static void main(String[] args) {
        new Rules("User");
    }
}
