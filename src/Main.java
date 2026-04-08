import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Biblioteca biblioteca = new Biblioteca();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        //Testar
        biblioteca.adicionarLivro(new Livro("O Hobbit", "J.R.R. Chicken",01));
        biblioteca.adicionarLivro(new Livro("Revolucao dos bichos","George Orwell",02));
        biblioteca.adicionarLivro(new Livro("Pequeno Principe","Antoine de Saint E.",03));
        biblioteca.adicionarUsuario(new Usuario("Arthur","0001","Discente"));
        biblioteca.adicionarUsuario(new Usuario("Pedro","0002","Discente"));
        biblioteca.adicionarUsuario(new Usuario("Geraldo","0003","Doscente"));



        do {
            System.out.println("\n ------- MENU -------");
            System.out.println("1 - Cadastrar usuario");
            System.out.println("2 - Buscar usuario");
            System.out.println("3 - Alugar livro");
            System.out.println("4 - Buscar livro");
            System.out.println("5 - Devolver livro");
            System.out.println("6 - Listar livros");
            System.out.println("7 - Sair");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch(opcao) {

                case 1:
                    System.out.println("Digite o nome do usuario:");
                    String nomeUsuario = scanner.nextLine();

                    System.out.println("Digite a matricula:");
                    String matriculaUsuario = scanner.nextLine();

                    System.out.println("Digite o tipo do usuario:");
                    String tipoUsuario = scanner.nextLine();

                    Usuario usuario = biblioteca.buscarUsuario(matriculaUsuario);

                    if (biblioteca.buscarUsuario(matriculaUsuario) != null){
                        System.out.println("Esse usuario ja esta cadastrado");
                    } else {
                        biblioteca.adicionarUsuario(new Usuario(nomeUsuario,matriculaUsuario, tipoUsuario));
                        System.out.println("Usuario cadastrado com sucesso!");
                    }
                    break;

                case 2:
                    System.out.println("Digite a matricula do usuario:");
                    String matriculaBusca = scanner.nextLine();

                    Usuario usuarioEncontrado = biblioteca.buscarUsuario(matriculaBusca);

                    if(usuarioEncontrado != null){
                        System.out.println("Usuario encontrado: " + usuarioEncontrado.getNome()
                                + " | Tipo: " + usuarioEncontrado.getTipo()
                                + " | Matricula: " + usuarioEncontrado.getMatricula());
                    }

                    //List<Livro> livrosAtual  = usuarioEncontrado.getLivrosAlugados();

                    if(!usuarioEncontrado.getLivrosAlugados().isEmpty()){
                        System.out.println("Livros alugado(s): ");
                        for(Livro i : usuarioEncontrado.getLivrosAlugados()) {
                            System.out.println(" - " + i.getTitulo());
                        }
                    } else {
                        System.out.println("Nenhum livro alugado no momento!");
                    }
                    break;

                case 3:
                    System.out.println("Matricula do usuario:");
                    String matriculaAluguel = scanner.nextLine();

                    Usuario usuarioAluguel = biblioteca.buscarUsuario(matriculaAluguel);
                    if(usuarioAluguel == null) break;

                    System.out.println("DIgite o ID do livro:");
                    int idAluguel = scanner.nextInt();
                    scanner.nextLine();

                    Livro livroAluguel = biblioteca.buscarLivro(idAluguel);

                    if(livroAluguel == null){
                        System.out.println("Livro nao encontrado!");
                    } else {
                        usuarioAluguel.alugarLivro(livroAluguel);
                    }
                    break;

                case 4:
                    System.out.println("ID do livro:");
                    int idBusca = scanner.nextInt();
                    scanner.nextLine();

                    Livro livroBusca = biblioteca.buscarLivro(idBusca);

                    if (livroBusca != null){
                        System.out.println(livroBusca);
                    } else {
                        System.out.println("Livro nao encontrado!");
                    }
                    break;

                case 5:
                    System.out.println("Matricula do usuario:");
                    String matriculaDevolucao = scanner.nextLine();

                    Usuario usuarioDevolucao = biblioteca.buscarUsuario(matriculaDevolucao);
                    if (usuarioDevolucao == null) {
                        break;
                    }

                    System.out.println("ID do livro a devolver: ");
                    int idDevolucao = scanner.nextInt();
                    scanner.nextLine();

                    Livro livroDevolucao = biblioteca.buscarLivro((idDevolucao));
                    if(livroDevolucao == null){
                        System.out.println("Livro nao encontrado!");
                    } else {
                        usuarioDevolucao.devolverLivro(livroDevolucao);
                    }
                    break;

                case 6:
                    System.out.println("\n--- LISTA DE LIVROS ---");
                    for (Livro livro : biblioteca.getLivros()) {
                        System.out.println(livro);
                    }
                    break;
                case 7:
                    System.out.println("SAINDO.....");
                    break;

                default:
                    System.out.println("Opcao inavalida!");
            }
        } while(opcao != 7);
        scanner.close();

    }
}