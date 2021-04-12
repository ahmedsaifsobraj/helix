package SM;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Cursor;
import java.awt.*;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
public class SignUp extends JFrame {

	private JPanel contentPane;
	private JLabel heading;
	private JTextField name;
	private JPasswordField pass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUp frame = new SignUp();
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
	
	public SignUp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1275, 700);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setUndecorated(true);
		setLocationRelativeTo(null);
		contentPane.setLayout(null);
		
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBackground(new Color(0, 128, 128));
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\DCL\\Downloads\\icons8-add-user-male-100.png"));
		lblNewLabel.setBounds(2, 195, 398, 310);
		contentPane.add(lblNewLabel);
		
		JLabel close = new JLabel("");
		close.setIcon(new ImageIcon("D:\\Icons\\icons8-close-window-24.png"));
		close.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		close.setHorizontalTextPosition(SwingConstants.CENTER);
		close.setHorizontalAlignment(SwingConstants.TRAILING);
		close.setFont(new Font("Arial", Font.PLAIN, 11));
		close.setBounds(1229, 0, 46, 25);
		contentPane.add(close);
		
		heading = new JLabel("SIGNUP");
		heading.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 40));
		heading.setHorizontalAlignment(SwingConstants.CENTER);
		heading.setBounds(709, 125, 300, 60);
		contentPane.add(heading);
		
		name = new JTextField();
		name.setHorizontalAlignment(SwingConstants.CENTER);
		name.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 11));
		name.setDisabledTextColor(new Color(0, 0, 0));
		name.setBorder(new LineBorder(new Color(0, 0, 0)));
		name.setBounds(709, 268, 300, 50);
		contentPane.add(name);
		name.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("USERNAME:");
		lblNewLabel_1.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(709, 242, 118, 25);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("PASSWORD:");
		lblNewLabel_1_1.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(709, 344, 118, 25);
		contentPane.add(lblNewLabel_1_1);
		
		pass = new JPasswordField();
		pass.setDisabledTextColor(new Color(0, 0, 0));
		pass.setHorizontalAlignment(SwingConstants.CENTER);
		pass.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 11));
		pass.setBorder(new LineBorder(new Color(0, 0, 0)));
		pass.setBounds(709, 368, 300, 50);
		contentPane.add(pass);
		
		JButton signup = new JButton("SIGNUP");
		signup.setIcon(new ImageIcon("D:\\Icons\\icons8-signin-24.png"));
		signup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try 
				{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
					String query="insert into login (username,password) values (?,?)";
					PreparedStatement pst=con.prepareStatement(query);
					pst.setString(1, name.getText());
					pst.setString(2, pass.getText());
					
					pst.execute();
					JOptionPane.showMessageDialog(null, "You are Successfully signedup.");
					LoginFrame l= new LoginFrame();
					l.setVisible(true);
					dispose();
					pst.close();
				}
				catch(Exception e2) {e2.printStackTrace();}
			}
		});
		signup.setForeground(new Color(0, 0, 0));
		signup.setBackground(new Color(255, 255, 255));
		signup.setBorder(new LineBorder(new Color(0, 0, 0)));
		signup.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 14));
		signup.setBounds(784, 468, 150, 30);
		contentPane.add(signup);
		
		JLabel lblNewLabel_2 = new JLabel("Already SignedUp? Click here to Login");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				LoginFrame l= new LoginFrame();
				l.setVisible(true);
				dispose();
			}
		});
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(709, 518, 300, 25);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("D:\\Icons\\R3.jpg"));
		lblNewLabel_3.setOpaque(true);
		lblNewLabel_3.setBounds(0, 0, 400, 700);
		contentPane.add(lblNewLabel_3);
		JPanel background;
	}
}
