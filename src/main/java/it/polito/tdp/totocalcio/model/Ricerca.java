package it.polito.tdp.totocalcio.model;

import java.util.ArrayList;
import java.util.List;

public class Ricerca {

	
	private Pronostico pronostico;
	private int N; 
	private List<Risultato> soluzione; 
	
	
	
	// parte di 'interfaccia'
	public List<Risultato> cerca(Pronostico pronostico) {
		
		this.pronostico=pronostico; 
		this.N= pronostico.size(); 
		
		
		List<RisultatoPartita> parziale= new ArrayList<>(); 
		
		int livello=0; 
		this.soluzione= new ArrayList<Risultato>(); 
		
		ricorsiva(parziale, livello); 
		return this.soluzione; 
		// Come si pensa in modo ricorsivo?
		// Sottoproblemi!!!!
		// ["2X", "1", "1X2", "12"]
		// ["2X"] + ["1", "1X2", "12"] al primo livello vedo solo 2X, il resto e' di livelli sottostanti
		//["1"] +   ["1X2", "12"] ogni livello decide cosa sta in una determinata posizione del risultato
		
		// Il LIVELLO della ricorsione indica il Numero di Partite considerate
		// le partite da 0 a livello-1 sono gia' state decise
		// la partita di indice livello la devo decidere io 
		// le partite da livello+1 in poi le decideranno le procedure ricorsive sottostanti
		
		//SOLUZIONE PARZIALE : insieme di RisultatoPartita di lunghezza pari al livello
		
		//SOLUZIONE TOTALE : ho N risultati
		
		//CONDIZIONE DI TERMINAZIONE : il livello=N 
		
		// GENERAZIONE NUOVE SOLUZIONI DEL LIVELLO : si provano tutti i pronostici definiti per 
		//quel livello 
	
	}
	
	// vera ricorsione 
	private void ricorsiva (List<RisultatoPartita> parziale, int livello) {
		
		// caso terminale 
		if(livello==N) {
			//questa soluzione parziale e' una soluzione completa
			//System.out.println(parziale); 
			this.soluzione.add(new Risultato(parziale)); 
			// TODO : restituire al chiamante
			
		} else {
			//caso generale 
			/*[parziale da o a livello-1] gia' deciso
			[livello] io 
			[livello+1 in poi] ci pensa qualcun altro */
			PronosticoPartita pp= this.pronostico.get(livello); 
			//pp sono i sottoproblemi da provare (le alternative possibili)
			
			//li provo
			for (RisultatoPartita ris : pp.getRisultati()) {
				// provo a mettere 'ris' nella posizione 'livello'
				//dalla soluzione parziale 
				
				//costruzione soluzione parziale (sottoproblema)
				parziale.add(ris); //ho provato a mettere il primo risultato possibile nella prima posizione
				//chiamata ricorsiva
				ricorsiva(parziale, livello+1); 
				
				//backtracking (rimettere le cose a posto eprche' non e' detto che sia tutto ok)
				parziale.remove(parziale.size()-1); //rimuovo l'ultimo inserito
				
				//fine 
				
				
				
			}
		}
		
		
	}

}
