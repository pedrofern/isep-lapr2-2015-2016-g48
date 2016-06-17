package lapr.project.model;

import java.util.Objects;
import lapr.project.utils.*;

/**
 *
 * @author Pedro Fernandes
 */
public class Utilizador implements Comparable<Utilizador>{

    private String nome;
    private String email;
    private String password;
    private String username;
    private static final String NOME_POR_OMISSAO = "Utilizador não registado";
    private static final String EMAIL_POR_OMISSAO = "Email do utilizador não registado";
    private static final String PASS_POR_OMISSAO = "Password do utilizador não registado";
    private static final String USER_POR_OMISSAO = "Username do utilizador não registado";
    private Boolean m_bRegistado;
    private int tempoServico=0;

    public Utilizador() {
        nome = NOME_POR_OMISSAO;
        email = EMAIL_POR_OMISSAO;
        username = USER_POR_OMISSAO;
        password = PASS_POR_OMISSAO;
    }

    public Utilizador(String nome, String email, String username, Boolean bRegistado, int experiencia) {
        this.nome=nome;
        this.email = email;
        this.username = username;
        this.m_bRegistado = bRegistado;
        this.tempoServico=experiencia;
    }
    
    public Utilizador(String strNome, String strUsername, String strPwd, String strEmail) {
        setNome(strNome);
        setUsername(strUsername);
        setPassword(strPwd);
        setEmail(strEmail);
    }

    /**
     * Constroi uma instancia cópia do Utilizador.
     * 
     * @return cópia do Utilizador
     */
    public Utilizador cloneUtilizador() {
      
        return new Utilizador(this.getNome(), this.getUsername(), this.getPassword(), this.getEmail());
    }
    
    public String getID() {
        return username;
    }

    public boolean hasID(String strId) {
        return username.equalsIgnoreCase(strId);
    }
    
     public boolean hasEmail(String email) {
        return email.equalsIgnoreCase(email);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String newNome) {
        this.nome = newNome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String newEmail) {
        this.email = newEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String newPassword) {
        this.password = newPassword;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String newUsername) {
        this.username = newUsername;
    }

    public Boolean getRegistado() {
        return m_bRegistado;
    }

    public void setRegistado(Boolean registado) {
        this.m_bRegistado = registado;
    }

    public boolean valida() {
  
        return validaNome() && validaUsername() && validaPassword() && validaEmail();
    }

    public boolean validaNome() {
        if (nome == null || nome.isEmpty() || nome.matches(".*\\d+.*")) {
            return false;
        }
        return true;
    }

    public boolean validaUsername() {
        if (username == null || username.isEmpty()) {
            return false;
        }
        return true;
    }

    public boolean validaPassword() {
        if (password == null || password.isEmpty()) {
            return false;
        }
        return true;
    }

    public boolean validaEmail() {
        return Utils.isEmailValido(email);
    }

    public String mostraSimples() {
        return username + "-" + nome;
    }

    @Override
    public String toString(){
        return nome+":" + email;
    }
    
    
    public String toStringGeral() {
        String str = "Utilizador:\n";
        str += "\tNome: " + this.nome + "\n";
        str += "\tUsername: " + this.username + "\n";
        str += "\tPassword: " + this.password + "\n";
        str += "\tEmail: " + this.email + "\n";

        return str;
    }

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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.nome);
        return hash;
    }
    
    public int getTempoServico(){
        return tempoServico;
    }

    @Override
    public int compareTo(Utilizador outroUtilizador) {
        return email.compareTo(outroUtilizador.email);
    }

}
