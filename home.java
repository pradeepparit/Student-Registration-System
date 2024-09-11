import java.awt.*;
import java.awt.event.*; 
import javax.swing.*;

public class home extends WindowAdapter {

  public static void main(String[] args) {
  
    JFrame frame = new JFrame("Dr. J.J. Magdum College of Engineering");

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    ImageIcon icon = new ImageIcon("jjm.jpg");

    JLabel label = new JLabel(icon);
    JButton  b1 = new JButton("New Registration");
    JButton  b2 = new JButton("Login");    

    label.setBounds(0,-170,400,700);
    b1.setBounds(470,100,150,30);
    b2.setBounds(470,150,150,30);

    frame.add(label);
    frame.add(b1);
    frame.add(b2);

    frame.setSize(700, 400);
    frame.setLayout(null);
    frame.setVisible(true);  

    b1.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            new registration();
  }
});

  b2.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            new login();
  }
});
  }
}
