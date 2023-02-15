/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.br.tads.locadora.model;

import com.br.tads.locadora.model.enums.Categoria;
import com.br.tads.locadora.model.enums.Estado;
import com.br.tads.locadora.model.enums.Marca;
import com.br.tads.locadora.model.enums.ModeloMotocicleta;

/**
 *
 * @author paula
 */
public class Motocicleta extends Veiculo {

    private ModeloMotocicleta motocicleta;

    private Motocicleta(ModeloMotocicleta motocicleta, Locacao locacao,Marca marca, Estado estado, Categoria categoria, double valorDeCompra, String placa, int ano) {
        super(marca, estado, locacao, categoria, valorDeCompra, placa, ano);
        this.motocicleta = motocicleta;
    }
    
    public ModeloMotocicleta getModelo() {
        return motocicleta;
    } 
    
    public void setModelo(ModeloMotocicleta motocicleta) {
        this.motocicleta = motocicleta;
    }
    
    @Override
    public double getValorDiariaLocacao() {
        
        Categoria c = this.categoria;
        double valorDiaria;
        
        switch(c) {
            case POPULAR -> {
                valorDiaria = 70.0;
                return valorDiaria;
            }
            case INTERMEDIARIO -> {
                valorDiaria = 200.0;
                return valorDiaria;
            }
            case LUXO -> {
                valorDiaria = 350.0;
                return valorDiaria;
            }
                
        }
        return 0;
        
    }
}
