# 🎵 Java Music Player (CLI)
Um reprodutor de música em linha de comando desenvolvido para praticar os pilares da **Programação Orientada a Objetos (POO)** e manipulação de estruturas de dados.

# 🚀 O que este projeto exercita?
Este projeto foi focado em resolver o problema de **navegação circular** em listas, garantindo que o usuário possa navegar infinitamente pela playlist sem erros de índice.

### Conceitos Técnicos Aplicados:
- **Encapsulamento**: As classes `Musica` e `Playlist` protegem seus dados, expondo apenas o necessário via métodos públicos.

- **Lógica de Ponteiros** (Circular Indexing): Uso do operador de módulo (`%`) para criar um fluxo contínuo entre a última e a primeira música.

- **Collections (ArrayList)**: Gerenciamento dinâmico de objetos em memória.

- **Tratamento de Exceções**: Implementação de proteção contra entradas inválidas do usuário (InputMismatchException).

# 🛠️ Como Funciona a Lógica "Circular"
Diferente de uma lista linear comum, este player trata os dados como um anel.

- **Avançar**: `(atual + 1) % tamanho`

- **Voltar**: `(atual - 1 + tamanho) % tamanho`

Isso evita que o programa tente acessar um índice inexistente (como o índice -1 ou um índice maior que o tamanho da lista), o que é um erro comum em sistemas de software.
# 📋 Estrutura do Código

| Classe |  Responsabilidade
|:-----|:--------:|
| Musica   | "Modelo de dados (Título, Artista, Duração)"
| Playlist   |  Gerenciamento da lista e controle do "ponteiro" de execução.  |
| App   | Interface de usuário e loop principal do sistema. |


