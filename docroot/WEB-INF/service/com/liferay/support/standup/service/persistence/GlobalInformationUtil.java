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

import com.liferay.support.standup.model.GlobalInformation;

import java.util.List;

/**
 * The persistence utility for the global information service. This utility wraps {@link GlobalInformationPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Daniel Javorszky
 * @see GlobalInformationPersistence
 * @see GlobalInformationPersistenceImpl
 * @generated
 */
public class GlobalInformationUtil {
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
	public static void clearCache(GlobalInformation globalInformation) {
		getPersistence().clearCache(globalInformation);
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
	public static List<GlobalInformation> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<GlobalInformation> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<GlobalInformation> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static GlobalInformation update(
		GlobalInformation globalInformation, boolean merge)
		throws SystemException {
		return getPersistence().update(globalInformation, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static GlobalInformation update(
		GlobalInformation globalInformation, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(globalInformation, merge, serviceContext);
	}

	/**
	* Caches the global information in the entity cache if it is enabled.
	*
	* @param globalInformation the global information
	*/
	public static void cacheResult(
		com.liferay.support.standup.model.GlobalInformation globalInformation) {
		getPersistence().cacheResult(globalInformation);
	}

	/**
	* Caches the global informations in the entity cache if it is enabled.
	*
	* @param globalInformations the global informations
	*/
	public static void cacheResult(
		java.util.List<com.liferay.support.standup.model.GlobalInformation> globalInformations) {
		getPersistence().cacheResult(globalInformations);
	}

	/**
	* Creates a new global information with the primary key. Does not add the global information to the database.
	*
	* @param globalInformationId the primary key for the new global information
	* @return the new global information
	*/
	public static com.liferay.support.standup.model.GlobalInformation create(
		long globalInformationId) {
		return getPersistence().create(globalInformationId);
	}

	/**
	* Removes the global information with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param globalInformationId the primary key of the global information
	* @return the global information that was removed
	* @throws com.liferay.support.standup.NoSuchGlobalInformationException if a global information with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.support.standup.model.GlobalInformation remove(
		long globalInformationId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.support.standup.NoSuchGlobalInformationException {
		return getPersistence().remove(globalInformationId);
	}

	public static com.liferay.support.standup.model.GlobalInformation updateImpl(
		com.liferay.support.standup.model.GlobalInformation globalInformation,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(globalInformation, merge);
	}

	/**
	* Returns the global information with the primary key or throws a {@link com.liferay.support.standup.NoSuchGlobalInformationException} if it could not be found.
	*
	* @param globalInformationId the primary key of the global information
	* @return the global information
	* @throws com.liferay.support.standup.NoSuchGlobalInformationException if a global information with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.support.standup.model.GlobalInformation findByPrimaryKey(
		long globalInformationId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.support.standup.NoSuchGlobalInformationException {
		return getPersistence().findByPrimaryKey(globalInformationId);
	}

	/**
	* Returns the global information with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param globalInformationId the primary key of the global information
	* @return the global information, or <code>null</code> if a global information with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.support.standup.model.GlobalInformation fetchByPrimaryKey(
		long globalInformationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(globalInformationId);
	}

	/**
	* Returns all the global informations where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching global informations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.support.standup.model.GlobalInformation> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	* Returns a range of all the global informations where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of global informations
	* @param end the upper bound of the range of global informations (not inclusive)
	* @return the range of matching global informations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.support.standup.model.GlobalInformation> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	* Returns an ordered range of all the global informations where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of global informations
	* @param end the upper bound of the range of global informations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching global informations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.support.standup.model.GlobalInformation> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupId(groupId, start, end, orderByComparator);
	}

	/**
	* Returns the first global information in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching global information
	* @throws com.liferay.support.standup.NoSuchGlobalInformationException if a matching global information could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.support.standup.model.GlobalInformation findByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.support.standup.NoSuchGlobalInformationException {
		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the first global information in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching global information, or <code>null</code> if a matching global information could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.support.standup.model.GlobalInformation fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the last global information in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching global information
	* @throws com.liferay.support.standup.NoSuchGlobalInformationException if a matching global information could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.support.standup.model.GlobalInformation findByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.support.standup.NoSuchGlobalInformationException {
		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the last global information in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching global information, or <code>null</code> if a matching global information could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.support.standup.model.GlobalInformation fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the global informations before and after the current global information in the ordered set where groupId = &#63;.
	*
	* @param globalInformationId the primary key of the current global information
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next global information
	* @throws com.liferay.support.standup.NoSuchGlobalInformationException if a global information with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.support.standup.model.GlobalInformation[] findByGroupId_PrevAndNext(
		long globalInformationId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.support.standup.NoSuchGlobalInformationException {
		return getPersistence()
				   .findByGroupId_PrevAndNext(globalInformationId, groupId,
			orderByComparator);
	}

	/**
	* Returns all the global informations where date = &#63;.
	*
	* @param date the date
	* @return the matching global informations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.support.standup.model.GlobalInformation> findByDate(
		java.util.Date date)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByDate(date);
	}

	/**
	* Returns a range of all the global informations where date = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param date the date
	* @param start the lower bound of the range of global informations
	* @param end the upper bound of the range of global informations (not inclusive)
	* @return the range of matching global informations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.support.standup.model.GlobalInformation> findByDate(
		java.util.Date date, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByDate(date, start, end);
	}

	/**
	* Returns an ordered range of all the global informations where date = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param date the date
	* @param start the lower bound of the range of global informations
	* @param end the upper bound of the range of global informations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching global informations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.support.standup.model.GlobalInformation> findByDate(
		java.util.Date date, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByDate(date, start, end, orderByComparator);
	}

	/**
	* Returns the first global information in the ordered set where date = &#63;.
	*
	* @param date the date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching global information
	* @throws com.liferay.support.standup.NoSuchGlobalInformationException if a matching global information could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.support.standup.model.GlobalInformation findByDate_First(
		java.util.Date date,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.support.standup.NoSuchGlobalInformationException {
		return getPersistence().findByDate_First(date, orderByComparator);
	}

	/**
	* Returns the first global information in the ordered set where date = &#63;.
	*
	* @param date the date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching global information, or <code>null</code> if a matching global information could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.support.standup.model.GlobalInformation fetchByDate_First(
		java.util.Date date,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByDate_First(date, orderByComparator);
	}

	/**
	* Returns the last global information in the ordered set where date = &#63;.
	*
	* @param date the date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching global information
	* @throws com.liferay.support.standup.NoSuchGlobalInformationException if a matching global information could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.support.standup.model.GlobalInformation findByDate_Last(
		java.util.Date date,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.support.standup.NoSuchGlobalInformationException {
		return getPersistence().findByDate_Last(date, orderByComparator);
	}

	/**
	* Returns the last global information in the ordered set where date = &#63;.
	*
	* @param date the date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching global information, or <code>null</code> if a matching global information could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.support.standup.model.GlobalInformation fetchByDate_Last(
		java.util.Date date,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByDate_Last(date, orderByComparator);
	}

	/**
	* Returns the global informations before and after the current global information in the ordered set where date = &#63;.
	*
	* @param globalInformationId the primary key of the current global information
	* @param date the date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next global information
	* @throws com.liferay.support.standup.NoSuchGlobalInformationException if a global information with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.support.standup.model.GlobalInformation[] findByDate_PrevAndNext(
		long globalInformationId, java.util.Date date,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.support.standup.NoSuchGlobalInformationException {
		return getPersistence()
				   .findByDate_PrevAndNext(globalInformationId, date,
			orderByComparator);
	}

	/**
	* Returns all the global informations where display = &#63;.
	*
	* @param display the display
	* @return the matching global informations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.support.standup.model.GlobalInformation> findByDisplay(
		int display) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByDisplay(display);
	}

	/**
	* Returns a range of all the global informations where display = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param display the display
	* @param start the lower bound of the range of global informations
	* @param end the upper bound of the range of global informations (not inclusive)
	* @return the range of matching global informations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.support.standup.model.GlobalInformation> findByDisplay(
		int display, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByDisplay(display, start, end);
	}

	/**
	* Returns an ordered range of all the global informations where display = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param display the display
	* @param start the lower bound of the range of global informations
	* @param end the upper bound of the range of global informations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching global informations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.support.standup.model.GlobalInformation> findByDisplay(
		int display, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByDisplay(display, start, end, orderByComparator);
	}

	/**
	* Returns the first global information in the ordered set where display = &#63;.
	*
	* @param display the display
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching global information
	* @throws com.liferay.support.standup.NoSuchGlobalInformationException if a matching global information could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.support.standup.model.GlobalInformation findByDisplay_First(
		int display,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.support.standup.NoSuchGlobalInformationException {
		return getPersistence().findByDisplay_First(display, orderByComparator);
	}

	/**
	* Returns the first global information in the ordered set where display = &#63;.
	*
	* @param display the display
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching global information, or <code>null</code> if a matching global information could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.support.standup.model.GlobalInformation fetchByDisplay_First(
		int display,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByDisplay_First(display, orderByComparator);
	}

	/**
	* Returns the last global information in the ordered set where display = &#63;.
	*
	* @param display the display
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching global information
	* @throws com.liferay.support.standup.NoSuchGlobalInformationException if a matching global information could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.support.standup.model.GlobalInformation findByDisplay_Last(
		int display,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.support.standup.NoSuchGlobalInformationException {
		return getPersistence().findByDisplay_Last(display, orderByComparator);
	}

	/**
	* Returns the last global information in the ordered set where display = &#63;.
	*
	* @param display the display
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching global information, or <code>null</code> if a matching global information could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.support.standup.model.GlobalInformation fetchByDisplay_Last(
		int display,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByDisplay_Last(display, orderByComparator);
	}

	/**
	* Returns the global informations before and after the current global information in the ordered set where display = &#63;.
	*
	* @param globalInformationId the primary key of the current global information
	* @param display the display
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next global information
	* @throws com.liferay.support.standup.NoSuchGlobalInformationException if a global information with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.support.standup.model.GlobalInformation[] findByDisplay_PrevAndNext(
		long globalInformationId, int display,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.support.standup.NoSuchGlobalInformationException {
		return getPersistence()
				   .findByDisplay_PrevAndNext(globalInformationId, display,
			orderByComparator);
	}

	/**
	* Returns all the global informations.
	*
	* @return the global informations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.support.standup.model.GlobalInformation> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the global informations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of global informations
	* @param end the upper bound of the range of global informations (not inclusive)
	* @return the range of global informations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.support.standup.model.GlobalInformation> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the global informations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of global informations
	* @param end the upper bound of the range of global informations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of global informations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.support.standup.model.GlobalInformation> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the global informations where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	* Removes all the global informations where date = &#63; from the database.
	*
	* @param date the date
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByDate(java.util.Date date)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByDate(date);
	}

	/**
	* Removes all the global informations where display = &#63; from the database.
	*
	* @param display the display
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByDisplay(int display)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByDisplay(display);
	}

	/**
	* Removes all the global informations from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of global informations where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching global informations
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	* Returns the number of global informations where date = &#63;.
	*
	* @param date the date
	* @return the number of matching global informations
	* @throws SystemException if a system exception occurred
	*/
	public static int countByDate(java.util.Date date)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByDate(date);
	}

	/**
	* Returns the number of global informations where display = &#63;.
	*
	* @param display the display
	* @return the number of matching global informations
	* @throws SystemException if a system exception occurred
	*/
	public static int countByDisplay(int display)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByDisplay(display);
	}

	/**
	* Returns the number of global informations.
	*
	* @return the number of global informations
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static GlobalInformationPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (GlobalInformationPersistence)PortletBeanLocatorUtil.locate(com.liferay.support.standup.service.ClpSerializer.getServletContextName(),
					GlobalInformationPersistence.class.getName());

			ReferenceRegistry.registerReference(GlobalInformationUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(GlobalInformationPersistence persistence) {
	}

	private static GlobalInformationPersistence _persistence;
}