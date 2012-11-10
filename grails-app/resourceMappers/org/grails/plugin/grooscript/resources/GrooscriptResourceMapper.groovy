package org.grails.plugins.grooscript.resources

import org.grails.plugin.resource.mapper.MapperPhase
import org.codehaus.groovy.grails.commons.GrailsApplication
import org.codehaus.groovy.grails.plugins.support.aware.GrailsApplicationAware
import org.mozilla.javascript.EvaluatorException

/**
 * 
 * 
 **/
class GrooscriptResourceMapper implements GrailsApplicationAware {
	
	GrailsApplication grailsApplication
	
	static final GROOSCRIPT_EXTENSION = ".gs"
	static final JAVASCRIPT_EXTENSION = ".js"
	
	def defaultIncludes = ['**/*.gs'] 
	
	/**
	 * 
	 **/
	def map(resource,config){
		
		
		
	}

}
