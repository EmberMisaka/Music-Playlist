

public class App {
    public static void main(String[] args) throws Exception {

        Playlist playlist = new Playlist();

        playlist.adicionarMusica(new Musica("Bohemian Rhapsody", "Queen", 355));
        playlist.adicionarMusica(new Musica("Imagine", "John Lennon", 180));
        playlist.adicionarMusica(new Musica("Billie Jean", "Michael Jackson", 294));

        new PlayerInterface(playlist);
    }
}
