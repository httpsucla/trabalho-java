/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.br.tads.locadora.controller;

import com.br.tads.locadora.model.Cliente;
import com.br.tads.locadora.view.ClienteComponent;
import com.br.tads.locadora.view.Info;
import java.util.List;
import locadora.model.dao.ClienteDao;

/**
 *
 * @author paula
 */
public class ClienteController {

    private ClienteComponent view;
    private Info info;
    private ClienteDao modelDao;

    public ClienteController(ClienteComponent view) {
        this.view = view;
        initController();
    }

    private void initController() {
        this.view.setController(this);
        this.view.initView();
    }

    public void inserirCliente() {
        try {
            Cliente cliente = view.getClienteFormulario();
            modelDao.inserir(cliente);
            view.inserirClienteView(cliente);
            info.apresentaInfo("Adicionado com sucesso.");
        } catch (Exception ex) {
            info.apresentaErro("Erro ao criar contato.");
        }
    }

    public void atualizarCliente() {
        try {
            Cliente cliente = view.getClienteAtualizar();
            if (cliente == null) {
                info.apresentaInfo("Selecione um cliente na tabela para atualizar.");
                return;
            }
            modelDao.atualizar(cliente);
            view.atualizarContato(cliente);
        } catch (Exception ex) {
            info.apresentaErro("Erro ao atualizar cliente.");
        }
    }

    public void excluirCliente() {
        try {
            List<Cliente> excluirCliente = view.getClienteExcluir();
           // modelDao.remover(0);
            view.excluirClienteView(excluirCliente);
        } catch (Exception ex) {
            info.apresentaErro("Erro ao excluir cliente.");
        }
    }

    public void listarCliente() {
        try {
            view.limparClienteAtualizar();
          //  List<Cliente> lista = this.modelDao.getLista();
          //  view.mostrarListaClientes(lista);
        } catch (Exception ex) {
            ex.printStackTrace();
            info.apresentaErro("Erro ao listar clientes");
        }
    }
}
