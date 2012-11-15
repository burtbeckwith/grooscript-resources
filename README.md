Grooscript Resources Plugin
===========================

This plugin enables you to declare Groovy scripts as static resources and compile those scripts to Javascript code. That´s possible thanks to 
the [Grooscript Project](http://www.grooscript.org/) 

Basic Usage
===========

There're a couple of things you must take into account:

1. Groovy files must have the suffix '.gs'. I still don´t know why files with '.groovy' suffix
can´t be 'watched' (Grails doesn´t see any changes made to that files). Maybe you can know the 
answer :)

2. You must declare the dependency of the 'grooscript' module in those modules you're declaring any
groovy scripts.

		modules = {
			myGroovyFiles{
				dependsOn 'grooscript'
				
				resource url:'js/gs/Car.gs'
				resource url:'js/gs/Bike.gs'
			}
		}

3. Enjoy coding Groovy in the client side ;)

