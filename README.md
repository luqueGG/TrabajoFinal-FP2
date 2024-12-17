<div align="center">
<table>
    <theader>
        <tr>
            <td><img src="https://github.com/rescobedoq/pw2/blob/main/epis.png?raw=true" alt="EPIS" style="width:50%; height:auto"/></td>
            <th>
                <span style="font-weight:bold;">UNIVERSIDAD NACIONAL DE SAN AGUSTIN</span><br />
                <span style="font-weight:bold;">FACULTAD DE INGENIERÍA DE PRODUCCIÓN Y SERVICIOS</span><br />
                <span style="font-weight:bold;">DEPARTAMENTO ACADÉMICO DE INGENIERÍA DE SISTEMAS E INFORMÁTICA</span><br />
                <span style="font-weight:bold;">ESCUELA PROFESIONAL DE INGENIERÍA DE SISTEMAS</span>
            </th>
            <td><img src="https://github.com/rescobedoq/pw2/blob/main/abet.png?raw=true" alt="ABET" style="width:50%; height:auto"/></td>
        </tr>
    </theader>
    <tbody>
        <tr><td colspan="3"><span style="font-weight:bold;">Formato</span>: Informe de Laboratorio</td></tr>
        <tr><td><span style="font-weight:bold;">Aprobación</span>:  2022/03/01</td><td><span style="font-weight:bold;">Código</span>: GUIA-PRLD-001</td><td><span style="font-weight:bold;">Página</span>: 1</td></tr>
    </tbody>
</table>
</div>

<div align="center">
<span style="font-weight:bold;">TRABAJO FINAL</span><br />
</div>


<table>
<theader>
<tr><th colspan="6">INFORMACIÓN BÁSICA</th></tr>
</theader>
<tbody>
<tr><td>ASIGNATURA:</td><td colspan="5">LABORATORIO - FUNDAMENTOS DE PROGRAMACION II</td></tr>
<tr><td>TÍTULO DEL LABORATORIO:</td><td colspan="5">TRABAJO FINAL</td></tr>
<tr>
<td>NÚMERO DE LABORATORIO:</td><td>Trabajo final</td><td>AÑO LECTIVO:</td><td>2024-B</td><td>NRO. SEMESTRE:</td><td>II</td>
</tr>
<tr>
<td>FECHA INICIO::</td><td>22-Nov-2024</td><td>FECHA FIN:</td><td>16-Dic-2024</td><td>GRUPO:</td><td>B</td>
<tr>
    <td colspan="6">
        <ul>
        <li>Luque Guevara Fernando Gerson</li>
        </ul>
    </td>
</tr>
<tr><td colspan="6">DOCENTE:
<ul>
<li>René Alonso Nieto Valencia</li>
</ul>
</td>
</<tr>
</tdbody>
</table>
# Videojuego de Turnos

## Resumen del Proyecto
Este repositorio contiene un videojuego de combate por turnos desarrollado en **Java** utilizando la biblioteca **Swing** para la interfaz gráfica. El juego permite a dos jugadores realizar ataques y defensas en turnos alternados hasta que uno de los personajes quede sin vida.

---

## Características Principales
- **Juego por turnos**: Dos jugadores se alternan para atacar o defenderse.
- **Interfaz gráfica intuitiva**: Implementada usando `Swing` para facilitar la interacción.
- **Acciones disponibles**: Atacar para reducir la vida del oponente o defenderse para reducir el daño recibido.
- **Sistema de vida**: El jugador pierde si su nivel de vida llega a cero.

---

## Tecnologías Utilizadas
- **Lenguaje**: Java
- **Interfaz Gráfica**: Swing (Java)

---
# Juego de Batalla - Proyecto Final

Este es un proyecto final que implementa un juego de batalla entre dos jugadores utilizando Java y la biblioteca Swing para la interfaz gráfica.

## Estructura del Proyecto

### 1. **Interfaz Gráfica**

#### **Clase `Jugar`**
La clase `Jugar` es responsable de gestionar la lógica y la interfaz gráfica del juego. Tiene los siguientes componentes clave:

- **Paneles**: Se divide en tres columnas:
  - Columna 1: Información del Jugador 1.
  - Columna 2: Área central con el texto "VS".
  - Columna 3: Información del Jugador 2.

```java
public class Jugar extends JFrame {
    private JPanel columna1, columna2, columna3;
    private JLabel titulo, labelNivelVida1, labelNivelVida2;
    private URL kash = MenuInterfaz.class.getResource("/assets/kash.png");
    private Personaje jugador1, jugador2;
    private ControladorJuego controlador;

    public Jugar(URL imagen) {
        // Inicialización y configuración de la ventana principal
        setSize(600, 480);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        getContentPane().setBackground(FONDO);
        setLayout(new GridLayout(1, 3));

        // Inicialización de personajes y controlador
        jugador1 = new Personaje();
        jugador2 = new Personaje();
        controlador = new ControladorJuego(jugador1, jugador2);

        // Crear paneles para cada columna
        columna1 = crearColumna(kash, jugador1, jugador2, "Jugador 1");
        columna2 = crearPanelCentral();
        columna3 = crearColumna(imagen, jugador2, jugador1, "Jugador 2");

        add(columna1);
        add(columna2);
        add(columna3);

        setVisible(true);
    }
}

## Funcionamiento del Juego
- Al iniciar el juego, se presenta un **menú principal** donde los jugadores pueden comenzar una nueva partida o salir.
- Cada jugador controla un personaje con un nivel de vida inicial.
- **Opciones durante el turno**:
  - **Atacar**: Disminuye la vida del oponente.
  - **Defender**: Reduce el daño recibido en el próximo turno.
- La partida finaliza cuando uno de los jugadores pierde toda su vida.

---

## Capturas de Pantalla
**Menú Principal**
![Menu Principal](ruta/a/la/captura-menu.png)

**Juego en Acción**
![Juego en Accion](ruta/a/la/captura-juego.png)

---
