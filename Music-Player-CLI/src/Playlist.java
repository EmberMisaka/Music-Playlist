import java.util.ArrayList;

public class Playlist {

    private ArrayList<Musica> musicas;
    private int indiceAtual;

    public Playlist() {
       this.musicas = new ArrayList<>();
        this.indiceAtual = 0;
    }

    public void adicionarMusica(Musica musica) {
        musicas.add(musica);
    }

    // Objeto de estudo de hoje:
    public void pularMusica(){
        indiceAtual = (indiceAtual +1) % musicas.size();
    }

    // Objeto de estudo de hoje:
    public void voltarMusica(){
        indiceAtual = (indiceAtual -1 +musicas.size()) % musicas.size();
    }

    public void mostrarMusicaAtual(){
        if (musicas.isEmpty()) {
            System.out.println("A playlist está vazia.");
        } else {
            Musica musicaAtual = musicas.get(indiceAtual);
            System.out.println("\n Sua vibe do momento é: " + musicaAtual.getTitulo() + " - "
                                + musicaAtual.getArtista() + " (" + musicaAtual.getDuracao() + "s)");
        }
    }
}
