import java.io.Serializable;

public class Professor {
    public String nome;
    public String disciplina;
    public String senha;
    public String anotaçoes = "";

    public Professor(String nome, String disciplina, String senha) {
        this.nome = nome;
        this.disciplina = disciplina;
        this.senha = senha;
    }
}