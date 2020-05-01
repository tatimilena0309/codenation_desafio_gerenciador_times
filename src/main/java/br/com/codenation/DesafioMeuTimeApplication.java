package br.com.codenation;

import br.com.codenation.desafio.annotation.Desafio;
import br.com.codenation.desafio.app.MeuTimeInterface;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class DesafioMeuTimeApplication implements MeuTimeInterface {

	private AppManager appManager = new AppManager();

	@Desafio("incluirTime")
	public void incluirTime(Long id, String nome, LocalDate dataCriacao, String corUniformePrincipal, String corUniformeSecundario) {
		Time time = new Time(id,nome,dataCriacao,corUniformePrincipal,corUniformeSecundario);
		appManager.AdicionarTime(time);
	}

	@Desafio("incluirJogador")
	public void incluirJogador(Long id, Long idTime, String nome, LocalDate dataNascimento, Integer nivelHabilidade, BigDecimal salario) {
		Jogador jogador = new Jogador(id,idTime,nome,dataNascimento,nivelHabilidade,salario);
		appManager.AdicionarJogadores(jogador);
	}

	@Desafio("definirCapitao")
	public void definirCapitao(Long idJogador) {
		appManager.DefinirCapitao(idJogador);
	}

	@Desafio("buscarCapitaoDoTime")
	public Long buscarCapitaoDoTime(Long idTime) {
		return appManager.BuscarCapitaoDoTime(idTime);
	}

	@Desafio("buscarNomeJogador")
	public String buscarNomeJogador(Long idJogador) {
		return appManager.buscarNomeJogador(idJogador);
	}

	@Desafio("buscarNomeTime")
	public String buscarNomeTime(Long idTime) {
		return appManager.buscarNomeTime(idTime);
	}

	@Desafio("buscarJogadoresDoTime")
	public List<Long> buscarJogadoresDoTime(Long idTime) {
		return appManager.buscarJogadoresDoTime(idTime);
	}

	@Desafio("buscarMelhorJogadorDoTime")
	public Long buscarMelhorJogadorDoTime(Long idTime) {
		return appManager.buscarMelhorJogadorDoTime(idTime);
	}

	@Desafio("buscarJogadorMaisVelho")
	public Long buscarJogadorMaisVelho(Long idTime) {
		return appManager.buscarJogadorMaisVelho(idTime);
	}

	@Desafio("buscarTimes")
	public List<Long> buscarTimes() {
		return appManager.buscarTimes();
	}

	@Desafio("buscarJogadorMaiorSalario")
	public Long buscarJogadorMaiorSalario(Long idTime) {
		return appManager.buscarJogadorMaiorSalario(idTime);
	}

	@Desafio("buscarSalarioDoJogador")
	public BigDecimal buscarSalarioDoJogador(Long idJogador) {
		return appManager.buscarSalarioDoJogador(idJogador);
	}

	@Desafio("buscarTopJogadores")
	public List<Long> buscarTopJogadores(Integer top) {
		return appManager.buscarTopJogadores(top);

	}

	@Desafio("buscarCorCamisaTimeDeFora")
	public String buscarCorCamisaTimeDeFora(Long timeDaCasa, Long timeDeFora) {
		return appManager.buscarCorCamisaTimeDeFora(timeDaCasa,timeDeFora);
	}

}


