/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;
import model.model;
import view.view;
import controllers.controllers;
/**
 *
 * @author Dani
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       model model = new model();
        view view = new view();
        controllers controllers = new controllers(model, view);
    }
    
}
