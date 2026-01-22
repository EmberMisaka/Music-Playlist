import java.util.ArrayList;

public class Playlist {


    private ArrayList<Musica> musicas;
    private int indiceAtual;

    public Playlist() {
        this.musicas = new ArrayList<>();
        this.indiceAtual = carregarEstado();
    }

    public void adicionarMusica(Musica musica) {
        musicas.add(musica);
    }

    public void pularMusica(){
        indiceAtual = (indiceAtual +1) % musicas.size();
        salvarEstado();
    }

    public void voltarMusica(){
        indiceAtual = (indiceAtual -1 +musicas.size()) % musicas.size();
        salvarEstado();
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

    // Novo objeto de estudo: Persistência Simples com Arquivo de Texto
    private void salvarEstado() {
        try (java.io.FileWriter fw = new java.io.FileWriter("config.txt")) {
            fw.write(String.valueOf(this.indiceAtual));
        } catch (java.io.IOException e){
            System.out.println("Erro ao savar progresso: ");
        }
    }

    private int carregarEstado() {
        java.io.File arquivo = new java.io.File("config.txt");
        if (arquivo.exists()) {
            try (java.util.Scanner sc = new java.util.Scanner(arquivo)) {
                return sc.nextInt();
            } catch (Exception e) {
                return 0;
            }
        }
        return 0;
    }

    public Musica getMusicaAtual() {
        if (musicas.isEmpty()) {
            return null;
        }
        return musicas.get(indiceAtual);
    }
}
