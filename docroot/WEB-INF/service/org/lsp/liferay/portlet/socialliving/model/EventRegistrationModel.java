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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.GroupedModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the EventRegistration service. Represents a row in the &quot;LSPSL_EventRegistration&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link org.lsp.liferay.portlet.socialliving.model.impl.EventRegistrationModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link org.lsp.liferay.portlet.socialliving.model.impl.EventRegistrationImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EventRegistration
 * @see org.lsp.liferay.portlet.socialliving.model.impl.EventRegistrationImpl
 * @see org.lsp.liferay.portlet.socialliving.model.impl.EventRegistrationModelImpl
 * @generated
 */
public interface EventRegistrationModel extends BaseModel<EventRegistration>,
	GroupedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a event registration model instance should use the {@link EventRegistration} interface instead.
	 */

	/**
	 * Returns the primary key of this event registration.
	 *
	 * @return the primary key of this event registration
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this event registration.
	 *
	 * @param primaryKey the primary key of this event registration
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the event registration ID of this event registration.
	 *
	 * @return the event registration ID of this event registration
	 */
	public long getEventRegistrationId();

	/**
	 * Sets the event registration ID of this event registration.
	 *
	 * @param eventRegistrationId the event registration ID of this event registration
	 */
	public void setEventRegistrationId(long eventRegistrationId);

	/**
	 * Returns the company ID of this event registration.
	 *
	 * @return the company ID of this event registration
	 */
	public long getCompanyId();

	/**
	 * Sets the company ID of this event registration.
	 *
	 * @param companyId the company ID of this event registration
	 */
	public void setCompanyId(long companyId);

	/**
	 * Returns the group ID of this event registration.
	 *
	 * @return the group ID of this event registration
	 */
	public long getGroupId();

	/**
	 * Sets the group ID of this event registration.
	 *
	 * @param groupId the group ID of this event registration
	 */
	public void setGroupId(long groupId);

	/**
	 * Returns the user ID of this event registration.
	 *
	 * @return the user ID of this event registration
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this event registration.
	 *
	 * @param userId the user ID of this event registration
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this event registration.
	 *
	 * @return the user uuid of this event registration
	 * @throws SystemException if a system exception occurred
	 */
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this event registration.
	 *
	 * @param userUuid the user uuid of this event registration
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this event registration.
	 *
	 * @return the user name of this event registration
	 */
	@AutoEscape
	public String getUserName();

	/**
	 * Sets the user name of this event registration.
	 *
	 * @param userName the user name of this event registration
	 */
	public void setUserName(String userName);

	/**
	 * Returns the create date of this event registration.
	 *
	 * @return the create date of this event registration
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this event registration.
	 *
	 * @param createDate the create date of this event registration
	 */
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this event registration.
	 *
	 * @return the modified date of this event registration
	 */
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this event registration.
	 *
	 * @param modifiedDate the modified date of this event registration
	 */
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the event entry ID of this event registration.
	 *
	 * @return the event entry ID of this event registration
	 */
	public long getEventEntryId();

	/**
	 * Sets the event entry ID of this event registration.
	 *
	 * @param eventEntryId the event entry ID of this event registration
	 */
	public void setEventEntryId(long eventEntryId);

	/**
	 * Returns the status of this event registration.
	 *
	 * @return the status of this event registration
	 */
	public int getStatus();

	/**
	 * Sets the status of this event registration.
	 *
	 * @param status the status of this event registration
	 */
	public void setStatus(int status);

	/**
	 * Returns the comments of this event registration.
	 *
	 * @return the comments of this event registration
	 */
	@AutoEscape
	public String getComments();

	/**
	 * Sets the comments of this event registration.
	 *
	 * @param comments the comments of this event registration
	 */
	public void setComments(String comments);

	public boolean isNew();

	public void setNew(boolean n);

	public boolean isCachedModel();

	public void setCachedModel(boolean cachedModel);

	public boolean isEscapedModel();

	public Serializable getPrimaryKeyObj();

	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	public ExpandoBridge getExpandoBridge();

	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	public Object clone();

	public int compareTo(EventRegistration eventRegistration);

	public int hashCode();

	public CacheModel<EventRegistration> toCacheModel();

	public EventRegistration toEscapedModel();

	public String toString();

	public String toXmlString();
}