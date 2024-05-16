package repository;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.FileOutputStream;

import model.CardapioOn;

public class pedidos {
	private List<CardapioOn> files;
	private File database;
	
	//sobreescrever arquivo no java
		private void saveFiles() {
			try (PrintWriter writer = new PrintWriter(new FileOutputStream(database, false))) {
				for (CardapioOn cardapioon:files) {
						String data = cardapioon.getId()+";" + cardapioon.getNomeCliente() +";"+
				cardapioon.getEmail() +";" +cardapioon.getTelefone() + ";" + cardapioon.getNomeDelivery();
						writer.println(data);
				}
			}catch (FileNotFoundException e) {
				System.out.println("Arquivo database nao encontrado! Deu ruim amante");
			}
		}
		 
	
	public pedidos () {
		this.database = new File("database-files.txt");
		this.files = new ArrayList<>();
	}
	
	private void loadFiles() {
	try (Scanner sc = new Scanner (database)){
		while (sc.hasNextLine()) {
			String[] data = sc.nextLine().split(";");
			if (data.length >= 4) {
				CardapioOn cardapioon = new CardapioOn();
				cardapioon.setId(Integer.parseInt(data[0]));
				cardapioon.setNomeCliente(data[1]);
				cardapioon.setEmail(data[2]);
				cardapioon.setTelefone(data[3]);
				cardapioon.setNomeDelivery(data[4]);
				files.add(cardapioon);
			}
		}
	}catch (FileNotFoundException e) {
		System.out.println("Arquivo database nao encontrado! Deu ruim amante");
	}
}
	//CRUD
	
	//buscar todos	
	public List <CardapioOn> buscarTodos(){
		return new ArrayList<>(files);
	}
	
	//deletar objeto especifico
	public void deleteCardapioOn(int id) {
		files.removeIf(CardapioOn -> CardapioOn.getId()== id);
		saveFiles();
	}
	
	//Criar CardapioOn
	
	public void addCardapioOn (CardapioOn cardapioon) {
		cardapioon.setId(getNextId());
		files.add(cardapioon);
		saveFiles();
		//sobreescrever o arquivo database
		
	}
	
	
	//logica para pegar o proximo id
	public int getNextId() {
		int maxId = 0;
		for(CardapioOn cardapioon:files) {
			//verifica se  o numero é maior que o nosso numero maximo
			if (cardapioon.getId() >maxId){
				maxId = cardapioon.getId();
			}
		}
		return maxId +1;
	}

}
