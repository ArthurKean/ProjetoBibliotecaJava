public class Usuario {
    private String nome;
    private String matricula;
    private String tipo;
    private Livro livroAlugado;

    public Usuario(String nome, Livro livroAlugado, String tipo, String matricula) {
        this.setNome(nome);
        this.setLivroAlugado(livroAlugado);
        this.setTipo(tipo);
        this.setMatricula(matricula);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Livro getLivroAlugado() {
        return livroAlugado;
    }

    public void setLivroAlugado(Livro livroAlugado) {
        this.livroAlugado = livroAlugado;
    }

    public void alugarLivro(Livro livro){
        if (livro.isDisponivel() == true){
            livroAlugado = livro;
            livro.setDisponivel(false);
            System.out.println(nome + " alugou o livro: " + livro.getTitulo());
        } else {
            System.out.println("O livro " + livro.getTitulo() + " nao esta mais disponivel!");
        }
    }
    public void devolverLivro(Livro livro){
        if(livroAlugado != null){
            livroAlugado.setDisponivel(true);
            System.out.println(nome + " devolveu o livro: " + livroAlugado.getTitulo());
            livroAlugado = null;
        } else {
            System.out.println(nome + " nao tem nenhum livro para devolver.");
        }

    }
}
