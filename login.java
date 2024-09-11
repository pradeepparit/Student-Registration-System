import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class login extends WindowAdapter  {

  public login()
  {
  
    JFrame frame = new JFrame("Student Login");

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    ImageIcon icon = new ImageIcon("jjm.jpg");

    JLabel label = new JLabel(icon);
    JLabel  lusername = new JLabel("Username:");
    JLabel  lpassword = new JLabel("Password:"); 
    Label i = new Label("");

    JTextField username = new JTextField();
    TextField password = new TextField();   

    JButton login = new JButton("Login");
    JButton cancel = new JButton("Cancel");

    password.setEchoChar('*');

    label.setBounds(0,-170,400,700);
    lusername.setBounds(500,50,150,30);
    username.setBounds(670,50,150,30);
    lpassword.setBounds(500,100,150,30);
    password.setBounds(670,100,150,30);
    login.setBounds(500,200,150,30);
    cancel.setBounds(670,200,150,30);
    i.setBounds(500,130,150,30);

    frame.add(label);
    frame.add(lusername);
    frame.add(username);
    frame.add(lpassword);
    frame.add(password);
    frame.add(login);
    frame.add(cancel);
    frame.add(i);

    frame.setSize(1000, 700);
    frame.setLayout(null);
    frame.setVisible(true);  

    login.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            String user = username.getText();
            String pass = password.getText();

            try{

                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/student_db","root", "");

                Statement statement;
                statement = connection.createStatement();
                ResultSet resultSet;

                System.out.println("Connection Established Successfull and the DATABASE NAME IS:" + connection.getMetaData().getDatabaseProductName());

                String query = "select username, password from student where username='"+ user +"' and password='"+ pass +"'";
                PreparedStatement preparedStmt = connection.prepareStatement(query);
                resultSet = preparedStmt.executeQuery();

                while(resultSet.next())
                {
                  if (user.equals(resultSet.getString("username")) && pass.equals(resultSet.getString("password")))
                    {
                        new logedin(user,pass);
                        System.out.println("User found");
                        frame.dispose();
                     }
                 }
                 if(resultSet.next() == false)
                  {
                    System.out.println("Invalid username or password");
                    i.setText("Incorrect Id or Password ! ");
                  }



            }
            catch(Exception dbe)
            {
              System.out.println("Got an Exception...");
              System.out.println(dbe.getMessage());
            }
  }
});

    cancel.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            frame.dispose();
  }
});

  }


  public static void main(String[] args) {
    login log = new login();
  }
}
