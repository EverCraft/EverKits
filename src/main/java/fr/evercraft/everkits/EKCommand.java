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

import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.text.Text;

import fr.evercraft.everapi.plugin.command.EParentCommand;
import fr.evercraft.everkits.EKMessage.EKMessages;

public class EKCommand extends EParentCommand<EverKits> {
	
	public EKCommand(final EverKits plugin) {
        super(plugin, "everkits");
    }
	
	@Override
	public boolean testPermission(final CommandSource source) {
		return source.hasPermission(EKPermissions.EVERKITS.get());
	}

	@Override
	public Text description(final CommandSource source) {
		return EKMessages.DESCRIPTION.getText();
	}

	@Override
	public boolean testPermissionHelp(final CommandSource source) {
		return source.hasPermission(EKPermissions.HELP.get());
	}
}
