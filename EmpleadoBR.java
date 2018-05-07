package PracticaJUnit;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class EmpleadoBR {

	private float salarioBase;

	public float calcularSalarioBruto(int tipo, float ventasMes, float horasExtras) {
		// Indico el precio del empleado dependiendo del tipo:
		if (tipo == 0) {
			this.salarioBase = 1000;
		} else if (tipo == 1) {
			this.salarioBase = 1500;
		}
		// Aumento el salario base a partir de las ventas, si ha cumplido con el
		// objetivo:
		if (ventasMes >= 1000 && ventasMes<1500) {
			this.salarioBase = this.salarioBase + 100;
		} else if (ventasMes >= 1500) {
			this.salarioBase = this.salarioBase + 200;
		}

		// Calculo el precio de las horas extras:
		float precioHorasExtras = horasExtras * 20;

		return (float) this.salarioBase + precioHorasExtras;
	}

	public float calcularSalarioNeto(float salarioBruto) {
		if (salarioBruto < 1000) {
			return (float) salarioBruto;
		} else if (salarioBruto >= 1000 && salarioBruto < 1500) {
			return (float) (salarioBruto - salarioBruto * 0.16);
		} else if (salarioBruto >= 1500) {
			return (float) (salarioBruto - salarioBruto * 0.18);
		}
		return salarioBruto;
	}

	@Test
	public void salarioNeto() {
		assertEquals(1640.0f, calcularSalarioNeto(2000.0f),0);
		assertEquals(1230.0f, calcularSalarioNeto(1500.0f),0);
		assertEquals(1259.9916f, calcularSalarioNeto(1499.99f),0);
		assertEquals(1050.0f, calcularSalarioNeto(1250.0f),0);
		assertEquals(840.0f, calcularSalarioNeto(1000.0f),0);
		assertEquals(999.99f, calcularSalarioNeto(999.99f),0);
		assertEquals(500.0f, calcularSalarioNeto(500.0f),0);
		assertEquals(0.0f, calcularSalarioNeto(0.0f),0);
	}
	
	@Test
	public void salarioBruto() {
		assertEquals(1360.0f, calcularSalarioBruto(0, 2000.0f, 8), 0);
		assertEquals(1260.0f, calcularSalarioBruto(0, 1500.0f, 3), 0);
		assertEquals(1100.0f, calcularSalarioBruto(0, 1499.99f, 0), 0);
		assertEquals(1760.0f, calcularSalarioBruto(1, 1250.0f, 8), 0);
		assertEquals(1600.0f, calcularSalarioBruto(1, 1000.0f, 0), 0);
		assertEquals(1560.0f, calcularSalarioBruto(1, 999.99f, 3), 0);
		assertEquals(1500.0f, calcularSalarioBruto(1, 500.0f, 0), 0);
		assertEquals(1660.0f, calcularSalarioBruto(1, 0.0f, 8), 0);

	}
}
