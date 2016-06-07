package lapr.project.ui.ucs;

import lapr.project.controller.*;
import java.util.*;
import lapr.project.model.*;
import lapr.project.ui.UI;

/**
 *
 * @author Pedro Fernandes
 */
public class ConfirmarRegistoUtilizadorUI implements UI{

    private final ConfirmarRegistoUtilizadorController controller;
    private Utilizador m_oUu;
    Scanner ler;

    public ConfirmarRegistoUtilizadorUI(CentroExposicoes ce, Utilizador u) {
        controller = new ConfirmarRegistoUtilizadorController(ce);
        m_oUu = u;
        ler = new Scanner(System.in);
    }

    @Override
    public void run() {
        System.out.println("Confirmar Registo Utilizador:");

        do {
            List<Utilizador> lUsers = controller.iniciaConfirmacaoUtilizador();
            mostraUtilizadores(lUsers);
            selecionaUtilizador();

            System.out.print("continuar (s/n)?");
        } while ("s".equalsIgnoreCase(ler.nextLine()));
    }

    public void mostraUtilizadores(List<Utilizador> lUsers) {
        System.out.println("Utilizadores");
        System.out.println("------------");
        for (Utilizador u : lUsers) {
            System.out.printf("[%s] : %s\n", u.getUsername(), u.getEmail());
        }
    }

    public void selecionaUtilizador() {
        System.out.print("Username?:");
        String uId = ler.nextLine();

        Utilizador u = controller.getUtilizadorInfo(uId);

        if (u == null || u.getRegistado()) {
            System.out.println("ERRO: utilizador invalido para confirmacao");
        } else {
            System.out.println(u.toString());
            System.out.print("confirma (s/n)?");
            if ("s".equalsIgnoreCase(ler.nextLine())) {

                controller.confirmaRegistoUtilizador();
                System.out.println("sucesso");
            }
        }
    }
}
