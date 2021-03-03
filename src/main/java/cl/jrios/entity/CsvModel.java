package cl.jrios.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CsvModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private Integer folio;
	private Integer neto;
	private Integer iva;
	private Integer total;
	private Integer dte;
	private Date fecha;
	private String vendedor;
	private String sucursal;

	public CsvModel(Integer id, Integer folio, Integer neto, Integer iva, Integer total, Integer dte, Date fecha,
			String vendedor, String sucursal) {
		super();
		this.id = id;
		this.folio = folio;
		this.neto = neto;
		this.iva = iva;
		this.total = total;
		this.dte = dte;
		this.fecha = fecha;
		this.vendedor = vendedor;
		this.sucursal = sucursal;
	}

	public CsvModel() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getFolio() {
		return folio;
	}

	public void setFolio(Integer folio) {
		this.folio = folio;
	}

	public Integer getNeto() {
		return neto;
	}

	public void setNeto(Integer neto) {
		this.neto = neto;
	}

	public Integer getIva() {
		return iva;
	}

	public void setIva(Integer iva) {
		this.iva = iva;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public Integer getDte() {
		return dte;
	}

	public void setDte(Integer dte) {
		this.dte = dte;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getVendedor() {
		return vendedor;
	}

	public void setVendedor(String vendedor) {
		this.vendedor = vendedor;
	}

	public String getSucursal() {
		return sucursal;
	}

	public void setSucursal(String sucursal) {
		this.sucursal = sucursal;
	}

}
