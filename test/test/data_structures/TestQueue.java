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
		Multa m2 = new Multa("CAMIONETA", "Particular", "C35", "NO REALIZAR LA REVISI�N TECNICOMEC�NICA EN EL PLAZO LEGAL ESTABLECIDO O CUANDO EL VEH�CULO  NO SE ENCUENTRE EN ADECUADAS CONDICIONES TECNICOMEC�NICAS O DE EMISIONES CONTAMINANTES, A�N CUANDO PORTE LOS CERTIFICADOS CORRESPONDIENTES, ADEM�S EL VEH�C", "TUNJUELITO", "2018/01/17", null, "509329");
		cola.enqueue(m2);
		cola.enqueue(m2);
		cola.enqueue(m2);
	}
	@Test
	public void testIsEmpty()
	{
		setUp1();
		assertTrue(cola.isEmpty());
		assertEquals(0, cola.darTama�o());
		
	}
	@Test
	public void testEnqueue()
	{
		setUp1();
		assertTrue(cola.isEmpty());
		Multa m1 = new Multa("AUTOM�VIL", "Particular", "C02", "ESTACIONAR UN VEH�CULO EN SITIOS PROHIBIDOS.", "BARRIOS UNIDOS", "2018/12/10", null, "12345");
		Multa m2 = new Multa("CAMIONETA", "Particular", "C35", "NO REALIZAR LA REVISI�N TECNICOMEC�NICA EN EL PLAZO LEGAL ESTABLECIDO O CUANDO EL VEH�CULO  NO SE ENCUENTRE EN ADECUADAS CONDICIONES TECNICOMEC�NICAS O DE EMISIONES CONTAMINANTES, A�N CUANDO PORTE LOS CERTIFICADOS CORRESPONDIENTES, ADEM�S EL VEH�C", "TUNJUELITO", "2018/01/17", null, "509329");

		cola.enqueue(m1);
		cola.enqueue(m1);
		cola.enqueue(m2);
		assertFalse(cola.isEmpty());
		assertEquals(3, cola.darTama�o());

	}
	@Test
	public void testDequeue()
	{
		setUp1();
		assertTrue(cola!=null);
		Multa m1 = new Multa("AUTOM�VIL", "Particular", "C02", "ESTACIONAR UN VEH�CULO EN SITIOS PROHIBIDOS.", "BARRIOS UNIDOS", "2018/12/10", null, "12345");
		Multa m2 = new Multa("CAMIONETA", "Particular", "C35", "NO REALIZAR LA REVISI�N TECNICOMEC�NICA EN EL PLAZO LEGAL ESTABLECIDO O CUANDO EL VEH�CULO  NO SE ENCUENTRE EN ADECUADAS CONDICIONES TECNICOMEC�NICAS O DE EMISIONES CONTAMINANTES, A�N CUANDO PORTE LOS CERTIFICADOS CORRESPONDIENTES, ADEM�S EL VEH�C", "TUNJUELITO", "2018/01/17", null, "509329");
		cola.enqueue(m2);
		cola.enqueue(m2);
		cola.enqueue(m1);
		assertEquals(3, cola.darTama�o());
		assertEquals(m1, cola.darActual(2).darValor());
		cola.dequeue();
		cola.dequeue();
		cola.dequeue();
		assertEquals(0, cola.darTama�o());
	}
	@Test
	public void testdarActual()
	{
		setUp2();
		assertTrue(cola!=null);
		Multa m1 = new Multa("AUTOM�VIL", "Particular", "C02", "ESTACIONAR UN VEH�CULO EN SITIOS PROHIBIDOS.", "BARRIOS UNIDOS", "2018/12/10", null, "12345");
		cola.enqueue(m1);
		assertEquals(m1, cola.darActual(3).darValor());
		
	}
	
}
