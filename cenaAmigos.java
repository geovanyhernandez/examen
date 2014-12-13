import java.util.Scanner;
import java.io.IOException;
import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.FileReader;

public class cenaAmigos{ 

	public static void main(String[] args) throws IOException{

		
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Nº de recetas que desea utilizar: ");
		int numreceta = sc.nextInt();

		ArrayList<Receta> recetas= new ArrayList<Receta>();
		ArrayList<Ingrediente> ingredientes= new ArrayList<Ingrediente>();

		for(int q=0; q<numreceta; q++){
			Receta receta = new Receta();

			System.out.println("Escribe el nombre de la receta: ");
			receta.setNombreReceta(sc.next());

			System.out.println("Escribe el Nº de ingredientes: ");
			int numIngredientes=sc.nextInt();

			ingredientes = new ArrayList<Ingrediente>();

			for(int i=0; i<numIngredientes; i++){
				Ingrediente ingrediente = new Ingrediente();
				

				System.out.println("dame el nombre del ingrediente " + (i+1));
				ingrediente.setNombreIngrediente(sc.next());
				char enGramos;
				
				do{ 
					System.out.println("la cantidad es en gramos? + (S/N)");
				
					 enGramos = sc.next().charAt(0);
					switch(enGramos) {

					case 'S':
							ingrediente.setEnGramos(true);
							System.out.println("dame la cantidad en gramos");
							ingrediente.setCantidadGramos(sc.nextInt());
							
							break;

					case 'N':
							ingrediente.setEnGramos(false);
							System.out.println("dame la cantidad en unidad");
							ingrediente.setCantidadUnidad(sc.nextInt());
							
							break;
						default:
							System.out.println("intentalo otra vez ");
							break;
					}
				} while ((enGramos != 'S') && (enGramos != 'N'));
				ingredientes.add(ingrediente);
			}
				receta.setIngredientes(ingredientes);
				System.out.println("ahora explica como se prepara la receta: ");
				receta.setPreparacion(sc.next());
				recetas.add(receta);
		} 
			
			///////////////punto2///////////////

			File archivo = new File("/home/zubiri/Escritorio/recu/recetas.txt");
			FileWriter fw = new FileWriter(archivo);

			for (int l=0; l<recetas.size(); l++) {

				fw.write(recetas.get(l).getNombreReceta() + ";");
				
				 ingredientes = recetas.get(l).getIngredientes();

			   for (int a=0 ; a<ingredientes.size(); a++) {

					fw.write(ingredientes.get(a).getNombreIngrediente() + "*");
					fw.write(ingredientes.get(a).getCantidadGramos() + "*");
					fw.write(ingredientes.get(a).getCantidadUnidad() + "*");
					
					

					if (a ==ingredientes.size()  -1){
					fw.write(ingredientes.get(a).getEnGramos() + ";");
					}
					else{fw.write(ingredientes.get(a).getEnGramos() + "#");
					}
				
				}
				fw.write(recetas.get(l).getPreparacion() + "\n");	
				 
			} 

			 fw.close(); 

			 ////////ejercicio3//////////
			 try{
			 	 File fl = new File("/home/zubiri/Escritorio/recu/recetas.txt");
				 FileInputStream fis= new FileInputStream(fl);
			     InputStreamReader isr= new InputStreamReader(fis, "UTF8");
			     BufferedReader br = new BufferedReader(isr);

			     String linea;
			     linea = br.readLine();
			     String [] campos=null;
			     System.out.println("\nTus recetas...");
			    while(linea!=null){
			     	
			     	campos = linea.split(";");
			     	System.out.println("----------------------------------");
			     	System.out.println("Nombre: " +campos[0]);
			     	System.out.println("Descripcion: " +campos[2]);
			     	
			     	String ingre = campos[1];
					campos = ingre.split("#");
			     	for (int x=0; x<campos.length; x++) {
			     		String camposeparados = campos[x];
			     		String [] campos2 = camposeparados.split("\\*");


			     		System.out.println("ingredientes: ");
			     		System.out.println("nombre " +campos2[0]);
			     		System.out.println("gramos " +campos2[1]);
			     		System.out.println("unidad " +campos2[2]);
			     		System.out.println("--------------------------------");
				 	}
				 	
			   		 linea = br.readLine();
			   	}

			   		}catch(Exception ioe){
	    			System.out.println("Error: "+ioe);
					}	


	}
}
