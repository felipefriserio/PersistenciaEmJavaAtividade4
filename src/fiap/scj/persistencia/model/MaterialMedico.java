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
@Table(name="MATERIALMEDICO")
public class MaterialMedico {
	
	public MaterialMedico() {}
	public MaterialMedico(String descricao, double preco, String fabricante, Paciente paciente) {
		super();
		this.descricao = descricao;
		this.preco = preco;
		this.fabricante = fabricante;
		this.paciente = paciente;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="IDMATERIALMEDICO")
	private int id;
	
	@Column(name="DESCRICAO", length = 45)
	private String descricao;
	
	@Column(name="PRECO")
	private double preco;
	
	@Column(name="FABRICANTE", length = 45)
	private String fabricante;
	
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

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	@Override
	public String toString() {
		return "MaterialMedico [id=" + id + ", descricao=" + descricao + ", preco=" + preco + ", fabricante="
				+ fabricante + ", paciente=" + paciente + "]";
	}
	
}
