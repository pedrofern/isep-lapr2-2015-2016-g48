/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import lapr.project.model.*;
import lapr.project.model.*;
import lapr.project.model.lists.*;

/**
 *
 * @author Edu
 */
public class ListagemCandidaturaRetiradaController {

    private CentroExposicoes centro;
    private Utilizador utilizador;
    private ListaCandidaturas listacandidaturas;
    private Exposicao exposicao;
    private RegistoUtilizadores listaUtilizadores;
    private RegistoExposicoes listaExposicoes;

    public ListagemCandidaturaRetiradaController(CentroExposicoes centro, Utilizador utilizador) {

        this.centro = centro;
        this.utilizador = utilizador;
        listacandidaturas = new ListaCandidaturas();
    }

//    public List<Exposicao> getListaExposicaoOrganizador(String email) {
//        
//        return listaExposicoes.geListatExposicaoOrganizador(email);
//    }
    

}
