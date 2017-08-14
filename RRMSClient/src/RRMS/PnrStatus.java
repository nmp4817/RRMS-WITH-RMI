package RRMS;
import java.awt.event.*;
import java.awt.*; 
import javax.swing.*;
import java.rmi.*;

public class PnrStatus extends Panel implements ActionListener
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Panel jp1;
	Label jl1,jl2,jl3;
	Button jb1,jb2,jb3;
	JTextField tf1;
	Font f;
	JTable jt;
	JScrollPane jsp;
	public PnrStatus()
	{
		f=new Font("Arial",Font.ITALIC,30);

		jl1=new Label("CURRENT RESERVATION STATUS");
		jl1.setBounds(300,0,500,50);
		jl1.setFont(f);
		add(jl1);

		f=new Font("Arial",Font.BOLD,20);

		jl2=new Label("PNR-STATUS :");
		jl2.setBounds(300,70,200,30);
		jl2.setFont(f);
		add(jl2);

		tf1=new JTextField();	
		tf1.setBounds(550,70,200,30);
		tf1.setFont(f);
		add(tf1);

		jb1=new Button("OK");
		jb1.setBounds(600,120,100,30);
		jb1.setFont(f);
		add(jb1);
		jb1.addActionListener(this);

		jp1=new Panel();
		jp1.setLayout(null);
		jp1.setBounds(200,150,800,300);
		jp1.setBackground(Color.red);
		add(jp1);
		jp1.setVisible(false);

		jl3=new Label("PNR does not exist!");
		jl3.setBounds(100,100,400,30);
		jl3.setFont(f);
		jp1.add(jl3);

		jb3=new Button("Back");
		jb3.setBounds(400,150,100,30);
		jb3.setFont(f);
		jp1.add(jb3);
		jb3.addActionListener(this);
			
		jt=new JTable();

	}

	public void actionPerformed(ActionEvent ae)
	{
		String s=ae.getActionCommand();
		Project2 pr=new Project2("RAILWAY RESERVATION APPLICATION");
		if(s.equals("OK"))
		{
			try{
				String head[]={"pnr","TRAIN_NO","TRAIN_NAME","coach_no","dt_of_jourey","seat_no","pf_no","boarding_st","ending_st","tfare","status"};
				Interface i= (Interface)Naming.lookup("rmi://192.168.1.4:1099/Imp");
				String data[][] = i.pnr_status(tf1.getText());
				
				jt=new JTable(data,head);
				jsp=new JScrollPane(jt);
				jt.setVisible(true);
				jt.setLayout(null);
				jt.setBounds(100,230,1200,300);
				add(jt);
				jsp.setVisible(true);
				add(jsp);

			}
			catch(Exception e){}
		}
			
	
		
		if(s.equals("Back"))
		{
			tf1.setText("");
			jp1.setVisible(false);
			pr.p.setVisible(true);	
		}
	}
}