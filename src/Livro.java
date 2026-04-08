import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicStampedReference;

public class Livro {
    private String titulo;
    private  String autor;
    private Integer id;
    private boolean disponivel;
    private LocalDate dataAluguel;
    private LocalDate dataDevolucao;

    public Livro(String titulo, String autor, Integer id){
        this.setTitulo(titulo);
        this.setAutor(autor);
        this.setId(id);
        this.setDisponivel(true);
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public LocalDate getDataAluguel() {
        return dataAluguel;
    }

    public void setDataAluguel(LocalDate dataAluguel) {
        this.dataAluguel = dataAluguel;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }


    @Override
    public String toString() {
        return "Livro{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", id=" + id +
                ", disponivel=" + disponivel +
                ", dataDevolucao=" + dataDevolucao +
                '}';
    }
}


