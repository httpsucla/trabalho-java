/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.br.tads.locadora.view.tables;

import com.br.tads.locadora.model.Automovel;
import com.br.tads.locadora.model.Cliente;
import com.br.tads.locadora.model.Veiculo;
import com.br.tads.locadora.view.TabbedView;
import java.util.List;

/**
 *
 * @author nilo-
 */
public class VenderTableView extends javax.swing.JPanel {
    private TableModelVender modeloTabela = new TableModelVender();
    private TabbedView janela;
    private int linhaClicadaParaAtualizacao = -1;

    /**
     * Creates new form ClienteTableView
     */
    public VenderTableView() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        jTable1.setModel(modeloTabela);
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

    public void setJanelaView(TabbedView janela) {
        this.janela = janela;
    }

    public void inserirVeiculoTabela(Automovel automovel) {
        modeloTabela.adicionaAutomovel(automovel);
    }

    public void setListaVeiculosTabela(List<Automovel> lista) {
        modeloTabela.setListaAutomoveis(lista);
    }

    public Veiculo getVeiculoParaExcluirDaTabela() {
        int linhasSelecionada = this.jTable1.getSelectedRow();
        Veiculo contato = modeloTabela.getAutomovel(linhasSelecionada);
        return contato;
    }

    public void excluirVeiculoDaTabela(Automovel veiculoParaExcluir) {
        modeloTabela.removeAutomovel(veiculoParaExcluir);
    }

    public void atualizarVeiculoNaTabela(Veiculo cliente) {

        modeloTabela.fireTableRowsUpdated(linhaClicadaParaAtualizacao, linhaClicadaParaAtualizacao);

    }
}
