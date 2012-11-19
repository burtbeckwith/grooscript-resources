grails.project.work.dir = 'target'
grails.project.source.level = 1.6

grails.project.dependency.resolution = {

	inherits 'global'
	log 'warn'

	repositories {
		grailsCentral()
		mavenRepo "http://oss.sonatype.org/content/groups/public/"
	}

	dependencies {
		runtime 'org.grooscript:grooscript:0.1'
	}

	plugins {

		runtime ":resources:1.1.6"

		build(':release:2.0.4', ':rest-client-builder:1.0.2') {
			export = false
		}
	}
}
