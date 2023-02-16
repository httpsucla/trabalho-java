/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.br.tads.locadora.controller;

import com.br.tads.locadora.model.Automovel;
import com.br.tads.locadora.model.Motocicleta;
import com.br.tads.locadora.model.Van;
import com.br.tads.locadora.model.Veiculo;
import com.br.tads.locadora.view.Info;
import com.br.tads.locadora.view.VendasComponent;
import java.util.ArrayList;
import java.util.List;
import locadora.model.dao.VeiculoDao;

/**
 *
 * @author paula
 */
public class VendasController {
    
    private VendasComponent view;
    private VeiculoDao modelDao;
    private List<Veiculo> veiculos = new ArrayList<>();
    private Info info;
    
    public VendasController(VendasComponent view, VeiculoDao modelDao) {
        this.view = view;
        this.modelDao = modelDao;
        initController();
    }
    
    private void initController() {
        this.view.setController(this);
        this.view.initView();
    }
    
    public void venderVeiculo() {
        try {
            List<Veiculo> veiculo = view.getVenderVeiculoView();
            modelDao.alterarEstado(veiculo);
            view.listaAtualizadaView(veiculo);
            info.apresentaInfo("Veiculo vendido com sucesso.");
        } catch(Exception ex) {
            info.apresentaErro("Erro ao vender veiculo.");
        }
    }
    
    public void filtrarVeiculo() {
        try {
            String tipo = view.getTipoView();
            String marca = view.getMarcaView();
            String categoria = view.getCategoriaView();
            List<Object> lista = this.modelDao.getLista(); 
            
            veiculos = filtrarTipo(veiculos, tipo);
            veiculos = filtrarMarca(veiculos, marca);
            veiculos = filtrarCategoria(veiculos, categoria);
            view.listaPesquisaView(veiculos);
        } catch(Exception ex) {
            info.apresentaErro("Erro ao filtrar veiculos");
        }
    }
    
    public List<Veiculo> filtrarTipo(List<Veiculo> veiculo, String tipo) {
        try {
            List<Veiculo> lista = new ArrayList<>();
            for(Veiculo vc : veiculo) {
                switch (tipo) {
                    case "AUTOMOVEL" -> {
                        if(vc instanceof Automovel) {
                            lista.add(vc);
                        }
                    }
                    case "MOTOCICLETA" -> {
                        if(vc instanceof Motocicleta) {
                            lista.add(vc);
                        }
                    }
                    case "VAN" -> {
                        if(vc instanceof Van) {
                            lista.add(vc);
                        }
                    }
                    default -> {
                        return veiculo;
                    }
                }
            }
            return lista;
        } catch(Exception ex) {
            info.apresentaErro("Erro ao filtrar tipo");
        }
        return null;
    }
    
    public List<Veiculo> filtrarMarca(List<Veiculo> veiculo, String marca) {
        try {
            if(marca.equals("None")) {
                return veiculo;
            } else {
                List<Veiculo> lista = new ArrayList<>();
                for(Veiculo vc : veiculo) {
                    if(vc.getMarca().toString().equals(marca)) {
                        lista.add(vc);
                    }
                }
                return lista;
            }
        } catch(Exception ex) {
            info.apresentaErro("Erro ao filtrar marca.");
        }
        return null;
    }
    
    public List<Veiculo> filtrarCategoria(List<Veiculo> veiculo, String categoria) {
        try {
            if(categoria.equals("None")) {
                return veiculo;
            } else {
                List<Veiculo> lista = new ArrayList<>();
                for(Veiculo vc : veiculo) {
                    if(vc.getCategoria().toString().equals(categoria)) {
                        lista.add(vc);
                    }
                }
                return lista;
            }
        } catch(Exception ex) {
            info.apresentaErro("Erro ao filtrar categoria.");
        }
        return null;
    }
}
