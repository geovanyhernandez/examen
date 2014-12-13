public class Ingrediente{

	String nombreIngrediente;
	int cantidadGramos;
	int cantidadUnidad;
	boolean enGramos;

public void setNombreIngrediente(String nombreIngrediente){
	this.nombreIngrediente=nombreIngrediente;
}
public void setCantidadGramos(int cantidadGramos){
	this.cantidadGramos=cantidadGramos;
}
public void setCantidadUnidad(int cantidadUnidad){
	this.cantidadUnidad=cantidadUnidad;
}
public void setEnGramos(boolean enGramos){
	this.enGramos=enGramos;
}

////get\\\\

public String getNombreIngrediente(){
	return nombreIngrediente;
}
public int getCantidadGramos(){
	return  cantidadGramos;
}
public int getCantidadUnidad(){
	return cantidadUnidad;
}
public boolean getEnGramos(){
	return enGramos;
}
}