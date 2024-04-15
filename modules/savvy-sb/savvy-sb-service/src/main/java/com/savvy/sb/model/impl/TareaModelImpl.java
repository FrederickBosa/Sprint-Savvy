/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
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

package com.savvy.sb.model.impl;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringUtil;

import com.savvy.sb.model.Tarea;
import com.savvy.sb.model.TareaModel;
import com.savvy.sb.model.TareaSoap;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.sql.Blob;
import java.sql.Types;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the Tarea service. Represents a row in the &quot;Servicio_Savvy_Tarea&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>TareaModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link TareaImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TareaImpl
 * @generated
 */
@JSON(strict = true)
public class TareaModelImpl extends BaseModelImpl<Tarea> implements TareaModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a tarea model instance should use the <code>Tarea</code> interface instead.
	 */
	public static final String TABLE_NAME = "Servicio_Savvy_Tarea";

	public static final Object[][] TABLE_COLUMNS = {
		{"uuid_", Types.VARCHAR}, {"tareaId", Types.BIGINT},
		{"groupId", Types.BIGINT}, {"companyId", Types.BIGINT},
		{"userId", Types.BIGINT}, {"userName", Types.VARCHAR},
		{"createDate", Types.TIMESTAMP}, {"modifiedDate", Types.TIMESTAMP},
		{"nombreTarea", Types.VARCHAR}, {"proyecto", Types.VARCHAR},
		{"responsable", Types.VARCHAR}, {"prioridad", Types.VARCHAR},
		{"sprint", Types.VARCHAR}, {"estado", Types.VARCHAR},
		{"fechaLimite", Types.VARCHAR}, {"resumen", Types.VARCHAR},
		{"descripcion", Types.VARCHAR}, {"categoria", Types.VARCHAR},
		{"etiqueta", Types.VARCHAR}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("tareaId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("nombreTarea", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("proyecto", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("responsable", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("prioridad", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("sprint", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("estado", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("fechaLimite", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("resumen", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("descripcion", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("categoria", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("etiqueta", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE =
		"create table Servicio_Savvy_Tarea (uuid_ VARCHAR(75) null,tareaId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,nombreTarea VARCHAR(75) null,proyecto VARCHAR(75) null,responsable VARCHAR(75) null,prioridad VARCHAR(75) null,sprint VARCHAR(75) null,estado VARCHAR(75) null,fechaLimite VARCHAR(75) null,resumen VARCHAR(75) null,descripcion VARCHAR(999) null,categoria VARCHAR(75) null,etiqueta VARCHAR(75) null)";

	public static final String TABLE_SQL_DROP =
		"drop table Servicio_Savvy_Tarea";

	public static final String ORDER_BY_JPQL =
		" ORDER BY tarea.nombreTarea ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY Servicio_Savvy_Tarea.nombreTarea ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long COMPANYID_COLUMN_BITMASK = 1L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long GROUPID_COLUMN_BITMASK = 2L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long NOMBRETAREA_COLUMN_BITMASK = 4L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long UUID_COLUMN_BITMASK = 8L;

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static void setEntityCacheEnabled(boolean entityCacheEnabled) {
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static void setFinderCacheEnabled(boolean finderCacheEnabled) {
	}

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static Tarea toModel(TareaSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		Tarea model = new TareaImpl();

		model.setUuid(soapModel.getUuid());
		model.setTareaId(soapModel.getTareaId());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setNombreTarea(soapModel.getNombreTarea());
		model.setProyecto(soapModel.getProyecto());
		model.setResponsable(soapModel.getResponsable());
		model.setPrioridad(soapModel.getPrioridad());
		model.setSprint(soapModel.getSprint());
		model.setEstado(soapModel.getEstado());
		model.setFechaLimite(soapModel.getFechaLimite());
		model.setResumen(soapModel.getResumen());
		model.setDescripcion(soapModel.getDescripcion());
		model.setCategoria(soapModel.getCategoria());
		model.setEtiqueta(soapModel.getEtiqueta());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static List<Tarea> toModels(TareaSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<Tarea> models = new ArrayList<Tarea>(soapModels.length);

		for (TareaSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public TareaModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _tareaId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setTareaId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _tareaId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return Tarea.class;
	}

	@Override
	public String getModelClassName() {
		return Tarea.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<Tarea, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<Tarea, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Tarea, Object> attributeGetterFunction = entry.getValue();

			attributes.put(
				attributeName, attributeGetterFunction.apply((Tarea)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<Tarea, Object>> attributeSetterBiConsumers =
			getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<Tarea, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept((Tarea)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<Tarea, Object>> getAttributeGetterFunctions() {
		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<Tarea, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static final Map<String, Function<Tarea, Object>>
		_attributeGetterFunctions;

	static {
		Map<String, Function<Tarea, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<Tarea, Object>>();

		attributeGetterFunctions.put("uuid", Tarea::getUuid);
		attributeGetterFunctions.put("tareaId", Tarea::getTareaId);
		attributeGetterFunctions.put("groupId", Tarea::getGroupId);
		attributeGetterFunctions.put("companyId", Tarea::getCompanyId);
		attributeGetterFunctions.put("userId", Tarea::getUserId);
		attributeGetterFunctions.put("userName", Tarea::getUserName);
		attributeGetterFunctions.put("createDate", Tarea::getCreateDate);
		attributeGetterFunctions.put("modifiedDate", Tarea::getModifiedDate);
		attributeGetterFunctions.put("nombreTarea", Tarea::getNombreTarea);
		attributeGetterFunctions.put("proyecto", Tarea::getProyecto);
		attributeGetterFunctions.put("responsable", Tarea::getResponsable);
		attributeGetterFunctions.put("prioridad", Tarea::getPrioridad);
		attributeGetterFunctions.put("sprint", Tarea::getSprint);
		attributeGetterFunctions.put("estado", Tarea::getEstado);
		attributeGetterFunctions.put("fechaLimite", Tarea::getFechaLimite);
		attributeGetterFunctions.put("resumen", Tarea::getResumen);
		attributeGetterFunctions.put("descripcion", Tarea::getDescripcion);
		attributeGetterFunctions.put("categoria", Tarea::getCategoria);
		attributeGetterFunctions.put("etiqueta", Tarea::getEtiqueta);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
	}

	private static final Map<String, BiConsumer<Tarea, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, BiConsumer<Tarea, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<Tarea, ?>>();

		attributeSetterBiConsumers.put(
			"uuid", (BiConsumer<Tarea, String>)Tarea::setUuid);
		attributeSetterBiConsumers.put(
			"tareaId", (BiConsumer<Tarea, Long>)Tarea::setTareaId);
		attributeSetterBiConsumers.put(
			"groupId", (BiConsumer<Tarea, Long>)Tarea::setGroupId);
		attributeSetterBiConsumers.put(
			"companyId", (BiConsumer<Tarea, Long>)Tarea::setCompanyId);
		attributeSetterBiConsumers.put(
			"userId", (BiConsumer<Tarea, Long>)Tarea::setUserId);
		attributeSetterBiConsumers.put(
			"userName", (BiConsumer<Tarea, String>)Tarea::setUserName);
		attributeSetterBiConsumers.put(
			"createDate", (BiConsumer<Tarea, Date>)Tarea::setCreateDate);
		attributeSetterBiConsumers.put(
			"modifiedDate", (BiConsumer<Tarea, Date>)Tarea::setModifiedDate);
		attributeSetterBiConsumers.put(
			"nombreTarea", (BiConsumer<Tarea, String>)Tarea::setNombreTarea);
		attributeSetterBiConsumers.put(
			"proyecto", (BiConsumer<Tarea, String>)Tarea::setProyecto);
		attributeSetterBiConsumers.put(
			"responsable", (BiConsumer<Tarea, String>)Tarea::setResponsable);
		attributeSetterBiConsumers.put(
			"prioridad", (BiConsumer<Tarea, String>)Tarea::setPrioridad);
		attributeSetterBiConsumers.put(
			"sprint", (BiConsumer<Tarea, String>)Tarea::setSprint);
		attributeSetterBiConsumers.put(
			"estado", (BiConsumer<Tarea, String>)Tarea::setEstado);
		attributeSetterBiConsumers.put(
			"fechaLimite", (BiConsumer<Tarea, String>)Tarea::setFechaLimite);
		attributeSetterBiConsumers.put(
			"resumen", (BiConsumer<Tarea, String>)Tarea::setResumen);
		attributeSetterBiConsumers.put(
			"descripcion", (BiConsumer<Tarea, String>)Tarea::setDescripcion);
		attributeSetterBiConsumers.put(
			"categoria", (BiConsumer<Tarea, String>)Tarea::setCategoria);
		attributeSetterBiConsumers.put(
			"etiqueta", (BiConsumer<Tarea, String>)Tarea::setEtiqueta);

		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public String getUuid() {
		if (_uuid == null) {
			return "";
		}
		else {
			return _uuid;
		}
	}

	@Override
	public void setUuid(String uuid) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_uuid = uuid;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalUuid() {
		return getColumnOriginalValue("uuid_");
	}

	@JSON
	@Override
	public long getTareaId() {
		return _tareaId;
	}

	@Override
	public void setTareaId(long tareaId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_tareaId = tareaId;
	}

	@JSON
	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_groupId = groupId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalGroupId() {
		return GetterUtil.getLong(this.<Long>getColumnOriginalValue("groupId"));
	}

	@JSON
	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_companyId = companyId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalCompanyId() {
		return GetterUtil.getLong(
			this.<Long>getColumnOriginalValue("companyId"));
	}

	@JSON
	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException portalException) {
			return "";
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	@JSON
	@Override
	public String getUserName() {
		if (_userName == null) {
			return "";
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_userName = userName;
	}

	@JSON
	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_createDate = createDate;
	}

	@JSON
	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public boolean hasSetModifiedDate() {
		return _setModifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_setModifiedDate = true;

		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_modifiedDate = modifiedDate;
	}

	@JSON
	@Override
	public String getNombreTarea() {
		if (_nombreTarea == null) {
			return "";
		}
		else {
			return _nombreTarea;
		}
	}

	@Override
	public void setNombreTarea(String nombreTarea) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_nombreTarea = nombreTarea;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalNombreTarea() {
		return getColumnOriginalValue("nombreTarea");
	}

	@JSON
	@Override
	public String getProyecto() {
		if (_proyecto == null) {
			return "";
		}
		else {
			return _proyecto;
		}
	}

	@Override
	public void setProyecto(String proyecto) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_proyecto = proyecto;
	}

	@JSON
	@Override
	public String getResponsable() {
		if (_responsable == null) {
			return "";
		}
		else {
			return _responsable;
		}
	}

	@Override
	public void setResponsable(String responsable) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_responsable = responsable;
	}

	@JSON
	@Override
	public String getPrioridad() {
		if (_prioridad == null) {
			return "";
		}
		else {
			return _prioridad;
		}
	}

	@Override
	public void setPrioridad(String prioridad) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_prioridad = prioridad;
	}

	@JSON
	@Override
	public String getSprint() {
		if (_sprint == null) {
			return "";
		}
		else {
			return _sprint;
		}
	}

	@Override
	public void setSprint(String sprint) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_sprint = sprint;
	}

	@JSON
	@Override
	public String getEstado() {
		if (_estado == null) {
			return "";
		}
		else {
			return _estado;
		}
	}

	@Override
	public void setEstado(String estado) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_estado = estado;
	}

	@JSON
	@Override
	public String getFechaLimite() {
		if (_fechaLimite == null) {
			return "";
		}
		else {
			return _fechaLimite;
		}
	}

	@Override
	public void setFechaLimite(String fechaLimite) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_fechaLimite = fechaLimite;
	}

	@JSON
	@Override
	public String getResumen() {
		if (_resumen == null) {
			return "";
		}
		else {
			return _resumen;
		}
	}

	@Override
	public void setResumen(String resumen) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_resumen = resumen;
	}

	@JSON
	@Override
	public String getDescripcion() {
		if (_descripcion == null) {
			return "";
		}
		else {
			return _descripcion;
		}
	}

	@Override
	public void setDescripcion(String descripcion) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_descripcion = descripcion;
	}

	@JSON
	@Override
	public String getCategoria() {
		if (_categoria == null) {
			return "";
		}
		else {
			return _categoria;
		}
	}

	@Override
	public void setCategoria(String categoria) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_categoria = categoria;
	}

	@JSON
	@Override
	public String getEtiqueta() {
		if (_etiqueta == null) {
			return "";
		}
		else {
			return _etiqueta;
		}
	}

	@Override
	public void setEtiqueta(String etiqueta) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_etiqueta = etiqueta;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(
			PortalUtil.getClassNameId(Tarea.class.getName()));
	}

	public long getColumnBitmask() {
		if (_columnBitmask > 0) {
			return _columnBitmask;
		}

		if ((_columnOriginalValues == null) ||
			(_columnOriginalValues == Collections.EMPTY_MAP)) {

			return 0;
		}

		for (Map.Entry<String, Object> entry :
				_columnOriginalValues.entrySet()) {

			if (!Objects.equals(
					entry.getValue(), getColumnValue(entry.getKey()))) {

				_columnBitmask |= _columnBitmasks.get(entry.getKey());
			}
		}

		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			getCompanyId(), Tarea.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Tarea toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, Tarea>
				escapedModelProxyProviderFunction =
					EscapedModelProxyProviderFunctionHolder.
						_escapedModelProxyProviderFunction;

			_escapedModel = escapedModelProxyProviderFunction.apply(
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		TareaImpl tareaImpl = new TareaImpl();

		tareaImpl.setUuid(getUuid());
		tareaImpl.setTareaId(getTareaId());
		tareaImpl.setGroupId(getGroupId());
		tareaImpl.setCompanyId(getCompanyId());
		tareaImpl.setUserId(getUserId());
		tareaImpl.setUserName(getUserName());
		tareaImpl.setCreateDate(getCreateDate());
		tareaImpl.setModifiedDate(getModifiedDate());
		tareaImpl.setNombreTarea(getNombreTarea());
		tareaImpl.setProyecto(getProyecto());
		tareaImpl.setResponsable(getResponsable());
		tareaImpl.setPrioridad(getPrioridad());
		tareaImpl.setSprint(getSprint());
		tareaImpl.setEstado(getEstado());
		tareaImpl.setFechaLimite(getFechaLimite());
		tareaImpl.setResumen(getResumen());
		tareaImpl.setDescripcion(getDescripcion());
		tareaImpl.setCategoria(getCategoria());
		tareaImpl.setEtiqueta(getEtiqueta());

		tareaImpl.resetOriginalValues();

		return tareaImpl;
	}

	@Override
	public int compareTo(Tarea tarea) {
		int value = 0;

		value = getNombreTarea().compareTo(tarea.getNombreTarea());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof Tarea)) {
			return false;
		}

		Tarea tarea = (Tarea)object;

		long primaryKey = tarea.getPrimaryKey();

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

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isEntityCacheEnabled() {
		return true;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isFinderCacheEnabled() {
		return true;
	}

	@Override
	public void resetOriginalValues() {
		_columnOriginalValues = Collections.emptyMap();

		_setModifiedDate = false;

		_columnBitmask = 0;
	}

	@Override
	public CacheModel<Tarea> toCacheModel() {
		TareaCacheModel tareaCacheModel = new TareaCacheModel();

		tareaCacheModel.uuid = getUuid();

		String uuid = tareaCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			tareaCacheModel.uuid = null;
		}

		tareaCacheModel.tareaId = getTareaId();

		tareaCacheModel.groupId = getGroupId();

		tareaCacheModel.companyId = getCompanyId();

		tareaCacheModel.userId = getUserId();

		tareaCacheModel.userName = getUserName();

		String userName = tareaCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			tareaCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			tareaCacheModel.createDate = createDate.getTime();
		}
		else {
			tareaCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			tareaCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			tareaCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		tareaCacheModel.nombreTarea = getNombreTarea();

		String nombreTarea = tareaCacheModel.nombreTarea;

		if ((nombreTarea != null) && (nombreTarea.length() == 0)) {
			tareaCacheModel.nombreTarea = null;
		}

		tareaCacheModel.proyecto = getProyecto();

		String proyecto = tareaCacheModel.proyecto;

		if ((proyecto != null) && (proyecto.length() == 0)) {
			tareaCacheModel.proyecto = null;
		}

		tareaCacheModel.responsable = getResponsable();

		String responsable = tareaCacheModel.responsable;

		if ((responsable != null) && (responsable.length() == 0)) {
			tareaCacheModel.responsable = null;
		}

		tareaCacheModel.prioridad = getPrioridad();

		String prioridad = tareaCacheModel.prioridad;

		if ((prioridad != null) && (prioridad.length() == 0)) {
			tareaCacheModel.prioridad = null;
		}

		tareaCacheModel.sprint = getSprint();

		String sprint = tareaCacheModel.sprint;

		if ((sprint != null) && (sprint.length() == 0)) {
			tareaCacheModel.sprint = null;
		}

		tareaCacheModel.estado = getEstado();

		String estado = tareaCacheModel.estado;

		if ((estado != null) && (estado.length() == 0)) {
			tareaCacheModel.estado = null;
		}

		tareaCacheModel.fechaLimite = getFechaLimite();

		String fechaLimite = tareaCacheModel.fechaLimite;

		if ((fechaLimite != null) && (fechaLimite.length() == 0)) {
			tareaCacheModel.fechaLimite = null;
		}

		tareaCacheModel.resumen = getResumen();

		String resumen = tareaCacheModel.resumen;

		if ((resumen != null) && (resumen.length() == 0)) {
			tareaCacheModel.resumen = null;
		}

		tareaCacheModel.descripcion = getDescripcion();

		String descripcion = tareaCacheModel.descripcion;

		if ((descripcion != null) && (descripcion.length() == 0)) {
			tareaCacheModel.descripcion = null;
		}

		tareaCacheModel.categoria = getCategoria();

		String categoria = tareaCacheModel.categoria;

		if ((categoria != null) && (categoria.length() == 0)) {
			tareaCacheModel.categoria = null;
		}

		tareaCacheModel.etiqueta = getEtiqueta();

		String etiqueta = tareaCacheModel.etiqueta;

		if ((etiqueta != null) && (etiqueta.length() == 0)) {
			tareaCacheModel.etiqueta = null;
		}

		return tareaCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<Tarea, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<Tarea, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Tarea, Object> attributeGetterFunction = entry.getValue();

			sb.append("\"");
			sb.append(attributeName);
			sb.append("\": ");

			Object value = attributeGetterFunction.apply((Tarea)this);

			if (value == null) {
				sb.append("null");
			}
			else if (value instanceof Blob || value instanceof Date ||
					 value instanceof Map || value instanceof String) {

				sb.append(
					"\"" + StringUtil.replace(value.toString(), "\"", "'") +
						"\"");
			}
			else {
				sb.append(value);
			}

			sb.append(", ");
		}

		if (sb.index() > 1) {
			sb.setIndex(sb.index() - 1);
		}

		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		Map<String, Function<Tarea, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<Tarea, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Tarea, Object> attributeGetterFunction = entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((Tarea)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, Tarea>
			_escapedModelProxyProviderFunction =
				ProxyUtil.getProxyProviderFunction(
					Tarea.class, ModelWrapper.class);

	}

	private String _uuid;
	private long _tareaId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private String _nombreTarea;
	private String _proyecto;
	private String _responsable;
	private String _prioridad;
	private String _sprint;
	private String _estado;
	private String _fechaLimite;
	private String _resumen;
	private String _descripcion;
	private String _categoria;
	private String _etiqueta;

	public <T> T getColumnValue(String columnName) {
		columnName = _attributeNames.getOrDefault(columnName, columnName);

		Function<Tarea, Object> function = _attributeGetterFunctions.get(
			columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((Tarea)this);
	}

	public <T> T getColumnOriginalValue(String columnName) {
		if (_columnOriginalValues == null) {
			return null;
		}

		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		return (T)_columnOriginalValues.get(columnName);
	}

	private void _setColumnOriginalValues() {
		_columnOriginalValues = new HashMap<String, Object>();

		_columnOriginalValues.put("uuid_", _uuid);
		_columnOriginalValues.put("tareaId", _tareaId);
		_columnOriginalValues.put("groupId", _groupId);
		_columnOriginalValues.put("companyId", _companyId);
		_columnOriginalValues.put("userId", _userId);
		_columnOriginalValues.put("userName", _userName);
		_columnOriginalValues.put("createDate", _createDate);
		_columnOriginalValues.put("modifiedDate", _modifiedDate);
		_columnOriginalValues.put("nombreTarea", _nombreTarea);
		_columnOriginalValues.put("proyecto", _proyecto);
		_columnOriginalValues.put("responsable", _responsable);
		_columnOriginalValues.put("prioridad", _prioridad);
		_columnOriginalValues.put("sprint", _sprint);
		_columnOriginalValues.put("estado", _estado);
		_columnOriginalValues.put("fechaLimite", _fechaLimite);
		_columnOriginalValues.put("resumen", _resumen);
		_columnOriginalValues.put("descripcion", _descripcion);
		_columnOriginalValues.put("categoria", _categoria);
		_columnOriginalValues.put("etiqueta", _etiqueta);
	}

	private static final Map<String, String> _attributeNames;

	static {
		Map<String, String> attributeNames = new HashMap<>();

		attributeNames.put("uuid_", "uuid");

		_attributeNames = Collections.unmodifiableMap(attributeNames);
	}

	private transient Map<String, Object> _columnOriginalValues;

	public static long getColumnBitmask(String columnName) {
		return _columnBitmasks.get(columnName);
	}

	private static final Map<String, Long> _columnBitmasks;

	static {
		Map<String, Long> columnBitmasks = new HashMap<>();

		columnBitmasks.put("uuid_", 1L);

		columnBitmasks.put("tareaId", 2L);

		columnBitmasks.put("groupId", 4L);

		columnBitmasks.put("companyId", 8L);

		columnBitmasks.put("userId", 16L);

		columnBitmasks.put("userName", 32L);

		columnBitmasks.put("createDate", 64L);

		columnBitmasks.put("modifiedDate", 128L);

		columnBitmasks.put("nombreTarea", 256L);

		columnBitmasks.put("proyecto", 512L);

		columnBitmasks.put("responsable", 1024L);

		columnBitmasks.put("prioridad", 2048L);

		columnBitmasks.put("sprint", 4096L);

		columnBitmasks.put("estado", 8192L);

		columnBitmasks.put("fechaLimite", 16384L);

		columnBitmasks.put("resumen", 32768L);

		columnBitmasks.put("descripcion", 65536L);

		columnBitmasks.put("categoria", 131072L);

		columnBitmasks.put("etiqueta", 262144L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private Tarea _escapedModel;

}