package fp.utiles;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Ficheros {
	public static Stream<String> leeFichero(String path){
		Stream<String> result=Stream.of();
		try {
			result=Files.lines(Paths.get(path)).skip(1);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}
