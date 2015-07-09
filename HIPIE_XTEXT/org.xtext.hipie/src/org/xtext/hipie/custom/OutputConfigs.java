package org.xtext.hipie.custom;


import static org.eclipse.xtext.xbase.lib.CollectionLiterals.newHashSet;

import java.util.Set;

import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.generator.IOutputConfigurationProvider;
import org.eclipse.xtext.generator.OutputConfiguration;

public class OutputConfigs implements IOutputConfigurationProvider {

	  public static final String DATABOMB_OUTPUT = "Databomb";
	  public static final String HTML_OUTPUT = "HTML";

	  /**
	   * @return a set of {@link OutputConfiguration} available for the generator
	   */
	   public Set<OutputConfiguration> getOutputConfigurations() {
	    OutputConfiguration defaultOutput = new OutputConfiguration(IFileSystemAccess.DEFAULT_OUTPUT);
	    defaultOutput.setDescription("Output Folder");
	    defaultOutput.setOutputDirectory("./gen");
	    defaultOutput.setOverrideExistingResources(true);
	    defaultOutput.setCreateOutputDirectory(true);
	    defaultOutput.setCleanUpDerivedResources(true);
	    defaultOutput.setSetDerivedProperty(true);

	    OutputConfiguration databomb = new OutputConfiguration(DATABOMB_OUTPUT);
	    databomb.setDescription("Output for databombs");
	    databomb.setOutputDirectory("./gen");
	    databomb.setOverrideExistingResources(true);
	    databomb.setCreateOutputDirectory(true);
	    databomb.setCleanUpDerivedResources(false);
	    databomb.setSetDerivedProperty(false);
	    
	    OutputConfiguration htmlgen = new OutputConfiguration(HTML_OUTPUT);
	    htmlgen.setDescription("Output for HTML");
	    htmlgen.setOutputDirectory("./gen");
	    htmlgen.setOverrideExistingResources(true);
	    htmlgen.setCreateOutputDirectory(true);
	    htmlgen.setCleanUpDerivedResources(false);
	    htmlgen.setSetDerivedProperty(false);    
	    
	    return newHashSet(defaultOutput, databomb, htmlgen);
	    
	  }
	}