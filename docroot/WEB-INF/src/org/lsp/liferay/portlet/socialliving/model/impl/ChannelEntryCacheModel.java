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

package org.lsp.liferay.portlet.socialliving.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import org.lsp.liferay.portlet.socialliving.model.ChannelEntry;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing ChannelEntry in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see ChannelEntry
 * @generated
 */
public class ChannelEntryCacheModel implements CacheModel<ChannelEntry>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{channelEntryId=");
		sb.append(channelEntryId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", comments=");
		sb.append(comments);
		sb.append("}");

		return sb.toString();
	}

	public ChannelEntry toEntityModel() {
		ChannelEntryImpl channelEntryImpl = new ChannelEntryImpl();

		channelEntryImpl.setChannelEntryId(channelEntryId);
		channelEntryImpl.setGroupId(groupId);
		channelEntryImpl.setCompanyId(companyId);
		channelEntryImpl.setUserId(userId);

		if (userName == null) {
			channelEntryImpl.setUserName(StringPool.BLANK);
		}
		else {
			channelEntryImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			channelEntryImpl.setCreateDate(null);
		}
		else {
			channelEntryImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			channelEntryImpl.setModifiedDate(null);
		}
		else {
			channelEntryImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (comments == null) {
			channelEntryImpl.setComments(StringPool.BLANK);
		}
		else {
			channelEntryImpl.setComments(comments);
		}

		channelEntryImpl.resetOriginalValues();

		return channelEntryImpl;
	}

	public long channelEntryId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String comments;
}