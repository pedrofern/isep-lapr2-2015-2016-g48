package lapr.project.model.lists;

import java.util.*;
import lapr.project.model.Utilizador;

/**
 *
 * @author Pedro Fernandes
 */
public class RegistoUtilizadores {

    private List<Utilizador> m_listaUtilizadores;

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

    public boolean registaUtilizador(Utilizador u) {
        if (u.valida() && validaUtilizador(u)) {
            return addUtilizador(u);
        } else {
            return false;
        }
    }

    private boolean validaUtilizador(Utilizador u) {
        System.out.println("RegistoUtilizadores: validaUtilizador: " + u.toString());
        return true;
    }

    public boolean addUtilizador(Utilizador u) {
        return this.m_listaUtilizadores.add(u);
    }

    public List<Utilizador> getListaUtilizadores() {
        return m_listaUtilizadores;
    }

    public Utilizador getUtilizadorByID(String strId) {
        for (Utilizador u : this.m_listaUtilizadores) {
            if (u.getUsername().equals(strId)) {
                return u;
            }
        }
        return null;
    }

    public Utilizador getUtilizadorByEmail(String strEmail) {
        for (Utilizador u : this.m_listaUtilizadores) {
            if (u.getEmail().equals(strEmail)) {
                return u;
            }
        }
        return null;
    }

    public boolean alteraUtilizador(Utilizador uOriginal, Utilizador uClone) {
        if (uClone.valida()) {
            List<Utilizador> lstUtilizadores = new ArrayList<Utilizador>(m_listaUtilizadores);
            lstUtilizadores.remove(uOriginal);
            lstUtilizadores.add(uClone);
            if (validaLista(lstUtilizadores)) {
                uOriginal.setNome(uClone.getNome());
                uOriginal.setEmail(uClone.getEmail());
                uOriginal.setUsername(uClone.getUsername());
                uOriginal.setPassword(uClone.getPassword());
                return true;
            }
        }
        return false;
    }
    
    private boolean validaLista(List<Utilizador> lista) {
        System.out.println("RegistoUtilizadores: validaLista: " + lista.toString());
        return true;
    }

    public Utilizador getUtilizadorInfo(String uId) {
        for (Utilizador u : m_listaUtilizadores) {
            if (uId.equalsIgnoreCase(u.getUsername())) {
                return u;
            }
        }
        return null;
    }

    public List<Utilizador> getUtilizadoresNaoRegistados() {
        List<Utilizador> lUsers = new ArrayList<Utilizador>();

        for (Utilizador u : m_listaUtilizadores) {
            if (!u.getRegistado()) {
                lUsers.add(u);
            }
        }
        return lUsers;
    }

    public void confirmaRegistoUtilizador(Utilizador u) {
        u.setRegistado(true);
    }

    boolean hasUtilizador(String username, String password) {
        for (Utilizador utilizador : m_listaUtilizadores) {
            if (utilizador.getUsername().equals(username)) {
                if (utilizador.getPassword().equals(password)) {
                    return true;
                }
            }

        }

        return false;
    }
    
    
    public int tamanho() {
        return this.m_listaUtilizadores.size();
    }
    
    public boolean removerUtilizador(Utilizador utilizador) {
        return m_listaUtilizadores.remove(utilizador);
    }
    
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

}
