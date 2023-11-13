package br.avaliacao.model.service;

import br.avaliacao.model.model.Jogo;
import br.avaliacao.model.repository.JogoRepository;
import sun.plugin2.message.Message;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.util.List;

/**
 * Created by cdelfino on 13/11/2023.
 */

@Stateless
public class JogoService {



    @EJB
    private JogoRepository jogoRepository;


    public void create(Jogo jogo){
        String target = jogo.getNome().substring(0,4).toUpperCase();
        if("MORT".equals(target)){
            System.out.println("LETRA INICIAL NÃO PERMITIDA");
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, "LETRA INICIAL NÃO PERMITIDA: "+ target, "INICIAL NÃO PERMITIDA");

            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, facesMessage);
        }else{
            jogoRepository.persist(jogo);
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "adicionado com sucesso: ", "adicionado");

            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, facesMessage);
        }
    }

    // testando outro create com update
    public void salvar(Jogo jogo){
        jogoRepository.salvar(jogo);
    }

    public List<Jogo> listarTodos(){
        return jogoRepository.buscarTodos("select j from Jogo j order by j.nome ");
    }

    public void remover(Jogo jogo){
        jogoRepository.remover(jogo);
    }

    public void remove(Jogo jogo){
        jogoRepository.remove(jogo);
    }



}
