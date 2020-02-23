package tk.sherrao.discord.api;

import javax.security.auth.login.LoginException;

import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.OnlineStatus;
import tk.sherrao.logging.Logger;

public class Bot {

	private final BotWrapper wrapper;
	private final JDA jda;
	
	protected final Logger audioLogger;
	protected final Logger ioLogger;
	protected final Logger commandsLogger;
	protected final Logger eventsLogger;
	
	public Bot( final BotWrapper wrapper ) throws LoginException, InterruptedException {
		this.wrapper = wrapper;
		this.jda = new JDABuilder( AccountType.BOT )
				.setAudioEnabled( true )
				.setStatus( OnlineStatus.ONLINE )
				.setEnableShutdownHook( true ) 
				.setToken( "" )
				.setIdle( false )
				.setMaxReconnectDelay(32)
				.buildBlocking();
		
		this.audioLogger = new Logger( "Audio System" );
		this.ioLogger = new Logger( "I/O" );
		this.commandsLogger = new Logger( "Command Executor" );
		this.eventsLogger = new Logger( "Events Manager" );
		
	}
	
}