package p1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import java.awt.BorderLayout;
import javax.swing.JList;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.SwingConstants;

import net.proteanit.sql.DbUtils;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import javax.swing.JSplitPane;

public class ViewLibrarian {

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewLibrarian window = new ViewLibrarian();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public ViewLibrarian() throws SQLException, InterruptedException {
		initialize();
		
	}

	
	private void initialize() throws SQLException, InterruptedException {
		frame = new JFrame();
		frame.getContentPane().setLayout(null);
		
	
		JButton btnCloseTable = new JButton("CloseTab");
		btnCloseTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			AdminSuccess.main(new String[]{});
				frame.dispose();
			}
		});
		btnCloseTable.setHorizontalAlignment(SwingConstants.LEADING);
		btnCloseTable.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCloseTable.setBounds(200, 30, 90, 30);
		frame.getContentPane().add(btnCloseTable);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 91, 484, 227);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setFont(new Font("Tahoma", Font.PLAIN, 12));
		table.setBorder(new LineBorder(Color.BLUE, 2));
		
		Connection con=DBConn.getConnection();
		PreparedStatement ps=con.prepareStatement("select * from librarian");
		ResultSet rs=ps.executeQuery();
		Thread.sleep(1000);
		table.setModel(DbUtils.resultSetToTableModel(rs));
	}
}
