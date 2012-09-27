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

	private String nextLine() {

		try {
			if (_bufferedReader != null) {
				String line = _bufferedReader.readLine();
				if (line != null) {
					return line;
				}
			}
			

			if (!_files.hasNext()) {
				return null;
			}

			File file = _files.next();
			FileInputStream is = new FileInputStream(file);
			GZIPInputStream gzis = new GZIPInputStream(is);
			InputStreamReader reader = new InputStreamReader(gzis);
			_bufferedReader = new BufferedReader(reader);
			return nextLine();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public boolean hasNext() {
		_nextLine = nextLine();
		return _nextLine != null;
	}

	public String next() {
		if (_nextLine != null) {
			_nextLine = null;
			return _nextLine;
		} else {
			return nextLine();
		}
	}

	public void remove() {
		// Read only data
	}

}
