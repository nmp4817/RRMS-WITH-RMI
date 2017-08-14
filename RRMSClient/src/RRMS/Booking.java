package RRMS;
import java.awt.event.*;
import java.awt.*; 
import javax.swing.*;
import java.rmi.*;

public class Booking extends Panel implements ActionListener,ItemListener
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Choice c1,c2,c3,c4;
	Button jb1,jbg,jb2,jbu1;
	Font f;
	Panel jpb,jp1;
	Label jl1,jl2,jl3,jl4,jl5,jlt1,jlt2,jlt3,jlt4,jlt5;
	String st1,st2,st4,tna,sna1="";
	String sna[];
	TextField tf1,tf2,tf3,tf4,tf5;
	int pno=0,tno1,dis1,dis2,fra;
	String pfno="";
	int pnrno=0;
	String sno="",st;
	String sta="",cno;
	JScrollPane jsp;
	JTable jt;
	public Booking()
	{
		f=new Font("Arial",Font.ITALIC,35);
		setLayout(null);

		jp1=new Panel();
		jp1.setLayout(null);
		jp1.setBounds(0,0,1368,610);
		jp1.setBackground(Color.blue);
		add(jp1);
		jp1.setVisible(true);

		jt=new JTable();
		jsp=new JScrollPane(jt);
		jsp.setBounds(200,200,300,100);
		jsp.setVisible(false);
		add(jsp);

		jl1=new Label("Search Trains Between Station");
		jl1.setBounds(400,0,500,50);
		jl1.setFont(f);
		jp1.add(jl1);

		f=new Font("Arial",Font.ITALIC,25);

		jl2=new Label("Source Station");
		jl2.setBounds(400,70,200,35);
		jl2.setFont(f);
		jp1.add(jl2);

		jl3=new Label("Destination Station");
		jl3.setBounds(400,110,250,35);
		jl3.setFont(f);
		jp1.add(jl3);

		jl4=new Label("Available Trains");
		jl4.setBounds(400,150,250,35);
		jl4.setFont(f);
		jp1.add(jl4);

		jl5=new Label("Coach Type");
		jl5.setBounds(400,190,250,35);
		jl5.setFont(f);
		jp1.add(jl5);
		
		f=new Font("Arial",Font.BOLD,25);

		c1=new Choice();
		c1.add("Ahmedabad");
		c1.add("Vadodara");
		c1.add("Surat");
		c1.add("Bhopal");
		c1.add("Delhi");
		c1.add("Ahmadnagar");
		c1.add("Pune");
		c1.add("Anand");
		c1.add("Vapi");
		c1.add("Akola");
		c1.add("Nagpur");
		c1.add("Jaipur");
		c1.add("Bhusaval");
		c1.add("Chennai");
		c1.add("Mathura");
		c1.add("Muzaffarnagar");
		c1.add("Ghaziabad");
		c1.add("Dehradun");
		c1.add("Haridwar");
		c1.add("Ratlam");
		c1.add("Jhansi");
		c1.add("Mumbai");
		c1.add("Agra");
		c1.add("Kota");
		c1.add("Hz. Nizamuddin");
		c1.setBounds(675,80,200,35);
		c1.addItemListener(this);
		jp1.add(c1);

		c2=new Choice();
		c2.add("Ahmedabad");
		c2.add("Vadodara");
		c2.add("Surat");
		c2.add("Bhopal");
		c2.add("Delhi");
		c2.add("Ahmadnagar");
		c2.add("Pune");
		c2.add("Anand");
		c2.add("Vapi");
		c2.add("Akola");
		c2.add("Nagpur");
		c2.add("Jaipur");
		c2.add("Bhusaval");
		c2.add("Chennai");
		c2.add("Mathura");
		c2.add("Muzaffarnagar");
		c2.add("Ghaziabad");
		c2.add("Dehradun");
		c2.add("Haridwar");
		c2.add("Ratlam");
		c2.add("Jhansi");
		c2.add("Mumbai");
		c2.add("Agra");
		c2.add("Kota");
		c2.add("Hz. Nizamuddin");
		c2.setBounds(675,120,200,35);
		c2.addItemListener(this);
		jp1.add(c2);

		c3=new Choice();
		c3.setBounds(675,160,200,35);
		jp1.add(c3);

		c4=new Choice();
		c4.add("CHAIR-CAR");
		c4.add("SLEEPER");
		c4.add("AC1");
		c4.add("AC2");
		c4.add("AC3");
		c4.setBounds(675,200,200,35);
		c2.addItemListener(this);
		jp1.add(c4);

		jbg=new Button("GO");
		jbg.setFont(f);
		jbg.setBounds(650,270,50,30);
		jp1.add(jbg);
		jbg.addActionListener(this);

		jpb=new Panel();
		jpb.setLayout(null);
		jpb.setBounds(0,0,1368,610);
		jpb.setBackground(Color.red);
		add(jpb);
		jpb.setVisible(false);

		jlt3=new Label("DATE OF JOURNEY");
		jlt3.setBounds(20,20,260,30);
		jlt3.setFont(f);
		jpb.add(jlt3);

		tf4=new TextField();
		tf4.setBounds(290,20,200,50);
		tf4.setFont(f);
		jpb.add(tf4);

		jlt1=new Label("PASSENGER NAME ");
		jlt1.setBounds(20,100,240,30);
		jlt1.setFont(f);
		jpb.add(jlt1);

		tf1=new TextField();
		tf1.setBounds(290,100,350,50);
		tf1.setFont(f);
		jpb.add(tf1);

		jlt2=new Label("AGE");
		jlt2.setBounds(710,100,80,30);
		jlt2.setFont(f);
		jpb.add(jlt2);

		tf2=new TextField();
		tf2.setBounds(800,100,50,50);
		tf2.setFont(f);
		jpb.add(tf2);

		jb2=new Button("BOOK");
		jb2.setBounds(500,175,100,30);
		jb2.setFont(f);
		jb2.addActionListener(this);
		jpb.add(jb2);
	}

	public void actionPerformed(ActionEvent ae)
	{
		String s=ae.getActionCommand();
		if(s.equals("GO"))
		{
			jp1.setVisible(false);
			jpb.setVisible(true);
		}

		if(s.equals("BOOK"))
		{
			try{
								
				String uid1=Home.getId();
				String pname=tf1.getText();
				String dte=tf4.getText();
				int age=Integer.parseInt(tf2.getText());
				String tna=sna1;

				Interface oi = (Interface)Naming.lookup("rmi://localhost/Imp");
				String data[][]=oi.booking(uid1,pname,dte,age,tna,st4,st1,st2,st,sno);
				String head[]={"pnr","train_no","train_name","coach_no","date_of_journey","arrival_time","departure_time","seat_no","pf_no","boarding_station","ending_station","fare","status"};
				jt=new JTable(data,head);
				jsp=new JScrollPane(jt);
				jt.setVisible(true);
				jt.setLayout(null);
				jt.setBounds(100,220,1100,150);
				jpb.add(jt);
				jsp.setVisible(true);
				jpb.add(jsp);
			 }
		
			catch(Exception e)
			{
				System.out.println("Exception:"+e);
			}
			
			
		}
	}
	public void itemStateChanged(ItemEvent ie)
	{
		if(!sna1.equals(""))
		{
			c3.removeAll();
		}
		st1=c1.getSelectedItem();
		st2=c2.getSelectedItem();
		st4=c4.getSelectedItem();
		try
		{

			Interface oi = (Interface)Naming.lookup("rmi://localhost/Imp");
			sna=oi.train3(st1,st2);
				for(int j=0;j<sna.length;j++)
				{
					c3.add(sna[j]);
				}
		}
		catch(Exception e)
		{System.out.println("Exception : "+e);}
		sna1=c3.getSelectedItem();	
	}

}
