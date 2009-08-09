/*******************************************************************************
 * This program and the accompanying materials
 * are made available under the terms of the Common Public License v1.0
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/cpl-v10.html
 * 
 * Contributors:
 *     Peter Smith
 *******************************************************************************/
package org.boris.winrun4j;

/**
 * A mechanism for adding events.
 */
public class EventLog
{
    public static final int SUCCESS = 0x0000;
    public static final int ERROR = 0x0001;
    public static final int WARNING = 0x0002;
    public static final int INFORMATION = 0x0004;
    public static final int AUDIT_SUCCESS = 0x0008;
    public static final int AUDIT_FAILURE = 0x0010;

    /**
     * Report an event.
     * 
     * @param source.
     * @param type.
     * @param msg.
     * 
     * @return boolean.
     */
    public static boolean report(String source, int type, String msg) {
        return false;
    }
}
