package br.edu.ifsp.pep.Modelo;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@DiscriminatorValue("ASSALARIADO")
@NamedQueries(value = {
    @NamedQuery(name = "Assalariado.AtualizarSalario", query = "update Assalariado a set a.salarioFixo = a.salarioFixo * :percent"),
    @NamedQuery(name = "Assalariado.BuscarSalario", query = "SELECT a FROM Assalariado a WHERE a.salarioFixo > 10000")
})
public class Assalariado extends Funcionario {
    @Column(name = "salarioFixo")
    private double salarioFixo;

    public Assalariado() {
    }

    public Assalariado(double salarioFixo, int codigo, String nome, String login, String senha) {
        super(codigo, nome, login, senha);
        this.salarioFixo = salarioFixo;
    }
    
    public double getSalarioFixo() {
        return salarioFixo;
    }

    public void setSalarioFixo(double salarioFixo) {
        this.salarioFixo = salarioFixo;
    }
}
