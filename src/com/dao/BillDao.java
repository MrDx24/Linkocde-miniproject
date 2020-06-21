package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;


public class BillDao {

	Dao dao = new Dao();

	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	public BillDao() {
		// TODO Auto-generated constructor stub
	}
	
	public int placeOrder(int id ) throws Exception {
		
		con = dao.connect();
		ps = con.prepareStatement("delete from orders where userid='"+id+"'");
		
		
		int i = ps.executeUpdate();
		
		return i;
	}
	
	public String sendSms(String messageData, String mobile) {
		try {
			// Construct data
			String apiKey = "apikey=" + "SP5QKdndEHg-KGK4dsLDWEVQkqlLNtqpH4ab40gXeD";
			String message = "&message=" + messageData;
			String sender = "&sender=" + "TXTLCL";
			String numbers = "&numbers=" + "91"+mobile;
			
			// Send data
			HttpURLConnection conn = (HttpURLConnection) new URL("https://api.textlocal.in/send/?").openConnection();
			String data = apiKey + numbers + message + sender;
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Length", Integer.toString(data.length()));
			conn.getOutputStream().write(data.getBytes("UTF-8"));
			final BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			final StringBuffer stringBuffer = new StringBuffer();
			String line;
			while ((line = rd.readLine()) != null) {
				stringBuffer.append(line);
			}
			rd.close();
			
			return stringBuffer.toString();
		} catch (Exception e) {
			System.out.println("Error SMS "+e);
			return "Error "+e;
		}
	}
}
