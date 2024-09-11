import java.awt.*;
import java.awt.event.*; 
import javax.swing.*;
import java.sql.*;

public class registration extends WindowAdapter  {

  public registration(){

  
    JFrame frame = new JFrame("Registration");
    

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    ImageIcon icon = new ImageIcon("logo.jpg");

    Font  f1  = new Font(Font.SANS_SERIF, Font.BOLD, 17);

    JLabel label = new JLabel(icon);

    JLabel  label1 = new JLabel("New Registration");
    label1.setFont(f1);

    JLabel  l1 = new JLabel("Name : ");
    JLabel  l2 = new JLabel("Phone Number : ");
    JLabel  l3 = new JLabel("Email : ");
    JLabel  l4 = new JLabel("Address : ");
    JLabel  l5 = new JLabel("Class : ");
    JLabel  l6 = new JLabel("Username : ");
    JLabel  l7 = new JLabel("Password : ");
    JLabel  error = new JLabel("");

    error.setForeground(new Color(255, 0, 0));

    JTextField t1 = new JTextField();
    JTextField t2 = new JTextField();
    JTextField t3 = new JTextField();
    JTextField t4 = new JTextField();
    JTextField t5 = new JTextField();

    String department[]={"CS","IT","AI","ENTC","ETC","Civil","Mechanical"};        
    JComboBox cb =new JComboBox(department);  

    TextField ps = new TextField(); 
    ps.setEchoChar('*');

    JButton submit = new JButton("Submit");
    JButton cancel = new JButton("Cancel");


    label.setBounds(0,-170,400,900);
    label1.setBounds(550,10,200,30);
    
    l1.setBounds(470,50,150,30);
    l2.setBounds(470,100,150,30);
    l3.setBounds(470,150,150,30);
    l4.setBounds(470,200,150,30);
    l5.setBounds(470,250,150,30);
    l6.setBounds(470,300,150,30);
    l7.setBounds(470,350,150,30);
    error.setBounds(470,450,150,30);

    t1.setBounds(650,50,150,30);
    t2.setBounds(650,100,150,30);
    t3.setBounds(650,150,150,30);
    t4.setBounds(650,200,150,30);
    t5.setBounds(650,300,150,30);

    cb.setBounds(650,250,150,30);

    ps.setBounds(650,350,150,30);   

    submit.setBounds(470,550,150,30);
    cancel.setBounds(650,550,150,30);

    frame.add(label);
    frame.add(label1);

    frame.add(l1);
    frame.add(l2);
    frame.add(l3);
    frame.add(l4);
    frame.add(l5);
    frame.add(l6);
    frame.add(l7);
    frame.add(error);

    frame.add(t1);
    frame.add(t2);
    frame.add(t3);
    frame.add(t4);
    frame.add(t5);

    frame.add(cb);

    frame.add(ps);

    frame.add(submit);
    frame.add(cancel);

    frame.setSize(900, 700);
    frame.setLayout(null);
    frame.setVisible(true);  

  submit.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {

          try{

            String name,ph_no,email,address,department,username,password;

            if (!t1.getText().isEmpty() && !t2.getText().isEmpty() && !t3.getText().isEmpty() && !t4.getText().isEmpty() && !t5.getText().isEmpty() && ps.getText() != null)
              {
                error.setText("");

                name = t1.getText();
                ph_no = t2.getText();
                email = t3.getText();
                address = t4.getText();
                department = (String) cb.getSelectedItem();
                username = t5.getText();
                password = ps.getText();

    try{

                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/student_db","root", "");


                Statement statement;
                statement = connection.createStatement();

                System.out.println("Connection Established Successfull and the DATABASE NAME IS:" + connection.getMetaData().getDatabaseProductName());


                String query = " insert into student (name, ph_no, email, address, department, username, password)" + " values (?, ?, ?, ?, ?, ?, ?)";

                PreparedStatement preparedStmt = connection.prepareStatement(query);
                preparedStmt.setString (1, name);
                preparedStmt.setString (2, ph_no);
                preparedStmt.setString (3, email);
                preparedStmt.setString (4, address);
                preparedStmt.setString (5, department);
                preparedStmt.setString (6, username);
                preparedStmt.setString (7, password);

                // execute the preparedstatement
                preparedStmt.execute();
                System.out.println("All data filled...");

                frame.dispose(); 

                }
                catch (Exception dbe)
                {
                  System.out.println("Got an exception: "+dbe.getMessage());
                }
              }
            else
              {
                error.setText("Enter All Details...");
                System.out.println("Enter All Details..."); 
              }
            }

            catch(Exception ee)
            {System.out.println("Error:"+ee);}
  }
});

cancel.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            frame.dispose();
  }
});

}

 public static void main(String[] args) {

  registration r = new registration();

}

}