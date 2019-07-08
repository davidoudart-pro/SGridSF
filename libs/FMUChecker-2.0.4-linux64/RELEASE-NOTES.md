﻿Release notes for FMI Compliance Checker (FMUChecker) application.

2017-11-06 Version 2.0.4
- Updates:
 - Support for FMIL 2.0.3
  - Solved compilation error related to vsnprintf on macOS.

2017-10-06 version 2.0.4b1
- Updates:
 - Added check for calls with zero-size arrays (see 1.0.1 FMI spec p. 13).
 - Support for FMIL 2.0.3b1
  - Added check for consistent start values in FMI 1.0.1 alias sets.
  - Added error for the deprecated capability flag canSignalEvents in FMI 1.0.1
  - Improved performance for many unique variable descriptions in FMU
  - Fixed memory bug in jm_vector_insert

2016-09-30 Version 2.0.3
- Updates:
 - Support for FMIL 2.0.2
  - No changed made since FMIL 2.0.2b4.

2016-09-26 Version 2.0.3b3
- Feature updates:
 - Support for FMIL 2.0.2b4
  - Added an error message if neither of the required XML elements
  CoSimulation_StandAlone or CoSimulation_Tool are present in the
  Implementation element for 1.0 CS FMUs.
  - For ScalarVariable elements with invalid attributes in the XML, the
  log message was changed from a warning to an error.

2016-04-28 Version 2.0.3b2
- Bugfixes:
 - Fixed 2 bugs where simulating a 1.0 ME FMU did not follow the specified state
 machine of calling sequence, specifically:
  - Not calling fmiSetIN in the setInputs state
  - Calling fmiSetIN in the stepInProgress state instead of fmiSetINC

2016-03-23 Version 2.0.3b1
- Feature updates:
 - Variable names are checked to follow the syntax specified in the variable
 naming conventions.
 - External event check support added for FMI 1.0.
 - Improved documentation for the -n <numSteps> and -h <stepSize> options.
 - The checker confirms that an FMU contains either a "binaries" or "sources"
 folder.
 - A warning is logged if input variables have no start values.
 - A warning is given if no Capabilities element is found for CS 1.0 FMU.

- Bugfixes:
 - All discrete input values in a time step are checked for changes.
 - Steps that should be written to output is now written.
 - Set time is called at the right time for ME 2.0.
 - FMI 1.0 Integer/Enumeration attribute values are no longer overwritten.
 - Assert error for empty String variables removed.
 - Crash/assert error for empty ModelStructure tag fixed.

2014-12-22 Version 2.0.2b1
- Bugfixes:
 - Corrected handling of quoted variable names in input CSV files.
 - Fixed unmotivated warning when checking FMI 2.0 ME compliant FMUs.

2014-10-24 Version 2.0.1
- Feature updates:
  - Added call to Checker to logfile for improved documentation
  - More detailed error report
  - Moved FMU status reports to verbose level
  - Evaluation of all variables at all time steps to make sure everything may be calculated


2014-08-22 Version 2.0
- Feature updates:
 - Support for FMIL 2.0 resp. FMI 2.0
 - new -k option to specify XML test, ME or CS simulation
 - improvements in XML handling for improved compliance with standard
 - version info for Checker and FMIL in helptext
- Bugfixes:
 - input calculation for FMI 1.0 and FMI 2.0
 - inconsistencies in output file fixed


2014-05-09 Version 2.0b3
- Feature updates:
 - Added Support for FMIL 2.0b3 resp. FMI 2.0 RC2. Prior versions
  (RC1 and below) not supported any more.
 - Simultaneous identifiers for ModelExchange and CoSimulation in
  2.0 now legal and will both be verified.
 - updated model structure output for 2.0 due to new variabilities.


2014-03-10 Version 2.0b2
- Bug fix release:
  - Corrected reduced output for the 2.0RC1 FMUs
  - Handling of co-simulation FMUs with fixed time step
  - Improved error handling and better error messages.

2013-12-17 Version 2.0b1
- Feature updates:
 - Added Support for FMIL 2.0b1 resp. FMI 2.0 RC1. Prior versions
   (beta4) not supported any more.
  - New event handling for FMU 2.0 in ModelExchange simulation.
 - Added support for CSV input files for FMUs in 2.0 standard

2013-06-20 Version 2.0a2
- Feature updates:
 - Output format modified:
  - CSV files are now RFC 4180 compatible by default (comma is the
  default field separator; CR-LF is used as end of line; variable
  names are enclosed in double quotes as needed).
  - -m switch is itroduced to support mangling of variable names
  as needed by CSV importers that don't handle quoting.
  - Only variable names are written out in the header line (no
  aliasing information is provided).
  - Numerical values are printed for enum and boolean variables.
  - -n switch only controls the number of output points and works
  orthogonal to the -h switch specifying the time step length.
  - Only variables with causality output are written out by default.
  -f switch may be used to write out all variables.
 - Support for input CSV files.
   -i <file name> - flag is now used to specify file name with input
   signals for the FMU. Details on the file format are given in
   the README-FMUChecker.txt.
 - Version information printed as a part of the help screen.
- Packaging updates:
 - FMI Library is distirbuted as a part of checker's source.
 - Build script supports automatic cross-checking with FMI Library driven by
    compliance checker. See information on FMUCHK_FMI_PUBLIC in
    BUILD-FMUChecker.txt for details.
 - Updated the header files for FMI 2.0 (still beta4 compatible).

2012-10-18 Version 2.0a1
- Added support for FMI 2.0beta4 with the following modifications:
  - Modified and corrected standard header files as proposed in
  tickets #86, #87, #88 and #108 at https://trac.fmi-standard.org/
  Header files are distributed with the FMU checker.
  - Removed fmiGetPartialDerivatives interface function as decided
  during the FMI meeting Sep 07, 2012
  Note that FMU Checker 2.0a1 supports both FMI 1.0 and 2.0 beta 4
  specifications and contains a number of bug fixes as compared to the 1.0.2
  release. The �alpha� status concerns FMI 2.0 support due to limited testing
  and beta status of the specification.
- Added logging of memory callbacks calls
- The '-z <dir>' switch simplifies debugging for FMU developers
- Fixed the bugs:
  - empty and malfored XML files could result in segmentation fault;
  - instance name pointer can be legally used in fmiInitialize

2012-08-22 Version 1.0.2
- Fixed the bugs:
  - parsing of 'Model' element in XML
  - indexing of enum items
- Improved CSV file output making sure it can be easily imported into Excel
- Provided additional program options for convenience
- Linux version now uses 'RTLD_NOW' mode for loading the FMU binary and
  reports underfined symbols if there are such.

2012-07-16 Version 1.0.1
- Added output for the simulation start time
- Improved simulation output file header. Alias information
is now provided as "a=b" or "a=-b" in the first output row.
- Improved readability for a number of log messages

2012-07-06 Version 1.0
Initial release submitted to Modelica Association
