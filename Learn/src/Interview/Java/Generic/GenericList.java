package Interview.Java.Generic;

import java.io.File;
import java.util.*;

import org.jodconverter.JodConverter;
import org.jodconverter.LocalConverter;
import org.jodconverter.office.LocalOfficeManager;
import org.jodconverter.office.OfficeUtils;

public class GenericList {

	public static void main(String[] args) {

		File inputFile = new File("C:\\Users\\hhemr\\OneDrive\\Desktop\\test.xlsx");
		File outputFile = new File("C:\\Users\\hhemr\\OneDrive\\Desktop\\testPdf.pdf");

		// Create an office manager using the default configuration.
		// The default port is 2002. Note that when an office manager
		// is installed, it will be the one used by default when
		// a converter is created.
		final LocalOfficeManager officeManager = LocalOfficeManager.install();
		try {

			officeManager.start();

			MyFilter filter = new MyFilter();
			LocalConverter.builder().filterChain(filter).build().convert(inputFile).to(outputFile).execute();

			// Convert
//			JodConverter.convert(inputFile).to(outputFile).execute();

			File outputFile1 = new File("C:\\Users\\hhemr\\OneDrive\\Desktop\\testPdf.pdf");
			if (outputFile1.exists()) {
				System.out.println("File exist");
			} else {
				System.out.println("File not exist");
			}

			System.out.println("Conversion done");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Stop the office process
			OfficeUtils.stopQuietly(officeManager);
		}
	}

}
