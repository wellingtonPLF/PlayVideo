package modelo;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import javax.persistence.Version;

import dao.TriggerListener;

@Table(
		name="Visualizacao20181370022"
)

@Entity
@EntityListeners( TriggerListener.class )
public class Visualizacao {
	@Id		
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(columnDefinition = "DATE")	
	private LocalDate datahora = LocalDate.now();
	private int nota;
	
	@Version
	private String version;
	
	@Transient
	private int idade;
	
	@ManyToOne
	private Usuario usuario;
	
	@ManyToOne
	private Video video;
	
	//-----------------------------------------------------------------------
	public Visualizacao() {}
	
	public Visualizacao(int id, int nota, Usuario usuario, Video video) {
		this.id = id;
		this.nota = nota;
		this.usuario = usuario;
		this.video = video;
	}
	public Usuario getUsuario() {		//Method add
		return this.usuario;
	}
	public void setUsuario(Usuario usuario) { 		//Method add
		this.usuario = usuario;
	}
	
	public Video getVideo() { 	//Method add
		return this.video;
	}
	public void setVideo(Video video) { 	//Method add
		this.video= video;
	}
	
	public int getNota() {		//Method add
		return this.nota;
	}
	
	public int getAge() {		//Method add
		return this.idade;
	}
	
	public void setAge(int idade) { 	//Method add
		this.idade= idade;
	}
	
	public LocalDate getDataHora() {		//Method add
		return this.datahora;
	}

	@Override
	public String toString() {
		return "\n    -> Visualizacao [id=" + id + 
				", datahora=" + datahora.format(DateTimeFormatter.ofPattern("dd/MM/yyy hh:mm:ss")) + 
				", nota=" + nota +
				"\n usuario=" + usuario.getEmail() + ", video=" + video.getNome() + "]\n";
	}
}
