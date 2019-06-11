import javax.swing.JOptionPane;
public class Ejecutar {
    public static void main(String[] args) {
       /*
        String n = JOptionPane.showInputDialog("Primer número");
        String operacion=JOptionPane.showInputDialog("Operacion");
        String n2 = JOptionPane.showInputDialog("Segundo número");
        
         //SUMA ENTERA
        Suma suma = new Suma(n, n2);
        System.out.println(suma.n);
        System.out.println(suma.n2);
        suma.sumar();
*/    
        //SUMA FLOAT

     //METER ESTO A UNA INTERFAZ GRAFICA, UNA CALCULADORA BASICA ESTANDAR
       //new Suma("999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999","2").sumar();
Gui gui= new Gui();

gui.setTitle("Precicion Variable");
gui.setVisible(true);
    }
}
