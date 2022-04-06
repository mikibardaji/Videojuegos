/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listadovideojuegos;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author usuari
 */
public class ListadoVideojuegos {

     ArrayList<Videojuego> listado;
     Menu menu_principal;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ListadoVideojuegos app = new ListadoVideojuegos();
        
        app.run(); //metodo no static, que permite llamar a 
        //otros metodos no static
        
    }

    private void loadItems() {
        System.out.println("Load Items prove....");
        listado.add(new Videojuego("The secret of Monkey Island", 19));
        listado.add(new Videojuego("Monkey Island 2: LeChuck's Revenge", 10));
        
    }

    
    
    private void añadir_opciones(Menu menu_principal) {
        menu_principal.add(new Option("Salir "));
        menu_principal.add(new Option("Dar de alta videojuego "));
        menu_principal.add(new Option("Borrar Videojuego"));        
        menu_principal.add(new Option("Listar videjuegos "));

        menu_principal.add(new Option("Grabar en disco"));
        menu_principal.add(new Option("Recuperar disco "));

    }

    private void run() {
    
        listado = new ArrayList<Videojuego>();
        menu_principal = new Menu("Listado Videojuegos");
        añadir_opciones(menu_principal);
        
        
        int opcion;
        
        System.out.println("=============");
        loadItems();
        //int opcion;
        do{
            menu_principal.showMenu();
        opcion = menu_principal.choose("Select option: ");
        switch(opcion)
        {
            case 1:
                InsertarItem();
                break;
            case 2:
                EliminarAnimales();
                break;    
            case 3:
                mostrarDatosAnimales();
                break;
            case 4:
                System.out.println("no implementado");
                break;
            case 6:
                System.out.println("");
                break;
            case 0:
                System.out.println("saliendo");
                break;
            default:
                System.out.println("opcion no implementada");
                break;
        }
        } while(opcion!=0);
    }

    private void InsertarItem() {
        Scanner sc = new Scanner(System.in);
        System.out.print("name of videogame? ");
        String name = sc.nextLine();
        System.out.print("prize? ");
        int prize = sc.nextInt();
        Videojuego add_game = new Videojuego(name, prize);
        if (!listado.contains(add_game))
        {
            listado.add(add_game);
            System.out.println("Game add...");
        }
    }

    private void EliminarAnimales() {
        Scanner sc = new Scanner(System.in);
        System.out.print("name of videogame?");
        String name = sc.nextLine();
        Videojuego del = new Videojuego(name);
        if (listado.remove(del))
        {
            System.out.println("game deleted..." + del.getNombre());
        }
        else
        {
            System.out.println("game not exists in your list");
        }
    }

    private void mostrarDatosAnimales() {
        for (Videojuego game : listado) {
            System.out.println(game.toString());
        }
        System.out.println("Items number: " + listado.size());
    }
    
        
    
}
