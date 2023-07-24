package main.configs;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

import main.controllers.ProdutoController;
import main.models.Produto;

public class SocketServer {

  private ServerSocket serverSocket;

  public SocketServer(int port) {
    try {
      serverSocket = new ServerSocket(port);
      System.out.println("Servidor socket iniciado na porta " + port);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void start() {
    while (true) {
      try {
        Socket socket = serverSocket.accept();
        System.out.println("Nova conexão estabelecida: " + socket.getInetAddress());

        // Crie uma nova thread para lidar com a conexão
        Thread connectionThread = new Thread(() -> handleConnection(socket));
        connectionThread.start();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

  private void handleConnection(Socket socket) {
    try {
      // Obtenha os dados do banco de dados (por exemplo, lista de produtos)
      ProdutoController produtoController = new ProdutoController();
      List<Produto> produtos = produtoController.listarTodosProdutos();

      // Envie a lista de produtos para o front-end
      ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
      objectOutputStream.writeObject(produtos);

      // Feche a conexão com o front-end
      socket.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void stop() {
    try {
      serverSocket.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
