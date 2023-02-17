/**
 * 
 */
package com.Leonel.project.controller;

import java.io.IOException;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.security.auth.login.AccountException;

import com.Leonel.project.dto.UsuarioDTO;

/**
 * @author Leonel Santos Clase que nos permite controlar el funcionamiento de la
 *         pantalla con el login.xhtml.
 */

@ManagedBean
public class LoginController {


	/**
	 * Usuario que ingresa en el login
	 */

	private String usuario;

	/**
	 * Contraeña ingresada en el login
	 */
	private String password;
	/**
	 * Bean que mantiene la informacion en sesion
	 */
	@ManagedProperty("#{sessionController}")
	private SessionController sessionController;
	

	public void ingresar() {
		System.out.println("Usuario: " + usuario);
		// FacesContesxt es una clase del API de JSF
		if (usuario.equals("Alien") && password.equals("12345")) {
			/*FacesContext.getCurrentInstance().addMessage("formLogin: txtUsuario",
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuario correcto", ""));*/
			try {
				UsuarioDTO  usuarioDTO = new UsuarioDTO();
				usuarioDTO.setUsuario(this.usuario);
				usuarioDTO.setPassword(this.password);
				
				
				this.sessionController.setUsuarioDTO(usuarioDTO);
				this.redireccionar("principal.xhtml");
			} catch (IOException e) {
				FacesContext.getCurrentInstance().addMessage("formLogin: txtUsuario",
						new FacesMessage(FacesMessage.SEVERITY_FATAL, "La pagina no existe", ""));
				e.printStackTrace();
			}
			

		} else {
			FacesContext.getCurrentInstance().addMessage("formLogin: txtUsuario",
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuario y/o contraseña incorrectos", ""));

		}
	}

	private void redireccionar(String pagina) throws IOException  {
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		ec.redirect(pagina);
	}
	/**
	 * @return the usuario
	 */
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

	/**
	 * @return the sessionController
	 */
	public SessionController getSessionController() {
		return sessionController;
	}

	/**
	 * @param sessionController the sessionController to set
	 */
	public void setSessionController(SessionController sessionController) {
		this.sessionController = sessionController;
	}

}
