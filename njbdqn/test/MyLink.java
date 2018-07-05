package com.njbdqn.test;

/* import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager; */
import java.sql.*;
import java.text.SimpleDateFormat;


public class MyLink{
	public static void main(String[] args)throws Exception{
		
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection conn=DriverManager.getConnection
		("jdbc:mysql://127.0.0.1:3306/exps","root","106312");
		
		PreparedStatement pstm1=
			conn.prepareStatement(
				"insert into userinfos(username,birthday) values(?,?)");
		// pstm1.setString(1,"pz");
		//String str = "1999-5-5";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		//pstm1.setDate(2,new Date(sdf.parse(str).getTime())); 
		pstm1.setObject(1,"kf");
		/* pstm1.setObject(2,"1000-3-2"); */
		pstm1.setObject(2,sdf.parse("1822-4-5"));
		
		/* pstm1.setDate(2,new Date(new java.util.Date().getTime())); */
		pstm1.executeUpdate();
		PreparedStatement pstm2 =
			conn.prepareStatement("select * from userinfos");
		ResultSet rs = pstm2.executeQuery();
		/*while(rs.next()){
			System.out.println(rs.getInt(1)+"\t"
				+rs.getString(2)+"\t"+rs.getString(3));
		}*/
		
		while(rs.next()){
			System.out.println(rs.getInt("userid")
				+":" +rs.getString("username")
				+":"+rs.getDate("birthday"));
		}                                                                                                              
		
		
		
		if(rs!=null){
			rs.close();
		}
		if(pstm1!=null){
			pstm1.close();
		}
		if(pstm2!=null){
			pstm2.close();
		}
		if(conn!=null){
			conn.close();
		}
	}
}