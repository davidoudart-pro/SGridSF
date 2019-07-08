# SGridSF

MDE toolchain for FMI cosimulation of Cyber-Physical Systems

## Structure

The toolchain is composed of two EMF plugins, found in the `plugins` folder:
1. **sgridsf.lang.cosiml**: Plugin defining the CosiML language (DSL) from an Ecore metamodel.
2. **sgridsf.dsl.cosiml.gen.deployment**: Plugin based on Acceleo for generating the files of the cosimulation and the deployment scripts.

In addition, a use case example can be found in the `example` folder, inside the **islandedgrid.cosimulation** project folder.

## Use Case


The use case presents the cosimulation of a Smart Grid system.
The system is an islanded power grid (**Grid**) composed of photovoltaic and diesel production sources, and a storage solution, monitored by an Energy Management System (**EMS**) controling the various equipments.

The cosimulation scenario connects two simulation units, simuling the *Grid* and the *EMS* behaviors.

The *EMS* simulation unit can send (in a discrete way) control commands:
* turn on / off the diesel production,
* set the the battery power production / consumption when the diesel is ON,
* limit the photovoltaic production if necessary.

The *Grid* simulation unit send continuously the current electrical state of its equipments:
* the state of charge of the battery,
* the current production power of the diesel plant,
* the maximal power available from the photovoltaic farm,
* the current load of the grid.

## Prequisites

## To model the cosimulation and generates the cosimulation files

The modeling and generation tools are EMF plugins, so you need to install an Eclipse EMF version with several plugins to execute them:

1. Eclipse (tested with Oxygen)
2. EMF tools
3. Xtext
4. Acceleo

## To execute the cosimulation

The modeling/generation platform and the execution platform doesn't have to be the same.
The execution of the cosimulation requires its own dependencies, according to the generators you used in the previous part:

* **DACCOSIM Shell** [[https://bitbucket.org/simulage/daccosim/downloads/]]: DACCOSIM is a FMI cosimulation software. Its shell tool allows to execute cosimulations from a script.

If you want to use the **Java unit** or the **CSV unit** generator: 

* **JavaFMI Framework and Builder** [[https://bitbucket.org/siani/javafmi/downloads/]]: JavaFMI builder is a tool to produce an FMU artifact from a java model which written with the JavaFMI Framework Java library.

## Run the Use Case

### Install the plugins



The different steps of the installation are:
1. Run your Eclipse software an create a fresh workspace (called plugins workspace).
2. You can import the two folders in `plugins` as Eclipse plugin projects in your workspace. 
3. Generates the model code of the CosiML DSL :
	1. open the `cosiml.genmodel` file inside the *sgridsf.lang.cosiml* projects (`model` folder).
	2. right-click on the root element of the tree, and select *Generates Model Code*.

### Import the example projects

You can either launch a new Eclipse execution from your plugins workspace, in order to create a new workspace (called modeling workspace), or import the example projects directly inside your plugins workspace (then the plugins and modeling workspaces are the same one).

Import the example folder *islandedgrid.cosimulation* in the `example` folder as Modeling project.

### Execute the files generation

The *SeinIsland.xmi* file inside the example project is the model of the cosimulation, compliant to CosiML.
It uses the **Java units** and the **CSV units** generators.

You can create a .properties file next to your model to configure the generation for the execution platform (which can be different from the files generation platform).
You need especially to set the paths to several dependencies required for the simulation execution:

1. DACCOSIM shell path (required for the cosimulation)
2. JavaFMI framework library and builder tool (required by the *Java units* and *CSV units* generator).
3. JAVA_HOME variable if it is not set inside the environment variables (also required by the *Java units* and *CSV units* generator).

These tools are presented more in detail in the previous [[Prequisites]] section.

The generation is done using an *Acceleo Application Run Configuration*, as following

[[img/acceleo-run-configuration.png]]

The *Target* field is the folder where you want the files to be generated. 
All the files will be generated inside a src-gen folder.

Launch the run configuration to generate the files.

### Execute the example

As said in the previous part, they are dependencies required for the execution of the cosimulation.
Be sure to have on your simulation platform:
* the required models and FMU files accessible at the paths defined inside the cosimulation model.
* the required execution tools installed at the paths defined in the .properties file.

The required models and FMUs for our example can be found inside the `resources` folder of the **islandedgrid.cosimulation** project.

The cosimulation launching script is found at `src-gen/SeinIsland/makeSeinIsland.sh`.

**On Windows platform** :

For now, we only generates .SH files to execute the cosimulation.
On windows, you can execute .SH files inside the **mingw** command line software ([[http://www.mingw.org/]]).


Executing the launching script will creates an FMU for all the *GeneratedSimulationUnit* of the cosimulation model, and executes the cosimulation scenario inside the Daccosim software.

Cosimulation results are given in CSV format.






