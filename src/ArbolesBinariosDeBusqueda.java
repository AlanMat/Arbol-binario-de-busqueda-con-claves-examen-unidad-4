/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alan
 */
public class ArbolesBinariosDeBusqueda {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ArbolAVL arbolitoAVL=new ArbolAVL();
        //Insertando
        arbolitoAVL.insertar(50);
        arbolitoAVL.insertar(25);
        arbolitoAVL.insertar(75);
        arbolitoAVL.insertar(10);
        arbolitoAVL.insertar(40);
        arbolitoAVL.insertar(60);
        arbolitoAVL.insertar(90);
        arbolitoAVL.insertar(35);
        arbolitoAVL.insertar(70);
        arbolitoAVL.insertar(42);
        //arbolitoAVL.insertar(90);
        
        arbolitoAVL.preOrden(arbolitoAVL.obtenerRaiz());
        
    }
    
}
