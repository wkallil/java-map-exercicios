package ordenacaoMapLivrariaOnline;

import java.util.*;

public class LivrariaOnline {
    private Map<String, Livro> livrariaMap;

    public LivrariaOnline() {
        this.livrariaMap = new HashMap<>();
    }

    public void adicionarLivro(String link, String titulo, String autor, double preco) {
        livrariaMap.put(link, new Livro(titulo, autor, preco));
    }

    public void removerLivro(String titulo) {
        if (livrariaMap.isEmpty()) {
            throw new RuntimeException("O dicionário está vazio");
        }

        List<String> livrosParaRemover = new ArrayList<>();
        for (Map.Entry<String, Livro> entry : livrariaMap.entrySet()) {
            if (entry.getValue().getTitulo().equalsIgnoreCase(titulo)) {
                livrosParaRemover.add(entry.getKey());
            }
        }
        for (String chave : livrosParaRemover) {
            livrariaMap.remove(chave);
        }
    }

    public Map<String, Livro> exibirLivrosOrdenadosPorPreco() {
        if (livrariaMap.isEmpty()) {
            throw new RuntimeException("O dicionário está vazio");
        }

        List<Map.Entry<String, Livro>> livrosOrdenadosPorPreco = new ArrayList<>(livrariaMap.entrySet());
        Collections.sort(livrosOrdenadosPorPreco, new ComparadorPorPreco());
        Map<String, Livro> livrosOrdenadosPorPrecoFinal = new LinkedHashMap<>();

        for (Map.Entry<String, Livro> entry : livrosOrdenadosPorPreco) {
            livrosOrdenadosPorPrecoFinal.put(entry.getKey(), entry.getValue());
        }
        return livrosOrdenadosPorPrecoFinal;
    }

    public Map<String, Livro> exibirLivrosPorAutor() {
        if (livrariaMap.isEmpty()) {
            throw new RuntimeException("O dicionário está vazio");
        }

        List<Map.Entry<String, Livro>> livrosParaOrdenarPorAutor = new ArrayList<>(livrariaMap.entrySet());
        Collections.sort(livrosParaOrdenarPorAutor, new ComparadorPorAutor());
        Map<String, Livro> livrosOrdenadoPorAutorFinal = new LinkedHashMap<>();

        for (Map.Entry<String, Livro> entry : livrosParaOrdenarPorAutor) {
            livrosOrdenadoPorAutorFinal.put(entry.getKey(), entry.getValue());
        }
        return livrosOrdenadoPorAutorFinal;
    }

    public Map<String, Livro> pesquisarLivroPorAutor(String autor) {
        if (livrariaMap.isEmpty()) {
            throw new RuntimeException("O dicionário está vazio");
        }
        Map<String, Livro> livrosDoAutor = new LinkedHashMap<>();
        for (Map.Entry<String, Livro> entry : livrariaMap.entrySet()) {
            Livro livroDoAutor = entry.getValue();
            if (livroDoAutor.getAutor().equalsIgnoreCase(autor)) {
                livrosDoAutor.put(entry.getKey(), entry.getValue());
            }
        }
        return livrosDoAutor;
    }

    public Livro obterLivroMaisCaro() {
        if (livrariaMap.isEmpty()) {
            throw new RuntimeException("O dicionário está vazio");
        }
        Livro livroMaisCaro = null;
        double precoLivroMaisCaro = Double.MIN_VALUE;
        for (Map.Entry<String, Livro> entry : livrariaMap.entrySet()) {
            if (entry.getValue().getPreco() > precoLivroMaisCaro) {
                precoLivroMaisCaro = entry.getValue().getPreco();
                livroMaisCaro = entry.getValue();
            }
        }
        return livroMaisCaro;
    }
    public Livro obterLivroMaisBarato() {
        if (livrariaMap.isEmpty()) {
            throw new RuntimeException("O dicionário está vazio");
        }
        Livro livroMaisBarato = null;
        double valorLivroMaisBarato = Double.MAX_VALUE;
        for (Map.Entry<String, Livro> entry : livrariaMap.entrySet()) {
            if (entry.getValue().getPreco() < valorLivroMaisBarato) {
                valorLivroMaisBarato = entry.getValue().getPreco();
                livroMaisBarato = entry.getValue();
            }
        }
        return livroMaisBarato;
    }


}
