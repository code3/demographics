package com.lizardkinghotel.demographic.data;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;


@WebListener
public class PropertyData implements ServletContextListener{
	
	private String bootstrapMinCss = "css/bootstrap.min.css";
	private String bootstrapGridMinCss = "css/bootstrap-grid.min.css";

	
	public static final String getHeader() {
		
		String header = "<%@ page language=\"java\" contentType=\"text/html; charset=UTF-8\" pageEncoding=\"UTF-8\"%>";
		
//				<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
//		<%@page isELIgnored="false"%>
//		<!DOCTYPE html>
//		<html>
//		<head>
//		<meta charset="UTF-8">
//		<meta name="viewport" content="width=device-width, initial-scale=1.0">
//		<title>Insert title here</title>
//		<link rel="stylesheet" href="css/bootstrap.min.css" >
//		<link rel="stylesheet" href="css/bootstrap-grid.min.css" >
//		</head>';
		
		return header;
		
	}
	

	private Map<String, String> maritalStatusTypes;
	
	@Override
	public void contextInitialized(ServletContextEvent event) {
		
    	maritalStatusTypes = new LinkedHashMap<String, String>();
    	maritalStatusTypes.put("married/casado", "married/casado");
    	maritalStatusTypes.put("married/casado", "married/casado");
    	maritalStatusTypes.put("divorced/divorciado", "divorced/divorciado");
    	maritalStatusTypes.put("widow(er)/viudo(a)", "widow(er)/viudo(a)");
    	
    	event.getServletContext().setAttribute("data", this);
		
	}
	
  public Map<String, String> getMaritalStatusTypes() {
	  
	  return maritalStatusTypes;
	  
  }
	
	
}
