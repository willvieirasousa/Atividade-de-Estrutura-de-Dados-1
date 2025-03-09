import java.util.Scanner;

public class Estacionamento {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        EstacionamentoDados estacionamento = new EstacionamentoDados(5);

        while (true) {
            System.out.println("\n Menu do Estacionamento!!");
            System.out.println("===============================");
            System.out.println("(1) - Incluir Veículo");
            System.out.println("(2) - Pesquisar Veículo pela placa");
            System.out.println("(3) - Pesquisar Veículo pela posição");
            System.out.println("(4) - Excluir Veículo do Estacionamento");
            System.out.println("(5) - Listar Veículos do Estacionamento");
            System.out.println("(6) - Consultar as vagas livres");
            System.out.println("(7) - Sair");
            System.out.println("===============================");
            System.out.println("Escolha uma das opções: ");
            int opcao = input.nextInt();
            input.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("Digite o modelo do veículo");
                    String modelo = input.nextLine();

                    System.out.println("Digite a placa do veículo");
                    String placa = input.nextLine();

                    System.out.println("Digite a cor do veículo");
                    String cor = input.nextLine();

                    if (estacionamento.incluirVeiculo(modelo, placa, cor)) {
                        System.out.println("Veículo incluído com sucesso.");
                    } else {
                        System.out.println("Estacionamento está Lotado");
                    }
                    break;
                case 2:
                    System.out.println("Digite a placa do veículo");
                    String placaPesquisa = input.nextLine();
                    int posicao = estacionamento.procurarVeiculoPorPlaca(placaPesquisa);
                    if (posicao != -1) {
                        Veiculo veiculo = estacionamento.procurarVeiculoPorPosicao(posicao);
                        System.out.println("Veiculo foi encontrado na posição: " + posicao);
                        System.out.println("Modelo: " + veiculo.getModelo());
                        System.out.println("Placa: " + veiculo.getPlaca());
                        System.out.println("Cor: " + veiculo.getCor());
                    } else {
                        System.out.println("O veículo não foi localizado.");
                    }
                    break;
                case 3:
                    System.out.println("Digite a posicação do veículo: ");
                    int posicaoPesq = input.nextInt();
                    Veiculo veiculoPosicao = estacionamento.procurarVeiculoPorPosicao(posicaoPesq);
                    if (veiculoPosicao != null) {
                        System.out.println("Veiculo foi encontrado na posição: " + posicaoPesq);
                        System.out.println("Modelo: " + veiculoPosicao.getModelo());
                        System.out.println("Placa: " + veiculoPosicao.getPlaca());
                        System.out.println("Cor: " + veiculoPosicao.getCor());
                    } else {
                        System.out.println("O veículo não foi localizado.");
                    }
                    break;
                case 4:
                    System.out.println("Digite a posição do veículo a excluir: ");
                    int posicaoExcluir = input.nextInt();
                    if (estacionamento.excluirVeiculo(posicaoExcluir)) {
                        System.out.println("Veículo foi excluído com sucesso");
                    } else {
                        System.out.println("Posição inválida");
                    }
                    break;
                case 5:
                    Veiculo[] veiculos = estacionamento.listarVeiculos();
                    System.out.println("Veiculos que estão estacionados: ");
                    for (Veiculo v : veiculos) {
                        System.out.println("Modelo: " + v.getModelo() + ", Placa: " + v.getPlaca() + ", Cor: " + v.getCor());

                    }
                    break;
                case 6:
                    System.out.println("Vagas livres: " + estacionamento.vagasLivres());
                    break;
                case 7:
                    System.out.println("Fechando o sistema...");
                    input.close();
                    return;
                default:
                    System.out.println("Opção digitada é inválida.");
            }
        }
    }
}