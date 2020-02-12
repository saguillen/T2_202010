package controller;

import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

import model.data_structures.Multa;
import model.data_structures.Queue;
import model.data_structures.Stack;
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
							Stack<Multa> resp = modelo.ModelJSON();
							Queue<Multa> respuesta = modelo.ModeloJSON();
							String info = (respuesta.darPrimero().darValor().toString());
							String info2 = resp.getTopOfStack().darValor().toString();
							//
							view.displayTotalComparendosLeidos(resp.getSize());
							//
							view.displayOp0PrimeroDataCola(info);
							//
							view.displayOp0PrimeroDataPila(info2);

//						info = (respuesta.darPrimero().darValor().toString());
//						view.displayOp0UltimoData(info);


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
						view.displayClusterSize(respuesta.darTamaño());

						for(int i=0; i<respuesta.darTamaño();i++)
						{
							Multa multa= respuesta.darActual(i).darValor();
							view.displayInfoComparendosCluster(multa.toString());
						}
						break;

					case 2:

						view.displayInputInfr();
						String input = reader.next();
						Queue<Multa> multaQueue = modelo.cluster();
						for(int i = 0; i < multaQueue.darTamaño(); ++i)
						{
							Multa m = multaQueue.darActual(i).darValor();
							Queue<Multa> r = modelo.comparendosporInfraccion(m , input);
							view.displayQueueCompR(r.toString());
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