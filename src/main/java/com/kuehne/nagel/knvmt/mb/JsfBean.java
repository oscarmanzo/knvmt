package com.kuehne.nagel.knvmt.mb;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class JsfBean {

    private String welcomeMessage = "Populated by JSF created bean";

    public String getWelcomeMessage() {
        return welcomeMessage;
    }

}