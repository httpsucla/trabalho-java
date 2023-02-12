/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.br.tads.locadora.model;

import com.br.tads.locadora.model.enums.Categoria;
import com.br.tads.locadora.model.enums.Estado;
import com.br.tads.locadora.model.enums.Marca;
import com.br.tads.locadora.model.enums.ModeloAutomovel;

/**
 *
 * @author paula
 */
public class Automovel extends Veiculo{
    

    private ModeloAutomovel automovel;
 
    
    public Automovel(ModeloAutomovel automovel, Marca marca, Estado estado, Categoria categoria, double valorDeCompra, String placa, int ano) {
        /*super(
        marca,
        estado,
        categoria,
        valorDeCompra,
        placa,
        ano);*/
        this.automovel = automovel;
    }
    
    public ModeloAutomovel getModelo() {
        return automovel;
    }
    
    public void setModelo(ModeloAutomovel automovel) {
        this.automovel = automovel;
    }
    
    @Override
    public double getValorDiariaLocacao() {
        
        Categoria c = this.categoria;
        double valorDiaria;
        
        switch(c) {
            case POPULAR -> {
                valorDiaria = 100.0;
                return valorDiaria;
            }
            case INTERMEDIARIO -> {
                valorDiaria = 300.0;
                return valorDiaria;
            }
            case LUXO -> {
                valorDiaria = 450.0;
                return valorDiaria;
            }
                
        }
        return 0;
        
    } 
}
