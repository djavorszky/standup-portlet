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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.liferay.support.standup.service.http.GlobalInformationServiceSoap}.
 *
 * @author    Daniel Javorszky
 * @see       com.liferay.support.standup.service.http.GlobalInformationServiceSoap
 * @generated
 */
public class GlobalInformationSoap implements Serializable {
	public static GlobalInformationSoap toSoapModel(GlobalInformation model) {
		GlobalInformationSoap soapModel = new GlobalInformationSoap();

		soapModel.setGlobalInformationId(model.getGlobalInformationId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setUserId(model.getUserId());
		soapModel.setDate(model.getDate());
		soapModel.setMessage(model.getMessage());
		soapModel.setDisplay(model.getDisplay());
		soapModel.setStatus(model.getStatus());

		return soapModel;
	}

	public static GlobalInformationSoap[] toSoapModels(
		GlobalInformation[] models) {
		GlobalInformationSoap[] soapModels = new GlobalInformationSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static GlobalInformationSoap[][] toSoapModels(
		GlobalInformation[][] models) {
		GlobalInformationSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new GlobalInformationSoap[models.length][models[0].length];
		}
		else {
			soapModels = new GlobalInformationSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static GlobalInformationSoap[] toSoapModels(
		List<GlobalInformation> models) {
		List<GlobalInformationSoap> soapModels = new ArrayList<GlobalInformationSoap>(models.size());

		for (GlobalInformation model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new GlobalInformationSoap[soapModels.size()]);
	}

	public GlobalInformationSoap() {
	}

	public long getPrimaryKey() {
		return _globalInformationId;
	}

	public void setPrimaryKey(long pk) {
		setGlobalInformationId(pk);
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

	private long _globalInformationId;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private Date _date;
	private String _message;
	private int _display;
	private int _status;
}