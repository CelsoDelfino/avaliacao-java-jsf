package br.avaliacao.model.controller;

import br.avaliacao.model.model.Jogo;
import br.avaliacao.model.repository.JogoRepository;
import br.avaliacao.model.service.JogoService;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named("bean")
@RequestScoped
public class JogoMB {

    @Inject
    private JogoService service;

    @Inject
    private JogoRepository jogoRepository;

    private List<Jogo> jogos;

    @Inject
    Jogo jogo;

    public String inserir(){
        service.create(jogo);
        limpar();
        listar();
        return "";
    }

    public void adicionar(){
        service.salvar(this.jogo);
        System.out.println(jogo.getId() + "" + jogo.getNome() + "" + jogo.getEmpresa() + "" + jogo.getCategoria() + "" + jogo.getPreco());
    }

    public void excluir(){
        service.remover(this.jogo);
        listar();
    }

    public void exclui(Jogo jogoDB){
        jogoRepository.remove(jogoDB);
    }




    public void limpar(){
        this.jogo = new Jogo();
    }

    @PostConstruct
    public void listar(){
        jogos = service.listarTodos();
    }


    public Jogo getJogo() {
        return jogo;
    }

    public void setJogo(Jogo jogo) {
        this.jogo = jogo;
    }

    public List<Jogo> getJogos() {
        return jogos;
    }

}
