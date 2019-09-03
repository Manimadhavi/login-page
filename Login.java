package mysql;

import java.sql.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField user;
	private JPasswordField pass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 264, 327);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.info);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLogin = new JLabel("Login Here");
		lblLogin.setForeground(Color.GREEN);
		lblLogin.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setBounds(24, 11, 191, 31);
		contentPane.add(lblLogin);
		
		JLabel lblUsername = new JLabel("UserName");
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsername.setBounds(10, 53, 205, 14);
		contentPane.add(lblUsername);
		
		user = new JTextField();
		user.setBounds(42, 78, 173, 20);
		contentPane.add(user);
		user.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setBounds(10, 117, 205, 14);
		contentPane.add(lblPassword);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/logindetails","root","mani123");
					Statement stmt=con.createStatement();
					String sql="Select * from User Where User_Name='"+user.getText()+"'and Password='"+pass.getText().toString()+"'";
					ResultSet rs=stmt.executeQuery(sql);
					if(rs.next())
						JOptionPane.showMessageDialog(null,"login succesfully...");
					else
						JOptionPane.showMessageDialog(null,"Incorrect usename or password....");
					con.close();
					
				} catch(Exception e){System.out.print(e);}
			}
		});
		btnLogin.setBounds(90, 186, 66, 23);
		contentPane.add(btnLogin);
		
		pass = new JPasswordField();
		pass.setBounds(42, 142, 173, 20);
		contentPane.add(pass);
	}
}
