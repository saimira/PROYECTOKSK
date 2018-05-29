import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class Licencia extends JFrame implements ActionListener, ChangeListener{

  private JLabel label1, label2;
  private JCheckBox check1;
  private JButton boton1, boton2;
  private JScrollPane scrollpane1; 
  private JTextArea textarea1;
  String nombre = "";

  public Licencia(){
    setLayout(null);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setTitle("Licencia de uso");
    getContentPane().setBackground(new Color(95,185,160));
    setIconImage(new ImageIcon(getClass().getResource("images/IMG1.png")).getImage());
    Bienvenida ventanaBienvenida = new Bienvenida();
    nombre = ventanaBienvenida.texto;

    label1 = new JLabel("T�RMINOS Y CONDICIONES");
    label1.setBounds(215,5,200,30);
    label1.setFont(new Font("Andale Mono", 1, 14));
    label1.setForeground(new Color(255,255,255));
    add(label1);

    textarea1 = new JTextArea();
    textarea1.setEditable(false);
    textarea1.setFont(new Font("Andale Mono", 0, 9));   
    textarea1.setText("\n\n          T�RMINOS Y CONDICIONES" +
                    "\n\n            A.  PROHIBIDA SU VENTA O DISTRIBUCI�N SIN AUTORIZACI�N DE LA LIBRERIA." +
                    "\n            B.  PROHIBIDA LA ALTERACI�N DEL C�DIGO FUENTE O DISE�O DE." +
                    "\n            C.  Prohibido alterar las condiciones del libro." +
                    "\n            D. Devolver el libro en el tiempo previsto" +
                    "\n\n        Si el usuario no se encuentra de acuerdo con los T�rminos y condiciones" +
                    "\n          generales de uso, se le solicita que no haga uso, ni acceda a la informaci�n" + 
                    "\n          ni a los servicios ofrecidos" +
                    "\n          SI USTED NO CUMPLE ESTOS TERMINOS, HAGA CLIC EN (NO CUMPLO) Y NO UTILICE ESTE SOFTWARE." + 
                    "\n\n          PARA MAYOR INFORMACI�N SOBRE NUESTROS PRODUCTOS O SERVICIOS, POR FAVOR VISITE" + 
                    "\n           http://www.youtube.com/K&S");
    scrollpane1 = new JScrollPane(textarea1);
    scrollpane1.setBounds(10,40,575,200);
    add(scrollpane1);   

    check1 = new JCheckBox("Yo " + nombre + "  cumpli con las condiciones");
    check1.setBounds(10,250,300,30);
    check1.addChangeListener(this);
    add(check1);

    boton1 = new JButton("Continuar");
    boton1.setBounds(10,290,100,30);
    boton1.setBackground(new Color(255,255,255));
    boton1.setForeground(new Color(204,52,103));
    boton1.addActionListener(this);
    boton1.setEnabled(false);
    add(boton1);

    boton2 = new JButton("No Cumpli");
    boton2.setBounds(120,290,100,30);
    boton2.setBackground(new Color(255,255,255));
    boton2.setForeground(new Color(204,52,103));
    boton2.addActionListener(this);
    boton2.setEnabled(true);
    add(boton2);

    ImageIcon imagen = new ImageIcon("images/IMG2.png");
    label2 = new JLabel(imagen);  
    label2. setBounds(315,135,300,300);
    add(label2);
  }

  public void stateChanged(ChangeEvent e){
    if(check1.isSelected() == true){
       boton1.setEnabled(true);
       boton2.setEnabled(false);
    } else {
       boton1.setEnabled(false);
       boton2.setEnabled(true);
    }
    
  } 

  public void actionPerformed(ActionEvent e){
    if(e.getSource() == boton1){
        Principal ventanaPrincipal = new Principal();
        ventanaPrincipal.setBounds(0,0,640,535);
        ventanaPrincipal.setVisible(true);
        ventanaPrincipal.setResizable(false);
        ventanaPrincipal.setLocationRelativeTo(null);
        this.setVisible(false);
    } else if(e.getSource() == boton2){
        Bienvenida ventanabienvenida = new Bienvenida();
        ventanabienvenida.setBounds(0,0,350,450);
        ventanabienvenida.setVisible(true);
        ventanabienvenida.setResizable(false);
        ventanabienvenida.setLocationRelativeTo(null);
        this.setVisible(false);   
    }   
  }       

  public static void main(String args[]){
   Licencia ventanalicencia = new Licencia();
   ventanalicencia.setBounds(0,0,600,360);
   ventanalicencia.setVisible(true);
   ventanalicencia.setResizable(false);
   ventanalicencia.setLocationRelativeTo(null);
 }
}