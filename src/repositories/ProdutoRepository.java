package repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.UUID;

import entities.Produto;
import factories.ConnectionFactory;

public class ProdutoRepository {

    private ConnectionFactory connectionFactory = new ConnectionFactory();

    public void inserir(Produto produto) {
        try {
            Connection connection = connectionFactory.obterConexao();
            PreparedStatement stmt = connection.prepareStatement(
                "INSERT INTO produto (id, nome, preco, quantidade) VALUES (?, ?, ?, ?)"
            );
            stmt.setObject(1, produto.getId());
            stmt.setString(2, produto.getNome());
            stmt.setDouble(3, produto.getPreco());
            stmt.setInt(4, produto.getQuantidade());
            stmt.execute();
            connection.close();

            System.out.println("\nProduto cadastrado com sucesso!");
        } catch (Exception e) {
            System.out.println("\nErro ao inserir: " + e.getMessage());
        }
    }

    public void alterar(Produto produto) {
        try {
            Connection connection = connectionFactory.obterConexao();
            PreparedStatement stmt = connection.prepareStatement(
                "UPDATE produto SET nome = ?, preco = ?, quantidade = ? WHERE id = ?"
            );
            stmt.setString(1, produto.getNome());
            stmt.setDouble(2, produto.getPreco());
            stmt.setInt(3, produto.getQuantidade());
            stmt.setObject(4, produto.getId());
            stmt.execute();
            connection.close();

            System.out.println("\nProduto atualizado com sucesso!");
        } catch (Exception e) {
            System.out.println("\nErro ao alterar: " + e.getMessage());
        }
    }

    public void excluir(UUID id) {
        try {
            Connection connection = connectionFactory.obterConexao();
            PreparedStatement stmt = connection.prepareStatement(
                "DELETE FROM produto WHERE id = ?"
            );
            stmt.setObject(1, id);
            stmt.execute();
            connection.close();

            System.out.println("\nProduto excluído com sucesso!");
        } catch (Exception e) {
            System.out.println("\nErro ao excluir: " + e.getMessage());
        }
    }

    public void consultar() {
        try {
            Connection connection = connectionFactory.obterConexao();
            PreparedStatement stmt = connection.prepareStatement(
                "SELECT * FROM produto"
            );
            var result = stmt.executeQuery();

            while (result.next()) {
                System.out.println("ID.........: " + result.getString("id"));
                System.out.println("NOME.......: " + result.getString("nome"));
                System.out.println("PREÇO......: " + result.getDouble("preco"));
                System.out.println("QUANTIDADE.: " + result.getInt("quantidade"));
                System.out.println("------------------------------------------");
            }

            connection.close();
        } catch (Exception e) {
            System.out.println("\nErro ao consultar: " + e.getMessage());
        }
    }
}



	
