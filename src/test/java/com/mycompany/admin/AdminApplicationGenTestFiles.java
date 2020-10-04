package com.mycompany.admin;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

class AdminApplicationGenTestFiles {

	// Use this class to copy a test file X number of times in the same directory, to create a large volume of files to test with
	// Choose your own path and update the path accordingly
	public static void main(String[] args) throws IOException {
		long start = System.currentTimeMillis();

		// Path of test file to duplicate
		File original = new File("/home/torra/tmp/file0.txt");
		Path originalPath = original.toPath();

		for (int i = 0; i < 50; i++) {
			Path copied = Paths.get("/home/torra/tmp/file0" + i + ".txt");
			Files.copy(originalPath, copied, StandardCopyOption.REPLACE_EXISTING);

		}
		long stop = System.currentTimeMillis();
		System.out.println( "Elapsed: " + (stop - start) + " ms" );
	}

}
