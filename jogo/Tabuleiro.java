package jogo;

public class Tabuleiro implements Cloneable
{
    // A principio, todas as casas sao null.
    private Marca matriz [][];

    public Tabuleiro ()
    {
        this.matriz = new Marca [3][3];
    }

    public boolean haMarcaNaPosicao (int lin, int col) throws Exception
    {
        if (lin < 0 || lin > 2)
            throw new Exception("Linha invalida.");

        if (col < 0 || col > 2)
            throw new Exception("Coluna invalida.");

        if (this.matriz[lin][col] == null)
            return false;

        return true;
    }

    public Marca getMarcaNaPosicao (int lin, int col) throws Exception
    {
        if (lin < 0 || lin > 2)
            throw new Exception("Linha invalida.");

        if (col < 0 || col > 2)
            throw new Exception("Coluna invalida.");

        // Marca nao possui metodos que alterem seu simbolo.
        return this.matriz[lin][col];
    }

    public void setMarcaNaPosicao (Marca mrc, int lin, int col) throws Exception
    {
        if (lin < 0 || lin > 2)
            throw new Exception("Linha invalida.");

        if (col < 0 || col > 2)
            throw new Exception("Coluna invalida.");

        if (mrc == null)
            throw new Exception("A marca deve ser informada.");

        // A marca de empate representa um resultado, nunca uma jogada.
        if (mrc.getSimbolo() != 'X' && mrc.getSimbolo() != 'O')
            throw new Exception("Somente X ou O podem ocupar uma casa.");

        if (this.matriz[lin][col] != null)
            throw new Exception("Esta casa ja esta ocupada.");

        this.matriz[lin][col] = mrc;
    }

    @Override
    public String toString ()
    {
        String texto = "    0   1   2\n";

        for (int linha = 0; linha < 3; linha++)
        {
            texto = texto + linha + "   ";

            for (int coluna = 0; coluna < 3; coluna++)
            {
                if (this.matriz[linha][coluna] == null)
                    texto = texto + " ";
                else
                    texto = texto + this.matriz[linha][coluna].getSimbolo();

                if (coluna < 2)
                    texto = texto + " | ";
            }

            texto = texto + "\n";

            if (linha < 2)
                texto = texto + "   ---+---+---\n";
        }

        return texto;
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

        Tabuleiro outro = (Tabuleiro)obj;

        for (int linha = 0; linha < 3; linha++)
            for (int coluna = 0; coluna < 3; coluna++)
            {
                if (this.matriz[linha][coluna] == null)
                {
                    if (outro.matriz[linha][coluna] != null)
                        return false;
                }
                else
                {
                    if (!this.matriz[linha][coluna].equals(outro.matriz[linha][coluna]))
                        return false;
                }
            }

        return true;
    }

    @Override
    public int hashCode ()
    {
        int resultado = 17;

        for (int linha = 0; linha < 3; linha++)
            for (int coluna = 0; coluna < 3; coluna++)
            {
                int codigo = 0;

                if (this.matriz[linha][coluna] != null)
                    codigo = this.matriz[linha][coluna].hashCode();

                resultado = 31 * resultado + codigo;
            }

        return resultado;
    }

    // Cria uma matriz independente.
    // As marcas podem ser compartilhadas porque seus simbolos nao sao alterados.
    public Tabuleiro (Tabuleiro modelo) throws Exception
    {
        if (modelo == null)
            throw new Exception("Modelo ausente.");

        this.matriz = new Marca[3][3];

        for (int linha = 0; linha < 3; linha++)
            for (int coluna = 0; coluna < 3; coluna++)
                this.matriz[linha][coluna] =
                    modelo.matriz[linha][coluna];
    }

    @Override
    public Object clone ()
    {
        Tabuleiro ret = null;

        try
        {
            ret = new Tabuleiro(this);
        }
        catch (Exception erro)
        {
            throw new IllegalStateException(
                "Nao foi possivel copiar o tabuleiro.", erro);
        }

        return ret;
    }
}
