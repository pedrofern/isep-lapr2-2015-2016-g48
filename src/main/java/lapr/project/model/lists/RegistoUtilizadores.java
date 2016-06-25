package lapr.project.model.lists;

import java.io.Serializable;
import java.util.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import lapr.project.model.Utilizador;

/**
 *
 * @author Pedro Fernandes
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class RegistoUtilizadores implements Serializable{

    private ArrayList<Utilizador> m_listaUtilizadores;

    /**
     * Metodo construtor para criar instancias de registoUtilizadores
     */
    public RegistoUtilizadores() {
        m_listaUtilizadores = new ArrayList<>();
    }

    /**
     * Cria um novo Utilizador.
     *
     * @return utilizador.
     */
    public Utilizador novoUtilizador() {
        return new Utilizador();
    }
/**
 * Regista e valida o utilizador
 * @param u
 * @return true se for valido e false se nao
 */
    public boolean registaUtilizador(Utilizador u) {
        if (u.valida() && validaUtilizador(u)) {
           return addUtilizador(u);
        } else {
            return false;
        }
    }
/**
 * Adiciona utilizador a lista de utilizadores
 * @param u
 * @return true se foi adicionado e false se contrario
 */
    public boolean addUtilizador(Utilizador u) {
        return this.m_listaUtilizadores.add(u);
    } 
    /**
     * Devolve a lista de utilizadores
     * @return 
     */
    public List<Utilizador> getListaUtilizadores(){
        return m_listaUtilizadores;
    }
   
/**
 * Devolve o utilizador por id
 * @param strId
 * @return o utilizador 
 */
    public Utilizador getUtilizadorByID(String strId) {
        for (Utilizador u : this.m_listaUtilizadores) {
            if (u.getUsername().equals(strId)) {
                return u;
            }
        }
        return null;
    }
/**
 * Devolve o utilizador atraves do email
 * @param strEmail
 * @return o utilizador
 */
    public Utilizador getUtilizadorByEmail(String strEmail) {
        for (Utilizador u : this.m_listaUtilizadores) {
            if (u.getEmail().equals(strEmail)) {
                return u;
            }
        }
        return null;
    }
/**
 * Altera o utilizador original 
 * @param uOriginal
 * @param uClone
 * @return utilizador actual
 */
    public boolean alteraUtilizador(Utilizador uOriginal, Utilizador uClone) {
        if (uClone.valida()) {
//            List<Utilizador> lstUtilizadores = new ArrayList<Utilizador>(m_listaUtilizadores);
//            lstUtilizadores.remove(uOriginal);
//            lstUtilizadores.add(uClone);
            if (validaLista(m_listaUtilizadores)) {
                uOriginal.setNome(uClone.getNome());
                uOriginal.setEmail(uClone.getEmail());
                uOriginal.setUsername(uClone.getUsername());
                uOriginal.setPassword(uClone.getPassword());
                return true;
            }
        }
        return false;
    }
    /**
     * Valida a lista de utilizadores
     * @param lista
     * @return true se valida, false se invalida
     */
    private boolean validaLista(List<Utilizador> lista) {
        return true;
    }
/**
 * Devolve os dados por id
 * @param uId
 * @return utilizador
 */
    public Utilizador getUtilizadorInfo(String uId) {
        for (Utilizador u : m_listaUtilizadores) {
            if (uId.equalsIgnoreCase(u.getUsername())) {
                return u;
            }
        }
        return null;
    }
/**
 * Devolve a lista de utilizadores nao registados
 * @return a lista de utilizadores nao registados
 */
    public List<Utilizador> getUtilizadoresNaoRegistados() {
        List<Utilizador> lUsers = new ArrayList<Utilizador>();

        for (Utilizador u : m_listaUtilizadores) {
            if (!u.getRegistado()) {
                lUsers.add(u);
            }
        }
        return lUsers;
    }
/**
 * Confirma registo do utilizador
 * @param u 
 */
    public void confirmaRegistoUtilizador(Utilizador u) {
        u.setRegistado(true);
    }
/**
 * Verifica se o utilizador existe
 * @param email
 * @param id
 * @return true se sim, false se nao
 */
    boolean hasUtilizador(String email, String id) {
        for (Utilizador utilizador : m_listaUtilizadores) {
            if (utilizador.getEmail().equals(email)) {
                if (utilizador.getID().equals(id)) {
                    return true;
                }
            }

        }

        return false;
    }
    
    /**
     * Devolve o tamanho da lista de utilizadores
     * @return o tamanho
     */
    public int tamanho() {
        return this.m_listaUtilizadores.size();
    }
    /**
     * Remove o utilizador
     * @param utilizador
     * @return true se removido, false se nao
     */
    public boolean removerUtilizador(Utilizador utilizador) {
        return m_listaUtilizadores.remove(utilizador);
    }
    /**
     * Ordena a lista de utilizadores por posicao
     */
    public void ordenarPorPosicao(){
        Collections.sort(m_listaUtilizadores);
    }

    /**
     * Devolve a descrição textual do Registo de Utilizadores.
     *
     * @return características do Registo de Utilizadores.
     */
    @Override
    public String toString() {
        return "RegistoUtilizadores:" + "m_listaUtilizadores=" + m_listaUtilizadores;
    }
    /**
     * Devolve um vector com a lista de utilizadores
     * @return um vector
     */
    public Utilizador[] getArray() {
        return m_listaUtilizadores.toArray( new Utilizador[m_listaUtilizadores.size()] );
     }
    /**
     * Conta o numero de utilizadores da lista
     * @return o numero de utilizadores da lista
     */
    public int countUtilizadores(){
        return m_listaUtilizadores.size();
    }
    
    
    
    /**
     * Metodo responsavel por validar utilizador
     * @param u utilizador 
     * @return true se validar false caso contrario
     */
    private boolean validaUtilizador(Utilizador u) {
        return !hasUtilizador(u.getEmail(), u.getID());
    }
   /**
    * Devolve a lista de utilizadores pendentes
    * @return a lista de utilizadores pendentes
    */
    public RegistoUtilizadores getUtilizadoresPend(){
        RegistoUtilizadores m_listaUtilizadoresPend;
        m_listaUtilizadoresPend= new RegistoUtilizadores();
        for (Utilizador u:m_listaUtilizadores){
            if (u.getRegistado()==false){
                m_listaUtilizadoresPend.addUtilizador(u);
            }
        } 
        return m_listaUtilizadoresPend;
    }
    /**
     * Devolve o id e email como string
     * @param id
     * @param email
     * @return email e id como string
     */
    public Utilizador getUtilizadorAtravesString(String id, String email){
        Utilizador u=null;
        try{
            if(hasUtilizador(id, email)){
            for (Utilizador utilizador : m_listaUtilizadores) {
                if (utilizador.getEmail().equals(email)) {
                    if (utilizador.getID().equals(id)) {
                        u=utilizador;
                    }
                }
                }

            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return u;
    }

}
