package sgridsf.dsl.cosiml.gen.deployment.services;

import java.io.File;

import org.eclipse.core.runtime.Path;


public class PathsService {

	public static File targetFolder;
	public static File sourceFile;
	protected String _path;
	
	public static String getTargetFolder() {return targetFolder.getAbsolutePath();}
	public static String getSourceFile() {return sourceFile.getAbsolutePath();}
	
	public boolean isFile(String path) { return new File(path).isFile(); }
	public boolean isDirectory(String path) { return new File(path).isDirectory(); }
	public boolean exists(String path) { return new File(path).exists(); }
	public boolean isAbsolute(String path) { return new File(path).isAbsolute(); }
	
	public String getParentPath(String path) {
		File f = new File(path);
		return f.getParent();
	}
	
	public String getName(String path) {
		File f = new File(path);
		return f.getName();
	}
	
	public String relativizeTo(String path, String base) { 
		Path p = new Path(path);
		Path b = new Path(base);
		String res = p.makeRelativeTo(b).toPortableString();
		System.out.println("========");
		System.out.println(p.toString());
		System.out.println(b.toString());
		System.out.println(res);
		return res;
	}
	
}
