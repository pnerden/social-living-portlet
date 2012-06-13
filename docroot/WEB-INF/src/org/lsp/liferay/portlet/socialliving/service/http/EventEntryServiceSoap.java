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

package org.lsp.liferay.portlet.socialliving.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import org.lsp.liferay.portlet.socialliving.service.EventEntryServiceUtil;

import java.rmi.RemoteException;

/**
 * <p>
 * This class provides a SOAP utility for the
 * {@link org.lsp.liferay.portlet.socialliving.service.EventEntryServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 * </p>
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link org.lsp.liferay.portlet.socialliving.model.EventEntrySoap}.
 * If the method in the service utility returns a
 * {@link org.lsp.liferay.portlet.socialliving.model.EventEntry}, that is translated to a
 * {@link org.lsp.liferay.portlet.socialliving.model.EventEntrySoap}. Methods that SOAP cannot
 * safely wire are skipped.
 * </p>
 *
 * <p>
 * The benefits of using the SOAP utility is that it is cross platform
 * compatible. SOAP allows different languages like Java, .NET, C++, PHP, and
 * even Perl, to call the generated services. One drawback of SOAP is that it is
 * slow because it needs to serialize all calls into a text format (XML).
 * </p>
 *
 * <p>
 * You can see a list of services at
 * http://localhost:8080/api/secure/axis. Set the property
 * <b>axis.servlet.hosts.allowed</b> in portal.properties to configure
 * security.
 * </p>
 *
 * <p>
 * The SOAP utility is only generated for remote services.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       EventEntryServiceHttp
 * @see       org.lsp.liferay.portlet.socialliving.model.EventEntrySoap
 * @see       org.lsp.liferay.portlet.socialliving.service.EventEntryServiceUtil
 * @generated
 */
public class EventEntryServiceSoap {
	public static org.lsp.liferay.portlet.socialliving.model.EventEntrySoap addEventEntry(
		long groupId, long userId, java.lang.String title,
		java.lang.String description, int startDateMonth, int startDateDay,
		int startDateYear, int startDateHour, int startDateMinute,
		int endDateMonth, int endDateDay, int endDateYear, int endDateHour,
		int endDateMinute, int totalAttendees, int maxAttendees, double price,
		byte[] thumbnail, int visibility, java.lang.String latitude,
		java.lang.String longitude, java.lang.String location)
		throws RemoteException {
		try {
			org.lsp.liferay.portlet.socialliving.model.EventEntry returnValue = EventEntryServiceUtil.addEventEntry(groupId,
					userId, title, description, startDateMonth, startDateDay,
					startDateYear, startDateHour, startDateMinute,
					endDateMonth, endDateDay, endDateYear, endDateHour,
					endDateMinute, totalAttendees, maxAttendees, price,
					thumbnail, visibility, latitude, longitude, location);

			return org.lsp.liferay.portlet.socialliving.model.EventEntrySoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static org.lsp.liferay.portlet.socialliving.model.EventEntrySoap deleteEventEntry(
		long companyId, long eventEntryId) throws RemoteException {
		try {
			org.lsp.liferay.portlet.socialliving.model.EventEntry returnValue = EventEntryServiceUtil.deleteEventEntry(companyId,
					eventEntryId);

			return org.lsp.liferay.portlet.socialliving.model.EventEntrySoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static org.lsp.liferay.portlet.socialliving.model.EventEntrySoap getEventEntry(
		long companyId, long eventEntryId) throws RemoteException {
		try {
			org.lsp.liferay.portlet.socialliving.model.EventEntry returnValue = EventEntryServiceUtil.getEventEntry(companyId,
					eventEntryId);

			return org.lsp.liferay.portlet.socialliving.model.EventEntrySoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static int getVisibility(
		org.lsp.liferay.portlet.socialliving.model.EventEntrySoap eventEntry)
		throws RemoteException {
		try {
			int returnValue = EventEntryServiceUtil.getVisibility(org.lsp.liferay.portlet.socialliving.model.impl.EventEntryModelImpl.toModel(
						eventEntry));

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static org.lsp.liferay.portlet.socialliving.model.EventEntrySoap updateEventEntry(
		long userId, long eventEntryId, java.lang.String title,
		java.lang.String description, int startDateMonth, int startDateDay,
		int startDateYear, int startDateHour, int startDateMinute,
		int endDateMonth, int endDateDay, int endDateYear, int endDateHour,
		int endDateMinute, int totalAttendees, int maxAttendees, double price,
		byte[] thumbnail, int visibility, java.lang.String latitude,
		java.lang.String longitude, java.lang.String location)
		throws RemoteException {
		try {
			org.lsp.liferay.portlet.socialliving.model.EventEntry returnValue = EventEntryServiceUtil.updateEventEntry(userId,
					eventEntryId, title, description, startDateMonth,
					startDateDay, startDateYear, startDateHour,
					startDateMinute, endDateMonth, endDateDay, endDateYear,
					endDateHour, endDateMinute, totalAttendees, maxAttendees,
					price, thumbnail, visibility, latitude, longitude, location);

			return org.lsp.liferay.portlet.socialliving.model.EventEntrySoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(EventEntryServiceSoap.class);
}