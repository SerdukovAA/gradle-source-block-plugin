package serdukovaa.github.io

import org.gradle.api.Plugin
import org.gradle.api.Project

/**
 * Created by Serdyukov_A on 04.05.2017.
 */

class SourceBlockPlugin implements Plugin<Project> {
    void apply(Project project) {
        project.task('addGitSourceBlock', type: AddGitBlockTask)
    }
}

