package com.mycompanys.projetointegrador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaMenu extends JFrame {

    public TelaMenu() {
        setTitle("Menu");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Painel principal
        JPanel painelPrincipal = new JPanel();
        painelPrincipal.setLayout(new BorderLayout());

        // titulo azul
        JPanel topo = new JPanel();
        topo.setBackground(new Color(20, 30, 120));
        topo.setPreferredSize(new Dimension(500, 100));

        JLabel titulo = new JLabel("Menu");
        titulo.setFont(new Font("SansSerif", Font.BOLD, 32));
        titulo.setForeground(Color.WHITE);
        topo.add(titulo);

        // Painel central com botões
        JPanel painelBotoes = new JPanel();
        painelBotoes.setBackground(Color.WHITE);
        painelBotoes.setLayout(new GridLayout(3, 1, 20, 20));
        painelBotoes.setBorder(BorderFactory.createEmptyBorder(40, 80, 40, 80));

        JButton btnBuscar = new JButton("Buscar Produto");
        btnBuscar.setBackground(new Color(20, 30, 120));
        btnBuscar.setForeground(Color.WHITE);
        btnBuscar.setFont(new Font("SansSerif", Font.BOLD, 16));
        btnBuscar.setFocusPainted(false);
        btnBuscar.setBorder(BorderFactory.createRaisedBevelBorder());

        JButton btnCadastro = new JButton("Cadastro de produto");
        btnCadastro.setBackground(new Color(20, 30, 120));
        btnCadastro.setForeground(Color.WHITE);
        btnCadastro.setFont(new Font("SansSerif", Font.BOLD, 16));
        btnCadastro.setFocusPainted(false);
        btnCadastro.setBorder(BorderFactory.createRaisedBevelBorder());

        JButton btnVoltar = new JButton("Voltar");
        btnVoltar.setBackground(new Color(66, 165, 245));
        btnVoltar.setForeground(Color.BLACK);
        btnVoltar.setFont(new Font("SansSerif", Font.PLAIN, 12));
        btnVoltar.setFocusPainted(false);
        btnVoltar.setBorder(BorderFactory.createLineBorder(Color.BLUE));

        painelBotoes.add(btnBuscar);
        painelBotoes.add(btnCadastro);
        painelBotoes.add(btnVoltar);

        // para abrir a tela de cadastro ao clicar
        btnCadastro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Fecha  menu
                new TelaCadProduto(); // Abre cadastro
            }
        });

        // Voltar para tela de login
        btnVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Fecha menu
                new TelaAcesso(); // Volta  login
            }
        });
btnBuscar.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        dispose(); // Fecha  menu
        new TelaBuscProduto(); // Abre  busca
    }
});

        painelPrincipal.add(topo, BorderLayout.NORTH);
        painelPrincipal.add(painelBotoes, BorderLayout.CENTER);

        add(painelPrincipal);
        setVisible(true);
    }
}

