import java.io.*;
import java.util.HashMap;

public class Dados {
    public static HashMap<String, String> usuarios = new HashMap<>();
    private static final String ARQUIVO = "usuarios.dat";

    static {
        carregarUsuarios(); // carrega automaticamente ao iniciar
    }

    public static void salvarUsuarios() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARQUIVO))) {
            oos.writeObject(usuarios);
        } catch (IOException e) {
            System.out.println("Erro ao salvar usuários: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public static void carregarUsuarios() {
        File file = new File(ARQUIVO);
        if (!file.exists()) return;

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            usuarios = (HashMap<String, String>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao carregar usuários: " + e.getMessage());
        }
    }
}
