
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        Playlist playlist = new Playlist();
        Musica musica1 = new Musica("Bohemian Rhapsody", "Queen", 355);
        Musica musica2 = new Musica("Imagine", "John Lennon", 180);
        Musica musica3 = new Musica("Billie Jean", "Michael Jackson", 294);

        playlist.adicionarMusica(musica1);
        playlist.adicionarMusica(musica2);
        playlist.adicionarMusica(musica3);

        Scanner scanner = new Scanner(System.in);
        int opcao = -1;

        while (opcao != 0) {
            try {
                playlist.mostrarMusicaAtual();

            System.out.println("Escolha uma opçao:"+
                                "\n [1] Pular música"+
                                "\n [2] Voltar música"+
                                "\n [0] Sair");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    playlist.pularMusica();
                    break;
                case 2:
                    playlist.voltarMusica();
                    break;
                case 0:
                    System.out.println("Saindo do player de música. Até mais!");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
            } catch (Exception e) {
                System.out.println("Entrada inválida. Por favor, insira um número.");
                scanner.nextLine();
                opcao = -1;

            }
        }

    }
}
