<%@page import="net.sf.json.JSONArray"%>
<%@page import="net.sf.json.JSONObject"%>
<%@page import="com.util.ConnectionProvider"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page trimDirectiveWhitespaces="true" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
   Connection conn = null;
   PreparedStatement pstmt = null;
   ResultSet rs = null;
   String sql = "select id, type,name, lng,lat,address " 
                       + " from googlemap";
   
   // [ {},{} ,{} ]
   JSONArray    jsonArray = null; 
		   
   try{
     conn = ConnectionProvider.getConnection();
     pstmt = conn.prepareStatement(sql);
     rs = pstmt.executeQuery();
     
     jsonArray = new JSONArray(); // []
     
     while( rs.next() ){
    	int id = rs.getInt("id");
    	String type = rs.getString("type");
    	String name = rs.getString("name");
    	double lng = rs.getDouble("lng");
    	double lat = rs.getDouble("lat");
    	String address = rs.getString("address"); 
     
    	JSONObject   jsonObject = new JSONObject();
	    	jsonObject.put("id", id);
	    	jsonObject.put("type", type);
	    	jsonObject.put("name", name);
	    	jsonObject.put("lng", lng);
	    	jsonObject.put("lat", lat);
	    	jsonObject.put("address", address);
	    jsonArray.add(jsonObject);
     }     
   }catch(Exception e){
	   e.printStackTrace();
   }finally{
	   pstmt.close();
	   rs.close();
	   conn.close();
   }
%>
<%= jsonArray %>