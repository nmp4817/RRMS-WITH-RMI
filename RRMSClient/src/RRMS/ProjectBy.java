package RRMS;
import java.awt.*;

public class ProjectBy extends Panel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Label jl1,jl2,jl3,jl4;
	Font f;
	public ProjectBy()
	{
		f=new Font("Arial",Font.ITALIC,50);

		jl1=new Label("THIS APPLICATION IS MADE BY");
		jl1.setBounds(300,0,1000,50);
		jl1.setFont(f);
		add(jl1);
	
		f=new Font("Arial",Font.BOLD,30);

		jl2=new Label("1. MADHUR GOR(516)");
		jl2.setBounds(150,100,500,50);
		jl2.setFont(f);
		add(jl2);

		jl3=new Label("2. HIREN JAISWAL(518)");
		jl3.setBounds(150,250,500,50);
		jl3.setFont(f);
		add(jl3);

		jl4=new Label("3.NABIL PATEL(542)");
		jl4.setBounds(150,400,500,50);
		jl4.setFont(f);
		add(jl4);
	}
}
