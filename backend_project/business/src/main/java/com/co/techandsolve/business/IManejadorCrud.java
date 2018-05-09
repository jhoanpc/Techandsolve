package com.co.techandsolve.business;

/**
 * 
 * 
 */
public interface IManejadorCrud<T,U> {

    /**
     * Busca el objeto de tipo T cuyo identificar es pId
     * 
     * @param pId Identificador el objeto de clase T
     * @return El objeto de la entidad T encontrado en la busqueda
     */
    public T buscar(U pId);   

    /**
     * Crea el objeto de clase T que se pasa como parámetro en la base de datos
     * @param obj Instancia de la entidad T a almacenar en la base de datos
     */
    public void crear(T obj);

    /**
     * Actualiza en base de datos el registro correspondiente al objeto de la entidad
     * T que se pasa como parámetro
     * @param obj Instancia de la entidad T a actualizar en la base de datos
     */
    public void actualizar(T obj);

    /**
     * Elimina en base de datos el registro correspondiente al objeto de la entidad
     * T que se pasa como parámetro
     * @param obj Instancia de la entidad T a eliminar de la base de datos
     */
    public void eliminar(T obj);
    
}
