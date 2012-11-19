import org.grails.plugin.resource.ResourceProcessor
import org.grails.plugin.resource.ResourceTagLib

class GrooscriptResourcesGrailsPlugin {
	def version = "0.1"
	def grailsVersion = "2.0 > *"

	def title = "Grooscript Resources Plugin"
	def author = "Mario Garcia"
	def authorEmail = ""
	def description = 'Compiles groovy static resources to javascript'
	def documentation = "http://grails.org/plugin/grooscript-resources"

	def license = "APACHE"
	def issueManagement = [system: 'Github', url: 'https://github.com/mariogarcia/grooscript-resources/issues']
	def scm = [url: 'https://github.com/mariogarcia/grooscript-resources']

	def doWithSpring = {
		// TODO Implement runtime spring config (optional)
		ResourceTagLib.SUPPORTED_TYPES['gs'] = [type:'text/javascript', writer:'js']
		ResourceProcessor.DEFAULT_MODULE_SETTINGS['gs'] = [disposition: 'defer']
	}
}
