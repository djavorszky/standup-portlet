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

package com.liferay.support.standup.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.liferay.support.standup.service.StandUpEntryLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Daniel Javorszky
 */
public class StandUpEntryClp extends BaseModelImpl<StandUpEntry>
	implements StandUpEntry {
	public StandUpEntryClp() {
	}

	public Class<?> getModelClass() {
		return StandUpEntry.class;
	}

	public String getModelClassName() {
		return StandUpEntry.class.getName();
	}

	public long getPrimaryKey() {
		return _entryId;
	}

	public void setPrimaryKey(long primaryKey) {
		setEntryId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_entryId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("entryId", getEntryId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("quantity", getQuantity());
		attributes.put("difficulty", getDifficulty());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("blocking", getBlocking());
		attributes.put("additionalDetails", getAdditionalDetails());
		attributes.put("status", getStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long entryId = (Long)attributes.get("entryId");

		if (entryId != null) {
			setEntryId(entryId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Integer quantity = (Integer)attributes.get("quantity");

		if (quantity != null) {
			setQuantity(quantity);
		}

		Integer difficulty = (Integer)attributes.get("difficulty");

		if (difficulty != null) {
			setDifficulty(difficulty);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String blocking = (String)attributes.get("blocking");

		if (blocking != null) {
			setBlocking(blocking);
		}

		String additionalDetails = (String)attributes.get("additionalDetails");

		if (additionalDetails != null) {
			setAdditionalDetails(additionalDetails);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}
	}

	public long getEntryId() {
		return _entryId;
	}

	public void setEntryId(long entryId) {
		_entryId = entryId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	public int getQuantity() {
		return _quantity;
	}

	public void setQuantity(int quantity) {
		_quantity = quantity;
	}

	public int getDifficulty() {
		return _difficulty;
	}

	public void setDifficulty(int difficulty) {
		_difficulty = difficulty;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public String getBlocking() {
		return _blocking;
	}

	public void setBlocking(String blocking) {
		_blocking = blocking;
	}

	public String getAdditionalDetails() {
		return _additionalDetails;
	}

	public void setAdditionalDetails(String additionalDetails) {
		_additionalDetails = additionalDetails;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	public BaseModel<?> getStandUpEntryRemoteModel() {
		return _standUpEntryRemoteModel;
	}

	public void setStandUpEntryRemoteModel(BaseModel<?> standUpEntryRemoteModel) {
		_standUpEntryRemoteModel = standUpEntryRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			StandUpEntryLocalServiceUtil.addStandUpEntry(this);
		}
		else {
			StandUpEntryLocalServiceUtil.updateStandUpEntry(this);
		}
	}

	@Override
	public StandUpEntry toEscapedModel() {
		return (StandUpEntry)Proxy.newProxyInstance(StandUpEntry.class.getClassLoader(),
			new Class[] { StandUpEntry.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		StandUpEntryClp clone = new StandUpEntryClp();

		clone.setEntryId(getEntryId());
		clone.setCompanyId(getCompanyId());
		clone.setGroupId(getGroupId());
		clone.setUserId(getUserId());
		clone.setQuantity(getQuantity());
		clone.setDifficulty(getDifficulty());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setBlocking(getBlocking());
		clone.setAdditionalDetails(getAdditionalDetails());
		clone.setStatus(getStatus());

		return clone;
	}

	public int compareTo(StandUpEntry standUpEntry) {
		long primaryKey = standUpEntry.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		StandUpEntryClp standUpEntry = null;

		try {
			standUpEntry = (StandUpEntryClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = standUpEntry.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{entryId=");
		sb.append(getEntryId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", quantity=");
		sb.append(getQuantity());
		sb.append(", difficulty=");
		sb.append(getDifficulty());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", blocking=");
		sb.append(getBlocking());
		sb.append(", additionalDetails=");
		sb.append(getAdditionalDetails());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(37);

		sb.append("<model><model-name>");
		sb.append("com.liferay.support.standup.model.StandUpEntry");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>entryId</column-name><column-value><![CDATA[");
		sb.append(getEntryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>quantity</column-name><column-value><![CDATA[");
		sb.append(getQuantity());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>difficulty</column-name><column-value><![CDATA[");
		sb.append(getDifficulty());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>blocking</column-name><column-value><![CDATA[");
		sb.append(getBlocking());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>additionalDetails</column-name><column-value><![CDATA[");
		sb.append(getAdditionalDetails());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _entryId;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private String _userUuid;
	private int _quantity;
	private int _difficulty;
	private Date _createDate;
	private Date _modifiedDate;
	private String _blocking;
	private String _additionalDetails;
	private int _status;
	private BaseModel<?> _standUpEntryRemoteModel;
}