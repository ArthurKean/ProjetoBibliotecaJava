import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String nome;
    private String matricula;
    private String tipo;
    private List<Livro> livrosAlugados;


    public Usuario(String nome, String matricula, String tipo) {
        this.nome = nome;
        this.matricula = matricula;
        this.tipo = tipo;
        this.livrosAlugados = new ArrayList<>();
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

    public List<Livro> getLivrosAlugados() {
        return livrosAlugados;
    }

    public void setLivrosAlugados(List<Livro> livrosAlugados) {
        this.livrosAlugados = livrosAlugados;
    }

    //Estabelecendo os limites para cada tipo de usuario
    public int getLimiteLivros(){
        if(tipo.equalsIgnoreCase("Docente")){
            return 2;
        } else if (tipo.equalsIgnoreCase("Discente")) {
            return 3;
        }
        return 1;
    }

    public int getPrazoDias() {
        if (tipo.equalsIgnoreCase("Docente")){
            return 15;
        } else if (tipo.equalsIgnoreCase("Discente")) {
            return 30;
        }
        return 7;
    }

    public void alugarLivro(Livro livro){

        if (livrosAlugados.size() >= getLimiteLivros()){
            System.out.println(nome + " atingiu o limite de livros!");
            return;
        }

        if (livro.isDisponivel() == true){
            livrosAlugados.add(livro);
            livro.setDisponivel(false);
            livro.setDataAluguel(LocalDate.now());
            livro.setDataDevolucao(LocalDate.now().plusDays(getPrazoDias()));
            System.out.println(nome + " alugou o livro: " + livro.getTitulo() + " | Devolver ate: " + livro.getDataDevolucao());
        } else {
            System.out.println("O livro " + livro.getTitulo() + " nao esta mais disponivel!");
        }

    }
    public void devolverLivro(Livro livro){

        if(livrosAlugados.contains(livro)){
            livrosAlugados.remove(livro);
            livro.setDisponivel(true);
            System.out.println(nome + " devolveu o livro: " + livro.getTitulo());
        } else {
            System.out.println(nome + " nao tem nenhum livro para devolver.");
        }

    }
}
