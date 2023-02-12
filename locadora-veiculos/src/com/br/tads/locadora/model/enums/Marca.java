/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package com.br.tads.locadora.model.enums;

/**
 *
 * @author paula
 */
public enum Marca {
    
    VW("VW"),
    GM("GM"),
    Fiat("Fiat"),
    Honda("Honda"),
    Mercedes("Mercedes");
    
    private String descricao;
    
    Marca(String descricao) {
        this.descricao = descricao;
        
    }
    
    public String getDescricao() {
        return descricao;
    }
    
}
