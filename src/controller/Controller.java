package controller;

import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

import model.data_structures.Multa;
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
	 */
	public Controller ()
	{
		view = new View();
		modelo = new Modelo();
	}
		
	public void run() {
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

							Stack<Multa> respuesta = modelo.ModeloJSON();
							String info = respuesta.peek().toString();
							view.displayOp0PrimeroData(info);

							int pSize = respuesta.getSize();
							view.displayOp0sizeData(pSize);

						} catch (FileNotFoundException e) {

							e.printStackTrace();
						}
						break;

					case 1:
						view.displayInput();
						String input = reader.next();
						Multa respuesta = modelo.buscar();
						view.displayInfoComparendo(respuesta.toString());
						break;

					//Opcion No valida.
					default:
						view.badOption();
						fin = true;
						break;
				}
			}
		}
		catch(InputMismatchException e){
			run();
		}
	}
}
