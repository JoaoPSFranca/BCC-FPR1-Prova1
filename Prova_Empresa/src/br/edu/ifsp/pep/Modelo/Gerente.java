package br.edu.ifsp.pep.Modelo;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@DiscriminatorValue("GERENTE")
@NamedQueries(value = {
    @NamedQuery(name = "Gerente.AtualizarSalario", query = "update Gerente g set g.salarioTotal = g.salarioTotal * :percent")
})
public class Gerente extends Funcionario{
    @Column(name = "percentual")
    private double percentual;
    
    @Column(name = "total_vendas")
    private double totalVendas;
    
    @Column(name = "salario_total")
    private double salarioTotal;

    public Gerente() {
    }

    public Gerente(double percentual, double totalVendas, int codigo, String nome, String login, String senha) {
        super(codigo, nome, login, senha);
        this.percentual = percentual;
        this.totalVendas = totalVendas;
        this.salarioTotal = totalVendas * percentual;
    }

    public double getPercentual() {
        return percentual;
    }

    public void setPercentual(double percentual) {
        this.percentual = percentual;
    }

    public double getTotalVendas() {
        return totalVendas;
    }

    public void setTotalVendas(double totalVendas) {
        this.totalVendas = totalVendas;
    }

    public double getSalarioTotal() {
        return salarioTotal;
    }

    public void setSalarioTotal(double salarioTotal) {
        this.salarioTotal = salarioTotal;
    }
}
