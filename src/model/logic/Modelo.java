package model.logic;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;

import model.data_structures.Multa;
import model.data_structures.Node;
import model.data_structures.Queue;
import model.data_structures.Stack;


/**
 * Definicion del modelo del mundo
 *
 */
public class Modelo {

	Queue<Multa> cola = new Queue<>();
	Stack<Multa> stack = new Stack<>();


	public Queue<Multa> ModeloJSON() throws FileNotFoundException
	{
		String path = "./data/comparendos_dei_2018_small.geojson";
		JsonReader reader;
		try{

			reader = new JsonReader(new FileReader(path));
			JsonElement elem = JsonParser.parseReader(reader);
			JsonArray features = elem.getAsJsonObject().get("features").getAsJsonArray();
			for(JsonElement e : features)
			{
				JsonElement properties = e.getAsJsonObject().get("properties");

				String id = properties.getAsJsonObject().get("OBJECTID").getAsString();
				String fechaHora = properties.getAsJsonObject().get("FECHA_HORA").getAsString();
				String clase = properties.getAsJsonObject().get("CLASE_VEHI").getAsString();
				String tipo = properties.getAsJsonObject().get("TIPO_SERVI").getAsString();
				String infrac = properties.getAsJsonObject().get("INFRACCION").getAsString();
				String descr = properties.getAsJsonObject().get("DES_INFRAC").getAsString();
				String localidad = properties.getAsJsonObject().get("LOCALIDAD").getAsString();


				List<Double> geo = new ArrayList<>();
				if(e.getAsJsonObject().has("geometry") && !e.getAsJsonObject().get("geometry").isJsonNull())
				{
					for(JsonElement geoElem : e.getAsJsonObject().get("geometry").getAsJsonObject().get("coordinates").getAsJsonArray()){
						geo.add(geoElem.getAsDouble());
					}
				}

				Multa m = new Multa(clase, tipo, infrac, descr, localidad, fechaHora, geo, id);

				cola.enqueue(m);

			}


		}catch (FileNotFoundException e){
			e.printStackTrace();
		}System.out.println(cola.darTama�o());
		return cola;

	}

	public Queue<Multa> cluster()
	{
		Queue<Multa> cluster = new Queue<>();
		String infracActual = "";
		String infracMax = "";
		int repeActual = 0;
		int repeMaxima=0;

		for(int i = 0; i<cola.darTama�o();i++)
		{
			Multa m = cola.darActual(i).darValor();
			if(m.darInfraccion().equalsIgnoreCase(infracActual)){
				if(cola.darActual(i).darSiguiente().darValor().darInfraccion().equalsIgnoreCase(infracMax)){
					repeActual++;
				}if(cola.darActual(i).darAnterior()!=null&&cola.darActual(i).darAnterior().darValor().darInfraccion().equalsIgnoreCase(infracMax)){
					repeActual++;
				}

			}else{
				repeActual= 1;
				infracActual=m.darInfraccion();
			}
			if(repeActual>repeMaxima)
			{
				repeMaxima=repeActual;
				infracMax=infracActual;                          //&&cola.darActual(i).darSiguiente().darValor().darInfraccion().equalsIgnoreCase(infracMax)
			}
			if(m.darInfraccion().equalsIgnoreCase(infracMax))
			{
				if(cola.darActual(i).darSiguiente().darValor().darInfraccion().equalsIgnoreCase(infracMax))
					cluster.enqueue(m);
				if(cola.darActual(i).darAnterior()!=null&&cola.darActual(i).darAnterior().darValor().darInfraccion().equalsIgnoreCase(infracMax))
				{
					cluster.enqueue(m);
				}
			}
		}
		return cluster;
	}

	public Stack<Multa> ModelJSON() throws FileNotFoundException {
		String path = "./data/comparendos_dei_2018_small.geojson";
		JsonReader reader;

		try {

			reader = new JsonReader(new FileReader(path));
			JsonElement elem = JsonParser.parseReader(reader);
			JsonArray features = elem.getAsJsonObject().get("features").getAsJsonArray();
			for (JsonElement e : features) {
				JsonElement properties = e.getAsJsonObject().get("properties");

				String id = properties.getAsJsonObject().get("OBJECTID").getAsString();
				String fechaHora = properties.getAsJsonObject().get("FECHA_HORA").getAsString();
				String clase = properties.getAsJsonObject().get("CLASE_VEHI").getAsString();
				String tipo = properties.getAsJsonObject().get("TIPO_SERVI").getAsString();
				String infrac = properties.getAsJsonObject().get("INFRACCION").getAsString();
				String descr = properties.getAsJsonObject().get("DES_INFRAC").getAsString();
				String localidad = properties.getAsJsonObject().get("LOCALIDAD").getAsString();


				List<Double> geo = new ArrayList<>();
				if (e.getAsJsonObject().has("geometry") && !e.getAsJsonObject().get("geometry").isJsonNull()) {
					for (JsonElement geoElem : e.getAsJsonObject().get("geometry").getAsJsonObject().get("coordinates").getAsJsonArray()) {
						geo.add(geoElem.getAsDouble());
					}
				}

				Multa m = new Multa(clase, tipo, infrac, descr, localidad, fechaHora, geo, id);

				stack.push(m);
			}


		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return stack;

	}


	public Queue<Multa> comparendosporInfraccion(int N, String pInfracc)
	{
		Queue<Multa> queueM = new Queue<>();
		for(int i= 0; i < stack.getSize()&&queueM.darTama�o()<N; ++i)
		{
				Multa m = stack.darActual(i).darValor();
				if(m.darInfraccion().equalsIgnoreCase(pInfracc))
				{
					queueM.enqueue(m);
				}
			stack.pop(m);
		}
		System.out.println("tama�o de la pila " + stack.getSize() );
		System.out.println("Tama�o de la cola por multa final" +queueM.darTama�o());

		
		return queueM;
	}

	public Multa buscar() {
		return null;
	}



}