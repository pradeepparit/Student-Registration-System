import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class logedin extends WindowAdapter  {

  public logedin(String user, String pass)
  {

    String username = user;
    String password = pass;
  
    try 
    {
      JFrame frame = new JFrame("Student Logged In");

      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


      Class.forName("com.mysql.cj.jdbc.Driver");
      Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/student_db","root", "");

      Statement statement;
      statement = connection.createStatement();
      ResultSet resultSet;

      System.out.println("Connection Established Successfull and the DATABASE NAME IS:" + connection.getMetaData().getDatabaseProductName());

      String query = "select name,ph_no,email,address,department,username, password from student where username='"+ user +"' and password='"+ pass +"'";
      PreparedStatement preparedStmt = connection.prepareStatement(query);
      resultSet = preparedStmt.executeQuery();
      
      ImageIcon icon = new ImageIcon("photo.jpg");

      JLabel label = new JLabel(icon);
      JLabel  l1 = new JLabel("Name : ");
      JLabel  l2 = new JLabel("Phone Number : ");
      JLabel  l3 = new JLabel("Email : ");
      JLabel  l4 = new JLabel("Address : ");
      JLabel  l5 = new JLabel("Class : ");
      JLabel  l6 = new JLabel("Username : ");
      JLabel  l7 = new JLabel("Password : ");

      JLabel  ll1 = new JLabel();
      JLabel  ll2 = new JLabel();
      JLabel  ll3 = new JLabel();
      JLabel  ll4 = new JLabel();
      JLabel  ll5 = new JLabel();
      JLabel  ll6 = new JLabel();
      JLabel  ll7 = new JLabel();

      while(resultSet.next())
        {
             ll1.setText(resultSet.getString("name"));
             ll2.setText(resultSet.getString("ph_no"));
             ll3.setText(resultSet.getString("email"));
             ll4.setText(resultSet.getString("address"));
             ll5.setText(resultSet.getString("department"));
             ll6.setText(resultSet.getString("username"));
             ll7.setText(resultSet.getString("password"));
        }

      JButton logout = new JButton("Logout");


      label.setBounds(0,-170,400,700);
      l1.setBounds(470,50,150,30);
      l2.setBounds(470,100,150,30);
      l3.setBounds(470,150,150,30);
      l4.setBounds(470,200,150,30);
      l5.setBounds(470,250,150,30);
      l6.setBounds(470,300,150,30);
      l7.setBounds(470,350,150,30);

      ll1.setBounds(600,50,200,30);
      ll2.setBounds(600,100,200,30);
      ll3.setBounds(600,150,200,30);
      ll4.setBounds(600,200,200,30);
      ll5.setBounds(600,250,200,30);
      ll6.setBounds(600,300,200,30);
      ll7.setBounds(600,350,200,30);

      logout.setBounds(700,400,150,30);

      frame.add(label);
      frame.add(l1);
      frame.add(l2);
      frame.add(l3);
      frame.add(l4);
      frame.add(l5);
      frame.add(l6);
      frame.add(l7);

      frame.add(ll1);
      frame.add(ll2);
      frame.add(ll3);
      frame.add(ll4);
      frame.add(ll5);
      frame.add(ll6);
      frame.add(ll7);

      frame.add(logout);

      frame.setSize(1000, 500);
      frame.setLayout(null);
      frame.setVisible(true);  

      logout.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
            frame.dispose();
    }
  });
}
catch(Exception e)
{
  System.out.println("Got an Exception...");
  System.out.println(e.getMessage());
}
}
  
}