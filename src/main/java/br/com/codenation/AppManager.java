package br.com.codenation;

import br.com.codenation.desafio.exceptions.CapitaoNaoInformadoException;
import br.com.codenation.desafio.exceptions.IdentificadorUtilizadoException;
import br.com.codenation.desafio.exceptions.JogadorNaoEncontradoException;
import br.com.codenation.desafio.exceptions.TimeNaoEncontradoException;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

public class AppManager {

    private HashMap<Long, Jogador> jogadores;
    private HashMap<Long, Time> times;

    public AppManager() {
        jogadores = new HashMap<Long, Jogador>();
        times = new HashMap<Long, Time>();
    }

    public HashMap<Long, Jogador> getJogadores() {
        return jogadores;
    }

    public void setJogadores(HashMap<Long, Jogador> jogadores) {
        this.jogadores = jogadores;
    }

    public HashMap<Long, Time> getTimes() {
        return times;
    }

    public void setTimes(HashMap<Long, Time> times) {
        this.times = times;
    }

    public void AdicionarTime(Time time) {

            if (this.getTimes().containsKey(time.getId())) {
                throw new IdentificadorUtilizadoException();
            }
            this.getTimes().put(time.getId(), time);
        }


    public void AdicionarJogadores(Jogador jogador) {

            if (this.getJogadores().containsKey(jogador.getId())) {
                throw new IdentificadorUtilizadoException();
            }
            if (this.getTimes().containsKey(jogador.getIdTime())) {
                this.getJogadores().put(jogador.getId(), jogador);
            } else {
                throw new TimeNaoEncontradoException();
            }
        }

    public void DefinirCapitao(Long idJogador) {

        if (this.getJogadores().containsKey(idJogador)) {
            Jogador jogador = this.getJogadores().get(idJogador.longValue());
            if(this.times.containsKey( jogador.getIdTime())) {
                this.times.get(jogador.getIdTime()).setIdCapitao(idJogador.longValue());
            }
        }else {
            throw new JogadorNaoEncontradoException();
        }
    }

    public Long BuscarCapitaoDoTime(Long idTime) {
        if (this.getTimes().containsKey(idTime)) {
            if(this.getTimes().get(idTime).getIdCapitao() == null){
                throw new CapitaoNaoInformadoException("Capitão não informado");
            }else{
                return this.getTimes().get(idTime).getIdCapitao().longValue();
            }
        }
        else{
            throw new TimeNaoEncontradoException("Time não encontrado");
        }
    }

    public String buscarNomeJogador (Long idJogador) {

        if (this.getJogadores().containsKey(idJogador)) {
            return this.getJogadores().get(idJogador).getNome();
        }
        else{
            throw new JogadorNaoEncontradoException();
        }
    }
    public String buscarNomeTime (Long idTime) {

        if (this.getTimes().containsKey(idTime)) {
            return this.getTimes().get(idTime).getNome();
        }
        else{
            throw new TimeNaoEncontradoException();
        }
    }

    public List<Long> buscarJogadoresDoTime(Long idTime) {

        List<Long> listaIdJogadores = new ArrayList<Long>();
        if (this.getTimes().containsKey(idTime)) {
            this.getJogadores().forEach((k, v) -> {
                if (v.getIdTime().equals(idTime)) {
                    listaIdJogadores.add(v.getId());
                }
            });
        } else{
            throw new TimeNaoEncontradoException();
        }
        Collections.sort(listaIdJogadores);
        return listaIdJogadores;
    }

    public Long buscarMelhorJogadorDoTime(Long idTime) {

        if (this.getTimes().containsKey(idTime)) {
            Optional<Jogador> melhorJogador = this.getJogadores().values().stream()
                    .filter(v -> v.getIdTime().longValue() == (idTime))
                    .sorted(Collections.reverseOrder(Comparator.comparing(Jogador::getNivelHabilidade)).thenComparing(Jogador::getId))
                    .max(Comparator.comparing(Jogador::getNivelHabilidade));

            return melhorJogador.get().getId().longValue();

        } else{
            throw new TimeNaoEncontradoException();
        }
    }
    public Long buscarJogadorMaisVelho(Long idTime) {
        if (this.getTimes().containsKey(idTime)) {
            Optional<Jogador> jogadorMaisVelho = this.getJogadores().values().stream()
                    .filter(v -> v.getIdTime().equals(idTime))
                    .sorted(Collections.reverseOrder(Comparator.comparing(Jogador::getDataNascimento)).thenComparing(Jogador::getId))
                    .min(Comparator.comparing(Jogador::getDataNascimento));

            return jogadorMaisVelho.get().getId().longValue();
        }else{
            throw new TimeNaoEncontradoException();
        }}

    public List<Long> buscarTimes() {
            List<Long>listaIdsTimes = new ArrayList<>();
            this.getTimes().values().forEach(time -> {
                listaIdsTimes.add(time.getId());
            });
            Collections.sort(listaIdsTimes);
            return listaIdsTimes;
    }

    public Long buscarJogadorMaiorSalario (Long idTime) {
        if (this.getTimes().containsKey(idTime)) {
            Optional<Jogador> jogadorMaiorSalario = this.getJogadores().values().stream()
                    .filter(v->v.getIdTime().longValue() == (idTime))
                    .sorted(Collections.reverseOrder(Comparator.comparing(Jogador::getSalario)).thenComparing(Jogador::getId))
                    .collect(Collectors.maxBy(Comparator.comparing(Jogador::getSalario)));

            return jogadorMaiorSalario.get().getId();
        } else{
            throw new TimeNaoEncontradoException();
        }
    }
    public BigDecimal buscarSalarioDoJogador(Long idJogador) {
        if (this.getJogadores().containsKey(idJogador)) {
            return  this.getJogadores().get(idJogador).getSalario();
        }
        else{
            throw new JogadorNaoEncontradoException();
        }
    }
    public List<Long> buscarTopJogadores(Integer top) {
        Integer limite = 0;

        limite = this.getJogadores().size() < top ? getJogadores().size() : top;
        List<Long> listaTops = new ArrayList<Long>(top);
        List<Jogador> jogadoresSortHabilidade = this.getJogadores().values().stream()
                .sorted(Collections.reverseOrder(Comparator.comparing(Jogador::getNivelHabilidade)).thenComparing((Jogador::getId))).limit(limite)
                .collect(Collectors.toList());
        jogadoresSortHabilidade.forEach((jogador -> {
            listaTops.add(jogador.getId());
        }));
        return listaTops;
    }
    public String buscarCorCamisaTimeDeFora(Long timeDaCasa, Long timeDeFora){
        if ((this.getTimes().containsKey(timeDaCasa) && this.getTimes().containsKey(timeDeFora))) {
            return  this.getTimes().get(timeDaCasa).getCorUniformePrincipal().equals(this.getTimes().get(timeDeFora).getCorUniformePrincipal()) ?
                    this.getTimes().get(timeDeFora).getCorUniformeSecundario() :
                    this.getTimes().get(timeDeFora).getCorUniformePrincipal();
        } else{
            throw new TimeNaoEncontradoException();
        }
    }
}