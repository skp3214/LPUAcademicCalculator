



import javax.swing.*;

import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



class BtnTwo implements ActionListener{

    private JLabel gradeLabel1,gradePointLabel,gradePointLabel2,creditPointLabel,creditPointLabel2;
    private JLabel gradeCalc,gradePointCalc,minimumMarksCalc,creditPointCalc;
    private JTextField gradeInput,gradePointInput,gradePointInput2,creditPointInput,gradePointInput4;
    private JButton calculateButton,calculateButton2,calculateButton3,calculateButton4;
    private JLabel result1,result2,result3,result4;

    BtnTwo(){
        JFrame fTwo=new JFrame();
        fTwo.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        fTwo.setBounds(0, 0, 1650, 1080);
        Color c2=new Color(10,50,60);
        Container c=fTwo.getContentPane();
        c.setBackground(c2);
        c.setLayout(null);
        Font objFont=new Font("Arial",Font.PLAIN,20);
        Cursor objCur=new Cursor(Cursor.HAND_CURSOR);
        JLabel gradePredictor=new JLabel("GRADE PREDICTOR");
        gradePredictor.setFont(new Font("Serif", Font.PLAIN, 160));
        gradePredictor.setForeground(Color.white);
        
        gradePredictor.setBounds(35,20,1500,130);
        c.add(gradePredictor);

        /*****************************        GRADE CALCULATOR SECTION        **********************************/

        gradeCalc=new JLabel("CALCULATE GRADE");
        gradeCalc.setFont(new Font("Serif", Font.PLAIN, 25));
        gradeCalc.setForeground(Color.white);
        gradeCalc.setBounds(205,300,250,30);
        c.add(gradeCalc);

        gradeLabel1=new JLabel("Enter your marks: ");
        gradeLabel1.setFont(new Font("Serif", Font.PLAIN, 20));
        gradeLabel1.setForeground(Color.white);
        gradeLabel1.setBounds(200,350,150,20);
        c.add(gradeLabel1);
    
        gradeInput=new JTextField();
        gradeInput.setBounds(345,350,105,30);
        c.add(gradeInput);

        calculateButton=new JButton("Calculate");
        calculateButton.setSize(250,30);
        calculateButton.setLocation(200,400);
        calculateButton.setFont(objFont);
        calculateButton.setCursor(objCur);
        c.add(calculateButton);
        calculateButton.addActionListener(this);

        result1=new JLabel(" ");      
        result1.setFont(new Font("Serif", Font.PLAIN, 25));
        result1.setForeground(Color.white);
        result1.setBounds(200,450,250,35);
        c.add(result1);


        /***********************            GRADEPOINT CALCULATOR SECTION   **************************************/
        
        gradePointCalc=new JLabel("CALCULATE GRADEPOINT");
        gradePointCalc.setFont(new Font("Serif", Font.PLAIN, 25));
        gradePointCalc.setForeground(Color.white);
        gradePointCalc.setBounds(905,300,350,30);
        c.add(gradePointCalc);
        
        gradePointLabel=new JLabel("Enter your marks: ");
        gradePointLabel.setFont(new Font("Serif", Font.PLAIN, 20));
        gradePointLabel.setForeground(Color.white);
        gradePointLabel.setBounds(905,350,150,20);
        c.add(gradePointLabel);
        
        gradePointInput=new JTextField();
        gradePointInput.setBounds(1050,350,169,30);
        c.add(gradePointInput);
        
        calculateButton2=new JButton("Calculate");
        calculateButton2.setSize(315,30);
        calculateButton2.setLocation(905,400);
        calculateButton2.setFont(objFont);
        calculateButton2.setCursor(objCur);
        c.add(calculateButton2);
        calculateButton2.addActionListener(this);
        
        result2=new JLabel(" ");      
        result2.setFont(new Font("Serif", Font.PLAIN, 25));
        result2.setForeground(Color.white);
        result2.setBounds(905,450,250,35);
        c.add(result2);
        
        /***********************            MINIMUM MARKS CALCULATOR SECTION   **************************************/

        minimumMarksCalc=new JLabel("CALCULATE MINIMUM MARKS");
        minimumMarksCalc.setFont(new Font("Serif", Font.PLAIN, 22));
        minimumMarksCalc.setForeground(Color.white);
        minimumMarksCalc.setBounds(200,550,350,30);
        c.add(minimumMarksCalc);
        
        gradePointLabel2=new JLabel("Enter your Grade: ");
        gradePointLabel2.setFont(new Font("Serif", Font.PLAIN, 20));
        gradePointLabel2.setForeground(Color.white);
        gradePointLabel2.setBounds(200,600,150,20);
        c.add(gradePointLabel2);
        
        gradePointInput2=new JTextField();
        gradePointInput2.setBounds(345,600,169,30);
        c.add(gradePointInput2);
        
        calculateButton3=new JButton("Calculate");
        calculateButton3.setSize(315,30);
        calculateButton3.setLocation(200,650);
        calculateButton3.setFont(objFont);
        calculateButton3.setCursor(objCur);
        c.add(calculateButton3);
        calculateButton3.addActionListener(this);
        
        result3=new JLabel(" ");      
        result3.setFont(new Font("Serif", Font.PLAIN, 25));
        result3.setForeground(Color.white);
        result3.setBounds(200,700,350,35);
        c.add(result3);
        /***********************            CREDIT POINT CALCULATOR SECTION   **************************************/

        creditPointCalc=new JLabel("CALCULATE CREDIT POINT");
        creditPointCalc.setFont(new Font("Serif", Font.PLAIN, 22));
        creditPointCalc.setForeground(Color.white);
        creditPointCalc.setBounds(905,550,350,30);
        c.add(creditPointCalc);
        
        creditPointLabel=new JLabel("Enter Subject Credit: ");
        creditPointLabel.setFont(new Font("Serif", Font.PLAIN, 20));
        creditPointLabel.setForeground(Color.white);
        creditPointLabel.setBounds(905,600,200,20);
        c.add(creditPointLabel);

        creditPointLabel2=new JLabel("Enter Subject GradePoint: ");
        creditPointLabel2.setFont(new Font("Serif", Font.PLAIN, 20));
        creditPointLabel2.setForeground(Color.white);
        creditPointLabel2.setBounds(905,650,220,20);
        c.add(creditPointLabel2);
        
        creditPointInput=new JTextField();
        creditPointInput.setBounds(1100,600,120,30);
        c.add(creditPointInput);

        gradePointInput4=new JTextField();
        gradePointInput4.setBounds(1120,650,100,30);
        c.add(gradePointInput4);
        
        calculateButton4=new JButton("Calculate");
        calculateButton4.setSize(315,30);
        calculateButton4.setLocation(905,700);
        calculateButton4.setFont(objFont);
        calculateButton4.setCursor(objCur);
        c.add(calculateButton4);
        calculateButton4.addActionListener(this);
        
        result4=new JLabel(" ");      
        result4.setFont(new Font("Serif", Font.PLAIN, 25));
        result4.setForeground(Color.white);
        result4.setBounds(905,750,350,35);
        c.add(result4);
    

        fTwo.setVisible(true);
    }
     
