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

package com.liferay.support.standup.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * The utility for the global information local service. This utility wraps {@link com.liferay.support.standup.service.impl.GlobalInformationLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Daniel Javorszky
 * @see GlobalInformationLocalService
 * @see com.liferay.support.standup.service.base.GlobalInformationLocalServiceBaseImpl
 * @see com.liferay.support.standup.service.impl.GlobalInformationLocalServiceImpl
 * @generated
 */
public class GlobalInformationLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.support.standup.service.impl.GlobalInformationLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the global information to the database. Also notifies the appropriate model listeners.
	*
	* @param globalInformation the global information
	* @return the global information that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.support.standup.model.GlobalInformation addGlobalInformation(
		com.liferay.support.standup.model.GlobalInformation globalInformation)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addGlobalInformation(globalInformation);
	}

	/**
	* Creates a new global information with the primary key. Does not add the global information to the database.
	*
	* @param globalInformationId the primary key for the new global information
	* @return the new global information
	*/
	public static com.liferay.support.standup.model.GlobalInformation createGlobalInformation(
		long globalInformationId) {
		return getService().createGlobalInformation(globalInformationId);
	}

	/**
	* Deletes the global information with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param globalInformationId the primary key of the global information
	* @return the global information that was removed
	* @throws PortalException if a global information with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.support.standup.model.GlobalInformation deleteGlobalInformation(
		long globalInformationId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteGlobalInformation(globalInformationId);
	}

	/**
	* Deletes the global information from the database. Also notifies the appropriate model listeners.
	*
	* @param globalInformation the global information
	* @return the global information that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.support.standup.model.GlobalInformation deleteGlobalInformation(
		com.liferay.support.standup.model.GlobalInformation globalInformation)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteGlobalInformation(globalInformation);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	public static com.liferay.support.standup.model.GlobalInformation fetchGlobalInformation(
		long globalInformationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchGlobalInformation(globalInformationId);
	}

	/**
	* Returns the global information with the primary key.
	*
	* @param globalInformationId the primary key of the global information
	* @return the global information
	* @throws PortalException if a global information with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.support.standup.model.GlobalInformation getGlobalInformation(
		long globalInformationId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getGlobalInformation(globalInformationId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<com.liferay.support.standup.model.GlobalInformation> getGlobalInformations(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getGlobalInformations(start, end);
	}

	/**
	* Returns the number of global informations.
	*
	* @return the number of global informations
	* @throws SystemException if a system exception occurred
	*/
	public static int getGlobalInformationsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getGlobalInformationsCount();
	}

	/**
	* Updates the global information in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param globalInformation the global information
	* @return the global information that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.support.standup.model.GlobalInformation updateGlobalInformation(
		com.liferay.support.standup.model.GlobalInformation globalInformation)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateGlobalInformation(globalInformation);
	}

	/**
	* Updates the global information in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param globalInformation the global information
	* @param merge whether to merge the global information with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the global information that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.support.standup.model.GlobalInformation updateGlobalInformation(
		com.liferay.support.standup.model.GlobalInformation globalInformation,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateGlobalInformation(globalInformation, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static void clearService() {
		_service = null;
	}

	public static GlobalInformationLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					GlobalInformationLocalService.class.getName());

			if (invokableLocalService instanceof GlobalInformationLocalService) {
				_service = (GlobalInformationLocalService)invokableLocalService;
			}
			else {
				_service = new GlobalInformationLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(GlobalInformationLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated
	 */
	public void setService(GlobalInformationLocalService service) {
	}

	private static GlobalInformationLocalService _service;
}