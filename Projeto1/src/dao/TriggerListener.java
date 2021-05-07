package dao;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.Duration;

import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;

import modelo.Visualizacao;

public class TriggerListener{  // usada pela classe Visualizacao

	@PrePersist
	public void exibirmsg1(Object obj) throws Exception {
		System.out.println(" @PrePersist... " + obj.getClass().getSimpleName());
	}

	@PostPersist
	public void exibirmsg2(Object obj) {
		System.out.println(" @PostPersist... " + obj.getClass().getSimpleName());
		if (obj instanceof Visualizacao)  {
			Visualizacao vs = (Visualizacao)obj;
			System.out.println("   Ingresso da Nota (Idade) [" +vs.getNota() + "]= "+  vs.getAge() );
			int idade = calcularIdade( vs );
			vs.setAge(idade);
			System.out.println("   Tempo Calculado [" +vs.getNota() + "]=  "+  idade );
		}

	}

	
	@PostUpdate
	public void exibirmsg3(Object obj) {
		System.out.println(" @PostPersist... " + obj.getClass().getSimpleName());
		if (obj instanceof Visualizacao)  {
			Visualizacao vs = (Visualizacao)obj;
			System.out.println("   Ingresso da Nota (Idade) [" +vs.getNota() + "]= "+  vs.getAge() );
			int idade = calcularIdade( vs );
			vs.setAge(idade);
			System.out.println("   Tempo Calculado [" +vs.getNota() + "]=  "+  idade );
		}

	}
	
	@PostLoad
	public void exibirmsg4(Object obj) {
		System.out.println(" @PostPersist... " + obj.getClass().getSimpleName());
		if (obj instanceof Visualizacao)  {
			Visualizacao vs = (Visualizacao)obj;
			System.out.println("   Ingresso da Nota (Idade) [" +vs.getNota() + "]= "+  vs.getAge() );
			int idade = calcularIdade( vs );
			vs.setAge(idade);
			System.out.println("   Tempo Calculado [" +vs.getNota() + "]=  "+  idade );
		}

	}

	@PostRemove
	public void exibirmsg5(Object obj) {
		System.out.println(" @PostRemove.... " + obj.getClass().getSimpleName());
	}

	//============================================================
	public int calcularIdade(Visualizacao v) {
		LocalDate hoje = LocalDate.now();
		Period per = Period.between(v.getDataHora(), hoje);
		int idade = per.getYears();
		return idade;
	}

}
