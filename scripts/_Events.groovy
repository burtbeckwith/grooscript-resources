
/**
 * Because the js file is bundle with the grooscript.jar and we don«t want
 * to copy it manually to the js/grooscript folder, every time the project
 * is compiled, the system is going to take the js from the jar and put it
 * in the right folder. That way the plugin always will have the right
 * version of the grooscript.js file.
 * 
 **/
eventCompileStart = {
 /* Looking for the source */
	def fileName = "grooscript.js"
	def inputStream = classLoader.getResourceAsStream("js/${fileName}") 
	def outputFile = new File("${basedir}/web-app/js/grooscript/${fileName}")
 /* Delete if previous version exists */
	if (outputFile.exists()){
		def couldBeDeleted = outputFile.delete()
		if (!couldBeDeleted){
			throw new Exception("Previous version can't be deleted, please delete grooscript.js manually")
		}
	}	
 /* Copying */
	outputFile.withOutputStream{out->
		out << inputStream
	}
}
