/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.ui;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import lapr.project.model.CentroExposicoes;

/**
 *
 * @author Pedro Fernandes
 */
public class FichCentroExposicoes {
/**
 * Caminho em que o ficheiro binario se encontra
 */
    public static final String NOME_BINARIO = "src/main/resources/ficheiros/CentroExposicoes.bin";
/**
 * Construtor relativo a classe ficheiro
 */
    public FichCentroExposicoes() {
    }
/**
 * Metodo que vai ler em binario toda a informação contida no Centro de Exposições
 * @return Casa a leitrua do ficheiro seja um sucesso retorna true caso contrario retorna false
 */
    public CentroExposicoes lerFichBinario() {
        CentroExposicoes centroExposicoes;
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(NOME_BINARIO));
            try {
                centroExposicoes = (CentroExposicoes) in.readObject();
            } finally {
                in.close();
            }
            return centroExposicoes;
        } catch (IOException | ClassNotFoundException ex) {
            return null;
        }
    }
/**
 * Metodo que vai guardar num ficheiro binario toda a informação contida no Centro de Exposições
 * @param centroExposicoes Centro de Exposições
 * @return Caso o ficheiro seja guardado com sucesso retorna true caso contrario retorna false
 */
    public boolean guardarFichBinario(CentroExposicoes centroExposicoes) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(NOME_BINARIO));
            try {
                out.writeObject(centroExposicoes);
            } finally {
                out.close();
            }
            return true;
        } catch (IOException ex) {
            return false;
        }
    }
    
    

}

