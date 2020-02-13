package test.data_structures;
import org.junit.Test;
import static org.junit.Assert.*;
import model.data_structures.IQueue;
import model.data_structures.Multa;
import model.data_structures.Node;
import model.data_structures.Queue;
import model.logic.Modelo;

public class TestQueue<T extends Comparable<T>> {

	private IQueue<Multa> cola;
	private Modelo modelo;
	
	public TestQueue()
	{
		cola = new Queue<>();
		
		
	}
	public void setUp1()
	{
		cola = new Queue<>();
	}
	public void setUp2()
	{
		setUp1();
		Multa m2 = new Multa("CAMIONETA", "Particular", "C35", "NO REALIZAR LA REVISIÓN TECNICOMECÁNICA EN EL PLAZO LEGAL ESTABLECIDO O CUANDO EL VEHÍCULO  NO SE ENCUENTRE EN ADECUADAS CONDICIONES TECNICOMECÁNICAS O DE EMISIONES CONTAMINANTES, AÚN CUANDO PORTE LOS CERTIFICADOS CORRESPONDIENTES, ADEMÁS EL VEHÍC", "TUNJUELITO", "2018/01/17", null, "509329");
		cola.enqueue(m2);
		cola.enqueue(m2);
		cola.enqueue(m2);
	}
	@Test
	public void testIsEmpty()
	{
		setUp1();
		assertTrue(cola.isEmpty());
		assertEquals(0, cola.darTamaño());
		
	}
	@Test
	public void testEnqueue()
	{
		setUp1();
		assertTrue(cola.isEmpty());
		Multa m1 = new Multa("AUTOMÓVIL", "Particular", "C02", "ESTACIONAR UN VEHÍCULO EN SITIOS PROHIBIDOS.", "BARRIOS UNIDOS", "2018/12/10", null, "12345");
		Multa m2 = new Multa("CAMIONETA", "Particular", "C35", "NO REALIZAR LA REVISIÓN TECNICOMECÁNICA EN EL PLAZO LEGAL ESTABLECIDO O CUANDO EL VEHÍCULO  NO SE ENCUENTRE EN ADECUADAS CONDICIONES TECNICOMECÁNICAS O DE EMISIONES CONTAMINANTES, AÚN CUANDO PORTE LOS CERTIFICADOS CORRESPONDIENTES, ADEMÁS EL VEHÍC", "TUNJUELITO", "2018/01/17", null, "509329");

		cola.enqueue(m1);
		cola.enqueue(m1);
		cola.enqueue(m2);
		assertFalse(cola.isEmpty());
		assertEquals(3, cola.darTamaño());

	}
	@Test
	public void testDequeue()
	{
		setUp1();
		assertTrue(cola!=null);
		Multa m1 = new Multa("AUTOMÓVIL", "Particular", "C02", "ESTACIONAR UN VEHÍCULO EN SITIOS PROHIBIDOS.", "BARRIOS UNIDOS", "2018/12/10", null, "12345");
		Multa m2 = new Multa("CAMIONETA", "Particular", "C35", "NO REALIZAR LA REVISIÓN TECNICOMECÁNICA EN EL PLAZO LEGAL ESTABLECIDO O CUANDO EL VEHÍCULO  NO SE ENCUENTRE EN ADECUADAS CONDICIONES TECNICOMECÁNICAS O DE EMISIONES CONTAMINANTES, AÚN CUANDO PORTE LOS CERTIFICADOS CORRESPONDIENTES, ADEMÁS EL VEHÍC", "TUNJUELITO", "2018/01/17", null, "509329");
		cola.enqueue(m2);
		cola.enqueue(m2);
		cola.enqueue(m1);
		assertEquals(3, cola.darTamaño());
		assertEquals(m1, cola.darActual(2).darValor());
		cola.dequeue();
		cola.dequeue();
		cola.dequeue();
		assertEquals(0, cola.darTamaño());
	}
	@Test
	public void testdarActual()
	{
		setUp2();
		assertTrue(cola!=null);
		Multa m1 = new Multa("AUTOMÓVIL", "Particular", "C02", "ESTACIONAR UN VEHÍCULO EN SITIOS PROHIBIDOS.", "BARRIOS UNIDOS", "2018/12/10", null, "12345");
		cola.enqueue(m1);
		assertEquals(m1, cola.darActual(3).darValor());
		
	}
	
}
