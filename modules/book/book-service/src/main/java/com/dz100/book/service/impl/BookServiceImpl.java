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

package com.dz100.book.service.impl;

import com.dz100.book.service.BookLocalServiceUtil;
import com.dz100.book.service.base.BookServiceBaseImpl;

import com.liferay.portal.aop.AopService;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the book remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.dz100.book.service.BookService</code> interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BookServiceBaseImpl
 */
@Component(
	property = {
		"json.web.service.context.name=dz", "json.web.service.context.path=Book"
	},
	service = AopService.class
)
public class BookServiceImpl extends BookServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use <code>com.dz100.book.service.BookServiceUtil</code> to access the book remote service.
	 */

	private static Log log = LogFactoryUtil.getLog(BookServiceImpl.class);
	public void addBook(String title, String author, double price){
		BookLocalServiceUtil.addBook(title, author, price);
		log.info("添加《" + title + "》成功");
	}
}