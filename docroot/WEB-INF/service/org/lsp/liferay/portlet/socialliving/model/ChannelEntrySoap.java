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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author    Brian Wing Shun Chan
 * @generated
 */
public class ChannelEntrySoap implements Serializable {
	public static ChannelEntrySoap toSoapModel(ChannelEntry model) {
		ChannelEntrySoap soapModel = new ChannelEntrySoap();

		soapModel.setChannelEntryId(model.getChannelEntryId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setComments(model.getComments());

		return soapModel;
	}

	public static ChannelEntrySoap[] toSoapModels(ChannelEntry[] models) {
		ChannelEntrySoap[] soapModels = new ChannelEntrySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ChannelEntrySoap[][] toSoapModels(ChannelEntry[][] models) {
		ChannelEntrySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ChannelEntrySoap[models.length][models[0].length];
		}
		else {
			soapModels = new ChannelEntrySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ChannelEntrySoap[] toSoapModels(List<ChannelEntry> models) {
		List<ChannelEntrySoap> soapModels = new ArrayList<ChannelEntrySoap>(models.size());

		for (ChannelEntry model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ChannelEntrySoap[soapModels.size()]);
	}

	public ChannelEntrySoap() {
	}

	public long getPrimaryKey() {
		return _channelEntryId;
	}

	public void setPrimaryKey(long pk) {
		setChannelEntryId(pk);
	}

	public long getChannelEntryId() {
		return _channelEntryId;
	}

	public void setChannelEntryId(long channelEntryId) {
		_channelEntryId = channelEntryId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
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

	public String getComments() {
		return _comments;
	}

	public void setComments(String comments) {
		_comments = comments;
	}

	private long _channelEntryId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _comments;
}