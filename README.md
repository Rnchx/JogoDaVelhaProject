# Jogo da Velha em Java

Jogo da velha executado no terminal, com partidas entre um jogador humano e um jogador automático. Projeto acadêmico desenvolvido para praticar programação orientada a objetos em Java, a partir de uma estrutura fornecida pelo professor.

A implementação utiliza verificações explícitas com `if/else`, laços e uma matriz de objetos. O arquivo principal, `Velha.java`, foi preservado conforme fornecido.

## Funcionalidades

- Partidas em um tabuleiro de 3 × 3.
- Sorteio de quem começa a primeira partida.
- Escolha de X ou O pelo humano quando ele começa; quando o automático começa, sua marca é sorteada e o humano recebe a outra.
- Validação das entradas e das posições escolhidas.
- Bloqueio de jogadas em casas ocupadas.
- Identificação de vitória nas linhas, colunas e diagonais.
- Identificação de empate e opção de jogar novamente.
- Alternância de quem começa nas partidas seguintes.

## Estrutura do projeto

| Arquivo | Responsabilidade |
| --- | --- |
| `Velha.java` | Inicia o programa e controla o fluxo das partidas. |
| `jogador/Jogador.java` | Define os métodos comuns aos jogadores. |
| `jogador/JogadorHumano.java` | Lê as entradas do teclado e realiza as jogadas do usuário. |
| `jogador/JogadorAutomatico.java` | Escolhe as jogadas do computador. |
| `jogo/Marca.java` | Representa os símbolos e o resultado especial de empate. |
| `jogo/Tabuleiro.java` | Armazena as casas e valida o acesso ao tabuleiro. |
| `jogo/AnalistaSituacional.java` | Verifica o resultado e o encerramento da partida. |

Mantenha `Velha.java` na raiz do projeto e os demais arquivos nas pastas correspondentes aos seus pacotes: `jogador` e `jogo`.

## Requisitos

- JDK instalado, com os comandos `java` e `javac` disponíveis no terminal.
- Um terminal para compilar, executar e informar as jogadas.

O projeto foi compilado e testado com Java 17. Não utiliza bibliotecas externas, Maven ou Gradle.

## Como executar

Baixe ou clone o repositório e abra o terminal na pasta que contém `Velha.java`.

Compile o projeto:

```bash
javac -encoding UTF-8 -d out Velha.java
```

O compilador também compila as classes dos pacotes utilizadas pelo programa. Os arquivos `.class` são gerados na pasta `out`.

Execute:

```bash
java -cp out Velha
```

## Como jogar

1. O programa sorteia quem começa a primeira partida.
2. Se você começar, digite `X` ou `O` para escolher sua marca.
3. Na sua vez, informe a linha e depois a coluna, ambas entre `0` e `2`.
4. As jogadas se alternam até alguém completar uma linha, coluna ou diagonal, ou até o tabuleiro ficar cheio.
5. Ao final, digite `S` para jogar novamente ou `N` para encerrar.

Por exemplo, para jogar no centro, informe `1` para a linha e `1` para a coluna. Para o canto superior esquerdo, informe `0` e `0`.

Entradas como `x`, `o`, `s` e `n` também são aceitas. Uma coordenada inválida ou uma casa ocupada gera uma mensagem e uma nova solicitação de entrada.

## Estratégia do jogador automático

O computador verifica as possibilidades nesta ordem:

1. Completar uma sequência de três marcas próprias para vencer.
2. Impedir uma vitória imediata do adversário.
3. Acrescentar uma segunda marca própria em uma linha, coluna ou diagonal que não contenha marcas adversárias.
4. Ocupar a primeira casa livre, percorrendo o tabuleiro por linhas.

As verificações de linhas, colunas e diagonais estão escritas explicitamente no código. A estratégia não utiliza minimax e não garante que o computador seja invencível.

## Conceitos de orientação a objetos

- **Encapsulamento:** atributos privados e acesso por métodos.
- **Interface e polimorfismo:** `JogadorHumano` e `JogadorAutomatico` implementam `Jogador`.
- **Composição:** jogadores e analista trabalham com um objeto `Tabuleiro`, que armazena objetos `Marca`.
- **Tratamento de exceções:** validação de marcas, posições e argumentos inválidos.
- **`toString`:** representação textual dos objetos.
- **`equals` e `hashCode`:** comparação e cálculo de hash com base no estado dos objetos.
- **Construtor de cópia e `clone`:** cópias independentes de tabuleiros e jogadores.

Os jogadores de uma mesma partida compartilham o tabuleiro original. Ao copiar um jogador, a cópia recebe outro tabuleiro, independente do original. O leitor do teclado é compartilhado entre as instâncias de `JogadorHumano`.

`Marca` não possui métodos para alterar seu símbolo após a criação. Não foi implementado `compareTo`, pois o projeto não define uma ordenação natural para seus objetos.

## Tratamento do empate

Para manter `Velha.java` sem alterações, `Marca.getMarcaDeEmpate()` cria uma marca especial com o símbolo de espaço (`' '`). Essa marca representa somente o resultado e não pode ser inserida no tabuleiro.

O método `AnalistaSituacional.getMarcaDoVencedor()` retorna:

| Situação | Retorno |
| --- | --- |
| Partida em andamento | `null` |
| Vitória | Marca do vencedor, X ou O |
| Empate | Marca especial de empate |

O construtor público de `Marca` continua aceitando somente X ou O. A marca especial permite que as comparações com `equals` existentes no programa principal identifiquem o empate sem acessar uma referência nula.

## Validação

Durante o desenvolvimento, foram realizados:

- Compilação conjunta dos sete arquivos com as classes definitivas.
- Verificação de 22.186 cenários de jogada do automático.
- Verificação das 19.683 combinações de casas vazias, X e O no analista, incluindo configurações que não ocorrem em partidas válidas.
- Testes de entradas inválidas, posições, casas ocupadas, igualdade, hash e independência das cópias.
- Execução do `Velha.java` original em oito partidas empatadas, incluindo revanche e alternância de quem começa.

Esses testes foram executados durante o desenvolvimento; os scripts de teste não fazem parte dos sete arquivos do projeto.
