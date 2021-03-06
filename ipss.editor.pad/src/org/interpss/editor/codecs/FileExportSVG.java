package org.interpss.editor.codecs;
/*
 * @(#)FileExportJPG.java 1.2 01.02.2003
 * 
 * Copyright (C) 2001-2004 Gaudenz Alder
 * 
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation; either version 2 of the License, or (at your option) any later
 * version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 * 
 * You should have received a copy of the GNU General Public License along with
 * this program; if not, write to the Free Software Foundation, Inc., 59 Temple
 * Place - Suite 330, Boston, MA 02111-1307, USA.
 *  
 */

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.geom.Rectangle2D;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

import org.apache.batik.dom.GenericDOMImplementation;
import org.apache.batik.svggen.SVGGraphics2D;
import org.interpss.editor.coreframework.actions.IpssAbstractGraphActionFile;
import org.interpss.editor.resources.Translator;
import org.jgraph.JGraph;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;


/**
 * Export Jgraphpad pictures as SVG. WARNING, JGRAPHPAD GPL AND APACHE
 * BATIK LICENCES CLASH. IF YOU ARE DISTRIBUTING A GPL JGRAPHPAD VERSION, THEN
 * YOU CAN'T DISTRIBUTE IT WITH THIS FILE. BUT YOU CAN DISTRIBUTE THIS AS A
 * SEPARATED PLUGIN, OR USE LINK IT FOR YOUR OWN USE OR SERVER SIDE USE.
 * FINALLY, IF YOU ACHIEVE TO ONLY USE A LGPL JGRAPHPAD MINIMAL DISTRIBUTION,
 * THEN YOU COULD LINK THIS FILE IN THE DISTRIBUTION. IT'S A SHAME APACHE AND
 * GPL LICENSE ARE INCOMPATIBLES...
 */
public class FileExportSVG extends IpssAbstractGraphActionFile {

	protected transient String fileType = "svg";
	/**
	 * @see java.awt.event.ActionListener#actionPerformed(ActionEvent)
	 */
	public void actionPerformed(ActionEvent e) {
		try {
			String file =
				saveDialog(
					Translator.getString("FileSaveAsLabel") + " "+fileType.toUpperCase(),
					fileType.toLowerCase(),
					fileType.toUpperCase()+" Image");
			if (file == null) return;
			
			
			JGraph graph = getCurrentGraph();
			Object[] cells = graph.getDescendants(graph.getRoots());
			if (cells.length > 0 && file != null && file.length() > 0) {
				Rectangle2D bounds = graph.getCellBounds(cells);
				graph.toScreen(bounds);
				Dimension d = bounds.getBounds().getSize();

				Object[] selection = graph.getSelectionCells();
				boolean gridVisible = graph.isGridVisible();
				boolean doubleBuffered = graph.isDoubleBuffered();
				graph.setGridVisible(false);
				graph.setDoubleBuffered(false);
				graph.clearSelection();

				FileOutputStream fos = new FileOutputStream(file);
				// Created writer with UTF-8 encoding
				Writer out = new OutputStreamWriter(fos, "UTF-8");
				// Get a DOMImplementation
				DOMImplementation domImpl =
					GenericDOMImplementation.getDOMImplementation();
				// Create an instance of org.w3c.dom.Document
				Document document = domImpl.createDocument(null, "svg", null);
				// Create an instance of the SVG Generator
				SVGGraphics2D g2 = new SVGGraphics2D(document);
				// Render into the SVG Graphics2D implementation
				graph.paint(g2);
				// Use CSS style attribute
				boolean useCSS = true;
				// Finally, stream out SVG to the writer
				g2.stream(out, useCSS);

				g2.setColor(graph.getBackground());
				g2.fillRect(0, 0, d.width + 10, d.height + 10);
				g2.translate(-bounds.getX() + 5, -bounds.getY() + 5);

				graph.paint(g2);

				graph.setSelectionCells(selection);
				graph.setGridVisible(gridVisible);
				graph.setDoubleBuffered(doubleBuffered);

				// Close the file output stream
				fos.flush();
				fos.close();
			}
		} catch (IOException ex) {
			graphpad.error(ex.getMessage());
		}
	}

}
