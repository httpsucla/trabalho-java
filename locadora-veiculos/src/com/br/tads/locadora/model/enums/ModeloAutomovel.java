/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package com.br.tads.locadora.model.enums;

/**
 *
 * @author paula
 */
public enum ModeloAutomovel {
    
    Gol("Gol"),
    Celta("Celta"),
    Palio("Palio");
    
    private String descricao;
    
    ModeloAutomovel(String descricao) {
        this.descricao = descricao;
    }
    
    public String getDescricao() {
        return descricao;
    }
}
