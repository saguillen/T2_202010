package view;

import model.data_structures.Multa;
import model.data_structures.Node;
import model.logic.Modelo;

public class View
{

	/**
	 * Metodo constructor
	 */
	public View()
	{

	}

	public void printMenu()
	{
		System.out.println(" **===========================================**");
		System.out.println(" ||              ==== MENU ====               ||");

		System.out.println(" || 0.Carga de Datos.                         ||");
		System.out.println(" || 1.Comparendos consecutivos por Infraccion.||");
		System.out.println(" || 2.Ultimos comparendos por Infraccion.     ||");
		System.out.println(" **===========================================**\n");

		// display hint
		this.displayHint();
		System.out.print("Input -> \n");
	}

	/**
	 * Displays an error message to the user if the option selected is invalid.
	 */
	public void badOption() {
		System.out.println("\n Invalid option !! \n");
	}

	/**
	 * Print a hint to the user to select an option.
	 */
	public void displayHint() {
		System.out.println(
				"Enter the number corresponding to the option, the press the Return "
						+ "key: (e.g ., 1,2..):\n");
	}

	// -------------------------------------------------------------
	// Option 0
	// -------------------------------------------------------------


	/**
	 * Print option 0 data.
	 */
	public void displayOp0PrimeroDataCola(String pInfo) {
		System.out.println("====== Informacion Primer Comparendo de la Cola ======");
		System.out.println("FECHA: "+ pInfo.split("\t")[0]);
		System.out.println("CLASE DE VEHICULO: "+ pInfo.split("\t")[1]);
		System.out.println("TIPO DE SERVICIO: " + pInfo.split("\t")[2]);
		System.out.println("INFRACCION: "+ pInfo.split("\t")[3]);
		System.out.println("DESCRIPCION DE INFRACC.: "+ pInfo.split("\t")[4]);
		System.out.println("LOCALIDAD: "+pInfo.split("\t")[5]);
		System.out.println("GEOLOCALIZACION: "+pInfo.split("\t")[6]);
		System.out.println("=======================================================\n");

	}

	public void displayOp0PrimeroDataPila(String pInfo) {
		System.out.println("====== Informacion Primer Comparendo de la Pila ======");
		System.out.println("FECHA: "+ pInfo.split("\t")[0]);
		System.out.println("CLASE DE VEHICULO: "+ pInfo.split("\t")[1]);
		System.out.println("TIPO DE SERVICIO: " + pInfo.split("\t")[2]);
		System.out.println("INFRACCION: "+ pInfo.split("\t")[3]);
		System.out.println("DESCRIPCION DE INFRACC.: "+ pInfo.split("\t")[4]);
		System.out.println("LOCALIDAD: "+pInfo.split("\t")[5]);
		System.out.println("GEOLOCALIZACION: "+pInfo.split("\t")[6]);
		System.out.println("======================================================\n");

	}

	// -------------------------------------------------------------
	// Option 1
	// -------------------------------------------------------------

	/**
	 * Print option 1 data.
	 */
	public void displayOp0UltimoData(String pInfo) {
		System.out.println("====== Informacion Ultimo Comparendo  ======");
		System.out.println("FECHA: "+ pInfo.split("\t")[0]);
		System.out.println("CLASE DE VEHICULO: "+ pInfo.split("\t")[1]);
		System.out.println("TIPO DE SERVICIO: " + pInfo.split("\t")[2]);
		System.out.println("INFRACCION: "+ pInfo.split("\t")[3]);
		System.out.println("DESCRIPCION DE INFRACC.: "+ pInfo.split("\t")[4]);
		System.out.println("LOCALIDAD: "+ pInfo.split("\t")[5]);
		System.out.println("GEOLOCALIZACION: "+pInfo.split("\t")[6]);
		System.out.println("======================\n");

	}

	// -------------------------------------------------------------
	// Option 2
	// -------------------------------------------------------------


