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

package com.liferay.support.standup.service.base;

import com.liferay.counter.service.CounterLocalService;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.PersistedModel;
import com.liferay.portal.service.BaseLocalServiceImpl;
import com.liferay.portal.service.PersistedModelLocalServiceRegistryUtil;
import com.liferay.portal.service.ResourceLocalService;
import com.liferay.portal.service.ResourceService;
import com.liferay.portal.service.UserLocalService;
import com.liferay.portal.service.UserService;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;

import com.liferay.support.standup.model.GlobalInformation;
import com.liferay.support.standup.service.GlobalInformationLocalService;
import com.liferay.support.standup.service.GlobalInformationService;
import com.liferay.support.standup.service.StandUpEntryLocalService;
import com.liferay.support.standup.service.StandUpEntryService;
import com.liferay.support.standup.service.persistence.GlobalInformationPersistence;
import com.liferay.support.standup.service.persistence.StandUpEntryPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * The base implementation of the global information local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.liferay.support.standup.service.impl.GlobalInformationLocalServiceImpl}.
 * </p>
 *
 * @author Daniel Javorszky
 * @see com.liferay.support.standup.service.impl.GlobalInformationLocalServiceImpl
 * @see com.liferay.support.standup.service.GlobalInformationLocalServiceUtil
 * @generated
 */
