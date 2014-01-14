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

import com.liferay.portal.service.persistence.BasePersistence;

import com.liferay.support.standup.model.GlobalInformation;

/**
 * The persistence interface for the global information service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Daniel Javorszky
 * @see GlobalInformationPersistenceImpl
 * @see GlobalInformationUtil
 * @generated
 */
public interface GlobalInformationPersistence extends BasePersistence<GlobalInformation> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link GlobalInformationUtil} to access the global information persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the global information in the entity cache if it is enabled.
	*
	* @param globalInformation the global information
	*/
	public void cacheResult(
		com.liferay.support.standup.model.GlobalInformation globalInformation);

	/**
	* Caches the global informations in the entity cache if it is enabled.
	*
	* @param globalInformations the global informations
	*/
	public void cacheResult(
		java.util.List<com.liferay.support.standup.model.GlobalInformation> globalInformations);

	/**
	* Creates a new global information with the primary key. Does not add the global information to the database.
	*
	* @param globalInformationId the primary key for the new global information
	* @return the new global information
	*/
	public com.liferay.support.standup.model.GlobalInformation create(
		long globalInformationId);

	/**
	* Removes the global information with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param globalInformationId the primary key of the global information
	* @return the global information that was removed
	* @throws com.liferay.support.standup.NoSuchGlobalInformationException if a global information with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.support.standup.model.GlobalInformation remove(
		long globalInformationId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.support.standup.NoSuchGlobalInformationException;

	public com.liferay.support.standup.model.GlobalInformation updateImpl(
		com.liferay.support.standup.model.GlobalInformation globalInformation,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the global information with the primary key or throws a {@link com.liferay.support.standup.NoSuchGlobalInformationException} if it could not be found.
	*
	* @param globalInformationId the primary key of the global information
	* @return the global information
	* @throws com.liferay.support.standup.NoSuchGlobalInformationException if a global information with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.support.standup.model.GlobalInformation findByPrimaryKey(
		long globalInformationId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.support.standup.NoSuchGlobalInformationException;

	/**
	* Returns the global information with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param globalInformationId the primary key of the global information
	* @return the global information, or <code>null</code> if a global information with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.support.standup.model.GlobalInformation fetchByPrimaryKey(
		long globalInformationId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the global informations where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching global informations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.support.standup.model.GlobalInformation> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.support.standup.model.GlobalInformation> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.support.standup.model.GlobalInformation> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first global information in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching global information
	* @throws com.liferay.support.standup.NoSuchGlobalInformationException if a matching global information could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.support.standup.model.GlobalInformation findByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.support.standup.NoSuchGlobalInformationException;

	/**
	* Returns the first global information in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching global information, or <code>null</code> if a matching global information could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.support.standup.model.GlobalInformation fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last global information in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching global information
	* @throws com.liferay.support.standup.NoSuchGlobalInformationException if a matching global information could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.support.standup.model.GlobalInformation findByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.support.standup.NoSuchGlobalInformationException;

	/**
	* Returns the last global information in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching global information, or <code>null</code> if a matching global information could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.support.standup.model.GlobalInformation fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.liferay.support.standup.model.GlobalInformation[] findByGroupId_PrevAndNext(
		long globalInformationId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.support.standup.NoSuchGlobalInformationException;

	/**
	* Returns all the global informations where date = &#63;.
	*
	* @param date the date
	* @return the matching global informations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.support.standup.model.GlobalInformation> findByDate(
		java.util.Date date)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.support.standup.model.GlobalInformation> findByDate(
		java.util.Date date, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.support.standup.model.GlobalInformation> findByDate(
		java.util.Date date, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first global information in the ordered set where date = &#63;.
	*
	* @param date the date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching global information
	* @throws com.liferay.support.standup.NoSuchGlobalInformationException if a matching global information could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.support.standup.model.GlobalInformation findByDate_First(
		java.util.Date date,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.support.standup.NoSuchGlobalInformationException;

	/**
	* Returns the first global information in the ordered set where date = &#63;.
	*
	* @param date the date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching global information, or <code>null</code> if a matching global information could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.support.standup.model.GlobalInformation fetchByDate_First(
		java.util.Date date,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last global information in the ordered set where date = &#63;.
	*
	* @param date the date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching global information
	* @throws com.liferay.support.standup.NoSuchGlobalInformationException if a matching global information could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.support.standup.model.GlobalInformation findByDate_Last(
		java.util.Date date,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.support.standup.NoSuchGlobalInformationException;

	/**
	* Returns the last global information in the ordered set where date = &#63;.
	*
	* @param date the date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching global information, or <code>null</code> if a matching global information could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.support.standup.model.GlobalInformation fetchByDate_Last(
		java.util.Date date,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.liferay.support.standup.model.GlobalInformation[] findByDate_PrevAndNext(
		long globalInformationId, java.util.Date date,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.support.standup.NoSuchGlobalInformationException;

	/**
	* Returns all the global informations where display = &#63;.
	*
	* @param display the display
	* @return the matching global informations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.support.standup.model.GlobalInformation> findByDisplay(
		int display) throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.support.standup.model.GlobalInformation> findByDisplay(
		int display, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.support.standup.model.GlobalInformation> findByDisplay(
		int display, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first global information in the ordered set where display = &#63;.
	*
	* @param display the display
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching global information
	* @throws com.liferay.support.standup.NoSuchGlobalInformationException if a matching global information could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.support.standup.model.GlobalInformation findByDisplay_First(
		int display,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.support.standup.NoSuchGlobalInformationException;

	/**
	* Returns the first global information in the ordered set where display = &#63;.
	*
	* @param display the display
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching global information, or <code>null</code> if a matching global information could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.support.standup.model.GlobalInformation fetchByDisplay_First(
		int display,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last global information in the ordered set where display = &#63;.
	*
	* @param display the display
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching global information
	* @throws com.liferay.support.standup.NoSuchGlobalInformationException if a matching global information could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.support.standup.model.GlobalInformation findByDisplay_Last(
		int display,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.support.standup.NoSuchGlobalInformationException;

	/**
	* Returns the last global information in the ordered set where display = &#63;.
	*
	* @param display the display
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching global information, or <code>null</code> if a matching global information could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.support.standup.model.GlobalInformation fetchByDisplay_Last(
		int display,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.liferay.support.standup.model.GlobalInformation[] findByDisplay_PrevAndNext(
		long globalInformationId, int display,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.support.standup.NoSuchGlobalInformationException;

	/**
	* Returns all the global informations.
	*
	* @return the global informations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.support.standup.model.GlobalInformation> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.support.standup.model.GlobalInformation> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.support.standup.model.GlobalInformation> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the global informations where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the global informations where date = &#63; from the database.
	*
	* @param date the date
	* @throws SystemException if a system exception occurred
	*/
	public void removeByDate(java.util.Date date)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the global informations where display = &#63; from the database.
	*
	* @param display the display
	* @throws SystemException if a system exception occurred
	*/
	public void removeByDisplay(int display)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the global informations from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of global informations where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching global informations
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of global informations where date = &#63;.
	*
	* @param date the date
	* @return the number of matching global informations
	* @throws SystemException if a system exception occurred
	*/
	public int countByDate(java.util.Date date)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of global informations where display = &#63;.
	*
	* @param display the display
	* @return the number of matching global informations
	* @throws SystemException if a system exception occurred
	*/
	public int countByDisplay(int display)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of global informations.
	*
	* @return the number of global informations
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}