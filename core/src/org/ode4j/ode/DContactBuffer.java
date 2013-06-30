/*************************************************************************
 *                                                                       *
 * Open Dynamics Engine, Copyright (C) 2001,2002 Russell L. Smith.       *
 * All rights reserved.  Email: russ@q12.org   Web: www.q12.org          *
 * Open Dynamics Engine 4J, Copyright (C) 2007-2010 Tilmann Zäschke      *
 * All rights reserved.  Email: ode4j@gmx.de   Web: www.ode4j.org        *
 *                                                                       *
 * This library is free software; you can redistribute it and/or         *
 * modify it under the terms of EITHER:                                  *
 *   (1) The GNU Lesser General Public License as published by the Free  *
 *       Software Foundation; either version 2.1 of the License, or (at  *
 *       your option) any later version. The text of the GNU Lesser      *
 *       General Public License is included with this library in the     *
 *       file LICENSE.TXT.                                               *
 *   (2) The BSD-style license that is included with this library in     *
 *       the file ODE-LICENSE-BSD.TXT and ODE4J-LICENSE-BSD.TXT.         *
 *                                                                       *
 * This library is distributed in the hope that it will be useful,       *
 * but WITHOUT ANY WARRANTY; without even the implied warranty of        *
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the files    *
 * LICENSE.TXT, ODE-LICENSE-BSD.TXT and ODE4J-LICENSE-BSD.TXT for more   *
 * details.                                                              *
 *                                                                       *
 *************************************************************************/
package org.ode4j.ode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;


/**
 * A collection of DContact objects.
 *
 * @ingroup collide
 */
public class DContactBuffer implements Iterable<DContact> {
	
	private ArrayList<DContact> _buf = new ArrayList<DContact>();

	public DContactBuffer(int size) {
		for (int i = 0; i < size; i++) {
			_buf.add(new DContact());
		}
	}
	
	public DContact get(int i) {
		return _buf.get(i);
	}
	
	public DContactGeomBuffer getGeomBuffer() {
		return new DContactGeomBuffer(this);
	}

	@Override
	public Iterator<DContact> iterator() {
		return Collections.unmodifiableList(_buf).iterator();
	}
}