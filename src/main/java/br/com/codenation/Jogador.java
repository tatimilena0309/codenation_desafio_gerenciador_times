package br.com.codenation;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Jogador {

    private Long id;                        //* Identificador do Jogador
    private Long idTime;                    //* Identificador do time
    private String nome;                    //* Nome do Jogador
    private LocalDate dataNascimento;       //* Data de nascimento do Jogador
    private Integer nivelHabilidade;        //* Nível de habilidade do jogador (0 a 100)
    private BigDecimal salario;             //* Salário do jogador


    public Jogador(Long id, Long idTime, String nome, LocalDate dataNascimento, Integer nivelHabilidade, BigDecimal salario) {
        this.setId(id);
        this.setIdTime(idTime);
        this.setNome(nome);
        this.setDataNascimento(dataNascimento);
        this.setNivelHabilidade(nivelHabilidade);
        this.setSalario(salario);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        if(id == null){
            throw new NullPointerException();}

        if (id < 0){
            throw new IllegalArgumentException();}

        this.id = id;
    }

    public Long getIdTime() {
        return idTime;
    }

    public void setIdTime(Long idTime) {
        this.idTime = idTime;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Integer getNivelHabilidade() {
        return nivelHabilidade;
    }

    public void setNivelHabilidade(Integer nivelHabilidade) {
        this.nivelHabilidade = nivelHabilidade;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

}
