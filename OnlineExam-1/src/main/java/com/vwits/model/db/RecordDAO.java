package com.vwits.model.db;

import java.util.List;

public interface RecordDAO<T, E> {
	/**
	 * To insert T record in database
	 * @param t Table 
	 * @return number of rows affected after inserting the record
	 */
	public int save(T t);
	
	/**
	 * To display particular T record
	 * @param display record with respect to T field
	 * @return T record
	 */
	public List get(E e);
	
	/**
	 * To display all the T records
	 * @return List of all the T records
	 */
	public List getAll();
	
	/**
	 * Update Record
	 * @param e according to record field
	 * @return number of rows affected after updating the record
	 */
	public void update(T t);
	
	/*
	 * Delete Record from database
	 */
	public void delete(T t);
}
