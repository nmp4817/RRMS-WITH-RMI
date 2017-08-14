package RRMS;
import java.rmi.*;

interface Interface extends Remote
{
	public int signIn(String uid,char[] pwd) throws Exception;

	public void register(String uid,String nm,String bdt,String gen,char[] pwd,String ct,String sta,String cou,long poco,long mono,String addr,String eid) throws Exception;

	public String[][] view_History(String uid,int c) throws Exception;

	public int view_History(String uid) throws Exception;

	public String[][] booking(String uid1,String pname,String dte,int age,String tna,String st4,String st1,String st2,String st,String sno) throws Exception;

	public String[][] train2(String src,String dest,int c)throws Exception;

	public int train1(String src,String dest)throws Exception;
		
	public String[] train3(String st1,String st2) throws Exception;
	
	public String[][] pnr_status(String pnr) throws Exception;

}
