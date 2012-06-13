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

import org.lsp.liferay.portlet.socialliving.service.EventEntryLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Brian Wing Shun Chan
 */
public class EventEntryClp extends BaseModelImpl<EventEntry>
	implements EventEntry {
	public EventEntryClp() {
	}

	public Class<?> getModelClass() {
		return EventEntry.class;
	}

	public String getModelClassName() {
		return EventEntry.class.getName();
	}

	public long getPrimaryKey() {
		return _eventEntryId;
	}

	public void setPrimaryKey(long primaryKey) {
		setEventEntryId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_eventEntryId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("eventEntryId", getEventEntryId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("title", getTitle());
		attributes.put("description", getDescription());
		attributes.put("startDate", getStartDate());
		attributes.put("endDate", getEndDate());
		attributes.put("totalAttendees", getTotalAttendees());
		attributes.put("maxAttendees", getMaxAttendees());
		attributes.put("price", getPrice());
		attributes.put("thumbnailId", getThumbnailId());
		attributes.put("latitude", getLatitude());
		attributes.put("longitude", getLongitude());
		attributes.put("location", getLocation());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		Long eventEntryId = (Long)attributes.get("eventEntryId");

		if (eventEntryId != null) {
			setEventEntryId(eventEntryId);
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

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		Date startDate = (Date)attributes.get("startDate");

		if (startDate != null) {
			setStartDate(startDate);
		}

		Date endDate = (Date)attributes.get("endDate");

		if (endDate != null) {
			setEndDate(endDate);
		}

		Integer totalAttendees = (Integer)attributes.get("totalAttendees");

		if (totalAttendees != null) {
			setTotalAttendees(totalAttendees);
		}

		Integer maxAttendees = (Integer)attributes.get("maxAttendees");

		if (maxAttendees != null) {
			setMaxAttendees(maxAttendees);
		}

		Double price = (Double)attributes.get("price");

		if (price != null) {
			setPrice(price);
		}

		Long thumbnailId = (Long)attributes.get("thumbnailId");

		if (thumbnailId != null) {
			setThumbnailId(thumbnailId);
		}

		String latitude = (String)attributes.get("latitude");

		if (latitude != null) {
			setLatitude(latitude);
		}

		String longitude = (String)attributes.get("longitude");

		if (longitude != null) {
			setLongitude(longitude);
		}

		String location = (String)attributes.get("location");

		if (location != null) {
			setLocation(location);
		}
	}

	public long getEventEntryId() {
		return _eventEntryId;
	}

	public void setEventEntryId(long eventEntryId) {
		_eventEntryId = eventEntryId;
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

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		_title = title;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public Date getStartDate() {
		return _startDate;
	}

	public void setStartDate(Date startDate) {
		_startDate = startDate;
	}

	public Date getEndDate() {
		return _endDate;
	}

	public void setEndDate(Date endDate) {
		_endDate = endDate;
	}

	public int getTotalAttendees() {
		return _totalAttendees;
	}

	public void setTotalAttendees(int totalAttendees) {
		_totalAttendees = totalAttendees;
	}

	public int getMaxAttendees() {
		return _maxAttendees;
	}

	public void setMaxAttendees(int maxAttendees) {
		_maxAttendees = maxAttendees;
	}

	public double getPrice() {
		return _price;
	}

	public void setPrice(double price) {
		_price = price;
	}

	public long getThumbnailId() {
		return _thumbnailId;
	}

	public void setThumbnailId(long thumbnailId) {
		_thumbnailId = thumbnailId;
	}

	public String getLatitude() {
		return _latitude;
	}

	public void setLatitude(String latitude) {
		_latitude = latitude;
	}

	public String getLongitude() {
		return _longitude;
	}

	public void setLongitude(String longitude) {
		_longitude = longitude;
	}

	public String getLocation() {
		return _location;
	}

	public void setLocation(String location) {
		_location = location;
	}

	public BaseModel<?> getEventEntryRemoteModel() {
		return _eventEntryRemoteModel;
	}

	public void setEventEntryRemoteModel(BaseModel<?> eventEntryRemoteModel) {
		_eventEntryRemoteModel = eventEntryRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			EventEntryLocalServiceUtil.addEventEntry(this);
		}
		else {
			EventEntryLocalServiceUtil.updateEventEntry(this);
		}
	}

	@Override
	public EventEntry toEscapedModel() {
		return (EventEntry)Proxy.newProxyInstance(EventEntry.class.getClassLoader(),
			new Class[] { EventEntry.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		EventEntryClp clone = new EventEntryClp();

		clone.setEventEntryId(getEventEntryId());
		clone.setCompanyId(getCompanyId());
		clone.setGroupId(getGroupId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setTitle(getTitle());
		clone.setDescription(getDescription());
		clone.setStartDate(getStartDate());
		clone.setEndDate(getEndDate());
		clone.setTotalAttendees(getTotalAttendees());
		clone.setMaxAttendees(getMaxAttendees());
		clone.setPrice(getPrice());
		clone.setThumbnailId(getThumbnailId());
		clone.setLatitude(getLatitude());
		clone.setLongitude(getLongitude());
		clone.setLocation(getLocation());

		return clone;
	}

	public int compareTo(EventEntry eventEntry) {
		int value = 0;

		value = DateUtil.compareTo(getStartDate(), eventEntry.getStartDate());

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

		EventEntryClp eventEntry = null;

		try {
			eventEntry = (EventEntryClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = eventEntry.getPrimaryKey();

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
		StringBundler sb = new StringBundler(37);

		sb.append("{eventEntryId=");
		sb.append(getEventEntryId());
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
		sb.append(", title=");
		sb.append(getTitle());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", startDate=");
		sb.append(getStartDate());
		sb.append(", endDate=");
		sb.append(getEndDate());
		sb.append(", totalAttendees=");
		sb.append(getTotalAttendees());
		sb.append(", maxAttendees=");
		sb.append(getMaxAttendees());
		sb.append(", price=");
		sb.append(getPrice());
		sb.append(", thumbnailId=");
		sb.append(getThumbnailId());
		sb.append(", latitude=");
		sb.append(getLatitude());
		sb.append(", longitude=");
		sb.append(getLongitude());
		sb.append(", location=");
		sb.append(getLocation());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(58);

		sb.append("<model><model-name>");
		sb.append("org.lsp.liferay.portlet.socialliving.model.EventEntry");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>eventEntryId</column-name><column-value><![CDATA[");
		sb.append(getEventEntryId());
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
			"<column><column-name>title</column-name><column-value><![CDATA[");
		sb.append(getTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>startDate</column-name><column-value><![CDATA[");
		sb.append(getStartDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>endDate</column-name><column-value><![CDATA[");
		sb.append(getEndDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>totalAttendees</column-name><column-value><![CDATA[");
		sb.append(getTotalAttendees());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>maxAttendees</column-name><column-value><![CDATA[");
		sb.append(getMaxAttendees());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>price</column-name><column-value><![CDATA[");
		sb.append(getPrice());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>thumbnailId</column-name><column-value><![CDATA[");
		sb.append(getThumbnailId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>latitude</column-name><column-value><![CDATA[");
		sb.append(getLatitude());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>longitude</column-name><column-value><![CDATA[");
		sb.append(getLongitude());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>location</column-name><column-value><![CDATA[");
		sb.append(getLocation());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _eventEntryId;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _title;
	private String _description;
	private Date _startDate;
	private Date _endDate;
	private int _totalAttendees;
	private int _maxAttendees;
	private double _price;
	private long _thumbnailId;
	private String _latitude;
	private String _longitude;
	private String _location;
	private BaseModel<?> _eventEntryRemoteModel;
}