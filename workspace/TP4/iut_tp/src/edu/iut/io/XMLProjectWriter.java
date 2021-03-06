package edu.iut.io;

import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Comment;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import edu.iut.app.Agenda;
import edu.iut.app.ExamEvent;
import edu.iut.app.Person;

//EX 1 Completer la classe 

public class XMLProjectWriter {
	
	public XMLProjectWriter() {		
	}
	
	public void save(Agenda a, java.io.File xmlfile) {
		final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
		    DocumentBuilder builder = factory.newDocumentBuilder();
			Document document= builder.newDocument();
			
			Element root = document.createElement("agenda");			
			Comment comment = document.createComment("Agenda backup");
			root.appendChild(comment);
			
			for (ExamEvent event : a) {
				Element event1 = document.createElement("Event");
				Element personne = document.createElement("Personne");
				Element jury = document.createElement("Jury");
				Element documents = document.createElement("Documents");

				event1.setAttribute("Date", event.getDate().toString());
				personne.setAttribute("Fonction", ""+event.getStudent().getFunction());
				personne.setAttribute("Prenom", ""+event.getStudent().getFirstname());
				personne.setAttribute("Nom", ""+event.getStudent().getLastname());
				personne.setAttribute("Mail", ""+event.getStudent().getEmail());
				personne.setAttribute("Tel", ""+event.getStudent().getPhone());
				
				for (Person membreJury : event.getJury()){
					Element membre = document.createElement("Membre");
					membre.setAttribute("Fonction", ""+membreJury.getFunction());
					membre.setAttribute("Prenom", ""+membreJury.getFirstname());
					membre.setAttribute("Nom", ""+membreJury.getLastname());
					membre.setAttribute("Mail", ""+membreJury.getEmail());
					membre.setAttribute("Tel", ""+membreJury.getPhone());
					jury.appendChild(membre);
				}
				event1.setAttribute("Classroom", ""+event.getClassroom().getClassRoomNumber());

				for (edu.iut.app.Document docs : event.getDocuments()){
					Element doc = document.createElement("Document");
					doc.setAttribute("URL", ""+docs.getDocumentURI());
					documents.appendChild(doc);
				}

				event1.appendChild(personne);
				event1.appendChild(jury);
				event1.appendChild(documents);
				root.appendChild(event1);
			}
						
			document.appendChild(root);
			document.setXmlStandalone(true);
			document.setXmlVersion("1.0");
			
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
		    Transformer transformer = transformerFactory.newTransformer();
		    DOMSource source = new DOMSource(document);
		    StreamResult output = new StreamResult(xmlfile);
			    
		    transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		    transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
				
		    transformer.transform(source, output);	

		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		}

	}
}
