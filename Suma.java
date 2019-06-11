
import java.util.LinkedList;

public class Suma {

    String n = "0";
    String n2 = "0";                                             //siempre debe haber un cero adelante 999+101 da error si no hay cero
    LinkedList<String> num = new LinkedList();                   //separa el primer numero en varios string
    LinkedList<String> num2 = new LinkedList();                   //separa el segundo numero
    LinkedList<Integer> regex = new LinkedList();                 //registra una unidad cuando la suma vertical de cierta posicion da mas de 10. por ejemplo 9+9=18 registra un 1 sino 0  
    LinkedList<Integer> result = new LinkedList();                // almacena las distintas sumas de los valores de n y n2 separadamente hasta almacenar el resultado final en varios objetos Integer
   //meter en un metodo al ultimo, en afinar talvez  LinkedList<String> resultString = new LinkedList();           //se tranforma el resultado fianl a String, si es necesario

    public Suma() {
    }

    public Suma(String n, String n2) {
        this.n += n;
        this.n2 += n2;
        emparejar();
    }

    private void emparejar() {                                  //se rellenan con ceros los string para que tengan el mismo tamaño y se puedan realizar correctamente las sumas
        String a = "";
        
        if (n.length() >= n2.length()) {
            for (int i = n.length(); i >= n2.length(); i--) {
                a += "0";
            }
            n2 = n2.replaceFirst("0", a);
        } else {
            for (int i = n2.length(); i >= n.length(); i--) {
                a += "0";
            }
            n = n.replace("0", a);
        }
        //al final colocar un metodo afinar para sacar los ceros del principio que estan en el resultado final
        
    }

    public void sumar() { 

        agregar();
        makeResultAndRegex();
        System.out.println("");
        registrar();
        sumaParcial();
        finalizar(); 
        System.out.print("regex ");
        mostrar(regex);
        System.out.println("result ");
        mostrar(result);

    }

    public void agregar() {                                          //agrego cada numero a su respectiva linkedlist, pero separo sus elementos, en distintas posiciones del linkedlist
        char aux = ' ';
        char aux2 = ' ';
        String aux3 = "";
        String aux4 = "";
        int tam=n.length()-1;
        for (int i = 0; i <= tam; i++) {
            aux = n.charAt(i);
            aux2 = n2.charAt(i);
            aux3 = String.valueOf(aux);
            aux4 = String.valueOf(aux2);
            num.add(aux3);
            num2.add(aux4);

        }
        System.out.print("num ");
        mostrar(num);
        System.out.print("num2 ");
        mostrar(num2);
    }

    public void registrar() {                                   //cada psocion del result que haya dado mayor a 10 al crearlo, corresponde a un 1 en regex simetricamente
        int aux = 0;
        int tam = result.size() - 1;
        for (int i = tam; i >= 0; i--) {
            aux = result.get(i);
            result.set(i, aux % 10);                            //divido el elemento de la posicion del result por 10 y almaceno su resto, sabiendo que esa unidad se representa en el regex
            if (aux > 9) {
                regex.set(i, 1);
            } else {
                regex.set(i, 0);                                //si el valor que contiene el result es inferior a 10, colocamos en el regex un cero
            }
        }
        System.out.print("regex ");
        mostrar(regex);
        System.out.print("result ");
        mostrar(result);
    }

    public void makeResultAndRegex() {                              //creo el ragistro lleno de ceros y en el result coloca la suma simetrica de los elementos de los dos numeros 
        int tam=num.size()-1;
        for (int i = tam; i >= 0; i--) {
            regex.push(0);
            result.push(convertirToInt(num.get(i), num2.get(i)));       
        }
        System.out.print("regex0 ");
        mostrar(regex);
        System.out.print("result0 ");
        mostrar(result);
    }

    public void sumaParcial() {                                     //Cada valor de la  posicion del result la sumamos con la posicion equivalente+1 del regex para recuperar la unidad 
        for (int i = regex.size() - 2; i >= 0; i--) {
            result.set(i, result.get(i) + regex.get(i + 1));
            regex.set(i + 1, 0);
        }

    }

    public void finalizar() {                                       //aumenta el tamaño del numero si corresponde
        if (regex.get(0) == 1) {                                    //si en la primera posicion del regex hay un 1 significa que se agrega una nueva posicion a la izquierda para representar un numero mas grande
            result.push(1);
        }
        mostrar(result);
        comprobarRegex();                                           //se comprueba el registro
    }

    public void comprobarRegex() {                                  //comprueba que los valores del regex este en cero, de lo contrario, faltan unidades por sumar y/0 posiciones por agregar
        System.out.println("regex.size() " + regex.size());
        int cont = regex.size() - 1;
        for (int i = 0; i < regex.size(); i++) {
            if (result.get(i) < 10) {
                cont--;
            }
        }
        if (cont != -1) {
            sanguche();                                              // si el regex contiene algun 1 , se llama a la rutina sanguche para que procece el numero hasta que sea necesario
        }

    }

    public Integer convertirToInt(String a, String b) {              //transforma dos elementos simetricos de los Linkedlist num y num2 para convertirlos en entero y sumarlos
        Integer c = Integer.parseInt(a) + Integer.parseInt(b);
        return c;
    }

    public void sanguche() {                                        //los elementos de result deben ser inferiores a 10 y ademas el regex debe estar todo en cero, por lo tanto se llama a esta rutina, un patron de metodos, para que se ejecute hasta dar el resultado correcto
        System.out.println("sanguche");
        registrar();
        sumaParcial();
        finalizar();
    }

    /*
    public static void convertirToString() {    //podria usarse o no para devolver el resultado final , lo convierte en elementos string separados
        for (int i = result.size() - 1; i >= 0; i--) {
            resultString.push(String.valueOf(result.get(i)));
        }
    }
     */
    public void mostrar(LinkedList a) {                             //muestra los elementos de cualquier linkedList
       int tam = a.size() - 1;
        for (int i = 0; i <= tam; i++) {
            System.out.print(a.get(i) + "-");
        }
        System.out.println("");
    }
    public String guardar(){
        String res="";
        for (int i=0; i<result.size(); i++){
            res+=String.valueOf(result.get(i));
        }
        return res;
    }
}