    public void actionPerformed(ActionEvent e){

        /*        GRADE CALCULATOR SECTION        */

        if (e.getSource() == calculateButton) {
            int marks=Integer.parseInt(gradeInput.getText());
            if(marks>=90 && marks<=100)result1.setText("Grade : O  ");
            else if(marks>=80 && marks<90)result1.setText("Grade : A+ ");
            else if(marks>=70 && marks<80)result1.setText("Grade :  A ");
            else if(marks>=60 && marks<70)result1.setText("Grade :  B+ ");
            else if(marks>=50 && marks<60)result1.setText("Grade :  B ");
            else if(marks>=40 && marks<50)result1.setText("Grade :  C ");
            else if(marks<40)result1.setText("Grade : F (Fail) ");
            else result1.setText("Invalid Marks Input ");    
        }

        /*       GRADEPOINT CALCULATOR SECTION      */
        
        if (e.getSource() == calculateButton2) {
            int mark=Integer.parseInt(gradePointInput.getText());
            if(mark>=90 && mark<=100)result2.setText("Grade Point:  10 ");
            else if(mark>=80 && mark<90)result2.setText("Grade Point:  9 ");
            else if(mark>=70 && mark<80)result2.setText("Grade Point:  8 ");
            else if(mark>=60 && mark<70)result2.setText("Grade Point:  7 ");
            else if(mark>=50 && mark<60)result2.setText("Grade Point:  6 ");
            else if(mark>=40 && mark<50)result2.setText("Grade Point:  5 ");
            else if(mark<40)result2.setText("You are Fail ");
            else result2.setText("Invalid Marks Input ");       
        }
        
        /*       MINIMUM MARKS CALCULATOR SECTION      */

        
        if (e.getSource() == calculateButton3) {
            String grade=gradePointInput2.getText().toUpperCase();
            switch (grade) {
                case "O":result3.setText("Minimum marks needed is 90 ");break;
                case "A+":result3.setText("Minimum marks needed is 80 ");break;
                case "A": result3.setText("Minimum marks needed is 70 "); break;
                case "B+": result3.setText("Minimum marks needed is 60 "); break;
                case "B": result3.setText("Minimum marks needed is 50 "); break;
                case "C": result3.setText("Minimum marks needed is 40 "); break;
                default:result3.setText("You will be Fail  "); break;
            }
        }
        /*       Credit Point Calculator      */

        
        if (e.getSource() == calculateButton4) {
           int credit=Integer.parseInt(creditPointInput.getText());
           int gradePoint=Integer.parseInt(gradePointInput4.getText());
           result4.setText("Credit point: "+credit*gradePoint);
        }

}
}


public class GradePredictorGui {
    public static void main(String[] args) {
        JFrame obj1=new JFrame();
        obj1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        obj1.setBounds(0, 0, 1650, 1080);
        Container c=obj1.getContentPane();
        Color c1=new Color(10,50,60);
        c.setBackground(c1);
        c.setLayout(null);
        
        JLabel gradePredictor=new JLabel("GRADE PREDICTOR");
        gradePredictor.setFont(new Font("Serif", Font.PLAIN, 160));
        gradePredictor.setForeground(Color.white);
        
        gradePredictor.setBounds(35,20,1500,130);
        c.add(gradePredictor);

        
        
        JButton btn2=new JButton("Grade, GradePoint, Minimum Marks ");

        Font objFont=new Font("Serif",Font.PLAIN,27);
        Cursor objCur=new Cursor(Cursor.HAND_CURSOR);
    
        
        btn2.setSize(550,100);
        btn2.setLocation(500,460);
        btn2.setFont(objFont);
        btn2.setCursor(objCur);
        c.add(btn2);
        
  

     
        btn2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                new BtnTwo();
            }
        });
      

        
        obj1.setVisible(true);
    }
}


