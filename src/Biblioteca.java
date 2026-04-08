import java.util.ArrayList;

public class Biblioteca {
    private ArrayList<Usuario> usuarios;
    private ArrayList<Livro> livros;

    public Biblioteca() {
        livros = new ArrayList<Livro>();
        usuarios = new ArrayList<Usuario>();

    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public ArrayList<Livro> getLivros() {
        return livros;
    }

    public void setLivros(ArrayList<Livro> livros) {
        this.livros = livros;
    }

    public void adicionarLivro(Livro livro) {
        livros.add(livro);
        System.out.println("Livro adicionado: " + livro.getTitulo());
    }

    public void adicionarUsuario(Usuario usuario) {
        usuarios.add(usuario);
        System.out.println("Usuario cadastrado(a): " + usuario.getNome());
    }

    public Livro buscarLivro(Integer id) {
        for (int i = 0; i < livros.size(); i++) {
            Livro livro = livros.get(i);

            if (livro.getId().equals(id)) {
                return livro;
            }
        }
        return null;
    }

    public Usuario buscarUsuario(String matricula) {
        for (int i = 0; i < usuarios.size(); i++) {
            Usuario usuario = usuarios.get(i);

            if (usuario.getMatricula().equals(matricula)) {
                return usuario;
            }
        }
        System.out.println("Usuario com matricula: " + matricula + " nao foi encontrado!");
        return null;
    }
}
