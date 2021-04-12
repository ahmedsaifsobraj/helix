package SM;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Dimension;
import java.awt.Cursor;
import javax.swing.ScrollPaneConstants;

public class StudentInfo extends JFrame {

	private JPanel contentPane;
	private JTextField sid;
	private JTextField sn;
	private JTextField sec;
	private JTextField loc;
	private JTextField srch;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentInfo frame = new StudentInfo();
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
	public StudentInfo() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1275, 700);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel close = new JLabel("");
		close.setBounds(1229, 0, 46, 25);
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
		contentPane.add(close);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 128, 128));
		panel.setBounds(0, 0, 454 , 750);
		contentPane.add(panel);
		panel.setLayout(null);
		
		sid = new JTextField();
		sid.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 11));
		sid.setBorder(null);
		sid.setColumns(10);
		sid.setBounds(77, 80, 300, 50);
		panel.add(sid);
		
		sn = new JTextField();
		sn.setSelectionColor(new Color(0, 0, 0));
		sn.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 11));
		sn.setBorder(null);
		sn.setColumns(10);
		sn.setBounds(77, 180, 300, 50);
		panel.add(sn);
		
		sec = new JTextField();
		sec.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 11));
		sec.setBorder(null);
		sec.setColumns(10);
		sec.setBounds(77, 280, 300, 50);
		panel.add(sec);
		
		loc = new JTextField();
		loc.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 11));
		loc.setBorder(null);
		loc.setColumns(10);
		loc.setBounds(77, 380, 300, 50);
		panel.add(loc);
		
		JComboBox r = new JComboBox();
		r.setEditable(true);
		r.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 12));
		r.addItem("Pending");
		r.addItem("Partialy Complete");
		r.addItem("Complete");
		r.setSelectedItem(null);
		r.setBackground(new Color(255, 255, 255));
		r.setBorder(null);
		r.setBounds(77, 480, 300, 50);
		panel.add(r);
		
		
		JButton add = new JButton("Add ");
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try 
				{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
					String query="insert into student (student_id,student_name,section,list_of_courses,registration_status) values (?,?,?,?,?)";
					PreparedStatement pst=con.prepareStatement(query);
					pst.setString(1, sid.getText());
					pst.setString(2, sn.getText());
					pst.setString(3, sec.getText());
					pst.setString(4, loc.getText());
					pst.setString(5, (String)r.getSelectedItem());
					pst.execute();
					JOptionPane.showMessageDialog(null, "Added Successfully.");
					pst.close();
				}
				catch(Exception e2) {e2.printStackTrace();}
			}
			
		});
		add.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 14));
		add.setBorder(null);
		add.setIcon(new ImageIcon("D:\\Icons\\icons8-add-user-male-24 (1).png"));
		add.setBackground(new Color(255, 255, 255));
		add.setBounds(77, 557, 300, 30);
		panel.add(add);
		
		JButton update = new JButton("Update");
		update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try 
				{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
					String query="update student set student_id=?,student_name=?,section=?,list_of_courses=?,registration_status=? where student_id =?";
					PreparedStatement pst=con.prepareStatement(query);
					pst.setString(1, sid.getText());
					pst.setString(2, sn.getText());
					pst.setString(3, sec.getText());
					pst.setString(4, loc.getText());
					pst.setString(5, (String)r.getSelectedItem());
					pst.setString(6, sid.getText());
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Updated Successfully.");
					pst.close();
				}
				catch(Exception e2) {e2.printStackTrace();}
			}
		});
		update.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 14));
		update.setIcon(new ImageIcon("D:\\Icons\\icons8-edit-user-24.png"));
		update.setBorder(null);
		update.setBackground(new Color(255, 255, 255));
		update.setBounds(77, 600, 300, 30);
		panel.add(update);
		
		JButton delete = new JButton("Delete");
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try 
				{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
					String query="delete from student where student_id =?";
					PreparedStatement pst=con.prepareStatement(query);
					pst.setString(1,sid.getText());
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Deleted Successfully.");
					pst.close();
				}
				catch(Exception e2) {e2.printStackTrace();}
			}
		});
		delete.setBackground(new Color(255, 255, 255));
		delete.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 14));
		delete.setIcon(new ImageIcon("D:\\Icons\\icons8-denied-24.png"));
		delete.setBorder(null);
		delete.setBounds(77, 641, 300, 30);
		panel.add(delete);
		
		JLabel lblNewLabel_1 = new JLabel("STUDENT ID:");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(77, 54, 118, 25);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("STUDENT NAME:");
		lblNewLabel_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(77, 153, 118, 25);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("SECTION:");
		lblNewLabel_1_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_2.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 14));
		lblNewLabel_1_2.setBounds(77, 254, 118, 25);
		panel.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("LIST OF COURSES:");
		lblNewLabel_1_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_3.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 14));
		lblNewLabel_1_3.setBounds(77, 355, 118, 25);
		panel.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("REGISTRATION STATUS:");
		lblNewLabel_1_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_4.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 14));
		lblNewLabel_1_4.setBounds(77, 454, 155, 25);
		panel.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("D:\\Icons\\R3.jpg"));
		lblNewLabel.setBounds(0, 0, 454, 698);
		panel.add(lblNewLabel);
		
		JButton list = new JButton("VIEW LIST");
		list.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try 
				{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
					String sql="select * from student";
					PreparedStatement pst=con.prepareStatement(sql);
					ResultSet rs=pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
				}
				catch(Exception e2) {e2.printStackTrace();}
			}
		});
		list.setIcon(new ImageIcon("D:\\Icons\\icons8-list-view-24.png"));
		list.setForeground(new Color(0, 0, 0));
		list.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 14));
		list.setBorder(new LineBorder(new Color(0, 0, 0)));
		list.setBackground(new Color(255, 255, 255));
		list.setBounds(464, 148, 790, 30);
		contentPane.add(list);
		
		srch = new JTextField();
		srch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				try 
				{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
					String sql="select * from student where student_id=?";
					PreparedStatement pst=con.prepareStatement(sql);
					pst.setString(1, srch.getText());
					ResultSet rs=pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					pst.close();
					
				}
				catch(Exception e2) {e2.printStackTrace();}
			}
		});
		srch.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 11));
		srch.setBorder(new LineBorder(new Color(0, 0, 0)));
		srch.setBounds(464, 80, 300, 50);
		contentPane.add(srch);
		srch.setColumns(10);
		
		JLabel lblNewLabel_1_5 = new JLabel("SEARCH BY STUDENT ID:");
		lblNewLabel_1_5.setForeground(new Color(0, 0, 0));
		lblNewLabel_1_5.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 14));
		lblNewLabel_1_5.setBounds(464, 54, 196, 25);
		contentPane.add(lblNewLabel_1_5);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerifyInputWhenFocusTarget(false);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBackground(Color.WHITE);
		scrollPane.setViewportBorder(null);
		scrollPane.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 12));
		scrollPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		scrollPane.setBounds(464, 191, 790, 481);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		table.setIntercellSpacing(new Dimension(0, 0));
		table.setRowMargin(0);
		table.setRowHeight(50);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try 
				{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
					int row=table.getSelectedRow();
					String SID=(table.getModel().getValueAt(row, 0)).toString();
					String sql="select * from student where student_id='"+SID+"'";
					PreparedStatement pst=con.prepareStatement(sql);
					ResultSet rs=pst.executeQuery();
					while(rs.next())
					{
					sid.setText(rs.getString("student_id"));
					sn.setText(rs.getString("student_name"));
					sec.setText(rs.getString("section"));
					loc.setText(rs.getString("list_of_courses"));
					r.setSelectedItem(rs.getString("registration_status"));
					}
					pst.close();
					
				}
				catch(Exception e2) {e2.printStackTrace();}
			}
		});
		table.setSelectionForeground(new Color(255, 255, 255));
		table.setSelectionBackground(Color.DARK_GRAY);
		table.setGridColor(Color.BLACK);
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setForeground(Color.BLACK);
		scrollPane.setViewportView(table);
		table.setBackground(Color.WHITE);
		table.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 11));
		table.getTableHeader().setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
		table.getTableHeader().setOpaque(false);
		table.getTableHeader().setBackground(Color.DARK_GRAY);
		table.getTableHeader().setForeground(new Color(255, 255, 255));
		table.setRowHeight(50);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			}
		));
	}
}
