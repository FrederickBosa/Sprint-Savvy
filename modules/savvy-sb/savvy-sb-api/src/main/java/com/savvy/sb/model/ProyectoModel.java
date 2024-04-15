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

package com.savvy.sb.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.GroupedModel;
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.model.StagedAuditedModel;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the Proyecto service. Represents a row in the &quot;Servicio_Savvy_Proyecto&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.savvy.sb.model.impl.ProyectoModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.savvy.sb.model.impl.ProyectoImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Proyecto
 * @generated
 */
@ProviderType
public interface ProyectoModel
	extends BaseModel<Proyecto>, GroupedModel, ShardedModel,
			StagedAuditedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a proyecto model instance should use the {@link Proyecto} interface instead.
	 */

	/**
	 * Returns the primary key of this proyecto.
	 *
	 * @return the primary key of this proyecto
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this proyecto.
	 *
	 * @param primaryKey the primary key of this proyecto
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this proyecto.
	 *
	 * @return the uuid of this proyecto
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this proyecto.
	 *
	 * @param uuid the uuid of this proyecto
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the proyecto ID of this proyecto.
	 *
	 * @return the proyecto ID of this proyecto
	 */
	public long getProyectoId();

	/**
	 * Sets the proyecto ID of this proyecto.
	 *
	 * @param proyectoId the proyecto ID of this proyecto
	 */
	public void setProyectoId(long proyectoId);

	/**
	 * Returns the group ID of this proyecto.
	 *
	 * @return the group ID of this proyecto
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this proyecto.
	 *
	 * @param groupId the group ID of this proyecto
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this proyecto.
	 *
	 * @return the company ID of this proyecto
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this proyecto.
	 *
	 * @param companyId the company ID of this proyecto
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this proyecto.
	 *
	 * @return the user ID of this proyecto
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this proyecto.
	 *
	 * @param userId the user ID of this proyecto
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this proyecto.
	 *
	 * @return the user uuid of this proyecto
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this proyecto.
	 *
	 * @param userUuid the user uuid of this proyecto
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this proyecto.
	 *
	 * @return the user name of this proyecto
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this proyecto.
	 *
	 * @param userName the user name of this proyecto
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this proyecto.
	 *
	 * @return the create date of this proyecto
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this proyecto.
	 *
	 * @param createDate the create date of this proyecto
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this proyecto.
	 *
	 * @return the modified date of this proyecto
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this proyecto.
	 *
	 * @param modifiedDate the modified date of this proyecto
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the titulo proyecto of this proyecto.
	 *
	 * @return the titulo proyecto of this proyecto
	 */
	@AutoEscape
	public String getTituloProyecto();

	/**
	 * Sets the titulo proyecto of this proyecto.
	 *
	 * @param tituloProyecto the titulo proyecto of this proyecto
	 */
	public void setTituloProyecto(String tituloProyecto);

	/**
	 * Returns the descripcion of this proyecto.
	 *
	 * @return the descripcion of this proyecto
	 */
	@AutoEscape
	public String getDescripcion();

	/**
	 * Sets the descripcion of this proyecto.
	 *
	 * @param descripcion the descripcion of this proyecto
	 */
	public void setDescripcion(String descripcion);

	/**
	 * Returns the fecha inicio of this proyecto.
	 *
	 * @return the fecha inicio of this proyecto
	 */
	@AutoEscape
	public String getFechaInicio();

	/**
	 * Sets the fecha inicio of this proyecto.
	 *
	 * @param fechaInicio the fecha inicio of this proyecto
	 */
	public void setFechaInicio(String fechaInicio);

	/**
	 * Returns the fecha final of this proyecto.
	 *
	 * @return the fecha final of this proyecto
	 */
	@AutoEscape
	public String getFechaFinal();

	/**
	 * Sets the fecha final of this proyecto.
	 *
	 * @param fechaFinal the fecha final of this proyecto
	 */
	public void setFechaFinal(String fechaFinal);

	/**
	 * Returns the estado of this proyecto.
	 *
	 * @return the estado of this proyecto
	 */
	@AutoEscape
	public String getEstado();

	/**
	 * Sets the estado of this proyecto.
	 *
	 * @param estado the estado of this proyecto
	 */
	public void setEstado(String estado);

}