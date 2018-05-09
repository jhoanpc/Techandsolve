package com.co.techandsolve.business;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

import javax.ejb.Stateless;
import javax.inject.Inject;

import org.apache.commons.lang.ArrayUtils;
import org.apache.log4j.Logger;

import com.ibm.icu.util.Calendar;

import co.com.entities.MudanzasEntity;


@Stateless
public class MudanzaBusiness {

	private static final Logger logger = Logger.getLogger(MudanzaBusiness.class.getName());

	@Inject
	private ManejadorMudanzas manejadorMudanzas;
	//peso que puede llevar
	private static int PESO = 50;
	private String test = "";
	
	
  public MudanzaBusiness(){
	  

  }

 public String realizarMudanza(byte[] archivo, String numeroDocumento)  {
	
	 String restul ="";
	 String file = new String(archivo);
	 
	 StringBuffer contenidoString = new StringBuffer();
	 contenidoString.append(test);
	  
	 int[] contenido = Arrays.stream(file.split("\n")).mapToInt(Integer::parseInt).toArray(); 
	 int numeroDias = contenido[0];
	 int elementos = 0;
	 int posContent = 0;
	 contenido = java.util.Arrays.copyOfRange(contenido, 1, contenido.length);
	 
	 contenidoString = new StringBuffer();
	 for(int i =0; i < numeroDias; i++){
		 
		 elementos = contenido[posContent];
		 posContent++;
		 int [] copyTo = java.util.Arrays.copyOfRange(contenido, posContent, posContent + elementos);
		 
		 restul = generarRegistro(copyTo);
		 
		 String testCase = "TestCase #"+i +": " + restul + "\n";
		 contenidoString.append(testCase );
		 posContent = posContent + elementos;
		 
		 registrarMudanza(testCase, numeroDocumento);
	 }
	 
	 
	 
	
	 
	 return contenidoString.toString();
   }
 
   private String generarRegistro (int [] registros){
	   
	   int sumaTotal = 0;
	   int cantidadViajes = 0;
	   int pos=0;
	   
	   if (registros != null & registros.length > 0){
		   
		   
         
		   //ordenamiento de elementos
             burbuja(registros);            
             //de mayor a menor
             ArrayUtils.reverse(registros);                	
                                               	
        	   
    		   
    		   while(pos < registros.length){
    			   
    			   int tempPeso = registros[pos];
    			   
    			   if (tempPeso > PESO){
    				   cantidadViajes++;
    			   }else{
    				  
    				   sumaTotal = sumaTotal + (registros[pos]);
    				   if (sumaTotal > PESO){
    					   cantidadViajes++;
    					  
    					   sumaTotal = 0;
    				   }
    			   }
    			   
    			   pos++;
    		   }
    		   
    		   if (sumaTotal < 50 && sumaTotal > 0){
    			   cantidadViajes++;
    		   }
          
	   }
	   
    return ""+cantidadViajes;   
   }
   
   public static void burbuja(int [] A){
       int i, j, aux;
       for(i=0;i<A.length-1;i++)
            for(j=0;j<A.length-i-1;j++)
                 if(A[j+1]<A[j]){
                    aux=A[j+1];
                    A[j+1]=A[j];
                    A[j]=aux;
                 }
     }
  
  
   /*
    * guardar registro base de datos
    * */
   public boolean registrarMudanza(String testCase, String numeroDocumento) {
		
		boolean grabado = false;
		try {
			
			
			MudanzasEntity mudanzasEntity = new MudanzasEntity();
			mudanzasEntity.setFechaEjecucion(Calendar.getInstance().getTime());
			mudanzasEntity.setTestCase(testCase);
			mudanzasEntity.setUsuariocreacion(numeroDocumento);
				
				
			mudanzasEntity =manejadorMudanzas.crearRegistroMudanza(mudanzasEntity);
				
			
			if (mudanzasEntity.getIdMudanza() > 0){
				grabado = true;
			}
				
			

		
		} catch (Exception e) {
			
			try {
				throw new Exception(""+e.getMessage());
			} catch (Exception e1) {
				
			}
		}
		
		return grabado;

	}
	

   
}
