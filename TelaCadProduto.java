package com.mycompanys.projetointegrador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaCadProduto extends JFrame {

    public TelaCadProduto() {
        setTitle("Cadastro de Produto");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel painelPrincipal = new JPanel();
        painelPrincipal.setLayout(new BorderLayout());

        // Topo azul com título
        JPanel topo = new JPanel();
        topo.setBackground(new Color(20, 30, 120));
        topo.setPreferredSize(new Dimension(600, 100));
        topo.setLayout(null);

        JLabel titulo = new JLabel("Cadastro de produto");
        titulo.setFont(new Font("SansSerif", Font.BOLD, 28));
        titulo.setForeground(Color.BLACK);
        titulo.setBounds(160, 30, 400, 40);
        topo.add(titulo);

        JButton btnVoltar = new JButton("← Voltar");
        btnVoltar.setBounds(500, 10, 80, 30);
        btnVoltar.setBackground(new Color(135, 206, 250));
        btnVoltar.setFont(new Font("SansSerif", Font.PLAIN, 10));
        topo.add(btnVoltar);

        // Painel do formulário
        JPanel formulario = new JPanel();
        formulario.setBackground(new Color(240, 240, 240));
        formulario.setLayout(null);

        JLabel lblNome = new JLabel("Nome:");
        lblNome.setFont(new Font("SansSerif", Font.BOLD, 16));
        lblNome.setBounds(100, 30, 100, 30);
        JTextField txtNome = new JTextField();
        txtNome.setBounds(200, 30, 250, 30);

        JLabel lblCaixa = new JLabel("Nº Caixa");
        lblCaixa.setFont(new Font("SansSerif", Font.BOLD, 16));
        lblCaixa.setBounds(100, 90, 100, 30);
        JTextField txtCaixa = new JTextField();
        txtCaixa.setBounds(200, 90, 250, 30);

        JLabel lblFornecedor = new JLabel("Fornecedor");
        lblFornecedor.setFont(new Font("SansSerif", Font.BOLD, 16));
        lblFornecedor.setBounds(100, 150, 100, 30);
        JTextField txtFornecedor = new JTextField();
        txtFornecedor.setBounds(200, 150, 250, 30);

        JButton btnCadastrar = new JButton("Cadastrar");
        btnCadastrar.setBackground(new Color(135, 206, 250));
        btnCadastrar.setBounds(230, 220, 130, 40);

        formulario.add(lblNome);
        formulario.add(txtNome);
        formulario.add(lblCaixa);
        formulario.add(txtCaixa);
        formulario.add(lblFornecedor);
        formulario.add(txtFornecedor);
        formulario.add(btnCadastrar);

        painelPrincipal.add(topo, BorderLayout.NORTH);
        painelPrincipal.add(formulario, BorderLayout.CENTER);

        // Ações dos botões
        btnVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new TelaMenu();
            }
        });

        btnCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = txtNome.getText();
                String caixa = txtCaixa.getText();
                String fornecedor = txtFornecedor.getText();

                JOptionPane.showMessageDialog(null, "Produto cadastrado:\nNome: " + nome + "\nCaixa: " + caixa + "\nFornecedor: " + fornecedor);
            }
        });

        add(painelPrincipal);
        setVisible(true);
    }
}
