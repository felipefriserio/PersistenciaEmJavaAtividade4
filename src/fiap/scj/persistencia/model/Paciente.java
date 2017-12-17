package fiap.scj.persistencia.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "PACIENTE")
public class Paciente {
	
	public Paciente() {}
	public Paciente(String cpf, String nome, Calendar dataNasc, String telefone, Agenda agenda) {
		super();
		this.cpf = cpf;
		this.nome = nome;
		this.dataNasc = dataNasc;
		this.telefone = telefone;
		this.agendas.add(agenda);
	}
	public Paciente(String cpf, String nome, Calendar dataNasc, String telefone) {
		super();
		this.cpf = cpf;
		this.nome = nome;
		this.dataNasc = dataNasc;
		this.telefone = telefone;
	}
	
	@Id
	@Column(name="CPF", length = 11)
	private String cpf;
	
	@Column(name="NOME", length = 45)
	private String nome;
	
	@Temporal(value=TemporalType.TIMESTAMP)
	@Column(name="DATANASC")
	private Calendar dataNasc;
	
	@Column(name="TELEFONE", length = 20)
	private String telefone;
	
	@ManyToMany
	@JoinTable(
			name 				= "PACIENTE_AGENDA", 		   // nome da tabela de relacionamento que sera gerada pelo Hibernate 
			joinColumns 		= @JoinColumn(name="CPF"),     // id desta classe
			inverseJoinColumns  = @JoinColumn(name="IDAGENDA") // id da classe na qual sera feito o relacionamento
	)
	private List<Agenda> agendas = new ArrayList<Agenda>();
	
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Calendar getDataNasc() {
		return dataNasc;
	}
	public void setDataNasc(Calendar dataNasc) {
		this.dataNasc = dataNasc;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public List<Agenda> getAgendas() {
		return agendas;
	}
	public void setAgendas(List<Agenda> agendas) {
		this.agendas = agendas;
	}
	@Override
	public String toString() {
		return "Paciente [cpf=" + cpf + ", nome=" + nome + ", dataNasc=" + dataNasc + ", telefone=" + telefone+"]";
	}
	
	
}
