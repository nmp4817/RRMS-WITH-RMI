package RRMS;
import java.io.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

class Project2 extends JFrame implements ActionListener,Runnable
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Button jbh,jbt,jbb,jbp,jbpr,jrb,jbu1;
	Label jl1;
	JLabel jlp1,jrl1;
	Panel jp1,jp2,jp3;
	Font fb,fl,f;
	Home h;
	Trains t;
	Booking b;
	PnrStatus p;
	ProjectBy pb;
	Thread th;
	
	public Project2(String s)
	{
		super(s);

		 setLayout(null);

		//PANEL 1 FOR LABEL
		fl=new Font("Times New Roman",Font.BOLD,30);
		jp1=new Panel();
		jp1.setLayout(null);
		jp1.setBounds(0,0,1368,50);
		jp1.setBackground(Color.gray);
		add(jp1);	
		jl1=new Label("RAILWAY RESERVATION MANAGEMENT APPLICATION");
		jl1.setBounds(250,0,850,50);
		jl1.setFont(fl);
		jp1.add(jl1);
		fb=new Font("Times New Roman",Font.BOLD,20);

		//PANEL 2 FOR BUTTONS
		jp2=new Panel();
		jp2.setLayout(null);
		jp2.setBounds(0,50,1368,70);
		jp2.setBackground(Color.black);
		add(jp2);
		jbh=new Button("HOME");
		jbh.setBounds(90,10,220,50);
		jbh.setFont(fb);
		jbh.addActionListener(this);
		jbt=new Button("TRAINS");
		jbt.setBounds(330,10,220,50);
		jbt.setFont(fb);
		jbt.addActionListener(this);
		jbb=new Button("BOOKING");
		jbb.setBounds(570,10,220,50);
		jbb.setFont(fb);		
		jbb.addActionListener(this);
		jbp=new Button("PNR-STATUS");
		jbp.setBounds(810,10,220,50);
		jbp.setFont(fb);
		jbp.addActionListener(this);
		jbpr=new Button("PROJECT BY");
		jbpr.setBounds(1050,10,220,50);
		jbpr.setFont(fb);
		jbpr.addActionListener(this);
		jp2.add(jbh); 	
		jp2.add(jbt);
		jp2.add(jbb);
		jp2.add(jbp);
		jp2.add(jbpr);
		
		h=new Home();
		h.setLayout(null);
		h.setBounds(0,120,1368,610);
		h.setBackground(Color.orange);
		add(h);
		jlp1=new JLabel("");
		jlp1.setBounds(30,20,640,360);
		h.jp1.add(jlp1);

		t=new Trains();
		t.setLayout(null);
		t.setBounds(0,120,1368,610);
		t.setBackground(Color.red);
		t.setVisible(false);
		add(t);
	
		b=new Booking();
		b.setLayout(null);
		b.setBounds(0,120,1368,610);
		b.setBackground(Color.blue);
		b.setVisible(false);
		add(b);	
		
		p=new PnrStatus();
		p.setLayout(null);
		p.setBounds(0,120,1368,610);
		p.setBackground(Color.green);
		p.setVisible(false);
		add(p);

		pb=new ProjectBy();
		pb.setLayout(null);
		pb.setBounds(0,120,1368,610);
		pb.setBackground(Color.blue);
		pb.setVisible(false);
		add(pb);

		jp3=new Panel();
		jp3.setLayout(null);
		jp3.setBounds(200,150,800,300);
		jp3.setBackground(Color.red);
		add(jp3);
		jp3.setVisible(false);
		
		jrl1=new JLabel("YOU ARE NOT SIGNED IN! PLEASE SIGN IN  FIRST!");
		jrl1.setBounds(60,50,800,50);
		jrl1.setFont(fb);
		jp3.add(jrl1);
		jrl1.setVisible(false);

		jrb = new Button("OK");	
		jrb.setFont(fb);	
		jrb.setBounds(300,150,130,30);
		jp3.add(jrb);
		jrb.setVisible(false);
		jrb.addActionListener(this);
	
		jbu1=new Button("User Homepage");
		jbu1.setBounds(730,270,220,30);
		f=new Font("Arial",Font.BOLD,20);
		jbu1.setFont(f);
		jbu1.setVisible(false);
		jbu1.addActionListener(this);
		b.jp1.add(jbu1);

		th=new Thread(this);
		th.start();
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	public void run()
	{	
		File fl=new File("C:\\Users\\t\\workspace\\RRMSClient\\Images\\");
		String sf[]=fl.list();
		while(true)
		{
			for(int i=0;i<sf.length;i++)
			{	
				if(sf[i].endsWith(".JPG") || sf[i].endsWith(".jpg"))
				{	
					try{
						jlp1.setIcon(new ImageIcon("C:\\Users\\t\\workspace\\RRMSClient\\Images\\"+sf[i]));
						Thread.sleep(2000);
					} catch(Exception e){System.out.println("Exception: "+e);}
				}
			}
		}
	}

	public void actionPerformed(ActionEvent ae)
	{	
		String s=ae.getActionCommand();
		if(s.equals("HOME"))
		{
			h.setVisible(true);
			h.jp1.setVisible(true);
			h.jp2.setVisible(true);
			t.setVisible(false);
			b.setVisible(false);
			p.setVisible(false);
			pb.setVisible(false);
			t.jt.setVisible(false);
			p.tf1.setText("");
		}

		if(s.equals("TRAINS"))
		{
			h.setVisible(false);
			t.setVisible(true);
			b.setVisible(false);
			p.setVisible(false);
			pb.setVisible(false);
		}	

		if(s.equals("BOOKING"))
		{
			h.setVisible(false);
			t.setVisible(false);
			p.setVisible(false);
			pb.setVisible(false);
			
			if(Home.flag==1)
			{
				b.setVisible(true);
				jbu1.setVisible(true);
			}
			else
			{
				jp3.setVisible(true);
				jrl1.setVisible(true);
				jrb.setVisible(true);
			}
		}

		if(s.equals("PNR-STATUS"))
		{
			h.setVisible(false);
			t.setVisible(false);
			b.setVisible(false);
			p.setVisible(true);
			pb.setVisible(false);
			p.jt.setVisible(false);
			p.jp1.setVisible(false);
			p.tf1.setText("");
		}

		if(s.equals("PROJECT BY"))
		{
			h.setVisible(false);
			t.setVisible(false);
			b.setVisible(false);
			p.setVisible(false);
			pb.setVisible(true);
		}

		if(s.equals("OK"))
		{
			jp3.setVisible(false);
			h.setVisible(true);
			h.jp1.setVisible(true);
			h.jp2.setVisible(true);
		}
		
		if(s.equals("User Homepage"))
		{
			jp1.setVisible(false);
			h.jpr2.setVisible(false);
			h.jpr1.setVisible(false);
			h.jp1.setVisible(false);
			h.jp2.setVisible(false);
			h.jp3.setVisible(false);
			b.setVisible(false);
			p.setVisible(false);
			h.setVisible(true);
			h.jps1.setVisible(true);
			h.jps2.setVisible(true);
		}

	}
}

public class Project
{
	public static void main(String[] s)
	{
		Project2 pr=new Project2("RAILWAY RESERVATION APPLICATION");
		pr.setVisible(true);
		pr.setSize(1368,730);
		pr.setLocation(0,0);
	}
}

