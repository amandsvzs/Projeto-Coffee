package controller;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
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
	
	
	@FXML
	public void initialize() {
		Delivery= new pedidos();
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
