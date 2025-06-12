import javax.swing.*;
import java.io.*;
import java.util.HashMap;
public class TelaCadastro extends JFrame {
 
    public TelaCadastro() {
        setTitle("Cadastro");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setLayout(null);
        
        JLabel lblNome = new JLabel("Nome:");
        lblNome.setBounds(30, 30, 80, 25);
        add(lblNome);

        JTextField txtNome = new JTextField();
        txtNome.setBounds(100, 30, 150, 25);
        add(txtNome);

        JLabel lblSenha = new JLabel("Senha:");
        lblSenha.setBounds(30, 70, 80, 25);
        add(lblSenha);

        JPasswordField txtSenha = new JPasswordField();
        txtSenha.setBounds(100, 70, 150, 25);
        add(txtSenha);

        JButton btnSalvar = new JButton("Salvar");
        btnSalvar.setBounds(100, 120, 100, 25);
        add(btnSalvar);

        btnSalvar.addActionListener(e -> {
            String nome = txtNome.getText();
            String senha = new String(txtSenha.getPassword());

            if (nome.isEmpty() || senha.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Preencha todos os campos!");
                return;
            }

            if (Dados.usuarios.containsKey(nome)) {
                JOptionPane.showMessageDialog(this, "Usuário já existe!");
                return;
            }

            Dados.usuarios.put(nome, senha);
            Dados.salvarUsuarios();
            JOptionPane.showMessageDialog(this, "Cadastro realizado com sucesso!");
            dispose();
            new TelaLogin();
        });

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
}