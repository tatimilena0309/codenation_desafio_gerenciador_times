package br.com.codenation;

import br.com.codenation.desafio.annotation.Desafio;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface MeuTimeInterface {
    @Desafio("incluirTime")
    public void incluirTime(Long id, String nome, LocalDate dataCriacao, String corUniformePrincipal, String corUniformeSecundario);

    @Desafio("incluirJogador")
    public void incluirJogador(Long id, Long idTime, String nome, LocalDate dataNascimento, Integer nivelHabilidade, BigDecimal salario);

    @Desafio("definirCapitao")
    public void definirCapitao(Long idJogador);

    @Desafio("buscarCapitaoDoTime")
    public Long buscarCapitaoDoTime(Long idTime);

    @Desafio("buscarNomeJogador")
    public String buscarNomeJogador(Long idJogador);

    @Desafio("buscarNomeTime")
    public String buscarNomeTime(Long idTime);

    @Desafio("buscarMaiorSalario")
    public Long buscarJogadorMaiorSalario(Long idTime);

    @Desafio("buscarSalarioDoJogador")
    public BigDecimal buscarSalarioDoJogaodor(Long idJogador);

    @Desafio("buscarJogadoresDoTime")
    public List<Long> buscarJogadoresDoTime(Long idTime);

    @Desafio("buscarMelhorJogadorDoTime")
    public Long buscarMelhorJogadorDoTime(Long idTime);

    @Desafio("buscarJogadorMaisVelho")
    public Long buscarJogadorMaisVelho(Long idTime);

    @Desafio("buscarTimes")
    public List<Long> buscarTimes();

    @Desafio("buscarTopJogadores")
    public List<Long> buscarTopJogadores(Integer top);
}
