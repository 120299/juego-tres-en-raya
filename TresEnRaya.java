/*
    TITULO: 3 en raya.

    DESCRIPCION: Hacer el tres en raya con Jframe.

    AUTOR: Brayan Lasso.
*/

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class TresEnRaya extends JFrame implements ActionListener {
    //DECLARACIONES
    private JLabel lblJugador1, lblJugador2, lblTotalEmpates, lblTotalPartidas,
    lblPartJug1, lblPartJug2;
    private JButton[] btn = new JButton[9];
    private JButton btnReiniciar, btnNuevaPartida, bntSalir;
    private JTextField txtNomJug1, txtNomJug2, txtTotalPartidas, txtTotalVicJug1, txtTotalVicJug2, txtTotalEmpate;
    private JTextArea txtAreaPartidas;
    private JScrollPane scrollAreaPartidas;
    private boolean bTurno = true, bJugTerminado = false;
    private int iCasoJugTerminado, iConPartidas = 1, iConVicJug1, iConVicJug2, iConEmpate;
    private ImageIcon iconoJugX = new ImageIcon("imagenes/iconoJugX.png"), iconoJugO = new ImageIcon("imagenes/iconoJugO.png");
    private ImageIcon iconoJugXClasico = new ImageIcon("imagenes/iconoJugXClasico.png"), iconoJugOClasico = new ImageIcon("imagenes/iconoJugOClasico.png");
     private ImageIcon iconoJugXNormal = new ImageIcon("imagenes/iconoJugX.png"), iconoJugONormal = new ImageIcon("imagenes/iconoJugO.png");
    private ImageIcon iconoJugXFuturista= new ImageIcon("imagenes/iconoJugXFuturista.png"), iconoJugOFuturista = new ImageIcon("imagenes/iconoJugOFuturista.png");
    private JMenuBar jMenubar;
    private JMenu jMenu1, jMenu2, jMenu3;
    private JMenuItem jMenu1Item1, jMenu1Item2, jMenu2Item1, jMenu2Item2, jMenu2Item3;

    //CONSTRUCTORES
    public TresEnRaya(String titulo) {
        /*---------------------------------------------*/
        //JFrame
        setLayout(null);
        setTitle(titulo);
        getContentPane().setBackground(Color.LIGHT_GRAY);
        /*---------------------------------------------*/

        //JMenuBar
        jMenubar = new JMenuBar();
        setJMenuBar(jMenubar);

        //JMenu Opciones
        jMenu1 = new JMenu("Opciones");
        jMenubar.add(jMenu1);

        /*---------------------------------------------*/

        //JMenu Nivel de Juego
        jMenu2 = new JMenu("Nivel de juego");
        jMenu1.add(jMenu2);

        //JMenuItem1 Nivel de Juego Basico
        jMenu1Item1 = new JMenuItem("Básico");
        jMenu2.add(jMenu1Item1);
        jMenu1Item1.addActionListener(this);

        //JMenuItem2 Nivel de Juego Avanzado
        jMenu1Item2 = new JMenuItem("Avanzado");
        jMenu2.add(jMenu1Item2);
        jMenu1Item2.addActionListener(this);

        /*---------------------------------------------*/

        //JMenu Tema de Jeugo
        jMenu3 = new JMenu("Temas de Juego");
        jMenu1.add(jMenu3);

        //JMenu Fondo de pantalla Clasico
        jMenu2Item1 = new JMenuItem("Clásico");
        jMenu3.add(jMenu2Item1);
        jMenu2Item1.addActionListener(this);

        //JMenu Fondo de pantalla Normal
        jMenu2Item2 = new JMenuItem("Normal");
        jMenu3.add(jMenu2Item2);
        jMenu2Item2.addActionListener(this);

        //JMenu Fondo Futurista
        jMenu2Item3 = new JMenuItem("Futurista");
        jMenu3.add(jMenu2Item3);
        jMenu2Item3.addActionListener(this);

        /*---------------------------------------------*/

        //Jlabel lblJugador1
        lblJugador1 = new JLabel("Jugador 1");
        lblJugador1.setBounds(30, 30, 100, 20);
        add(lblJugador1);

        //JTextField Jugador 1 
        txtNomJug1 = new JTextField(" ");
        txtNomJug1.setBounds(100, 30, 190, 20);
        add(txtNomJug1);

        //JLabel Partidas Jugador 1
        lblPartJug1 = new JLabel("Victoria/s");
        lblPartJug1.setBounds(340, 30, 70, 20);
        add(lblPartJug1);

        //JTextField Partidas Jugador 1
        txtTotalVicJug1 = new JTextField("0");
        txtTotalVicJug1.setBounds(400, 30, 30, 20);
        txtTotalVicJug1.setHorizontalAlignment(JTextField.CENTER);
        add(txtTotalVicJug1);

        /*---------------------------------------------*/

        //Jlabel Jugador 2
        lblJugador2 = new JLabel("Jugador 2");
        lblJugador2.setBounds(30, 60, 100, 20);
        add(lblJugador2);

        //JTextField Jugador 2
        txtNomJug2 = new JTextField(" ");
        txtNomJug2.setBounds(100, 60, 190, 20);
        add(txtNomJug2);

        //JLabel Partidas Jugador 2
        lblPartJug2 = new JLabel("Victoria/s");
        lblPartJug2.setBounds(340, 60, 70, 20);
        add(lblPartJug2);

        //JTextField Partidas Jugador 2
        txtTotalVicJug2 = new JTextField("0");
        txtTotalVicJug2.setBounds(400, 60, 30, 20);
        txtTotalVicJug2.setHorizontalAlignment(JTextField.CENTER);
        add(txtTotalVicJug2);

        /*---------------------------------------------*/

        //Jlaber Empates totales
        lblTotalEmpates = new JLabel("Empates");
        lblTotalEmpates.setBounds(340, 520, 70, 20);
        add(lblTotalEmpates);

        //JTextField Empatadas
        txtTotalEmpate = new JTextField("0");
        txtTotalEmpate.setBounds(400, 520, 30, 20);
        txtTotalEmpate.setHorizontalAlignment(JTextField.CENTER);
        add(txtTotalEmpate);
        //Jlabel Empates

        /*---------------------------------------------*/

        //JTextArea Partidas
        txtAreaPartidas = new JTextArea("  Partida " + iConPartidas + "\n\n");
        scrollAreaPartidas = new JScrollPane(txtAreaPartidas);
        scrollAreaPartidas.setBounds(450, 100, 240, 400);
        add(scrollAreaPartidas);

        /*---------------------------------------------*/

        //JLabel partidas totales.
        lblTotalPartidas = new JLabel("Partida/s");
        lblTotalPartidas.setBounds(30, 520, 100, 20);
        add(lblTotalPartidas);

        //JTextField partidas totales
        txtTotalPartidas = new JTextField("1");
        txtTotalPartidas.setBounds(110, 520, 30, 20);
        txtTotalPartidas.setHorizontalAlignment(JTextField.CENTER);
        add(txtTotalPartidas);

        /*---------------------------------------------*/

        //Crear Botones del 1 al 9
        for (int i = 0; i <= 8; i++) {
            btn[i] = new JButton();
            switch (i) {
                case 0:
                    btn[0].setBounds(30, 100, 120, 120);
                    break;
                case 1:
                    btn[1].setBounds(170, 100, 120, 120);
                    break;
                case 2:
                    btn[2].setBounds(310, 100, 120, 120);
                    break;
                case 3:
                    btn[3].setBounds(30, 240, 120, 120);
                    break;
                case 4:
                    btn[4].setBounds(170, 240, 120, 120);
                    break;
                case 5:
                    btn[5].setBounds(310, 240, 120, 120);
                    break;
                case 6:
                    btn[6].setBounds(30, 380, 120, 120);
                    break;
                case 7:
                    btn[7].setBounds(170, 380, 120, 120);
                    break;
                case 8:
                    btn[8].setBounds(310, 380, 120, 120);
                    break;
            } //Switch
            add(btn[i]);
            btn[i].setBackground(Color.white);
            btn[i].addActionListener(this);
        } //For

        /*---------------------------------------------*/

        //JButton Reinciar
        btnReiniciar = new JButton("Reiniciar");
        btnReiniciar.setBounds(30, 560, 100, 40);
        add(btnReiniciar);
        btnReiniciar.addActionListener(this);

        //JButton Nueva Partida
        btnNuevaPartida = new JButton("Nueva Partida");
        btnNuevaPartida.setBounds(290, 560, 150, 40);
        add(btnNuevaPartida);
        btnNuevaPartida.addActionListener(this);

        //JButton Salir
        bntSalir = new JButton("Salir");
        bntSalir.setBounds(590, 560, 100, 40);
        add(bntSalir);
        bntSalir.addActionListener(this);

    } //TresEnRaya(String titulo)

    //** METODOS **//

    public void actionPerformed(ActionEvent e) {

        /*---------------------------------------------*/
        //Cambiar Tema Juego Clasico
        if (e.getSource() == jMenu2Item1) {
            temaClasico();
        }

        //Cambiar Tema Juego Normal
        if (e.getSource() == jMenu2Item2) {
             temaNormal();
        }

        //Cambiar Tema Juego Futurista
        if (e.getSource() == jMenu2Item3) {
            temaFuturista();
        }
        /*---------------------------------------------*/

        //Cambiar tamaño de pantalla 470*670
        if (e.getSource() == jMenu1Item1) {
            juegoBasico();
        } //If

        //Cambiar tamaño de pantalla 740*670
        if (e.getSource() == jMenu1Item2) {
            juegoAvanzado();
        } //If

        /*---------------------------------------------*/

        //Reiniciar Partida
        if (e.getSource() == btnReiniciar) {
            reiniciarPartida();
        } //if

        /*---------------------------------------------*/
        //Reiniciar Partida
        if (e.getSource() == btnNuevaPartida) {
            nuevaPartida();
        } //if
        /*---------------------------------------------*/

        //Salir de la partida
        if (e.getSource() == bntSalir) {
            System.exit(0);
        } //if

        /*---------------------------------------------*/

        //Verificar botones pulsado
        for (int i = 0; i <= 8; i++) {
            if (e.getSource() == btn[i] && btn[i].getIcon() == null) {
                btn[i].setIcon(bTurno ? iconoJugX : iconoJugO);
                bTurno = !bTurno;
                txtAreaPartidas.append("  Boton " + (i + 1) + " \n");
            }
        } //For

        /*---------------------------------------------*/

        //Comprobar partida
        if (!bJugTerminado) {
            comprobarPartida();
        }

    } //actionPerformed

    public void juegoAvanzado() {
        setSize(740, 690);
        txtAreaPartidas.setVisible(true);
        scrollAreaPartidas.setVisible(true);

        //JButton validaciones de reinicio, nueva partida o salir
        btnReiniciar.setBounds(30, 560, 100, 40);
        btnNuevaPartida.setBounds(290, 560, 150, 40);
        bntSalir.setBounds(590, 560, 100, 40);
    }

    public void juegoBasico() {
        setSize(480, 690);
        txtAreaPartidas.setVisible(false);
        scrollAreaPartidas.setVisible(false);

        //JButton validaciones de reinicio, nueva partida o salir
        btnReiniciar.setBounds(30, 560, 120, 40);
        btnNuevaPartida.setBounds(170, 560, 120, 40);
        bntSalir.setBounds(310, 560, 120, 40);
    }

    public void temaClasico() {
        //Declaraciones
        Color colorClasico = new Color(237, 208, 157);
        getContentPane().setBackground(colorClasico);

        //Inicio
        reiniciarPartida();
        lblJugador1.setForeground(Color.BLACK);
        lblJugador2.setForeground(Color.BLACK);
        lblTotalEmpates.setForeground(Color.BLACK);
        lblTotalPartidas.setForeground(Color.BLACK);
        lblPartJug1.setForeground(Color.BLACK);
        lblPartJug2.setForeground(Color.BLACK);

        iconoJugX = new ImageIcon("imagenes/iconoJugXClasico.png");
        iconoJugO = new ImageIcon("imagenes/iconoJugOClasico.png");
    }

        public void temaNormal() {
        //Declaraciones
        getContentPane().setBackground(Color.LIGHT_GRAY);

        //Inicio
        lblJugador1.setForeground(Color.BLACK);
        lblJugador2.setForeground(Color.BLACK);
        lblTotalEmpates.setForeground(Color.BLACK);
        lblTotalPartidas.setForeground(Color.BLACK);
        lblPartJug1.setForeground(Color.BLACK);
        lblPartJug2.setForeground(Color.BLACK);
        reiniciarPartida();
        iconoJugX = new ImageIcon("imagenes/iconoJugX.png");
        iconoJugO = new ImageIcon("imagenes/iconoJugO.png");
    }

    public void temaFuturista() {
        //Declaraciones
        Color colorFuturista = new Color(87, 35, 100);
        getContentPane().setBackground(colorFuturista);

        //Inicio 
        reiniciarPartida();

        lblJugador1.setForeground(Color.WHITE);
        lblJugador2.setForeground(Color.WHITE);
        lblTotalEmpates.setForeground(Color.WHITE);
        lblTotalPartidas.setForeground(Color.WHITE);
        lblPartJug1.setForeground(Color.WHITE);
        lblPartJug2.setForeground(Color.WHITE);

        iconoJugX = new ImageIcon("imagenes/iconoJugXFuturista.png");
        iconoJugO = new ImageIcon("imagenes/iconoJugOFuturista.png");
    }

    public void nombreJugadores() {
        //Declaracioens
        String sNombre1 = "";
        String sNombre2 = "";

        sNombre1 = JOptionPane.showInputDialog(null,
            "Ingrese el nombre",
            "Nombre del jugador 1",
            JOptionPane.QUESTION_MESSAGE);

        if (sNombre1 == null || sNombre1.equals("")) {
            txtNomJug1.setText("  Jugador 1");
        } else {
            txtNomJug1.setText("  " + sNombre1.toUpperCase());
        }

        sNombre2 = JOptionPane.showInputDialog(null,
            "Ingrese el nombre",
            "Nombre del jugador 2",
            JOptionPane.QUESTION_MESSAGE);

        if (sNombre2 == null || sNombre2.equals("")) {
            txtNomJug2.setText("  Jugador 2");
        } else {
            txtNomJug2.setText("  " + sNombre2.toUpperCase());
        }
    }

    public void cambiarNombre1() {
        lblJugador1.setText(txtNomJug1.getText().equals(" ") ? "Jugador 1" : txtNomJug1.getText());
        txtNomJug1.setVisible(false);
    } //cambiarNombre1

    public void cambiarNombre2() {
        lblJugador2.setText(txtNomJug2.getText().equals(" ") ? "Jugador 2" : txtNomJug2.getText());
        txtNomJug2.setVisible(false);
    } //cambiarNombre2

    public void deshabilitarBotones(int iN1, int iN2, int iN3) {
        for (int i = 0; i <= 8; i++) {
            btn[i].setEnabled(false);
        } //For
        btn[iN1].setEnabled(true);
        btn[iN2].setEnabled(true);
        btn[iN3].setEnabled(true);
    } //deshabilitarBotones

    public void habilitarBotones() {
        for (int i = 0; i <= 8; i++) {
            btn[i].setEnabled(true);
        } //For
    } //habilitarBotones

    public void botonesNull() {
        for (int i = 0; i <= 8; i++) {
            btn[i].setIcon(null);
        } //For
    } //botonesNull

    public void quitarFondoBoton() {
        for (int i = 0; i <= 8; i++) {
            btn[i].setBackground(Color.white);
        } //For
    } //botonSinFondo

    public void cambiarColorBotones(Color colotFondo) {
        for (int i = 0; i <= 8; i++) {
            btn[i].setBackground(colotFondo);
        } //For
    } //cambiarColorBotones

    public void comprobarPartida() {

        //COMPROBAR FILAS 

        /*---------------------------------------------*/
        //Primera fila btn1, btn2 y btn3 caso = 1
        if (btn[0].getIcon() != null && (btn[0].getIcon() == btn[1].getIcon() && btn[1].getIcon() == btn[2].getIcon())) {
            bJugTerminado = true;
            iCasoJugTerminado = 1;
        }

        //Segunda fila btn4, btn5 y btn6 caso = 2
        if (btn[3].getIcon() != null && (btn[3].getIcon() == btn[4].getIcon() && btn[4].getIcon() == btn[5].getIcon())) {
            bJugTerminado = true;
            iCasoJugTerminado = 2;
        }

        //Tercera fila btn7, btn8 y btn9 caso = 3
        if (btn[6].getIcon() != null && (btn[6].getIcon() == btn[7].getIcon() && btn[7].getIcon() == btn[8].getIcon())) {
            bJugTerminado = true;
            iCasoJugTerminado = 3;
        }
        /*---------------------------------------------*/

        //COMPROBAR COLUMNAS

        /*---------------------------------------------*/
        //Primera columna btn1, btn4 y btn7 caso = 4
        if (btn[0].getIcon() != null && (btn[0].getIcon() == btn[3].getIcon() && btn[3].getIcon() == btn[6].getIcon())) {
            bJugTerminado = true;
            iCasoJugTerminado = 4;
        }

        //Segunda columna btn2, btn5 y btn8 caso = 5
        if (btn[1].getIcon() != null && (btn[1].getIcon() == btn[4].getIcon() && btn[4].getIcon() == btn[7].getIcon())) {
            bJugTerminado = true;
            iCasoJugTerminado = 5;
        }

        //Tercera columna btn3, btn6 y btn9 caso = 6
        if (btn[2].getIcon() != null && (btn[2].getIcon() == btn[5].getIcon() && btn[5].getIcon() == btn[8].getIcon())) {
            bJugTerminado = true;
            iCasoJugTerminado = 6;
        }
        /*---------------------------------------------*/

        //COMPROBAR DIAGONALES

        /*---------------------------------------------*/
        //Diagonal \ btn1, btn5 y btn9 caso = 7
        if (btn[0].getIcon() != null && (btn[0].getIcon() == btn[4].getIcon() && btn[4].getIcon() == btn[8].getIcon())) {
            bJugTerminado = true;
            iCasoJugTerminado = 7;
        }

        //Diagonal / btn3, btn5 y btn7 caso = 8
        if (btn[2].getIcon() != null && (btn[2].getIcon() == btn[4].getIcon() && btn[4].getIcon() == btn[6].getIcon())) {
            bJugTerminado = true;
            iCasoJugTerminado = 8;
        }

        /*---------------------------------------------*/
        if (bJugTerminado) {

            //Desabilitar botones

            switch (iCasoJugTerminado) {

                case 1:
                    deshabilitarBotones(0,1,2);
                    break;

                case 2:
                     deshabilitarBotones(3,4,5);
                    break;

                case 3:
                     deshabilitarBotones(6,7,8);
                    break;

                case 4:
                    deshabilitarBotones(0,3,6);
                    break;

                case 5:
                    deshabilitarBotones(1,4,7);
                    break;

                case 6:
                    deshabilitarBotones(2,5,8);
                    break;

                case 7:
                    deshabilitarBotones(0,4,8);
                    break;

                case 8:
                    deshabilitarBotones(2,4,6);
                    break;
            } //Switch
            
            /*---------------------------------------------*/

            if (bTurno == false) {
                //Contador
                iConVicJug1++;

                //Mostrar contador
                txtTotalVicJug1.setText(Integer.toString(iConVicJug1));

                //Mostrar quien gano
                txtAreaPartidas.append("\n " + txtNomJug1.getText() + " ha ganado. \n");
            } else {
                //Contador
                iConVicJug2++;

                //Mostrar contador
                txtTotalVicJug2.setText(Integer.toString(iConVicJug2));

                //Mostrar quien gano
                txtAreaPartidas.append("\n " + txtNomJug2.getText() + " ha ganado. \n");
            }
        } //If
        /*---------------------------------------------*/

        //EMPATE    
        if (btn[0].getIcon() != null && btn[1].getIcon() != null && btn[2].getIcon() != null &&
            btn[3].getIcon() != null && btn[4].getIcon() != null && btn[5].getIcon() != null &&
            btn[6].getIcon() != null && btn[7].getIcon() != null && btn[8].getIcon() != null && !bJugTerminado) {

            //deshabilitarBotones();
            //Contador
            iConEmpate++;

            //Mostrar contador
            txtTotalEmpate.setText(Integer.toString(iConEmpate));
            txtAreaPartidas.append("\n  Los jugadores han empatado\n");
        } //if
        /*---------------------------------------------*/
    } // comprobarPartida()

    public void nuevaPartida() {
        //contador de partidas
        iConPartidas++;

        //Mostar contador partidas
        txtTotalPartidas.setText(Integer.toString(iConPartidas));

        //Poner imagenes de botones en null
        botonesNull();

        //Habilitar botones
        habilitarBotones();

        //Quitar color de fondo
        quitarFondoBoton();

        //Ocutar el JTextField de los nombres 
        txtNomJug1.setEnabled(true);
        txtNomJug2.setEnabled(true);

        //Mostar partidas en el JTextArea 
        txtAreaPartidas.append("\n  Partida " + iConPartidas + "\n\n");

        //reiniciar turno
        bTurno = true;

        //reiniciar juego terminado     
        bJugTerminado = false;

        //Reiniciar casos de ganador
        iCasoJugTerminado = 0;

    } //nuevaPartida()

    public void reiniciarPartida() {
        //Poner imagenes de botones en null
        botonesNull();

        //habilitar botones
        habilitarBotones();

        //Quitar color
        quitarFondoBoton();

        //Reinicar texto jugador 1
        txtNomJug1.setText(" ");
        txtNomJug1.setVisible(true);
        txtTotalVicJug1.setText("0");

        //Reinicar texto jugador 2
        txtNomJug2.setText(" ");
        txtNomJug2.setVisible(true);
        txtTotalVicJug2.setText("0");

        //Reiniciar Label y texto de empate;
        txtTotalEmpate.setText("0");

        //Reinicar JTextArea de historial
        txtAreaPartidas.setText("\n  Partida 1" + "\n\n");

        //Reinicar JTextField Partidas
        txtTotalPartidas.setText("1");

        //Reinicar Contadores
        iConPartidas = 1;
        iConVicJug1 = 0;
        iConVicJug2 = 0;
        iConEmpate = 0;
        iCasoJugTerminado = 0;

        //Reinicar turnos  
        bTurno = true;

        //Reinicar juego terminado     
        bJugTerminado = false;

        //Nombre jugadores
        nombreJugadores();
    } //reiniciarPartida()

    public static void main(String[] args) {
        //Declaraciones
        TresEnRaya juego = new TresEnRaya("Tres en Raya");

        //Inicio

        juego.setBounds(700, 100, 740, 690);
        juego.setResizable(false);
        juego.setVisible(true);
        juego.nombreJugadores();

    } //Main
} //Class