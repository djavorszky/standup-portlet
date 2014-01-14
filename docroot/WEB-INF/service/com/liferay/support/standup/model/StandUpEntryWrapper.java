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

import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link StandUpEntry}.
 * </p>
 *
 * @author    Daniel Javorszky
 * @see       StandUpEntry
 * @generated
 */
public class StandUpEntryWrapper implements StandUpEntry,
	ModelWrapper<StandUpEntry> {
	public StandUpEntryWrapper(StandUpEntry standUpEntry) {
		_standUpEntry = standUpEntry;
	}

	public Class<?> getModelClass() {
		return StandUpEntry.class;
	}

	public String getModelClassName() {
		return StandUpEntry.class.getName();
	}

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

	/**
	* Returns the primary key of this stand up entry.
	*
	* @return the primary key of this stand up entry
	*/
	public long getPrimaryKey() {
		return _standUpEntry.getPrimaryKey();
	}

	/**
	* Sets the primary key of this stand up entry.
	*
	* @param primaryKey the primary key of this stand up entry
	*/
	public void setPrimaryKey(long primaryKey) {
		_standUpEntry.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the entry ID of this stand up entry.
	*
	* @return the entry ID of this stand up entry
	*/
	public long getEntryId() {
		return _standUpEntry.getEntryId();
	}

	/**
	* Sets the entry ID of this stand up entry.
	*
	* @param entryId the entry ID of this stand up entry
	*/
	public void setEntryId(long entryId) {
		_standUpEntry.setEntryId(entryId);
	}

	/**
	* Returns the company ID of this stand up entry.
	*
	* @return the company ID of this stand up entry
	*/
	public long getCompanyId() {
		return _standUpEntry.getCompanyId();
	}

	/**
	* Sets the company ID of this stand up entry.
	*
	* @param companyId the company ID of this stand up entry
	*/
	public void setCompanyId(long companyId) {
		_standUpEntry.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this stand up entry.
	*
	* @return the group ID of this stand up entry
	*/
	public long getGroupId() {
		return _standUpEntry.getGroupId();
	}

	/**
	* Sets the group ID of this stand up entry.
	*
	* @param groupId the group ID of this stand up entry
	*/
	public void setGroupId(long groupId) {
		_standUpEntry.setGroupId(groupId);
	}

	/**
	* Returns the user ID of this stand up entry.
	*
	* @return the user ID of this stand up entry
	*/
	public long getUserId() {
		return _standUpEntry.getUserId();
	}

	/**
	* Sets the user ID of this stand up entry.
	*
	* @param userId the user ID of this stand up entry
	*/
	public void setUserId(long userId) {
		_standUpEntry.setUserId(userId);
	}

	/**
	* Returns the user uuid of this stand up entry.
	*
	* @return the user uuid of this stand up entry
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _standUpEntry.getUserUuid();
	}

	/**
	* Sets the user uuid of this stand up entry.
	*
	* @param userUuid the user uuid of this stand up entry
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_standUpEntry.setUserUuid(userUuid);
	}

	/**
	* Returns the quantity of this stand up entry.
	*
	* @return the quantity of this stand up entry
	*/
	public int getQuantity() {
		return _standUpEntry.getQuantity();
	}

	/**
	* Sets the quantity of this stand up entry.
	*
	* @param quantity the quantity of this stand up entry
	*/
	public void setQuantity(int quantity) {
		_standUpEntry.setQuantity(quantity);
	}

	/**
	* Returns the difficulty of this stand up entry.
	*
	* @return the difficulty of this stand up entry
	*/
	public int getDifficulty() {
		return _standUpEntry.getDifficulty();
	}

	/**
	* Sets the difficulty of this stand up entry.
	*
	* @param difficulty the difficulty of this stand up entry
	*/
	public void setDifficulty(int difficulty) {
		_standUpEntry.setDifficulty(difficulty);
	}

	/**
	* Returns the create date of this stand up entry.
	*
	* @return the create date of this stand up entry
	*/
	public java.util.Date getCreateDate() {
		return _standUpEntry.getCreateDate();
	}

	/**
	* Sets the create date of this stand up entry.
	*
	* @param createDate the create date of this stand up entry
	*/
	public void setCreateDate(java.util.Date createDate) {
		_standUpEntry.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this stand up entry.
	*
	* @return the modified date of this stand up entry
	*/
	public java.util.Date getModifiedDate() {
		return _standUpEntry.getModifiedDate();
	}

	/**
	* Sets the modified date of this stand up entry.
	*
	* @param modifiedDate the modified date of this stand up entry
	*/
	public void setModifiedDate(java.util.Date modifiedDate) {
		_standUpEntry.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the blocking of this stand up entry.
	*
	* @return the blocking of this stand up entry
	*/
	public java.lang.String getBlocking() {
		return _standUpEntry.getBlocking();
	}

	/**
	* Sets the blocking of this stand up entry.
	*
	* @param blocking the blocking of this stand up entry
	*/
	public void setBlocking(java.lang.String blocking) {
		_standUpEntry.setBlocking(blocking);
	}

	/**
	* Returns the additional details of this stand up entry.
	*
	* @return the additional details of this stand up entry
	*/
	public java.lang.String getAdditionalDetails() {
		return _standUpEntry.getAdditionalDetails();
	}

	/**
	* Sets the additional details of this stand up entry.
	*
	* @param additionalDetails the additional details of this stand up entry
	*/
	public void setAdditionalDetails(java.lang.String additionalDetails) {
		_standUpEntry.setAdditionalDetails(additionalDetails);
	}

	/**
	* Returns the status of this stand up entry.
	*
	* @return the status of this stand up entry
	*/
	public int getStatus() {
		return _standUpEntry.getStatus();
	}

	/**
	* Sets the status of this stand up entry.
	*
	* @param status the status of this stand up entry
	*/
	public void setStatus(int status) {
		_standUpEntry.setStatus(status);
	}

	public boolean isNew() {
		return _standUpEntry.isNew();
	}

	public void setNew(boolean n) {
		_standUpEntry.setNew(n);
	}

	public boolean isCachedModel() {
		return _standUpEntry.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_standUpEntry.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _standUpEntry.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _standUpEntry.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_standUpEntry.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _standUpEntry.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_standUpEntry.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new StandUpEntryWrapper((StandUpEntry)_standUpEntry.clone());
	}

	public int compareTo(StandUpEntry standUpEntry) {
		return _standUpEntry.compareTo(standUpEntry);
	}

	@Override
	public int hashCode() {
		return _standUpEntry.hashCode();
	}

	public com.liferay.portal.model.CacheModel<StandUpEntry> toCacheModel() {
		return _standUpEntry.toCacheModel();
	}

	public StandUpEntry toEscapedModel() {
		return new StandUpEntryWrapper(_standUpEntry.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _standUpEntry.toString();
	}

	public java.lang.String toXmlString() {
		return _standUpEntry.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_standUpEntry.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public StandUpEntry getWrappedStandUpEntry() {
		return _standUpEntry;
	}

	public StandUpEntry getWrappedModel() {
		return _standUpEntry;
	}

	public void resetOriginalValues() {
		_standUpEntry.resetOriginalValues();
	}

	private StandUpEntry _standUpEntry;
}