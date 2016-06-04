package lapr.project.model;

import lapr.project.utils.*;

/**
 *
 * @author Pedro Fernandes
 */
public class Utilizador {

    private String nome;
    private String email;
    private String password;
    private String username;
    private Boolean m_bRegistado;

    public Utilizador() {

    }

    public Utilizador(String email, String username, Boolean bRegistado) {
        this.email = email;
        this.username = username;
        this.m_bRegistado = bRegistado;
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
    @Override
    public Utilizador clone() {
        return new Utilizador(this.getNome(), this.getUsername(), this.getPassword(), this.getEmail());
    }
    
    public String getID() {
        return username;
    }

    public boolean hasID(String strId) {
        return username.equalsIgnoreCase(strId);
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
        System.out.println("Utilizador:valida: " + this.toString());
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
    public String toString() {
        String str = "Utilizador:\n";
        str += "\tNome: " + this.nome + "\n";
        str += "\tUsername: " + this.username + "\n";
        str += "\tPassword: " + this.password + "\n";
        str += "\tEmail: " + this.email + "\n";

        return str;
    }

    public boolean equals(Utilizador u) {
        if (this == u) {
            return true;
        }
        if (u != null) {
            return hasID(u.username);
        }
        return false;
    }

}
