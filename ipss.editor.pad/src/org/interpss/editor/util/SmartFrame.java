/*
 * @(#)SmartFrame.java 1.0 06.08.2003
 *
 * Copyright (C) 2003 sven_luzar
 *
 * 6/01/2006: I, Raphpael Valyi, changed back the header of this file to LGPL
 * because nobody changed the file significantly since the last
 * 3.0 version of GPGraphpad that was LGPL. By significantly, I mean: 
 *  - less than 3 instructions changes could honnestly have been done from an old fork,
 *  - license or copyright changes in the header don't count
 *  - automaticaly updating imports don't count,
 *  - updating systematically 2 instructions to a library specification update don't count.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.

 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.

 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
 *
 */
package org.interpss.editor.util;

import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.KeyStroke;

import org.interpss.editor.resources.LocaleChangeAdapter;


/**
 * One Layer between the JDialog 
 * and our implementation. 
 * Currently we add a load and store 
 * management for the window position.
 * and a locale change listener support
 */
public class SmartFrame extends JFrame {

	/** Key description for the ESC key.
	 * 
	 */
	protected KeyStroke escKeystroke =
		KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0);

	/** Calls the super constructor
	 *  and adds the instance to the position manager
	 *  and the locale change adapter
	 * 
	 * @throws java.awt.HeadlessException
	 */
	public SmartFrame() throws HeadlessException {
		super();
		initFrame();
	}

	/** Calls the super constructor
	 *  and adds the instance to the position manager
	 *  and the locale change adapter
	 * 
	 * @param gc
	 */
	public SmartFrame(GraphicsConfiguration gc) {
		super(gc);
		initFrame();
	}

	/** Calls the super constructor
	 *  and adds the instance to the position manager
	 *  and the locale change adapter
	 * 
	 * @param title
	 * @throws java.awt.HeadlessException
	 */
	public SmartFrame(String title) throws HeadlessException {
		super(title);
		initFrame();
	}

	/** Calls the super constructor
	 *  and adds the instance to the position manager
	 *  and the locale change adapter
	 * 
	 * @param title
	 * @param gc
	 */
	public SmartFrame(String title, GraphicsConfiguration gc) {
		super(title, gc);
		initFrame();
	}
	/**
	 *  Adds the instance to the position manager and to
	 *  the locale change adapter. 
	 *  Registers the default esc action.
	 * 
	 */
	
	private void initFrame(){
		LocaleChangeAdapter.addContainer(this);
		PositionManager.addComponent(this);
		//registerDefaultEscAction();		
	}

	/** Removes the current instance from the  
	 *  position manager and from
	 *  the locale change adapter.
	 *  After that the method calls
	 *  the super implementation. 
	 *  
	 * @see java.lang.Object#finalize()
	 */

	protected void finalize() throws Throwable {
		LocaleChangeAdapter.removeContainer(this);
		PositionManager.removeComponent(this);
		super.finalize();
	}

	/** Calls the super implementation
	 *  and makes an update for the
	 *  component by using the locale
	 *  change adapter and the 
	 *  position manager.
	 *  
	 *  @param name the new name
	 *  @see java.awt.Component#setName(java.lang.String)
	 */
	public void setName(String name) {
		super.setName(name);
		PositionManager.updateComponent(this);
		LocaleChangeAdapter.updateComponent(this);
	}

	/** makes an update for the locale
	 *  dependent values from the whole
	 *  container and calls
	 *  the super implementation 
	 *  
	 * @see java.awt.Component#validate()
	 * @see java.awt.Component#validate()
	 */
	public void validate() {
		LocaleChangeAdapter.updateContainer(this);
		super.validate();
	}

	/** Registers the default 
	 *  window esc action for this
	 *  frame. 
	 * 
	 *  @see EscAction
	 *  
	 */
	public void registerDefaultEscAction() {
		registerEscAction(new EscAction());
	}

	/** Registers the specified
	 *  action for a esc action 
	 *  of this frame. 
	 * 
	 *  @param action the action 
	 *  
	 */
	public void registerEscAction(Action action) {
		this.getRootPane().registerKeyboardAction(
			action,
			escKeystroke,
			JComponent.WHEN_IN_FOCUSED_WINDOW);
	}

	/** Unregisters the esc action 
	 *  of this frame. 
	 *  
	 */
	public void unregisterEscAction() {
		this.getRootPane().unregisterKeyboardAction(escKeystroke);

	}

	/** Registers the specified button
	 *  for the default esc button.
	 * 
	 * @param button
	 */	
	public void setEscButton(JButton button){
		registerEscAction(new EscAction(button));
	}
	
	/** Registers the specified button
	 *  for the default button.
	 * 
	 * @param button
	 */	
	public void setDefaultButton(JButton button){
		getRootPane().setDefaultButton(button);
	}

}
