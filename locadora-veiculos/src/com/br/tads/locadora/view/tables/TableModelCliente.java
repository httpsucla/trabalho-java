/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.br.tads.locadora.view.tables;

import com.br.tads.locadora.model.Cliente;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author paula
 */
public class TableModelCliente extends AbstractTableModel {

    private List<Cliente> clientes;
    private String[] columns = {"Nome", "Sobrenome", "RG", "CPF", "Endereco"};

    public TableModelCliente() {
        clientes = new ArrayList<>();
    }

    @Override
    public int getRowCount() {
        return this.clientes.size();
    }

    @Override
    public int getColumnCount() {
        return this.columns.length;
    }

    @Override
    public String getColumnName(int column) {
        return this.columns[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Cliente customer = this.clientes.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return customer.getNome();//if column 0 (code)
            case 1:
                return customer.getSobrenome();//if column 1 (name)
            case 2:
                return customer.getRg();
            case 3:
                return customer.getCpf();//if column 2 (birthday)
            case 4:
                return customer.getEndereco();
            default:
                return null;
        }
    }

    public void setListaClientes(List<Cliente> clientes) {
        this.clientes = clientes;
        this.fireTableDataChanged();
    }

    void adicionaCliente(Cliente cliente) {
        this.clientes.add(cliente);
        this.fireTableRowsInserted(clientes.size() - 1, clientes.size() - 1);//update JTable
    }

    Cliente getCliente(int linha) {
         return clientes.get(linha);
    }

    public boolean removeCliente(Cliente clienteParaExcluir) {
        int linha = this.clientes.indexOf(clienteParaExcluir);
        boolean result = this.clientes.remove(clienteParaExcluir);
        this.fireTableRowsDeleted(linha,linha);//update JTable
        return result;
    }

}
