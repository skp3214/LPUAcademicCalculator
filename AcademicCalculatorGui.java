import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;

public class AcademicCalculatorGui {
    private static JPanel mainpanel, p1, p2, p3, p4;
    private static JLabel lb1, lb2, lb3, lb4, lb5;
    private static JTextField ip1, ip2, ip3, ip4, ip5;
    private static JButton calculateButton, calculateButton2, calculateButton3, calculateButton4;
    private static JLabel result1, result2, result3, result4;
    private static JComboBox<String> j1;
    private static CardLayout cl;

    public static void main(String[] args) {
        JFrame obj1 = new JFrame("");
        obj1.setResizable(false);
        obj1.setTitle("Academic Calculator");

        Image icon = Toolkit.getDefaultToolkit().getImage("calculator.jpg");
        obj1.setIconImage(icon);
        obj1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        obj1.setSize(750, 850);
        obj1.setLocationRelativeTo(null);
        Container c = obj1.getContentPane();
        Color c1 = new Color(10, 50, 60);
        c.setBackground(c1);
        obj1.setLayout(null);

        JLabel gradePredictor = new JLabel("ACADEMIC");
        gradePredictor.setFont(new Font("Serif", Font.PLAIN, 70));
        gradePredictor.setForeground(Color.white);
        gradePredictor.setBounds(185, 0, 700, 130);
        obj1.add(gradePredictor);

        JLabel gradePredictor2 = new JLabel("CALCULATOR");
        gradePredictor2.setFont(new Font("Serif", Font.PLAIN, 70));
        gradePredictor2.setForeground(Color.white);
        gradePredictor2.setBounds(150, 65, 700, 130);
        obj1.add(gradePredictor2);

        JButton btn1 = new JButton("CGPA Calculator");
        JButton btn2 = new JButton("Grade, GradePoint, Minimum Marks, Total Credit ");

        Font objFont = new Font("Serif", Font.PLAIN, 27);
        Cursor objCur = new Cursor(Cursor.HAND_CURSOR);

        btn1.setSize(600, 100);
        btn1.setLocation(70, 330);
        btn1.setFont(objFont);
        btn1.setCursor(objCur);
        obj1.add(btn1);
        btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    obj1.setVisible(false);
                    JFrame f1 = new JFrame("CGPA Calculator");
                    f1.setIconImage(icon);
                    f1.setResizable(false);
                    f1.setSize(350, 650);
                    f1.setLocationRelativeTo(null);
                    f1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                    JLabel marksLabel = new JLabel("      GradePoint");
                    marksLabel.setFont(new Font("Ariel", 1, 20));
                    JLabel creditLabel = new JLabel("      Credit");
                    creditLabel.setFont(new Font("Ariel", 1, 20));

                    int n = Integer.parseInt(JOptionPane.showInputDialog("Enter number of subjects: "));

                    JTextField[] marksField = new JTextField[n];
                    JTextField[] creditField = new JTextField[n];

                    for (int i = 0; i < n; i++) {

                        marksField[i] = new JTextField(5);
                        marksField[i].setFont(new Font("Ariel", 1, 30));
                        marksField[i].setHorizontalAlignment(JTextField.CENTER);

                        creditField[i] = new JTextField(5);
                        creditField[i].setFont(new Font("Ariel", 1, 30));
                        creditField[i].setHorizontalAlignment(JTextField.CENTER);
                    }

                    JButton calculateButton = new JButton("Calculate");
                    calculateButton.setBounds(10, 760, 300, 60);
                    calculateButton.setFont(new Font("Serif", 0, 50));
                    calculateButton.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {

                            try {
                                double totalCredit = 0.0;
                                double totalGrade = 0.0;
                                for (int i = 0; i < n; i++) {
                                    double marks = Double.parseDouble(marksField[i].getText());

                                    double credit = Double.parseDouble(creditField[i].getText());
                                    totalCredit += credit;
                                    totalGrade += (marks) * credit;
                                }
                                double cgpa = totalGrade / totalCredit;
                                UIManager.put("OptionPane.messageFont",
                                        new FontUIResource(new Font("Arial", Font.PLAIN, 30)));

                                JOptionPane.showMessageDialog(f1, "Your CGPA is: " + String.format("%.2f", cgpa));
                            } catch (Exception ak) {
                                UIManager.put("OptionPane.messageFont",
                                        new FontUIResource(new Font("Arial", Font.PLAIN, 30)));

                                JOptionPane.showMessageDialog(f1, "Invalid or Incomplete Input ");
                            }

                        }
                    });

                    f1.setLayout(new BorderLayout());

                    JPanel inputPanel = new JPanel(new GridLayout(n + 1, 2));
                    inputPanel.add(marksLabel);
                    inputPanel.add(creditLabel);

                    for (int i = 0; i < n; i++) {
                        inputPanel.add(marksField[i]);
                        inputPanel.add(creditField[i]);
                    }
                    f1.add(inputPanel);
                    f1.add(calculateButton, BorderLayout.SOUTH);

                    f1.addWindowListener(new WindowAdapter() {
                        @Override
                        public void windowClosed(WindowEvent ke) {
                            obj1.setVisible(true);
                        }
                    });
                    f1.setVisible(true);
                } catch (Exception me) {
                    obj1.setVisible(true);
                }
            }
        });


        
        btn2.setSize(600, 100);
        btn2.setLocation(70, 460);
        btn2.setFont(objFont);
        btn2.setCursor(objCur);
        obj1.add(btn2);
        btn2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                obj1.setVisible(false);
                JFrame f = new JFrame();
                f.setTitle("Academic Calculator");
                f.setResizable(false);
                f.setSize(750, 850);
                f.setIconImage(icon);
                f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                f.setLocationRelativeTo(null);

                String[] options = { "GRADE CALCULATOR", "GRADE POINT CALCULATOR", "MINIMUM MARKS CALCULATOR",
                        "TOTAL CREDIT CALCULATOR" };
                j1 = new JComboBox<>(options);
                j1.setPreferredSize(new Dimension(0, 50));
                j1.setFont(new Font(Font.SERIF, 0, 28));
                f.add(j1, BorderLayout.NORTH);

                mainpanel = new JPanel();
                cl = new CardLayout();
                mainpanel.setLayout(cl);
                f.add(mainpanel);
                /********************* GRADE CALCULATOR **********************************/
                p1 = new JPanel();
                p1.setLayout(null);
                p1.setBackground(new Color(10, 50, 60));
                mainpanel.add(p1, "GRADE CALCULATOR");

                JLabel g1 = new JLabel("CALCULATE");
                g1.setFont(new Font("Serif", Font.PLAIN, 80));
                g1.setForeground(Color.white);
                g1.setBounds(145, 0, 700, 130);
                p1.add(g1);

                JLabel g2 = new JLabel("GRADE");
                g2.setFont(new Font("Serif", Font.PLAIN, 80));
                g2.setForeground(Color.white);
                g2.setBounds(235, 75, 700, 130);
                p1.add(g2);

                lb1 = new JLabel("Enter your marks: ");
                lb1.setFont(new Font("Serif", Font.PLAIN, 30));
                lb1.setForeground(Color.white);
                lb1.setBounds(200, 350, 350, 30);
                p1.add(lb1);

                ip1 = new JTextField();
                ip1.setFont(new Font("Serif", Font.PLAIN, 30));
                ip1.setBounds(445, 350, 105, 30);
                p1.add(ip1);

                calculateButton = new JButton("Calculate");
                calculateButton.setSize(350, 30);
                calculateButton.setLocation(200, 400);
                calculateButton.setFont(objFont);
                calculateButton.setCursor(objCur);
                p1.add(calculateButton);
                calculateButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource() == calculateButton) {
                            int marks = Integer.parseInt(ip1.getText());
                            if (marks >= 90 && marks <= 100)
                                result1.setText("Grade : O  ");
                            else if (marks >= 80 && marks < 90)
                                result1.setText("Grade : A+ ");
                            else if (marks >= 70 && marks < 80)
                                result1.setText("Grade :  A ");
                            else if (marks >= 60 && marks < 70)
                                result1.setText("Grade :  B+ ");
                            else if (marks >= 50 && marks < 60)
                                result1.setText("Grade :  B ");
                            else if (marks >= 40 && marks < 50)
                                result1.setText("Grade :  C ");
                            else if (marks >= 34 && marks < 40)
                                result1.setText("Grade : D ");
                            else if (marks < 34)
                                result1.setText("Fail");
                            else
                                result1.setText("Invalid Marks Input ");
                        }
                    }
                });

                result1 = new JLabel("Grade : ?");
                result1.setFont(new Font("Serif", Font.PLAIN, 35));
                result1.setForeground(Color.white);
                result1.setBounds(200, 450, 350, 35);
                p1.add(result1);

                /********************** GRADE POINT CALCULATOR****************************** */

                p2 = new JPanel();
                p2.setLayout(null);
                p2.setBackground(new Color(10, 50, 60));
                mainpanel.add(p2, "GRADE POINT CALCULATOR");

                JLabel g3 = new JLabel("CALCULATE");
                g3.setFont(new Font("Serif", Font.PLAIN, 80));
                g3.setForeground(Color.white);
                g3.setBounds(135, 0, 700, 130);
                p2.add(g3);

                JLabel g4 = new JLabel("GRADE POINT");
                g4.setFont(new Font("Serif", Font.PLAIN, 80));
                g4.setForeground(Color.white);
                g4.setBounds(120, 75, 700, 130);
                p2.add(g4);

                lb2 = new JLabel("Enter your marks: ");
                lb2.setFont(new Font("Serif", Font.PLAIN, 30));
                lb2.setForeground(Color.white);
                lb2.setBounds(200, 350, 250, 30);
                p2.add(lb2);

                ip2 = new JTextField();
                ip2.setFont(new Font("Serif", Font.PLAIN, 30));
                ip2.setBounds(445, 350, 105, 30);
                p2.add(ip2);

                calculateButton2 = new JButton("Calculate ");
                calculateButton2.setSize(350, 30);
                calculateButton2.setLocation(200, 400);
                calculateButton2.setFont(objFont);
                calculateButton2.setCursor(objCur);
                p2.add(calculateButton2);
                calculateButton2.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource() == calculateButton2) {
                            int mark = Integer.parseInt(ip2.getText());
                            if (mark >= 90 && mark <= 100)
                                result2.setText("Grade Point:  10 ");
                            else if (mark >= 80 && mark < 90)
                                result2.setText("Grade Point:  9 ");
                            else if (mark >= 70 && mark < 80)
                                result2.setText("Grade Point:  8 ");
                            else if (mark >= 60 && mark < 70)
                                result2.setText("Grade Point:  7 ");
                            else if (mark >= 50 && mark < 60)
                                result2.setText("Grade Point:  6 ");
                            else if (mark >= 40 && mark < 50)
                                result2.setText("Grade Point:  5 ");
                            else if (mark >= 34 && mark < 40)
                                result2.setText("Grade Point:  4 ");
                            else if (mark < 34)
                                result2.setText("GradePoint:  0");
                            else
                                result2.setText("Invalid Marks Input ");
                        }
                    }
                });

                result2 = new JLabel("Grade Point:  ?");
                result2.setFont(new Font("Serif", Font.PLAIN, 35));
                result2.setForeground(Color.white);
                result2.setBounds(200, 450, 250, 35);
                p2.add(result2);

                /**************** MINIMUM MARKS CALCULATOR ***********************/
                p3 = new JPanel();
                p3.setLayout(null);
                p3.setBackground(new Color(10, 50, 60));
                mainpanel.add(p3, "MINIMUM MARKS CALCULATOR");

                JLabel g5 = new JLabel("CALCULATE");
                g5.setFont(new Font("Serif", Font.PLAIN, 75));
                g5.setForeground(Color.white);
                g5.setBounds(135, 0, 700, 130);
                p3.add(g5);

                JLabel g6 = new JLabel("MINIMUM MARKS");
                g6.setFont(new Font("Serif", Font.PLAIN, 75));
                g6.setForeground(Color.white);
                g6.setBounds(60, 75, 700, 130);
                p3.add(g6);

                lb3 = new JLabel("Enter your Grade: ");
                lb3.setFont(new Font("Serif", Font.PLAIN, 30));
                lb3.setForeground(Color.white);
                lb3.setBounds(200, 350, 230, 30);
                p3.add(lb3);

                ip3 = new JTextField();
                ip3.setFont(new Font("Serif", Font.PLAIN, 30));
                ip3.setBounds(425, 350, 85, 30);
                p3.add(ip3);

                result3 = new JLabel("Minimum marks needed is ?");
                result3.setFont(new Font("Serif", Font.PLAIN, 35));
                result3.setForeground(Color.white);
                result3.setBounds(200, 450, 550, 35);
                p3.add(result3);

                calculateButton3 = new JButton("Calculate");
                calculateButton3.setSize(312, 30);
                calculateButton3.setLocation(200, 400);
                calculateButton3.setFont(objFont);
                calculateButton3.setCursor(objCur);
                p3.add(calculateButton3);
                calculateButton3.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {

                        if (e.getSource() == calculateButton3) {
                            String grade = ip3.getText().toUpperCase();

                            switch (grade) {
                                case "O":
                                    result3.setText("Minimum marks needed is 90 ");
                                    break;
                                case "A+":
                                    result3.setText("Minimum marks needed is 80 ");
                                    break;
                                case "A":
                                    result3.setText("Minimum marks needed is 70 ");
                                    break;
                                case "B+":
                                    result3.setText("Minimum marks needed is 60 ");
                                    break;
                                case "B":
                                    result3.setText("Minimum marks needed is 50 ");
                                    break;
                                case "C":
                                    result3.setText("Minimum marks needed is 40 ");
                                    break;
                                case "D":
                                    result3.setText("Minimum marks needed is 34 ");
                                    break;
                                case "E":
                                    result3.setText("Reappeaar ");
                                    break;
                                case "F":
                                    result3.setText("Fail ");
                                    break;
                                case "G":
                                    result3.setText("Backlog ");
                                    break;
                                case "I":
                                    result3.setText("Result Incomplete ");
                                    break;
                                default:
                                    result3.setText("Invalid Input  ");
                                    break;
                            }

                        }
                    }
                });

                /************ TOTAL CREDIT CALCULATOR *********************/
                p4 = new JPanel();
                p4.setLayout(null);
                p4.setBackground(new Color(10, 50, 60));
                mainpanel.add(p4, "TOTAL CREDIT CALCULATOR");

                JLabel g7 = new JLabel("CALCULATE");
                g7.setFont(new Font("Serif", Font.PLAIN, 80));
                g7.setForeground(Color.white);
                g7.setBounds(125, 0, 700, 130);
                p4.add(g7);

                JLabel g8 = new JLabel("TOTAL CREDIT");
                g8.setFont(new Font("Serif", Font.PLAIN, 80));
                g8.setForeground(Color.white);
                g8.setBounds(120, 75, 700, 130);
                p4.add(g8);

                lb4 = new JLabel("Enter Subject Credit: ");
                lb4.setFont(new Font("Serif", Font.PLAIN, 30));
                lb4.setForeground(Color.white);
                lb4.setBounds(170, 300, 300, 30);
                p4.add(lb4);

                lb5 = new JLabel("Enter Subject GradePoint: ");
                lb5.setFont(new Font("Serif", Font.PLAIN, 30));
                lb5.setForeground(Color.white);
                lb5.setBounds(170, 350, 350, 30);
                p4.add(lb5);

                ip4 = new JTextField();
                ip4.setFont(new Font("Serif", Font.PLAIN, 30));
                ip4.setBounds(485, 300, 60, 30);
                p4.add(ip4);

                ip5 = new JTextField();
                ip5.setFont(new Font("Serif", Font.PLAIN, 30));
                ip5.setBounds(485, 350, 60, 30);
                p4.add(ip5);

                calculateButton4 = new JButton("Calculate");
                calculateButton4.setSize(376, 30);
                calculateButton4.setLocation(170, 400);
                calculateButton4.setFont(objFont);
                calculateButton4.setCursor(objCur);
                p4.add(calculateButton4);
                calculateButton4.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {

                        if (e.getSource() == calculateButton4) {
                            int credit = Integer.parseInt(ip4.getText());
                            int gradePoint = Integer.parseInt(ip5.getText());
                            result4.setText("Total Credit: " + credit * gradePoint);
                        }
                    }
                });

                result4 = new JLabel("Total Credit: ?");
                result4.setFont(new Font("Serif", Font.PLAIN, 35));
                result4.setForeground(Color.white);
                result4.setBounds(200, 450, 350, 35);
                p4.add(result4);

                class MyClass implements ItemListener, FocusListener {
                    @Override
                    public void itemStateChanged(ItemEvent e) {
                        String item = (String) j1.getSelectedItem();
                        cl.show(mainpanel, item);
                    }

                    @Override
                    public void focusGained(FocusEvent e) {
                        if (e.getSource() == ip1) {
                            ip1.setEditable(true);
                            result1.setText("Grade : ?");
                            ip1.setText(null);
                        }
                        if (e.getSource() == ip2) {
                            ip2.setEditable(true);
                            result2.setText("Grade Point:  ?");
                            ip2.setText(null);
                        }
                        if (e.getSource() == ip3) {
                            ip3.setEditable(true);
                            result3.setText("Minimum marks needed is ?");
                            ip3.setText(null);
                        }

                        if (e.getSource() == ip4) {
                            ip4.setEditable(true);
                            result4.setText("Total Credit: ?");
                            ip4.setText(null);
                        }
                        if (e.getSource() == ip5) {
                            ip5.setEditable(true);
                            ip5.setText(null);
                        }
                    }

                    @Override
                    public void focusLost(FocusEvent e) {
                        if (e.getSource() == ip1) {
                            ip1.setEditable(false);
                        }
                        if (e.getSource() == ip2) {
                            ip2.setEditable(false);
                        }
                        if (e.getSource() == ip3) {
                            ip3.setEditable(false);
                        }
                        if (e.getSource() == ip3) {
                            ip3.setEditable(false);
                        }
                        if (e.getSource() == ip4) {
                            ip4.setEditable(false);
                        }
                        if (e.getSource() == ip5) {
                            ip5.setEditable(false);
                        }
                    }
                }
                MyClass ml = new MyClass();
                j1.addItemListener(ml);
                ip1.addFocusListener(ml);
                ip2.addFocusListener(ml);
                ip3.addFocusListener(ml);
                ip4.addFocusListener(ml);
                ip5.addFocusListener(ml);
                f.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosed(WindowEvent ke) {

                        obj1.setVisible(true);

                    }
                });
                f.setVisible(true);
            }
        });

        obj1.setVisible(true);
    }
}
