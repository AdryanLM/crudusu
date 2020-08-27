/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ulbra.model;

/**
 *
 * @author s.lucas
 */
public class gato {
    private int idGato;
    private String nomeGato;
    private String generoGato;
    private String racaGato;
    private String nascimentoGato;
    private double tamanhoGato;
    private boolean vacinadoGato;
    private String corGato;
    private double pesoGato;
    private boolean microchipGato;
    private String descricaoGato;

    public gato() {
    }

    
    
    public gato(int idGato, String nomeGato, String generoGato, String racaGato, String nascimentoGato, double tamanhoGato, boolean vacinadoGato, String corGato, double pesoGato, boolean microchipGato, String descricaoGato) {
        this.idGato = idGato;
        this.nomeGato = nomeGato;
        this.generoGato = generoGato;
        this.racaGato = racaGato;
        this.nascimentoGato = nascimentoGato;
        this.tamanhoGato = tamanhoGato;
        this.vacinadoGato = vacinadoGato;
        this.corGato = corGato;
        this.pesoGato = pesoGato;
        this.microchipGato = microchipGato;
        this.descricaoGato = descricaoGato;
    }

    public int getIdGato() {
        return idGato;
    }

    public void setIdGato(int idGato) {
        this.idGato = idGato;
    }

    public String getNomeGato() {
        return nomeGato;
    }

    public void setNomeGato(String nomeGato) {
        this.nomeGato = nomeGato;
    }

    public String getGeneroGato() {
        return generoGato;
    }

    public void setGeneroGato(String generoGato) {
        this.generoGato = generoGato;
    }

    public String getRacaGato() {
        return racaGato;
    }

    public void setRacaGato(String racaGato) {
        this.racaGato = racaGato;
    }

    public String getNascimentoGato() {
        return nascimentoGato;
    }

    public void setNascimentoGato(String nascimentoGato) {
        this.nascimentoGato = nascimentoGato;
    }

    public double getTamanhoGato() {
        return tamanhoGato;
    }

    public void setTamanhoGato(double tamanhoGato) {
        this.tamanhoGato = tamanhoGato;
    }

    public boolean isVacinadoGato() {
        return vacinadoGato;
    }

    public void setVacinadoGato(boolean vacinadoGato) {
        this.vacinadoGato = vacinadoGato;
    }

    public String getCorGato() {
        return corGato;
    }

    public void setCorGato(String corGato) {
        this.corGato = corGato;
    }

    public double getPesoGato() {
        return pesoGato;
    }

    public void setPesoGato(double pesoGato) {
        this.pesoGato = pesoGato;
    }

    public boolean isMicrochipGato() {
        return microchipGato;
    }

    public void setMicrochipGato(boolean microchipGato) {
        this.microchipGato = microchipGato;
    }

    public String getDescricaoGato() {
        return descricaoGato;
    }

    public void setDescricaoGato(String descricaoGato) {
        this.descricaoGato = descricaoGato;
    }

    @Override
    public String toString() {
        return "gato{" + "idGato=" + idGato + ", nomeGato=" + nomeGato + ", generoGato=" + generoGato + ", racaGato=" + racaGato + ", nascimentoGato=" + nascimentoGato + ", tamanhoGato=" + tamanhoGato + ", vacinadoGato=" + vacinadoGato + ", corGato=" + corGato + ", pesoGato=" + pesoGato + ", microchipGato=" + microchipGato + ", descricaoGato=" + descricaoGato + '}';
    }
    
    
}
