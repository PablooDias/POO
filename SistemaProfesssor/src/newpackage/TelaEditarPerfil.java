import javax.swing.*;

public class TelaEditarPerfil extends JFrame {
    public TelaEditarPerfil(Professor p) {
        setTitle("Editar Perfil");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel lblNome = new JLabel("Novo nome:");
        lblNome.setBounds(30, 30, 100, 25);
        add(lblNome);

        JTextField txtNome = new JTextField(p.nome);
        txtNome.setBounds(120, 30, 130, 25);
        add(txtNome);

        JButton btnSalvar = new JButton("Salvar");
        btnSalvar.setBounds(90, 100, 100, 25);
        add(btnSalvar);

        btnSalvar.addActionListener(e -> {
            p.nome = txtNome.getText();
            dispose();
            new TelaPerfilProfessor(p);
        });

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
}