public abstract class GlobalInformationLocalServiceBaseImpl
	extends BaseLocalServiceImpl implements GlobalInformationLocalService,
		IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.liferay.support.standup.service.GlobalInformationLocalServiceUtil} to access the global information local service.
	 */

	/**
	 * Adds the global information to the database. Also notifies the appropriate model listeners.
	 *
	 * @param globalInformation the global information
	 * @return the global information that was added
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	public GlobalInformation addGlobalInformation(
		GlobalInformation globalInformation) throws SystemException {
		globalInformation.setNew(true);

		return globalInformationPersistence.update(globalInformation, false);
	}

	/**
	 * Creates a new global information with the primary key. Does not add the global information to the database.
	 *
	 * @param globalInformationId the primary key for the new global information
	 * @return the new global information
	 */
	public GlobalInformation createGlobalInformation(long globalInformationId) {
		return globalInformationPersistence.create(globalInformationId);
	}

	/**
	 * Deletes the global information with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param globalInformationId the primary key of the global information
	 * @return the global information that was removed
	 * @throws PortalException if a global information with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	public GlobalInformation deleteGlobalInformation(long globalInformationId)
		throws PortalException, SystemException {
		return globalInformationPersistence.remove(globalInformationId);
	}

	/**
	 * Deletes the global information from the database. Also notifies the appropriate model listeners.
	 *
	 * @param globalInformation the global information
	 * @return the global information that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	public GlobalInformation deleteGlobalInformation(
		GlobalInformation globalInformation) throws SystemException {
		return globalInformationPersistence.remove(globalInformation);
	}

	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(GlobalInformation.class,
			clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return globalInformationPersistence.findWithDynamicQuery(dynamicQuery);
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
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return globalInformationPersistence.findWithDynamicQuery(dynamicQuery,
			start, end);
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
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return globalInformationPersistence.findWithDynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows that match the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows that match the dynamic query
	 * @throws SystemException if a system exception occurred
	 */
	public long dynamicQueryCount(DynamicQuery dynamicQuery)
		throws SystemException {
		return globalInformationPersistence.countWithDynamicQuery(dynamicQuery);
	}

	public GlobalInformation fetchGlobalInformation(long globalInformationId)
		throws SystemException {
		return globalInformationPersistence.fetchByPrimaryKey(globalInformationId);
	}

	/**
	 * Returns the global information with the primary key.
	 *
	 * @param globalInformationId the primary key of the global information
	 * @return the global information
	 * @throws PortalException if a global information with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public GlobalInformation getGlobalInformation(long globalInformationId)
		throws PortalException, SystemException {
		return globalInformationPersistence.findByPrimaryKey(globalInformationId);
	}

	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException, SystemException {
		return globalInformationPersistence.findByPrimaryKey(primaryKeyObj);
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
	public List<GlobalInformation> getGlobalInformations(int start, int end)
		throws SystemException {
		return globalInformationPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of global informations.
	 *
	 * @return the number of global informations
	 * @throws SystemException if a system exception occurred
	 */
	public int getGlobalInformationsCount() throws SystemException {
		return globalInformationPersistence.countAll();
	}

	/**
	 * Updates the global information in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param globalInformation the global information
	 * @return the global information that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	public GlobalInformation updateGlobalInformation(
		GlobalInformation globalInformation) throws SystemException {
		return updateGlobalInformation(globalInformation, true);
	}

	/**
	 * Updates the global information in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param globalInformation the global information
	 * @param merge whether to merge the global information with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	 * @return the global information that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	public GlobalInformation updateGlobalInformation(
		GlobalInformation globalInformation, boolean merge)
		throws SystemException {
		globalInformation.setNew(false);

		return globalInformationPersistence.update(globalInformation, merge);
	}

	/**
	 * Returns the global information local service.
	 *
	 * @return the global information local service
	 */
	public GlobalInformationLocalService getGlobalInformationLocalService() {
		return globalInformationLocalService;
	}

	/**
	 * Sets the global information local service.
	 *
	 * @param globalInformationLocalService the global information local service
	 */
	public void setGlobalInformationLocalService(
		GlobalInformationLocalService globalInformationLocalService) {
		this.globalInformationLocalService = globalInformationLocalService;
	}

	/**
	 * Returns the global information remote service.
	 *
	 * @return the global information remote service
	 */
	public GlobalInformationService getGlobalInformationService() {
		return globalInformationService;
	}

	/**
	 * Sets the global information remote service.
	 *
	 * @param globalInformationService the global information remote service
	 */
	public void setGlobalInformationService(
		GlobalInformationService globalInformationService) {
		this.globalInformationService = globalInformationService;
	}

	/**
	 * Returns the global information persistence.
	 *
	 * @return the global information persistence
	 */
	public GlobalInformationPersistence getGlobalInformationPersistence() {
		return globalInformationPersistence;
	}

	/**
	 * Sets the global information persistence.
	 *
	 * @param globalInformationPersistence the global information persistence
	 */
	public void setGlobalInformationPersistence(
		GlobalInformationPersistence globalInformationPersistence) {
		this.globalInformationPersistence = globalInformationPersistence;
	}

	/**
	 * Returns the stand up entry local service.
	 *
	 * @return the stand up entry local service
	 */
	public StandUpEntryLocalService getStandUpEntryLocalService() {
		return standUpEntryLocalService;
	}

	/**
	 * Sets the stand up entry local service.
	 *
	 * @param standUpEntryLocalService the stand up entry local service
	 */
	public void setStandUpEntryLocalService(
		StandUpEntryLocalService standUpEntryLocalService) {
		this.standUpEntryLocalService = standUpEntryLocalService;
	}

	/**
	 * Returns the stand up entry remote service.
	 *
	 * @return the stand up entry remote service
	 */
	public StandUpEntryService getStandUpEntryService() {
		return standUpEntryService;
	}

	/**
	 * Sets the stand up entry remote service.
	 *
	 * @param standUpEntryService the stand up entry remote service
	 */
	public void setStandUpEntryService(StandUpEntryService standUpEntryService) {
		this.standUpEntryService = standUpEntryService;
	}

	/**
	 * Returns the stand up entry persistence.
	 *
	 * @return the stand up entry persistence
	 */
	public StandUpEntryPersistence getStandUpEntryPersistence() {
		return standUpEntryPersistence;
	}

	/**
	 * Sets the stand up entry persistence.
	 *
	 * @param standUpEntryPersistence the stand up entry persistence
	 */
	public void setStandUpEntryPersistence(
		StandUpEntryPersistence standUpEntryPersistence) {
		this.standUpEntryPersistence = standUpEntryPersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the resource remote service.
	 *
	 * @return the resource remote service
	 */
	public ResourceService getResourceService() {
		return resourceService;
	}

	/**
	 * Sets the resource remote service.
	 *
	 * @param resourceService the resource remote service
	 */
	public void setResourceService(ResourceService resourceService) {
		this.resourceService = resourceService;
	}

	/**
	 * Returns the resource persistence.
	 *
	 * @return the resource persistence
	 */
	public ResourcePersistence getResourcePersistence() {
		return resourcePersistence;
	}

	/**
	 * Sets the resource persistence.
	 *
	 * @param resourcePersistence the resource persistence
	 */
	public void setResourcePersistence(ResourcePersistence resourcePersistence) {
		this.resourcePersistence = resourcePersistence;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user remote service.
	 *
	 * @return the user remote service
	 */
	public UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
		PersistedModelLocalServiceRegistryUtil.register("com.liferay.support.standup.model.GlobalInformation",
			globalInformationLocalService);
	}

	public void destroy() {
		PersistedModelLocalServiceRegistryUtil.unregister(
			"com.liferay.support.standup.model.GlobalInformation");
	}

	/**
	 * Returns the Spring bean ID for this bean.
	 *
	 * @return the Spring bean ID for this bean
	 */
	public String getBeanIdentifier() {
		return _beanIdentifier;
	}

	/**
	 * Sets the Spring bean ID for this bean.
	 *
	 * @param beanIdentifier the Spring bean ID for this bean
	 */
	public void setBeanIdentifier(String beanIdentifier) {
		_beanIdentifier = beanIdentifier;
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		return _clpInvoker.invokeMethod(name, parameterTypes, arguments);
	}

	protected Class<?> getModelClass() {
		return GlobalInformation.class;
	}

	protected String getModelClassName() {
		return GlobalInformation.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = globalInformationPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = GlobalInformationLocalService.class)
	protected GlobalInformationLocalService globalInformationLocalService;
	@BeanReference(type = GlobalInformationService.class)
	protected GlobalInformationService globalInformationService;
	@BeanReference(type = GlobalInformationPersistence.class)
	protected GlobalInformationPersistence globalInformationPersistence;
	@BeanReference(type = StandUpEntryLocalService.class)
	protected StandUpEntryLocalService standUpEntryLocalService;
	@BeanReference(type = StandUpEntryService.class)
	protected StandUpEntryService standUpEntryService;
	@BeanReference(type = StandUpEntryPersistence.class)
	protected StandUpEntryPersistence standUpEntryPersistence;
	@BeanReference(type = CounterLocalService.class)
	protected CounterLocalService counterLocalService;
	@BeanReference(type = ResourceLocalService.class)
	protected ResourceLocalService resourceLocalService;
	@BeanReference(type = ResourceService.class)
	protected ResourceService resourceService;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserLocalService.class)
	protected UserLocalService userLocalService;
	@BeanReference(type = UserService.class)
	protected UserService userService;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private String _beanIdentifier;
	private GlobalInformationLocalServiceClpInvoker _clpInvoker = new GlobalInformationLocalServiceClpInvoker();
}