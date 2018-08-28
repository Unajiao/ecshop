package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Database {
	//test
	public List<Map<String,String>> connect_Database(String sqlquery) {	
	//public List<Map<String,String>> connect_Database( ) {	
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
			try{
				Class.forName("com.mysql.jdbc.Driver");
				//����static���췽������Connection���������ݿ�����
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ECshop?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=GMT%2B8", "root", "");
				//����connection��̬��������Statement��Ϊsql���ִ���ṩ����
				Statement sta=con.createStatement();
				//ִ��sql��÷��ؽ��
				//ResultSet rset=sta.executeQuery("select  DISTINCT(goods_name) from  ecs_goods order by rand() limit 2;");
				ResultSet rset = sta.executeQuery(sqlquery);
				//��ȡ���������ݰ�װ��List<map>������
		        java.sql.ResultSetMetaData md = rset.getMetaData();
		        int columnCount = md.getColumnCount();
		        while (rset.next()) {
		        	Map<String,String> rowData = new HashMap<String, String>(columnCount);
		            for (int i = 1; i <=columnCount; i++) {
		                rowData.put(md.getColumnName(i), (String) rset.getObject(i));
		            }
		            list.add(rowData);
		        }
		      //�ر�ResultSet��Statement��connection
				rset.close();
				sta.close();
				con.close();	
			}catch(Exception e){
				System.out.println(e);	
			}
			return list;
			
		}
		
	} 
