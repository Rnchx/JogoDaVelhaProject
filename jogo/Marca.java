package jogo;

public class Marca
{
    private char simbolo;

    public Marca (char smb) throws Exception
    {
        if (smb != 'X' && smb != 'O')
            throw new Exception("A marca deve ser X ou O.");

        this.simbolo = smb;
    }

    // Uso exclusivo do resultado de empate, sem alterar o construtor acima.
    private Marca ()
    {
        this.simbolo = ' ';
    }

    public static Marca getMarcaDeEmpate ()
    {
        return new Marca();
    }

    public char getSimbolo ()
    {
        return this.simbolo;
    }

    @Override
    public String toString ()
    {
        return "" + this.simbolo;
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

        Marca outra = (Marca)obj;

        if (this.simbolo != outra.simbolo)
            return false;

        return true;
    }

    @Override
    public int hashCode ()
    {
        int resultado = 17;
        resultado = 31 * resultado + this.simbolo;
        return resultado;
    }
}
