package br.com.restaurante;

import br.com.restaurante.dao.AtendenteDAO;
import br.com.restaurante.dao.ChamadoDAO;
import br.com.restaurante.dao.ClienteDAO;
import br.com.restaurante.exception.AtendimentoException;
import br.com.restaurante.model.Atendente;
import br.com.restaurante.model.Chamado;
import br.com.restaurante.model.Cliente;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ClienteDAO clienteDAO = new ClienteDAO();
        AtendenteDAO atendenteDAO = new AtendenteDAO();
        ChamadoDAO chamadoDAO = new ChamadoDAO();

        int opcao = -1;

        while (opcao != 0) {
            try {
                System.out.println("\n=== SISTEMA DE ATENDIMENTO ===");
                System.out.println("1 - Cadastrar Cliente");
                System.out.println("2 - Cadastrar Atendente");
                System.out.println("3 - Abrir Chamado");
                System.out.println("4 - Listar Chamados");
                System.out.println("5 - Atribuir Chamado a Atendente");
                System.out.println("6 - Resolver Chamado");
                System.out.println("0 - Sair");
                System.out.print("Escolha: ");
                opcao = Integer.parseInt(sc.nextLine());

                switch (opcao) {
                    case 1:
                        System.out.println("\n--- Cadastro de Cliente ---");
                        System.out.print("Nome: ");
                        String nome = sc.nextLine();
                        System.out.print("Email: ");
                        String email = sc.nextLine();
                        System.out.print("Telefone: ");
                        String telefone = sc.nextLine();

                        clienteDAO.inserir(new Cliente(nome, email, telefone));
                        System.out.println("Cliente cadastrado com sucesso!");
                        break;

                    case 2:
                        System.out.println("\n--- Cadastro de Atendente ---");
                        System.out.print("Nome: ");
                        String nomeA = sc.nextLine();
                        System.out.print("Departamento: ");
                        String depto = sc.nextLine();

                        atendenteDAO.inserir(new Atendente(nomeA, depto));
                        System.out.println("Atendente cadastrado com sucesso!");
                        break;

                    case 3:
                        System.out.println("\n--- Abertura de Chamado ---");
                        System.out.print("ID do Cliente: ");
                        int idCli = Integer.parseInt(sc.nextLine());
                        System.out.print("Descrição: ");
                        String desc = sc.nextLine();

                        chamadoDAO.inserir(new Chamado(desc, "ABERTO", idCli));
                        System.out.println("Chamado aberto com sucesso!");
                        break;

                    case 4:
                        System.out.println("\n--- Lista de Chamados ---");
                        for (Chamado ch : chamadoDAO.listar()) {
                            System.out.println(ch);
                        }
                        break;

                    case 5:
                        System.out.println("\n--- Atribuir Chamado ---");
                        System.out.print("ID do Chamado: ");
                        int idCh = Integer.parseInt(sc.nextLine());
                        System.out.print("ID do Atendente: ");
                        int idAt = Integer.parseInt(sc.nextLine());

                        chamadoDAO.atribuirAtendente(idCh, idAt);
                        System.out.println("Chamado atribuído com sucesso!");
                        break;

                    case 6:
                        System.out.println("\n--- Resolver Chamado ---");
                        System.out.print("ID do Chamado: ");
                        int idChRes = Integer.parseInt(sc.nextLine());

                        chamadoDAO.resolverChamado(idChRes);
                        System.out.println("Chamado resolvido com sucesso!");
                        break;

                    case 0:
                        System.out.println("Encerrando o sistema...");
                        break;

                    default:
                        System.out.println("Opção inválida!");
                }

            } catch (AtendimentoException e) {
                System.err.println("Erro no sistema de atendimento: " + e.getMessage());
            } catch (NumberFormatException e) {
                System.err.println("Entrada inválida! Digite apenas números.");
            } catch (Exception e) {
                System.err.println("Ocorreu um erro inesperado: " + e.getMessage());
            }
        }

        sc.close();
    }
}
