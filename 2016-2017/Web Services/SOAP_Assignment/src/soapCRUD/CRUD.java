package soapCRUD;

import javax.jws.WebService;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Vector;
@WebService
public class CRUD {
	static Vector<Book> books; 
	static File xmlFile = new File("soap_assign.xml");
	public Vector<Book> loadXmlFile(){
		try{
			if(xmlFile.exists()){
				books = new Vector<Book>();
				System.out.println("File does exist!!");
				BufferedReader br = new BufferedReader(new FileReader(xmlFile));
				
				//******************
				DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
				DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
				Document doc = dBuilder.parse(xmlFile);
				doc.getDocumentElement().normalize();
				
				NodeList nList = doc.getElementsByTagName("book");
				Book b;
				String bookName,author,publishDate,isbn,des, tempPrice;
				double price;
				for (int temp = 0; temp < nList.getLength(); temp++) {
		            Node nNode = nList.item(temp);
		            /*System.out.println("\n-------------------" 
		               + nNode.getNodeName()+"-------------------");*/
		            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
		               Element eElement = (Element) nNode;
		            	bookName = eElement
				                  .getElementsByTagName("name")
				                  .item(0)
				                  .getTextContent();
		            	author = eElement
				                  .getElementsByTagName("author")
				                  .item(0)
				                  .getTextContent();
		            	publishDate = eElement
				                  .getElementsByTagName("publish_date")
				                  .item(0)
				                  .getTextContent();
		            	isbn = eElement
				                  .getElementsByTagName("isbn")
				                  .item(0)
				                  .getTextContent();
		            	des = eElement
				                  .getElementsByTagName("description")
				                  .item(0)
				                  .getTextContent();
		            	tempPrice = eElement
				                  .getElementsByTagName("price")
				                  .item(0)
				                  .getTextContent();
		               //------------------------------------
		            	price = Double.parseDouble(tempPrice);
		            	b = new Book(bookName,author,publishDate,isbn,des,price);
		            	books.addElement(b);
		               
		               //------------------------------------
		            }
				}
				//******************				
				
				String line;
				while ((line = br.readLine()) != null) {
					//System.out.println(xmlFile+line);//+xmlFile.getAbsolutePath());
				}
				br.close();
			} else {
				System.out.println("File does not exist!!");
			}
		} catch(Exception e){
			e.printStackTrace();
		}
		return books;
	}
	public String addBook(String bookName,String author, String publishDate, String isbn, String description, double price){
		Book t = new Book(description, description, description, description, description, price);
		books.addElement(t);
		return "Item was added, to file <strong>"+xmlFile+"</strong>!!";
	}
	public String remove (int index){
		Book t = books.elementAt(index);
		books.remove(t);
		
		return "Item was removed, make sure to <strong>SAVE</strong>!!";
	}
	public String update(int index, String bookName,String author, String publishDate, String isbn, String description, double price){
		
		Book t = books.elementAt(index);
		books.remove(t);
		t.setBookName(bookName);
		t.setAuthor(author);
		t.setPublishDate(publishDate);
		t.setIsbn(isbn);
		t.setDescription(description);
		t.setPrice(price);
		books.addElement(t);
		return "Item was updated, to file <strong>"+xmlFile+"</strong>!!";
		
	}
	public Vector<Book> display(){
		return books;
	}
	public static void saveXmlFile(){
		try{
			FileWriter writer = new FileWriter(xmlFile);
			writer.append("<?xml version='1.0' encoding='UTF-8'?>\n");
			writer.append("<books>\n");
			
			for(Book temp:books){
				writer.append("\t<book>\n");
					writer.append("\t\t<name>"+temp.getBookName()+"</name>\n");
					writer.append("\t\t<author>"+temp.getAuthor()+"</author>\n");
					writer.append("\t\t<publish_date>"+temp.getPublishDate()+"</publish_date>\n");
					writer.append("\t\t<isbn>"+temp.getIsbn()+"</isbn>\n");
					writer.append("\t\t<description>"+temp.getDescription()+"</description>\n");
					writer.append("\t\t<price>"+temp.getPrice()+"</price>\n");
				writer.append("\t</book>\n");
			}	
			
			writer.append("</books>");
			writer.flush();
			writer.close();
		} catch(Exception e){
			e.printStackTrace();
		}
	}
}