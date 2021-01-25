package MEDMEX.command.impl;

import MEDMEX.Client;
import MEDMEX.command.Command;

public class Toggle extends Command {
	
	public Toggle() {
		super("Toggle", "toggles a module by name.", "Toggle <name>", "t");
		
	}

	@Override
	public void onCommand(String[] args, String command) {
		if(args.length > 0) {
			String moduleName = args[0];
			
			boolean foundModule = false;
			
			for(MEDMEX.modules.Module module : Client.modules){
				if(module.name.equalsIgnoreCase(moduleName)) {
					module.toggle();
					
					Client.addChatMessage((module.isEnabled() ? "Enabled" : "Disabled") + " " + module.name);
					
					foundModule = true;
					break;
					
				}
			}
			if(!foundModule) {
				Client.addChatMessage("Could not find module.");
			}
		}
		
	}

}
