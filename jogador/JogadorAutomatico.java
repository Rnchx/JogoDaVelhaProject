package jogador;

import jogo.Marca;
import jogo.Tabuleiro;

public class JogadorAutomatico implements Jogador, Cloneable
{
    private Marca     marca     = null;
    private Tabuleiro tabDoJogo = null;

    public JogadorAutomatico (Tabuleiro tab) throws Exception
    {
        if (tab == null)
            throw new Exception("O tabuleiro deve ser informado.");

        tabDoJogo = tab;

        // Fazer o jogador escolher sua marca por sorteio.
        if ((int)(Math.random()*2) == 0)
            marca = new Marca('X');
        else
            marca = new Marca('O');
    }

    public JogadorAutomatico (Tabuleiro tab, Marca mrc) throws Exception
    {
        if (tab == null || mrc == null)
            throw new Exception("Tabuleiro e marca devem ser informados.");

        // Os dois jogadores da partida precisam usar o MESMO tabuleiro.
        this.tabDoJogo = tab;
        this.marca = new Marca(mrc.getSimbolo());
    }

    @Override
    public void facaSuaJogada () throws Exception
    {
        // Tentando ganhar na linha 0.
        if (!this.tabDoJogo.haMarcaNaPosicao(0,0) &&
            this.tabDoJogo.haMarcaNaPosicao(0,1) && this.tabDoJogo.getMarcaNaPosicao(0,1).equals(this.marca) &&
            this.tabDoJogo.haMarcaNaPosicao(0,2) && this.tabDoJogo.getMarcaNaPosicao(0,2).equals(this.marca))
            this.tabDoJogo.setMarcaNaPosicao(this.marca, 0,0);
        else
        if (this.tabDoJogo.haMarcaNaPosicao(0,0) && this.tabDoJogo.getMarcaNaPosicao(0,0).equals(this.marca) &&
            !this.tabDoJogo.haMarcaNaPosicao(0,1) &&
            this.tabDoJogo.haMarcaNaPosicao(0,2) && this.tabDoJogo.getMarcaNaPosicao(0,2).equals(this.marca))
            this.tabDoJogo.setMarcaNaPosicao(this.marca, 0,1);
        else
        if (this.tabDoJogo.haMarcaNaPosicao(0,0) && this.tabDoJogo.getMarcaNaPosicao(0,0).equals(this.marca) &&
            this.tabDoJogo.haMarcaNaPosicao(0,1) && this.tabDoJogo.getMarcaNaPosicao(0,1).equals(this.marca) &&
            !this.tabDoJogo.haMarcaNaPosicao(0,2))
            this.tabDoJogo.setMarcaNaPosicao(this.marca, 0,2);
        else
        // Tentando ganhar na linha 1.
        if (!this.tabDoJogo.haMarcaNaPosicao(1,0) &&
            this.tabDoJogo.haMarcaNaPosicao(1,1) && this.tabDoJogo.getMarcaNaPosicao(1,1).equals(this.marca) &&
            this.tabDoJogo.haMarcaNaPosicao(1,2) && this.tabDoJogo.getMarcaNaPosicao(1,2).equals(this.marca))
            this.tabDoJogo.setMarcaNaPosicao(this.marca, 1,0);
        else
        if (this.tabDoJogo.haMarcaNaPosicao(1,0) && this.tabDoJogo.getMarcaNaPosicao(1,0).equals(this.marca) &&
            !this.tabDoJogo.haMarcaNaPosicao(1,1) &&
            this.tabDoJogo.haMarcaNaPosicao(1,2) && this.tabDoJogo.getMarcaNaPosicao(1,2).equals(this.marca))
            this.tabDoJogo.setMarcaNaPosicao(this.marca, 1,1);
        else
        if (this.tabDoJogo.haMarcaNaPosicao(1,0) && this.tabDoJogo.getMarcaNaPosicao(1,0).equals(this.marca) &&
            this.tabDoJogo.haMarcaNaPosicao(1,1) && this.tabDoJogo.getMarcaNaPosicao(1,1).equals(this.marca) &&
            !this.tabDoJogo.haMarcaNaPosicao(1,2))
            this.tabDoJogo.setMarcaNaPosicao(this.marca, 1,2);
        else
        // Tentando ganhar na linha 2.
        if (!this.tabDoJogo.haMarcaNaPosicao(2,0) &&
            this.tabDoJogo.haMarcaNaPosicao(2,1) && this.tabDoJogo.getMarcaNaPosicao(2,1).equals(this.marca) &&
            this.tabDoJogo.haMarcaNaPosicao(2,2) && this.tabDoJogo.getMarcaNaPosicao(2,2).equals(this.marca))
            this.tabDoJogo.setMarcaNaPosicao(this.marca, 2,0);
        else
        if (this.tabDoJogo.haMarcaNaPosicao(2,0) && this.tabDoJogo.getMarcaNaPosicao(2,0).equals(this.marca) &&
            !this.tabDoJogo.haMarcaNaPosicao(2,1) &&
            this.tabDoJogo.haMarcaNaPosicao(2,2) && this.tabDoJogo.getMarcaNaPosicao(2,2).equals(this.marca))
            this.tabDoJogo.setMarcaNaPosicao(this.marca, 2,1);
        else
        if (this.tabDoJogo.haMarcaNaPosicao(2,0) && this.tabDoJogo.getMarcaNaPosicao(2,0).equals(this.marca) &&
            this.tabDoJogo.haMarcaNaPosicao(2,1) && this.tabDoJogo.getMarcaNaPosicao(2,1).equals(this.marca) &&
            !this.tabDoJogo.haMarcaNaPosicao(2,2))
            this.tabDoJogo.setMarcaNaPosicao(this.marca, 2,2);
        else
        // Tentando ganhar na coluna 0.
        if (!this.tabDoJogo.haMarcaNaPosicao(0,0) &&
            this.tabDoJogo.haMarcaNaPosicao(1,0) && this.tabDoJogo.getMarcaNaPosicao(1,0).equals(this.marca) &&
            this.tabDoJogo.haMarcaNaPosicao(2,0) && this.tabDoJogo.getMarcaNaPosicao(2,0).equals(this.marca))
            this.tabDoJogo.setMarcaNaPosicao(this.marca, 0,0);
        else
        if (this.tabDoJogo.haMarcaNaPosicao(0,0) && this.tabDoJogo.getMarcaNaPosicao(0,0).equals(this.marca) &&
            !this.tabDoJogo.haMarcaNaPosicao(1,0) &&
            this.tabDoJogo.haMarcaNaPosicao(2,0) && this.tabDoJogo.getMarcaNaPosicao(2,0).equals(this.marca))
            this.tabDoJogo.setMarcaNaPosicao(this.marca, 1,0);
        else
        if (this.tabDoJogo.haMarcaNaPosicao(0,0) && this.tabDoJogo.getMarcaNaPosicao(0,0).equals(this.marca) &&
            this.tabDoJogo.haMarcaNaPosicao(1,0) && this.tabDoJogo.getMarcaNaPosicao(1,0).equals(this.marca) &&
            !this.tabDoJogo.haMarcaNaPosicao(2,0))
            this.tabDoJogo.setMarcaNaPosicao(this.marca, 2,0);
        else
        // Tentando ganhar na coluna 1.
        if (!this.tabDoJogo.haMarcaNaPosicao(0,1) &&
            this.tabDoJogo.haMarcaNaPosicao(1,1) && this.tabDoJogo.getMarcaNaPosicao(1,1).equals(this.marca) &&
            this.tabDoJogo.haMarcaNaPosicao(2,1) && this.tabDoJogo.getMarcaNaPosicao(2,1).equals(this.marca))
            this.tabDoJogo.setMarcaNaPosicao(this.marca, 0,1);
        else
        if (this.tabDoJogo.haMarcaNaPosicao(0,1) && this.tabDoJogo.getMarcaNaPosicao(0,1).equals(this.marca) &&
            !this.tabDoJogo.haMarcaNaPosicao(1,1) &&
            this.tabDoJogo.haMarcaNaPosicao(2,1) && this.tabDoJogo.getMarcaNaPosicao(2,1).equals(this.marca))
            this.tabDoJogo.setMarcaNaPosicao(this.marca, 1,1);
        else
        if (this.tabDoJogo.haMarcaNaPosicao(0,1) && this.tabDoJogo.getMarcaNaPosicao(0,1).equals(this.marca) &&
            this.tabDoJogo.haMarcaNaPosicao(1,1) && this.tabDoJogo.getMarcaNaPosicao(1,1).equals(this.marca) &&
            !this.tabDoJogo.haMarcaNaPosicao(2,1))
            this.tabDoJogo.setMarcaNaPosicao(this.marca, 2,1);
        else
        // Tentando ganhar na coluna 2.
        if (!this.tabDoJogo.haMarcaNaPosicao(0,2) &&
            this.tabDoJogo.haMarcaNaPosicao(1,2) && this.tabDoJogo.getMarcaNaPosicao(1,2).equals(this.marca) &&
            this.tabDoJogo.haMarcaNaPosicao(2,2) && this.tabDoJogo.getMarcaNaPosicao(2,2).equals(this.marca))
            this.tabDoJogo.setMarcaNaPosicao(this.marca, 0,2);
        else
        if (this.tabDoJogo.haMarcaNaPosicao(0,2) && this.tabDoJogo.getMarcaNaPosicao(0,2).equals(this.marca) &&
            !this.tabDoJogo.haMarcaNaPosicao(1,2) &&
            this.tabDoJogo.haMarcaNaPosicao(2,2) && this.tabDoJogo.getMarcaNaPosicao(2,2).equals(this.marca))
            this.tabDoJogo.setMarcaNaPosicao(this.marca, 1,2);
        else
        if (this.tabDoJogo.haMarcaNaPosicao(0,2) && this.tabDoJogo.getMarcaNaPosicao(0,2).equals(this.marca) &&
            this.tabDoJogo.haMarcaNaPosicao(1,2) && this.tabDoJogo.getMarcaNaPosicao(1,2).equals(this.marca) &&
            !this.tabDoJogo.haMarcaNaPosicao(2,2))
            this.tabDoJogo.setMarcaNaPosicao(this.marca, 2,2);
        else
        // Tentando ganhar na diagonal principal.
        if (!this.tabDoJogo.haMarcaNaPosicao(0,0) &&
            this.tabDoJogo.haMarcaNaPosicao(1,1) && this.tabDoJogo.getMarcaNaPosicao(1,1).equals(this.marca) &&
            this.tabDoJogo.haMarcaNaPosicao(2,2) && this.tabDoJogo.getMarcaNaPosicao(2,2).equals(this.marca))
            this.tabDoJogo.setMarcaNaPosicao(this.marca, 0,0);
        else
        if (this.tabDoJogo.haMarcaNaPosicao(0,0) && this.tabDoJogo.getMarcaNaPosicao(0,0).equals(this.marca) &&
            !this.tabDoJogo.haMarcaNaPosicao(1,1) &&
            this.tabDoJogo.haMarcaNaPosicao(2,2) && this.tabDoJogo.getMarcaNaPosicao(2,2).equals(this.marca))
            this.tabDoJogo.setMarcaNaPosicao(this.marca, 1,1);
        else
        if (this.tabDoJogo.haMarcaNaPosicao(0,0) && this.tabDoJogo.getMarcaNaPosicao(0,0).equals(this.marca) &&
            this.tabDoJogo.haMarcaNaPosicao(1,1) && this.tabDoJogo.getMarcaNaPosicao(1,1).equals(this.marca) &&
            !this.tabDoJogo.haMarcaNaPosicao(2,2))
            this.tabDoJogo.setMarcaNaPosicao(this.marca, 2,2);
        else
        // Tentando ganhar na diagonal secundaria.
        if (!this.tabDoJogo.haMarcaNaPosicao(0,2) &&
            this.tabDoJogo.haMarcaNaPosicao(1,1) && this.tabDoJogo.getMarcaNaPosicao(1,1).equals(this.marca) &&
            this.tabDoJogo.haMarcaNaPosicao(2,0) && this.tabDoJogo.getMarcaNaPosicao(2,0).equals(this.marca))
            this.tabDoJogo.setMarcaNaPosicao(this.marca, 0,2);
        else
        if (this.tabDoJogo.haMarcaNaPosicao(0,2) && this.tabDoJogo.getMarcaNaPosicao(0,2).equals(this.marca) &&
            !this.tabDoJogo.haMarcaNaPosicao(1,1) &&
            this.tabDoJogo.haMarcaNaPosicao(2,0) && this.tabDoJogo.getMarcaNaPosicao(2,0).equals(this.marca))
            this.tabDoJogo.setMarcaNaPosicao(this.marca, 1,1);
        else
        if (this.tabDoJogo.haMarcaNaPosicao(0,2) && this.tabDoJogo.getMarcaNaPosicao(0,2).equals(this.marca) &&
            this.tabDoJogo.haMarcaNaPosicao(1,1) && this.tabDoJogo.getMarcaNaPosicao(1,1).equals(this.marca) &&
            !this.tabDoJogo.haMarcaNaPosicao(2,0))
            this.tabDoJogo.setMarcaNaPosicao(this.marca, 2,0);
        else
        // Tentando atrapalhar a vitoria do adversario na linha 0.
        if (!this.tabDoJogo.haMarcaNaPosicao(0,0) &&
            this.tabDoJogo.haMarcaNaPosicao(0,1) && !this.tabDoJogo.getMarcaNaPosicao(0,1).equals(this.marca) &&
            this.tabDoJogo.haMarcaNaPosicao(0,2) && !this.tabDoJogo.getMarcaNaPosicao(0,2).equals(this.marca))
            this.tabDoJogo.setMarcaNaPosicao(this.marca, 0,0);
        else
        if (this.tabDoJogo.haMarcaNaPosicao(0,0) && !this.tabDoJogo.getMarcaNaPosicao(0,0).equals(this.marca) &&
            !this.tabDoJogo.haMarcaNaPosicao(0,1) &&
            this.tabDoJogo.haMarcaNaPosicao(0,2) && !this.tabDoJogo.getMarcaNaPosicao(0,2).equals(this.marca))
            this.tabDoJogo.setMarcaNaPosicao(this.marca, 0,1);
        else
        if (this.tabDoJogo.haMarcaNaPosicao(0,0) && !this.tabDoJogo.getMarcaNaPosicao(0,0).equals(this.marca) &&
            this.tabDoJogo.haMarcaNaPosicao(0,1) && !this.tabDoJogo.getMarcaNaPosicao(0,1).equals(this.marca) &&
            !this.tabDoJogo.haMarcaNaPosicao(0,2))
            this.tabDoJogo.setMarcaNaPosicao(this.marca, 0,2);
        else
        // Tentando atrapalhar a vitoria do adversario na linha 1.
        if (!this.tabDoJogo.haMarcaNaPosicao(1,0) &&
            this.tabDoJogo.haMarcaNaPosicao(1,1) && !this.tabDoJogo.getMarcaNaPosicao(1,1).equals(this.marca) &&
            this.tabDoJogo.haMarcaNaPosicao(1,2) && !this.tabDoJogo.getMarcaNaPosicao(1,2).equals(this.marca))
            this.tabDoJogo.setMarcaNaPosicao(this.marca, 1,0);
        else
        if (this.tabDoJogo.haMarcaNaPosicao(1,0) && !this.tabDoJogo.getMarcaNaPosicao(1,0).equals(this.marca) &&
            !this.tabDoJogo.haMarcaNaPosicao(1,1) &&
            this.tabDoJogo.haMarcaNaPosicao(1,2) && !this.tabDoJogo.getMarcaNaPosicao(1,2).equals(this.marca))
            this.tabDoJogo.setMarcaNaPosicao(this.marca, 1,1);
        else
        if (this.tabDoJogo.haMarcaNaPosicao(1,0) && !this.tabDoJogo.getMarcaNaPosicao(1,0).equals(this.marca) &&
            this.tabDoJogo.haMarcaNaPosicao(1,1) && !this.tabDoJogo.getMarcaNaPosicao(1,1).equals(this.marca) &&
            !this.tabDoJogo.haMarcaNaPosicao(1,2))
            this.tabDoJogo.setMarcaNaPosicao(this.marca, 1,2);
        else
        // Tentando atrapalhar a vitoria do adversario na linha 2.
        if (!this.tabDoJogo.haMarcaNaPosicao(2,0) &&
            this.tabDoJogo.haMarcaNaPosicao(2,1) && !this.tabDoJogo.getMarcaNaPosicao(2,1).equals(this.marca) &&
            this.tabDoJogo.haMarcaNaPosicao(2,2) && !this.tabDoJogo.getMarcaNaPosicao(2,2).equals(this.marca))
            this.tabDoJogo.setMarcaNaPosicao(this.marca, 2,0);
        else
        if (this.tabDoJogo.haMarcaNaPosicao(2,0) && !this.tabDoJogo.getMarcaNaPosicao(2,0).equals(this.marca) &&
            !this.tabDoJogo.haMarcaNaPosicao(2,1) &&
            this.tabDoJogo.haMarcaNaPosicao(2,2) && !this.tabDoJogo.getMarcaNaPosicao(2,2).equals(this.marca))
            this.tabDoJogo.setMarcaNaPosicao(this.marca, 2,1);
        else
        if (this.tabDoJogo.haMarcaNaPosicao(2,0) && !this.tabDoJogo.getMarcaNaPosicao(2,0).equals(this.marca) &&
            this.tabDoJogo.haMarcaNaPosicao(2,1) && !this.tabDoJogo.getMarcaNaPosicao(2,1).equals(this.marca) &&
            !this.tabDoJogo.haMarcaNaPosicao(2,2))
            this.tabDoJogo.setMarcaNaPosicao(this.marca, 2,2);
        else
        // Tentando atrapalhar a vitoria do adversario na coluna 0.
        if (!this.tabDoJogo.haMarcaNaPosicao(0,0) &&
            this.tabDoJogo.haMarcaNaPosicao(1,0) && !this.tabDoJogo.getMarcaNaPosicao(1,0).equals(this.marca) &&
            this.tabDoJogo.haMarcaNaPosicao(2,0) && !this.tabDoJogo.getMarcaNaPosicao(2,0).equals(this.marca))
            this.tabDoJogo.setMarcaNaPosicao(this.marca, 0,0);
        else
        if (this.tabDoJogo.haMarcaNaPosicao(0,0) && !this.tabDoJogo.getMarcaNaPosicao(0,0).equals(this.marca) &&
            !this.tabDoJogo.haMarcaNaPosicao(1,0) &&
            this.tabDoJogo.haMarcaNaPosicao(2,0) && !this.tabDoJogo.getMarcaNaPosicao(2,0).equals(this.marca))
            this.tabDoJogo.setMarcaNaPosicao(this.marca, 1,0);
        else
        if (this.tabDoJogo.haMarcaNaPosicao(0,0) && !this.tabDoJogo.getMarcaNaPosicao(0,0).equals(this.marca) &&
            this.tabDoJogo.haMarcaNaPosicao(1,0) && !this.tabDoJogo.getMarcaNaPosicao(1,0).equals(this.marca) &&
            !this.tabDoJogo.haMarcaNaPosicao(2,0))
            this.tabDoJogo.setMarcaNaPosicao(this.marca, 2,0);
        else
        // Tentando atrapalhar a vitoria do adversario na coluna 1.
        if (!this.tabDoJogo.haMarcaNaPosicao(0,1) &&
            this.tabDoJogo.haMarcaNaPosicao(1,1) && !this.tabDoJogo.getMarcaNaPosicao(1,1).equals(this.marca) &&
            this.tabDoJogo.haMarcaNaPosicao(2,1) && !this.tabDoJogo.getMarcaNaPosicao(2,1).equals(this.marca))
            this.tabDoJogo.setMarcaNaPosicao(this.marca, 0,1);
        else
        if (this.tabDoJogo.haMarcaNaPosicao(0,1) && !this.tabDoJogo.getMarcaNaPosicao(0,1).equals(this.marca) &&
            !this.tabDoJogo.haMarcaNaPosicao(1,1) &&
            this.tabDoJogo.haMarcaNaPosicao(2,1) && !this.tabDoJogo.getMarcaNaPosicao(2,1).equals(this.marca))
            this.tabDoJogo.setMarcaNaPosicao(this.marca, 1,1);
        else
        if (this.tabDoJogo.haMarcaNaPosicao(0,1) && !this.tabDoJogo.getMarcaNaPosicao(0,1).equals(this.marca) &&
            this.tabDoJogo.haMarcaNaPosicao(1,1) && !this.tabDoJogo.getMarcaNaPosicao(1,1).equals(this.marca) &&
            !this.tabDoJogo.haMarcaNaPosicao(2,1))
            this.tabDoJogo.setMarcaNaPosicao(this.marca, 2,1);
        else
        // Tentando atrapalhar a vitoria do adversario na coluna 2.
        if (!this.tabDoJogo.haMarcaNaPosicao(0,2) &&
            this.tabDoJogo.haMarcaNaPosicao(1,2) && !this.tabDoJogo.getMarcaNaPosicao(1,2).equals(this.marca) &&
            this.tabDoJogo.haMarcaNaPosicao(2,2) && !this.tabDoJogo.getMarcaNaPosicao(2,2).equals(this.marca))
            this.tabDoJogo.setMarcaNaPosicao(this.marca, 0,2);
        else
        if (this.tabDoJogo.haMarcaNaPosicao(0,2) && !this.tabDoJogo.getMarcaNaPosicao(0,2).equals(this.marca) &&
            !this.tabDoJogo.haMarcaNaPosicao(1,2) &&
            this.tabDoJogo.haMarcaNaPosicao(2,2) && !this.tabDoJogo.getMarcaNaPosicao(2,2).equals(this.marca))
            this.tabDoJogo.setMarcaNaPosicao(this.marca, 1,2);
        else
        if (this.tabDoJogo.haMarcaNaPosicao(0,2) && !this.tabDoJogo.getMarcaNaPosicao(0,2).equals(this.marca) &&
            this.tabDoJogo.haMarcaNaPosicao(1,2) && !this.tabDoJogo.getMarcaNaPosicao(1,2).equals(this.marca) &&
            !this.tabDoJogo.haMarcaNaPosicao(2,2))
            this.tabDoJogo.setMarcaNaPosicao(this.marca, 2,2);
        else
        // Tentando atrapalhar a vitoria do adversario na diagonal principal.
        if (!this.tabDoJogo.haMarcaNaPosicao(0,0) &&
            this.tabDoJogo.haMarcaNaPosicao(1,1) && !this.tabDoJogo.getMarcaNaPosicao(1,1).equals(this.marca) &&
            this.tabDoJogo.haMarcaNaPosicao(2,2) && !this.tabDoJogo.getMarcaNaPosicao(2,2).equals(this.marca))
            this.tabDoJogo.setMarcaNaPosicao(this.marca, 0,0);
        else
        if (this.tabDoJogo.haMarcaNaPosicao(0,0) && !this.tabDoJogo.getMarcaNaPosicao(0,0).equals(this.marca) &&
            !this.tabDoJogo.haMarcaNaPosicao(1,1) &&
            this.tabDoJogo.haMarcaNaPosicao(2,2) && !this.tabDoJogo.getMarcaNaPosicao(2,2).equals(this.marca))
            this.tabDoJogo.setMarcaNaPosicao(this.marca, 1,1);
        else
        if (this.tabDoJogo.haMarcaNaPosicao(0,0) && !this.tabDoJogo.getMarcaNaPosicao(0,0).equals(this.marca) &&
            this.tabDoJogo.haMarcaNaPosicao(1,1) && !this.tabDoJogo.getMarcaNaPosicao(1,1).equals(this.marca) &&
            !this.tabDoJogo.haMarcaNaPosicao(2,2))
            this.tabDoJogo.setMarcaNaPosicao(this.marca, 2,2);
        else
        // Tentando atrapalhar a vitoria do adversario na diagonal secundaria.
        if (!this.tabDoJogo.haMarcaNaPosicao(0,2) &&
            this.tabDoJogo.haMarcaNaPosicao(1,1) && !this.tabDoJogo.getMarcaNaPosicao(1,1).equals(this.marca) &&
            this.tabDoJogo.haMarcaNaPosicao(2,0) && !this.tabDoJogo.getMarcaNaPosicao(2,0).equals(this.marca))
            this.tabDoJogo.setMarcaNaPosicao(this.marca, 0,2);
        else
        if (this.tabDoJogo.haMarcaNaPosicao(0,2) && !this.tabDoJogo.getMarcaNaPosicao(0,2).equals(this.marca) &&
            !this.tabDoJogo.haMarcaNaPosicao(1,1) &&
            this.tabDoJogo.haMarcaNaPosicao(2,0) && !this.tabDoJogo.getMarcaNaPosicao(2,0).equals(this.marca))
            this.tabDoJogo.setMarcaNaPosicao(this.marca, 1,1);
        else
        if (this.tabDoJogo.haMarcaNaPosicao(0,2) && !this.tabDoJogo.getMarcaNaPosicao(0,2).equals(this.marca) &&
            this.tabDoJogo.haMarcaNaPosicao(1,1) && !this.tabDoJogo.getMarcaNaPosicao(1,1).equals(this.marca) &&
            !this.tabDoJogo.haMarcaNaPosicao(2,0))
            this.tabDoJogo.setMarcaNaPosicao(this.marca, 2,0);
        else
        // Tentando jogada de futuro na linha 0: uma marca nossa e duas casas livres.
        if (this.tabDoJogo.haMarcaNaPosicao(0,0) && this.tabDoJogo.getMarcaNaPosicao(0,0).equals(this.marca) &&
            !this.tabDoJogo.haMarcaNaPosicao(0,1) &&
            !this.tabDoJogo.haMarcaNaPosicao(0,2))
            this.tabDoJogo.setMarcaNaPosicao(this.marca, 0,1);
        else
        if (!this.tabDoJogo.haMarcaNaPosicao(0,0) &&
            this.tabDoJogo.haMarcaNaPosicao(0,1) && this.tabDoJogo.getMarcaNaPosicao(0,1).equals(this.marca) &&
            !this.tabDoJogo.haMarcaNaPosicao(0,2))
            this.tabDoJogo.setMarcaNaPosicao(this.marca, 0,0);
        else
        if (!this.tabDoJogo.haMarcaNaPosicao(0,0) &&
            !this.tabDoJogo.haMarcaNaPosicao(0,1) &&
            this.tabDoJogo.haMarcaNaPosicao(0,2) && this.tabDoJogo.getMarcaNaPosicao(0,2).equals(this.marca))
            this.tabDoJogo.setMarcaNaPosicao(this.marca, 0,0);
        else
        // Tentando jogada de futuro na linha 1: uma marca nossa e duas casas livres.
        if (this.tabDoJogo.haMarcaNaPosicao(1,0) && this.tabDoJogo.getMarcaNaPosicao(1,0).equals(this.marca) &&
            !this.tabDoJogo.haMarcaNaPosicao(1,1) &&
            !this.tabDoJogo.haMarcaNaPosicao(1,2))
            this.tabDoJogo.setMarcaNaPosicao(this.marca, 1,1);
        else
        if (!this.tabDoJogo.haMarcaNaPosicao(1,0) &&
            this.tabDoJogo.haMarcaNaPosicao(1,1) && this.tabDoJogo.getMarcaNaPosicao(1,1).equals(this.marca) &&
            !this.tabDoJogo.haMarcaNaPosicao(1,2))
            this.tabDoJogo.setMarcaNaPosicao(this.marca, 1,0);
        else
        if (!this.tabDoJogo.haMarcaNaPosicao(1,0) &&
            !this.tabDoJogo.haMarcaNaPosicao(1,1) &&
            this.tabDoJogo.haMarcaNaPosicao(1,2) && this.tabDoJogo.getMarcaNaPosicao(1,2).equals(this.marca))
            this.tabDoJogo.setMarcaNaPosicao(this.marca, 1,0);
        else
        // Tentando jogada de futuro na linha 2: uma marca nossa e duas casas livres.
        if (this.tabDoJogo.haMarcaNaPosicao(2,0) && this.tabDoJogo.getMarcaNaPosicao(2,0).equals(this.marca) &&
            !this.tabDoJogo.haMarcaNaPosicao(2,1) &&
            !this.tabDoJogo.haMarcaNaPosicao(2,2))
            this.tabDoJogo.setMarcaNaPosicao(this.marca, 2,1);
        else
        if (!this.tabDoJogo.haMarcaNaPosicao(2,0) &&
            this.tabDoJogo.haMarcaNaPosicao(2,1) && this.tabDoJogo.getMarcaNaPosicao(2,1).equals(this.marca) &&
            !this.tabDoJogo.haMarcaNaPosicao(2,2))
            this.tabDoJogo.setMarcaNaPosicao(this.marca, 2,0);
        else
        if (!this.tabDoJogo.haMarcaNaPosicao(2,0) &&
            !this.tabDoJogo.haMarcaNaPosicao(2,1) &&
            this.tabDoJogo.haMarcaNaPosicao(2,2) && this.tabDoJogo.getMarcaNaPosicao(2,2).equals(this.marca))
            this.tabDoJogo.setMarcaNaPosicao(this.marca, 2,0);
        else
        // Tentando jogada de futuro na coluna 0: uma marca nossa e duas casas livres.
        if (this.tabDoJogo.haMarcaNaPosicao(0,0) && this.tabDoJogo.getMarcaNaPosicao(0,0).equals(this.marca) &&
            !this.tabDoJogo.haMarcaNaPosicao(1,0) &&
            !this.tabDoJogo.haMarcaNaPosicao(2,0))
            this.tabDoJogo.setMarcaNaPosicao(this.marca, 1,0);
        else
        if (!this.tabDoJogo.haMarcaNaPosicao(0,0) &&
            this.tabDoJogo.haMarcaNaPosicao(1,0) && this.tabDoJogo.getMarcaNaPosicao(1,0).equals(this.marca) &&
            !this.tabDoJogo.haMarcaNaPosicao(2,0))
            this.tabDoJogo.setMarcaNaPosicao(this.marca, 0,0);
        else
        if (!this.tabDoJogo.haMarcaNaPosicao(0,0) &&
            !this.tabDoJogo.haMarcaNaPosicao(1,0) &&
            this.tabDoJogo.haMarcaNaPosicao(2,0) && this.tabDoJogo.getMarcaNaPosicao(2,0).equals(this.marca))
            this.tabDoJogo.setMarcaNaPosicao(this.marca, 0,0);
        else
        // Tentando jogada de futuro na coluna 1: uma marca nossa e duas casas livres.
        if (this.tabDoJogo.haMarcaNaPosicao(0,1) && this.tabDoJogo.getMarcaNaPosicao(0,1).equals(this.marca) &&
            !this.tabDoJogo.haMarcaNaPosicao(1,1) &&
            !this.tabDoJogo.haMarcaNaPosicao(2,1))
            this.tabDoJogo.setMarcaNaPosicao(this.marca, 1,1);
        else
        if (!this.tabDoJogo.haMarcaNaPosicao(0,1) &&
            this.tabDoJogo.haMarcaNaPosicao(1,1) && this.tabDoJogo.getMarcaNaPosicao(1,1).equals(this.marca) &&
            !this.tabDoJogo.haMarcaNaPosicao(2,1))
            this.tabDoJogo.setMarcaNaPosicao(this.marca, 0,1);
        else
        if (!this.tabDoJogo.haMarcaNaPosicao(0,1) &&
            !this.tabDoJogo.haMarcaNaPosicao(1,1) &&
            this.tabDoJogo.haMarcaNaPosicao(2,1) && this.tabDoJogo.getMarcaNaPosicao(2,1).equals(this.marca))
            this.tabDoJogo.setMarcaNaPosicao(this.marca, 0,1);
        else
        // Tentando jogada de futuro na coluna 2: uma marca nossa e duas casas livres.
        if (this.tabDoJogo.haMarcaNaPosicao(0,2) && this.tabDoJogo.getMarcaNaPosicao(0,2).equals(this.marca) &&
            !this.tabDoJogo.haMarcaNaPosicao(1,2) &&
            !this.tabDoJogo.haMarcaNaPosicao(2,2))
            this.tabDoJogo.setMarcaNaPosicao(this.marca, 1,2);
        else
        if (!this.tabDoJogo.haMarcaNaPosicao(0,2) &&
            this.tabDoJogo.haMarcaNaPosicao(1,2) && this.tabDoJogo.getMarcaNaPosicao(1,2).equals(this.marca) &&
            !this.tabDoJogo.haMarcaNaPosicao(2,2))
            this.tabDoJogo.setMarcaNaPosicao(this.marca, 0,2);
        else
        if (!this.tabDoJogo.haMarcaNaPosicao(0,2) &&
            !this.tabDoJogo.haMarcaNaPosicao(1,2) &&
            this.tabDoJogo.haMarcaNaPosicao(2,2) && this.tabDoJogo.getMarcaNaPosicao(2,2).equals(this.marca))
            this.tabDoJogo.setMarcaNaPosicao(this.marca, 0,2);
        else
        // Tentando jogada de futuro na diagonal principal: uma marca nossa e duas casas livres.
        if (this.tabDoJogo.haMarcaNaPosicao(0,0) && this.tabDoJogo.getMarcaNaPosicao(0,0).equals(this.marca) &&
            !this.tabDoJogo.haMarcaNaPosicao(1,1) &&
            !this.tabDoJogo.haMarcaNaPosicao(2,2))
            this.tabDoJogo.setMarcaNaPosicao(this.marca, 1,1);
        else
        if (!this.tabDoJogo.haMarcaNaPosicao(0,0) &&
            this.tabDoJogo.haMarcaNaPosicao(1,1) && this.tabDoJogo.getMarcaNaPosicao(1,1).equals(this.marca) &&
            !this.tabDoJogo.haMarcaNaPosicao(2,2))
            this.tabDoJogo.setMarcaNaPosicao(this.marca, 0,0);
        else
        if (!this.tabDoJogo.haMarcaNaPosicao(0,0) &&
            !this.tabDoJogo.haMarcaNaPosicao(1,1) &&
            this.tabDoJogo.haMarcaNaPosicao(2,2) && this.tabDoJogo.getMarcaNaPosicao(2,2).equals(this.marca))
            this.tabDoJogo.setMarcaNaPosicao(this.marca, 0,0);
        else
        // Tentando jogada de futuro na diagonal secundaria: uma marca nossa e duas casas livres.
        if (this.tabDoJogo.haMarcaNaPosicao(0,2) && this.tabDoJogo.getMarcaNaPosicao(0,2).equals(this.marca) &&
            !this.tabDoJogo.haMarcaNaPosicao(1,1) &&
            !this.tabDoJogo.haMarcaNaPosicao(2,0))
            this.tabDoJogo.setMarcaNaPosicao(this.marca, 1,1);
        else
        if (!this.tabDoJogo.haMarcaNaPosicao(0,2) &&
            this.tabDoJogo.haMarcaNaPosicao(1,1) && this.tabDoJogo.getMarcaNaPosicao(1,1).equals(this.marca) &&
            !this.tabDoJogo.haMarcaNaPosicao(2,0))
            this.tabDoJogo.setMarcaNaPosicao(this.marca, 0,2);
        else
        if (!this.tabDoJogo.haMarcaNaPosicao(0,2) &&
            !this.tabDoJogo.haMarcaNaPosicao(1,1) &&
            this.tabDoJogo.haMarcaNaPosicao(2,0) && this.tabDoJogo.getMarcaNaPosicao(2,0).equals(this.marca))
            this.tabDoJogo.setMarcaNaPosicao(this.marca, 0,2);
        else
        {
            // Sem jogada especial, procurar uma casa livre.
            for (int linha = 0; linha < 3; linha++)
                for (int coluna = 0; coluna < 3; coluna++)
                    if (!this.tabDoJogo.haMarcaNaPosicao(linha, coluna))
                    {
                        this.tabDoJogo.setMarcaNaPosicao(this.marca, linha, coluna);
                        return;
                    }

            throw new Exception("O tabuleiro esta cheio.");
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
        return "JogadorAutomatico [marca=" + this.marca.getSimbolo()
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

        JogadorAutomatico outro = (JogadorAutomatico)obj;

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
    public JogadorAutomatico (JogadorAutomatico modelo) throws Exception
    {
    if (modelo == null)
        throw new Exception("Modelo ausente.");

    this.marca = modelo.marca;
    this.tabDoJogo = new Tabuleiro(modelo.tabDoJogo);
    }

    @Override
    public Object clone ()
    {
        JogadorAutomatico ret = null;

        try
        {
            ret = new JogadorAutomatico(this);
        }
        catch (Exception erro)
        {
            throw new IllegalStateException(
                "Nao foi possivel copiar o jogador.", erro);
        }

        return ret;
    }
}
