package tk.sherrao.discord.api;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public final class BotWrapper {

	private String name;
	private Bot bot;
	
	private final File workspace;
	
	public BotWrapper( String name ) 
			throws UnsupportedEncodingException {
		this.name = name;
		
		this.workspace = new File( URLDecoder.decode( new File( super.getClass().getProtectionDomain().getCodeSource().getLocation().getPath() ).getParent(), "UTF-8" ) );
		
	}
	
	public final void load() {
		
	}
	
	public final Bot start() {
		return bot;
		
	}
	
	public final String getName() {
		return name; 
		
	}
	
}