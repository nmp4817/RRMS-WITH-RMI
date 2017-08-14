package RRMS;
import java.rmi.server.*;
import java.sql.*;

class Implementation extends UnicastRemoteObject implements Interface
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Implementation() throws Exception
	{}
	
	public int signIn(String uid,char[] pwd) throws Exception
	{
		int fl1=0;
		try
		{
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			System.out.println("Connecting to the database...");
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/XE", "system", "system");
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select user_id,pwd from user0");		
			while(rs.next())
			{
				if(rs.getString("USER_ID").equals(uid) && rs.getString("PWD").equals(new String(pwd)))
				{
					fl1=1;
					break;
				}
			}
			rs.close();
			statement.close();
			connection.close();
		}
		catch(Exception e)
		{System.out.println("Exception : "+e);}
		return fl1;

	}

	public void register(String uid,String nm,String bdt,String gen,char[] pwd,String ct,String sta,String cou,long poco,long mono,String addr,String eid) throws Exception
	{
		try 
		{
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			System.out.println("Connecting to the database...");
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/XE", "system", "system");
			Statement statement = connection.createStatement();
			int result = statement.executeUpdate("insert into user0 values('"+uid+"','"+nm+"','"+bdt+"','"+gen+"','"+new String(pwd)+"','"+ct+"','"+sta+"','"+cou+"','"+poco+"','"+mono+"','"+addr+"','"+eid+"'"+")");			
			System.out.println(""+result);
			statement.close();
			connection.close();
			System.out.println("Close");	
		}	
			
			catch (Exception e) {System.out.println("The exception raised is:" + e);}
	}

	public int view_History(String uid) throws Exception
	{
		int count=0;
		try
		{
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/XE", "system", "system");
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from books_for where u_id='"+uid+"'");
			while(rs.next())
			{
				count++;
			}
		}
		catch(Exception e){System.out.println(e);}
		return count;
	}

	public String[][] view_History(String uid,int count) throws Exception
	{
		String data[][]=new String[count][9];
		for(int i=0;i<count;i++){data[i][0]="";data[i][1]="";data[i][3]="";data[i][2]="";data[i][4]="";data[i][5]="";data[i][6]="";data[i][7]="";data[i][8]="";}
		try
		{
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/XE", "system", "system");
			Statement statement = connection.createStatement();
			int ii=0;
			ResultSet rs = statement.executeQuery("select * from books_for where u_id='"+uid+"'");
			while(rs.next())
			{
				data[ii][0]=rs.getString("u_id");
				data[ii][1]=rs.getString("passenger_no");
				data[ii][2]=rs.getString("pnr");	
				data[ii][3]=rs.getString("train_no");
				data[ii][4]=rs.getString("coach_no");
				data[ii][5]=rs.getString("dt_of_journey");
				data[ii][6]=rs.getString("boarding_st");
				data[ii][7]=rs.getString("ending_st");
				data[ii][8]=rs.getString("status");
				ii++;
			}
			rs.close();
			statement.close();
			connection.close();
		}
		catch(Exception e)
		{System.out.println("Exception : "+e);}
		
		return data;
	}

	public String[][] booking(String uid1,String pname,String dte,int age,String tna,String st4,String st1,String st2,String st,String sno)
	{
		String[][] data={{"","","","","","","","","","","","",""}};
		String cno="",pfno="";
		int dis1=0,dis2=0,pnrno=0,tno1=0,fra=0,pno=0;
		try
		{
			        DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
				System.out.println("Connecting to the database...");
				Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/XE", "system", "system");
				Statement statement = connection.createStatement();

				ResultSet rs0=statement.executeQuery("select * from passenger where user_id='"+uid1+"'");
				int ij=0;
				while(rs0.next())
				{
					ij++;
				}
				pno=ij+1;

				statement.executeUpdate("insert into passenger values('"+uid1+"','"+pno+"','"+pname+"','"+age+"'"+")");

				ResultSet rs = statement.executeQuery("select train_no as tno from train where train_name='"+tna+"'");
				while(rs.next())
				{
					tno1=Integer.parseInt(rs.getString("tno"));
				}

				ResultSet rs1 = statement.executeQuery("select coach_no as cno from coach  where upper(coach_type)='"+st4.toUpperCase()+"'");
				while(rs1.next())
				{
					cno=rs1.getString("cno");
				}
				
				ResultSet rs2 = statement.executeQuery("select pf_no as pfno from route  where train_no="+tno1+" and upper(station_name)='"+st1.toUpperCase()+"'");
				while(rs2.next())
				{
					pfno=rs2.getString("pfno");
				}
				
				ResultSet rs3= statement.executeQuery("select distance as dis1 from route where train_no="+tno1+" and upper(station_name)='"+st1.toUpperCase()+"'");
				while(rs3.next())
				{
					dis1=Integer.parseInt(rs3.getString("dis1"));
				}
				
				ResultSet rs4= statement.executeQuery("select distance as dis2 from route where train_no="+tno1+" and upper(station_name)='"+st2.toUpperCase()+"'");
				while(rs4.next())
				{
					 dis2=Integer.parseInt(rs4.getString("dis2"));
				}

				ResultSet rs5= statement.executeQuery("select fare_per_km as fr from fare where train_no="+tno1+" and coach_no='"+cno+"'");
				while(rs5.next())
				{
					 fra=(int)(Float.parseFloat(rs5.getString("fr"))*(dis2-dis1));
				}
				
				ResultSet rs7=statement.executeQuery("select * from ticket");
				while(rs7.next())
				{
					pnrno++;
				}
				pnrno++;
				
				int f=1;
				ResultSet rs6=statement.executeQuery("select status,seat_no from container where train_no="+tno1);
				while(rs6.next())
				{
				st=rs6.getString("status");
				sno=rs6.getString("seat_no");
				if(st.equals("nb"))
				{
				statement.executeUpdate("insert into ticket values('"+pnrno+"','"+tno1+"','"+tna+"','"+cno+"',to_date('"+dte+"','dd-mon-yyyy'),'"+sno+"','"+pfno+"','"+st1+"','"+st2+"','"+fra+"','c'"+")");
				statement.executeUpdate("insert into books_for values('"+uid1+"','"+pno+"','"+pnrno+"','"+tno1+"','"+cno+"',to_date('"+dte+"','dd-mon-yyyy'),'"+st1+"','"+st2+"','c'"+")");
				f=0;
				st="c";
				break;
				}				
				}
				if(f==1)
				{
					statement.executeUpdate("insert into ticket values('"+pnrno+"','"+tno1+"','"+tna+"','"+cno+"',to_date('"+dte+"','dd-mon-yyyy'),'"+sno+"','"+pfno+"','"+st1+"','"+st2+"','"+fra+"','w'"+")");
					statement.executeUpdate("insert into books_for values('"+uid1+"','"+pno+"','"+pnrno+"','"+tno1+"','"+cno+"',to_date('"+dte+"','dd-mon-yyyy'),'"+st1+"','"+st2+"','w'"+")");		
					st="w";
				}

				data=new String[1][13];
				ResultSet rs8=statement.executeQuery("select t.train_no as tno,t.*,a.pf_no as pno,to_char(a.arrival_time,'hh24:mi:ss') as atime,to_char(a.dept_time,'hh24:mi:ss') as dtime from route a,route b,train t where a.station_name='"+st1+"' and b.station_name='"+st2+"' and a.distance < b.distance and a.train_no=b.train_no and t.train_no=a.train_no");
				data[0][0]=""+pnrno;
				data[0][1]=""+tno1;
				data[0][2]=tna;	
				data[0][3]=cno;
				data[0][4]=dte;
				data[0][7]=sno;
				data[0][8]=pfno;
				data[0][9]=st1;
				data[0][10]=st2;
				data[0][11]=""+fra;
				data[0][12]=st;
				while(rs8.next())
				{			
					data[0][5]=rs8.getString("atime");
					data[0][6]=rs8.getString("dtime");
				}

				statement.close();
				connection.close();
		}
		catch(Exception e){}
		return data;
	}
	public int train1(String st1,String st2)
	{
		int count=0;
		try
		{
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/XE", "system", "system");
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from route a,route b,train t where a.station_name='"+st1+"' and b.station_name='"+st2+"' and a.distance < b.distance and a.train_no=b.train_no and t.train_no=a.train_no");
			while(rs.next())
			{
				count++;
			}
		}
		catch(Exception e){System.out.println(e);}
		return count;
	}
	public String[][] train2(String st1,String st2,int count)
	{
		String data[][]=new String[count][8];
		for(int i=0;i<count;i++){data[i][0]="";data[i][1]="";data[i][3]="";data[i][2]="";data[i][4]="";data[i][5]="";data[i][6]="";data[i][7]="";}
		try
		{
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/XE", "system", "system");
			Statement statement = connection.createStatement();
			int ii=0;
			ResultSet rs = statement.executeQuery("select t.train_no as tno,t.*,a.pf_no as pno,to_char(a.arrival_time,'hh24:mi:ss') as atime,to_char(a.dept_time,'hh24:mi:ss') as dtime from route a,route b,train t where a.station_name='"+st1+"' and b.station_name='"+st2+"' and a.distance < b.distance and a.train_no=b.train_no and t.train_no=a.train_no");
			while(rs.next())
			{
				data[ii][0]=rs.getString("TRAIN_NO");
				data[ii][1]=rs.getString("TRAIN_NAME");
				data[ii][2]=rs.getString("TRAIN_TYPE");	
				data[ii][3]=rs.getString("SOURCE");
				data[ii][4]=rs.getString("DESTINATION");
				data[ii][5]=rs.getString("pno");
				data[ii][6]=rs.getString("atime");
				data[ii][7]=rs.getString("dtime");
				ii++;
			}
			statement.close();
			connection.close();
		}
		catch(Exception e){System.out.println(e);}
		return data;
	}

	public String[] train3(String st1,String st2) throws Exception
	{	
			String sna[];
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/XE", "system", "system");
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select train_name as tname from route a,route b,train t where a.station_name='"+st1+"' and b.station_name='"+st2+"' and a.distance < b.distance and a.train_no=b.train_no and t.train_no=a.train_no");
			int count=0;
			while(rs.next())
			{
				count++;
			}
			rs.close();
			sna = new String[count];
			int i=0;
			rs = statement.executeQuery("select train_name as tname from route a,route b,train t where a.station_name='"+st1+"' and b.station_name='"+st2+"' and a.distance < b.distance and a.train_no=b.train_no and t.train_no=a.train_no");
			while(rs.next())
			{
				sna[i]=rs.getString("tname");
				i++;
			}
			rs.close();
			statement.close();
			connection.close();
			return sna;
	}

	public String[][] pnr_status(String pnr)
	{
		String[][] data={{"","","","","","","","","","","","",""}};
			try
			{
				DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
				Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/XE", "system", "system");
				Statement statement = connection.createStatement();
				ResultSet rs = statement.executeQuery("select * from ticket where pnr='"+pnr+"'");
				int count=0;
				while(rs.next())
				{
					count++;
				}
				if(count==0)
				{
					
				}
				else
				{
					data=new String[count][11];

					rs.close();
					int ii=0;
					rs = statement.executeQuery("select * from ticket where pnr='"+pnr+"'");
					while(rs.next())
					{
						data[ii][0]=rs.getString("pnr");
						data[ii][1]=rs.getString("train_no");
						data[ii][2]=rs.getString("train_name");	
						data[ii][3]=rs.getString("coach_no");
						data[ii][4]=rs.getString("dt_of_journey");
						data[ii][5]=rs.getString("seat_no");
						data[ii][6]=rs.getString("pf_no");
						data[ii][7]=rs.getString("boarding_st");
						data[ii][8]=rs.getString("ending_st");
						data[ii][9]=rs.getString("t_fare");
						data[ii][10]=rs.getString("status");
						ii++;
					}
					rs.close();
					statement.close();
					connection.close();
				}
			}
			catch(Exception e){}
			
			return data;
			
	}
}
