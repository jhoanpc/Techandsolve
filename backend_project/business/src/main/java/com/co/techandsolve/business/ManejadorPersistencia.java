package com.co.techandsolve.business;

import java.io.Serializable;
import java.util.List;
import java.util.concurrent.Callable;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


public class ManejadorPersistencia <T> implements Serializable {

    // Atributos
    @PersistenceContext
    private transient EntityManager em;
    
    /**
    * Variable estatica para imprimir logs...
    */
    private static final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(ManejadorPersistencia.class.getName());

    /**
     * Persiste un objeto en la base de datos.
     *
     * @param obj Instancia de la entidad T a crear en la base de datos
     */
    public void create(Object obj) {
        em.persist(obj);
        em.flush();
    }

    /**
     * Elimina los objetos en cascada deacuerdo a su mapeo
     *
     * @param o Objeto a eliminar
     */
    public void deleteCascade(Object o) {
        em.remove(em.merge(o));
    }

    /**
     * Limpia toda la informaci√≥n en cache para la sesi√≥n actual
     */
    public void clear() {
        em.clear();
    }

    /**
     * Elimina un objeto de la base de datos.
     *
     * @param obj Instancia de la entidad T a eliminar de la base de datos
     */
    public void delete(Object obj) {
        em.remove(em.merge(obj));
    }

    /**
     * Actualiza un objeto en la base de datos.
     *
     * @param obj Instancia de la entidad T a actualizar en la base de datos
     */
    public void update(Object obj) {
        em.merge(obj);
        em.flush();
    }

    /**
     * Actualiza un objeto desde la base de datos.
     *
     * @param obj Instancia de la entidad T a actualizar desde la base de datos
     */
    public void refresh(Object obj) {
        em.refresh(obj);
    }

    /**
     * Busca un objeto en la base de datos.
     * @param <T> Identificador de la clase de una entidad
     * @param cl Clase de la entidad T
     * @param pk Llave primaria de la instancia de la entidad T a buscar
     * @return El objeto de la clase T identificado con el pk especificado 
     */
    public <T> T find(Class<T> cl, Object pk) {
        return em.find(cl, pk);
    }

    /**
     * Obtiene una lista con todos los resultados de una entidad.
     *
     * @param obj Instancia de una entidad (No importan los valores)
     * @return List Lista de todas las instancias encontradas para la entidad del objeto obj
     */
    public List listData(Object obj) {
        return em.createNamedQuery(obj.getClass().getSimpleName() + ".findAll").getResultList();
    }

    /**
     * Obtiene una lista con todos los resultados de una entidad.
     *
     * @param clazz Clase de la entidad a consultar
     * @return List Lista de todas las instancias encontradas para la entidad de la clase clazz
     */
    public List<T> listData(Class clazz) {
        return em.createNamedQuery(clazz.getSimpleName() + ".findAll").getResultList();
    }

    /**
     * Obtiene una lista con todos los resultados de un query.
     *
     * @param q Query jpql a ejecutar
     * @return List Lista con los resultados de la ejecución del query
     */
    public List listData(Query q) {    	
        return q.getResultList();
    }

    /**
     * Crea un nuevo query JPQL
     *
     * @param sql El query en formato JPQL
     * @return El query JPQL
     */
    public Query createQuery(String sql) {
        return em.createQuery(sql);
    }

    /**
     * Crea un nuevo query a partir del nombre dado
     *
     * @param sql El query nombrado en formato jpql
     * @return El query JPQL
     */
    public Query createNamedQuery(String sql) {
        return em.createNamedQuery(sql);
    }

    /**
     * Obtiene un referencia a una instancia de la clase dada
     * @param <R> Identificador de una clase
     * @param clazz Clase de la cual se quiere obtener la referencia
     * @param id Identificar del objeto del cual se quiere obtener la referencia
     * @return El objeto identificado con el id especificado
     */
    public <R> R getReference(Class<R> clazz, Object id) {
        return em.getReference(clazz, id);
    }

    /**
     * Ejecuta el conteo de todos los registros de la tabla corrspondiente a la clase c
     * 
     * @param c La clase de la entidad sobre la cual se va a realizar la consulta
     * @return El número de registro en la tabla de la entidad c
     */
    public int getCount(Class c) {
        return ((Long) em.createQuery("select count(c) from " + c.getSimpleName() + " c").getSingleResult()).intValue();
    }

    /**
     * Ejecuta el "Callable" que llega como parametro en el contexto de
     * persistencia
     *
     * @param <V> El tipo de resultado generado por el "Callable"
     * @param c El "Callable"
     * @return El resultado de la ejecución
     */
    public <V> V executeInPersistenceContext(Callable<V> c) {
        V resultado = null;
        try {
            resultado = c.call();
        } catch (Exception ex) {
            logger.error(ex);
        }
        return resultado;
    }   

    /**
     * Ejecuta el query nativo sel que se pasa como parámetro
     * @param querystr Query nativo en formato sql
     * @return La lista con los resultados de la ejecución del query
     */
    public List<Object[]> doNativeQuery(String querystr) {

        logger.debug("NATIVE QRY> " + querystr);
        
        return em.createNativeQuery(querystr).getResultList();

    }
    
    /**
     * Obtiene un único objeto resultado de la ejecución del query
     * 
     * @param q Query jpql a ejecutar
     * @return El resultado de la consulta 
     */
    public Object getData(Query q) {
    	Object objeto;
    	try{
            objeto = q.getSingleResult();
    	}catch(NoResultException e){
            logger.error(e);
            objeto = null;
    	}
    	
        return objeto;
    }
    
    /**
     * Crea un nuevo query JPQL
     *
     * @param sql El query en formato JPQL
     * @return El query JPQL
     */
    public Query createNativeQuery(String sql) {
        return em.createNativeQuery(sql);
    }

}
