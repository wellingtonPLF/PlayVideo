package modelo;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Table(
		name="Usuario20181370022"
)

@Entity
public class Usuario {
	@Id		
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String email;
	
	@Version
	private String version;
	
	@OneToMany(mappedBy="usuario", 
			cascade=CascadeType.ALL, 	
			orphanRemoval=true,			
			fetch=FetchType.EAGER) 		
	private List<Visualizacao> visualizacoes = new ArrayList<>();	
	//-----------------------------------------------------------------------
	public Usuario() {}
	
	public Usuario(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {  //Method add
		this.email = email;
	}
	
	public void adicionar(Visualizacao visu) {
		visualizacoes.add(visu);
	}
	
	public void remover(Visualizacao visu){  //Method add
		this.visualizacoes.remove(visu);
	}

	@Override
	public String toString() {
		String texto =  "Usuario [email=" + email + "]";
		
		texto+="\n visualizacoes=";
		for(Visualizacao vis : visualizacoes) {
			texto += vis;
		}
		return texto;
	}
}
