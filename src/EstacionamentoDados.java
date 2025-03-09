public class EstacionamentoDados {
    private Veiculo [] veiculos;
    private int capacidade;
    private int tamanho;

    public EstacionamentoDados(int capacidade) {
        this.veiculos = new Veiculo[capacidade];
        this.capacidade = capacidade;
        this.tamanho = 0;
    }

    public boolean incluirVeiculo (String modelo, String placa, String cor){
        if (tamanho < capacidade) {
            veiculos[tamanho] = new Veiculo(modelo, placa, cor);
            tamanho++;
            return true;
        }
        return false;
    }
    public int procurarVeiculoPorPlaca(String placa) {
        for (int i = 0; i < tamanho; i++) {
            if (veiculos[i].getPlaca().equals(placa)){
                return i;
            }
        }
        return -1;
    }
    public Veiculo procurarVeiculoPorPosicao(int posicao) {
        if (posicao >= 0 && posicao < tamanho){
            return veiculos[posicao];
        }
        return null;
    }
    public boolean excluirVeiculo(int posicao){
        if(posicao >=0 && posicao < tamanho){
            for(int i = posicao; i < tamanho - 1; i++){
                veiculos[i] = veiculos[i + 1];
            }
            veiculos[tamanho - 1] = null;
            tamanho--;
            return true;
        }
        return false;
    }

    public Veiculo[] listarVeiculos(){
        Veiculo[] lista = new Veiculo[tamanho];
        for(int i = 0; i < tamanho; i++){
            lista[i] = veiculos[i];
        }
        return lista;
    }

    public int vagasLivres(){
        return capacidade - tamanho;
    }
}

