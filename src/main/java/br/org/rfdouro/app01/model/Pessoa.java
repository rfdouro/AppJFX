/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.org.rfdouro.app01.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author romulo
 */
public class Pessoa {

 private final StringProperty nome;
 private final StringProperty sobreNome;

 public Pessoa(String nome, String sobreNome) {
  this.nome = new SimpleStringProperty(nome);
  this.sobreNome = new SimpleStringProperty(sobreNome);
 }

 public Pessoa() {
  this(null, null);
 }

 public StringProperty getNome() {
  return nome;
 }

 public StringProperty getSobreNome() {
  return sobreNome;
 }
 
 public void setNome(String nome){
  this.nome.set(nome);
 }
 
 public void setSobreNome(String sobreNome){
  this.sobreNome.set(sobreNome);
 }

}
