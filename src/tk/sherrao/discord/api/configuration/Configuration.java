package tk.sherrao.discord.api.configuration;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Configuration {

	private File file;
	private Path path;
	private BufferedReader in;
	private BufferedWriter out;
	
	private Gson gson;
	private JsonParser parser;
	
	private JsonObject json;
	private Map<String, JsonElement> config; 
	
	public Configuration( final String filePath ) {
		this( new File( filePath ) );
		
	}
	
	public Configuration( final String folderPath, final String filename ) {
		this( new File( folderPath, filename ) );
		
	}
	
	public Configuration( final File file ) {
        try {
            this.file = file;
			this.path = Paths.get( file.getPath() );
			this.in = Files.newBufferedReader( path );
            this.out = Files.newBufferedWriter( path, StandardOpenOption.WRITE, StandardOpenOption.APPEND );		
			
			this.gson = new GsonBuilder()
					.serializeNulls()
					.setPrettyPrinting()
					.setLenient()
					.setFieldNamingPolicy( FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES )
					.create();		
			
			this.parser = new JsonParser();

        } catch ( IOException e ) { 
            e.printStackTrace(); 
            
        }            
	}

	public void loadValues( boolean async ) {
		this.json = parser.parse( in ).getAsJsonObject();
		this.config = Collections.synchronizedMap( new HashMap<String, JsonElement>() );
		
		
	}
	
	public final File getFile() {
		return file;
		
	}
	
	public final Path getPath() {
		return path;
		
	}
	
	public final String getStringPath() {
		return file.getPath();
		
	}

}