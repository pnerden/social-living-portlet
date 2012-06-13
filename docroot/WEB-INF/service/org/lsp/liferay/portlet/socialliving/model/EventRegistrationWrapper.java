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

package org.lsp.liferay.portlet.socialliving.model;

import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link EventRegistration}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       EventRegistration
 * @generated
 */
public class EventRegistrationWrapper implements EventRegistration,
	ModelWrapper<EventRegistration> {
	public EventRegistrationWrapper(EventRegistration eventRegistration) {
		_eventRegistration = eventRegistration;
	}

	public Class<?> getModelClass() {
		return EventRegistration.class;
	}

	public String getModelClassName() {
		return EventRegistration.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("eventRegistrationId", getEventRegistrationId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("eventEntryId", getEventEntryId());
		attributes.put("status", getStatus());
		attributes.put("comments", getComments());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		Long eventRegistrationId = (Long)attributes.get("eventRegistrationId");

		if (eventRegistrationId != null) {
			setEventRegistrationId(eventRegistrationId);
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

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long eventEntryId = (Long)attributes.get("eventEntryId");

		if (eventEntryId != null) {
			setEventEntryId(eventEntryId);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		String comments = (String)attributes.get("comments");

		if (comments != null) {
			setComments(comments);
		}
	}

	/**
	* Returns the primary key of this event registration.
	*
	* @return the primary key of this event registration
	*/
	public long getPrimaryKey() {
		return _eventRegistration.getPrimaryKey();
	}

	/**
	* Sets the primary key of this event registration.
	*
	* @param primaryKey the primary key of this event registration
	*/
	public void setPrimaryKey(long primaryKey) {
		_eventRegistration.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the event registration ID of this event registration.
	*
	* @return the event registration ID of this event registration
	*/
	public long getEventRegistrationId() {
		return _eventRegistration.getEventRegistrationId();
	}

	/**
	* Sets the event registration ID of this event registration.
	*
	* @param eventRegistrationId the event registration ID of this event registration
	*/
	public void setEventRegistrationId(long eventRegistrationId) {
		_eventRegistration.setEventRegistrationId(eventRegistrationId);
	}

	/**
	* Returns the company ID of this event registration.
	*
	* @return the company ID of this event registration
	*/
	public long getCompanyId() {
		return _eventRegistration.getCompanyId();
	}

	/**
	* Sets the company ID of this event registration.
	*
	* @param companyId the company ID of this event registration
	*/
	public void setCompanyId(long companyId) {
		_eventRegistration.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this event registration.
	*
	* @return the group ID of this event registration
	*/
	public long getGroupId() {
		return _eventRegistration.getGroupId();
	}

	/**
	* Sets the group ID of this event registration.
	*
	* @param groupId the group ID of this event registration
	*/
	public void setGroupId(long groupId) {
		_eventRegistration.setGroupId(groupId);
	}

	/**
	* Returns the user ID of this event registration.
	*
	* @return the user ID of this event registration
	*/
	public long getUserId() {
		return _eventRegistration.getUserId();
	}

	/**
	* Sets the user ID of this event registration.
	*
	* @param userId the user ID of this event registration
	*/
	public void setUserId(long userId) {
		_eventRegistration.setUserId(userId);
	}

	/**
	* Returns the user uuid of this event registration.
	*
	* @return the user uuid of this event registration
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _eventRegistration.getUserUuid();
	}

	/**
	* Sets the user uuid of this event registration.
	*
	* @param userUuid the user uuid of this event registration
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_eventRegistration.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this event registration.
	*
	* @return the user name of this event registration
	*/
	public java.lang.String getUserName() {
		return _eventRegistration.getUserName();
	}

	/**
	* Sets the user name of this event registration.
	*
	* @param userName the user name of this event registration
	*/
	public void setUserName(java.lang.String userName) {
		_eventRegistration.setUserName(userName);
	}

	/**
	* Returns the create date of this event registration.
	*
	* @return the create date of this event registration
	*/
	public java.util.Date getCreateDate() {
		return _eventRegistration.getCreateDate();
	}

	/**
	* Sets the create date of this event registration.
	*
	* @param createDate the create date of this event registration
	*/
	public void setCreateDate(java.util.Date createDate) {
		_eventRegistration.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this event registration.
	*
	* @return the modified date of this event registration
	*/
	public java.util.Date getModifiedDate() {
		return _eventRegistration.getModifiedDate();
	}

	/**
	* Sets the modified date of this event registration.
	*
	* @param modifiedDate the modified date of this event registration
	*/
	public void setModifiedDate(java.util.Date modifiedDate) {
		_eventRegistration.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the event entry ID of this event registration.
	*
	* @return the event entry ID of this event registration
	*/
	public long getEventEntryId() {
		return _eventRegistration.getEventEntryId();
	}

	/**
	* Sets the event entry ID of this event registration.
	*
	* @param eventEntryId the event entry ID of this event registration
	*/
	public void setEventEntryId(long eventEntryId) {
		_eventRegistration.setEventEntryId(eventEntryId);
	}

	/**
	* Returns the status of this event registration.
	*
	* @return the status of this event registration
	*/
	public int getStatus() {
		return _eventRegistration.getStatus();
	}

	/**
	* Sets the status of this event registration.
	*
	* @param status the status of this event registration
	*/
	public void setStatus(int status) {
		_eventRegistration.setStatus(status);
	}

	/**
	* Returns the comments of this event registration.
	*
	* @return the comments of this event registration
	*/
	public java.lang.String getComments() {
		return _eventRegistration.getComments();
	}

	/**
	* Sets the comments of this event registration.
	*
	* @param comments the comments of this event registration
	*/
	public void setComments(java.lang.String comments) {
		_eventRegistration.setComments(comments);
	}

	public boolean isNew() {
		return _eventRegistration.isNew();
	}

	public void setNew(boolean n) {
		_eventRegistration.setNew(n);
	}

	public boolean isCachedModel() {
		return _eventRegistration.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_eventRegistration.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _eventRegistration.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _eventRegistration.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_eventRegistration.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _eventRegistration.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_eventRegistration.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new EventRegistrationWrapper((EventRegistration)_eventRegistration.clone());
	}

	public int compareTo(
		org.lsp.liferay.portlet.socialliving.model.EventRegistration eventRegistration) {
		return _eventRegistration.compareTo(eventRegistration);
	}

	@Override
	public int hashCode() {
		return _eventRegistration.hashCode();
	}

	public com.liferay.portal.model.CacheModel<org.lsp.liferay.portlet.socialliving.model.EventRegistration> toCacheModel() {
		return _eventRegistration.toCacheModel();
	}

	public org.lsp.liferay.portlet.socialliving.model.EventRegistration toEscapedModel() {
		return new EventRegistrationWrapper(_eventRegistration.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _eventRegistration.toString();
	}

	public java.lang.String toXmlString() {
		return _eventRegistration.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_eventRegistration.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public EventRegistration getWrappedEventRegistration() {
		return _eventRegistration;
	}

	public EventRegistration getWrappedModel() {
		return _eventRegistration;
	}

	public void resetOriginalValues() {
		_eventRegistration.resetOriginalValues();
	}

	private EventRegistration _eventRegistration;
}