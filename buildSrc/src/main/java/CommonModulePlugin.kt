
import com.android.build.gradle.BaseExtension
import org.gradle.api.Plugin
import org.gradle.api.Project

class CommonModulePlugin : Plugin<Project>  {
    override fun apply(project: Project) {
        val androidExtension = project.extensions.getByName("android")

        androidExtension.apply {
            if (androidExtension is BaseExtension) {
                androidExtension.apply {
                    compileSdkVersion(ConfigData.compileSdkVersion)
                    defaultConfig {
                        applicationId = ConfigData.appId
                        targetSdk = ConfigData.targetSdk
                        minSdk = ConfigData.minSdkVersion
                        versionCode = ConfigData.versionCode
                        versionName = ConfigData.versionName
                        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
                    }
                }
            }
        }
    }

}