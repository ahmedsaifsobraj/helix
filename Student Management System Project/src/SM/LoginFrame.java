package SM;
import java.sql.*;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginFrame extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JPasswordField pass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
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
	public LoginFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1275, 700);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\DCL\\Downloads\\rsz_unnamed.png"));
		lblNewLabel.setBackground(new Color(0, 128, 128));
		lblNewLabel.setBounds(0, 224, 400, 270);
		contentPane.add(lblNewLabel);
		
		JLabel lblLogin = new JLabel("LOGIN");
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 40));
		lblLogin.setBounds(690, 142, 300, 60);
		contentPane.add(lblLogin);
		
		JLabel lblNewLabel_1 = new JLabel("USERNAME:");
		lblNewLabel_1.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(690, 259, 118, 25);
		contentPane.add(lblNewLabel_1);
		
		name = new JTextField();
		name.setHorizontalAlignment(SwingConstants.CENTER);
		name.setDisabledTextColor(new Color(0, 0, 0));
		name.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 12));
		name.setBorder(new LineBorder(new Color(0, 0, 0)));
		name.setColumns(10);
		name.setBounds(690, 285, 300, 50);
		contentPane.add(name);
		
		JLabel lblNewLabel_1_1 = new JLabel("PASSWORD");
		lblNewLabel_1_1.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(690, 360, 118, 25);
		contentPane.add(lblNewLabel_1_1);
		
		pass = new JPasswordField();
		pass.setHorizontalAlignment(SwingConstants.CENTER);
		pass.setDisabledTextColor(new Color(0, 0, 0));
		pass.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 12));
		pass.setBorder(new LineBorder(new Color(0, 0, 0)));
		pass.setBounds(690, 385, 300, 50);
		contentPane.add(pass);
		
		JButton login = new JButton("LOGIN");
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
					Statement stmt=con.createStatement();
					String sql="Select * from login Where username='"+name.getText()+"'and password='"+pass.getText().toString()+"'";
					ResultSet rs=stmt.executeQuery(sql);
					if(rs.next())
						JOptionPane.showMessageDialog(null, "You successfully logined.");
						
					
					else
						JOptionPane.showMessageDialog(null, "Wrong Username or Password!");
					StudentInfo s=new StudentInfo();
					s.setVisible(true);
					dispose();
					con.close();

					
			}catch(Exception e1) {System.out.print(e);
				
			}
			}
		});
		login.setIcon(new ImageIcon("D:\\Icons\\icons8-login-24.png"));
		login.setForeground(new Color(0, 0, 0));
		login.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 14));
		login.setBorder(new LineBorder(new Color(0, 0, 0)));
		login.setBackground(new Color(255, 255, 255));
		login.setBounds(765, 485, 150, 30);
		contentPane.add(login);
		
		JLabel close = new JLabel("");
		close.setBackground(Color.BLACK);
		close.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		close.setIcon(new ImageIcon("D:\\Icons\\icons8-close-window-24.png"));
		close.setHorizontalTextPosition(SwingConstants.CENTER);
		close.setHorizontalAlignment(SwingConstants.TRAILING);
		close.setFont(new Font("Arial", Font.PLAIN, 11));
		close.setBounds(1229, 0, 46, 25);
		contentPane.add(close);
		
		JLabel lblNewLabel_2 = new JLabel("Not SignedUp? Click here to Sign Up");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
	 		@Override
			public void mouseClicked(MouseEvent e) {
				SignUp s= new SignUp();
				s.setVisible(true);
				dispose();
			}
		});
		lblNewLabel_2.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(690, 535, 300, 25);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setOpaque(true);
		lblNewLabel_3.setIcon(new ImageIcon("D:\\Icons\\R3.jpg"));
		lblNewLabel_3.setBounds(0, 0, 400, 700);
		contentPane.add(lblNewLabel_3);
		setUndecorated(true);
	}
}
