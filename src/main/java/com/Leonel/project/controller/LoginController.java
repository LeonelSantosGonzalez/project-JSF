/**
 * 
 */
package com.Leonel.project.controller;

import java.io.IOException;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.security.auth.login.AccountException;

/**
 * @author Leonel Santos Clase que nos permite controlar el funcionamiento de la
 *         pantalla con el login.xhtml.
 */

@ManagedBean

public class LoginController {

	/**
	 * @Usuario que ingresa en el login.
	 */
	private String usuario;

	private String password;

	/**
	 * @Contraseña que se ingresa en el login.
	 */

	public void ingresar() {
		System.out.println("Usuario" + usuario);

		// FacesContext es una clase del API de JSF
		if (usuario.equals("Alien") && password.equals("12345")) {
			/*
			 * FacesContext.getCurrentInstance().addMessage("formLogin: txtUsuario", new
			 * FacesMessage(FacesMessage.SEVERITY_INFO, "Usuario Correcto", ""));
			 */
			try {
				this.redireccionar("principal.xhtml");
			} catch (IOException e) {
				FacesContext.getCurrentInstance().addMessage("formLogin: txtUsuario",
						new FacesMessage(FacesMessage.SEVERITY_FATAL, "La ágina no existe", "Intentelo de nuevo"));
				e.printStackTrace();
			}

		} else {
			FacesContext.getCurrentInstance().addMessage("formLogin: txtUsuario", new FacesMessage(
					FacesMessage.SEVERITY_ERROR, "Usuario y/0 contraseña incorrectos ", "Intentelo de nuevo"));
		}
	}

	private void redireccionar(String pagina) throws IOException {
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		ec.redirect(pagina);
	}

	public String getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
}
