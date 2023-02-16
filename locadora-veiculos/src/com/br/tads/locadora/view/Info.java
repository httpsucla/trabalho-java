/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.br.tads.locadora.view;

import javax.swing.JOptionPane;

/**
 *
 * @author paula
 */
public class Info {
    public void apresentaInfo(String info) {
        JOptionPane.showMessageDialog(null,info + "\n", "Informação", JOptionPane.INFORMATION_MESSAGE);
    }
    public void apresentaErro(String erro) {
        JOptionPane.showMessageDialog(null,erro + "\n", "Erro", JOptionPane.ERROR_MESSAGE);
    }
}
