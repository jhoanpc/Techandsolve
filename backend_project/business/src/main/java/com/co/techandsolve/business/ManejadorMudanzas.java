package com.co.techandsolve.business;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;

import co.com.entities.MudanzasEntity;

@Stateless
public class ManejadorMudanzas extends ManejadorCrud<MudanzasEntity, Long> {

	private static final Logger logger = Logger.getLogger(MudanzasEntity.class.getName());

	@PersistenceContext(unitName = "techandsolve-pu")
	private EntityManager em;

	public ManejadorMudanzas() {
		super(MudanzasEntity.class);
	}


	public MudanzasEntity crearRegistroMudanza(MudanzasEntity entidad) throws Exception {
		
		try {
			em.persist(entidad);

			
			return entidad;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			
		}
		return null;
	}
}
