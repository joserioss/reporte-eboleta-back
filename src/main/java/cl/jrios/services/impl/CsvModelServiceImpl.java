package cl.jrios.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.jrios.dao.ICsvModelRepo;
import cl.jrios.entity.CsvModel;
import cl.jrios.services.ICsvModelService;

@Service
public class CsvModelServiceImpl implements ICsvModelService {

	@Autowired
	private ICsvModelRepo repo;

	@Override
	public CsvModel registrar(CsvModel obj) {
		return repo.save(obj);
	}

	@Override
	public CsvModel modificar(CsvModel obj) {
		return repo.save(obj);
	}

	@Override
	public List<CsvModel> listar() {
		return repo.findAll();
	}

	@Override
	public CsvModel leerPorId(Integer id) {
		Optional<CsvModel> op = repo.findById(id);
		return op.isPresent() ? op.get() : new CsvModel();
	}

	@Override
	public boolean eliminar(Integer id) {
		repo.deleteById(id);
		return true;
	}

}
