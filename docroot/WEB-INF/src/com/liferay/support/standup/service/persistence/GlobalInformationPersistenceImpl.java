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

package com.liferay.support.standup.service.persistence;

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
import com.liferay.portal.kernel.util.CalendarUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.liferay.support.standup.NoSuchGlobalInformationException;
import com.liferay.support.standup.model.GlobalInformation;
import com.liferay.support.standup.model.impl.GlobalInformationImpl;
import com.liferay.support.standup.model.impl.GlobalInformationModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * The persistence implementation for the global information service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Daniel Javorszky
 * @see GlobalInformationPersistence
 * @see GlobalInformationUtil
 * @generated
 */
public class GlobalInformationPersistenceImpl extends BasePersistenceImpl<GlobalInformation>
	implements GlobalInformationPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link GlobalInformationUtil} to access the global information persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = GlobalInformationImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(GlobalInformationModelImpl.ENTITY_CACHE_ENABLED,
			GlobalInformationModelImpl.FINDER_CACHE_ENABLED,
			GlobalInformationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
		new FinderPath(GlobalInformationModelImpl.ENTITY_CACHE_ENABLED,
			GlobalInformationModelImpl.FINDER_CACHE_ENABLED,
			GlobalInformationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] { Long.class.getName() },
			GlobalInformationModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(GlobalInformationModelImpl.ENTITY_CACHE_ENABLED,
			GlobalInformationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_DATE = new FinderPath(GlobalInformationModelImpl.ENTITY_CACHE_ENABLED,
			GlobalInformationModelImpl.FINDER_CACHE_ENABLED,
			GlobalInformationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDate",
			new String[] {
				Date.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DATE = new FinderPath(GlobalInformationModelImpl.ENTITY_CACHE_ENABLED,
			GlobalInformationModelImpl.FINDER_CACHE_ENABLED,
			GlobalInformationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByDate",
			new String[] { Date.class.getName() },
			GlobalInformationModelImpl.DATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_DATE = new FinderPath(GlobalInformationModelImpl.ENTITY_CACHE_ENABLED,
			GlobalInformationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDate",
			new String[] { Date.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_DISPLAY = new FinderPath(GlobalInformationModelImpl.ENTITY_CACHE_ENABLED,
			GlobalInformationModelImpl.FINDER_CACHE_ENABLED,
			GlobalInformationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDisplay",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DISPLAY =
		new FinderPath(GlobalInformationModelImpl.ENTITY_CACHE_ENABLED,
			GlobalInformationModelImpl.FINDER_CACHE_ENABLED,
			GlobalInformationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByDisplay",
			new String[] { Integer.class.getName() },
			GlobalInformationModelImpl.DISPLAY_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_DISPLAY = new FinderPath(GlobalInformationModelImpl.ENTITY_CACHE_ENABLED,
			GlobalInformationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDisplay",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(GlobalInformationModelImpl.ENTITY_CACHE_ENABLED,
			GlobalInformationModelImpl.FINDER_CACHE_ENABLED,
			GlobalInformationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(GlobalInformationModelImpl.ENTITY_CACHE_ENABLED,
			GlobalInformationModelImpl.FINDER_CACHE_ENABLED,
			GlobalInformationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(GlobalInformationModelImpl.ENTITY_CACHE_ENABLED,
			GlobalInformationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the global information in the entity cache if it is enabled.
	 *
	 * @param globalInformation the global information
	 */
	public void cacheResult(GlobalInformation globalInformation) {
		EntityCacheUtil.putResult(GlobalInformationModelImpl.ENTITY_CACHE_ENABLED,
			GlobalInformationImpl.class, globalInformation.getPrimaryKey(),
			globalInformation);

		globalInformation.resetOriginalValues();
	}

	/**
	 * Caches the global informations in the entity cache if it is enabled.
	 *
	 * @param globalInformations the global informations
	 */
	public void cacheResult(List<GlobalInformation> globalInformations) {
		for (GlobalInformation globalInformation : globalInformations) {
			if (EntityCacheUtil.getResult(
						GlobalInformationModelImpl.ENTITY_CACHE_ENABLED,
						GlobalInformationImpl.class,
						globalInformation.getPrimaryKey()) == null) {
				cacheResult(globalInformation);
			}
			else {
				globalInformation.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all global informations.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(GlobalInformationImpl.class.getName());
		}

		EntityCacheUtil.clearCache(GlobalInformationImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the global information.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(GlobalInformation globalInformation) {
		EntityCacheUtil.removeResult(GlobalInformationModelImpl.ENTITY_CACHE_ENABLED,
			GlobalInformationImpl.class, globalInformation.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<GlobalInformation> globalInformations) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (GlobalInformation globalInformation : globalInformations) {
			EntityCacheUtil.removeResult(GlobalInformationModelImpl.ENTITY_CACHE_ENABLED,
				GlobalInformationImpl.class, globalInformation.getPrimaryKey());
		}
	}

	/**
	 * Creates a new global information with the primary key. Does not add the global information to the database.
	 *
	 * @param globalInformationId the primary key for the new global information
	 * @return the new global information
	 */
	public GlobalInformation create(long globalInformationId) {
		GlobalInformation globalInformation = new GlobalInformationImpl();

		globalInformation.setNew(true);
		globalInformation.setPrimaryKey(globalInformationId);

		return globalInformation;
	}

	/**
	 * Removes the global information with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param globalInformationId the primary key of the global information
	 * @return the global information that was removed
	 * @throws com.liferay.support.standup.NoSuchGlobalInformationException if a global information with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public GlobalInformation remove(long globalInformationId)
		throws NoSuchGlobalInformationException, SystemException {
		return remove(Long.valueOf(globalInformationId));
	}

	/**
	 * Removes the global information with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the global information
	 * @return the global information that was removed
	 * @throws com.liferay.support.standup.NoSuchGlobalInformationException if a global information with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GlobalInformation remove(Serializable primaryKey)
		throws NoSuchGlobalInformationException, SystemException {
		Session session = null;

		try {
			session = openSession();

			GlobalInformation globalInformation = (GlobalInformation)session.get(GlobalInformationImpl.class,
					primaryKey);

			if (globalInformation == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchGlobalInformationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(globalInformation);
		}
		catch (NoSuchGlobalInformationException nsee) {
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
	protected GlobalInformation removeImpl(GlobalInformation globalInformation)
		throws SystemException {
		globalInformation = toUnwrappedModel(globalInformation);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, globalInformation);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(globalInformation);

		return globalInformation;
	}

	@Override
	public GlobalInformation updateImpl(
		com.liferay.support.standup.model.GlobalInformation globalInformation,
		boolean merge) throws SystemException {
		globalInformation = toUnwrappedModel(globalInformation);

		boolean isNew = globalInformation.isNew();

		GlobalInformationModelImpl globalInformationModelImpl = (GlobalInformationModelImpl)globalInformation;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, globalInformation, merge);

			globalInformation.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !GlobalInformationModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((globalInformationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(globalInformationModelImpl.getOriginalGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);

				args = new Object[] {
						Long.valueOf(globalInformationModelImpl.getGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);
			}

			if ((globalInformationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DATE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						globalInformationModelImpl.getOriginalDate()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DATE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DATE,
					args);

				args = new Object[] { globalInformationModelImpl.getDate() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DATE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DATE,
					args);
			}

			if ((globalInformationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DISPLAY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Integer.valueOf(globalInformationModelImpl.getOriginalDisplay())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DISPLAY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DISPLAY,
					args);

				args = new Object[] {
						Integer.valueOf(globalInformationModelImpl.getDisplay())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DISPLAY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DISPLAY,
					args);
			}
		}

		EntityCacheUtil.putResult(GlobalInformationModelImpl.ENTITY_CACHE_ENABLED,
			GlobalInformationImpl.class, globalInformation.getPrimaryKey(),
			globalInformation);

		return globalInformation;
	}

	protected GlobalInformation toUnwrappedModel(
		GlobalInformation globalInformation) {
		if (globalInformation instanceof GlobalInformationImpl) {
			return globalInformation;
		}

		GlobalInformationImpl globalInformationImpl = new GlobalInformationImpl();

		globalInformationImpl.setNew(globalInformation.isNew());
		globalInformationImpl.setPrimaryKey(globalInformation.getPrimaryKey());

		globalInformationImpl.setGlobalInformationId(globalInformation.getGlobalInformationId());
		globalInformationImpl.setCompanyId(globalInformation.getCompanyId());
		globalInformationImpl.setGroupId(globalInformation.getGroupId());
		globalInformationImpl.setUserId(globalInformation.getUserId());
		globalInformationImpl.setDate(globalInformation.getDate());
		globalInformationImpl.setMessage(globalInformation.getMessage());
		globalInformationImpl.setDisplay(globalInformation.getDisplay());
		globalInformationImpl.setStatus(globalInformation.getStatus());

		return globalInformationImpl;
	}

	/**
	 * Returns the global information with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the global information
	 * @return the global information
	 * @throws com.liferay.portal.NoSuchModelException if a global information with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GlobalInformation findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the global information with the primary key or throws a {@link com.liferay.support.standup.NoSuchGlobalInformationException} if it could not be found.
	 *
	 * @param globalInformationId the primary key of the global information
	 * @return the global information
	 * @throws com.liferay.support.standup.NoSuchGlobalInformationException if a global information with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public GlobalInformation findByPrimaryKey(long globalInformationId)
		throws NoSuchGlobalInformationException, SystemException {
		GlobalInformation globalInformation = fetchByPrimaryKey(globalInformationId);

		if (globalInformation == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					globalInformationId);
			}

			throw new NoSuchGlobalInformationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				globalInformationId);
		}

		return globalInformation;
	}

	/**
	 * Returns the global information with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the global information
	 * @return the global information, or <code>null</code> if a global information with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GlobalInformation fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the global information with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param globalInformationId the primary key of the global information
	 * @return the global information, or <code>null</code> if a global information with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public GlobalInformation fetchByPrimaryKey(long globalInformationId)
		throws SystemException {
		GlobalInformation globalInformation = (GlobalInformation)EntityCacheUtil.getResult(GlobalInformationModelImpl.ENTITY_CACHE_ENABLED,
				GlobalInformationImpl.class, globalInformationId);

		if (globalInformation == _nullGlobalInformation) {
			return null;
		}

		if (globalInformation == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				globalInformation = (GlobalInformation)session.get(GlobalInformationImpl.class,
						Long.valueOf(globalInformationId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (globalInformation != null) {
					cacheResult(globalInformation);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(GlobalInformationModelImpl.ENTITY_CACHE_ENABLED,
						GlobalInformationImpl.class, globalInformationId,
						_nullGlobalInformation);
				}

				closeSession(session);
			}
		}

		return globalInformation;
	}

	/**
	 * Returns all the global informations where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching global informations
	 * @throws SystemException if a system exception occurred
	 */
	public List<GlobalInformation> findByGroupId(long groupId)
		throws SystemException {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the global informations where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of global informations
	 * @param end the upper bound of the range of global informations (not inclusive)
	 * @return the range of matching global informations
	 * @throws SystemException if a system exception occurred
	 */
	public List<GlobalInformation> findByGroupId(long groupId, int start,
		int end) throws SystemException {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the global informations where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of global informations
	 * @param end the upper bound of the range of global informations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching global informations
	 * @throws SystemException if a system exception occurred
	 */
	public List<GlobalInformation> findByGroupId(long groupId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
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

		List<GlobalInformation> list = (List<GlobalInformation>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (GlobalInformation globalInformation : list) {
				if ((groupId != globalInformation.getGroupId())) {
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

			query.append(_SQL_SELECT_GLOBALINFORMATION_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(GlobalInformationModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				list = (List<GlobalInformation>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first global information in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching global information
	 * @throws com.liferay.support.standup.NoSuchGlobalInformationException if a matching global information could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public GlobalInformation findByGroupId_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchGlobalInformationException, SystemException {
		GlobalInformation globalInformation = fetchByGroupId_First(groupId,
				orderByComparator);

		if (globalInformation != null) {
			return globalInformation;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchGlobalInformationException(msg.toString());
	}

	/**
	 * Returns the first global information in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching global information, or <code>null</code> if a matching global information could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public GlobalInformation fetchByGroupId_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<GlobalInformation> list = findByGroupId(groupId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last global information in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching global information
	 * @throws com.liferay.support.standup.NoSuchGlobalInformationException if a matching global information could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public GlobalInformation findByGroupId_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchGlobalInformationException, SystemException {
		GlobalInformation globalInformation = fetchByGroupId_Last(groupId,
				orderByComparator);

		if (globalInformation != null) {
			return globalInformation;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchGlobalInformationException(msg.toString());
	}

	/**
	 * Returns the last global information in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching global information, or <code>null</code> if a matching global information could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public GlobalInformation fetchByGroupId_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroupId(groupId);

		List<GlobalInformation> list = findByGroupId(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the global informations before and after the current global information in the ordered set where groupId = &#63;.
	 *
	 * @param globalInformationId the primary key of the current global information
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next global information
	 * @throws com.liferay.support.standup.NoSuchGlobalInformationException if a global information with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public GlobalInformation[] findByGroupId_PrevAndNext(
		long globalInformationId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchGlobalInformationException, SystemException {
		GlobalInformation globalInformation = findByPrimaryKey(globalInformationId);

		Session session = null;

		try {
			session = openSession();

			GlobalInformation[] array = new GlobalInformationImpl[3];

			array[0] = getByGroupId_PrevAndNext(session, globalInformation,
					groupId, orderByComparator, true);

			array[1] = globalInformation;

			array[2] = getByGroupId_PrevAndNext(session, globalInformation,
					groupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected GlobalInformation getByGroupId_PrevAndNext(Session session,
		GlobalInformation globalInformation, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_GLOBALINFORMATION_WHERE);

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
			query.append(GlobalInformationModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(globalInformation);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<GlobalInformation> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the global informations where date = &#63;.
	 *
	 * @param date the date
	 * @return the matching global informations
	 * @throws SystemException if a system exception occurred
	 */
	public List<GlobalInformation> findByDate(Date date)
		throws SystemException {
		return findByDate(date, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the global informations where date = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param date the date
	 * @param start the lower bound of the range of global informations
	 * @param end the upper bound of the range of global informations (not inclusive)
	 * @return the range of matching global informations
	 * @throws SystemException if a system exception occurred
	 */
	public List<GlobalInformation> findByDate(Date date, int start, int end)
		throws SystemException {
		return findByDate(date, start, end, null);
	}

	/**
	 * Returns an ordered range of all the global informations where date = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param date the date
	 * @param start the lower bound of the range of global informations
	 * @param end the upper bound of the range of global informations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching global informations
	 * @throws SystemException if a system exception occurred
	 */
	public List<GlobalInformation> findByDate(Date date, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DATE;
			finderArgs = new Object[] { date };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_DATE;
			finderArgs = new Object[] { date, start, end, orderByComparator };
		}

		List<GlobalInformation> list = (List<GlobalInformation>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (GlobalInformation globalInformation : list) {
				if (!Validator.equals(date, globalInformation.getDate())) {
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

			query.append(_SQL_SELECT_GLOBALINFORMATION_WHERE);

			if (date == null) {
				query.append(_FINDER_COLUMN_DATE_DATE_1);
			}
			else {
				query.append(_FINDER_COLUMN_DATE_DATE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(GlobalInformationModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (date != null) {
					qPos.add(CalendarUtil.getTimestamp(date));
				}

				list = (List<GlobalInformation>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first global information in the ordered set where date = &#63;.
	 *
	 * @param date the date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching global information
	 * @throws com.liferay.support.standup.NoSuchGlobalInformationException if a matching global information could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public GlobalInformation findByDate_First(Date date,
		OrderByComparator orderByComparator)
		throws NoSuchGlobalInformationException, SystemException {
		GlobalInformation globalInformation = fetchByDate_First(date,
				orderByComparator);

		if (globalInformation != null) {
			return globalInformation;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("date=");
		msg.append(date);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchGlobalInformationException(msg.toString());
	}

	/**
	 * Returns the first global information in the ordered set where date = &#63;.
	 *
	 * @param date the date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching global information, or <code>null</code> if a matching global information could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public GlobalInformation fetchByDate_First(Date date,
		OrderByComparator orderByComparator) throws SystemException {
		List<GlobalInformation> list = findByDate(date, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last global information in the ordered set where date = &#63;.
	 *
	 * @param date the date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching global information
	 * @throws com.liferay.support.standup.NoSuchGlobalInformationException if a matching global information could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public GlobalInformation findByDate_Last(Date date,
		OrderByComparator orderByComparator)
		throws NoSuchGlobalInformationException, SystemException {
		GlobalInformation globalInformation = fetchByDate_Last(date,
				orderByComparator);

		if (globalInformation != null) {
			return globalInformation;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("date=");
		msg.append(date);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchGlobalInformationException(msg.toString());
	}

	/**
	 * Returns the last global information in the ordered set where date = &#63;.
	 *
	 * @param date the date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching global information, or <code>null</code> if a matching global information could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public GlobalInformation fetchByDate_Last(Date date,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByDate(date);

		List<GlobalInformation> list = findByDate(date, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the global informations before and after the current global information in the ordered set where date = &#63;.
	 *
	 * @param globalInformationId the primary key of the current global information
	 * @param date the date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next global information
	 * @throws com.liferay.support.standup.NoSuchGlobalInformationException if a global information with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public GlobalInformation[] findByDate_PrevAndNext(
		long globalInformationId, Date date, OrderByComparator orderByComparator)
		throws NoSuchGlobalInformationException, SystemException {
		GlobalInformation globalInformation = findByPrimaryKey(globalInformationId);

		Session session = null;

		try {
			session = openSession();

			GlobalInformation[] array = new GlobalInformationImpl[3];

			array[0] = getByDate_PrevAndNext(session, globalInformation, date,
					orderByComparator, true);

			array[1] = globalInformation;

			array[2] = getByDate_PrevAndNext(session, globalInformation, date,
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

	protected GlobalInformation getByDate_PrevAndNext(Session session,
		GlobalInformation globalInformation, Date date,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_GLOBALINFORMATION_WHERE);

		if (date == null) {
			query.append(_FINDER_COLUMN_DATE_DATE_1);
		}
		else {
			query.append(_FINDER_COLUMN_DATE_DATE_2);
		}

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
			query.append(GlobalInformationModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (date != null) {
			qPos.add(CalendarUtil.getTimestamp(date));
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(globalInformation);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<GlobalInformation> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the global informations where display = &#63;.
	 *
	 * @param display the display
	 * @return the matching global informations
	 * @throws SystemException if a system exception occurred
	 */
	public List<GlobalInformation> findByDisplay(int display)
		throws SystemException {
		return findByDisplay(display, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the global informations where display = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param display the display
	 * @param start the lower bound of the range of global informations
	 * @param end the upper bound of the range of global informations (not inclusive)
	 * @return the range of matching global informations
	 * @throws SystemException if a system exception occurred
	 */
	public List<GlobalInformation> findByDisplay(int display, int start, int end)
		throws SystemException {
		return findByDisplay(display, start, end, null);
	}

	/**
	 * Returns an ordered range of all the global informations where display = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param display the display
	 * @param start the lower bound of the range of global informations
	 * @param end the upper bound of the range of global informations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching global informations
	 * @throws SystemException if a system exception occurred
	 */
	public List<GlobalInformation> findByDisplay(int display, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DISPLAY;
			finderArgs = new Object[] { display };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_DISPLAY;
			finderArgs = new Object[] { display, start, end, orderByComparator };
		}

		List<GlobalInformation> list = (List<GlobalInformation>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (GlobalInformation globalInformation : list) {
				if ((display != globalInformation.getDisplay())) {
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

			query.append(_SQL_SELECT_GLOBALINFORMATION_WHERE);

			query.append(_FINDER_COLUMN_DISPLAY_DISPLAY_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(GlobalInformationModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(display);

				list = (List<GlobalInformation>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first global information in the ordered set where display = &#63;.
	 *
	 * @param display the display
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching global information
	 * @throws com.liferay.support.standup.NoSuchGlobalInformationException if a matching global information could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public GlobalInformation findByDisplay_First(int display,
		OrderByComparator orderByComparator)
		throws NoSuchGlobalInformationException, SystemException {
		GlobalInformation globalInformation = fetchByDisplay_First(display,
				orderByComparator);

		if (globalInformation != null) {
			return globalInformation;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("display=");
		msg.append(display);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchGlobalInformationException(msg.toString());
	}

	/**
	 * Returns the first global information in the ordered set where display = &#63;.
	 *
	 * @param display the display
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching global information, or <code>null</code> if a matching global information could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public GlobalInformation fetchByDisplay_First(int display,
		OrderByComparator orderByComparator) throws SystemException {
		List<GlobalInformation> list = findByDisplay(display, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last global information in the ordered set where display = &#63;.
	 *
	 * @param display the display
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching global information
	 * @throws com.liferay.support.standup.NoSuchGlobalInformationException if a matching global information could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public GlobalInformation findByDisplay_Last(int display,
		OrderByComparator orderByComparator)
		throws NoSuchGlobalInformationException, SystemException {
		GlobalInformation globalInformation = fetchByDisplay_Last(display,
				orderByComparator);

		if (globalInformation != null) {
			return globalInformation;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("display=");
		msg.append(display);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchGlobalInformationException(msg.toString());
	}

	/**
	 * Returns the last global information in the ordered set where display = &#63;.
	 *
	 * @param display the display
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching global information, or <code>null</code> if a matching global information could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public GlobalInformation fetchByDisplay_Last(int display,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByDisplay(display);

		List<GlobalInformation> list = findByDisplay(display, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the global informations before and after the current global information in the ordered set where display = &#63;.
	 *
	 * @param globalInformationId the primary key of the current global information
	 * @param display the display
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next global information
	 * @throws com.liferay.support.standup.NoSuchGlobalInformationException if a global information with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public GlobalInformation[] findByDisplay_PrevAndNext(
		long globalInformationId, int display,
		OrderByComparator orderByComparator)
		throws NoSuchGlobalInformationException, SystemException {
		GlobalInformation globalInformation = findByPrimaryKey(globalInformationId);

		Session session = null;

		try {
			session = openSession();

			GlobalInformation[] array = new GlobalInformationImpl[3];

			array[0] = getByDisplay_PrevAndNext(session, globalInformation,
					display, orderByComparator, true);

			array[1] = globalInformation;

			array[2] = getByDisplay_PrevAndNext(session, globalInformation,
					display, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected GlobalInformation getByDisplay_PrevAndNext(Session session,
		GlobalInformation globalInformation, int display,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_GLOBALINFORMATION_WHERE);

		query.append(_FINDER_COLUMN_DISPLAY_DISPLAY_2);

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
			query.append(GlobalInformationModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(display);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(globalInformation);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<GlobalInformation> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the global informations.
	 *
	 * @return the global informations
	 * @throws SystemException if a system exception occurred
	 */
	public List<GlobalInformation> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the global informations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of global informations
	 * @param end the upper bound of the range of global informations (not inclusive)
	 * @return the range of global informations
	 * @throws SystemException if a system exception occurred
	 */
	public List<GlobalInformation> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the global informations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of global informations
	 * @param end the upper bound of the range of global informations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of global informations
	 * @throws SystemException if a system exception occurred
	 */
	public List<GlobalInformation> findAll(int start, int end,
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

		List<GlobalInformation> list = (List<GlobalInformation>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_GLOBALINFORMATION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_GLOBALINFORMATION.concat(GlobalInformationModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<GlobalInformation>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<GlobalInformation>)QueryUtil.list(q,
							getDialect(), start, end);
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
	 * Removes all the global informations where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByGroupId(long groupId) throws SystemException {
		for (GlobalInformation globalInformation : findByGroupId(groupId)) {
			remove(globalInformation);
		}
	}

	/**
	 * Removes all the global informations where date = &#63; from the database.
	 *
	 * @param date the date
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByDate(Date date) throws SystemException {
		for (GlobalInformation globalInformation : findByDate(date)) {
			remove(globalInformation);
		}
	}

	/**
	 * Removes all the global informations where display = &#63; from the database.
	 *
	 * @param display the display
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByDisplay(int display) throws SystemException {
		for (GlobalInformation globalInformation : findByDisplay(display)) {
			remove(globalInformation);
		}
	}

	/**
	 * Removes all the global informations from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (GlobalInformation globalInformation : findAll()) {
			remove(globalInformation);
		}
	}

	/**
	 * Returns the number of global informations where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching global informations
	 * @throws SystemException if a system exception occurred
	 */
	public int countByGroupId(long groupId) throws SystemException {
		Object[] finderArgs = new Object[] { groupId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_GROUPID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_GLOBALINFORMATION_WHERE);

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
	 * Returns the number of global informations where date = &#63;.
	 *
	 * @param date the date
	 * @return the number of matching global informations
	 * @throws SystemException if a system exception occurred
	 */
	public int countByDate(Date date) throws SystemException {
		Object[] finderArgs = new Object[] { date };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_DATE,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_GLOBALINFORMATION_WHERE);

			if (date == null) {
				query.append(_FINDER_COLUMN_DATE_DATE_1);
			}
			else {
				query.append(_FINDER_COLUMN_DATE_DATE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (date != null) {
					qPos.add(CalendarUtil.getTimestamp(date));
				}

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_DATE,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of global informations where display = &#63;.
	 *
	 * @param display the display
	 * @return the number of matching global informations
	 * @throws SystemException if a system exception occurred
	 */
	public int countByDisplay(int display) throws SystemException {
		Object[] finderArgs = new Object[] { display };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_DISPLAY,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_GLOBALINFORMATION_WHERE);

			query.append(_FINDER_COLUMN_DISPLAY_DISPLAY_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(display);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_DISPLAY,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of global informations.
	 *
	 * @return the number of global informations
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_GLOBALINFORMATION);

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
	 * Initializes the global information persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.liferay.support.standup.model.GlobalInformation")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<GlobalInformation>> listenersList = new ArrayList<ModelListener<GlobalInformation>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<GlobalInformation>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(GlobalInformationImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = GlobalInformationPersistence.class)
	protected GlobalInformationPersistence globalInformationPersistence;
	@BeanReference(type = StandUpEntryPersistence.class)
	protected StandUpEntryPersistence standUpEntryPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_GLOBALINFORMATION = "SELECT globalInformation FROM GlobalInformation globalInformation";
	private static final String _SQL_SELECT_GLOBALINFORMATION_WHERE = "SELECT globalInformation FROM GlobalInformation globalInformation WHERE ";
	private static final String _SQL_COUNT_GLOBALINFORMATION = "SELECT COUNT(globalInformation) FROM GlobalInformation globalInformation";
	private static final String _SQL_COUNT_GLOBALINFORMATION_WHERE = "SELECT COUNT(globalInformation) FROM GlobalInformation globalInformation WHERE ";
	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "globalInformation.groupId = ?";
	private static final String _FINDER_COLUMN_DATE_DATE_1 = "globalInformation.date IS NULL";
	private static final String _FINDER_COLUMN_DATE_DATE_2 = "globalInformation.date = ?";
	private static final String _FINDER_COLUMN_DISPLAY_DISPLAY_2 = "globalInformation.display = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "globalInformation.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No GlobalInformation exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No GlobalInformation exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(GlobalInformationPersistenceImpl.class);
	private static GlobalInformation _nullGlobalInformation = new GlobalInformationImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<GlobalInformation> toCacheModel() {
				return _nullGlobalInformationCacheModel;
			}
		};

	private static CacheModel<GlobalInformation> _nullGlobalInformationCacheModel =
		new CacheModel<GlobalInformation>() {
			public GlobalInformation toEntityModel() {
				return _nullGlobalInformation;
			}
		};
}