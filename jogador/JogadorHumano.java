package jogador;

import jogo.Marca;
import jogo.Tabuleiro;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class JogadorHumano implements Jogador, Cloneable
{
    private Marca     marca     = null;
    private Tabuleiro tabDoJogo = null;

    // Uma unica leitura de System.in, compartilhada entre partidas e copias.
    // Nao fechamos este leitor, pois isso fecharia a entrada do programa.
    private static final BufferedReader teclado =
        new BufferedReader(new InputStreamReader(System.in));

    public JogadorHumano (Tabuleiro tab) throws Exception
    {
        if (tab == null)
            throw new Exception("O tabuleiro deve ser informado.");

        this.tabDoJogo = tab;
        while (true)
        {
            System.out.print("Escolha sua marca (X ou O): ");
            String entrada = teclado.readLine();
            if (entrada == null)
                throw new IOException("A entrada foi encerrada.");

            if (entrada.length() == 1)
            {
                char simbolo = entrada.charAt(0);
                if (simbolo == 'x')
                    simbolo = 'X';
                if (simbolo == 'o')
                    simbolo = 'O';
                if (simbolo == 'X' || simbolo == 'O')
                {
                    this.marca = new Marca(simbolo);
                    return;
                }
            }
            System.out.println("Digite apenas X ou O.");
        }
    }

    public JogadorHumano (Tabuleiro tab, Marca mrc) throws Exception
    {
        if (tab == null || mrc == null)
            throw new Exception("Tabuleiro e marca devem ser informados.");

        this.tabDoJogo = tab;
        this.marca = new Marca(mrc.getSimbolo());
    }

    private int leiaCoordenada (String mensagem) throws IOException
    {
        while (true)
        {
            System.out.print(mensagem);
            String entrada = teclado.readLine();
            if (entrada == null)
                throw new IOException("A entrada foi encerrada.");

            // Conversao manual: '0' - '0' = 0, '1' - '0' = 1 etc.
            if (entrada.length() == 1)
            {
                char digito = entrada.charAt(0);
                if (digito >= '0' && digito <= '2')
                    return digito - '0';
            }
            System.out.println("Digite apenas 0, 1 ou 2.");
        }
    }

    @Override
    public void facaSuaJogada () throws Exception
    {
        boolean temCasaLivre = false;
        for (int linha = 0; linha < 3; linha++)
            for (int coluna = 0; coluna < 3; coluna++)
                if (!this.tabDoJogo.haMarcaNaPosicao(linha, coluna))
                    temCasaLivre = true;

        if (!temCasaLivre)
            throw new Exception("O tabuleiro esta cheio.");

        System.out.println(this.tabDoJogo);
        System.out.println("Sua marca: " + this.marca.getSimbolo());
        while (true)
        {
            int linha = this.leiaCoordenada("Linha (0 a 2): ");
            int coluna = this.leiaCoordenada("Coluna (0 a 2): ");
            if (this.tabDoJogo.haMarcaNaPosicao(linha, coluna))
            {
                System.out.println("Esta casa ja esta ocupada. Tente outra.");
                continue;
            }
            this.tabDoJogo.setMarcaNaPosicao(this.marca, linha, coluna);
            System.out.println(this.tabDoJogo);
            return;
        }
    }

    public void vcGanhou ()
    {
        System.out.println(this.tabDoJogo);
        System.out.println("Voce ganhou! Parabens!");
    }

    public void vcPerdeu ()
    {
        System.out.println(this.tabDoJogo);
        System.out.println("Voce perdeu!");
    }

    public void deuVelha ()
    {
        System.out.println(this.tabDoJogo);
        System.out.println("Deu velha! A partida terminou empatada.");
    }

    public boolean querMaisUmaPartida ()
    {
        while (true)
        {
            System.out.print("Deseja jogar novamente (S/N)? ");
            try
            {
                String entrada = teclado.readLine();
                if (entrada == null)
                    return false;
                if (entrada.length() == 1)
                {
                    char resposta = entrada.charAt(0);
                    if (resposta == 'S' || resposta == 's')
                        return true;
                    if (resposta == 'N' || resposta == 'n')
                        return false;
                }
                System.out.println("Digite apenas S ou N.");
            }
            catch (IOException erro)
            {
                System.out.println("Nao foi possivel ler a resposta: " + erro.getMessage());
                return false;
            }
        }
    }

    @Override
    public Marca getMarca ()
    {
        return this.marca;
    }

    @Override
    public String toString ()
    {
        return "JogadorHumano [marca=" + this.marca.getSimbolo()
             + ", tabuleiro=" + this.tabDoJogo + "]";
    }

    // Igualdade por estado: mesmo tipo, mesma marca e mesmas casas.
    // O teclado nao faz parte do estado de uma partida.
    @Override
    public boolean equals (Object obj)
    {
        if (this == obj)
            return true;

        if (obj == null)
            return false;

        if (this.getClass() != obj.getClass())
            return false;

        JogadorHumano outro = (JogadorHumano)obj;

        if (!this.marca.equals(outro.marca))
            return false;

        if (!this.tabDoJogo.equals(outro.tabDoJogo))
            return false;

        return true;
    }

    @Override
    public int hashCode ()
    {
        int ret = 17;

        ret = 31 * ret + this.marca.hashCode();
        ret = 31 * ret + this.tabDoJogo.hashCode();

        return ret;
    }

    // Copia profunda: a copia recebe um tabuleiro independente do original.
    public JogadorHumano (JogadorHumano modelo) throws Exception
    {
        if (modelo == null)
            throw new Exception("Modelo ausente.");

        this.marca = modelo.marca;
        this.tabDoJogo = new Tabuleiro(modelo.tabDoJogo);
    }

    @Override
    public Object clone ()
    {
        JogadorHumano ret = null;

        try
        {
            ret = new JogadorHumano(this);
        }
        catch (Exception erro)
        {
            throw new IllegalStateException(
                "Nao foi possivel copiar o jogador.", erro);
        }

        return ret;
    }
}
