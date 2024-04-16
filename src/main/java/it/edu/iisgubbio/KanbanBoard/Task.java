package it.edu.iisgubbio.KanbanBoard;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Task {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    
    String titolo;
    String descrizione;
    String assegnatario;
    String stato;
    Integer priorita;
    
	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public String getAssegnatario() {
		return assegnatario;
	}
	public void setAssegnatario(String assegnatario) {
		this.assegnatario = assegnatario;
	}
	public String getStato() {
		return stato;
	}
	public void setStato(String stato) {
		this.stato = stato;
	}
	public Integer getPriorita() {
		return priorita;
	}
	public void setPriorita(Integer priorita) {
		this.priorita = priorita;
	}
    
}