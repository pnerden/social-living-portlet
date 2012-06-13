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

package org.lsp.liferay.portlet.socialliving.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * The utility for the channel entry local service. This utility wraps {@link org.lsp.liferay.portlet.socialliving.service.impl.ChannelEntryLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ChannelEntryLocalService
 * @see org.lsp.liferay.portlet.socialliving.service.base.ChannelEntryLocalServiceBaseImpl
 * @see org.lsp.liferay.portlet.socialliving.service.impl.ChannelEntryLocalServiceImpl
 * @generated
 */
public class ChannelEntryLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link org.lsp.liferay.portlet.socialliving.service.impl.ChannelEntryLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the channel entry to the database. Also notifies the appropriate model listeners.
	*
	* @param channelEntry the channel entry
	* @return the channel entry that was added
	* @throws SystemException if a system exception occurred
	*/
	public static org.lsp.liferay.portlet.socialliving.model.ChannelEntry addChannelEntry(
		org.lsp.liferay.portlet.socialliving.model.ChannelEntry channelEntry)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addChannelEntry(channelEntry);
	}

	/**
	* Creates a new channel entry with the primary key. Does not add the channel entry to the database.
	*
	* @param channelEntryId the primary key for the new channel entry
	* @return the new channel entry
	*/
	public static org.lsp.liferay.portlet.socialliving.model.ChannelEntry createChannelEntry(
		long channelEntryId) {
		return getService().createChannelEntry(channelEntryId);
	}

	/**
	* Deletes the channel entry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param channelEntryId the primary key of the channel entry
	* @return the channel entry that was removed
	* @throws PortalException if a channel entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.lsp.liferay.portlet.socialliving.model.ChannelEntry deleteChannelEntry(
		long channelEntryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteChannelEntry(channelEntryId);
	}

	/**
	* Deletes the channel entry from the database. Also notifies the appropriate model listeners.
	*
	* @param channelEntry the channel entry
	* @return the channel entry that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static org.lsp.liferay.portlet.socialliving.model.ChannelEntry deleteChannelEntry(
		org.lsp.liferay.portlet.socialliving.model.ChannelEntry channelEntry)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteChannelEntry(channelEntry);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	public static org.lsp.liferay.portlet.socialliving.model.ChannelEntry fetchChannelEntry(
		long channelEntryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchChannelEntry(channelEntryId);
	}

	/**
	* Returns the channel entry with the primary key.
	*
	* @param channelEntryId the primary key of the channel entry
	* @return the channel entry
	* @throws PortalException if a channel entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.lsp.liferay.portlet.socialliving.model.ChannelEntry getChannelEntry(
		long channelEntryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getChannelEntry(channelEntryId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the channel entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of channel entries
	* @param end the upper bound of the range of channel entries (not inclusive)
	* @return the range of channel entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.lsp.liferay.portlet.socialliving.model.ChannelEntry> getChannelEntries(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getChannelEntries(start, end);
	}

	/**
	* Returns the number of channel entries.
	*
	* @return the number of channel entries
	* @throws SystemException if a system exception occurred
	*/
	public static int getChannelEntriesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getChannelEntriesCount();
	}

	/**
	* Updates the channel entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param channelEntry the channel entry
	* @return the channel entry that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static org.lsp.liferay.portlet.socialliving.model.ChannelEntry updateChannelEntry(
		org.lsp.liferay.portlet.socialliving.model.ChannelEntry channelEntry)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateChannelEntry(channelEntry);
	}

	/**
	* Updates the channel entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param channelEntry the channel entry
	* @param merge whether to merge the channel entry with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the channel entry that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static org.lsp.liferay.portlet.socialliving.model.ChannelEntry updateChannelEntry(
		org.lsp.liferay.portlet.socialliving.model.ChannelEntry channelEntry,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateChannelEntry(channelEntry, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static void clearService() {
		_service = null;
	}

	public static ChannelEntryLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					ChannelEntryLocalService.class.getName());

			if (invokableLocalService instanceof ChannelEntryLocalService) {
				_service = (ChannelEntryLocalService)invokableLocalService;
			}
			else {
				_service = new ChannelEntryLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(ChannelEntryLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated
	 */
	public void setService(ChannelEntryLocalService service) {
	}

	private static ChannelEntryLocalService _service;
}