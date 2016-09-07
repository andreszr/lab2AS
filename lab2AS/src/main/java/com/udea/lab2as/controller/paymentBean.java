/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.lab2as.controller;

import com.udea.lab2as.Payment;
import com.udea.lab2as.PaymentFacadeLocal;
import java.io.Serializable;
import java.util.Date;
import javax.ejb.EJB;
import javax.faces.component.UIComponent;

/**
 *
 * @author aux12
 */
public class paymentBean implements Serializable{
    @EJB
    private PaymentFacadeLocal paymentFacade;
    private UIComponent mybutton;
    private int id;
    private long amount;
    private long card;
    private Date date = new Date();
    private int cvvno;
    private String contrasenia;
    private String txtContraseniaRepita;
    private boolean Disable = true;
    private String sSubCadena;
    private String mensajeCard;
    private String m;

    public String getsSubCadena() {
        return sSubCadena;
    }

    public void setsSubCadena(String sSubCadena) {
        this.sSubCadena = sSubCadena;
    }

    public String getMensajeCard() {
        return mensajeCard;
    }

    public void setMensajeCard(String mensajeCard) {
        this.mensajeCard = mensajeCard;
    }

    public String getM() {
        return m;
    }

    public void setM(String m) {
        this.m = m;
    }    

    public boolean isDisable() {
        return Disable;
    }

    public void setDisable(boolean Disable) {
        this.Disable = Disable;
    }
    
    
    public paymentBean() {
    }

    public UIComponent getMybutton() {
        return mybutton;
    }

    public void setMybutton(UIComponent mybutton) {
        this.mybutton = mybutton;
    }

    /**
     * @return the paymentFacade
     */
    public PaymentFacadeLocal getPaymentFacade() {
        return paymentFacade;
    }

    /**
     * @param paymentFacade the paymentFacade to set
     */
    public void setPaymentFacade(PaymentFacadeLocal paymentFacade) {
        this.paymentFacade = paymentFacade;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the amount
     */
    public long getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(long amount) {
        this.amount = amount;
    }

    /**
     * @return the card
     */
    public long getCard() {
        return card;
    }

    /**
     * @param card the card to set
     */
    public void setCard(long card) {
        this.card = card;
    }

    /**
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * @return the cvvno
     */
    public int getCvvno() {
        return cvvno;
    }

    /**
     * @param cvvno the cvvno to set
     */
    public void setCvvno(int cvvno) {
        this.cvvno = cvvno;
    }

    /**
     * @return the contrasenia
     */
    public String getContrasenia() {
        return contrasenia;
    }

    /**
     * @param contrasenia the contrasenia to set
     */
    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    /**
     * @return the txtContraseniaRepita
     */
    public String getTxtContraseniaRepita() {
        return txtContraseniaRepita;
    }

    /**
     * @param txtContraseniaRepita the txtContraseniaRepita to set
     */
    public void setTxtContraseniaRepita(String txtContraseniaRepita) {
        this.txtContraseniaRepita = txtContraseniaRepita;
    }

    //acción para insertar el registro en la DB desde el form
    public String guardar(){
        Payment p= new Payment();
        p.setId(id);
        p.setAmount(amount);
        p.setCard(card);
        p.setCvvno(cvvno);
        p.setDate(date);
        this.paymentFacade.create(p);
        m=this.getMensajeCard();
        return "paymentCreate";
    }
    
}
