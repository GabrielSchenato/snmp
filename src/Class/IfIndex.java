/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

/**
 *
 * @author gabri
 */
public class IfIndex {
    
    private int index;
    private String nome;
    
    public IfIndex(int index, String nome) {
        this.index = index;
        this.nome = nome;
    }
    
    public int getIndex() {
        return index;
    }
    
    public void setIndex(int index) {
        this.index = index;
    }
    
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    @Override
    public String toString() {
        return this.index + " - " + this.nome;
    }
    
}
