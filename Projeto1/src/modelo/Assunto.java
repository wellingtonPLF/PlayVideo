package modelo;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Table(
		name="Assunto20181370022"
)

@Entity
public class Assunto {
	@Id		
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String palavra;
	
	@Version
	private String version;
	
	@ManyToMany(cascade={CascadeType.PERSIST,CascadeType.MERGE})
	private List<Video> videos = new ArrayList<>();
	//-----------------------------------------------------------------------
	public Assunto() {}
	
	public Assunto(String palavra) {
		this.palavra = palavra;
	}
	
	public String getPalavra() {
		return palavra;
	}

	public void adicionar(Video v) {
		videos.add(v);
	}
	
	@Override
	public String toString() {
		String texto = "Assunto: [palavra= " + palavra + " -> Vídeo= ";
		for(Video v : videos) {
			texto += v.getNome();
		}
		texto+= "]";
		return texto;
	}
}
