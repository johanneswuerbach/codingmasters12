package challenge1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.zip.GZIPInputStream;

public class StringIterator implements Iterator<String> {

	private Iterator<File> _files;
	private BufferedReader _bufferedReader;
	private String _nextLine;

	public StringIterator(String directoryName) {
		File directory = new File(directoryName);
		_files = listSourceFiles(directory).iterator();
	}

	public ArrayList<File> listSourceFiles(final File directory) {
		ArrayList<File> files = new ArrayList<File>();
		for (final File fileEntry : directory.listFiles()) {
			if (fileEntry.isDirectory()) {
				files.addAll(listSourceFiles(fileEntry));
			} else {
				String name = fileEntry.getAbsolutePath();
				if (name.endsWith("tw.gz")) {
					files.add(new File(name));
				}
			}
		}
		return files;
	}
	
	
	private BufferedReader nextFile() {
		if (!_files.hasNext()) {
			return null;
		}
		
		try {
			File file = _files.next();
			FileInputStream is = new FileInputStream(file);
			GZIPInputStream gzis = new GZIPInputStream(is);
			InputStreamReader reader = new InputStreamReader(gzis);
			return new BufferedReader(reader);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			// Try to open the next file
			return nextFile();
		} catch (IOException e) {
			e.printStackTrace();
			// Try to open the next file
			return nextFile();
		}
	}

	private String nextLine() {

		try {
			String line;
			if (_bufferedReader == null || (line = _bufferedReader.readLine()) == null) {
				_bufferedReader = nextFile();
				if (_bufferedReader == null) {
					return null;
				}
				return _bufferedReader.readLine();
			}
			else {
				return line;
			}
			
		} catch (IOException e) {
			e.printStackTrace();
			// Try next line
			return nextLine();
		}
	}

	public boolean hasNext() {
		_nextLine = nextLine();
		return _nextLine != null;
	}

	public String next() {
		if (_nextLine != null) {
			String line = _nextLine;
			_nextLine = null;
			return line;
		} else {
			return nextLine();
		}
	}

	public void remove() {
		// Read only data
	}

}
