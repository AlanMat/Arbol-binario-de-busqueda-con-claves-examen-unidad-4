/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alan
 */
public class ArbolAVL {
    private NodoArbolAVL raiz;
    public ArbolAVL(){
    raiz=null;
    }
    public NodoArbolAVL obtenerRaiz(){
        return raiz;
    }
    // buscar
    public NodoArbolAVL buscar(int d, NodoArbolAVL r){
        if(raiz==null){
        
        }else if (r.dato==d){
        return r;
        }else if (r.dato<d){
            return buscar(d,r.hijoDerecho);
        }else{
        return buscar(d,r.hijoIzquierdo);
        }
        return null;
        
        
    }
    
     //obtener el factor de equilibrio
    public int obtenerFE(NodoArbolAVL x){
        if(x==null){
            return -1;
        }else{
            return x.fe;
        }
    }
    //Rotacion simple Izquirda
    public NodoArbolAVL rotacionIzquierda(NodoArbolAVL C){
        NodoArbolAVL auxiliar=C.hijoIzquierdo;
        C.hijoIzquierdo=auxiliar.hijoDerecho;
        auxiliar.hijoDerecho=C;
        C.fe=Math.max(obtenerFE(C.hijoIzquierdo),obtenerFE(C.hijoDerecho))+1;
        auxiliar.fe=Math.max(obtenerFE(auxiliar.hijoIzquierdo),obtenerFE(auxiliar.hijoDerecho))+1;
        return auxiliar;
      
        
    }
    //Rotacion simple Derecho
    public NodoArbolAVL rotacionDerecha(NodoArbolAVL C){
        NodoArbolAVL auxiliar=C.hijoDerecho;
        C.hijoDerecho=auxiliar.hijoIzquierdo;
        auxiliar.hijoIzquierdo=C;
        C.fe=Math.max(obtenerFE(C.hijoIzquierdo),obtenerFE(C.hijoDerecho))+1;
        auxiliar.fe=Math.max(obtenerFE(auxiliar.hijoIzquierdo),obtenerFE(auxiliar.hijoDerecho))+1;
        return auxiliar;
      
        
    }
    //Roracion doble ala derecha
    public NodoArbolAVL rotacionDobleIzquierda(NodoArbolAVL C){
        NodoArbolAVL temporal;
        C.hijoIzquierdo=rotacionDerecha(C.hijoIzquierdo);
        temporal=rotacionIzquierda(C);
        return temporal;
       
        
    }
    
    // Rotacion doble a l izquierda
    public NodoArbolAVL rotacionDobleDerecha(NodoArbolAVL C){
        NodoArbolAVL temporal;
        C.hijoDerecho=rotacionIzquierda(C.hijoDerecho);
        temporal=rotacionDerecha(C);
        return temporal;
    }
    // Metodo para insrtar AVL
    public NodoArbolAVL insertarAVL(NodoArbolAVL nuevo,NodoArbolAVL subAr){
        NodoArbolAVL nuevoPadre=subAr;
        if (nuevo.dato<subAr.dato){
            if(subAr.hijoIzquierdo==null){
                subAr.hijoIzquierdo=nuevo;
            }else{
                subAr.hijoIzquierdo=insertarAVL(nuevo,subAr.hijoIzquierdo);
                if(obtenerFE(subAr.hijoIzquierdo)-obtenerFE(subAr.hijoDerecho)==2){
                    if(nuevo.dato<subAr.hijoIzquierdo.dato){
                        nuevoPadre=rotacionIzquierda(subAr);
                        
                    }else{
                        nuevoPadre=rotacionDobleIzquierda(subAr);
                    }
                    
                }
            }
        }else if(nuevo.dato>subAr.dato){
            if(subAr.hijoDerecho==null){
                subAr.hijoDerecho=nuevo;
            }else{
                subAr.hijoDerecho=insertarAVL(nuevo,subAr.hijoDerecho);
                if((obtenerFE(subAr.hijoDerecho)-obtenerFE(subAr.hijoIzquierdo)==2)){
                    if (nuevo.dato>subAr.hijoDerecho.dato){
                        nuevoPadre=rotacionDerecha(subAr);
                        
                    }else{
                        nuevoPadre=rotacionDobleDerecha(subAr);
                    }
                }
            }
        }else{
            System.out.print("Nodo duplicado");
        }
        //Actualizando la altura
        if((subAr.hijoIzquierdo==null)&&(subAr.hijoDerecho!=null)){
            subAr.fe=subAr.hijoDerecho.fe+1;
        }else if((subAr.hijoDerecho ==null)&&(subAr.hijoIzquierdo!=null)){
            subAr.fe=subAr.hijoIzquierdo.fe+1;
            
        }else{
            subAr.fe=Math.max(obtenerFE(subAr.hijoIzquierdo), obtenerFE(subAr.hijoDerecho))+1;
        }
        return nuevoPadre;
        
        
    }
    //metodo para insertar
    public void insertar(int d){
        NodoArbolAVL nuevo=new NodoArbolAVL(d);
        if(raiz==null){
            raiz=nuevo;
        }else{
            raiz=insertarAVL(nuevo,raiz);
        }
        
    }
    //Recorridos
    
    // Método para recorrer el árbol InOrden
     public void inOrden ( NodoArbolAVL r) {
        if(r!=null){
            inOrden (r.hijoIzquierdo);
            System.out.print(r.hijoIzquierdo +  " , " );
            inOrden (r.hijoDerecho);
        }
    }

    // Método para recorrer el árbol PreOrden
    public  void  preOrden ( NodoArbolAVL r ) {
        if (r!= null ) {
            System.out.print(r.dato +  " , " );
            preOrden (r.hijoIzquierdo);
            preOrden (r.hijoDerecho);
        }
    }

    // Método para recorrer el árbol PostOrden
    public  void  postOrden (  NodoArbolAVL r) {
         if (r!= null ) {
            postOrden (r.hijoIzquierdo);
            postOrden (r.hijoDerecho);
            System.out.print(r.dato +  " , " );
        }
    }
}
