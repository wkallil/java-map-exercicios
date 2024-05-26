package operacoesBasicasMapDicionario;

import java.util.HashMap;
import java.util.Map;

public class Dicionario {
    Map<String, String> dicionarioMap;

    public Dicionario() {
        this.dicionarioMap = new HashMap<>();
    }

    public void adicionarPalavra(String nome, String definicao) {
        dicionarioMap.put(nome, definicao);
    }

    public void removerPalavra(String nome) {
        if (!dicionarioMap.isEmpty()) {
            dicionarioMap.remove(nome);
        } else {
            throw new RuntimeException("O dicionário está vazio");
        }
    }

    public void exibirPalavras(){
        System.out.println(dicionarioMap);
    }

    public String pesquisaPorPalavra(String palavra) {
        String definicaoDaPalavraProcurada = null;
        if (!dicionarioMap.isEmpty()) {
            definicaoDaPalavraProcurada = dicionarioMap.get(palavra);
        } else {
            throw new RuntimeException("O dicionário está vazio");
        }
        if (definicaoDaPalavraProcurada == null) {
            System.out.println("Palavra não encontrada!");
        }
        return definicaoDaPalavraProcurada;
    }
}
