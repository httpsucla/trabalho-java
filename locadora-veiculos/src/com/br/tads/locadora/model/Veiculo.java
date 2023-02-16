/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.br.tads.locadora.model;

import com.br.tads.locadora.model.enums.Categoria;
import com.br.tads.locadora.model.enums.Estado;
import com.br.tads.locadora.model.enums.Marca;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author paula
 */
public abstract class Veiculo implements VeiculoI {

    Marca marca;
    Estado estado;
    Locacao locacao;
    Categoria categoria;
    private double valorDeCompra;
    private String placa;
    private int ano;

    public Veiculo() {

    }

    public Veiculo(Marca marca, Estado estado, Locacao locacao, Categoria categoria, double valorDeCompra, String placa, int ano) {
        this.marca = marca;
        this.estado = estado;
        this.locacao = locacao;
        this.categoria = categoria;
        this.valorDeCompra = valorDeCompra;
        this.placa = placa;
        this.ano = ano;
    }

    public void locar(int dias, Object data, Cliente cliente) {
        this.estado = Estado.VENDIDO;
    }

    @Override
    public void vender() {
        this.estado = Estado.DISPONIVEL;
    }

    @Override
    public void devolver() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Estado getEstado() {
        return estado;
    }

    @Override
    public Marca getMarca() {
        return marca;
    }

    @Override
    public Categoria getCategoria() {
        return categoria;
    }

    @Override
    public Locacao getLocacao() {
        return locacao;
    }

    @Override
    public String getPlaca() {
        return placa;
    }

    @Override
    public int getAno() {
        return ano;
    }

    @Override
    public double getValorParaVenda() {
        Calendar  calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        int anoAtual = calendar.get(Calendar.YEAR);
        
        int idadeVeiculoEmAnos = anoAtual - ano;

        double valorParaVenda = valorDeCompra - (idadeVeiculoEmAnos * .15 * valorDeCompra);
        
        if(valorParaVenda < valorDeCompra* .1){
            valorParaVenda = valorDeCompra* .1;
        }
        
        return valorParaVenda;
    }

    ;

    @Override
    public abstract double getValorDiariaLocacao();

    @Override
    public void locar(int dias, Calendar data, Cliente cliente) {
        this.estado = Estado.LOCADO;

        Locacao loca = new Locacao(dias, this.getValorDiariaLocacao(), data, cliente);

        this.locacao = loca;

    }

}
