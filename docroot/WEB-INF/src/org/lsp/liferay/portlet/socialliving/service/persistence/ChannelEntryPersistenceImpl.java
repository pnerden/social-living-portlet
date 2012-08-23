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

package org.lsp.liferay.portlet.socialliving.service.persistence;

import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import org.lsp.liferay.portlet.socialliving.NoSuchChannelEntryException;
import org.lsp.liferay.portlet.socialliving.model.ChannelEntry;
import org.lsp.liferay.portlet.socialliving.model.impl.ChannelEntryImpl;
import org.lsp.liferay.portlet.socialliving.model.impl.ChannelEntryModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the channel entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ChannelEntryPersistence
 * @see ChannelEntryUtil
 * @generated
 */
public class ChannelEntryPersistenceImpl extends BasePersistenceImpl<ChannelEntry>
	implements ChannelEntryPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ChannelEntryUtil} to access the channel entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ChannelEntryImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(ChannelEntryModelImpl.ENTITY_CACHE_ENABLED,
			ChannelEntryModelImpl.FINDER_CACHE_ENABLED, ChannelEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
		new FinderPath(ChannelEntryModelImpl.ENTITY_CACHE_ENABLED,
			ChannelEntryModelImpl.FINDER_CACHE_ENABLED, ChannelEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] { Long.class.getName() },
			ChannelEntryModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(ChannelEntryModelImpl.ENTITY_CACHE_ENABLED,
			ChannelEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID = new FinderPath(ChannelEntryModelImpl.ENTITY_CACHE_ENABLED,
			ChannelEntryModelImpl.FINDER_CACHE_ENABLED, ChannelEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUserId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID =
		new FinderPath(ChannelEntryModelImpl.ENTITY_CACHE_ENABLED,
			ChannelEntryModelImpl.FINDER_CACHE_ENABLED, ChannelEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUserId",
			new String[] { Long.class.getName() },
			ChannelEntryModelImpl.USERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERID = new FinderPath(ChannelEntryModelImpl.ENTITY_CACHE_ENABLED,
			ChannelEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_G_U = new FinderPath(ChannelEntryModelImpl.ENTITY_CACHE_ENABLED,
			ChannelEntryModelImpl.FINDER_CACHE_ENABLED, ChannelEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_U",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_U = new FinderPath(ChannelEntryModelImpl.ENTITY_CACHE_ENABLED,
			ChannelEntryModelImpl.FINDER_CACHE_ENABLED, ChannelEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_U",
			new String[] { Long.class.getName(), Long.class.getName() },
			ChannelEntryModelImpl.GROUPID_COLUMN_BITMASK |
			ChannelEntryModelImpl.USERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_G_U = new FinderPath(ChannelEntryModelImpl.ENTITY_CACHE_ENABLED,
			ChannelEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_U",
			new String[] { Long.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ChannelEntryModelImpl.ENTITY_CACHE_ENABLED,
			ChannelEntryModelImpl.FINDER_CACHE_ENABLED, ChannelEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ChannelEntryModelImpl.ENTITY_CACHE_ENABLED,
			ChannelEntryModelImpl.FINDER_CACHE_ENABLED, ChannelEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ChannelEntryModelImpl.ENTITY_CACHE_ENABLED,
			ChannelEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the channel entry in the entity cache if it is enabled.
	 *
	 * @param channelEntry the channel entry
	 */
	public void cacheResult(ChannelEntry channelEntry) {
		EntityCacheUtil.putResult(ChannelEntryModelImpl.ENTITY_CACHE_ENABLED,
			ChannelEntryImpl.class, channelEntry.getPrimaryKey(), channelEntry);

		channelEntry.resetOriginalValues();
	}

	/**
	 * Caches the channel entries in the entity cache if it is enabled.
	 *
	 * @param channelEntries the channel entries
	 */
	public void cacheResult(List<ChannelEntry> channelEntries) {
		for (ChannelEntry channelEntry : channelEntries) {
			if (EntityCacheUtil.getResult(
						ChannelEntryModelImpl.ENTITY_CACHE_ENABLED,
						ChannelEntryImpl.class, channelEntry.getPrimaryKey()) == null) {
				cacheResult(channelEntry);
			}
			else {
				channelEntry.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all channel entries.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ChannelEntryImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ChannelEntryImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the channel entry.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ChannelEntry channelEntry) {
		EntityCacheUtil.removeResult(ChannelEntryModelImpl.ENTITY_CACHE_ENABLED,
			ChannelEntryImpl.class, channelEntry.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ChannelEntry> channelEntries) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ChannelEntry channelEntry : channelEntries) {
			EntityCacheUtil.removeResult(ChannelEntryModelImpl.ENTITY_CACHE_ENABLED,
				ChannelEntryImpl.class, channelEntry.getPrimaryKey());
		}
	}

	/**
	 * Creates a new channel entry with the primary key. Does not add the channel entry to the database.
	 *
	 * @param channelEntryId the primary key for the new channel entry
	 * @return the new channel entry
	 */
	public ChannelEntry create(long channelEntryId) {
		ChannelEntry channelEntry = new ChannelEntryImpl();

		channelEntry.setNew(true);
		channelEntry.setPrimaryKey(channelEntryId);

		return channelEntry;
	}

	/**
	 * Removes the channel entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param channelEntryId the primary key of the channel entry
	 * @return the channel entry that was removed
	 * @throws org.lsp.liferay.portlet.socialliving.NoSuchChannelEntryException if a channel entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ChannelEntry remove(long channelEntryId)
		throws NoSuchChannelEntryException, SystemException {
		return remove(Long.valueOf(channelEntryId));
	}

	/**
	 * Removes the channel entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the channel entry
	 * @return the channel entry that was removed
	 * @throws org.lsp.liferay.portlet.socialliving.NoSuchChannelEntryException if a channel entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ChannelEntry remove(Serializable primaryKey)
		throws NoSuchChannelEntryException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ChannelEntry channelEntry = (ChannelEntry)session.get(ChannelEntryImpl.class,
					primaryKey);

			if (channelEntry == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchChannelEntryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(channelEntry);
		}
		catch (NoSuchChannelEntryException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected ChannelEntry removeImpl(ChannelEntry channelEntry)
		throws SystemException {
		channelEntry = toUnwrappedModel(channelEntry);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, channelEntry);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(channelEntry);

		return channelEntry;
	}

	@Override
	public ChannelEntry updateImpl(
		org.lsp.liferay.portlet.socialliving.model.ChannelEntry channelEntry,
		boolean merge) throws SystemException {
		channelEntry = toUnwrappedModel(channelEntry);

		boolean isNew = channelEntry.isNew();

		ChannelEntryModelImpl channelEntryModelImpl = (ChannelEntryModelImpl)channelEntry;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, channelEntry, merge);

			channelEntry.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ChannelEntryModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((channelEntryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(channelEntryModelImpl.getOriginalGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);

				args = new Object[] {
						Long.valueOf(channelEntryModelImpl.getGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);
			}

			if ((channelEntryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(channelEntryModelImpl.getOriginalUserId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);

				args = new Object[] {
						Long.valueOf(channelEntryModelImpl.getUserId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);
			}

			if ((channelEntryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_U.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(channelEntryModelImpl.getOriginalGroupId()),
						Long.valueOf(channelEntryModelImpl.getOriginalUserId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_U, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_U,
					args);

				args = new Object[] {
						Long.valueOf(channelEntryModelImpl.getGroupId()),
						Long.valueOf(channelEntryModelImpl.getUserId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_U, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_U,
					args);
			}
		}

		EntityCacheUtil.putResult(ChannelEntryModelImpl.ENTITY_CACHE_ENABLED,
			ChannelEntryImpl.class, channelEntry.getPrimaryKey(), channelEntry);

		return channelEntry;
	}

	protected ChannelEntry toUnwrappedModel(ChannelEntry channelEntry) {
		if (channelEntry instanceof ChannelEntryImpl) {
			return channelEntry;
		}

		ChannelEntryImpl channelEntryImpl = new ChannelEntryImpl();

		channelEntryImpl.setNew(channelEntry.isNew());
		channelEntryImpl.setPrimaryKey(channelEntry.getPrimaryKey());

		channelEntryImpl.setChannelEntryId(channelEntry.getChannelEntryId());
		channelEntryImpl.setGroupId(channelEntry.getGroupId());
		channelEntryImpl.setCompanyId(channelEntry.getCompanyId());
		channelEntryImpl.setUserId(channelEntry.getUserId());
		channelEntryImpl.setUserName(channelEntry.getUserName());
		channelEntryImpl.setCreateDate(channelEntry.getCreateDate());
		channelEntryImpl.setModifiedDate(channelEntry.getModifiedDate());
		channelEntryImpl.setComments(channelEntry.getComments());

		return channelEntryImpl;
	}

	/**
	 * Returns the channel entry with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the channel entry
	 * @return the channel entry
	 * @throws com.liferay.portal.NoSuchModelException if a channel entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ChannelEntry findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the channel entry with the primary key or throws a {@link org.lsp.liferay.portlet.socialliving.NoSuchChannelEntryException} if it could not be found.
	 *
	 * @param channelEntryId the primary key of the channel entry
	 * @return the channel entry
	 * @throws org.lsp.liferay.portlet.socialliving.NoSuchChannelEntryException if a channel entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ChannelEntry findByPrimaryKey(long channelEntryId)
		throws NoSuchChannelEntryException, SystemException {
		ChannelEntry channelEntry = fetchByPrimaryKey(channelEntryId);

		if (channelEntry == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + channelEntryId);
			}

			throw new NoSuchChannelEntryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				channelEntryId);
		}

		return channelEntry;
	}

	/**
	 * Returns the channel entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the channel entry
	 * @return the channel entry, or <code>null</code> if a channel entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ChannelEntry fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the channel entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param channelEntryId the primary key of the channel entry
	 * @return the channel entry, or <code>null</code> if a channel entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ChannelEntry fetchByPrimaryKey(long channelEntryId)
		throws SystemException {
		ChannelEntry channelEntry = (ChannelEntry)EntityCacheUtil.getResult(ChannelEntryModelImpl.ENTITY_CACHE_ENABLED,
				ChannelEntryImpl.class, channelEntryId);

		if (channelEntry == _nullChannelEntry) {
			return null;
		}

		if (channelEntry == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				channelEntry = (ChannelEntry)session.get(ChannelEntryImpl.class,
						Long.valueOf(channelEntryId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (channelEntry != null) {
					cacheResult(channelEntry);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(ChannelEntryModelImpl.ENTITY_CACHE_ENABLED,
						ChannelEntryImpl.class, channelEntryId,
						_nullChannelEntry);
				}

				closeSession(session);
			}
		}

		return channelEntry;
	}

	/**
	 * Returns all the channel entries where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching channel entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<ChannelEntry> findByGroupId(long groupId)
		throws SystemException {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the channel entries where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of channel entries
	 * @param end the upper bound of the range of channel entries (not inclusive)
	 * @return the range of matching channel entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<ChannelEntry> findByGroupId(long groupId, int start, int end)
		throws SystemException {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the channel entries where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of channel entries
	 * @param end the upper bound of the range of channel entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching channel entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<ChannelEntry> findByGroupId(long groupId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID;
			finderArgs = new Object[] { groupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID;
			finderArgs = new Object[] { groupId, start, end, orderByComparator };
		}

		List<ChannelEntry> list = (List<ChannelEntry>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ChannelEntry channelEntry : list) {
				if ((groupId != channelEntry.getGroupId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_CHANNELENTRY_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(ChannelEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				list = (List<ChannelEntry>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first channel entry in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching channel entry
	 * @throws org.lsp.liferay.portlet.socialliving.NoSuchChannelEntryException if a matching channel entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ChannelEntry findByGroupId_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchChannelEntryException, SystemException {
		ChannelEntry channelEntry = fetchByGroupId_First(groupId,
				orderByComparator);

		if (channelEntry != null) {
			return channelEntry;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchChannelEntryException(msg.toString());
	}

	/**
	 * Returns the first channel entry in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching channel entry, or <code>null</code> if a matching channel entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ChannelEntry fetchByGroupId_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ChannelEntry> list = findByGroupId(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last channel entry in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching channel entry
	 * @throws org.lsp.liferay.portlet.socialliving.NoSuchChannelEntryException if a matching channel entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ChannelEntry findByGroupId_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchChannelEntryException, SystemException {
		ChannelEntry channelEntry = fetchByGroupId_Last(groupId,
				orderByComparator);

		if (channelEntry != null) {
			return channelEntry;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchChannelEntryException(msg.toString());
	}

	/**
	 * Returns the last channel entry in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching channel entry, or <code>null</code> if a matching channel entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ChannelEntry fetchByGroupId_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroupId(groupId);

		List<ChannelEntry> list = findByGroupId(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the channel entries before and after the current channel entry in the ordered set where groupId = &#63;.
	 *
	 * @param channelEntryId the primary key of the current channel entry
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next channel entry
	 * @throws org.lsp.liferay.portlet.socialliving.NoSuchChannelEntryException if a channel entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ChannelEntry[] findByGroupId_PrevAndNext(long channelEntryId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchChannelEntryException, SystemException {
		ChannelEntry channelEntry = findByPrimaryKey(channelEntryId);

		Session session = null;

		try {
			session = openSession();

			ChannelEntry[] array = new ChannelEntryImpl[3];

			array[0] = getByGroupId_PrevAndNext(session, channelEntry, groupId,
					orderByComparator, true);

			array[1] = channelEntry;

			array[2] = getByGroupId_PrevAndNext(session, channelEntry, groupId,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ChannelEntry getByGroupId_PrevAndNext(Session session,
		ChannelEntry channelEntry, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CHANNELENTRY_WHERE);

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		else {
			query.append(ChannelEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(channelEntry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ChannelEntry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the channel entries where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching channel entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<ChannelEntry> findByUserId(long userId)
		throws SystemException {
		return findByUserId(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the channel entries where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of channel entries
	 * @param end the upper bound of the range of channel entries (not inclusive)
	 * @return the range of matching channel entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<ChannelEntry> findByUserId(long userId, int start, int end)
		throws SystemException {
		return findByUserId(userId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the channel entries where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of channel entries
	 * @param end the upper bound of the range of channel entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching channel entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<ChannelEntry> findByUserId(long userId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID;
			finderArgs = new Object[] { userId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID;
			finderArgs = new Object[] { userId, start, end, orderByComparator };
		}

		List<ChannelEntry> list = (List<ChannelEntry>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ChannelEntry channelEntry : list) {
				if ((userId != channelEntry.getUserId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_CHANNELENTRY_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(ChannelEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				list = (List<ChannelEntry>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first channel entry in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching channel entry
	 * @throws org.lsp.liferay.portlet.socialliving.NoSuchChannelEntryException if a matching channel entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ChannelEntry findByUserId_First(long userId,
		OrderByComparator orderByComparator)
		throws NoSuchChannelEntryException, SystemException {
		ChannelEntry channelEntry = fetchByUserId_First(userId,
				orderByComparator);

		if (channelEntry != null) {
			return channelEntry;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchChannelEntryException(msg.toString());
	}

	/**
	 * Returns the first channel entry in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching channel entry, or <code>null</code> if a matching channel entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ChannelEntry fetchByUserId_First(long userId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ChannelEntry> list = findByUserId(userId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last channel entry in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching channel entry
	 * @throws org.lsp.liferay.portlet.socialliving.NoSuchChannelEntryException if a matching channel entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ChannelEntry findByUserId_Last(long userId,
		OrderByComparator orderByComparator)
		throws NoSuchChannelEntryException, SystemException {
		ChannelEntry channelEntry = fetchByUserId_Last(userId, orderByComparator);

		if (channelEntry != null) {
			return channelEntry;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchChannelEntryException(msg.toString());
	}

	/**
	 * Returns the last channel entry in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching channel entry, or <code>null</code> if a matching channel entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ChannelEntry fetchByUserId_Last(long userId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUserId(userId);

		List<ChannelEntry> list = findByUserId(userId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the channel entries before and after the current channel entry in the ordered set where userId = &#63;.
	 *
	 * @param channelEntryId the primary key of the current channel entry
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next channel entry
	 * @throws org.lsp.liferay.portlet.socialliving.NoSuchChannelEntryException if a channel entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ChannelEntry[] findByUserId_PrevAndNext(long channelEntryId,
		long userId, OrderByComparator orderByComparator)
		throws NoSuchChannelEntryException, SystemException {
		ChannelEntry channelEntry = findByPrimaryKey(channelEntryId);

		Session session = null;

		try {
			session = openSession();

			ChannelEntry[] array = new ChannelEntryImpl[3];

			array[0] = getByUserId_PrevAndNext(session, channelEntry, userId,
					orderByComparator, true);

			array[1] = channelEntry;

			array[2] = getByUserId_PrevAndNext(session, channelEntry, userId,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ChannelEntry getByUserId_PrevAndNext(Session session,
		ChannelEntry channelEntry, long userId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CHANNELENTRY_WHERE);

		query.append(_FINDER_COLUMN_USERID_USERID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		else {
			query.append(ChannelEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(channelEntry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ChannelEntry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the channel entries where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @return the matching channel entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<ChannelEntry> findByG_U(long groupId, long userId)
		throws SystemException {
		return findByG_U(groupId, userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the channel entries where groupId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of channel entries
	 * @param end the upper bound of the range of channel entries (not inclusive)
	 * @return the range of matching channel entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<ChannelEntry> findByG_U(long groupId, long userId, int start,
		int end) throws SystemException {
		return findByG_U(groupId, userId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the channel entries where groupId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of channel entries
	 * @param end the upper bound of the range of channel entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching channel entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<ChannelEntry> findByG_U(long groupId, long userId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_U;
			finderArgs = new Object[] { groupId, userId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_G_U;
			finderArgs = new Object[] {
					groupId, userId,
					
					start, end, orderByComparator
				};
		}

		List<ChannelEntry> list = (List<ChannelEntry>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ChannelEntry channelEntry : list) {
				if ((groupId != channelEntry.getGroupId()) ||
						(userId != channelEntry.getUserId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_CHANNELENTRY_WHERE);

			query.append(_FINDER_COLUMN_G_U_GROUPID_2);

			query.append(_FINDER_COLUMN_G_U_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(ChannelEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(userId);

				list = (List<ChannelEntry>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first channel entry in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching channel entry
	 * @throws org.lsp.liferay.portlet.socialliving.NoSuchChannelEntryException if a matching channel entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ChannelEntry findByG_U_First(long groupId, long userId,
		OrderByComparator orderByComparator)
		throws NoSuchChannelEntryException, SystemException {
		ChannelEntry channelEntry = fetchByG_U_First(groupId, userId,
				orderByComparator);

		if (channelEntry != null) {
			return channelEntry;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchChannelEntryException(msg.toString());
	}

	/**
	 * Returns the first channel entry in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching channel entry, or <code>null</code> if a matching channel entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ChannelEntry fetchByG_U_First(long groupId, long userId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ChannelEntry> list = findByG_U(groupId, userId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last channel entry in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching channel entry
	 * @throws org.lsp.liferay.portlet.socialliving.NoSuchChannelEntryException if a matching channel entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ChannelEntry findByG_U_Last(long groupId, long userId,
		OrderByComparator orderByComparator)
		throws NoSuchChannelEntryException, SystemException {
		ChannelEntry channelEntry = fetchByG_U_Last(groupId, userId,
				orderByComparator);

		if (channelEntry != null) {
			return channelEntry;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchChannelEntryException(msg.toString());
	}

	/**
	 * Returns the last channel entry in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching channel entry, or <code>null</code> if a matching channel entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ChannelEntry fetchByG_U_Last(long groupId, long userId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByG_U(groupId, userId);

		List<ChannelEntry> list = findByG_U(groupId, userId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the channel entries before and after the current channel entry in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param channelEntryId the primary key of the current channel entry
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next channel entry
	 * @throws org.lsp.liferay.portlet.socialliving.NoSuchChannelEntryException if a channel entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ChannelEntry[] findByG_U_PrevAndNext(long channelEntryId,
		long groupId, long userId, OrderByComparator orderByComparator)
		throws NoSuchChannelEntryException, SystemException {
		ChannelEntry channelEntry = findByPrimaryKey(channelEntryId);

		Session session = null;

		try {
			session = openSession();

			ChannelEntry[] array = new ChannelEntryImpl[3];

			array[0] = getByG_U_PrevAndNext(session, channelEntry, groupId,
					userId, orderByComparator, true);

			array[1] = channelEntry;

			array[2] = getByG_U_PrevAndNext(session, channelEntry, groupId,
					userId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ChannelEntry getByG_U_PrevAndNext(Session session,
		ChannelEntry channelEntry, long groupId, long userId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CHANNELENTRY_WHERE);

		query.append(_FINDER_COLUMN_G_U_GROUPID_2);

		query.append(_FINDER_COLUMN_G_U_USERID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		else {
			query.append(ChannelEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(userId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(channelEntry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ChannelEntry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the channel entries.
	 *
	 * @return the channel entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<ChannelEntry> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<ChannelEntry> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the channel entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of channel entries
	 * @param end the upper bound of the range of channel entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of channel entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<ChannelEntry> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = new Object[] { start, end, orderByComparator };

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<ChannelEntry> list = (List<ChannelEntry>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_CHANNELENTRY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CHANNELENTRY.concat(ChannelEntryModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<ChannelEntry>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<ChannelEntry>)QueryUtil.list(q, getDialect(),
							start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the channel entries where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByGroupId(long groupId) throws SystemException {
		for (ChannelEntry channelEntry : findByGroupId(groupId)) {
			remove(channelEntry);
		}
	}

	/**
	 * Removes all the channel entries where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByUserId(long userId) throws SystemException {
		for (ChannelEntry channelEntry : findByUserId(userId)) {
			remove(channelEntry);
		}
	}

	/**
	 * Removes all the channel entries where groupId = &#63; and userId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByG_U(long groupId, long userId)
		throws SystemException {
		for (ChannelEntry channelEntry : findByG_U(groupId, userId)) {
			remove(channelEntry);
		}
	}

	/**
	 * Removes all the channel entries from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (ChannelEntry channelEntry : findAll()) {
			remove(channelEntry);
		}
	}

	/**
	 * Returns the number of channel entries where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching channel entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countByGroupId(long groupId) throws SystemException {
		Object[] finderArgs = new Object[] { groupId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_GROUPID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CHANNELENTRY_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_GROUPID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of channel entries where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching channel entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countByUserId(long userId) throws SystemException {
		Object[] finderArgs = new Object[] { userId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_USERID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CHANNELENTRY_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_USERID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of channel entries where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @return the number of matching channel entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countByG_U(long groupId, long userId) throws SystemException {
		Object[] finderArgs = new Object[] { groupId, userId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_G_U,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_CHANNELENTRY_WHERE);

			query.append(_FINDER_COLUMN_G_U_GROUPID_2);

			query.append(_FINDER_COLUMN_G_U_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(userId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_G_U, finderArgs,
					count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of channel entries.
	 *
	 * @return the number of channel entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_CHANNELENTRY);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the channel entry persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.lsp.liferay.portlet.socialliving.model.ChannelEntry")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ChannelEntry>> listenersList = new ArrayList<ModelListener<ChannelEntry>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ChannelEntry>)InstanceFactory.newInstance(
							listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(ChannelEntryImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = ChannelEntryPersistence.class)
	protected ChannelEntryPersistence channelEntryPersistence;
	@BeanReference(type = EventEntryPersistence.class)
	protected EventEntryPersistence eventEntryPersistence;
	@BeanReference(type = EventRegistrationPersistence.class)
	protected EventRegistrationPersistence eventRegistrationPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_CHANNELENTRY = "SELECT channelEntry FROM ChannelEntry channelEntry";
	private static final String _SQL_SELECT_CHANNELENTRY_WHERE = "SELECT channelEntry FROM ChannelEntry channelEntry WHERE ";
	private static final String _SQL_COUNT_CHANNELENTRY = "SELECT COUNT(channelEntry) FROM ChannelEntry channelEntry";
	private static final String _SQL_COUNT_CHANNELENTRY_WHERE = "SELECT COUNT(channelEntry) FROM ChannelEntry channelEntry WHERE ";
	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "channelEntry.groupId = ?";
	private static final String _FINDER_COLUMN_USERID_USERID_2 = "channelEntry.userId = ?";
	private static final String _FINDER_COLUMN_G_U_GROUPID_2 = "channelEntry.groupId = ? AND ";
	private static final String _FINDER_COLUMN_G_U_USERID_2 = "channelEntry.userId = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "channelEntry.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ChannelEntry exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ChannelEntry exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ChannelEntryPersistenceImpl.class);
	private static ChannelEntry _nullChannelEntry = new ChannelEntryImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ChannelEntry> toCacheModel() {
				return _nullChannelEntryCacheModel;
			}
		};

	private static CacheModel<ChannelEntry> _nullChannelEntryCacheModel = new CacheModel<ChannelEntry>() {
			public ChannelEntry toEntityModel() {
				return _nullChannelEntry;
			}
		};
}