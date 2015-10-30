package com.photo.webapp.dao.util;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;


/**
 * Eine abstrakte Implementierung der Schnittstelle {@link GenericDAO}.
 *
 * @param <Entity>
 *            Die Klasse der Entität
 * @param <PrimaryKey>
 *            Die Klasse des primären Key
 */
public abstract class AbstractGenericDAO<Entity, PrimaryKey extends Serializable>
		implements GenericDAO<Entity, PrimaryKey> {

	/** Die Klasse der Entität. */
	protected final Class<Entity> entityClass;

	/** Die Klasse des primären Key. */
	protected final Class<PrimaryKey> primaryKeyClass;

	{
		ParameterizedType type = (ParameterizedType) getClass()
				.getGenericSuperclass();
		Type[] actualTypeArguments = type.getActualTypeArguments();

		@SuppressWarnings("unchecked")
		Class<Entity> entityClass = (Class<Entity>) actualTypeArguments[0];
		this.entityClass = entityClass;

		@SuppressWarnings("unchecked")
		Class<PrimaryKey> primaryKey = (Class<PrimaryKey>) actualTypeArguments[1];
		this.primaryKeyClass = primaryKey;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see GenericDAO#remove(java.io.Serializable)
	 */
	public void remove(PrimaryKey key) {
		remove(findByPrimaryKey(key));
	}

}