package br.edu.ifsp.pep.Modelo;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@DiscriminatorValue("COMISSIONADO")
@NamedQueries(value = {
    @NamedQuery(name = "Comissionado.AtualizarSalario", query = "update Comissionado c set c.salarioFixo = c.salarioFixo * :percent")
})
public class Comissionado extends Funcionario {
    @Column(name = "salarioFixo")
    private double salarioFixo;
    
    @Column(name = "comissao")
    private double comissao;
    
    @Column(name = "salario_total")
    private double salarioTotal;

    public Comissionado() {
    }

    public Comissionado(double salarioFixo, double comissao, int codigo, String nome, String login, String senha) {
        super(codigo, nome, login, senha);
        this.salarioFixo = salarioFixo;
        this.comissao = comissao;
        this.salarioTotal = comissao + salarioFixo;
    }

    public double getSalarioFixo() {
        return salarioFixo;
    }

    public void setSalarioFixo(double salarioFixo) {
        this.salarioFixo = salarioFixo;
    }

    public double getComissao() {
        return comissao;
    }

    public void setComissao(double comissao) {
        this.comissao = comissao;
    }

    public double getSalarioTotal() {
        return salarioTotal;
    }

    public void setSalarioTotal(double salarioTotal) {
        this.salarioTotal = salarioTotal;
    }
}
