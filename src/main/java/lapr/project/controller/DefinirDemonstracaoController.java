/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import lapr.project.model.*;
import lapr.project.model.lists.*;
import lapr.project.utils.Data;

/**
 *
 * @author Edu
 */
public class DefinirDemonstracaoController {

    private RegistoExposicoes registoExposicoes;
    private CentroExposicoes ce;
    private ListaDemonstracoes listaDemonstracoes;
    private Utilizador utilizador;
    private Exposicao exposicao;
    private Demonstracao demonstracao;

    public DefinirDemonstracaoController(CentroExposicoes ce, Utilizador utilizador) {

        this.ce = ce;
        this.utilizador = utilizador;
    }

    public RegistoExposicoes getRegistoExposicoes() {

        return registoExposicoes = ce.getRegistoExposicoes();
    }

    public void setEposicao(Exposicao exposicao) {
        this.exposicao = exposicao;
    }

    public void setDemonstracao(Demonstracao demonstracao) {

        this.demonstracao = demonstracao;

    }

    public void setPeriodoCanidatura(Data inicio, Data fim) {
            demonstracao.setPeriodoCandidaturas(inicio, fim);
    }

}
