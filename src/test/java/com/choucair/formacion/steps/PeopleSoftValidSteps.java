package com.choucair.formacion.steps;

import java.util.List;

import com.choucair.formacion.pageobjects.PeopleSoftValidPage;

import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;

public class PeopleSoftValidSteps {
	PeopleSoftValidPage peopleSoftValidPage;
	
	@Step
	public void diliguenciar_datos(List<List<String>> data, int id) {
		//ingreso del cliente
		peopleSoftValidPage.Tipo_Documento(data.get(id).get(1).trim());
		peopleSoftValidPage.esperar(3);
		peopleSoftValidPage.ID_Set(data.get(id).get(0).trim());
		peopleSoftValidPage.Documento_Identidad(data.get(id).get(2).trim());
		peopleSoftValidPage.anadir.click();
		//ingreso de nombres
		peopleSoftValidPage.Primer_Nombre(data.get(id).get(3).trim());
		peopleSoftValidPage.Segundo_Nombre(data.get(id).get(4).trim());
		peopleSoftValidPage.Apellido(data.get(id).get(5).trim());
		peopleSoftValidPage.Apellido_dos(data.get(id).get(6).trim());
		peopleSoftValidPage.esperar(2);
		//Ingreso de regimen y responsabilidades
		peopleSoftValidPage.activityt.click();
		peopleSoftValidPage.esperar(2);
		peopleSoftValidPage.Tipo_Contribuyente(data.get(id).get(7).trim());
		peopleSoftValidPage.esperar(1);
		peopleSoftValidPage.Regimen(data.get(id).get(8).trim());
		peopleSoftValidPage.esperar(1);
		peopleSoftValidPage.Responsabilidad(data.get(id).get(9).trim());
		peopleSoftValidPage.esperar(1);
		peopleSoftValidPage.infogral.click();
		//Informacion General del cliente
		peopleSoftValidPage.esperar(1);
		peopleSoftValidPage.unidadNegocio(data.get(id).get(10).trim());
		peopleSoftValidPage.legal( data.get(id).get(3).trim(), data.get(id).get(5).trim());
		peopleSoftValidPage.esperar(1);
		peopleSoftValidPage.Tipo_DocI(data.get(id).get(1).trim());
		peopleSoftValidPage.Num_DocI(data.get(id).get(2).trim());
		peopleSoftValidPage.equipo_asistencia(data.get(id).get(17).trim());
		peopleSoftValidPage.chechboxinfo();
		peopleSoftValidPage.Addresss(data.get(id).get(11).trim());
		peopleSoftValidPage.estado(data.get(id).get(12).trim());
		peopleSoftValidPage.esperar(2);
		peopleSoftValidPage.ciudad(data.get(id).get(13).trim());
		peopleSoftValidPage.esperar(2);
		peopleSoftValidPage.barrio(data.get(id).get(14).trim());
		peopleSoftValidPage.esperar(2);
		//Opciones de facturacion
		peopleSoftValidPage.opcfact.click();
		peopleSoftValidPage.esperar(2);
		peopleSoftValidPage.condicion_pago(data.get(id).get(15).trim());
		peopleSoftValidPage.esperar(1);
		peopleSoftValidPage.metodos_pago(data.get(id).get(1).trim());
		peopleSoftValidPage.esperar(1);
		peopleSoftValidPage.factura_Elec(data.get(id).get(16).trim());
		peopleSoftValidPage.nombre_contacto(data.get(id).get(3).trim(),data.get(id).get(5).trim());
		peopleSoftValidPage.esperar(2);
		//Rutas 
		peopleSoftValidPage.infogralvarios.click();
		peopleSoftValidPage.esperar(2);
		peopleSoftValidPage.preventa.click();
		peopleSoftValidPage.rutas_preventa(data.get(id).get(18).trim());
		peopleSoftValidPage.esperar(2);
		//Requisitos Credito
		peopleSoftValidPage.ckcredi.click();
		peopleSoftValidPage.esperar(2);
		peopleSoftValidPage.ck_Reg_Credito(data.get(id).get(16).trim());
		peopleSoftValidPage.esperar(2);
		// Codigo Región
		peopleSoftValidPage.custCode.click();
		peopleSoftValidPage.esperar(2);
		peopleSoftValidPage.codigo(data.get(id).get(19).trim());
		peopleSoftValidPage.cdRegion(data.get(id).get(12).trim());
		peopleSoftValidPage.esperar(2);
		//Opciones de datafono
		peopleSoftValidPage.opcdataf.click();
		peopleSoftValidPage.esperar(2);
		//Perfil de Credito
		peopleSoftValidPage.perfcred.click();
		peopleSoftValidPage.esperar(2);
		peopleSoftValidPage.compcred.click();
		peopleSoftValidPage.esperar(2);
		//Corregir
		peopleSoftValidPage.corrections.click();
		peopleSoftValidPage.esperar(3);
		peopleSoftValidPage.cambiarDeFrame();
		peopleSoftValidPage.accepts.click();
		//peopleSoftValidPage.aceptarAlertaPorMensaje("¿Desea guardar los cambios? Haga clic en Sí para volver y guardarlos o en No para desechar cambios.");
		peopleSoftValidPage.esperar(3);
		//Guardar
		peopleSoftValidPage.cambiarDeFrame("(//iframe)[1]");
		peopleSoftValidPage.savec.click();
		peopleSoftValidPage.esperar(2);
		peopleSoftValidPage.cambiarDeFrame();
		peopleSoftValidPage.accepts1.click();
		peopleSoftValidPage.esperar(5);
		
		//Iniciar segunda creacion
		PeopleSoftSteps menu = new PeopleSoftSteps();
		menu.ingresar_menu_people();
		
	}
	@Step
	public void verificar_ingreso_datos_exitoso() {
		peopleSoftValidPage.validacion_sin_errores();
	}
	@Step
	public void verificar_ingreso_datos_erroneo() {
		peopleSoftValidPage.validacion_sin_errores();
	}
	@Step
	public void diliguenciar_datos2(String strID_Set, String strTipo_Identificacion, String strDocumento_Identidad, String strPrimer_Nombre, String strSegundo_Nombre, String strApellido, String strApellido_dos,String strTipo_Contribuyente,String strRegimen,String strResponsabilidad,String strUnidad_de_Negocio,String strDirección,String strEstado,String strCiudad,String strBarrio,String strCondicion_pago,String strFaceletronica,String strSubcliente,String strRutas,String strCodigo){
		//ingreso del cliente
				peopleSoftValidPage.Tipo_Documento(strTipo_Identificacion);
				peopleSoftValidPage.esperar(3);
				peopleSoftValidPage.ID_Set(strID_Set);
				peopleSoftValidPage.Documento_Identidad(strDocumento_Identidad);
				Serenity.takeScreenshot();
				peopleSoftValidPage.anadir.click();
				//ingreso de nombres
				peopleSoftValidPage.Primer_Nombre(strPrimer_Nombre);
				peopleSoftValidPage.Segundo_Nombre(strSegundo_Nombre);
				peopleSoftValidPage.Apellido(strApellido);
				peopleSoftValidPage.Apellido_dos(strApellido_dos);
				Serenity.takeScreenshot();
				peopleSoftValidPage.esperar(2);
				//Ingreso de regimen y responsabilidades
				peopleSoftValidPage.activityt.click();
				peopleSoftValidPage.esperar(2);
				peopleSoftValidPage.Tipo_Contribuyente(strTipo_Contribuyente);
				peopleSoftValidPage.esperar(1);
				peopleSoftValidPage.Regimen(strRegimen);
				Serenity.takeScreenshot();
				peopleSoftValidPage.esperar(1);
				peopleSoftValidPage.Responsabilidad(strResponsabilidad);
				Serenity.takeScreenshot();
				peopleSoftValidPage.esperar(1);
				peopleSoftValidPage.infogral.click();
				//Informacion General del cliente
				peopleSoftValidPage.esperar(1);
				peopleSoftValidPage.unidadNegocio(strUnidad_de_Negocio);
				peopleSoftValidPage.legal( strPrimer_Nombre, strSegundo_Nombre);
				peopleSoftValidPage.esperar(1);
				peopleSoftValidPage.Tipo_DocI(strTipo_Identificacion);
				peopleSoftValidPage.Num_DocI(strDocumento_Identidad);
				Serenity.takeScreenshot();
				peopleSoftValidPage.equipo_asistencia(strSubcliente);
				peopleSoftValidPage.chechboxinfo();
				peopleSoftValidPage.Addresss(strDirección);
				peopleSoftValidPage.estado(strEstado);
				peopleSoftValidPage.esperar(2);
				peopleSoftValidPage.ciudad(strCiudad);
				peopleSoftValidPage.esperar(2);
				peopleSoftValidPage.barrio(strBarrio);
				Serenity.takeScreenshot();
				peopleSoftValidPage.esperar(2);
				//Opciones de facturacion
				peopleSoftValidPage.opcfact.click();
				peopleSoftValidPage.esperar(2);
				peopleSoftValidPage.condicion_pago(strCondicion_pago);
				peopleSoftValidPage.esperar(1);
				peopleSoftValidPage.metodos_pago(strTipo_Identificacion);
				Serenity.takeScreenshot();
				peopleSoftValidPage.esperar(1);
				peopleSoftValidPage.factura_Elec(strFaceletronica);
				peopleSoftValidPage.nombre_contacto(strPrimer_Nombre, strSegundo_Nombre);
				Serenity.takeScreenshot();
				peopleSoftValidPage.esperar(2);
				//Rutas 
				peopleSoftValidPage.infogralvarios.click();
				peopleSoftValidPage.esperar(2);
				peopleSoftValidPage.preventa.click();
				peopleSoftValidPage.rutas_preventa(strRutas);
				Serenity.takeScreenshot();
				peopleSoftValidPage.esperar(2);
				//Requisitos Credito
				peopleSoftValidPage.ckcredi.click();
				peopleSoftValidPage.esperar(2);
				peopleSoftValidPage.ck_Reg_Credito(strFaceletronica);
				Serenity.takeScreenshot();
				peopleSoftValidPage.esperar(2);
				// Codigo Región
				peopleSoftValidPage.custCode.click();
				peopleSoftValidPage.esperar(2);
				peopleSoftValidPage.codigo(strCodigo);
				peopleSoftValidPage.cdRegion(strEstado);
				Serenity.takeScreenshot();
				peopleSoftValidPage.esperar(2);
				//Opciones de datafono
				peopleSoftValidPage.opcdataf.click();
				peopleSoftValidPage.esperar(2);
				//Perfil de Credito
				peopleSoftValidPage.perfcred.click();
				peopleSoftValidPage.esperar(2);
				peopleSoftValidPage.compcred.click();
				Serenity.takeScreenshot();
				peopleSoftValidPage.esperar(2);
				//Corregir
				peopleSoftValidPage.corrections.click();
				peopleSoftValidPage.esperar(3);
				peopleSoftValidPage.cambiarDeFrame();
				peopleSoftValidPage.accepts.click();
				//peopleSoftValidPage.aceptarAlertaPorMensaje("¿Desea guardar los cambios? Haga clic en Sí para volver y guardarlos o en No para desechar cambios.");
				peopleSoftValidPage.esperar(3);
				//Guardar
				peopleSoftValidPage.cambiarDeFrame("(//iframe)[1]");
				peopleSoftValidPage.savec.click();
				peopleSoftValidPage.esperar(2);
				peopleSoftValidPage.cambiarDeFrame();
				peopleSoftValidPage.accepts1.click();
				Serenity.takeScreenshot();
				peopleSoftValidPage.esperar(5);
	}
	
}
