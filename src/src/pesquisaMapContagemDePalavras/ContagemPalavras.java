package pesquisaMapContagemDePalavras;

import java.util.HashMap;
import java.util.Map;

public class ContagemPalavras {
    Map<String, Integer> contagemMap;

    public ContagemPalavras() {
        this.contagemMap = new HashMap<>();
    }

    public void adicionarPalavra(String palavra, Integer contagem) {
        contagemMap.put(palavra, contagem);
    }

    public void removerPalavra(String palavra) {
        if (contagemMap.isEmpty()) {
            throw new RuntimeException("O dicionário está vazio");
        }
        contagemMap.remove(palavra);
    }

    public void exibirContagemPalavras(){
        System.out.println(contagemMap);
    }

    public String encontrarPalavraMaisFrequente(){
        if (contagemMap.isEmpty()) {
            throw new RuntimeException("O dicionário está vazio");
        }

        String palavraMaisFrequente = null;
        int frequenciaDaPalavra = Integer.MIN_VALUE;
        for (Map.Entry<String, Integer> p : contagemMap.entrySet()) {
            if (p.getValue() > frequenciaDaPalavra) {
                frequenciaDaPalavra = p.getValue();
                palavraMaisFrequente = p.getKey();
            }
        }
        return palavraMaisFrequente;
    }



}
