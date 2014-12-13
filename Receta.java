import java.util.ArrayList; 

public class Receta{


private String nombreReceta;
private ArrayList<Ingrediente>ingredientes;
private String preparacion;

public void setNombreReceta(String nombreReceta){

	this.nombreReceta=nombreReceta;
}
public void setIngredientes(ArrayList<Ingrediente>ingredientes){

	this.ingredientes=ingredientes;
}
public void setPreparacion(String preparacion){

	this.preparacion=preparacion;
}

///////comienzan los get\\\\\\\\

public String getNombreReceta(){

	return nombreReceta;
}
public ArrayList<Ingrediente>getIngredientes(){

	return ingredientes;
}
public String getPreparacion(){
	return preparacion;
}

}