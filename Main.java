import java.util.Scanner;

/**
 * Main
 */
public class Main {

    static Scanner scanner=new Scanner(System.in);
    static double AuxMonedero = 0;

    public static void main(String[] args) {
        int carrito, Cantidad;



        Productos productos[] = new Productos[3];
        productos[0] = new Productos();
        productos[0].setProducto(1, "Vitaminas", 142, 1.42);
        productos[1] = new Productos();
        productos[1].setProducto(2, "Suero", 19, 0.95);
        productos[2] = new Productos();
        productos[2].setProducto(3, "Leche", 128, 1.13);


        System.out.println("BIENVENIDO AL SISTEMA DE PAGO");
        System.out.println("Nuestros productos son:");

        for (int i = 0; i < productos.length; i++) {
            System.out.println("id: " + productos[i].getId() + " Nombre: " + productos[i].getNombre() + " Precio: "
                    + productos[i].getPrecio());

        }

        System.out.println("------------------------");
        System.out.println("------------------------");

        compra(productos);

        System.out.println("Muchas gracias por su compra vuelva pronto");

    }

    public static void compra(Productos productos[]) {
        int id, Aux = 1;
        double cantidad;

        do {

            System.out.println("Ingrese el Id del producto que desea comprar");
            id = scanner.nextInt();
            System.out.println("Ingrese la cantidad de producto");
            cantidad = scanner.nextDouble();

            if (id < 1 || id > 3) {
                System.out.println("ERROR, intente de nuevo");

            } else {

                AuxMonedero =  cantidad * productos[id-1].abMonedero();




                System.out.println("Si desea comprar otro producto precione 1 de lo contrario 2");
                Aux=scanner.nextInt();
            }
            
        } while (Aux != 2);

        pago(productos);
        
    }

    public static void pago(Productos productos[]) {
        int valor, error=0;
        String nMonedero;

        MonElectronico monElectronico = new MonElectronico();
        
        monElectronico.setNumMonedero("12345678");
        monElectronico.setDineroElec(149);


        System.out.println("Cuenta con monedero electronico");
        System.out.println("1 = si, 2 = no");
        valor = scanner.nextInt();

        if (valor == 1) {

            do {
                System.out.println("Ingrese su numero de monedero electronico");
                nMonedero = scanner.next();
                
                if (nMonedero.equals(monElectronico.getNumMonedero())) {



                    monElectronico.setDineroElec(monElectronico.getDineroElec()+AuxMonedero);  
                

                    System.out.println("Pago y abono a monedero realizado");
                    System.out.println("su abono a monedero es de " + monElectronico.getDineroElec() + " pesos");
                    
                    if (monElectronico.getDineroElec()>150) {
                        System.out.println("Por acumular más de 150 le regalaremos otros 150");
                        System.out.println("Saldo: "+monElectronico.getDineroElec());
                        
                    }



                    error = 1;
                }else{
                    System.out.println("ERROR, ingrese su numero de nuevo");
                }

               


            } while (error == 0);
            
        }else{

            System.out.println("Pago sin monedero, no abona");


        } 


        

        
    }

}