package controller;

import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

import model.data_structures.IQueue;
import model.data_structures.IStack;
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
							IStack<Multa> resp = modelo.ModelJSON();
							IQueue<Multa> respuesta = modelo.ModeloJSON();
							String info = (respuesta.darPrimero().darValor().toString());
							String info2 = resp.getTopOfStack().darValor().toString();
							//
							view.displayTotalComparendosLeidos(resp.getSize());
							//
							view.displayOp0PrimeroDataCola(info);
							//
							view.displayOp0PrimeroDataPila(info2);




						} catch (FileNotFoundException e) {

							e.printStackTrace();
						}
						break;

					case 1:
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
						view.displayInputUltimos();
						String N = reader.next();								
						Queue<Multa> r = modelo.comparendosporInfraccion(Integer.parseInt(N), input);
						view.displayUltimosComparendosSize(r.darTamaño());
						for(int i = 0; i < r.darTamaño(); ++i)
						{
							Multa m = r.darActual(i).darValor();
							view.displayQueueCompR(m.toString());
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