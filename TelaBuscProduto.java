package com.mycompanys.projetointegrador;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class TelaBuscProduto extends JFrame {

    public TelaBuscProduto() {
        setTitle("Buscar Produto");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Painel principal
        JPanel painelPrincipal = new JPanel(new BorderLayout());

        // Topo azul com título e data
        JPanel topo = new JPanel(new BorderLayout());
        topo.setBackground(new Color(20, 30, 120));
        topo.setPreferredSize(new Dimension(900, 100));

        JLabel titulo = new JLabel("Buscar Produto", SwingConstants.CENTER);
        titulo.setFont(new Font("SansSerif", Font.BOLD, 28));
        titulo.setForeground(Color.BLACK);
        titulo.setOpaque(true);
        titulo.setBackground(Color.WHITE);
        titulo.setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 30));

        JLabel data = new JLabel("Data: 27/11/25");
        data.setFont(new Font("SansSerif", Font.BOLD, 16));
        data.setForeground(Color.BLACK);
        data.setOpaque(true);
        data.setBackground(Color.WHITE);
        data.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        topo.add(titulo, BorderLayout.CENTER);
        topo.add(data, BorderLayout.EAST);

        // Campo de busca
        JPanel painelBusca = new JPanel();
        painelBusca.setBackground(new Color(20, 30, 120));

        JLabel lblBusca = new JLabel("Digite o nº da caixa");
        lblBusca.setFont(new Font("SansSerif", Font.PLAIN, 18));
        lblBusca.setForeground(Color.WHITE);

        JTextField campoCaixa = new JTextField(10);
        campoCaixa.setFont(new Font("SansSerif", Font.BOLD, 24));
        campoCaixa.setHorizontalAlignment(SwingConstants.CENTER);
        campoCaixa.setText("Nº 1010511");

        painelBusca.add(lblBusca);
        painelBusca.add(campoCaixa);

        // Tabela de produtos
        String[] colunas = {"Nº Caixa", "Descrição", "Und", "Preço"};
        Object[][] dados = {
            {"Nº 1010511", "Produto 01", "01", "R$5,99"},
            {"", "", "", ""},
            {"", "", "", ""},
            {"", "", "", ""},
        };

        JTable tabela = new JTable(new DefaultTableModel(dados, colunas));
        tabela.setRowHeight(30);
        tabela.setFont(new Font("SansSerif", Font.PLAIN, 14));
        JScrollPane scrollPane = new JScrollPane(tabela);

        // Painel lateral com pré-visualização
        JPanel painelLateral = new JPanel(new BorderLayout());
        painelLateral.setPreferredSize(new Dimension(200, 300));
        painelLateral.setBackground(Color.WHITE);

        ImageIcon imagem = new ImageIcon("caminho/para/imagem_produto.png"); // Ajustar se quiser imagem real
        JLabel imgLabel = new JLabel(imagem);
        JLabel preLabel = new JLabel("Pré-visualização", SwingConstants.CENTER);
        preLabel.setFont(new Font("SansSerif", Font.BOLD, 14));

        painelLateral.add(imgLabel, BorderLayout.CENTER);
        painelLateral.add(preLabel, BorderLayout.SOUTH);

        // Painel inferior com botões
        JPanel painelBotoes = new JPanel();

        JButton btnVender = new JButton("✓ Vender - F11");
        btnVender.setBackground(Color.BLACK);
        btnVender.setForeground(Color.GREEN);
        btnVender.setFocusPainted(false);

        JButton btnSair = new JButton("🗙 Sair - Esc");
        btnSair.setBackground(Color.BLACK);
        btnSair.setForeground(Color.RED);
        btnSair.setFocusPainted(false);

        JButton btnVoltar = new JButton("Voltar");
        btnVoltar.setBackground(Color.CYAN);

        painelBotoes.add(btnVender);
        painelBotoes.add(btnSair);
        painelBotoes.add(btnVoltar);

        // Ações dos botões
        btnVoltar.addActionListener(e -> {
            dispose();
            new TelaMenu();
        });

        btnSair.addActionListener(e -> {
            System.exit(0);
        });

        // Layout centro
        JPanel centro = new JPanel(new BorderLayout());
        centro.add(scrollPane, BorderLayout.CENTER);
        centro.add(painelLateral, BorderLayout.EAST);

        // Adiciona tudo
        painelPrincipal.add(topo, BorderLayout.NORTH);
        painelPrincipal.add(painelBusca, BorderLayout.BEFORE_FIRST_LINE);
        painelPrincipal.add(centro, BorderLayout.CENTER);
        painelPrincipal.add(painelBotoes, BorderLayout.SOUTH);

        add(painelPrincipal);
        setVisible(true);
    }
}
