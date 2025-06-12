import javax.swing.*;

public class TelaConfirmarSaida extends JFrame {
    public TelaConfirmarSaida(Professor p) {
        setTitle("Confirmar Saída");
        setSize(300, 150);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel lbl = new JLabel("Tem certeza que deseja sair?");
        lbl.setBounds(40, 20, 250, 25);
        add(lbl);

        JButton btnSim = new JButton("Sim");
        btnSim.setBounds(40, 60, 80, 25);
        add(btnSim);

        JButton btnNao = new JButton("Não");
        btnNao.setBounds(140, 60, 80, 25);
        add(btnNao);

        btnSim.addActionListener(e -> {
            dispose();
            new TelaLogin();
        });

        btnNao.addActionListener(e -> {
            dispose();
            new TelaPerfilProfessor(p);
        });

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
}