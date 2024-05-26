package operacoesBasicasMapAgendaContatos;

import java.util.HashMap;
import java.util.Map;

public class AgendaContatos {
    Map<String, Integer> contatosMap;

    public AgendaContatos() {
        this.contatosMap = new HashMap<>();
    }

    public void adicionarContato(String nome, Integer telefone) {
        contatosMap.put(nome, telefone);
    }

    public void removerContato(String nome) {
        if (!contatosMap.isEmpty()) {
            contatosMap.remove(nome);
        } else {
            throw new RuntimeException("O dicionário está vazio");
        }
    }

    public void exibirContatos() {
        if (!contatosMap.isEmpty()) {
            System.out.println(contatosMap);
        } else {
            throw new RuntimeException("O dicionário está vazio");
        }
    }

    public Integer pesquisarPorNome(String nome) {
        Integer numeroPesquisadoPeloNome = null;
        if (!contatosMap.isEmpty()) {
            numeroPesquisadoPeloNome = contatosMap.get(nome);
        } else {
            throw new RuntimeException("O dicionário está vazio");
        }
        if (numeroPesquisadoPeloNome == null) {
            System.out.println("Contato não encontrado!");
        }
        return numeroPesquisadoPeloNome;
    }

}
