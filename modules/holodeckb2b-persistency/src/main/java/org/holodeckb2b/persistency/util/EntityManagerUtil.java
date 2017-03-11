/**
 * Copyright (C) 2014 The Holodeck B2B Team, Sander Fieten
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.holodeckb2b.persistency.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.holodeckb2b.interfaces.persistency.PersistenceException;

/**
 * Is a helper class to easily get hold of the JPA <code>EntityManager</code> to access the database where the message
 * unit meta-data is stored. This default persistency provider uses <i>holodeckb2b-core</i> as name for the JPA
 * persistency unit.
 *
 * @author Sander Fieten (sander at holodeck-b2b.org)
 * @since HB2B_NEXT_VERSION
 */
public class EntityManagerUtil {
    // We use SingletonHolder pattern for the reference to the EntityManagerFactory object
    private static final class SingletonHolder
    {
      static final EntityManagerFactory instance =  Persistence.createEntityManagerFactory("holodeckb2b-core");
    }

    /**
     * Gets a JPA {@link EntityManager} to execute database operations.
     *
     * @return  An <code>EntityManager</code> to access the database
     * @throws  PersistenceException   When exception occurs getting hold of an EntityManager object
     */
    public static EntityManager getEntityManager() throws PersistenceException {
       try {
           // The class is loaded upon first call
           return  SingletonHolder.instance.createEntityManager();
       } catch (final Exception e) {
           // Oh oh, something went wrong creating the entity manager
           throw new PersistenceException("Error while creating the EntityManager", e);
       }
    }
}
