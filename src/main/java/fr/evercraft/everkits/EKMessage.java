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

import com.google.common.base.Preconditions;

import fr.evercraft.everapi.message.EMessageFormat;
import fr.evercraft.everapi.message.format.EFormatString;
import fr.evercraft.everapi.plugin.file.EMessage;
import fr.evercraft.everapi.plugin.file.EnumMessage;

public class EKMessage extends EMessage<EverKits> {

	public EKMessage(final EverKits plugin) {
		super(plugin, EKMessages.values());
	}
	
	public enum EKMessages implements EnumMessage {
		PREFIX("prefix",  							
				"[&4Ever&6&lKits&f] "),
		DESCRIPTION("description", 
				"Gestionnaire des kits");
		
		private final String path;
	    private final EMessageFormat french;
	    private final EMessageFormat english;
	    private EMessageFormat message;
	    
	    private EKMessages(final String path, final String french) {   	
	    	this(path, 
	    		EMessageFormat.builder().chat(new EFormatString(french), true).build(), 
	    		EMessageFormat.builder().chat(new EFormatString(french), true).build());
	    }
	    
	    private EKMessages(final String path, final String french, final String english) {   	
	    	this(path, 
	    		EMessageFormat.builder().chat(new EFormatString(french), true).build(), 
	    		EMessageFormat.builder().chat(new EFormatString(english), true).build());
	    }
	    
	    private EKMessages(final String path, final EMessageFormat french) {   	
	    	this(path, french, french);
	    }
	    
	    private EKMessages(final String path, final EMessageFormat french, final EMessageFormat english) {
	    	Preconditions.checkNotNull(french, "Le message '" + this.name() + "' n'est pas définit");
	    	
	    	this.path = path;	    	
	    	this.french = french;
	    	this.english = english;
	    	this.message = french;
	    }

	    public String getName() {
			return this.name();
		}
	    
		public String getPath() {
			return this.path;
		}

		public Object getFrench() {
			return this.french;
		}

		public Object getEnglish() {
			return this.english;
		}
		
		public EMessageFormat getMessage() {
			return this.message;
		}
		
		public void set(EMessageFormat message) {
			this.message = message;
		}
	}
}
