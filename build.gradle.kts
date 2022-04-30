import org.jetbrains.compose.compose
import org.jetbrains.compose.desktop.application.dsl.TargetFormat

group = "jp.kaleidot725"
version = "1.0"

plugins {
    kotlin("jvm") version "1.6.10"
    id("org.jetbrains.compose") version "1.1.1"
    id("org.jlleitschuh.gradle.ktlint") version "10.2.1"
}

repositories {
    google()
    mavenCentral()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
}

dependencies {
    implementation(compose.desktop.currentOs)
    implementation("org.jetbrains.compose.components:components-splitpane-desktop:1.1.1")
    implementation("br.com.devsrsouza.compose.icons.jetbrains:feather:1.0.0")

    testImplementation(kotlin("test-junit5"))
    testImplementation("io.kotest:kotest-runner-junit5:5.2.3")
    testImplementation("io.mockk:mockk:1.12.3")
}

configure<org.jlleitschuh.gradle.ktlint.KtlintExtension> {
    reporters {
        reporter(org.jlleitschuh.gradle.ktlint.reporter.ReporterType.CHECKSTYLE)
    }
}

compose.desktop {
    application {
        mainClass = "MainKt"
        nativeDistributions {
            packageName = "Pico"
            packageVersion = "1.0.0"

            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)

            macOS {
                bundleID = "jp.kaleidot725.pico"
                iconFile.set(project.file("icon.icns"))
            }

            windows {
                iconFile.set(project.file("icon.ico"))
            }

            linux {
                iconFile.set(project.file("icon.ico"))
            }
        }
    }
}
