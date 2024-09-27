package br.edu.ifsp.pep;

import br.edu.ifsp.pep.Modelo.Assalariado;
import br.edu.ifsp.pep.Modelo.Comissionado;
import br.edu.ifsp.pep.Modelo.Funcionario;
import br.edu.ifsp.pep.Modelo.Gerente;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

public class Principal {
    private static EntityManagerFactory enf = Persistence.createEntityManagerFactory("ConexaoPU");
    
    public static void main(String[] args) {
        Assalariado assalariado = new Assalariado(2000, 1, "Luana", "Killuax", "killuax123");
        Assalariado assalariado2 = new Assalariado(8000, 2, "Guilherme", "vongui", "gui123");
        Assalariado assalariado3 = new Assalariado(12000, 3, "Gabriel", "Biel", "bi123");
        Assalariado assalariado4 = new Assalariado(15000, 4, "Leo", "lzim", "lzim123");
        Comissionado comissionado = new Comissionado(300, 100, 5, "Karina", "nina", "nina123");
        Gerente gerente = new Gerente(10, 2000, 6, "Larissa", "i.ass.irl", "lari123");
        
        adicionar(assalariado);
        adicionar(assalariado2);
        adicionar(assalariado3);
        adicionar(assalariado4);
        adicionar(comissionado);
        adicionar(gerente);
        
        ReajustarSalario(0.10);
        
        BuscarAssalariado();
        
        MostrarTodasClasses();
    }
      
    private static void adicionar(Assalariado a){
        EntityManager em = enf.createEntityManager();
        
        em.getTransaction().begin();
        em.persist(a);
        em.getTransaction().commit();
        em.close();
    }
    
    private static void adicionar(Comissionado c){
        EntityManager em = enf.createEntityManager();
        
        em.getTransaction().begin();
        em.persist(c);
        em.getTransaction().commit();
        em.close();
    } 
    
    private static void adicionar(Gerente g){
        EntityManager em = enf.createEntityManager();
        
        em.getTransaction().begin();
        em.persist(g);
        em.getTransaction().commit();
        em.close();
    } 
    
    private static void ReajustarSalario(double percent) {
        EntityManager em = enf.createEntityManager();
        
        percent = percent + 1;
        
        em.getTransaction().begin();
        Query query = em.createNamedQuery("Comissionado.AtualizarSalario");
        query.setParameter("percent", percent);
        em.getTransaction().commit();
        
        em.getTransaction().begin();
        query = em.createNamedQuery("Comissionado.AtualizarSalario");
        query.setParameter("percent", percent);
        em.getTransaction().commit();
        
        em.getTransaction().begin();
        query = em.createNamedQuery("Comissionado.AtualizarSalario");
        query.setParameter("percent", percent);
        em.getTransaction().commit();
        
        em.getTransaction().begin();
        query = em.createNamedQuery("Comissionado.AtualizarSalario");
        query.setParameter("percent", percent);
        em.getTransaction().commit();
        em.close(); 
    }

    private static void BuscarAssalariado(){
        EntityManager em = enf.createEntityManager();
        
        TypedQuery<Assalariado> query = em.createNamedQuery("Assalariado.BuscarSalario", Assalariado.class);
        List<Assalariado> resultList = query.getResultList();

        System.out.println("\nAssalariados Maior que 10.000: ");
        if (resultList != null) {
            for (Assalariado a : resultList) {
                System.out.println("Nome: " + a.getNome());
            }
        }
        em.close();
    }

    private static void MostrarTodasClasses(){
        EntityManager em = enf.createEntityManager();
        
        System.out.println("\nTodas as Classes: ");
        TypedQuery<Object> tudo = em.createNamedQuery("Funcionario.SelectAll", Object.class);
        List<Object> result = tudo.getResultList();
        
        for (Object o : result) {
            if(o instanceof Assalariado a){
                System.out.println("Nome: " + a.getNome());
                System.out.println("Login: " + a.getLogin());
                System.out.println("Senha: " + a.getSenha());
                System.out.println("Salario: " + a.getSalarioFixo());
            }
            if(o instanceof Gerente g){
                System.out.println("Nome: " + g.getNome());
                System.out.println("Login: " + g.getLogin());
                System.out.println("Senha: " + g.getSenha());
                System.out.println("Salario: " + g.getSalarioTotal());
            }
            if(o instanceof Comissionado c){
                System.out.println("Nome: " + c.getNome());
                System.out.println("Login: " + c.getLogin());
                System.out.println("Senha: " + c.getSenha());
                System.out.println("Salario: " + c.getSalarioTotal());
            }
        }
    }
}
