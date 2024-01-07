package quiz.application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Quiz extends JFrame implements ActionListener {
    
    String questions[][] = new String[10][5];
    String answers[][] = new String[10][2];
    String useranswers[][] = new String[10][1];
    JLabel qno, question;
    JRadioButton opt1, opt2, opt3, opt4;
    ButtonGroup groupoptions;
    JButton next, submit, lifeline;
    
    public static int timer = 10;
    public static int ans_given = 0;
    public static int count = 0;
    public static int score = 0;
    
    String name;
    Quiz(String name) {
        this.name = name;
        setBounds(50, 0, 1200, 800);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logic_gates.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0, 0, 800, 300);
        add(image);
        
        qno = new JLabel();
        qno.setBounds(100, 400, 50, 30);
        qno.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(qno);
        
        question = new JLabel();
        question.setBounds(150, 400, 900, 30);
        question.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(question);
        
        questions[0][0] = "The logical gates are categorized into _______";
        questions[0][1] = "One group";
        questions[0][2] = "Two groups";
        questions[0][3] = "Three groups";
        questions[0][4] = "Four groups";

        questions[1][0] = " _______ are basic gates";
        questions[1][1] = "NOT";
        questions[1][2] = "NAND";
        questions[1][3] = "AND";
        questions[1][4] = "NOT, AND, & OR";

        questions[2][0] = "__________ are universal gates";
        questions[2][1] = "NOT";
        questions[2][2] = "NAND & NOR";
        questions[2][3] = "AND";
        questions[2][4] = "NOT, AND, & OR";

        questions[3][0] = " __________ are arithmetic gates";
        questions[3][1] = "NOT";
        questions[3][2] = "NAND & NOR";
        questions[3][3] = "X-OR & X-NOR";
        questions[3][4] = "NOT, AND, & OR";

        questions[4][0] = "_________ are the common forms of complex logic gates";
        questions[4][1] = "OR-AND-Invert (OAI)";
        questions[4][2] = "AND-OR-Invert (AOI)";
        questions[4][3] = "Both OAI and AOI";
        questions[4][4] = "None of the above";

        questions[5][0] = "What is the standard form of DCDVS logic?";
        questions[5][1] = "Differential Cascade Voltage Switch";
        questions[5][2] = "Differential Cascade Voltage Static";
        questions[5][3] = "Differential Complex Voltage Switch";
        questions[5][4] = "None of the above";

        questions[6][0] = "What are the advantages of static complementary gates?";
        questions[6][1] = "Reliable";
        questions[6][2] = "Not easy to use";
        questions[6][3] = "Not reliable";
        questions[6][4] = "Reliable and easy to use";

        questions[7][0] = "Who invented Boolean algebra?";
        questions[7][1] = "Bardeen";
        questions[7][2] = "Claude Shannon";
        questions[7][3] = "George Boole";
        questions[7][4] = "None of the above";

        questions[8][0] = "How many terminals do MOS transistors have?";
        questions[8][1] = "ONE";
        questions[8][2] = "TWO";
        questions[8][3] = "THREE";
        questions[8][4] = "FOUR";

        questions[9][0] = "The base is 16 for _______ number system";
        questions[9][1] = "Binary";
        questions[9][2] = "Hexadecimal";
        questions[9][3] = "Decimal";
        questions[9][4] = "Octal";
        
        answers[0][1] = "Three groups";
        answers[1][1] = "NOT, AND, & OR";
        answers[2][1] = "NAND & NOR";
        answers[3][1] = "X-OR & X-NOR";
        answers[4][1] = "Both OAI and AOI";
        answers[5][1] = "Differential Cascade Voltage Switch";
        answers[6][1] = "Reliable";
        answers[7][1] = "George Boole";
        answers[8][1] = "THREE";
        answers[9][1] = "Hexadecimal";
        
        opt1 = new JRadioButton();
        opt1.setBounds(170, 500, 700, 30);
        opt1.setBackground(Color.WHITE);
        opt1.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt1);
        
        opt2 = new JRadioButton();
        opt2.setBounds(170, 550, 700, 30);
        opt2.setBackground(Color.WHITE);
        opt2.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt2);
        
        opt3 = new JRadioButton();
        opt3.setBounds(170, 600, 700, 30);
        opt3.setBackground(Color.WHITE);
        opt3.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt3);
        
        opt4 = new JRadioButton();
        opt4.setBounds(170, 650, 700, 30);
        opt4.setBackground(Color.WHITE);
        opt4.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt4);
        
        groupoptions = new ButtonGroup();
        groupoptions.add(opt1);
        groupoptions.add(opt2);
        groupoptions.add(opt3);
        groupoptions.add(opt4);
        
        next = new JButton("Next");
        next.setBounds(900, 450, 200, 40);
        next.setFont(new Font("Tahoma", Font.PLAIN, 22));
        next.setBackground(new Color(30, 144, 255));
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        add(next);
        
        lifeline = new JButton("50-50 Lifeline");
        lifeline.setBounds(900, 550, 200, 40);
        lifeline.setFont(new Font("Tahoma", Font.PLAIN, 22));
        lifeline.setBackground(new Color(30, 144, 255));
        lifeline.setForeground(Color.WHITE);
        lifeline.addActionListener(this);
        add(lifeline);
        
        submit = new JButton("Submit");
        submit.setBounds(900, 650, 200, 40);
        submit.setFont(new Font("Tahoma", Font.PLAIN, 22));
        submit.setBackground(new Color(30, 144, 255));
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setEnabled(false);
        add(submit);
        
        start(count);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == next) {
            repaint();
            opt1.setEnabled(true);
            opt2.setEnabled(true);
            opt3.setEnabled(true);
            opt4.setEnabled(true);
            
            ans_given = 1;
            if (groupoptions.getSelection() == null) {
               useranswers[count][0] = "";
            } else {
                useranswers[count][0] = groupoptions.getSelection().getActionCommand();
            }
            
            if (count == 8) {
                next.setEnabled(false);
                submit.setEnabled(true);
            }
            
            count++;
            start(count);
        } else if (ae.getSource() == lifeline) {
            if (count == 2 || count == 4 || count == 6 || count == 8 || count == 9) {
                opt2.setEnabled(false);
                opt3.setEnabled(false);
            } else {
                opt1.setEnabled(false);
                opt4.setEnabled(false);
            }
            lifeline.setEnabled(false);
        } else if (ae.getSource() == submit) {
            ans_given = 1;
            if (groupoptions.getSelection() == null) {
                useranswers[count][0] = "";
            } else {
                useranswers[count][0] = groupoptions.getSelection().getActionCommand();
            }

            for (int i = 0; i < useranswers.length; i++) {
                if (useranswers[i][0].equals(answers[i][1])) {
                    score += 10;
                } else {
                    score += 0;
                }
            }
            setVisible(false);
            new Score(name, score);
        }
    }
    
    public void paint(Graphics g) {
        super.paint(g);
        
        String time = "Time left - " + timer + " seconds"; // 15
        g.setColor(Color.RED);
        g.setFont(new Font("Tahoma", Font.BOLD, 25));
        
        if (timer > 0) { 
            g.drawString(time, 900, 200);
        } else {
            g.drawString("Times up!!", 900, 200);
        }
        
        timer--; // 14
        
        try {
            Thread.sleep(1000);
            repaint();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        if (ans_given == 1) {
            ans_given = 0;
            timer = 15;
        } else if (timer < 0) {
            timer = 15;
            opt1.setEnabled(true);
            opt2.setEnabled(true);
            opt3.setEnabled(true);
            opt4.setEnabled(true);
            
            if (count == 8) {
                next.setEnabled(false);
                submit.setEnabled(true);
            }
            if (count == 9) { // submit button
                if (groupoptions.getSelection() == null) {
                   useranswers[count][0] = "";
                } else {
                    useranswers[count][0] = groupoptions.getSelection().getActionCommand();
                }
                
                for (int i = 0; i < useranswers.length; i++) {
                    if (useranswers[i][0].equals(answers[i][1])) {
                        score += 10;
                    } else {
                        score += 0;
                    }
                }
                setVisible(false);
                new Score(name, score);
            } else { // next button
                if (groupoptions.getSelection() == null) {
                   useranswers[count][0] = "";
                } else {
                    useranswers[count][0] = groupoptions.getSelection().getActionCommand();
                }
                count++; // 0 // 1
                start(count);
            }
        }
        
    }
    
    public void start(int count) {
        qno.setText("" + (count + 1) + ". ");
        question.setText(questions[count][0]);
        opt1.setText(questions[count][1]);
        opt1.setActionCommand(questions[count][1]);
        
        opt2.setText(questions[count][2]);
        opt2.setActionCommand(questions[count][2]);
        
        opt3.setText(questions[count][3]);
        opt3.setActionCommand(questions[count][3]);
        
        opt4.setText(questions[count][4]);
        opt4.setActionCommand(questions[count][4]);
        
        groupoptions.clearSelection();
    }
    
    public static void main(String[] args) {
        new Quiz("User");
    }
}

