import java.util.ArrayList;
import java.util.Scanner;

public class SistemaGestaoEstoque {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        // Cria um ArrayList vazio para armazenar os produtos em estoque
        ArrayList<Produto> estoque = new ArrayList<>();

        // Exibe o menu e solicita a entrada do usuário
        int escolha;
        do {
            System.out.println("1. Adicionar produto ao estoque");
            System.out.println("2. Remover produto do estoque");
            System.out.println("3. Visualizar estoque");
            System.out.println("4. Sair");
            System.out.print("Digite sua escolha: ");
            escolha = entrada.nextInt();

            switch (escolha) {
                case 1:
                    // Solicita detalhes do produto
                    System.out.print("Digite o nome do produto: ");
                    String nome = entrada.next();
                    System.out.print("Digite a quantidade do produto: ");
                    int quantidade = entrada.nextInt();
                    System.out.print("Digite o preço do produto: ");
                    double preco = entrada.nextDouble();

                    // Cria um novo objeto Produto e adiciona ao ArrayList
                    Produto novoProduto = new Produto(nome, quantidade, preco);
                    estoque.add(novoProduto);

                    System.out.println("Produto adicionado com sucesso");
                    break;

                case 2:
                    // Solicita o nome do produto e a quantidade a ser removida
                    System.out.print("Digite o nome do produto: ");
                    String nomeProduto = entrada.next();
                    System.out.print("Digite a quantidade a ser removida: ");
                    int quantidadeRemover = entrada.nextInt();

                    // Percorre o estoque para encontrar o produto correspondente
                    boolean produtoEncontrado = false;
                    for (Produto produto : estoque) {
                        if (produto.getNome().equals(nomeProduto)) {
                            // Se o produto for encontrado, remove a quantidade especificada
                            produtoEncontrado = true;
                            produto.removerQuantidade(quantidadeRemover);
                            System.out.println("Produto removido com sucesso");
                            break;
                        }
                    }
                    if (!produtoEncontrado) {
                        System.out.println("Produto não encontrado");
                    }
                    break;

                case 3:
                    // Exibe a lista de produtos em estoque
                    System.out.println("Estoque atual:");
                    for (Produto produto : estoque) {
                        System.out.println(produto.toString());
                    }
                    break;

                case 4:
                    System.out.println("Encerrando o programa...");
                    break;

                default:
                    System.out.println("Escolha inválida, tente novamente.");
                    break;
            }

        } while (escolha != 4);

        entrada.close();
    }
}

class Produto {
    private String nome;
    private int quantidade;
    private double preco;

    public Produto(String nome, int quantidade, double preco) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getPreco() {
        return preco;
    }

    public void removerQuantidade(int quantidadeRemover) {
        if (quantidadeRemover <= quantidade) {
            quantidade -= quantidadeRemover;
        } else {
            System.out.println("Quantidade insuficiente para remover");
        }
    }

    public String toString() {
        return nome + ", quantidade: " + quantidade + ", preço: R$" + preco;
    }
}
