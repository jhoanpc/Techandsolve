package co.com.entities;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
@Table(name = "RE_MUDANZAS")
public class MudanzasEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
    @Basic(optional = false)
    @SequenceGenerator(allocationSize = 1, name = "SQ_ID_RE_MUDANZAS", sequenceName = "SEQ_RE_MUDANZAS")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_ID_RE_MUDANZAS" )
    @Column(name = "ID_MUDANZA")
    private Long idMudanza;
	
    @Basic(optional = false)
    @Column(name = "TEST_CASE")
    private String testCase;
    
    @Basic(optional = false)
    @Column(name = "USUARIOCREACION")
    private String usuariocreacion;
    
    @Basic(optional = false)
    @Column(name = "FECHA_EJECUCION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaEjecucion;
    
public MudanzasEntity(){
    	
    }
    
    
    public Long getIdMudanza() {
		return idMudanza;
	}

	public void setIdMudanza(Long idMudanza) {
		this.idMudanza = idMudanza;
	}

	public String getTestCase() {
		return testCase;
	}

	public void setTestCase(String testCase) {
		this.testCase = testCase;
	}

	public String getUsuariocreacion() {
		return usuariocreacion;
	}

	public void setUsuariocreacion(String usuariocreacion) {
		this.usuariocreacion = usuariocreacion;
	}

	public Date getFechaEjecucion() {
		return fechaEjecucion;
	}

	public void setFechaEjecucion(Date fechaEjecucion) {
		this.fechaEjecucion = fechaEjecucion;
	}

	
    
    
}
