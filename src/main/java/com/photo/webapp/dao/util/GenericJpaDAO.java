package com.photo.webapp.dao.util;

import java.io.Serializable;

/**
 * Eine Erweiterung der Schnittstelle {@link GenericDAO} für JPA.
 *
 * @param <Entity>
 *            Die Klasse der Entität
 * @param <PrimaryKey>
 *            Die Klasse des primären Key
 * @see com.photo.webapp.dao.GenericDAO
 */
public interface GenericJpaDAO<Entity, PrimaryKey extends Serializable> extends
		GenericDAO<Entity, PrimaryKey> {

	// Noch keine spezielle Definitionen.

}
