package RRMS;
import java.rmi.*;

public class R_Server
{
	public static void main(String args[]) throws Exception
	{
		try {
			Implementation i = new Implementation();
			Naming.rebind("rmi://localhost:1099/Imp",i);
			System.out.println("Server is ready.");
	   }catch (Exception e) {
		   System.out.println("Server failed: " + e);
		}
	}
}

