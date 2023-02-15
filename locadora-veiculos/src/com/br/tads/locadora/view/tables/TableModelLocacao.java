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
public class TableModelLocacao extends AbstractTableModel{
    private List<Automovel> veiculos;
    private String[] columns = {"Placa", "Marca", "Modelo", "Ano", "Preço Locação"};
    
    public TableModelLocacao() {
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
                return veiculo.getPlaca();//if column 0 (code)
            case 1:
                return veiculo.getMarca();//if column 1 (name)
            case 2:
                return veiculo.getModelo();
            case 3:
                return veiculo.getAno();//if column 2 (birthday)
            case 4:
                return veiculo.getValorDiariaLocacao();
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
        this.fireTableRowsDeleted(linha,linha);//update JTable
        return result;
    }

}
