import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;

public class LPU_AcademicCalculatorGui {
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
        obj1.setTitle("LPU Academic Calculator");

        ImageIcon icon = new ImageIcon("ok.jpg");
        obj1.setIconImage(icon.getImage());
        obj1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        obj1.setSize(750, 850);
        obj1.setLocationRelativeTo(null);
        Container c = obj1.getContentPane();
        Color c1 = new Color(10, 50, 60);
        Color c2 = new Color(237, 241, 214);
        Color c5 = new Color(0, 0, 0);
        c.setBackground(c5);
        obj1.setLayout(null);

        JLabel lpu = new JLabel("LPU");
        lpu.setFont(new Font("Serif", Font.PLAIN, 70));
        lpu.setForeground(new Color(232,106,51));
        lpu.setBounds(315, 0, 700, 130);
        obj1.add(lpu);

        JLabel gradePredictor = new JLabel("ACADEMIC");
        gradePredictor.setFont(new Font("Serif", Font.PLAIN, 70));
        gradePredictor.setForeground(c2);
        gradePredictor.setBounds(190, 60, 700, 130);
        obj1.add(gradePredictor);

        JLabel gradePredictor2 = new JLabel("CALCULATOR");
        gradePredictor2.setFont(new Font("Serif", Font.PLAIN, 70));
        gradePredictor2.setForeground(c2);
        gradePredictor2.setBounds(150, 125, 700, 130);
        obj1.add(gradePredictor2);

        Font objFont = new Font("Serif", Font.PLAIN, 27);
        Cursor objCur = new Cursor(Cursor.HAND_CURSOR);

