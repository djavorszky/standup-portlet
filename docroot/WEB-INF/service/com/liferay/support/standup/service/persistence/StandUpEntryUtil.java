/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.support.standup.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.liferay.support.standup.model.StandUpEntry;

import java.util.List;

/**
 * The persistence utility for the stand up entry service. This utility wraps {@link StandUpEntryPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Daniel Javorszky
 * @see StandUpEntryPersistence
 * @see StandUpEntryPersistenceImpl
 * @generated
 */
public class StandUpEntryUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(StandUpEntry standUpEntry) {
		getPersistence().clearCache(standUpEntry);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<StandUpEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<StandUpEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<StandUpEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static StandUpEntry update(StandUpEntry standUpEntry, boolean merge)
		throws SystemException {
		return getPersistence().update(standUpEntry, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static StandUpEntry update(StandUpEntry standUpEntry, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(standUpEntry, merge, serviceContext);
	}

	/**
	* Caches the stand up entry in the entity cache if it is enabled.
	*
	* @param standUpEntry the stand up entry
	*/
	public static void cacheResult(
		com.liferay.support.standup.model.StandUpEntry standUpEntry) {
		getPersistence().cacheResult(standUpEntry);
	}

	/**
	* Caches the stand up entries in the entity cache if it is enabled.
	*
	* @param standUpEntries the stand up entries
	*/
	public static void cacheResult(
		java.util.List<com.liferay.support.standup.model.StandUpEntry> standUpEntries) {
		getPersistence().cacheResult(standUpEntries);
	}

	/**
	* Creates a new stand up entry with the primary key. Does not add the stand up entry to the database.
	*
	* @param entryId the primary key for the new stand up entry
	* @return the new stand up entry
	*/
	public static com.liferay.support.standup.model.StandUpEntry create(
		long entryId) {
		return getPersistence().create(entryId);
	}

	/**
	* Removes the stand up entry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param entryId the primary key of the stand up entry
	* @return the stand up entry that was removed
	* @throws com.liferay.support.standup.NoSuchStandUpEntryException if a stand up entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.support.standup.model.StandUpEntry remove(
		long entryId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.support.standup.NoSuchStandUpEntryException {
		return getPersistence().remove(entryId);
	}

	public static com.liferay.support.standup.model.StandUpEntry updateImpl(
		com.liferay.support.standup.model.StandUpEntry standUpEntry,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(standUpEntry, merge);
	}

	/**
	* Returns the stand up entry with the primary key or throws a {@link com.liferay.support.standup.NoSuchStandUpEntryException} if it could not be found.
	*
	* @param entryId the primary key of the stand up entry
	* @return the stand up entry
	* @throws com.liferay.support.standup.NoSuchStandUpEntryException if a stand up entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.support.standup.model.StandUpEntry findByPrimaryKey(
		long entryId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.support.standup.NoSuchStandUpEntryException {
		return getPersistence().findByPrimaryKey(entryId);
	}

	/**
	* Returns the stand up entry with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param entryId the primary key of the stand up entry
	* @return the stand up entry, or <code>null</code> if a stand up entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.support.standup.model.StandUpEntry fetchByPrimaryKey(
		long entryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(entryId);
	}

	/**
	* Returns all the stand up entries.
	*
	* @return the stand up entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.support.standup.model.StandUpEntry> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the stand up entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of stand up entries
	* @param end the upper bound of the range of stand up entries (not inclusive)
	* @return the range of stand up entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.support.standup.model.StandUpEntry> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the stand up entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of stand up entries
	* @param end the upper bound of the range of stand up entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of stand up entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.support.standup.model.StandUpEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the stand up entries from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of stand up entries.
	*
	* @return the number of stand up entries
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static StandUpEntryPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (StandUpEntryPersistence)PortletBeanLocatorUtil.locate(com.liferay.support.standup.service.ClpSerializer.getServletContextName(),
					StandUpEntryPersistence.class.getName());

			ReferenceRegistry.registerReference(StandUpEntryUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(StandUpEntryPersistence persistence) {
	}

	private static StandUpEntryPersistence _persistence;
}