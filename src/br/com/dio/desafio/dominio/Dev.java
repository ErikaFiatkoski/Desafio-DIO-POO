package br.com.dio.desafio.dominio;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class Dev {
    private String nome;
    private Set<Conteudo> conteudosInscritos = new LinkedHashSet<>();
    private Set<Conteudo> conteudosConcluidos = new LinkedHashSet<>();

    public void inscreverBootcamp(Bootcamp bootcamp){
        this.conteudosInscritos.addAll(bootcamp.getConteudos()); //O addAll pega tudo que está dentro do set "bootcamp.getConteudos" e add dentro de conteudosInscritos;
        bootcamp.getDevsInscritos().add(this); //adiciona o dev a lista de devs matriculados no bootcamp.

    } //Quando o Dev se inscrever no Bootcamp,
    // automaticamente ele já terá conteudos inscritos.

    public void progredir(){
        Optional<Conteudo> conteudo = this.conteudosInscritos.stream().findFirst(); // stream().findFirst() pega o conteudo pela ordem apresentada, independente de ser curso ou mentoria.
        //O optional resolve a questão de a lista estar vazia.
        if (conteudo.isPresent()){
            this.conteudosConcluidos.add(conteudo.get());
            this.conteudosInscritos.remove(conteudo.get());
        } else {
            System.err.println("Você não está matriculado em nenhum conteudo");
        }

    } //A medida que for progredindo no Bootcamp,
    //automaticamente terá conteudos concluidos.


    public double calcularXp(){
        return this.conteudosConcluidos.stream().mapToDouble(Conteudo::calcularXp).sum(); //pega o xp de cada conteudo concluido e soma.
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Conteudo> getConteudosInscritos() {
        return conteudosInscritos;
    }

    public void setConteudosInscritos(Set<Conteudo> conteudosInscritos) {
        this.conteudosInscritos = conteudosInscritos;
    }

    public Set<Conteudo> getConteudosConcluidos() {
        return conteudosConcluidos;
    }

    public void setConteudosConcluidos(Set<Conteudo> conteudosConcluidos) {
        this.conteudosConcluidos = conteudosConcluidos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dev dev = (Dev) o;
        return Objects.equals(nome, dev.nome) && Objects.equals(conteudosInscritos, dev.conteudosInscritos) && Objects.equals(conteudosConcluidos, dev.conteudosConcluidos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, conteudosInscritos, conteudosConcluidos);
    }
}
