package fiap.scj.persistencia.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="PROCEDIMENTO")
public class Procedimento {
	
	public Procedimento() {}
	public Procedimento(String descricao, double preco, Paciente paciente) {
		super();
		this.descricao = descricao;
		this.preco = preco;
		this.paciente = paciente;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)  
	@Column(name = "IDPROCEDIMENTO")
	private int id;
	
	@Column(name = "DESCRICAO", length = 45)
	private String descricao;
	
	@Column(name = "PRECO")
	private double preco;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="CPF")
	private Paciente paciente;
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	@Override
	public String toString() {
		return "Procedimento [id=" + id + ", descricao=" + descricao + ", preco=" + preco + ", paciente=" + paciente
				+ "]";
	}
	
	
}
