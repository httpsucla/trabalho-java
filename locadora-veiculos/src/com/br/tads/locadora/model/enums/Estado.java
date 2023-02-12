/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package com.br.tads.locadora.model.enums;

/**
 *
 * @author paula
 */
public enum Estado {
    
    NOVO("NOVO"),
    LOCADO("LOCADO"),
    DISPONIVEL("DISPONIVEL"),
    VENDIDO("VENDIDO");
    
    private String descricao;
    
    Estado(String descricao) {
        this.descricao = descricao;
    }
    
    public String getDescricao() {
        return descricao;
    }
}
