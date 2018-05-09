package com.co.techandsolve.business;

import javax.inject.Inject;

public abstract class ManejadorCrud<T, U> implements IManejadorCrud<T, U> {

	public static final Integer IGNORAR_PARAMETRO_CONSULTA = -1;

	@Inject
	protected ManejadorPersistencia<T> mp;

	private Class<T> claseEntidad;

	/**
	 * @param claseEntidad
	 *            Clase de la entidad T
	 */
	public ManejadorCrud(Class<T> claseEntidad) {
		this.claseEntidad = claseEntidad;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @param pId
	 *            {@inheritDoc}
	 * @return {@inheritDoc}
	 */
//	@Override
	public T buscar(U pId) {
		return mp.find(getClaseEntidad(), pId);
	}

	/**
	 * Método que se ejecuta antes de crear un registro en la base de datos y en
	 * el que la clase que extienda esta clase puede añadir funcionalidad
	 * personalizada.
	 */
	public void preCrear() {

	}

	/**
	 * Método que se ejecuta después de crear un registro en la base de datos y
	 * en el que la clase que extienda esta clase puede añadir funcionalidad
	 * personalizada.
	 */
	public void postCrear() {

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @param pData
	 *            {@inheritDoc}
	 */
//	@Override
	public void crear(T pData) {
		preGuardar();
		preCrear();
		mp.create(pData);
		postCrear();
		postGuardar();
	}

	/**
	 * Método que se ejecuta antes de actualizar un registro en la base de datos
	 * y en el que la clase que extienda esta clase puede añadir funcionalidad
	 * personalizada.
	 */
	public void preActualizar() {

	}

	/**
	 * Método que se ejecuta después de crear un registro en la base de datos y
	 * en el que la clase que extienda esta clase puede añadir funcionalidad
	 * personalizada.
	 */
	public void postActualizar() {

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @param pData
	 *            {@inheritDoc}
	 */
//	@Override
	public void actualizar(T pData) {
		preGuardar();
		preActualizar();
		mp.update(pData);
		postActualizar();
		postGuardar();
	}

	/**
	 * Método que se ejecuta antes de eliminar un registro en la base de datos y
	 * en el que la clase que extienda esta clase puede añadir funcionalidad
	 * personalizada.
	 */
	public void preEliminar() {

	}

	/**
	 * Método que se ejecuta después de eliminar un registro en la base de datos
	 * y en el que la clase que extienda esta clase puede añadir funcionalidad
	 * personalizada.
	 */
	public void postEliminar() {

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @param pData
	 *            {@inheritDoc}
	 */
//	@Override
	public void eliminar(T pData) {

		preEliminar();
		mp.delete(pData);
		postEliminar();

	}

	/**
	 * Método que se ejecuta antes de crear o actualizar un registro en la base
	 * de datos y en el que la clase que extienda esta clase puede añadir
	 * funcionalidad personalizada.
	 */
	public void preGuardar() {
	}

	/**
	 * Método que se ejecuta después de crear o actualizar un registro en la
	 * base de datos y en el que la clase que extienda esta clase puede añadir
	 * funcionalidad personalizada.
	 */
	public void postGuardar() {
	}

	/**
	 * @return the claseEntidad
	 */
	public Class<T> getClaseEntidad() {
		return claseEntidad;
	}

	/**
	 * @param claseEntidad
	 *            the claseEntidad to set
	 */
	public void setClaseEntidad(Class<T> claseEntidad) {
		this.claseEntidad = claseEntidad;
	}

}
