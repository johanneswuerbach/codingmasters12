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

public class RawIterator implements Iterator<RawTweet> {

	private final Iterator<File> _files;
	private String _filter;
	
	private BufferedReader _bufferedReader;
	private RawTweet _currentLine;
	private String _currentFile;
	

	public RawIterator(String[] directoryNames) {
		ArrayList<File> files = new ArrayList<File>();
		for (String name : directoryNames) {
			File directory = new File(name);
			files.addAll(listSourceFiles(directory));
		}
		_files = files.iterator();
	}
	
	public RawIterator(String[] directoryNames, String filter) {
		this(directoryNames);
		_filter = filter;
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
			_currentFile = file.getAbsolutePath();
			
			FileInputStream is = new FileInputStream(file);
			GZIPInputStream gzis = new GZIPInputStream(is);
			InputStreamReader reader = new InputStreamReader(gzis, "UTF-8");
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
	
	public RawTweet nextRaw() {
		String line = nextLine();
		if (line == null) {
			return null;
		}
		
		if (_filter != null && !line.matches(_filter)) {
			return nextRaw();
		}
		else {
			return new RawTweet(nextLine(), _currentFile);
		}
	}

	public boolean hasNext() {
		_currentLine = nextRaw();
		return _currentLine != null;
	}

	public RawTweet next() {
		if (_currentLine != null) {
			RawTweet line = _currentLine;
			_currentLine = null;
			return line;
		} else {
			return nextRaw();
		}
	}

	public void remove() {
		// Read only data
	}

}
