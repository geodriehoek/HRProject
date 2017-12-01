package utilities;

import domain.Worker;

import javax.xml.bind.*;
import java.io.File;

public class XMLUtil {              //aanpassen"CreateContactXML" en "ReadContact" uit XML_oef

    public void marshallWorker() throws Exception{
//        Document doc = new Document();
//
//        Element emp = new Element("employee");
//        Namespace sns = Namespace.getNamespace("xsi", "http://www.w3.org/2001/XMLSchema-instance");
//        emp.addNamespaceDeclaration(sns);
//        doc.setRootElement(emp);
//
//        emp.addContent(new Element("firstName").setText("Rul"));
//        emp.addContent(new Element("lastName").setText("G"));
//        emp.addContent(new Element("middleName").setText("niks"));
//        emp.addContent(new Element("gender").setText("MALE"));
//        emp.addContent(new Element("ssn").setText("15.20.45-123.88"));
//        emp.addContent(new Element("salary").setText("tienduust"));
//        emp.addContent(new Element("street").setText("muinkLAN"));
//        emp.addContent(new Element("streeNumber").setText("43"));
//        emp.addContent(new Element("city").setText("Hent"));
//        emp.addContent(new Element("ZIP").setText("9000"));
//        emp.addContent(new Element("Country").setText("Belgium"));
//        emp.addContent(new Element("transportType").setText("fiets"));
//
//    }
//
//    public void writeDoc(Document doc) throws IOException{
//        XMLOutputter out = new XMLOutputter(Format.getPrettyFormat());
//        out.output(doc, new FileWriter("HREmployeeImport.xml"));
//    }
        JAXBContext ctx = JAXBContext.newInstance(Worker.class);
        Marshaller marshaller = ctx.createMarshaller();
        marshaller.setProperty("jaxb.formatted.out", true);
        marshaller.setProperty("jaxb.noNamespaceSchemaLocation, Worker.xsd");

        File file = new File("Worker.xml");
        marshaller.marshal();


    }
}
