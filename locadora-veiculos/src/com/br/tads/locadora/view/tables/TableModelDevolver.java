/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.br.tads.locadora.view.tables;

import com.br.tads.locadora.model.Automovel;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author paula
 */
public class TableModelDevolver extends AbstractTableModel {

    private List<Automovel> veiculos;
    private String[] columns = {"Cliente", "Placa", "Marca", "Modelo", "Ano", "Data locação", "Preço diária", "Quantidade de dias locado", "Valor Locação"};

    public TableModelDevolver() {
        this.veiculos = new ArrayList<>();
    }

    @Override
    public int getRowCount() {
        return this.veiculos.size();
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
        Automovel veiculo = this.veiculos.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return veiculo.getLocacao().getCliente().getNome();
            case 1:
                return veiculo.getPlaca();
            case 2:
                return veiculo.getMarca();
            case 3:
                return veiculo.getModelo();
            case 4:
                return veiculo.getAno();
            case 5:
                return veiculo.getLocacao().getData();
            case 6:
                return veiculo.getLocacao().getValor();
            case 7:
                return veiculo.getLocacao().getDias();
            case 8:
                return veiculo.getLocacao().getValor() * veiculo.getLocacao().getDias();
            default:
                return null;
        }
    }

    public void setListaAutomoveis(List<Automovel> automovel) {
        this.veiculos = automovel;
        this.fireTableDataChanged();
    }

    void adicionaAutomovel(Automovel veiculo) {
        this.veiculos.add(veiculo);
        this.fireTableRowsInserted(veiculos.size() - 1, veiculos.size() - 1);//update JTable
    }

    Automovel getAutomovel(int linha) {
        return veiculos.get(linha);
    }

    public boolean removeAutomovel(Automovel automovelParaExcluir) {
        int linha = this.veiculos.indexOf(automovelParaExcluir);
        boolean result = this.veiculos.remove(automovelParaExcluir);
        this.fireTableRowsDeleted(linha, linha);//update JTable
        return result;
    }

}
