/**
 *  Copyright (c) 2015-2017 Angelo ZERR.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *
 *  Contributors:
 *  Angelo Zerr <angelo.zerr@gmail.com> - initial API and implementation
 */
package org.eclipse.tm4e.core.internal.css;

import org.w3c.css.sac.CombinatorCondition;
import org.w3c.css.sac.Condition;

public abstract class AbstractCombinatorCondition implements CombinatorCondition, ExtendedCondition {
	protected Condition firstCondition;

	protected Condition secondCondition;

	/**
	 * Creates a new CombinatorCondition object.
	 */
	protected AbstractCombinatorCondition(Condition c1, Condition c2) {
		firstCondition = c1;
		secondCondition = c2;
	}

	@Override
	public Condition getFirstCondition() {
		return firstCondition;
	}

	@Override
	public Condition getSecondCondition() {
		return secondCondition;
	}

	public int getSpecificity() {
		return ((ExtendedCondition) getFirstCondition()).getSpecificity()
				+ ((ExtendedCondition) getSecondCondition()).getSpecificity();
	}
}