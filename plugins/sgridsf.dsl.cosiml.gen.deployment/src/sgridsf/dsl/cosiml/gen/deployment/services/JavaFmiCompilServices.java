/**
 * 
 */
package sgridsf.dsl.cosiml.gen.deployment.services;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.logging.Logger;

import org.eclipse.acceleo.common.AcceleoCommonPlugin;
import org.eclipse.acceleo.common.AcceleoServicesRegistry;
import org.eclipse.acceleo.common.internal.utils.AcceleoServicesEclipseUtil;
import org.eclipse.acceleo.common.internal.utils.workspace.AcceleoWorkspaceUtil;
import org.eclipse.acceleo.engine.AcceleoEnginePlugin;
import org.eclipse.acceleo.engine.service.AbstractAcceleoGenerator;
import org.eclipse.acceleo.engine.service.AcceleoModulePropertiesAdapter;
import org.eclipse.acceleo.engine.service.AcceleoService;
import org.eclipse.acceleo.engine.utils.AcceleoEngineUtils;
import org.eclipse.acceleo.engine.utils.AcceleoLaunchingUtil;

import sgridsf.dsl.cosiml.gen.deployment.main.GenerateAll;

/**
 * @author i48577
 *
 */
public class JavaFmiCompilServices {
	
	private static Path targetFolder;
	private Path pluginPath = Paths.get(this.getClass().getProtectionDomain().getCodeSource().getLocation().getPath());
	
	public static void setTargetFolder(File target) {
		targetFolder = target.toPath();
		System.out.println("Target folder set to "+targetFolder.toAbsolutePath());
	}
	
	private static boolean copyFile(Path src, Path dest) {
		if (dest.toFile().exists() == true) {
			System.out.println(dest.toAbsolutePath() +" already exist");
			return true;
		}
		if (dest.toFile().exists() == false) {
			 try {
				dest.toFile().mkdirs();
				Files.copy(src, dest, StandardCopyOption.REPLACE_EXISTING);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println(dest.toAbsolutePath() +": error copy");
				e.printStackTrace();
				return false;
			}
		}
		return true;
	}
	
	/*
	 * Copy jar from plugin to targetFolder
	 */
	public String addFmuFramework(String relativeTarget) {
		System.out.println("========== Call to addFmuFramework");
		Path src = pluginPath.resolve("resources/fmu-framework-2.5.2.jar");
		System.out.println(src.toString());
		Path dest = targetFolder.resolve(relativeTarget + "/fmu-framework-2.5.2.jar");
		System.out.println(dest.toString());
		if (copyFile(src, dest)) return dest.toAbsolutePath().toString();
		return "error path";
	}
	public String addFmuBuilder(String relativeTarget) {
		System.out.println("----------== Call to addFmuBuilder");
		Path src = pluginPath.resolve("resources/fmu-builder-2.5.2.jar");
		System.out.println(src.toString());
		Path dest = targetFolder.resolve(relativeTarget + "/fmu-builder-2.5.2.jar");
		System.out.println(dest.toString());
		if (copyFile(src, dest)) return dest.toAbsolutePath().toString();
		return "error path";
	}
	
	public static Boolean createFMU(String fmupath) {
		System.out.println("Call to createFMU");
		return true;
	}
	
}
