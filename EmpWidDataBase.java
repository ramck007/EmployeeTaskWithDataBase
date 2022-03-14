import java.util.*;

//import java.io.Serializable;
import java.sql.*;

public class EmpWidDataBase {

	public static void main(String[] args) throws SQLException {
		
		//employee e[]=new employee[2];
		System.out.println("Enter the Employee details");
		Scanner sc= new Scanner(System.in);
		int id; String name,location; long number;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sample","root","1234");
			Statement smt = con.createStatement();
			for(int i=0;i<3;i++) {
			  System.out.println("Enter the Employee ID"); 
			  id = sc.nextInt();
			  System.out.println("Enter the Employee Name"); 
			  name= sc.next();
			  System.out.println("Enter the Employee Number");
			  number = sc.nextLong();
			  System.out.println("Enter the Employee Location"); 
			  location= sc.next();
			  String sql = "insert into emp values(?,?,?,?);"; 
			  PreparedStatement stmt = con.prepareStatement(sql); 
			  stmt.setInt(1,id);
			  stmt.setString(2, name);
			  stmt.setLong(3, number); 
			  stmt.setString(4, location);
			  stmt.execute();
			}
			 System.out.println("Enter the id to get the Employee Details");
			 int k= sc.nextInt(); 
		//int i = 2;
		String sql1 = "select * from emp where id =";
		String sql2 = sql1+k+";";
		
		ResultSet rs= smt.executeQuery(sql2);
		while(rs.next()) {
			System.out.println("Employee id       : "+rs.getInt(1)+"\nEmployee Name     : "+rs.getString(2)+"\nEmployee Number   : "+rs.getLong(3)+"\nEmployee Location : "+rs.getString(4));
		}
		
	//	System.out.println("Executed");
			
			
			
		/*
		 * //ResultSet rs=smt.executeQuery("Create Database sample"); // ResultSet
		 * rs=smt.executeQuery("select * from samp1"); while(rs.next()) {
		 * System.out.println(rs.getInt(1)+" "+rs.getInt(2)); }
		 */
			
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		/*for(int i=0;i<2;i++) {
			System.out.println("Enter the Employee ID");
			id = sc.nextInt();
			System.out.println("Enter the Employee Name");
			name= sc.next();
			System.out.println("Enter the Employee Number");
			number = sc.nextLong();
			System.out.println("Enter the Employee Location");
			location= sc.next();
			System.out.println("");*/
			
		//	e[i]=new employee(id,name,number,location);
		
		//}
		
		
		
		/*
		 * ObjectInputStream inputStream = new ObjectInputStream(new
		 * FileInputStream("empfile")); Object obj=null;
		 * 
		 * while((obj=inputStream.readObject()) instanceof endoffile==false ) {
		 * System.out.println("Employee id       : "+((employee)obj).id);
		 * System.out.println("Employee Name     : "+((employee)obj).name);
		 * System.out.println("Employee Number   : "+((employee)obj).number);
		 * System.out.println("Employee Location : "+((employee)obj).location);
		 * System.out.println(""); }
		 */
	}
}

/*
 * class employee implements Serializable{ int id; String name,location; long
 * number; public employee (int id,String name ,long number,String location) {
 * this.id=id; this.name=name; this.number=number; this.location=location; } }
 * 
 * class endoffile implements Serializable{
 * 
 * }
 */