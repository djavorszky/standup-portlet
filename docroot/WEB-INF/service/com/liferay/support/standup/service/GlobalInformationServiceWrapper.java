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

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link GlobalInformationService}.
 * </p>
 *
 * @author    Daniel Javorszky
 * @see       GlobalInformationService
 * @generated
 */
public class GlobalInformationServiceWrapper implements GlobalInformationService,
	ServiceWrapper<GlobalInformationService> {
	public GlobalInformationServiceWrapper(
		GlobalInformationService globalInformationService) {
		_globalInformationService = globalInformationService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _globalInformationService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_globalInformationService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _globalInformationService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public GlobalInformationService getWrappedGlobalInformationService() {
		return _globalInformationService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedGlobalInformationService(
		GlobalInformationService globalInformationService) {
		_globalInformationService = globalInformationService;
	}

	public GlobalInformationService getWrappedService() {
		return _globalInformationService;
	}

	public void setWrappedService(
		GlobalInformationService globalInformationService) {
		_globalInformationService = globalInformationService;
	}

	private GlobalInformationService _globalInformationService;
}