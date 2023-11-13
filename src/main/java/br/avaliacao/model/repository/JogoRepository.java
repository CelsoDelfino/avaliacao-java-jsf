package br.avaliacao.model.repository;

import br.avaliacao.model.model.Jogo;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class JogoRepository {

    @PersistenceContext
    private EntityManager em;

    //OK
    public void persist(Jogo jogo){
        em.persist(jogo);
    }

    public void salvar(Jogo jogo){
            if(jogo.getId() == null){
                em.persist(jogo);
            }else{
                em.merge(jogo);
            }
    }

    //OK
    public List<Jogo> buscarTodos(String jpql){
        Query  query = em.createQuery(jpql);
        return query.getResultList();
    }

    public void remover(Jogo jogo){
        Query query = em.createQuery("delete from Jogo j where j.id = :id");
        query.setParameter("id",jogo.getId());
        query.executeUpdate();
    }

    public void remove(Jogo jogo){
        em.remove(jogo);
    }



}
