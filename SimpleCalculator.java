package p2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.text.JTextComponent;

public class SimpleCalculator {

	private JFrame frame;
	private JTextField textField;
	double firstnum;
	double secondnum;
	double result;
	String operations;
	String answer;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SimpleCalculator window = new SimpleCalculator();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SimpleCalculator() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Times New Roman", Font.BOLD, 18));
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(26, 23, 261, 41);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		//------------------------------------ROW-->1--------------------------------------------------------
		
		JButton btn8 = new JButton("8");
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String EnterNumber=textField.getText()+btn8.getText();
				textField.setText(EnterNumber );
				
			}
		});
		btn8.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btn8.setBounds(84, 87, 48, 48);
		frame.getContentPane().add(btn8);
		
		JButton btn7 = new JButton("7");
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String EnterNumber=textField.getText()+btn7.getText();
				textField.setText(EnterNumber );
				
				
			}
		});
		btn7.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btn7.setBounds(26, 87, 48, 48);
		frame.getContentPane().add(btn7);
		
		JButton btn9 = new JButton("9");
		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String EnterNumber=textField.getText()+btn9.getText();
				textField.setText(EnterNumber );
				
			}
		});
		btn9.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btn9.setBounds(142, 87, 48, 48);
		frame.getContentPane().add(btn9);
		
		JButton btnPlus = new JButton("+");
		btnPlus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				firstnum=Double.parseDouble(textField.getText());
				textField.setText("");
				operations="+";
				
			}
		});
		btnPlus.setFont(new Font("Times New Roman", Font.BOLD, 30));
		btnPlus.setBounds(198, 87, 89, 48);
		frame.getContentPane().add(btnPlus);
		
		//--------------------------------------------ROW-->2---------------------------------
		
		JButton btn4 = new JButton("4");
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String EnterNumber=textField.getText()+btn4.getText();
				textField.setText(EnterNumber );
				
			}
		});
		btn4.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btn4.setBounds(26, 146, 48, 48);
		frame.getContentPane().add(btn4);
		
		JButton btn5 = new JButton("5");
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String EnterNumber=textField.getText()+btn5.getText();
				textField.setText(EnterNumber );
				
			}
		});
		btn5.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btn5.setBounds(84, 146, 48, 48);
		frame.getContentPane().add(btn5);
		
		JButton btn6 = new JButton("6");
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String EnterNumber=textField.getText()+btn6.getText();
				textField.setText(EnterNumber );
				
			}
		});
		btn6.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btn6.setBounds(142, 146, 48, 48);
		frame.getContentPane().add(btn6);
		
		JButton btnSub = new JButton("-");
		btnSub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				firstnum=Double.parseDouble(textField.getText());
				textField.setText("");
				operations="-";
				
			}
		});
		btnSub.setFont(new Font("Times New Roman", Font.BOLD, 30));
		btnSub.setBounds(198, 146, 89, 48);
		frame.getContentPane().add(btnSub);
		
		//--------------------------------------------ROW-->3---------------------------------
		
		JButton btn1 = new JButton("1");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String EnterNumber=textField.getText()+btn1.getText();
				textField.setText(EnterNumber );
				
			}
		});
		btn1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btn1.setBounds(26, 205, 48, 48);
		frame.getContentPane().add(btn1);
		
		JButton btn2 = new JButton("2");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String EnterNumber=textField.getText()+btn2.getText();
				textField.setText(EnterNumber );
				
			}
		});
		btn2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btn2.setBounds(84, 205, 48, 48);
		frame.getContentPane().add(btn2);
		
		JButton btn3 = new JButton("3");
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String EnterNumber=textField.getText()+btn3.getText();
				textField.setText(EnterNumber );
				
			}
		});
		btn3.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btn3.setBounds(142, 205, 48, 48);
		frame.getContentPane().add(btn3);
		
		JButton btnMul = new JButton("*");
		btnMul.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				firstnum=Double.parseDouble(textField.getText());
				textField.setText("");
				operations="*";
				
			}
		});
		btnMul.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnMul.setBounds(198, 205, 89, 48);
		frame.getContentPane().add(btnMul);
		
		//--------------------------------------------ROW-->4---------------------------------
		
		JButton btn0 = new JButton("0");
		btn0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String EnterNumber=textField.getText()+btn0.getText();
				textField.setText(EnterNumber );
				
			}
		});
		btn0.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btn0.setBounds(26, 264, 48, 48);
		frame.getContentPane().add(btn0);
		
		JButton btnDot = new JButton(".");
		btnDot.setFont(new Font("Times New Roman", Font.BOLD, 30));
		btnDot.setBounds(84, 264, 48, 48);
		frame.getContentPane().add(btnDot);
		
		JButton btnDiv = new JButton("/");
		btnDiv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				firstnum=Double.parseDouble(textField.getText());
				textField.setText("");
				operations="";
				
			}
		});
		btnDiv.setFont(new Font("Times New Roman", Font.BOLD, 25));
		btnDiv.setBounds(142, 264, 48, 48);
		frame.getContentPane().add(btnDiv);
		
		JButton btnEqual = new JButton("=");
		btnEqual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String answer;
				secondnum=Double.parseDouble(textField.getText());
				if(operations=="+")
				{
					result=firstnum + secondnum;
					answer=String.format("%.4f",result);
					textField.setText(answer);
				}
				else if(operations == "-")
				{
					result=firstnum - secondnum;
					answer=String.format("%.4f",result);
					textField.setText(answer);
		
				}
				else if(operations == "*")
				{
					result=firstnum * secondnum;
					answer=String.format("%.4f",result);
					textField.setText(answer);
		
				}
				else if(operations == "/")
				{
					result=firstnum / secondnum;
					answer=String.format("%.4f",result);
					textField.setText(answer);
		
				}
				else if(operations == "%")
				{
					result=firstnum % secondnum;
					answer=String.format("%.4f",result);
					textField.setText(answer);
		
				}
				
				
				
			}
		});
		btnEqual.setFont(new Font("Times New Roman", Font.BOLD, 30));
		btnEqual.setBounds(198, 264, 89, 48);
		frame.getContentPane().add(btnEqual);
		
		//--------------------------------------------ROW-->5---------------------------------
		
		JButton btnBack = new JButton("<<");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String back=null;
				
				if(textField.getText().length()>0)
				{
					StringBuffer strB=new StringBuffer(textField.getText());
					strB.deleteCharAt(textField.getText().length()-1);
					back=strB.toString();
					textField.setText(back);
				}
			}
		});
		btnBack.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnBack.setBounds(26, 323, 58, 48);
		frame.getContentPane().add(btnBack);
		
		JButton btnClear = new JButton("c");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(null);
			}
		});
		btnClear.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnClear.setBounds(94, 323, 48, 48);
		frame.getContentPane().add(btnClear);
		
		JButton btnMod = new JButton("%");
		btnMod.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				firstnum=Double.parseDouble(textField.getText());
				textField.setText("");
				operations="%";
				
			}
		});
		btnMod.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnMod.setBounds(152, 323, 58, 48);
		frame.getContentPane().add(btnMod);
		
		JButton btnPM = new JButton("+-");
		btnPM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double ops=Double.parseDouble(String.valueOf(textField.getText()));
				ops=ops*(-1);
				textField.setText(String.valueOf(ops));
			}
		});
		btnPM.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnPM.setBounds(220, 325, 67, 41);
		frame.getContentPane().add(btnPM);
		
		//----------------------------------------------------------------------------
		
		
		
		
		
			
		
		
		
		
	}
}
