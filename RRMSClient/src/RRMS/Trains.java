package RRMS;
import java.awt.event.*;
import java.awt.*; 
import javax.swing.*;
import java.rmi.*;

public class Trains extends JPanel implements ActionListener,ItemListener
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Choice c1,c2;
	Button jb1;
	Font f;
	String st1,st2;
	Label jl1,jl2,jl3;
	JTable jt,jt1;
	JScrollPane jsp;
	JPanel jp1;
	public Trains()
	{
		f=new Font("Arial",Font.ITALIC,35);

		jl1=new Label("Search Trains Between Station");
		jl1.setBounds(400,0,500,50);
		jl1.setFont(f);
		add(jl1);

		f=new Font("Arial",Font.ITALIC,25);

		jl2=new Label("Source Station");
		jl2.setBounds(400,70,200,35);
		jl2.setFont(f);
		add(jl2);

		jl3=new Label("Destination Station");
		jl3.setBounds(400,110,250,35);
		jl3.setFont(f);
		add(jl3);
		
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
		add(c1);

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
		c2.setBounds(675,115,200,35);
		c2.addItemListener(this);
		add(c2);

		jb1 = new Button("OK");	
		jb1.setFont(f);	
		jb1.setBounds(600,150,130,30);
		add(jb1);
		jb1.addActionListener(this);

		jt=new JTable();
		jsp=new JScrollPane(jt);
		jsp.setBounds(200,200,300,100);
		jsp.setVisible(false);
		add(jsp);


	}

	public void itemStateChanged(ItemEvent ie)
	{
		st1=c1.getSelectedItem();
		st2=c2.getSelectedItem();
	}

	public void actionPerformed(ActionEvent ae)
	{
		String s=ae.getActionCommand();
		if(s.equals("OK"))
		{
		try
		{
			Interface oi = (Interface)Naming.lookup("rmi://localhost/Imp");
			int c=oi.train1(st1,st2);
			String data[][]=new String[c][8];
			data=oi.train2(st1,st2,c);

			String h[]={"","","","","","","",""};
			String head[][]=new String[1][8];
			head[0][0]="TRAIN_NO";
			head[0][1]="TRAIN_NAME";
			head[0][2]="TRAIN_TYPE";
			head[0][3]="SOURCE";
			head[0][4]="DESTINATION";
			head[0][5]="PLATFORM_NO";
			head[0][6]="ARRIVAL_TIME";
			head[0][7]="DEPARTURE_TIME";


			jt=new JTable(data,h);
			jt1=new JTable(head,h);
			jsp=new JScrollPane(jt);
			jt.setVisible(true);
			jt1.setVisible(true);
			jt.setLayout(null);
			jt1.setLayout(null);
			jt.setBounds(180,230,1000,300);
			jt1.setBounds(180,212,1000,250);
			add(jt);
			add(jt1);
			jsp.setVisible(true);
			add(jsp);
		}
		catch(Exception e)
		{System.out.println("Exception : "+e);}

		}

	}

}