/*
Контроллер дополнительного окна приложения "О программе"
Разметка для него лежит здесь: res/about.fxml
 */
import javafx.fxml.FXML
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.stage.Stage

class AboutController : Controller() {
    @FXML
    lateinit var okButton: Button
    @FXML
    lateinit var version: Label

    fun initialize() {
        version.text = """
            |Kotlin ${KotlinVersion.CURRENT}
            |Java ${System.getProperty("java.version")} ${System.getProperty("java.vendor")}
            |JavaFX ${System.getProperty("javafx.version")} ${System.getProperty("awt.toolkit")}
            |${System.getProperty("os.name")} ${System.getProperty("os.arch")} ${System.getProperty("os.version")}
            |""".trimMargin()
        okButton.setOnAction {
            stage.close()
        }
    }

    companion object {
        fun start(stage: Stage) = start(Stage().apply {
            initOwner(stage)
            isResizable = false
        }, "about.fxml", "О программе", "app_icon.png")
    }
}