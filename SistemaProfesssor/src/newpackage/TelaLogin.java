import javax.swing.*;
import java.util.HashMap;
public class TelaLogin extends JFrame {
    public TelaLogin() {
        setTitle("Login");
        setSize(300, 250);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
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

        JButton btnLogin = new JButton("Login");
        btnLogin.setBounds(30, 120, 100, 25);
        add(btnLogin);

        JButton btnCadastro = new JButton("Cadastrar");
        btnCadastro.setBounds(140, 120, 110, 25);
        add(btnCadastro);

        btnLogin.addActionListener(e -> {
            String nome = txtNome.getText();
            String senhaDigitada = new String(txtSenha.getPassword());

            if (Dados.usuarios.containsKey(nome)) {
                String senhaCerta = Dados.usuarios.get(nome);
                if (senhaCerta.equals(senhaDigitada)) {
                    Professor p = new Professor(nome, "Programação Orientada a Objetos", senhaCerta);
                    dispose();
                    new TelaPerfilProfessor(p);
                } else {
                    JOptionPane.showMessageDialog(this, "Senha incorreta!");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Usuário não encontrado!");
            }
        });

        btnCadastro.addActionListener(e -> {
            dispose();
            new TelaCadastro();
        });

        setVisible(true);
    }
}
