package lapr.project.model;

import java.io.Serializable;
import java.util.Objects;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import lapr.project.utils.*;
import lapr.project.utils.Utils;

/**
 *
 * @author Pedro Fernandes
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Utilizador implements Comparable<Utilizador>, Serializable  {

    /**
     * Nome do utilizador
     */
    private String nome;
    /**
     * Email do utilizador
     */
    private String email;
    /**
     * Password do utilizador
     */
    private String password;
    /**
     * Username do utilizador
     */
    private String username;
    /**
     * Nome por omissao
     */
    private static final String NOME_POR_OMISSAO = "Utilizador não registado";
    /**
     * Email por omissao
     */
    private static final String EMAIL_POR_OMISSAO = "Email do utilizador não registado";
    /**
     * Password por omissao
     */
    private static final String PASS_POR_OMISSAO = "Password do utilizador não registado";
    /**
     * Username por omissao
     */
    private static final String USER_POR_OMISSAO = "Username do utilizador não registado";
    /**
     * Utilizador registado
     */
    private Boolean bRegistado;
    /**
     * Tempo de serviço 
     */
    private int tempoServico=0;

    /**
     * Cria uma instancia de utilizador vazia, com os dados por omissao
     */
    public Utilizador() {
        nome = NOME_POR_OMISSAO;
        email = EMAIL_POR_OMISSAO;
        username = USER_POR_OMISSAO;
        password = PASS_POR_OMISSAO;
        bRegistado = false;        
    }
/**
 * Constroi uma instancia de utilizador, com os dados do utilizador, passados como parametro
 * @param nome
 * @param email
 * @param username
 * @param password
 * @param bRegistado
 * @param experiencia 
 */
    public Utilizador(String nome, String email, String username,String password, Boolean bRegistado, int experiencia) {
        this.nome=nome;
        this.email = email;
        this.username = username;
        setPassword(password);
        this.bRegistado = bRegistado;
        this.tempoServico=experiencia;
    }
    /**
     * Constroi outra instancia de utilizador apenas com os dados para o login
     * @param strNome
     * @param strUsername
     * @param strPwd
     * @param strEmail 
     */
    public Utilizador(String strNome, String strUsername, String strPwd, String strEmail) {
        setNome(strNome);
        setUsername(strUsername);
        setPassword(strPwd);
        setEmail(strEmail);
        bRegistado = true;
    }

    /**
     * Constroi uma instancia cópia do Utilizador.
     * 
     * @return cópia do Utilizador
     */
    public Utilizador cloneUtilizador() {
      
        return new Utilizador(this.getNome(), this.getUsername(), this.getPassword(), this.getEmail());
    }
    
    /**
     * Devolve o id 
     * @return id
     */
    public String getID() {
        return username;
    }
/**
 * Verifica se o utilizador tem id
 * @param strId
 * @return true se tiver, false caso contrario
 */
    public boolean hasID(String strId) {
        return username.equalsIgnoreCase(strId);
    }
    /**
     * Verifica se o utilizador tem email
     * @param email
     * @return true se tiver, false caso contrario
     */
     public boolean hasEmail(String email) {
        return email.equalsIgnoreCase(email);
    }
/**
 * Devolve o nome
 * @return nome
 */
    public String getNome() {
        return nome;
    }
/**
 * Altera o nome
 * @param newNome 
 */
    public void setNome(String newNome) {
        this.nome = newNome;
    }
/**
 * Devolve o email
 * @return o email
 */
    public String getEmail() {
        return email;
    }
/**
 * Altera o email
 * @param newEmail 
 */
    public void setEmail(String newEmail) {
        this.email = newEmail;
    }
/**
 * Devolve a password
 * @return password
 */
    public String getPassword() {
        return password;
    }
/**
 * Altera a password
 * @param newPassword 
 */
    public void setPassword(String newPassword) {
        this.password = Utils.encriptar(newPassword);
    }
/**
 * Devolve o username
 * @return username
 */
    public String getUsername() {
        return username;
    }
/**
 * Altera o username
 * @param newUsername 
 */
    public void setUsername(String newUsername) {
        this.username = newUsername;
    }
/**
 * Verifica se o utilizador esta registado ou nao
 * @return true se verdadeiro, false se falso
 */
    public Boolean getRegistado() {
        return bRegistado;
    }
/**
 * Altera o estado de registado ou nao do utilizador
 * @param registado 
 */
    public void setRegistado(Boolean registado) {
        this.bRegistado = registado;
    }
/**
 * Valida os daods de login
 * @return true se verdadeiro, false se falso
 */
    public boolean valida() {
  
        return validaNome() && validaUsername() && validaPassword() && validaEmail();
    }
/**
 * Valida nome 
 * @return true se verdadeiro, false se falso
 */
    public boolean validaNome() {
        if (nome == null || nome.isEmpty() || nome.matches(".*\\d+.*")) {
            return false;
        }
        return true;
    }
/**
 * Valida username
 * @return true se verdadeiro, false se falso
 */
    public boolean validaUsername() {
        if (username == null || username.isEmpty()) {
            return false;
        }
        return true;
    }
/**
 * Valida password
 * @return true se verdadeiro, false se falso
 */
    public boolean validaPassword() {
        if (password == null || password.isEmpty()) {
            return false;
        }
        return true;
    }
/**
 * Valida email
 * @return true se verdadeiro, false se falso
 */
    public boolean validaEmail() {
        return Utils.isEmailValido(email);
    }
/**
 * Representacao textual simples 
 * @return o objecto como string
 */
    public String mostraSimples() {
        return username + "-" + nome;
    }
/**
 * Representacao textual simples 
 * @return o objecto como string
 */
    @Override
    public String toString(){
        return nome+":"+email;
    }
    
    /**
     * Representacao textual geral dos dados do utilizador
     * @return o objecto como string
     */
    public String toStringGeral() {
        String str = "Utilizador:\n";
        str += "\tNome: " + this.nome + "\n";
        str += "\tUsername: " + this.username + "\n";
        str += "\tPassword: " + this.password + "\n";
        str += "\tEmail: " + this.email + "\n";

        return str;
    }
/**
 * Compara o Utilizador com outro objecto
 * @param outroObjeto
 * @return true se o objecto recebido é equivalente  e false caso contrario 
 */
    @Override
    public boolean equals(Object outroObjeto) {
        if (this == outroObjeto) {
            return true;
        }
        if (outroObjeto == null || getClass() != outroObjeto.getClass()) {
            return false;
        }
        Utilizador outroUtilizador = (Utilizador) outroObjeto;

        return nome.equalsIgnoreCase(outroUtilizador.nome);
    }
/**
 * Calcula o hashcode do nome
 * @return hash
 */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.nome);
        return hash;
    }
    /**
     * Devolve o tempo de servico do utilizador
     * @return o tempo de servico
     */
    public int getTempoServico(){
        return tempoServico;
    }
/**
 * Compara o email com outro email 
 * @param outroUtilizador
 * @return 0 se equivalentes, mais de 0 e menos de 0, se nao forem
 */
    @Override
    public int compareTo(Utilizador outroUtilizador) {
        return email.compareTo(outroUtilizador.email);
    }

}
