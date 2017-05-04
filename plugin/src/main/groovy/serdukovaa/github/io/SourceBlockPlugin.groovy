package serdukovaa.github.io

import org.gradle.api.Plugin
import org.gradle.api.Project

/**
 * Created by Serdyukov_A on 04.05.2017.
 */

class SourceBlockPlugin implements Plugin<Project> {
    void apply(Project project) {
        def String message = 'Hello from SourceBlockPlugin'
        // Add a task that uses the configuration
        project.task('hello') {
            doLast {
                println message
            }
        }
    }
}

