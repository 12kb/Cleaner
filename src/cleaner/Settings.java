package cleaner;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class Settings {

	private Path settingsFile;
	private Properties settings;

	public Settings(String filename){
		if (filename != null){
			
			try{
				InputStream input = null;
				settingsFile = Paths.get(filename);
				
				if (Files.exists(settingsFile)){
					input = Files.newInputStream(settingsFile);
				}else{
					System.err.println("���� �������� �� ������.");
					//TODO ������� ���������� �� ������� ����
				}
				settings.load(input);
			}catch(InvalidPathException e){
				String message = "���� � ����� �������� ����� � �������� �������.";
				System.err.println(message);
				e.printStackTrace();
				//TODO: ������� ���������� �� ������� ����
			}catch(IOException e){
				String message = "������ ������ ����� ��������.";
				System.err.println(message);
				e.printStackTrace();
				//TODO: ������� ���������� �� ������� ����
			}
			
			
		}
		
	}
}
