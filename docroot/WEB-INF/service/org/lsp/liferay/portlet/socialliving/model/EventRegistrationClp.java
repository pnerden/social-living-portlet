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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import org.lsp.liferay.portlet.socialliving.service.EventRegistrationLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Brian Wing Shun Chan
 */
public class EventRegistrationClp extends BaseModelImpl<EventRegistration>
	implements EventRegistration {
	public EventRegistrationClp() {
	}

	public Class<?> getModelClass() {
		return EventRegistration.class;
	}

	public String getModelClassName() {
		return EventRegistration.class.getName();
	}

	public long getPrimaryKey() {
		return _eventRegistrationId;
	}

	public void setPrimaryKey(long primaryKey) {
		setEventRegistrationId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_eventRegistrationId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
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

	@Override
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

	public long getEventRegistrationId() {
		return _eventRegistrationId;
	}

	public void setEventRegistrationId(long eventRegistrationId) {
		_eventRegistrationId = eventRegistrationId;
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

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
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

	public long getEventEntryId() {
		return _eventEntryId;
	}

	public void setEventEntryId(long eventEntryId) {
		_eventEntryId = eventEntryId;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	public String getComments() {
		return _comments;
	}

	public void setComments(String comments) {
		_comments = comments;
	}

	public BaseModel<?> getEventRegistrationRemoteModel() {
		return _eventRegistrationRemoteModel;
	}

	public void setEventRegistrationRemoteModel(
		BaseModel<?> eventRegistrationRemoteModel) {
		_eventRegistrationRemoteModel = eventRegistrationRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			EventRegistrationLocalServiceUtil.addEventRegistration(this);
		}
		else {
			EventRegistrationLocalServiceUtil.updateEventRegistration(this);
		}
	}

	@Override
	public EventRegistration toEscapedModel() {
		return (EventRegistration)Proxy.newProxyInstance(EventRegistration.class.getClassLoader(),
			new Class[] { EventRegistration.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		EventRegistrationClp clone = new EventRegistrationClp();

		clone.setEventRegistrationId(getEventRegistrationId());
		clone.setCompanyId(getCompanyId());
		clone.setGroupId(getGroupId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setEventEntryId(getEventEntryId());
		clone.setStatus(getStatus());
		clone.setComments(getComments());

		return clone;
	}

	public int compareTo(EventRegistration eventRegistration) {
		int value = 0;

		value = DateUtil.compareTo(getModifiedDate(),
				eventRegistration.getModifiedDate());

		value = value * -1;

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

		EventRegistrationClp eventRegistration = null;

		try {
			eventRegistration = (EventRegistrationClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = eventRegistration.getPrimaryKey();

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
		StringBundler sb = new StringBundler(21);

		sb.append("{eventRegistrationId=");
		sb.append(getEventRegistrationId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", eventEntryId=");
		sb.append(getEventEntryId());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append(", comments=");
		sb.append(getComments());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(34);

		sb.append("<model><model-name>");
		sb.append(
			"org.lsp.liferay.portlet.socialliving.model.EventRegistration");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>eventRegistrationId</column-name><column-value><![CDATA[");
		sb.append(getEventRegistrationId());
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
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
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
			"<column><column-name>eventEntryId</column-name><column-value><![CDATA[");
		sb.append(getEventEntryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>comments</column-name><column-value><![CDATA[");
		sb.append(getComments());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _eventRegistrationId;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _eventEntryId;
	private int _status;
	private String _comments;
	private BaseModel<?> _eventRegistrationRemoteModel;
}