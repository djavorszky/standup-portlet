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

import com.liferay.support.standup.model.StandUpEntry;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing StandUpEntry in entity cache.
 *
 * @author Daniel Javorszky
 * @see StandUpEntry
 * @generated
 */
public class StandUpEntryCacheModel implements CacheModel<StandUpEntry>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{entryId=");
		sb.append(entryId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", quantity=");
		sb.append(quantity);
		sb.append(", difficulty=");
		sb.append(difficulty);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", blocking=");
		sb.append(blocking);
		sb.append(", additionalDetails=");
		sb.append(additionalDetails);
		sb.append(", status=");
		sb.append(status);
		sb.append("}");

		return sb.toString();
	}

	public StandUpEntry toEntityModel() {
		StandUpEntryImpl standUpEntryImpl = new StandUpEntryImpl();

		standUpEntryImpl.setEntryId(entryId);
		standUpEntryImpl.setCompanyId(companyId);
		standUpEntryImpl.setGroupId(groupId);
		standUpEntryImpl.setUserId(userId);
		standUpEntryImpl.setQuantity(quantity);
		standUpEntryImpl.setDifficulty(difficulty);

		if (createDate == Long.MIN_VALUE) {
			standUpEntryImpl.setCreateDate(null);
		}
		else {
			standUpEntryImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			standUpEntryImpl.setModifiedDate(null);
		}
		else {
			standUpEntryImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (blocking == null) {
			standUpEntryImpl.setBlocking(StringPool.BLANK);
		}
		else {
			standUpEntryImpl.setBlocking(blocking);
		}

		if (additionalDetails == null) {
			standUpEntryImpl.setAdditionalDetails(StringPool.BLANK);
		}
		else {
			standUpEntryImpl.setAdditionalDetails(additionalDetails);
		}

		standUpEntryImpl.setStatus(status);

		standUpEntryImpl.resetOriginalValues();

		return standUpEntryImpl;
	}

	public long entryId;
	public long companyId;
	public long groupId;
	public long userId;
	public int quantity;
	public int difficulty;
	public long createDate;
	public long modifiedDate;
	public String blocking;
	public String additionalDetails;
	public int status;
}