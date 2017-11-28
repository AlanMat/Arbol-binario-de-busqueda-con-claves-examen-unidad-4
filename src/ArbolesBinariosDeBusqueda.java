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
        arbolitoAVL.insertar(10);
        arbolitoAVL.insertar(5);
        arbolitoAVL.insertar(13);
        arbolitoAVL.insertar(1);
        arbolitoAVL.insertar(6);
        arbolitoAVL.insertar(17);
        arbolitoAVL.insertar(16);
            
        
        arbolitoAVL.preOrden(arbolitoAVL.obtenerRaiz());
        
    }
    
}
