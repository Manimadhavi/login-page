package mysql;
import java.sql.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.SystemColor;
import java.awt.Font;
import java.awt.Color;

import javax.swing.SwingConstants;

import java.awt.Label;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.RowSpec;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Signup extends JFrame {

	private JPanel contentPane;
	private JTextField user;
	private JTextField mob;
	private JPasswordField pass;
	private JTextField gender;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Signup frame = new Signup();
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
	public Signup() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 276, 342);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(218, 165, 32));
		contentPane.setBackground(SystemColor.info);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Sign-Up");
		lblNewLabel.setBounds(0, 5, 240, 26);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(0, 255, 0));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(266, 12, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblUsernameemailid = new JLabel("UserName/Emailid");
		lblUsernameemailid.setForeground(new Color(218, 165, 32));
		lblUsernameemailid.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblUsernameemailid.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsernameemailid.setBounds(10, 30, 250, 14);
		contentPane.add(lblUsernameemailid);
		
		user = new JTextField();
		user.setBounds(10, 48, 240, 23);
		contentPane.add(user);
		user.setColumns(10);
		
		JLabel lblEnterpassword = new JLabel("Password");
		lblEnterpassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnterpassword.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblEnterpassword.setForeground(new Color(218, 165, 32));
		lblEnterpassword.setBounds(10, 123, 240, 14);
		contentPane.add(lblEnterpassword);
		
		JLabel lblMobno = new JLabel("Mobno");
		lblMobno.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblMobno.setForeground(new Color(218, 165, 32));
		lblMobno.setHorizontalAlignment(SwingConstants.CENTER);
		lblMobno.setBounds(10, 73, 240, 14);
		contentPane.add(lblMobno);
		
		mob = new JTextField();
		mob.setBounds(10, 89, 240, 23);
		contentPane.add(mob);
		mob.setColumns(10);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setHorizontalAlignment(SwingConstants.CENTER);
		lblGender.setForeground(new Color(218, 165, 32));
		lblGender.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblGender.setBounds(10, 184, 240, 14);
		contentPane.add(lblGender);
		
		JButton btnsignup = new JButton("Signup");
		btnsignup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/logindetails","root","mani123");
					Statement stmt=con.createStatement();
					//String sql="INSERT INTO user1(user_name,Mobno,Password,gender)values('"+user.getText()+","+mob.getText()+","+pass1.getText().toString()+","+pass2.getText().toString()+","+gender.getText()+"')";
					String sql="INSERT INTO user1 VALUES('"+user.getText()+","+mob.getText()+","+pass.getText().toString()+","+gender.getText()+"')";
					boolean status=stmt.execute(sql);
					if(!status){
						System.out.println("not Working");
					}else{
						ResultSet r=stmt.getResultSet();
						while(r.next()){
							System.out.println(r.getString(1));
						}
						r.close();
					//}
					//{
					   // if(Password==lblEnterpassword)
			             JOptionPane.showMessageDialog(null,"signup successfully...");
			             
					}
					    /*else{
						JOptionPane.showMessageDialog(null,"Incorrect  password entered...");
					    }*/
					con.close();
					
				} catch(Exception e){System.out.print(e);}
			
			}
		});
		btnsignup.setForeground(new Color(218, 165, 32));
		btnsignup.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnsignup.setBounds(75, 267, 89, 23);
		contentPane.add(btnsignup);
		
		pass = new JPasswordField();
		pass.setBounds(10, 139, 240, 23);
		contentPane.add(pass);
		
		gender = new JTextField();
		gender.setBounds(10, 209, 240, 22);
		contentPane.add(gender);
		gender.setColumns(10);
	}
}
