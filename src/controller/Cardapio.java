package controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.CardapioOn;
import repository.pedidos;

public class Cardapio {
	@FXML
	private TableView<pedidos> tableView;
	@FXML
	private TableColumn<pedidos,String>cCliente; 
	@FXML
	private TableColumn<pedidos,String>cEmail;
	@FXML
	private TableColumn<pedidos,String>cTelefone;
	@FXML
	private TableColumn<pedidos,String>cDelivery; 
	
	

	@FXML
	private TextField nomeCliente;
	
	@FXML
	private TextField email;
	
	@FXML
	private TextField telefone;
	
	@FXML
	private TextField nomeDelivery;
	private pedidos Delivery;
	
	
	private ObservableList<pedidos> data;
	
	
	@FXML
	public void initialize() {
		cCliente.setCellValueFactory(new PropertyValueFactory<>("nomeCliente"));
		cEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
		cTelefone.setCellValueFactory(new PropertyValueFactory<>("telefone"));
		cDelivery.setCellValueFactory(new PropertyValueFactory<>("nomeDelivery"));
		
		data = FXCollections.observableArrayList();
		tableView.setItems(data);
		Delivery= new pedidos();
		
		
	}
	public void carregarDadosSalvos() {
		try(BufferedReader br = new BufferedReader(new FileReader("database-files.txt"))){
			String line;
			while((line = br.readLine()) != null) {
				String []parts  = line.split(";");
				if (parts.length >=4) {
					CardapioOn cardapioon = new CardapioOn();
					cardapioon.setId(Integer.parseInt(parts[0]));
					cardapioon.setNomeCliente(parts[1]);
					cardapioon.setEmail(parts[2]);
					cardapioon.setTelefone(parts[3]);
					cardapioon.setNomeDelivery(parts[4]);
					data.add(Delivery);
					
				}
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	 public void cadastrar() {
		 CardapioOn cardapio = new CardapioOn();
		 cardapio.setNomeCliente(nomeCliente.getText());
		 cardapio.setEmail(email.getText());
		 cardapio.setTelefone(telefone.getText());
		 cardapio.setNomeDelivery(nomeDelivery.getText());
		 Delivery.addCardapioOn(cardapio);
		 clearFields();
		 
	 }
	 
	 public void clearFields() {
		 nomeCliente.clear();
		 email.clear();
		 telefone.clear();
		 nomeDelivery.clear();
	 }
	 
	 
	 
	 public void limpar() {
		 clearFields();
		  
		 
	 }
}
