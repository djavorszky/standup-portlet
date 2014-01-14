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
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.liferay.support.standup.service.GlobalInformationLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Daniel Javorszky
 */
public class GlobalInformationClp extends BaseModelImpl<GlobalInformation>
	implements GlobalInformation {
	public GlobalInformationClp() {
	}

	public Class<?> getModelClass() {
		return GlobalInformation.class;
	}

	public String getModelClassName() {
		return GlobalInformation.class.getName();
	}

	public long getPrimaryKey() {
		return _globalInformationId;
	}

	public void setPrimaryKey(long primaryKey) {
		setGlobalInformationId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_globalInformationId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("globalInformationId", getGlobalInformationId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("date", getDate());
		attributes.put("message", getMessage());
		attributes.put("display", getDisplay());
		attributes.put("status", getStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long globalInformationId = (Long)attributes.get("globalInformationId");

		if (globalInformationId != null) {
			setGlobalInformationId(globalInformationId);
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

		Date date = (Date)attributes.get("date");

		if (date != null) {
			setDate(date);
		}

		String message = (String)attributes.get("message");

		if (message != null) {
			setMessage(message);
		}

		Integer display = (Integer)attributes.get("display");

		if (display != null) {
			setDisplay(display);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}
	}

	public long getGlobalInformationId() {
		return _globalInformationId;
	}

	public void setGlobalInformationId(long globalInformationId) {
		_globalInformationId = globalInformationId;
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

	public Date getDate() {
		return _date;
	}

	public void setDate(Date date) {
		_date = date;
	}

	public String getMessage() {
		return _message;
	}

	public void setMessage(String message) {
		_message = message;
	}

	public int getDisplay() {
		return _display;
	}

	public void setDisplay(int display) {
		_display = display;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	public BaseModel<?> getGlobalInformationRemoteModel() {
		return _globalInformationRemoteModel;
	}

	public void setGlobalInformationRemoteModel(
		BaseModel<?> globalInformationRemoteModel) {
		_globalInformationRemoteModel = globalInformationRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			GlobalInformationLocalServiceUtil.addGlobalInformation(this);
		}
		else {
			GlobalInformationLocalServiceUtil.updateGlobalInformation(this);
		}
	}

	@Override
	public GlobalInformation toEscapedModel() {
		return (GlobalInformation)Proxy.newProxyInstance(GlobalInformation.class.getClassLoader(),
			new Class[] { GlobalInformation.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		GlobalInformationClp clone = new GlobalInformationClp();

		clone.setGlobalInformationId(getGlobalInformationId());
		clone.setCompanyId(getCompanyId());
		clone.setGroupId(getGroupId());
		clone.setUserId(getUserId());
		clone.setDate(getDate());
		clone.setMessage(getMessage());
		clone.setDisplay(getDisplay());
		clone.setStatus(getStatus());

		return clone;
	}

	public int compareTo(GlobalInformation globalInformation) {
		int value = 0;

		value = DateUtil.compareTo(getDate(), globalInformation.getDate());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		GlobalInformationClp globalInformation = null;

		try {
			globalInformation = (GlobalInformationClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = globalInformation.getPrimaryKey();

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
		StringBundler sb = new StringBundler(17);

		sb.append("{globalInformationId=");
		sb.append(getGlobalInformationId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", date=");
		sb.append(getDate());
		sb.append(", message=");
		sb.append(getMessage());
		sb.append(", display=");
		sb.append(getDisplay());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(28);

		sb.append("<model><model-name>");
		sb.append("com.liferay.support.standup.model.GlobalInformation");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>globalInformationId</column-name><column-value><![CDATA[");
		sb.append(getGlobalInformationId());
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
			"<column><column-name>date</column-name><column-value><![CDATA[");
		sb.append(getDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>message</column-name><column-value><![CDATA[");
		sb.append(getMessage());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>display</column-name><column-value><![CDATA[");
		sb.append(getDisplay());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _globalInformationId;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private String _userUuid;
	private Date _date;
	private String _message;
	private int _display;
	private int _status;
	private BaseModel<?> _globalInformationRemoteModel;
}