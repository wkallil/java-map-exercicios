package ordenacaoMapAgendaEventos;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class AgendaEventos {
    private Map<LocalDate, Evento> agendaEventosMap;

    public AgendaEventos() {
        this.agendaEventosMap = new HashMap<>();
    }

    public void adicionarEvento(LocalDate data, String nome, String atracao) {
        agendaEventosMap.put(data, new Evento(nome, atracao));
    }

    public void exibirAgenda() {
        Map<LocalDate, Evento> agendaOrdemCrescente = new TreeMap<>(agendaEventosMap);
        System.out.println(agendaOrdemCrescente);
    }

    public String obterProximoEvento() {
        LocalDate dataAtual = LocalDate.now();
        String proximoEvento = null;
        if (agendaEventosMap.isEmpty()) {
            throw new RuntimeException("O dicionário está vazio");
        }
        for (Map.Entry<LocalDate, Evento> entry : agendaEventosMap.entrySet()) {
            if (entry.getKey().isEqual(dataAtual) || entry.getKey().isAfter(dataAtual)) {
                proximoEvento = entry.getValue().getNome();
                break;
            }
        }
        if (proximoEvento != null) {
            return proximoEvento;
        } else {
            return "Não há eventos futuros na agenda";
        }
    }
}
