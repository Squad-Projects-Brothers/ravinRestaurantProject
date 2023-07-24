package main;

import main.controllers.ProdutoController;
import main.enums.TipoProdutoCardapio;
import main.models.Produto;

import java.util.Scanner;

public class RavinApplication {
  public static void main(String[] args) {
    /*int port = 1234; // Porta do servidor socket

    SocketServer socketServer = new SocketServer(port);
    socketServer.start();*/

    Scanner scanner = new Scanner(System.in);
    ProdutoController produtoController = new ProdutoController();

    boolean sair = false;
    while (!sair) {
      exibirMenu();
      int opcao = scanner.nextInt();
      scanner.nextLine(); // Limpar o buffer do scanner

      switch (opcao) {
        case 1:
          cadastrarProduto(scanner, produtoController);
          break;
        case 2:
          buscarProduto(scanner, produtoController);
          break;
        case 0:
          sair = true;
          System.out.println("Saindo do programa...");
          break;
        default:
          System.out.println("Opção inválida. Por favor, tente novamente.");
          break;
      }
    }
  }

  private static void exibirMenu() {
    System.out.println("===== MENU =====");
    System.out.println("1. Cadastrar Produto");
    System.out.println("2. Buscar Produto");
    System.out.println("0. Sair");
    System.out.print("Escolha uma opção: ");
  }

  private static void cadastrarProduto(Scanner scanner, ProdutoController produtoController) {
    System.out.println("===== CADASTRAR PRODUTO =====");
    Produto produto = new Produto();

    produto.setNome("Produto de Teste");
    produto.setDescricao("Descrição do Produto de Teste");
    produto.setCodigo("COD-132");
    produto.setPrecoCusto(15.0);
    produto.setPrecoVenda(26.0);
    produto.setTempoPreparo("10 minutos");
    produto.setTipoProduto(TipoProdutoCardapio.PRATO_PRINCIPAL);
    produto.setObservacoes("Observações do Produto de Teste");
    produto.setAtivo(true);
    produtoController.salvarProduto(produto);
    System.out.println("Produto cadastrado com sucesso.");
  }

  private static void buscarProduto(Scanner scanner, ProdutoController produtoController) {
    System.out.println("===== BUSCAR PRODUTO =====");
    System.out.print("ID do Produto: ");
    int id = scanner.nextInt();
    scanner.nextLine(); // Limpar o buffer do scanner

    // Buscar o produto pelo ID
    Produto produto = produtoController.buscarProdutoPorId(id);

    // Verificar se o produto foi encontrado
    if (produto != null) {
      System.out.println("Produto encontrado:");
      System.out.println("ID: " + produto.getId());
      System.out.println("Nome: " + produto.getNome());
      // Imprimir outros atributos do produto, se necessário
    } else {
      System.out.println("Produto não encontrado.");
    }
  }
}
