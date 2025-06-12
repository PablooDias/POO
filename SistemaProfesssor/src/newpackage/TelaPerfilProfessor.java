import javax.swing.*;

public class TelaPerfilProfessor extends JFrame {
    public TelaPerfilProfessor(Professor p) {
        setTitle("Perfil do Professor");
        setSize(500, 400);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel lblNome = new JLabel("Nome: " + p.nome);
        lblNome.setBounds(20, 20, 300, 25);
        add(lblNome);

        JLabel lblDisciplina = new JLabel("Disciplina: " + p.disciplina);
        lblDisciplina.setBounds(20, 50, 300, 25);
        add(lblDisciplina);

        JLabel lblHorario = new JLabel("Horário: 19:00 às 22:00");
        lblHorario.setBounds(20, 80, 300, 25);
        add(lblHorario);

        JLabel lblCalendario = new JLabel("Calendário (Seg a Sex, 19:00 as 22:00)");
        lblCalendario.setBounds(20, 110, 300, 25);
        add(lblCalendario);
        
        JTextArea calendario = new JTextArea();
        calendario.setBounds(20, 140, 450, 200);
        calendario.setLineWrap(true);
        calendario.setWrapStyleWord(true);
        calendario.setText(p.anotaçoes != null ? p.anotaçoes : ""); 
        add(calendario);

        JButton btnSalvarCalendario = new JButton("Salvar Calendário");
        btnSalvarCalendario.setBounds(20, 350, 200, 25);
        add(btnSalvarCalendario);

        btnSalvarCalendario.addActionListener(e -> {
            p.anotaçoes = calendario.getText(); 
            JOptionPane.showMessageDialog(this, "Calendário salvo.");
        });

        JButton btnEditar = new JButton("Editar");
        btnEditar.setBounds(20, 150, 100, 25);
        add(btnEditar);

        JButton btnSair = new JButton("Sair");
        btnSair.setBounds(130, 150, 100, 25);
        add(btnSair);

        JButton btnExcluir = new JButton("Excluir");
        btnExcluir.setBounds(240, 150, 100, 25);
        add(btnExcluir);

        btnSair.addActionListener(e -> {
            dispose();
            new TelaConfirmarSaida(p);
        });

        btnExcluir.addActionListener(e -> {
            dispose();
            new TelaConfirmarExclusao(p);
        });

        btnEditar.addActionListener(e -> {
            dispose();
            new TelaEditarPerfil(p);
        });

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
}