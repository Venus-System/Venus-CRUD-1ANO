package com.exemplo.dao;

import com.exemplo.model.Usuario;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        Usuario usuario = new Usuario ("Janderson Martins", "Masculino", "jdhfhd" ,  "1234","551198976", LocalDate.of(2000,6,7), LocalDate.of(2026,8,27));
        UsuarioDAO dao = new UsuarioDAO();
        System.out.println();
        dao.cadastrarUsuario(usuario);

        boolean sair = false;

        while (sair == false) {
            System.out.println("-\n===== MENU =====");
            System.out.println("1 - Adicionar usuário");
            System.out.println("2 - Sair");
            System.out.print("Escolha uma opção: ");

            String opcao = scanner.nextLine().trim();

            if (opcao.equals("1")) {
                try {

                    System.out.print("Nome completo: ");
                    String nomeCompleto = scanner.nextLine();

                    System.out.print("Gênero: ");
                    String genero = scanner.nextLine();

                    System.out.print("Email: ");
                    String email = scanner.nextLine();

                    System.out.print("Senha: ");
                    String senha = scanner.nextLine();

                    String telefone = null;
                    boolean telefoneValido = false;

                    while (telefoneValido == false) {
                        System.out.print("Telefone (somente números, com DDD): ");
                        telefone = scanner.nextLine().trim();

                        if (telefone.length() == 10 || telefone.length() == 11) {
                            boolean soTemNumeros = true;

                            for (int i = 0; i < telefone.length(); i++) {
                                char c = telefone.charAt(i);
                                if (Character.isDigit(c) == false) {
                                    soTemNumeros = false;
                                }
                            }

                            if (soTemNumeros == true) {
                                telefoneValido = true;
                            } else {
                                System.out.println("Telefone inválido. Digite apenas números (sem letras ou símbolos).");
                            }
                        } else {
                            System.out.println("Telefone inválido. Deve ter 10 ou 11 dígitos (com DDD).");
                        }
                    }

                    LocalDate dtNascimento = null;
                    boolean dataValida = false;

                    while (dataValida == false) {
                        System.out.print("Data de nascimento (dd/MM/yyyy): ");
                        String textoData = scanner.nextLine().trim();
                        try {
                            dtNascimento = LocalDate.parse(textoData, formatoData);
                            dataValida = true;
                        } catch (DateTimeParseException e) {
                            System.out.println("Data inválida. Use o formato dd/MM/yyyy.");
                        }
                    }

                    Usuario usuario1 = new Usuario(nomeCompleto, genero, email, senha, telefone, dtNascimento, LocalDate.now());
                    UsuarioDAO dao1 = new UsuarioDAO();

                    if (dao.existeEmail(usuario.getEmail())) {
                        System.out.println("Já existe um usuário cadastrado com esse email.");
                    } else {
                        boolean cadastrado = dao.cadastrarUsuario(usuario);
                        if (cadastrado) {
                            System.out.println("Usuário cadastrado com sucesso!");
                        } else {
                            System.out.println("Não foi possível cadastrar o usuário.");
                        }
                    }

                    System.out.println();

                    ArrayList<Usuario> usuarios = dao.read();
                    for (Usuario user : usuarios) {
                        System.out.println(user);
                    }

                } catch (SQLException sql) {
                    System.out.println(sql.getMessage());
                }
            } else if (opcao.equals("2")) {
                sair = true;
                System.out.println("Encerrando o programa...");
            } else {
                System.out.println("Opção inválida. Tente novamente.");
            }
        }

        scanner.close();
    }
}