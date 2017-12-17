package fiap.scj.persistencia.main;

import java.util.Calendar;
import java.util.List;

import fiap.scj.persistencia.dao.GenericDao;
import fiap.scj.persistencia.model.Agenda;
import fiap.scj.persistencia.model.MaterialMedico;
import fiap.scj.persistencia.model.Paciente;
import fiap.scj.persistencia.model.Procedimento;

public class Main {

	public static void main(String[] args) {
											// AGENDA
		// Insere agenda
		Agenda agenda = new Agenda(Calendar.getInstance(), Calendar.getInstance().getTime(), "Agenda");
		new GenericDao<>(Agenda.class).adicionar(agenda);

		// Busca agenda
		Agenda agendaBuscada = new GenericDao<>(Agenda.class).buscar(agenda.getId());
		System.out.println(agendaBuscada);
		
		
											// PACIENTE
		// Insere paciente
		String cpf  = Math.random()+"";
		Paciente p1 = new Paciente(cpf.substring(2, 10), "Ze lele", Calendar.getInstance(), "1234-1234", agenda);
		new GenericDao<>(Paciente.class).adicionar(p1);
		
		// Buscar paciente 
		Paciente pacienteBuscado = new GenericDao<>(Paciente.class).buscar("select p from Paciente p where p.cpf = ?", p1.getCpf());
		System.out.println(pacienteBuscado.toString());
		
		
											// PROCEDIMENTO
		//insere procedimento
		Procedimento procedimento = new Procedimento("Procedimento", 10d, pacienteBuscado);
		new GenericDao<>(Procedimento.class).adicionar(procedimento);
		
		// lista procedimentos do paciente
		List<Procedimento> listaDeProcedimentosDoPaciente =  new GenericDao<>(Procedimento.class).listar("select p from Procedimento p where p.paciente.cpf = ?", pacienteBuscado.getCpf());
		for (Procedimento p : listaDeProcedimentosDoPaciente) {
			System.out.println(p.toString());
		}
		
		
											// MATERIAL MEDICO
		// insere material
		MaterialMedico materialMedico = new MaterialMedico("material", 50d, "farmacia do zeh", pacienteBuscado);
		new GenericDao<>(MaterialMedico.class).adicionar(materialMedico);
		
		// lista procedimentos do paciente
		List<MaterialMedico> listaDeMateriaisDoPaciente = new GenericDao<>(MaterialMedico.class).listar("select m from MaterialMedico m where m.paciente.cpf = ?", pacienteBuscado.getCpf());
		for (MaterialMedico m : listaDeMateriaisDoPaciente) {
			System.out.println(m.toString());
		}
		
	
	}
}
