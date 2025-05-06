package controllers;

import java.util.Scanner;
import java.util.UUID;

import entities.Produto;
import repositories.ProdutoRepository;

public class ProdutoController {

    public void gerenciarProdutos() {
        var scanner = new Scanner(System.in);
        var produtoRepository = new ProdutoRepository();

        while (true) {
            System.out.println("\n=== MENU PRODUTOS ===");
            System.out.println("1 - Cadastrar Produto");
            System.out.println("2 - Listar Produtos");
            System.out.println("3 - Atualizar Produto");
            System.out.println("4 - Deletar Produto");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            var opcao = scanner.nextLine();

            switch (opcao) {
                case "1":
                    var produtoCadastro = new Produto();
                    produtoCadastro.setId(UUID.randomUUID());

                    System.out.print("NOME........: ");
                    produtoCadastro.setNome(scanner.nextLine());

                    System.out.print("PREÇO.......: ");
                    produtoCadastro.setPreco(Double.parseDouble(scanner.nextLine()));

                    System.out.print("QUANTIDADE..: ");
                    produtoCadastro.setQuantidade(Integer.parseInt(scanner.nextLine()));

                    produtoRepository.inserir(produtoCadastro);
                    break;

                case "2":
                    produtoRepository.consultar();
                    break;

                case "3":
                    var produtoEdicao = new Produto();

                    System.out.print("ID..........: ");
                    produtoEdicao.setId(UUID.fromString(scanner.nextLine()));

                    System.out.print("NOME........: ");
                    produtoEdicao.setNome(scanner.nextLine());

                    System.out.print("PREÇO.......: ");
                    produtoEdicao.setPreco(Double.parseDouble(scanner.nextLine()));

                    System.out.print("QUANTIDADE..: ");
                    produtoEdicao.setQuantidade(Integer.parseInt(scanner.nextLine()));

                    produtoRepository.alterar(produtoEdicao);
                    break;

                case "4":
                    System.out.print("ID..........: ");
                    var id = UUID.fromString(scanner.nextLine());

                    produtoRepository.excluir(id);
                    break;

                case "0":
                    System.out.println("Saindo...");
                    return; // ou break do while

                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }

       
    }
}

