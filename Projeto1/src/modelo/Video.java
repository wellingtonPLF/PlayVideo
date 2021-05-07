package modelo;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Table(
		name="Video20181370022"
)

@Entity
public class Video {
	@Id		
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String link;
	private String nome;
	
	@Version
	private Long version;
	
	@Column(columnDefinition = "TIMESTAMP")	
	private LocalDateTime datahora = LocalDateTime.now();
	private double media;
	
	@ManyToMany(mappedBy="videos", 
			cascade={CascadeType.PERSIST,CascadeType.MERGE}) 	
	private List<Assunto> assuntos = new ArrayList<>();
	
	@OneToMany(mappedBy="video", 
			cascade=CascadeType.ALL, 	
			orphanRemoval=true,			
			fetch=FetchType.EAGER) 		
	private List<Visualizacao> visualizacoes = new ArrayList<>();

	//-----------------------------------------------------------------------
	public Video() {}
	
	public Video(String link, String nome) {
		this.link = link;
		this.nome = nome;
	}
	public String getNome() {
		return this.nome;
	}
	
	public String getLink() {
		return this.link;
	}
	
	public void setMedia(double media) {	//Method add
		this.media = media;
	}
	
	public void setNome(String nome) {  //Method add
		this.nome = nome;
	}

	public void adicionar(Assunto a) {
		assuntos.add(a);
	}
	public void adicionar(Visualizacao visu) {
		visualizacoes.add(visu);
	}
	
	public void remover(Visualizacao visu){  //Method add
		this.visualizacoes.remove(visu);
	}
	
	public List<Assunto> getAssuntos(){  //Method add
		return this.assuntos;
	}
	
	public List<Visualizacao> getVisu(){  //Method add
		return this.visualizacoes;
	}

	@Override
	public String toString() {
		String texto = "Video: \n[" + (link != null ? "link= " + link + "; " : "") + 
				(nome != null ? "\n nome= " + nome + "; " : "") +
				(datahora != null ? "\n datahora= " +  datahora.format(DateTimeFormatter.ofPattern("dd/MM/yyy hh:mm:ss")) + "; " : "")
				+ "\n media= " + media ;
		texto+=",\n assuntos= ";
		for(Assunto a : assuntos) {
			texto += "("+a.getPalavra() + ")";
		}
		texto+=";\n visualizacoes=";
		for(Visualizacao vis : visualizacoes) {
			texto += vis;
		}
		texto+=";]\n";
		return texto;
	}
}