        JButton btn1 = new JButton("CGPA Calculator");
        btn1.setForeground(c1);
        btn1.setSize(600, 100);
        btn1.setLocation(70, 330);
        btn1.setFont(objFont);
        btn1.setCursor(objCur);
        obj1.add(btn1);
        btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                class ProblemHandling extends Exception {
                    ProblemHandling(String msg) {
                        UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("Arial", Font.PLAIN, 20)));
                        JOptionPane.showMessageDialog(null, msg);
                    }
                }
                try {
                    obj1.setVisible(false);
                    JFrame f1 = new JFrame("CGPA Calculator");
                    f1.setIconImage(icon.getImage());
                    f1.setResizable(false);
                    f1.setSize(350, 650);
                    f1.setLocationRelativeTo(null);
                    f1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                    JLabel gradeLabel = new JLabel("  Enter Grade ");
                    gradeLabel.setForeground(c2);
                    gradeLabel.setFont(new Font("Ariel", 1, 20));
                    JLabel creditLabel = new JLabel("  Enter Credit");
                    creditLabel.setForeground(c2);
                    creditLabel.setFont(new Font("Ariel", 1, 20));

                    int n = Integer.parseInt(JOptionPane.showInputDialog("Enter number of subjects but less than 20."));
                    
                    if (n > 20) {
                        throw new ProblemHandling("Enter number of subjects less than 20.");
                    }

                    JTextField[] gradeField = new JTextField[n];
                    JTextField[] creditField = new JTextField[n];

                    for (int i = 0; i < n; i++) {

                        gradeField[i] = new JTextField(5);
                        gradeField[i].setBackground(c2);
                        gradeField[i].setForeground(c5);
                        gradeField[i].setFont(new Font("Ariel", 1, 30));
                        gradeField[i].setHorizontalAlignment(JTextField.CENTER);

                        creditField[i] = new JTextField(5);
                        creditField[i].setBackground(c2);
                        creditField[i].setForeground(c5);
                        creditField[i].setFont(new Font("Ariel", 1, 30));
                        creditField[i].setHorizontalAlignment(JTextField.CENTER);
                    }

                    JButton calculateButton = new JButton("Calculate");
                    calculateButton.setForeground(c1);
                    calculateButton.setBounds(10, 760, 300, 60);
                    calculateButton.setFont(new Font("Serif", 0, 50));
                    calculateButton.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            try {
                                int totalCredit = 0;
                                double totalGrade = 0.0;
                                for (int i = 0; i < n; i++) {
                                    String grade = gradeField[i].getText();
                                    String credit = creditField[i].getText();
                                    if(grade.isEmpty() && credit.isEmpty()){
                                        throw new ProblemHandling("Empty Grade and Credit Field.");
                                    }
                                    if (grade.isEmpty()) {
                                        throw new ProblemHandling("Empty Grade Field.");
                                    }
                                    if (credit.isEmpty()) {
                                        throw new ProblemHandling("Empty Credit Field.");
                                    }
                                    if (!grade.matches("[oOaA][+-]?|B[+-]?|C[+-]?|D[+-]?|E|F|G|[oa][+-]?|b[+-]?|c[+-]?|d[+-]?|e|f|g")) {
                                        throw new ProblemHandling("Invalid Grade Input.");
                                    }
                                    if (!credit.matches("1|2|3|4")) {
                                        throw new ProblemHandling("Invalid Credit Input.");
                                    }

                                    totalCredit += Integer.parseInt(credit);
                                    totalGrade += GradePoint(grade) * Integer.parseInt(credit);
                                }
                                double cgpa = totalGrade / totalCredit;
                                UIManager.put("OptionPane.messageFont",new FontUIResource(new Font("Arial", Font.PLAIN, 20)));
                                JOptionPane.showMessageDialog(f1, "Your CGPA is: " + String.format("%.2f", cgpa));
                            } 
                            catch (Exception ak) {
                                
                            }

                        }
                    });

                    f1.setLayout(new BorderLayout());

                    JPanel inputPanel = new JPanel(new GridLayout(n + 1, 2));
                    inputPanel.setBackground(c5);
                    inputPanel.add(gradeLabel);
                    inputPanel.add(creditLabel);

                    for (int i = 0; i < n; i++) {
                        inputPanel.add(gradeField[i]);
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
                } 
                catch (Exception me) {
                    obj1.setVisible(true);
                }

            }

            public double GradePoint(String Grade) {

                switch (Grade.toUpperCase()) {
                    case "O":
                        return 10;
                    case "A+":
                        return 9;
                    case "A":
                        return 8;
                    case "B+":
                        return 7;
                    case "B":
                        return 6;
                    case "C":
                        return 5;
                    case "D":
                        return 4;
                    case "E":
                        return 0;
                    case "F":
                        return 0;
                    case "G":
                        return 0;
                    default:
                        return 0;

                }

            }
        });

        JButton btn2 = new JButton("Grade, GradePoint, Minimum Marks, Total Credit ");
        btn2.setForeground(c1);
        btn2.setSize(600, 100);
        btn2.setLocation(70, 460);
        btn2.setFont(objFont);
        btn2.setCursor(objCur);
        obj1.add(btn2);
        btn2.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                obj1.setVisible(false);
                JFrame f = new JFrame();
                f.setTitle("LPU Academic Calculator");
                f.setResizable(false);
                f.setSize(750, 850);
                f.setIconImage(icon.getImage());
                f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                f.setLocationRelativeTo(null);

                String[] options = { "GRADE CALCULATOR", "GRADE POINT CALCULATOR", "MINIMUM MARKS CALCULATOR","TOTAL CREDIT CALCULATOR" };
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
                p1.setBackground(c5);
                mainpanel.add(p1, "GRADE CALCULATOR");

                JLabel g1 = new JLabel("CALCULATE");
                g1.setFont(new Font("Serif", Font.PLAIN, 80));
                g1.setForeground(c2);
                g1.setBounds(145, 0, 700, 130);
                p1.add(g1);

                JLabel g2 = new JLabel("GRADE");
                g2.setFont(new Font("Serif", Font.PLAIN, 80));
                g2.setForeground(c2);
                g2.setBounds(235, 75, 700, 130);
                p1.add(g2);

                lb1 = new JLabel("Enter your marks: ");
                lb1.setFont(new Font("Serif", Font.PLAIN, 30));
                lb1.setForeground(c2);
                lb1.setBounds(200, 350, 350, 35);
                p1.add(lb1);

                ip1 = new JTextField();

                ip1.setHorizontalAlignment(JTextField.CENTER);
                ip1.setFont(new Font("Serif", Font.PLAIN, 30));
                ip1.setBounds(445, 350, 105, 30);
                p1.add(ip1);

                calculateButton = new JButton("Calculate");
                calculateButton.setForeground(c1);
                calculateButton.setSize(350, 30);
                calculateButton.setLocation(200, 400);
                calculateButton.setFont(objFont);
                calculateButton.setCursor(objCur);
                p1.add(calculateButton);
                calculateButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if (ip1.getText().isEmpty()) {
                            UIManager.put("OptionPane.messageFont",new FontUIResource(new Font("Arial", Font.PLAIN, 20)));
                            JOptionPane.showMessageDialog(null, "Please Enter Marks.");
                        } 
                        else {
                            try {
                                if (e.getSource() == calculateButton) {
                                    Double marks = Double.parseDouble(ip1.getText());
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
                                    else if (marks >= 0 && marks < 34)
                                        result1.setText("Fail");
                                    else if (marks > 100 || marks < 0) {
                                        UIManager.put("OptionPane.messageFont",new FontUIResource(new Font("Arial", Font.PLAIN, 20)));
                                        JOptionPane.showMessageDialog(null, "No Grade for this marks.");
                                    } 
                                    else
                                        throw new Exception();
                                }
                            } 
                            catch (Exception ge) {
                                UIManager.put("OptionPane.messageFont",new FontUIResource(new Font("Arial", Font.PLAIN, 20)));
                                JOptionPane.showMessageDialog(null, "Enter numeric value only.");
                            }
                        }

                    }
                });

                result1 = new JLabel("Grade : ?");
                result1.setFont(new Font("Serif", Font.PLAIN, 35));
                result1.setForeground(c2);
                result1.setBounds(200, 450, 350, 35);
                p1.add(result1);

                /********************** GRADE POINT CALCULATOR****************************** */

                p2 = new JPanel();
                p2.setLayout(null);
                p2.setBackground(c5);
                mainpanel.add(p2, "GRADE POINT CALCULATOR");

                JLabel g3 = new JLabel("CALCULATE");
                g3.setFont(new Font("Serif", Font.PLAIN, 80));
                g3.setForeground(c2);
                g3.setBounds(135, 0, 700, 130);
                p2.add(g3);

                JLabel g4 = new JLabel("GRADE POINT");
                g4.setFont(new Font("Serif", Font.PLAIN, 80));
                g4.setForeground(c2);
                g4.setBounds(120, 75, 700, 130);
                p2.add(g4);

                lb2 = new JLabel("Enter your marks: ");
                lb2.setFont(new Font("Serif", Font.PLAIN, 30));
                lb2.setForeground(c2);
                lb2.setBounds(200, 350, 250, 35);
                p2.add(lb2);

                ip2 = new JTextField();
                ip2.setHorizontalAlignment(JTextField.CENTER);
                ip2.setFont(new Font("Serif", Font.PLAIN, 30));
                ip2.setBounds(445, 350, 105, 30);
                p2.add(ip2);

                calculateButton2 = new JButton("Calculate ");
                calculateButton2.setForeground(c1);
                calculateButton2.setSize(350, 30);
                calculateButton2.setLocation(200, 400);
                calculateButton2.setFont(objFont);
                calculateButton2.setCursor(objCur);
                p2.add(calculateButton2);
                calculateButton2.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if (ip2.getText().isEmpty()) {
                            UIManager.put("OptionPane.messageFont",new FontUIResource(new Font("Arial", Font.PLAIN, 20)));
                            JOptionPane.showMessageDialog(null, "Please Enter Marks.");
                        } 
                        else {
                            try {
                                if (e.getSource() == calculateButton2) {
                                    Double mark = Double.parseDouble(ip2.getText());
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
                                    else if (mark >= 0 && mark < 34)
                                        result2.setText("GradePoint:  0");
                                    else if (mark > 100 && mark < 0) {
                                        UIManager.put("OptionPane.messageFont",new FontUIResource(new Font("Arial", Font.PLAIN, 20)));
                                        JOptionPane.showMessageDialog(null, "No GradePoint for this mark.");
                                    }
                                    else
                                        throw new Exception();

                                }
                            } 
                            catch (Exception ge) {
                                UIManager.put("OptionPane.messageFont",new FontUIResource(new Font("Arial", Font.PLAIN, 20)));
                                JOptionPane.showMessageDialog(null, "Enter Numeric value only.");
                            }
                        }
                    }
                });

                result2 = new JLabel("Grade Point:  ?");
                result2.setFont(new Font("Serif", Font.PLAIN, 35));
                result2.setForeground(c2);
                result2.setBounds(200, 450, 250, 35);
                p2.add(result2);

                /**************** MINIMUM MARKS CALCULATOR ***********************/
                p3 = new JPanel();
                p3.setLayout(null);
                p3.setBackground(c5);
                mainpanel.add(p3, "MINIMUM MARKS CALCULATOR");

                JLabel g5 = new JLabel("CALCULATE");
                g5.setFont(new Font("Serif", Font.PLAIN, 75));
                g5.setForeground(c2);
                g5.setBounds(135, 0, 700, 130);
                p3.add(g5);

                JLabel g6 = new JLabel("MINIMUM MARKS");
                g6.setFont(new Font("Serif", Font.PLAIN, 75));
                g6.setForeground(c2);
                g6.setBounds(60, 75, 700, 130);
                p3.add(g6);

                lb3 = new JLabel("Enter your Grade: ");
                lb3.setFont(new Font("Serif", Font.PLAIN, 30));
                lb3.setForeground(c2);
                lb3.setBounds(170, 350, 230, 35);
                p3.add(lb3);

                ip3 = new JTextField();
                ip3.setHorizontalAlignment(JTextField.CENTER);
                ip3.setFont(new Font("Serif", Font.PLAIN, 30));
                ip3.setBounds(395, 350, 175, 30);
                p3.add(ip3);

                result3 = new JLabel("Minimum marks needed is ?");
                result3.setFont(new Font("Serif", Font.PLAIN, 34));
                result3.setForeground(c2);
                result3.setBounds(170, 450, 550, 35);
                p3.add(result3);

                calculateButton3 = new JButton("Calculate");
                calculateButton3.setForeground(c1);
                calculateButton3.setSize(400, 30);
                calculateButton3.setLocation(170, 400);
                calculateButton3.setFont(objFont);
                calculateButton3.setCursor(objCur);
                p3.add(calculateButton3);
                calculateButton3.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if (ip3.getText().isEmpty()) {
                            UIManager.put("OptionPane.messageFont",new FontUIResource(new Font("Arial", Font.PLAIN, 20)));
                            JOptionPane.showMessageDialog(null, "Please Enter Grade.");
                        } 
                        else {
                            try {
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
                                            throw new Exception();

                                    }

                                }
                            } 
                            catch (Exception ge) {
                                UIManager.put("OptionPane.messageFont",new FontUIResource(new Font("Arial", Font.PLAIN, 20)));
                                JOptionPane.showMessageDialog(null, "Invalid Grade Input");
                            }
                        }

                    }
                });

                /************ TOTAL CREDIT CALCULATOR *********************/
                p4 = new JPanel();
                p4.setLayout(null);
                p4.setBackground(c5);
                mainpanel.add(p4, "TOTAL CREDIT CALCULATOR");

                JLabel g7 = new JLabel("CALCULATE");
                g7.setFont(new Font("Serif", Font.PLAIN, 80));
                g7.setForeground(c2);
                g7.setBounds(125, 0, 700, 130);
                p4.add(g7);

                JLabel g8 = new JLabel("TOTAL CREDIT");
                g8.setFont(new Font("Serif", Font.PLAIN, 80));
                g8.setForeground(c2);
                g8.setBounds(120, 75, 700, 130);
                p4.add(g8);

                lb4 = new JLabel("Enter Subject Credit: ");
                lb4.setFont(new Font("Serif", Font.PLAIN, 30));
                lb4.setForeground(c2);
                lb4.setBounds(170, 300, 300, 35);
                p4.add(lb4);

                lb5 = new JLabel("Enter Subject GradePoint: ");
                lb5.setFont(new Font("Serif", Font.PLAIN, 30));
                lb5.setForeground(c2);
                lb5.setBounds(170, 350, 350, 35);
                p4.add(lb5);

                ip4 = new JTextField();
                ip4.setHorizontalAlignment(JTextField.CENTER);
                ip4.setFont(new Font("Serif", Font.PLAIN, 30));
                ip4.setBounds(485, 300, 60, 30);
                p4.add(ip4);

                ip5 = new JTextField();
                ip5.setHorizontalAlignment(JTextField.CENTER);
                ip5.setFont(new Font("Serif", Font.PLAIN, 30));
                ip5.setBounds(485, 350, 60, 30);
                p4.add(ip5);

                calculateButton4 = new JButton("Calculate");
                calculateButton4.setForeground(c1);
                calculateButton4.setSize(376, 30);
                calculateButton4.setLocation(170, 400);
                calculateButton4.setFont(objFont);
                calculateButton4.setCursor(objCur);
                p4.add(calculateButton4);
                calculateButton4.addActionListener(new ActionListener() {

                    public void actionPerformed(ActionEvent e) {

                        if (ip4.getText().isEmpty() && ip5.getText().isEmpty()) {
                            UIManager.put("OptionPane.messageFont",new FontUIResource(new Font("Arial", Font.PLAIN, 20)));
                            JOptionPane.showMessageDialog(null, "You didn't entered any value.");
                        } 
                        else if (ip4.getText().isEmpty()) {
                            UIManager.put("OptionPane.messageFont",new FontUIResource(new Font("Arial", Font.PLAIN, 20)));
                            JOptionPane.showMessageDialog(null, "Please Enter credit.");
                        } 
                        else if (ip5.getText().isEmpty()) {
                            UIManager.put("OptionPane.messageFont",new FontUIResource(new Font("Arial", Font.PLAIN, 20)));
                            JOptionPane.showMessageDialog(null, "Please Enter Gradepoint.");
                        } 
                        else {
                            try {
                                if (e.getSource() == calculateButton4) {
                                    int credit = Integer.parseInt(ip4.getText());
                                    int gradePoint = Integer.parseInt(ip5.getText());
                                    if (credit > 0 && credit < 5) {
                                        if (gradePoint > 3 && gradePoint <= 10) {
                                            result4.setText("Total Credit: " + credit * gradePoint);
                                        } 
                                        else {

                                            UIManager.put("OptionPane.messageFont",new FontUIResource(new Font("Arial", Font.PLAIN, 20)));
                                            JOptionPane.showMessageDialog(null, "Enter GradePoint b/w 3-11.");
                                        }
                                    } 
                                    else {
                                        UIManager.put("OptionPane.messageFont",new FontUIResource(new Font("Arial", Font.PLAIN, 20)));
                                        JOptionPane.showMessageDialog(null, "Enter Credit 1,2,3,or 4.");

                                    }
                                } 
                                else
                                    throw new Exception();
                            } catch (Exception ge) {
                                UIManager.put("OptionPane.messageFont",new FontUIResource(new Font("Arial", Font.PLAIN, 20)));
                                JOptionPane.showMessageDialog(null, "Enter Numeric Value Only.");
                            }
                        }

                    }
                });

                result4 = new JLabel("Total Credit: ?");
                result4.setFont(new Font("Serif", Font.PLAIN, 35));
                result4.setForeground(c2);
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
