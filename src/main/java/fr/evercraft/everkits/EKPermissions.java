/*
 * This file is part of EverKits.
 *
 * EverKits is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * EverKits is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with EverKits.  If not, see <http://www.gnu.org/licenses/>.
 */
package fr.evercraft.everkits;

import fr.evercraft.everapi.plugin.EnumPermission;
import fr.evercraft.everapi.plugin.file.EnumMessage;
import fr.evercraft.everkits.EKMessage.EKMessages;

public enum EKPermissions implements EnumPermission {
	EVERKITS("commands.execute", EKMessages.PERMISSIONS_COMMANDS_EXECUTE),
	HELP("commands.help", EKMessages.PERMISSIONS_COMMANDS_HELP),
	RELOAD("commands.reload", EKMessages.PERMISSIONS_COMMANDS_RELOAD);
	
	private static final String PREFIX = "everkits";
	
	private final String permission;
	private final EnumMessage message;
	private final boolean value;
    
    private EKPermissions(final String permission, final EnumMessage message) {
    	this(permission, message, false);
    }
    
    private EKPermissions(final String permission, final EnumMessage message, final boolean value) {   	    	
    	this.permission = PREFIX + "." + permission;
    	this.message = message;
    	this.value = value;
    }

    @Override
    public String get() {
    	return this.permission;
	}

	@Override
	public boolean getDefault() {
		return this.value;
	}

	@Override
	public EnumMessage getMessage() {
		return this.message;
	}
}
