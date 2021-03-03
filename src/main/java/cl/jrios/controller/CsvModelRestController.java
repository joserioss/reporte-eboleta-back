package cl.jrios.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import cl.jrios.entity.CsvModel;
import cl.jrios.exception.ModelNotFoundException;
import cl.jrios.services.ICsvModelService;

@RestController
@RequestMapping("/api/csvModel")
public class CsvModelRestController {

	@Autowired
	private ICsvModelService service;
	
	@GetMapping
	public ResponseEntity<List<CsvModel>> listar(){
		 List<CsvModel> lista = service.listar();
		return new ResponseEntity<List<CsvModel>>(lista, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CsvModel> listarPorId(@PathVariable("id") Integer id){
		CsvModel obj = service.leerPorId(id);
		if(obj.getId() == null) {
			throw new ModelNotFoundException("ID NO ENCONTRADO " + id);
		}
		return new ResponseEntity<CsvModel>(obj, HttpStatus.OK); 
	}
	
	@PostMapping
	public ResponseEntity<Object> registrar(@Validated @RequestBody CsvModel paciente) {
		service.registrar(paciente);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(paciente.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	public ResponseEntity<CsvModel> modificar(@Validated @RequestBody CsvModel consulta) {
		CsvModel obj = service.modificar(consulta);
		return new ResponseEntity<CsvModel>(obj, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id){
		CsvModel obj = service.leerPorId(id);
		if(obj.getId() == null) {
			throw new ModelNotFoundException("ID NO ENCONTRADO " + id);
		}
		service.eliminar(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
}
