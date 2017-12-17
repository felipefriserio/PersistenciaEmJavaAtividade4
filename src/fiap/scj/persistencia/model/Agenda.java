package fiap.scj.persistencia.model;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="Agenda")
public class Agenda {
	
	public Agenda() {}
	public Agenda(Calendar data, Date  hora, String descricao) {
		super();
		this.data = data;
		this.hora = hora;
		this.descricao = descricao;
	}
	public Agenda(Calendar data, Date  hora, String descricao, Paciente paciente) {
		super();
		this.data = data;
		this.hora = hora;
		this.descricao = descricao;
		this.pacientes.add(paciente);
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="IDAGENDA")
	private int id;
	
	@Temporal(value=TemporalType.DATE)
	@Column(name="DATA")
	private Calendar data;

	@Temporal(value=TemporalType.TIME)
	@Column(name="HORA")
	private Date  hora;
	
	@Column(name="DESCRICAO")
	private String descricao;
	
	/* - classe dona do relacionamento eh colocado o mapped by
	 * - na tabela Paciente precisa conter um atributo `agendas`*/
	@ManyToMany(mappedBy = "agendas", cascade = CascadeType.ALL, fetch=FetchType.EAGER) 
	private List<Paciente> pacientes;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public Date getHora() {
		return hora;
	}

	public void setHora(Date hora) {
		this.hora = hora;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	@Override
	public String toString() {
		return "Agenda [id=" + id + ", data=" + data + ", hora=" + hora + ", descricao=" + descricao + "]";
	}
}
