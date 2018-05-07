package PracticaJUnit;

import static org.junit.Assert.*;

import org.junit.Test;

public class PruebaEmpleadoBR {
	
	private EmpleadoBR c1;
	private int tipo;
	private float ventasMes, horasExtras;

	@Test
	public void salarioBase() {
		this.tipo = 0;
		this.ventasMes = 2000.0f;
		this.horasExtras = 8.0f;
		
		assertEquals(1360.0f, calcularSalarioBruto(tipo, ventasMes, horasExtras), 0);
	}

}
