package controller;

import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

import model.data_structures.Multa;
import model.data_structures.Queue;
import model.logic.Modelo;
import view.View;

public class Controller {

	/* Instancia del Modelo*/
	private Modelo modelo;
	//
	/* Instancia de la Vista*/
	private View view;
	
	private Scanner reader;

	
	/**
	 * Crear la vista y el modelo del proyecto
	 * @param capacidad tamaNo inicial del arreglo
	 */
	public Controller ()
	{
		view = new View();
		modelo = new Modelo();
	}
		
	public void run() throws InputMismatchException
	{
		reader = new Scanner(System.in);
		try
		{
			boolean fin = false;
			while( !fin ){
				view.printMenu();
				int option = reader.nextInt();
				switch(option){
				case 0: 
					try {

						Queue<Multa> respuesta = modelo.ModeloJSON();
						String info = (respuesta.darPrimero().darValor().toString());
						view.displayOp0PrimeroData(info);

//						info = (respuesta.darPrimero().darValor().toString());
//						view.displayOp0UltimoData(info);
						
						int pSize = respuesta.darTamaño();
						view.displayOp0sizeData(pSize);

					} catch (FileNotFoundException e) {

						e.printStackTrace();
					}
					break;

				case 1:
				//	LinkedListImp<Multa> respuesta = modelo.ModeloJSON();

//					view.displayInput();
//					String input = reader.next();
//				Multa respuesta = modelo.buscar(input);
//					view.displayInfoComparendo(respuesta.darId());
					view.displayCluster();
					Queue<Multa> respuesta = modelo.cluster();
					System.out.println("tamaño del cluster" + respuesta.darTamaño());

					for(int i=0; i<respuesta.darTamaño();i++)
					{
						Multa multa= respuesta.darActual(i).darValor();
						view.displayInfoComparendosCluster(multa.toString());
					}
				break;
//
//					//Opcion No valida.
				default: 
					view.badOption();
					fin = true;
//					break;
					
					
					
				}
			}
		}
		catch(InputMismatchException e){
			run();
		
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
