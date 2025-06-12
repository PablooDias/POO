import javax.swing.*;

public class TelaConfirmarExclusao extends JFrame {
    public TelaConfirmarExclusao(Professor p) {
        setTitle("Confirmar Exclusão");
        setSize(300, 150);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel lbl = new JLabel("Tem certeza que deseja excluir?");
        lbl.setBounds(40, 20, 250, 25);
        add(lbl);

        JButton btnSim = new JButton("Sim");
        btnSim.setBounds(40, 60, 80, 25);
        add(btnSim);

        JButton btnNao = new JButton("Não");
        btnNao.setBounds(140, 60, 80, 25);
        add(btnNao);

        btnSim.addActionListener(e -> {
            try {
                java.io.File inputFile = new java.io.File("usuarios.txt");
                java.io.File tempFile = new java.io.File("usuarios_temp.txt");

                java.util.Scanner scanner = new java.util.Scanner(inputFile);
                java.io.PrintWriter writer = new java.io.PrintWriter(tempFile);

                while (scanner.hasNextLine()) {
                    String linha = scanner.nextLine();
                    if (!linha.equals(p.nome)) {
                        writer.println(linha);
                    }
                }

                scanner.close();
                writer.close();

                inputFile.delete();
                tempFile.renameTo(inputFile);
            } catch (Exception ex) {
                ex.printStackTrace();
            }

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