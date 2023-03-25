import javax.swing.JFrame;
import javax.swing.*;

import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class BtnOne implements ActionListener{
    public void actionPerformed(ActionEvent e){
        JFrame fOne=new JFrame();
        Color c1=new Color(10,50,60);
        Container c=fOne.getContentPane();
        c.setBackground(c1);
        fOne.setVisible(true);
        fOne.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        fOne.setBounds(100, 100, 1000,500);
    
        
        fOne.setVisible(true);
    }
}

class BtnTwo implements ActionListener{
    public void actionPerformed(ActionEvent e){
        JFrame fTwo=new JFrame();
        Color c1=new Color(10,50,60);
        Container c2=fTwo.getContentPane();
        c2.setBackground(c1);
        fTwo.setVisible(true);
        fTwo.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        fTwo.setBounds(100, 100, 1000,500);
        
        

        fTwo.setVisible(true);
    }
}

class BtnThree implements ActionListener{
    public void actionPerformed(ActionEvent e){
        JFrame obj=new JFrame();
        Color c1=new Color(10,50,60);
        Container c=obj.getContentPane();
        c.setBackground(c1);
        obj.setVisible(true);
        obj.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        obj.setBounds(100, 100, 1000,500);
    

        obj.setVisible(true);
    }
}

class BtnFour implements ActionListener{
    public void actionPerformed(ActionEvent e){
        JFrame obj=new JFrame();
        Color c1=new Color(10,50,60);
        Container c=obj.getContentPane();
        c.setBackground(c1);
        obj.setVisible(true);
        obj.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        obj.setBounds(100, 100, 1000,500);
    

        obj.setVisible(true);
    }
}

public class GradePredictorGui {
    
        public static void main(String[] args) {
            JFrame obj1=new JFrame();
            obj1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            obj1.setBounds(100, 100, 1000, 500);
            Container c=obj1.getContentPane();
            Color c1=new Color(10,50,60);
            c.setBackground(c1);
            c.setLayout(null);
            
            
            
            JButton btn1=new JButton("Full Result");
            JButton btn3=new JButton("GradePoint on Specific Marks");
            JButton btn2=new JButton("Grade on Specific Marks");
            JButton btn4=new JButton("Minimum Marks for Specific Grade");
            Font objFont=new Font("Arial",Font.PLAIN,20);
            Cursor objCur=new Cursor(Cursor.HAND_CURSOR);
        
            btn1.setSize(550,50);
            btn1.setLocation(200,100);
            btn1.setFont(objFont);
            btn1.setCursor(objCur);
            c.add(btn1);
            
            btn2.setSize(550,50);
            btn2.setLocation(200,160);
            btn2.setFont(objFont);
            btn2.setCursor(objCur);
            c.add(btn2);
            
            
            
            btn3.setSize(550,50);
            btn3.setLocation(200,220);
            btn3.setFont(objFont);
            btn3.setCursor(objCur);
            c.add(btn3);
            
            btn4.setSize(550,50);
            btn4.setLocation(200,280);
            btn4.setFont(objFont);
            btn4.setCursor(objCur);
            c.add(btn4);
    
            btn1.addActionListener(new BtnOne());
            btn2.addActionListener(new BtnTwo());
            btn3.addActionListener(new BtnThree());
            btn4.addActionListener(new BtnFour());
    
            
            obj1.setVisible(true);
    }
}