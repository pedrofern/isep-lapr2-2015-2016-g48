/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.utils;

import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import lapr.project.model.CentroExposicoes;

/**
 *
 * 
 */
public class XML {

    private static final String FILE = "CentroExposicoes.xml";

    /**
     * Cria o metodo de exportacao para xml
     */
    public XML() {
    }

    /**
     * Cria o metodo de exportacao
     *
     * @param ce
     * @return 
     */
    public boolean exportToXML(CentroExposicoes ce) {
        try {
            JAXBContext context = JAXBContext.newInstance(CentroExposicoes.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(ce, new FileWriter(FILE));
            return true;
        } catch (JAXBException | IOException e) {
                System.out.println(e.getMessage());
            return false;
        }
    }
    
    public CentroExposicoes importFromXML(File file) throws FileNotFoundException {
        JAXBContext jaxbContext;
        try {
            jaxbContext = JAXBContext.newInstance(CentroExposicoes.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            CentroExposicoes ce = (CentroExposicoes) jaxbUnmarshaller.unmarshal(file);
            return ce;
        } catch (JAXBException ex) { 
            System.out.println(ex);
            return null;
        }
    }

}
