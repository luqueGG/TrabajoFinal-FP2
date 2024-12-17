package logic;

public class ControladorJuego {
    private Personaje jugador1;
    private Personaje jugador2;

    public ControladorJuego(Personaje jugador1, Personaje jugador2) {
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
    }

    public void atacar(Personaje atacante, Personaje objetivo) {
        int daño = atacante.getAtaque();
        int nuevaVida = objetivo.getNivelVida() - daño;
        objetivo.setNivelVida(Math.max(nuevaVida, 0)); // No permitir vida negativa
    }

    public void defender(Personaje defensor) {
        int vidaActual = defensor.getNivelVida();
        defensor.setNivelVida(vidaActual + defensor.getDefensa()); // Sumar defensa a la vida
    }
}
