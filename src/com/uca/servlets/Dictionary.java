package com.uca.servlets;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import com.google.gson.*;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.w3c.dom.Node;
import org.w3c.dom.Element;


@WebServlet("/dictionary")

public class Dictionary extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	

		public Dictionary() {
			
		}
		
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			File fXmlFile = new File("C:\\Users\\hmanr\\Documents\\workspace-sts-3.9.3.RELEASE\\Dictionary\\WebContent\\WEB-INF\\resources\\dictionary.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder;
			int answer=0;
			boolean flag=false;
			try {
				dBuilder = dbFactory.newDocumentBuilder();
				Document doc = dBuilder.parse(fXmlFile);
				doc.getDocumentElement().normalize();
				NodeList ndlist=doc.getElementsByTagName("word");
				String name=request.getParameter("name");
				PrintWriter out=response.getWriter();
				int i=0;
				
				while(i<ndlist.getLength()) {
					Node nNode=ndlist.item(i);
					Element element=(Element) nNode;
					/*if(element.getElementsByTagName("name").item(i).getTextContent().toString().equals(name)) {
						answer=i;
						flag=true;
						break;
					}*/	
					i++;
				}
				if(flag!=true) {
					Node nNodex=ndlist.item(answer);
					Element elementx=(Element) nNodex;
					out.println("<html>");
					out.print("<body>");
					out.println("<b>Name:"+elementx.getElementsByTagName("name").item(answer).getTextContent().toString()+"</b>");
					out.println("<b>Description:"+elementx.getElementsByTagName("description").item(answer).getTextContent().toString()+"</b>");
					out.print("<body>");
					out.println("<html>");
				}
				else{
					out.println("<html>");
					out.print("<body>");
					out.println("<b>RIP</b>");
					out.print("<body>");
					out.println("<html>");
				}
			} catch (ParserConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SAXException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
		

}
