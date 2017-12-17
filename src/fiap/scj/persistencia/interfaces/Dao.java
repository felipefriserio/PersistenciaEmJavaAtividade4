package fiap.scj.persistencia.interfaces;

import java.util.List;

public interface Dao<T> {
	T adicionar(T entidade);
	List<T> listar();
	List<T> listar(String jpql, Object... params);
	void atualizar(T entidade);
	void remover(T entidade);
	T buscar(int id);
	T buscar(String jpql, Object... params);
}

