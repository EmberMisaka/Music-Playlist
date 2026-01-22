import java.awt.*;
import javax.swing.*;

public class PlayerInterface extends JFrame {
    private Playlist playlist;
    private JLabel lblMusica;
    private JLabel lblArtista;

    public PlayerInterface(Playlist playlist) {
        this.playlist = playlist;

        // Configurações da Janela
        setTitle("Java Music Player");
        setSize(600, 750);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centraliza na tela
        
        // --- CUSTOMIZAÇÃO "ESTILO DARK MODE" ---
        getContentPane().setBackground(new Color(30, 30, 30)); // Cor de fundo (RGB)
        setLayout(new BorderLayout(10, 10));

        // Painel de Informações (Display)
        JPanel painelInfo = new JPanel();
        painelInfo.setLayout(new GridLayout(2, 1));
        painelInfo.setOpaque(false); // Fica transparente para mostrar o fundo dark

        lblMusica = new JLabel("Nome da Música", SwingConstants.CENTER);
        lblMusica.setForeground(Color.WHITE);
        lblMusica.setFont(new Font("Arial", Font.BOLD, 18));

        lblArtista = new JLabel("Artista", SwingConstants.CENTER);
        lblArtista.setForeground(Color.LIGHT_GRAY);
        lblArtista.setFont(new Font("Arial", Font.PLAIN, 14));

        painelInfo.add(lblMusica);
        painelInfo.add(lblArtista);
        add(painelInfo, BorderLayout.CENTER);

        // Painel de Controles (Botões)
        JPanel painelBotoes = new JPanel();
        painelBotoes.setOpaque(false);
        
        JButton btnAnterior = criarBotao("  <<  ");
        JButton btnProxima = criarBotao("  >>  ");

        painelBotoes.add(btnAnterior);
        painelBotoes.add(btnProxima);
        add(painelBotoes, BorderLayout.SOUTH);

        // Inicializa o display com a música atual
        atualizarDisplay();
        btnAnterior.addActionListener(e -> {
            playlist.voltarMusica(); // 1. Move o ponteiro e salva o arquivo
            atualizarDisplay();     // 2. Pega os novos dados e atualiza a tela
        });

        btnProxima.addActionListener(e -> {
            playlist.pularMusica();  // 1. Move o ponteiro e salva o arquivo
            atualizarDisplay();     // 2. Pega os novos dados e atualiza a tela
        });
        
        setVisible(true);
    }

    // Método auxiliar para customizar botões (Como se fosse um CSS reutilizável)
    private JButton criarBotao(String texto) {
        JButton btn = new JButton(texto);
        btn.setBackground(new Color(50, 50, 50));
        btn.setForeground(Color.WHITE);
        btn.setFocusPainted(false);
        btn.setBorder(BorderFactory.createLineBorder(Color.GRAY));

        // :3 OH SOU FRONT-ENDI
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        return btn;
    }

    private void atualizarDisplay() {
        Musica atual = playlist.getMusicaAtual();

        if (atual != null ){
            lblMusica.setText(atual.getTitulo());
            lblArtista.setText(atual.getArtista());
        } else {
            lblMusica.setText("Nenhuma música na playlist");
            lblArtista.setText("");
        }
    }

}