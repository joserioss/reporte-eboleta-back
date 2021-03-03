package cl.jrios.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.jrios.entity.CsvModel;

public interface ICsvModelRepo extends JpaRepository<CsvModel, Integer> {

}
