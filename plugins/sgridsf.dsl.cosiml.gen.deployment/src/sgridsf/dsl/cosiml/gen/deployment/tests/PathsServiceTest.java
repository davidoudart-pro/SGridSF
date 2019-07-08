package sgridsf.dsl.cosiml.gen.deployment.tests;

import static org.junit.Assert.assertEquals;

import java.io.File;

import org.junit.Test;

import sgridsf.dsl.cosiml.gen.deployment.services.PathsService;

public class PathsServiceTest {

	@Test
	public void shouldRelativize() {
		PathsService service = new PathsService();
		String p = "/home/i48577/Travail/thesedavidoudart/Travail/Model Workbench/";
		String voltagePath = p+"cosimulationTests/src-gen/simplecosim/Voltage";
		String sourcePath = p+"cosimulationTests/simpleModel.xmi";
		String targetPath = p+"cosimulationTests";
		String dng = p+"cosimulationTests/src-gen/simplecosim/simplecosim.dng";
		String libFrame = "../lib/fmu-framework-2.5.2.jar";
		System.out.println(service.relativizeTo(sourcePath, targetPath+"/src-gen"));
		System.out.println(service.relativizeTo(libFrame, dng));
		System.out.println(service.relativizeTo(sourcePath +"/"+ libFrame, service.getParentPath(dng)));
		System.out.println(service.exists(dng + "/"+ service.relativizeTo(sourcePath +"/"+ libFrame, service.getParentPath(dng))));
		System.out.println(dng + "/"+ service.relativizeTo(sourcePath +"/"+ libFrame, service.getParentPath(dng)));
		System.out.println(service.isFile("heelo/var.sh"));
	}
	
}
