package jogo;

public class AnalistaSituacional
{
    private Tabuleiro tabDoJogo;

    public AnalistaSituacional (Tabuleiro tab) throws Exception
    {
        if (tab == null)
            throw new Exception("O tabuleiro deve ser informado.");

        this.tabDoJogo = tab;
    }

    public Marca getMarcaDoVencedor ()
    {
        try
        {
            // Verificar a linha 0.
            if (this.tabDoJogo.haMarcaNaPosicao(0,0) &&
                this.tabDoJogo.haMarcaNaPosicao(0,1) &&
                this.tabDoJogo.haMarcaNaPosicao(0,2) &&
                this.tabDoJogo.getMarcaNaPosicao(0,0).equals(this.tabDoJogo.getMarcaNaPosicao(0,1)) &&
                this.tabDoJogo.getMarcaNaPosicao(0,0).equals(this.tabDoJogo.getMarcaNaPosicao(0,2)))
                return this.tabDoJogo.getMarcaNaPosicao(0,0);

            // Verificar a linha 1.
            if (this.tabDoJogo.haMarcaNaPosicao(1,0) &&
                this.tabDoJogo.haMarcaNaPosicao(1,1) &&
                this.tabDoJogo.haMarcaNaPosicao(1,2) &&
                this.tabDoJogo.getMarcaNaPosicao(1,0).equals(this.tabDoJogo.getMarcaNaPosicao(1,1)) &&
                this.tabDoJogo.getMarcaNaPosicao(1,0).equals(this.tabDoJogo.getMarcaNaPosicao(1,2)))
                return this.tabDoJogo.getMarcaNaPosicao(1,0);

            // Verificar a linha 2.
            if (this.tabDoJogo.haMarcaNaPosicao(2,0) &&
                this.tabDoJogo.haMarcaNaPosicao(2,1) &&
                this.tabDoJogo.haMarcaNaPosicao(2,2) &&
                this.tabDoJogo.getMarcaNaPosicao(2,0).equals(this.tabDoJogo.getMarcaNaPosicao(2,1)) &&
                this.tabDoJogo.getMarcaNaPosicao(2,0).equals(this.tabDoJogo.getMarcaNaPosicao(2,2)))
                return this.tabDoJogo.getMarcaNaPosicao(2,0);

            // Verificar a coluna 0.
            if (this.tabDoJogo.haMarcaNaPosicao(0,0) &&
                this.tabDoJogo.haMarcaNaPosicao(1,0) &&
                this.tabDoJogo.haMarcaNaPosicao(2,0) &&
                this.tabDoJogo.getMarcaNaPosicao(0,0).equals(this.tabDoJogo.getMarcaNaPosicao(1,0)) &&
                this.tabDoJogo.getMarcaNaPosicao(0,0).equals(this.tabDoJogo.getMarcaNaPosicao(2,0)))
                return this.tabDoJogo.getMarcaNaPosicao(0,0);

            // Verificar a coluna 1.
            if (this.tabDoJogo.haMarcaNaPosicao(0,1) &&
                this.tabDoJogo.haMarcaNaPosicao(1,1) &&
                this.tabDoJogo.haMarcaNaPosicao(2,1) &&
                this.tabDoJogo.getMarcaNaPosicao(0,1).equals(this.tabDoJogo.getMarcaNaPosicao(1,1)) &&
                this.tabDoJogo.getMarcaNaPosicao(0,1).equals(this.tabDoJogo.getMarcaNaPosicao(2,1)))
                return this.tabDoJogo.getMarcaNaPosicao(0,1);

            // Verificar a coluna 2.
            if (this.tabDoJogo.haMarcaNaPosicao(0,2) &&
                this.tabDoJogo.haMarcaNaPosicao(1,2) &&
                this.tabDoJogo.haMarcaNaPosicao(2,2) &&
                this.tabDoJogo.getMarcaNaPosicao(0,2).equals(this.tabDoJogo.getMarcaNaPosicao(1,2)) &&
                this.tabDoJogo.getMarcaNaPosicao(0,2).equals(this.tabDoJogo.getMarcaNaPosicao(2,2)))
                return this.tabDoJogo.getMarcaNaPosicao(0,2);

            // Verificar a diagonal principal.
            if (this.tabDoJogo.haMarcaNaPosicao(0,0) &&
                this.tabDoJogo.haMarcaNaPosicao(1,1) &&
                this.tabDoJogo.haMarcaNaPosicao(2,2) &&
                this.tabDoJogo.getMarcaNaPosicao(0,0).equals(this.tabDoJogo.getMarcaNaPosicao(1,1)) &&
                this.tabDoJogo.getMarcaNaPosicao(0,0).equals(this.tabDoJogo.getMarcaNaPosicao(2,2)))
                return this.tabDoJogo.getMarcaNaPosicao(0,0);

            // Verificar a diagonal secundaria.
            if (this.tabDoJogo.haMarcaNaPosicao(0,2) &&
                this.tabDoJogo.haMarcaNaPosicao(1,1) &&
                this.tabDoJogo.haMarcaNaPosicao(2,0) &&
                this.tabDoJogo.getMarcaNaPosicao(0,2).equals(this.tabDoJogo.getMarcaNaPosicao(1,1)) &&
                this.tabDoJogo.getMarcaNaPosicao(0,2).equals(this.tabDoJogo.getMarcaNaPosicao(2,0)))
                return this.tabDoJogo.getMarcaNaPosicao(0,2);

            // Velha.java compara o resultado com equals, inclusive no empate.
            if (this.tabuleiroCheio())
                return Marca.getMarcaDeEmpate();

            // Sem vencedor e com casas livres, a partida continua.
            return null;
        }
        catch (Exception erro)
        {
            throw new IllegalStateException("Nao foi possivel verificar o vencedor.", erro);
        }
    }

