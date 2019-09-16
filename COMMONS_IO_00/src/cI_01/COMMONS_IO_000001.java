package cI_01;

import java.io.File;

import org.apache.commons.io.FileUtils;

public class COMMONS_IO_000001 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long a = FileUtils.sizeOf(new File("src\\cI_01\\COMMONS_IO_000001.java"));
		System.out.println(a);

	}

}
