package RRMS;
import java.awt.event.*;
import java.util.Arrays;

import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.rmi.*;

public class Home extends JPanel implements MouseListener,ActionListener,ItemListener
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Button jb1,jrb1,jrb2,jrb3,jrb,jsb,jsp,jsc,jsv,jbu,jbu1,jbu2,jbu3,jbc1,jbl;
	JPanel jp1,jp2,jp3,jpr1,jpr2,jps1,jps2,jpv,jp4,jpr3;
	CheckboxGroup cbg;
	Checkbox cb1,cb2;
	Choice c1,c2,c3;
	PnrStatus p;
	Booking b;
	Label jl1,jl2,jl3,jl4,jr,jr1,jr2,jr3,jr4,jr5,jr6,jr7,jr8,jr9,jr10,jr11,jr12,jr13,jr14,jr15,jr16,jrl1,jrl2,jrl3,js1,js2,js3,jlu1,jlu2,jrl4,jrs1,jlu,jla;
	static int flag=0;
	Font f,f1,f2;
	JTextField tf1,tr1,tr4,tr6,tr7,tr8,tr9,tr10,tr11,tr12;
	TextArea tr5;
	JPasswordField tr13,tr14,tf2;
	int x,y;
	String dd,mm,yy,ge;
	public static String a="";
	JScrollPane jsp1,jsp2;
	JTable jt1,jt2;

	public Home()
	{
		setLayout(null);
		//FOR PIC
		f=new Font("Times New Roman",Font.BOLD,20);
		jp1=new JPanel();
		jp1.setLayout(null);
		jp1.setBounds(0,0,900,610);
		jp1.setBackground(Color.blue);
		add(jp1);
		
		//FOR LOGIN
		jp2=new JPanel();
		jp2.setLayout(null);
		jp2.setBounds(900,0,468,610);
		jp2.setBackground(Color.red);
		jl1=new Label("USERNAME");
		jl2=new Label("PASSWORD");
		jl1.setFont(f);
		jl2.setFont(f);
		jl1.setBounds(20,50,200,30);
		jl2.setBounds(20,150,200,30);
		jp2.add(jl1);
		jp2.add(jl2);
		tf1=new JTextField();
		tf2=new JPasswordField();
		tf2.setEchoChar('*');
		tf1.setBounds(20,90,300,50);
		tf2.setBounds(20,190,300,50);
		tf1.setFont(f);
		tf2.setFont(f);
		jp2.add(tf1);
		jp2.add(tf2);
	
		jb1 = new Button("SIGN IN");	
		jb1.setFont(f);	
		jb1.setBounds(20,280,150,50);
		jp2.add(jb1);
		add(jp2);
		jb1.addActionListener(this);
		
		f1=new Font("Arial",Font.ITALIC,20);
		
		jl3=new Label("USER REGESTRATION");
		jl3.setBounds(20,380,400,50);
		jl3.setFont(f1);
		jp2.add(jl3);
		jl3.addMouseListener(this);

		jl4=new Label("FORGOT PASSWORD");
		jl4.setBounds(20,420,400,50);
		jl4.setFont(f1);
		//jl4.addMouseListener(this);
		jp2.add(jl4);

		jp3=new JPanel();
		jp3.setLayout(null);
		jp3.setBounds(0,0,1368,610);
		jp3.setBackground(Color.yellow);
		jp3.setVisible(false);
		add(jp3);

		jpr1=new JPanel();
		jpr1.setLayout(null);
		jpr1.setBounds(200,50,800,300);
		jpr1.setBackground(Color.red);
		add(jpr1);
		jpr1.setVisible(false);
		
		jpr2=new JPanel();
		jpr2.setLayout(null);
		jpr2.setBounds(200,50,800,300);
		jpr2.setBackground(Color.red);
		add(jpr2);
		jpr2.setVisible(false);
		
		jpr3=new JPanel();
		jpr3.setLayout(null);
		jpr3.setBounds(200,50,800,300);
		jpr3.setBackground(Color.red);
		add(jpr3);
		jpr3.setVisible(false);
		
		
		jps1=new JPanel();
		jps1.setLayout(null);
		jps1.setBounds(0,0,800,610);
		jps1.setBackground(Color.gray);
		add(jps1);
		jps1.setVisible(false);					
		jps2=new JPanel();
		jps2.setLayout(null);
		jps2.setBounds(800,0,568,610);
		jps2.setBackground(Color.yellow);
		add(jps2);				
		jps2.setVisible(false);	
		f=new Font("Arial",Font.ITALIC,40);
		js1=new Label("User Homepage");
		js1.setFont(f);
		js1.setForeground(Color.black);
		js1.setBounds(270,0,300,60);
		jps1.add(js1);
		f=new Font("Arial",Font.BOLD,30);
		js2=new Label("Quick Links");
		js2.setForeground(Color.black);
		js2.setFont(f);
		js2.setBounds(50,150,200,30);
		jps1.add(js2);
		js3=new Label("References");
		js3.setForeground(Color.black);
		js3.setFont(f);
		js3.setBounds(500,150,200,30);
		jps1.add(js3);

		f=new Font("Arial",Font.BOLD,20);
		jsb=new Button("Make Booking");
		jsb.setFont(f);	
		jsb.setBounds(50,210,150,50);
		jps1.add(jsb);
		jsb.addActionListener(this);
		jsp=new Button("PNR Status");
		jsp.setFont(f);	
		jsp.setBounds(50,280,150,50);
		jps1.add(jsp);
		jsp.addActionListener(this);
		jsc=new Button("Cancellation");
		jsc.setFont(f);	
		jsc.setBounds(50,350,150,50);
		jps1.add(jsc);
		jsc.addActionListener(this);
		jsv=new Button("View History");
		jsv.setFont(f);	
		jsv.setBounds(500,210,160,50);
		jps1.add(jsv);
		jsv.addActionListener(this);

		jbl=new Button("Logout");
		jbl.setFont(f);	
		jbl.setBounds(150,250,160,50);
		jps2.add(jbl);
		jbl.addActionListener(this);

		jlu1=new Label("UserName:");
		jlu1.setFont(f);
		jlu1.setForeground(Color.black);
		jlu1.setBounds(20,50,180,30);
		jps2.add(jlu1);

		jlu=new Label("");
		jlu.setFont(f);
		jlu.setForeground(Color.black);
		jlu.setBounds(20,90,180,30);
		jps2.add(jlu);

		jlu2=new Label("Authority:");
		jlu2.setFont(f);
		jlu2.setForeground(Color.black);
		jlu2.setBounds(20,140,180,30);
		jps2.add(jlu2);

		jla=new Label("Normal User");
		jla.setFont(f);
		jla.setForeground(Color.black);
		jla.setBounds(20,180,180,30);
		jps2.add(jla);

		p=new PnrStatus();
		p.setLayout(null);
		p.setBounds(0,0,1368,610);
		p.setBackground(Color.green);
		p.setVisible(false);
		add(p);
		
		b=new Booking();
		b.setLayout(null);
		b.setBounds(0,0,1368,610);
		b.setBackground(Color.blue);
		b.setVisible(false);
		add(b);

		jpv=new JPanel();
		jpv.setLayout(null);
		jpv.setBounds(0,0,1368,610);
		jpv.setBackground(Color.green);
		add(jpv);
		jpv.setVisible(false);

		jbu=new Button("User Homepage");
		jbu.setBounds(730,120,200,30);
		f=new Font("Arial",Font.BOLD,20);
		jbu.setFont(f);
		jbu.addActionListener(this);
		jbu.setVisible(false);
		p.add(jbu);

		jbu1=new Button("User Homepage");
		jbu1.setBounds(730,270,220,30);
		jbu1.setFont(f);
		jbu1.addActionListener(this);
		jbu1.setVisible(false);
		b.jp1.add(jbu1);

		
		jbu3=new Button("User Homepage");
		jbu3.setBounds(400,500,220,30);
		jbu3.setFont(f);
		jbu3.addActionListener(this);
		jbu3.setVisible(true);
		b.jpb.add(jbu3);
		
		jbu2=new Button("User Homepage");
		jbu2.setBounds(500,380,220,30);
		jbu2.setFont(f);
		jbu2.setVisible(false);
		jbu2.addActionListener(this);
		jpv.add(jbu2);

		jbc1=new Button("Cancel");
		jbc1.setBounds(470,120,100,30);
		jbc1.setFont(f);
		p.add(jbc1);
		jbc1.addActionListener(this);
		jbc1.setVisible(false);

		jp4=new JPanel();
		jp4.setLayout(null);
		jp4.setBounds(200,50,800,300);
		jp4.setBackground(Color.red);
		add(jp4);
		jp4.setVisible(true);

		jrs1=new Label("USERNAME OR PASSWORD IS INVALID OR YOU ARE NOT REGISTERED");
		jrs1.setBounds(60,50,800,50);
		jrs1.setFont(f1);
		jp4.add(jrs1);
		jrs1.setVisible(false);

		jrb = new Button("OK");	
		jrb.setFont(f1);	
		jrb.setBounds(300,150,130,30);
		jp4.add(jrb);
		jrb.setVisible(false);
		jrb.addActionListener(this);

		jrb3 = new Button("BACK");	
		jrb3.setFont(f1);	
		jrb3.setBounds(300,150,130,30);	
		jpr2.add(jrb3);
		jpr3.add(jrb3);
		jrb3.setVisible(false);
		jrb3.addActionListener(this);

		f2=new Font("Arial",Font.ITALIC,30);
		jr=new Label("USER REGESTRAION FORM");
		jr.setBounds(420,-15,800,65);
		jr.setFont(f2);
		jp3.add(jr);

		f2=new Font("Arial",Font.BOLD,15);
		jr1=new Label("Full Name* : ");
		jr1.setBounds(20,50,100,30);
		jr1.setFont(f2);
		jp3.add(jr1);

		tr1=new JTextField();
		tr1.setBounds(180,50,200,30);
		tr1.setFont(f2);
		jp3.add(tr1);
			
		jr2=new Label("Gender : ");
		jr2.setBounds(20,90,100,30);
		jr2.setFont(f2);
		jp3.add(jr2);

		cbg=new CheckboxGroup();
		cb1=new Checkbox("M",cbg,true);
		cb1.setBounds(180,90,50,30);
		cb1.setFont(f2);
		jp3.add(cb1);
		cb1.addItemListener(this);
		
		cb2=new Checkbox("F",cbg,false);
		cb2.setBounds(240,90,200,30);
		cb2.setFont(f2);
		jp3.add(cb2);
		cb2.addItemListener(this);

		jr3=new Label("Date Of Birth* : ");
		jr3.setBounds(20,130,120,30);
		jr3.setFont(f2);
		jp3.add(jr3);

		
		c1=new Choice();
		c1.setBounds(180,130,50,30);
		c1.setFont(f2);
		for(int i=1;i<=31;i++)
		{String dt=""+i;c1.add(dt);}
		jp3.add(c1);
		c1.addItemListener(this);

		c2=new Choice();
		c2.setBounds(240,130,50,30);
		c2.setFont(f2);
		c2.add("jan");
		c2.add("feb");
		c2.add("mar");
		c2.add("apr");
		c2.add("may");
		c2.add("jun");
		c2.add("jul");
		c2.add("aug");
		c2.add("sep");
		c2.add("oct");
		c2.add("nov");
		c2.add("dec");
		jp3.add(c2);
		c2.addItemListener(this);

		c3=new Choice();
		c3.setBounds(300,130,80,30);
		c3.setFont(f2);
		for(int i=1940;i<=1995;i++)
		{String yr=""+i;c3.add(yr);}
		jp3.add(c3);
		c3.addItemListener(this);

		jr4=new Label("Mobile No : ");
		jr4.setBounds(20,170,100,30);
		jr4.setFont(f2);
		jp3.add(jr4);
		tr4=new JTextField();
		tr4.setBounds(180,170,200,30);
		tr4.setFont(f2);
		jp3.add(tr4);

		jr5=new Label("Address : ");
		jr5.setBounds(20,210,100,30);
		jr5.setFont(f2);
		jp3.add(jr5);
		tr5=new TextArea(10,15);
		tr5.setBounds(180,210,300,70);
		tr5.setFont(f2);
		jp3.add(tr5);

		jr6=new Label("City : ");
		jr6.setBounds(600,50,100,30);
		jr6.setFont(f2);
		jp3.add(jr6);

		tr6=new JTextField();
		tr6.setBounds(750,50,200,30);
		tr6.setFont(f2);
		jp3.add(tr6);

		jr7=new Label("State : ");
		jr7.setBounds(600,90,100,30);
		jr7.setFont(f2);
		jp3.add(jr7);

		tr7=new JTextField();
		tr7.setBounds(750,90,200,30);
		tr7.setFont(f2);
		jp3.add(tr7);

		jr8=new Label("Pin Code : ");
		jr8.setBounds(600,130,100,30);
		jr8.setFont(f2);
		jp3.add(jr8);

		tr8=new JTextField();
		tr8.setBounds(750,130,200,30);
		tr8.setFont(f2);
		jp3.add(tr8);

		jr9=new Label("Country : ");
		jr9.setBounds(600,170,100,30);
		jr9.setFont(f2);
		jp3.add(jr9);

		tr9=new JTextField();
		tr9.setBounds(750,170,200,30);
		tr9.setFont(f2);
		jp3.add(tr9);

		jr10=new Label("Email-id* : ");
		jr10.setBounds(600,210,100,30);
		jr10.setFont(f2);
		jp3.add(jr10);

		tr10=new JTextField();
		tr10.setBounds(750,210,200,30);
		tr10.setFont(f2);
		jp3.add(tr10);

		//LOGIN INFORMATION
		f2=new Font("Arial",Font.ITALIC,30);

		jr11=new Label("LOG-IN INFORMATION");
		jr11.setBounds(450,275,800,75);
		jr11.setFont(f2);
		jp3.add(jr11);

		f2=new Font("Arial",Font.BOLD,15);

		jr12=new Label("USER-ID * : ");
		jr12.setBounds(20,345,150,30);
		jr12.setFont(f2);
		jp3.add(jr12);

		tr12=new JTextField();
		tr12.setBounds(220,345,200,30);
		tr12.setFont(f2);
		jp3.add(tr12);

		jr13=new Label("Enter Password * : ");
		jr13.setBounds(20,385,150,30);
		jr13.setFont(f2);
		jp3.add(jr13);

		tr13=new JPasswordField();
		tr13.setBounds(220,385,200,30);
		tr13.setEchoChar('*');
		tr13.setFont(f2);
		jp3.add(tr13);

		jr14=new Label("Confirm Password* : ");
		jr14.setBounds(20,425,150,30);
		jr14.setFont(f2);
		jp3.add(jr14);

		tr14=new JPasswordField();
		tr14.setBounds(220,425,200,30);
		tr14.setEchoChar('*');
		tr14.setFont(f2);
		jp3.add(tr14);

		jr15=new Label("(*) MARKED FIELDS CANT BE LEFT EMPTY");
		jr15.setBounds(20,475,500,30);
		jr15.setFont(f2);
		jp3.add(jr15);

		f2=new Font("Times New Roman",Font.BOLD,15);

		jrb1 = new Button("REGISTER");
		jrb1.setFont(f2);	
		jrb1.setBounds(380,515,130,30);
		jp3.add(jrb1);
		jrb1.addActionListener(this);
		
		jrl1=new Label("USER HAS BEEN REGISTERED SUCCESSFULY");
		jrl1.setBounds(200,50,800,50);
		jrl1.setFont(f1);
		jpr1.add(jrl1);
		jrl1.setVisible(false);

		jrl3=new Label("(*) MARKED FIELDS CANT BE LEFT EMPTY");
		jrl3.setBounds(200,50,800,50);
		jrl3.setFont(f1);
		jpr2.add(jrl3);
		jrl3.setVisible(false);

		jrl4=new Label("RE-INSERT PASSWORD");
		jrl4.setBounds(200,50,800,50);
		jrl4.setFont(f1);
		jpr3.add(jrl4);
		jrl4.setVisible(false);

		jrb2 = new Button("CLEAR");
		jrb2.setFont(f2);	
		jrb2.setBounds(520,515,100,30);
		jp3.add(jrb2);
		jrb2.addActionListener(this);

		jrb = new Button("OK");	
		jrb.setFont(f1);	
		jrb.setBounds(300,150,130,30);
		jpr1.add(jrb);
		jrb.setVisible(false);
		jrb.addActionListener(this);

	}
	

	public void mouseClicked(MouseEvent me)
	{
		
		x=me.getX();
		y=me.getY();
		if(x>=0 && x<=220)
		{
			if(y>=0 && y<=30)
			{
				setLayout(null);
			
				jp1.setVisible(false);
				jp2.setVisible(false);
				jps1.setVisible(false);
				jps2.setVisible(false);
				jpr1.setVisible(false);
				jp3.setVisible(true);
				
				tr1.setText("");
				tr4.setText("");
				tr5.setText("");
				tr6.setText("");
				tr7.setText("");
				tr8.setText("");
				tr9.setText("");
				tr10.setText("");
				tr12.setText("");
				tr13.setText("");
				tr14.setText("");
			}
		}
	}

	public static String getId()
	{
		return a;
	}

	public void actionPerformed(ActionEvent ae)
	{
		String s=ae.getActionCommand();
		long mono,poco;
		if(s.equals("REGISTER"))
		{

			jp3.setVisible(false);
			jps1.setVisible(false);
			jps2.setVisible(false);
			jp1.setVisible(false);
			jp2.setVisible(false);
			p.setVisible(false);
			jpv.setVisible(false);
			b.setVisible(false);

			String nm=tr1.getText();
			String mno=tr4.getText();

				String addr=tr5.getText();
				String ct=tr6.getText();
				String sta=tr7.getText();
				String pco=tr8.getText();

				String cou=tr9.getText();
				String eid=tr10.getText();
				String uid=tr12.getText();
				char[] pwd=tr13.getPassword();
				char[] cpwd=tr14.getPassword();
				String bdt=dd+"-"+mm+"-"+yy;
				String gen=ge;
			

			if( uid.equals("") || nm.equals("") || cpwd.equals("") || pwd.equals("") || eid.equals("") || dd.equals("") || mm.equals("") || yy.equals("") )
				{
					jpr2.setVisible(true);
					jrl3.setVisible(true);
					jpr2.add(jrb3);
					jrb3.setVisible(true);
				}
			else if(!Arrays.equals(pwd, cpwd))
			{
				jpr3.setVisible(true);
				jrl4.setVisible(true);
				jpr3.add(jrb3 );
				jrb3.setVisible(true);
	
			}

			else{
				if(pco.equals(""))
				{
					 poco=0;
				}
				else
				{
					poco=Long.parseLong(pco);	
				}
	
				if(mno.equals(""))
				{
					mono=0;
				}
				else
				{
					mono=Long.parseLong(mno);
				}
				try{
				Interface i = (Interface)Naming.lookup("rmi://localhost:1099/Imp");
				i.register(uid,nm,bdt,gen,pwd,ct,sta,cou,poco,mono,addr,eid);
				}
				catch(Exception e){}

				jpr1.setVisible(true);	
				jrl1.setVisible(true);
				jrb.setVisible(true);	
				
			
			}
						

		}

		if(s.equals("Logout"))
		{
			tf1.setText("");
			tf2.setText("");
			jpr2.setVisible(false);
			jpr1.setVisible(false);
			jps1.setVisible(false);
			jps2.setVisible(false);
			jp1.setVisible(true);
			jp2.setVisible(true);
			jp3.setVisible(false);
			b.setVisible(false);
			p.setVisible(false);
			flag=0;
		}
		
		if(s.equals("OK"))
		{
			jpr2.setVisible(false);
			jp1.setVisible(true);
			jp2.setVisible(true);
			jp3.setVisible(false);
			jpr1.setVisible(false);
			p.setVisible(false);
			jpv.setVisible(false);
			
		}

		if(s.equals("BACK"))
		{
			jpr3.setVisible(false);
			jpr2.setVisible(false);
			jp1.setVisible(false);
			jp2.setVisible(false);
			jp3.setVisible(false);
			jpr1.setVisible(false);
			p.setVisible(false);
			jpv.setVisible(false);
			jp3.setVisible(true);
		}

		if(s.equals("SIGN IN"))
		{
			int fl1=0;
			jpr2.setVisible(false);			
			jp1.setVisible(false);
			jp2.setVisible(false);
			jpr1.setVisible(false);
			jp3.setVisible(false);
			String uid = tf1.getText();
			char[] pwd = tf2.getPassword();
			try{
			Interface i = (Interface)Naming.lookup("rmi://localhost:1099/Imp");
			fl1=i.signIn(uid,pwd);
			System.out.println("here"+fl1);
			}
			catch(Exception e){System.out.println(""+e);}

			if(fl1==1)
			{
				jrs1.setVisible(false);
				jrb.setVisible(false);
				jp4.setVisible(false);
				jps1.setVisible(true);			
				jps2.setVisible(true);
				if(((tf1.getText()).toUpperCase()).equals("ADMIN"))
				{jla.setText("System Admin");}
				jlu.setText(tf1.getText());
				flag=1;
				a=tf1.getText();
			}
			else
			{
				jrs1.setVisible(true);
				jrb.setVisible(true);
				jp4.setVisible(true);
				tf1.setText("");
				tf2.setText("");
			}		
	
			f=new Font("Arial",Font.ITALIC,30);
		}
		
		if(s.equals("Cancellation"))
		{
			jpr2.setVisible(false);
			jpr1.setVisible(false);
			jps1.setVisible(false);
			jps2.setVisible(false);
			jp1.setVisible(false);
			jp2.setVisible(false);
			jp3.setVisible(false);
			b.setVisible(false);
			jbu.setVisible(true);
			p.setVisible(true);
			jbc1.setVisible(true);
		}
		
		if(s.equals("PNR Status"))
		{
			jpr2.setVisible(false);
			jpr1.setVisible(false);
			jps1.setVisible(false);
			jps2.setVisible(false);
			jp1.setVisible(false);
			jp2.setVisible(false);
			jp3.setVisible(false);
			b.setVisible(false);
			p.setVisible(true);
			jbu.setVisible(true);
			jbc1.setVisible(false);
		}


		if(s.equals("User Homepage"))
		{
			jpr2.setVisible(false);
			jpr1.setVisible(false);
			jps1.setVisible(true);
			jps2.setVisible(true);
			jp1.setVisible(false);
			jp2.setVisible(false);
			jp3.setVisible(false);
			b.setVisible(false);
			p.setVisible(false);
		}

		if(s.equals("View History"))
		{
			jpr2.setVisible(false);
			jpr1.setVisible(false);
			jps1.setVisible(false);
			jps2.setVisible(false);
			jp1.setVisible(false);
			jp2.setVisible(false);
			jp3.setVisible(false);
			p.setVisible(false);
			b.setVisible(false);
			jpv.setVisible(true);
			jbu2.setVisible(true);
			String uid = tf1.getText();
			try{
				String head[]={"u_id","passenger_no","pnr","train_no","coach_no","dt_of_journey","boarding_st","ending_st","status"};
				Interface oi = (Interface)Naming.lookup("rmi://localhost:1099/Imp");

				int c=oi.view_History(uid);
				String[][] data=oi.view_History(uid,c);
			
				jt1=new JTable(data,head);
				jsp1=new JScrollPane(jt1);
				jt1.setVisible(true);
				jt1.setLayout(null);
				jt1.setBounds(180,50,1000,300);
				jpv.add(jt1);
				jsp1.setVisible(true);
				jpv.add(jsp1);
			}
			catch(Exception e){}
			
		}

		if(s.equals("Make Booking"))
		{
			jpr2.setVisible(false);
			jpr1.setVisible(false);
			jps1.setVisible(false);
			jps2.setVisible(false);
			jp1.setVisible(false);
			jp2.setVisible(false);
			jp3.setVisible(false);
			p.setVisible(false);
			b.setVisible(true);
			jbu1.setVisible(true);
		}
		
		if(s.equals("CLEAR"))
		{
			tr1.setText("");
			tr4.setText("");
			tr5.setText("");
			tr6.setText("");
			tr7.setText("");
			tr8.setText("");
			tr9.setText("");
			tr10.setText("");
			tr12.setText("");
			tr13.setText("");
			tr14.setText("");
		}
		int pno=0;
		String d="",m="",y="";
		if(s.equals("Cancel"))
		{
			try
			{
				DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
				Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.43.144:1521/XE", "system", "system");
				Statement statement = connection.createStatement();
				ResultSet rs = statement.executeQuery("select t.pnr as pnr,t.train_no as train_no,t.train_name as train_name,t.coach_no as coach_no,t.dt_of_journey as dt_of_journey,t.seat_no as seat_no,t.pf_no as pf_no,t.boarding_st as boarding_st,t.ending_st as ending_st,t.t_fare as t_fare,t.status as status,b.passenger_no as pno from ticket t,books_for b where t.pnr='"+p.tf1.getText()+"' and u_id='"+tf1.getText()+"' and b.pnr='"+p.tf1.getText()+"'");
				int count=0;
				while(rs.next())
				{
					count++;
				}
				if(count==0)
				{
					p.jp1.setVisible(true);					
				}		
				else
				{
					String[][] data=new String[count][11];
					String head[]={"pnr","TRAIN_NO","TRAIN_NAME","coach_no","dt_of_jourey","seat_no","pf_no","boarding_st","ending_st","tfare","status"};
					rs.close();
					int ii=0;
					rs = statement.executeQuery("select t.pnr as pnr,t.train_no as train_no,t.train_name as train_name,t.coach_no as coach_no,t.dt_of_journey as dt_of_journey,t.seat_no as seat_no,t.pf_no as pf_no,t.boarding_st as boarding_st,t.ending_st as ending_st,t.t_fare as t_fare,t.status as status,b.passenger_no as pno from ticket t,books_for b where t.pnr='"+p.tf1.getText()+"' and u_id='"+tf1.getText()+"' and b.pnr='"+p.tf1.getText()+"'");
					while(rs.next())
					{
						data[ii][0]=rs.getString("pnr");
System.out.println(data[0][0]);
						data[ii][1]=rs.getString("train_no");
System.out.println(data[0][1]);
						data[ii][2]=rs.getString("train_name");	
System.out.println(data[0][2]);
						data[ii][3]=rs.getString("coach_no");
System.out.println(data[0][3]);
						data[ii][4]=rs.getString("dt_of_journey");
d=data[0][4].substring(8,2);
System.out.println(d);
m=data[0][4].substring(5,3);
System.out.println(m);
y=data[0][4].substring(0,5);
System.out.println(y);

System.out.println(data[0][4]);
						data[ii][5]=rs.getString("seat_no");
System.out.println(data[0][5]);
						data[ii][6]=rs.getString("pf_no");
System.out.println(data[0][6]);
						data[ii][7]=rs.getString("boarding_st");
System.out.println(data[0][7]);
						data[ii][8]=rs.getString("ending_st");
System.out.println(data[0][8]);
						data[ii][9]=rs.getString("t_fare");
System.out.println(data[0][9]);
						data[ii][10]=rs.getString("status");
System.out.println(data[0][10]);
						pno=Integer.parseInt(rs.getString("pno"));
System.out.println(pno);
						ii++;
					}
				rs = statement.executeQuery("select passenger_no as pno from books_for where pnr='"+p.tf1.getText()+"'and u_id='"+tf1.getText()+"'");

				statement.executeUpdate("insert into ticket values('"+Integer.parseInt(data[0][0])+"','"+Integer.parseInt(data[0][1])+"','"+data[0][2]+"','"+data[0][3]+"',to_date('"+d+m+y+"','dd-mm-yyyy'),'"+data[0][5]+"','"+data[0][6]+"','"+data[0][7]+"','"+data[0][8]+"','"+Integer.parseInt(data[0][9])+"','ca'"+")");

				statement.executeUpdate("insert into books_for values('"+tf1.getText()+"','"+pno+"','"+Integer.parseInt(data[0][0])+"','"+Integer.parseInt(data[0][1])+"','"+data[0][3]+"',to_date('"+data[0][4]+"','yyyy-mm-dd'),'"+data[0][7]+"','"+data[0][8]+"','ca'"+")");

					rs.close();
					jt2=new JTable(data,head);
					jsp2=new JScrollPane(jt2);
					jt2.setVisible(true);
					jt2.setLayout(null);
					jt2.setBounds(100,230,1200,300);
					add(jt2);
					jsp2.setVisible(true);
					add(jsp2);
				}
				statement.close();
				connection.close();
			}
			catch(Exception e)
			{System.out.println("Exception : "+e);}
		}

	}

	public void itemStateChanged(ItemEvent ie)
	{
		dd=c1.getSelectedItem();
		mm=c2.getSelectedItem();
		yy=c3.getSelectedItem();
		ge=cbg.getSelectedCheckbox().getLabel();
		System.out.println(""+ge+""+dd);

	}

	public void mouseEntered(MouseEvent me){}
	public void mouseReleased(MouseEvent me){}
	public void mousePressed(MouseEvent me){}
	public void mouseExited(MouseEvent me){}
}
