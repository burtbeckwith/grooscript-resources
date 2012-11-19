package org.grails.plugin.grooscript.resources

import groovy.util.logging.Log4j

import org.grooscript.GsConverter

import org.grails.plugin.resource.mapper.MapperPhase
import org.codehaus.groovy.grails.commons.GrailsApplication
import org.codehaus.groovy.grails.plugins.support.aware.GrailsApplicationAware

/**
 * This resource mapper compiles groovy script to javascript and 
 * exposes the javascript files
 * 
 * @author marioggar
 * @since 0.1
 * 
 **/
@Log4j
class GrooscriptResourceMapper implements GrailsApplicationAware {
	
	GrailsApplication grailsApplication
	
	static final GROOSCRIPT_EXTENSION = '.gs'
	static final JAVASCRIPT_EXTENSION = '.js'	
	static final GROOSCRIPT_PATTERN = /(?i)\.gs/
	
	static defaultIncludes = ['**/*.gs']
	
	def phase = MapperPhase.GENERATION
	 	
	/**
	 * Implementing how the resource is going to be processed
	 **/
	def map(resource,config){
		def original = resource.processedFile
		def input,target
	 /* I guess this is not neccessary because only gs files are sent to this resource mapper */
		if(resource.sourceUrl && original.name.toLowerCase().endsWith(GROOSCRIPT_EXTENSION)) {
		 /* Creating new file */
			input = grailsApplication.parentContext.getResource(resource.sourceUrl).file
			target = new File(original.absolutePath.replaceAll(GROOSCRIPT_PATTERN, JAVASCRIPT_EXTENSION))						
			try {				
			 /* Compiling groovy script to javascript */
				log.debug "Compiling GrooScript file ${original} into ${target}"
				String output = new GsConverter().toJs(input.text)
			 /* Writing the javascript */
				target << output
			 /* Keeping Grails posted */
				resource.processedFile = target
				resource.updateActualUrlFromProcessedFile()
				resource.sourceUrlExtension = 'js'
				resource.actualUrl = resource.originalUrl.replaceAll(GROOSCRIPT_PATTERN, JAVASCRIPT_EXTENSION)
				resource.contentType = 'text/javascript'  
			} catch(e) {
				log.error "Problems compiling GrooScript ${resource.originalUrl} ${e.message}"
				e.printStackTrace()
			}
		}		
	}
	
}
