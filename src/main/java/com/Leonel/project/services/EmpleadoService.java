/**
 * 
 */
package com.Leonel.project.services;

import java.util.ArrayList;
import java.util.List;

import com.Leonel.project.entity.Empleado;

/**
 * @author Leonel
 *Clases que permite realizar la logica de negocio para empleados
 */

public class EmpleadoService {
	
	/**
	 * @Metodo que permite consultar la lista de empleados de empresas TI
	 *
	 */
	
	
	public List<Empleado> consultarEmpleados (){
		
		//Generar la lista de empleados a consultar
		List<Empleado> empleados = new ArrayList <Empleado>();
		
		Empleado empleadoIBM = new Empleado();
		Empleado empleadoMicrosoft = new Empleado();
		Empleado empleadoApple = new Empleado();
		
		empleadoIBM.setNombre("Leonel");
		empleadoIBM.setPrimerApellido("Santos");
		empleadoIBM.setSegundoApellido("Gonzalez");
		empleadoIBM.setPuesto("Senior Developer Java");
		empleadoIBM.setEstatus(true);
		
		empleadoMicrosoft.setNombre("Rosa");
		empleadoMicrosoft.setPrimerApellido("Gonzalez");
		empleadoMicrosoft.setSegundoApellido("Vital");
		empleadoMicrosoft.setPuesto("CEO");
		empleadoMicrosoft.setEstatus(true);
		
		empleadoApple.setNombre("Sebastian");
		empleadoApple.setPrimerApellido("Alcantara");
		empleadoApple.setSegundoApellido("Santos");
		empleadoApple.setPuesto("Architec");
		empleadoApple.setEstatus(true);
		
		empleados.add(empleadoIBM);
		empleados.add(empleadoMicrosoft);
		empleados.add(empleadoApple);
		return empleados;
		
		
	}

}
