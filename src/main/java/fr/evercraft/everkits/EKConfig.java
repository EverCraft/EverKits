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

import java.util.Arrays;
import java.util.List;

import fr.evercraft.everapi.plugin.file.EConfig;

public class EKConfig extends EConfig<EverKits> {

	public EKConfig(final EverKits plugin) {
		super(plugin);
	}
	
	public void reload() {
		super.reload();
		this.plugin.getELogger().setDebug(this.isDebug());
	}
	
	@Override
	public List<String> getHeader() {
		return 	Arrays.asList(	"####################################################### #",
								"                   EverKits (By rexbut)                  #",
								"    For more information : https://docs.evercraft.fr     #",
								"####################################################### #");
	}
	
	@Override
	public void loadDefault() {
		this.configDefault();
	}
}
