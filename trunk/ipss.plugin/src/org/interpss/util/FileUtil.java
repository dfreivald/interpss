/*
 * @(#)FileUtil.java   
 *
 * Copyright (C) 2006-2008 www.interpss.com
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU LESSER GENERAL PUBLIC LICENSE
 * as published by the Free Software Foundation; either version 2.1
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * @Author Mike Zhou
 * @Version 1.0
 * @Date 01/30/2008
 * 
 *   Revision History
 *   ================
 *
 */

package org.interpss.util;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;

import com.interpss.common.util.IpssLogger;

public class FileUtil {
	/**
	 * Write the text to the file
	 * 
	 * @param filename filename
	 * @param textArea
	 * @return
	 */
	public static boolean writeText2File(String filename, String text) {
		IpssLogger.getLogger().info("FileUtil.writeTextarea2File() info to file: " + filename);
		try {
			OutputStream out = new BufferedOutputStream(new FileOutputStream(filename));
			out.write(text.getBytes());
			out.flush();
			out.close();
			return true;
		} catch (Exception e) {
			IpssLogger.getLogger().severe("Cannot save to file: " + filename + ", " + e.toString());
		}
		return false;
	}
}
