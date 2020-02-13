package test.data_structures;

import model.data_structures.IStack;
import model.data_structures.Multa;
import model.data_structures.Stack;
import model.logic.Modelo;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestStack<T extends Comparable<T>> {

    private IStack<Multa> stack;
    private Modelo modelo;

    public TestStack() {
        stack = new Stack<>();
    }

    public void setUp1() {
        stack = new Stack<>();
    }
    
    public void setUp2() {
        setUp1();
        Multa m2 = new Multa("CAMIONETA", "Particular", "C35", "NO REALIZAR LA REVISI�N TECNICOMEC�NICA EN EL PLAZO LEGAL ESTABLECIDO O CUANDO EL VEH�CULO  NO SE ENCUENTRE EN ADECUADAS CONDICIONES TECNICOMEC�NICAS O DE EMISIONES CONTAMINANTES, A�N CUANDO PORTE LOS CERTIFICADOS CORRESPONDIENTES, ADEM�S EL VEH�C", "TUNJUELITO", "2018/01/17", null, "509329");
        stack.push(m2);
        stack.push(m2);
        stack.push(m2);
    }
    @Test
    public void testIsEmpty() {
        setUp1();
        assertTrue(stack.isEmpty());
        assertEquals(0, stack.getSize());
    }
    @Test
    public void testPush(){
        setUp1();
        assertTrue(stack.isEmpty());
        Multa m1 = new Multa("AUTOM�VIL", "Particular", "C02", "ESTACIONAR UN VEH�CULO EN SITIOS PROHIBIDOS.", "BARRIOS UNIDOS", "2018/12/10", null, "12345");
        Multa m2 = new Multa("CAMIONETA", "Particular", "C35", "NO REALIZAR LA REVISI�N TECNICOMEC�NICA EN EL PLAZO LEGAL ESTABLECIDO O CUANDO EL VEH�CULO  NO SE ENCUENTRE EN ADECUADAS CONDICIONES TECNICOMEC�NICAS O DE EMISIONES CONTAMINANTES, A�N CUANDO PORTE LOS CERTIFICADOS CORRESPONDIENTES, ADEM�S EL VEH�C", "TUNJUELITO", "2018/01/17", null, "509329");

        stack.push(m1);
        stack.push(m1);
        stack.push(m2);
        assertFalse(stack.isEmpty());
        assertEquals(3, stack.getSize());

    }
    @Test
    public void TestPop()
    {
        setUp1();
        assertTrue(stack!=null);
        Multa m1 = new Multa("AUTOM�VIL", "Particular", "C02", "ESTACIONAR UN VEH�CULO EN SITIOS PROHIBIDOS.", "BARRIOS UNIDOS", "2018/12/10", null, "12345");
        Multa m2 = new Multa("CAMIONETA", "Particular", "C35", "NO REALIZAR LA REVISI�N TECNICOMEC�NICA EN EL PLAZO LEGAL ESTABLECIDO O CUANDO EL VEH�CULO  NO SE ENCUENTRE EN ADECUADAS CONDICIONES TECNICOMEC�NICAS O DE EMISIONES CONTAMINANTES, A�N CUANDO PORTE LOS CERTIFICADOS CORRESPONDIENTES, ADEM�S EL VEH�C", "TUNJUELITO", "2018/01/17", null, "509329");
        stack.push(m2);
        stack.push(m2);
        stack.push(m1);
        assertEquals(3, stack.getSize());
        assertEquals(m2, stack.darActual(1).darValor());
        stack.pop(m1);
        stack.pop(m2);
        stack.pop(m2);
        assertEquals(0, stack.getSize());
    }


}