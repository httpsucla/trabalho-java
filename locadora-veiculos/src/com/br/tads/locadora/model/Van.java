/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.br.tads.locadora.model;

import com.br.tads.locadora.model.enums.Categoria;
import com.br.tads.locadora.model.enums.Estado;
import com.br.tads.locadora.model.enums.Marca;
import com.br.tads.locadora.model.enums.ModeloVan;


/**
 *
 * @author paula
 */
public class Van extends Veiculo {

    private ModeloVan van;

    private Van(ModeloVan van, Marca marca, Locacao locacao, Estado estado, Categoria categoria, double valorDeCompra, String placa, int ano) {
       super(marca, estado, locacao, categoria, valorDeCompra, placa, ano);
        this.van = van;
    }
    
    public ModeloVan getModelo() {
        return van;
    } 
    
    public void setModelo(ModeloVan van) {
        this.van = van;
    }
    
    @Override
    public double getValorDiariaLocacao() {
        
        Categoria c = this.categoria;
        double valorDiaria;
        
        switch(c) {
            case POPULAR -> {
                valorDiaria = 200.0;
                return valorDiaria;
            }
            case INTERMEDIARIO -> {
                valorDiaria = 400.0;
                return valorDiaria;
            }
            case LUXO -> {
                valorDiaria = 600.0;
                return valorDiaria;
            }
                
        }
        return 0;
        
    }
    
}