	/**
	 * Print option 2 data.
	 */
	public void displayOp0sizeData(int pSize) {
		System.out.println("====== List Size ======");
		System.out.println("SIZE: "+ pSize);
		System.out.println("======================\n");

	}

	public void displayInfoComparendo(String pInfo){
		System.out.println("====== Comparendo Solicitado  ======");
		System.out.println("FECHA: "+ pInfo.split("\t")[0]);
		System.out.println("CLASE DE VEHICULO: "+ pInfo.split("\t")[1]);
		System.out.println("TIPO DE SERVICIO: "+ pInfo.split("\t")[2]);
		System.out.println("INFRACCION: "+ pInfo.split("\t")[3]);
		System.out.println("DESCRIPCION DE INFRACC.: "+ pInfo.split("\t")[4]);
		System.out.println("LOCALIDAD: "+ pInfo.split("\t")[5]);
		System.out.println("GEOLOCALIZACION: "+pInfo.split("\t")[6]);
		System.out.println("====================================\n");

	}

	public void displayInputInfr()
	{
		System.out.println("=========================================================\n");
		System.out.println("DIGITE EL CODIGO DE INFRACCION DEL/LOS COMPARENDO A BUSCAR");
		System.out.println("=========================================================\n");
	}
	public void displayCluster()
	{
		System.out.println("===========================================\n");
		System.out.println("CLUSTER DE COMPARENDOS CON MISMA INFRACCION");
		System.out.println("===========================================\n");
	}
	public void displayInfoComparendosCluster(String pInfo) {
		System.out.println("====== Comparendos por cluster ======");
		System.out.println("INFRACCION: "+ pInfo.split("\t")[3]);
		System.out.println("ID: "+pInfo.split("\t")[7]);
		System.out.println("FECHA: "+ pInfo.split("\t")[0]);
		System.out.println("CLASE DE VEHICULO: "+ pInfo.split("\t")[1]);
		System.out.println("TIPO DE SERVICIO: " + pInfo.split("\t")[2]);
		System.out.println("LOCALIDAD: "+pInfo.split("\t")[5]);
		System.out.println("======================================\n");

	}

	public void displayClusterSize(int pSize)
	{
		System.out.println("====== Cluster Size ======");
		System.out.println("SIZE: "+ pSize);
	}

	public void displayTotalComparendosLeidos(int pSize)
	{
		System.out.println("====== Numero de Comparendos leidos. ======");
		System.out.println("				  #"+ pSize);
		System.out.println("===========================================\n");
	}

	public void displayQueueCompR(String pInfo)
	{
		System.out.println("====== Comparendos resultantes. ======");
		System.out.println("INFRACCION: "+ pInfo.split("\t")[3]);
		System.out.println("ID: "+pInfo.split("\t")[7]);
		System.out.println("FECHA: "+ pInfo.split("\t")[0]);
		System.out.println("CLASE DE VEHICULO: "+ pInfo.split("\t")[1]);
		System.out.println("TIPO DE SERVICIO: " + pInfo.split("\t")[2]);
		System.out.println("LOCALIDAD: "+pInfo.split("\t")[5]);
		System.out.println("======================================\n");

	}

	public void displayQueueResSize(int numComp)
	{
		System.out.println("====== Numero de Comparendos leidos. ======");
		System.out.println("				  #"+numComp);
		System.out.println("===========================================");
	}
	public void displayInputUltimos()
	{
		System.out.println("=========================================================\n");
		System.out.println("DIGITE EL NUMERO N DE ULTIMOS COMPARENDOS A BUSCAR");
		System.out.println("=========================================================\n");
	}
	public void displayUltimosComparendosSize(int pSize)
	{
		System.out.println("====== INFORMACIÓN =====================================\n");
		System.out.println("SE ENCONTRARON: "+ pSize+ " COMPARENDOS");
		System.out.println("=========================================================\n");
	}
	
}

