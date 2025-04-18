package com.mycompanys.projetointegrador;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class TelaAcesso extends JFrame {
    private JTextField txtUsuario;
    private JPasswordField txtSenha;
    private JLabel lblMensagem;

    public TelaAcesso() {
        setTitle("Tela de Login");
        setSize(400, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel painelPrincipal = new JPanel(new BorderLayout());

        JPanel topo = new JPanel();
        topo.setBackground(new Color(20, 30, 120));
        topo.setPreferredSize(new Dimension(400, 100));
        JLabel titulo = new JLabel("Acesso");
        titulo.setFont(new Font("SansSerif", Font.BOLD, 28));
        titulo.setForeground(Color.WHITE);
        topo.add(titulo);

        JPanel painelForm = new JPanel(new GridLayout(5, 1, 10, 10));
        painelForm.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));

        txtUsuario = new JTextField();
        txtSenha = new JPasswordField();

        painelForm.add(new JLabel("Usuário:"));
        painelForm.add(txtUsuario);
        painelForm.add(new JLabel("Senha:"));
        painelForm.add(txtSenha);

        lblMensagem = new JLabel("", SwingConstants.CENTER);
        lblMensagem.setForeground(Color.RED);
        painelForm.add(lblMensagem);

        JButton btnLogin = new JButton("Entrar");
        btnLogin.setBackground(new Color(20, 30, 120));
        btnLogin.setForeground(Color.WHITE);
        btnLogin.addActionListener(e -> autenticar());

        JPanel painelBotao = new JPanel();
        painelBotao.add(btnLogin);

        painelPrincipal.add(topo, BorderLayout.NORTH);
        painelPrincipal.add(painelForm, BorderLayout.CENTER);
        painelPrincipal.add(painelBotao, BorderLayout.SOUTH);

        add(painelPrincipal);
        setVisible(true);
    }

    private void autenticar() {
        String usuario = txtUsuario.getText();
        String senha = new String(txtSenha.getPassword());

        try (Connection con = ConexaoBD.conectar()) {
            String sql = "SELECT * FROM usuarios WHERE usuario = ? AND senha = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, usuario);
            stmt.setString(2, senha);
            ResultSet rs = stmt.executeQuery();
              if (usuario.equals("admin") && senha.equals("1234")) {
        dispose();
        JOptionPane.showMessageDialog(null, "Login bem-sucedido!");
        new TelaMenu();
    } else {
        lblMensagem.setText("Usuário ou senha incorretos. Tente novamente!");
        txtSenha.setText("");
    }

            if (rs.next()) {
    dispose();
    JOptionPane.showMessageDialog(null, "Login bem-sucedido!");
    new TelaMenu(); }
 else {
                lblMensagem.setText("Senha incorreta. Tente novamente!");
                txtSenha.setText("");
            }

        } catch (SQLException e) {
            lblMensagem.setText("Erro ao conectar com o banco!");
            e.printStackTrace();
        }
    }
}
