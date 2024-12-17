package logic;

public class Personaje {
    private int ataque;
    private int defensa;
    private int nivelVida;

    public Personaje() {
        this.ataque = (int)(Math.random()*20+20);
        this.defensa = (int)(Math.random()*20+30);
        this.nivelVida = (int)(Math.random()*20+60);
    }

    public int getAtaque() {
        return ataque;
    }

    public int getDefensa() {
        return defensa;
    }

    public int getNivelVida() {
        return nivelVida;
    }

    public void setNivelVida(int nivelVida) {
        this.nivelVida = nivelVida;
    }
}
