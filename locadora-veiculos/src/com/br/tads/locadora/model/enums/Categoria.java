/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package com.br.tads.locadora.model.enums;

/**
 *
 * @author paula
 */
public enum Categoria {
    
    POPULAR("POPULAR"),
    INTERMEDIARIO("INTERMEDIARIO"),
    LUXO("LUXO");
    
    private String descricao;
    
    Categoria(String descricao) {
        this.descricao = descricao;
    }
    
    public String getDescricao() {
        return descricao;
    }
}