    private boolean tabuleiroCheio ()
    {
        try
        {
            for (int linha = 0; linha < 3; linha++)
                for (int coluna = 0; coluna < 3; coluna++)
                    if (!this.tabDoJogo.haMarcaNaPosicao(linha, coluna))
                        return false;

            return true;
        }
        catch (Exception erro)
        {
            throw new IllegalStateException("Nao foi possivel verificar o tabuleiro.", erro);
        }
    }

    public boolean fimDeJogo ()
    {
        if (this.getMarcaDoVencedor() != null)
            return true;

        if (this.tabuleiroCheio())
            return true;

        return false;
    }

    @Override
    public String toString ()
    {
        Marca vencedor = this.getMarcaDoVencedor();

        if (vencedor != null)
        {
            if (vencedor.getSimbolo() == ' ')
                return "Deu velha!";

            return "Vencedor: " + vencedor.getSimbolo();
        }

        return "Partida em andamento.";
    }

    @Override
    public boolean equals (Object obj)
    {
        if (this == obj)
            return true;

        if (obj == null)
            return false;

        if (this.getClass() != obj.getClass())
            return false;

        AnalistaSituacional outro = (AnalistaSituacional)obj;

        // Comparar cada casa, sem depender do equals de Tabuleiro.
        try
        {
            for (int linha = 0; linha < 3; linha++)
                for (int coluna = 0; coluna < 3; coluna++)
                {
                    boolean ocupada = this.tabDoJogo.haMarcaNaPosicao(linha, coluna);
                    boolean outraOcupada = outro.tabDoJogo.haMarcaNaPosicao(linha, coluna);

                    if (ocupada != outraOcupada)
                        return false;

                    if (ocupada)
                    {
                        char simbolo = this.tabDoJogo.getMarcaNaPosicao(linha, coluna).getSimbolo();
                        char outroSimbolo = outro.tabDoJogo.getMarcaNaPosicao(linha, coluna).getSimbolo();

                        if (simbolo != outroSimbolo)
                            return false;
                    }
                }

            return true;
        }
        catch (Exception erro)
        {
            throw new IllegalStateException("Nao foi possivel comparar os tabuleiros.", erro);
        }
    }

    @Override
    public int hashCode ()
    {
        int resultado = 17;

        // Usar os mesmos dados considerados no equals.
        try
        {
            for (int linha = 0; linha < 3; linha++)
                for (int coluna = 0; coluna < 3; coluna++)
                {
                    int simbolo = 0;

                    if (this.tabDoJogo.haMarcaNaPosicao(linha, coluna))
                        simbolo = this.tabDoJogo.getMarcaNaPosicao(linha, coluna).getSimbolo();

                    resultado = 31 * resultado + simbolo;
                }

            return resultado;
        }
        catch (Exception erro)
        {
            throw new IllegalStateException("Nao foi possivel calcular o hash.", erro);
        }
    }
}
