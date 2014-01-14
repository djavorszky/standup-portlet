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

package com.liferay.support.standup.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.liferay.support.standup.model.GlobalInformation;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing GlobalInformation in entity cache.
 *
 * @author Daniel Javorszky
 * @see GlobalInformation
 * @generated
 */
public class GlobalInformationCacheModel implements CacheModel<GlobalInformation>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{globalInformationId=");
		sb.append(globalInformationId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", date=");
		sb.append(date);
		sb.append(", message=");
		sb.append(message);
		sb.append(", display=");
		sb.append(display);
		sb.append(", status=");
		sb.append(status);
		sb.append("}");

		return sb.toString();
	}

	public GlobalInformation toEntityModel() {
		GlobalInformationImpl globalInformationImpl = new GlobalInformationImpl();

		globalInformationImpl.setGlobalInformationId(globalInformationId);
		globalInformationImpl.setCompanyId(companyId);
		globalInformationImpl.setGroupId(groupId);
		globalInformationImpl.setUserId(userId);

		if (date == Long.MIN_VALUE) {
			globalInformationImpl.setDate(null);
		}
		else {
			globalInformationImpl.setDate(new Date(date));
		}

		if (message == null) {
			globalInformationImpl.setMessage(StringPool.BLANK);
		}
		else {
			globalInformationImpl.setMessage(message);
		}

		globalInformationImpl.setDisplay(display);
		globalInformationImpl.setStatus(status);

		globalInformationImpl.resetOriginalValues();

		return globalInformationImpl;
	}

	public long globalInformationId;
	public long companyId;
	public long groupId;
	public long userId;
	public long date;
	public String message;
	public int display;
	public int status;
}