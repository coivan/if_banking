package factory;

import java.util.List;

import strategy.ContaStrategy;

public interface ContaFactory {

	void insert(ContaStrategy obj);
	ContaStrategy read(String numero);
	List<ContaStrategy> readAll();
	void update(ContaStrategy obj);
	void delete(String numero);
}

