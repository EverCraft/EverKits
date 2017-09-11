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

import org.spongepowered.api.plugin.Dependency;
import org.spongepowered.api.plugin.Plugin;

import fr.evercraft.everapi.EverAPI;
import fr.evercraft.everapi.exception.PluginDisableException;
import fr.evercraft.everapi.exception.ServerDisableException;
import fr.evercraft.everapi.plugin.EPlugin;
import fr.evercraft.everkits.command.sub.EKReload;

@Plugin(id = "everkits", 
		name = "EverKits", 
		version = EverAPI.VERSION, 
		description = "Manage Kit",
		url = "http://evercraft.fr/",
		authors = {"rexbut"},
		dependencies = {
		    @Dependency(id = "everapi", version = EverAPI.VERSION),
		    @Dependency(id = "spongeapi", version = EverAPI.SPONGEAPI_VERSION)
		})
public class EverKits extends EPlugin<EverKits> {
	private EKConfig configs;
	
	private EKMessage messages;
	
	@Override
	protected void onPreEnable() {		
		this.configs = new EKConfig(this);
		
		this.messages = new EKMessage(this);
		
		this.getGame().getEventManager().registerListeners(this, new EKListener(this));
	}
	
	@Override
	protected void onCompleteEnable() {
		EKCommand command = new EKCommand(this);
		
		command.add(new EKReload(this, command));
	}

	protected void onReload() throws PluginDisableException, ServerDisableException {
		super.onReload();
	}
	
	protected void onDisable() {
	}

	/*
	 * Accesseurs
	 */
	
	public EKMessage getMessages(){
		return this.messages;
	}
	
	public EKConfig getConfigs() {
		return this.configs;
	}
}
