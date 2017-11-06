package com.kuehne.nagel.knvmt.mbean;

import java.io.IOException;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpSession;

import org.primefaces.context.RequestContext;

import com.kuehne.nagel.knvmt.config.Constants;
import com.kuehne.nagel.knvmt.security.UserLogged;

@ManagedBean
@RequestScoped
public class UserLoginMB {

	private final static String URL_USER_LOGGED_SUCCESSFULLY = "view/home.jsf?faces-redirect=true";
	
	private String username;
    
    private String password;
 
    public String getUsername() {
        return username;
    }
 
    public void setUsername(String username) {
        this.username = username;
    }
 
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }
   
    public void login(ActionEvent event) {
        RequestContext context = RequestContext.getCurrentInstance();
        FacesMessage message = null;
        boolean loggedIn = false;
         
        if(username != null && username.equals("admin") && password != null && password.equals("admin")) {
            loggedIn = true;
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Welcome", username);
            signInUser();
            redirect(URL_USER_LOGGED_SUCCESSFULLY);
        } else {
            loggedIn = false;
            message = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Loggin Error", "Invalid credentials");
        }
         
        FacesContext.getCurrentInstance().addMessage(null, message);
        context.addCallbackParam("loggedIn", loggedIn);
    }
	
    private void signInUser() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
        
        UserLogged userLogged = new UserLogged();
        session.setAttribute(Constants.USER_SESSION, userLogged);
    }

    protected void redirect(String url) {
        try {
			FacesContext.getCurrentInstance().getExternalContext().redirect(url);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
}
