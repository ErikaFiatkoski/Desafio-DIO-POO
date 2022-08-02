import br.com.dio.desafio.dominio.*;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        Curso curso1 = new Curso();
        curso1.setTitulo("curso Java");
        curso1.setDescricao("descrição curso Java");
        curso1.setCargaHoraria(8);

        Curso curso2 = new Curso();
        curso2.setTitulo("curso JavaScript");
        curso2.setDescricao("descrição curso JavaScript");
        curso2.setCargaHoraria(4);


        Mentoria mentoria1 = new Mentoria();
        mentoria1.setTitulo("Mentoria de Java");
        mentoria1.setDescricao("Descrição mentoria Java");
        mentoria1.setData(LocalDate.now());

      /*  System.out.println(curso1);
        System.out.println(curso2);
        System.out.println(mentoria1); */


        Bootcamp bootcamp1 = new Bootcamp();
        bootcamp1.setNome("Bootcamp Java Developer");
        bootcamp1.setDescricao("Descricao Bootcamp Java Developer");
        bootcamp1.getConteudos().add(curso1);
        bootcamp1.getConteudos().add(curso2);
        bootcamp1.getConteudos().add(mentoria1);

        Dev devEkari = new Dev();
        devEkari.setNome("Ekari");

        Dev devAstolfo = new Dev();
        devAstolfo.setNome("Astolfo");


        devEkari.inscreverBootcamp(bootcamp1);
        devAstolfo.inscreverBootcamp(bootcamp1);

        System.out.println("Conteudos Incritos Ekari: " + devEkari.getConteudosInscritos());
        devEkari.progredir();
        devEkari.progredir();
        System.out.println("----");
        System.out.println("Conteudos Incritos Ekari: " + devEkari.getConteudosInscritos());
        System.out.println("Conteudos concluidos Ekari: " + devEkari.getConteudosConcluidos());
        System.out.println("XP Ekari: " + devEkari.calcularXp());

        System.out.println("-----------------------");

        System.out.println("Conteudos Incritos Astolfo: " + devAstolfo.getConteudosInscritos());
        devAstolfo.progredir();
        devAstolfo.progredir();
        devAstolfo.progredir();
        System.out.println("----");
        System.out.println("Conteudos Incritos Astolfo: " + devAstolfo.getConteudosInscritos());
        System.out.println("Conteudos concluidos Astolfo: " + devAstolfo.getConteudosConcluidos());
        System.out.println("XP Astolfo: " + devAstolfo.calcularXp());

    }
}
