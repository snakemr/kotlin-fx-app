Простой проект на языке Kotlin с использованием библиотеки JavaFX и визуальным построением разметки главного окна в Scene Builder. 
Настроено создание исполняемого файла (Build Artifacts). Создан типовой класс контроллера окна, и на его основе – классы главного 
и дополнительного окон приложения. Для работы требуется Java 1.8.
В проект входят файлы:
src/   – исходный код программы на языке Kotlin
 | Main – точка запуска приложения (изменения в этом файле нежелательны)
 | MainController – главное окно приложения
 | AboutController – дополнительное окно
 | Controller – типовой класс контроллера окна (изменения в этом файле нежелательны)
res/   – ресурсы программы
 | main.fxml – разметка главного окна
 | about.fxml – разметка дополнительного окна
 | app_icon.png – значок

Пример описания элементов, к которым нужно получить доступ (внутри класса MainController)
    @FXML lateinit var buttonClose: Button
    @FXML lateinit var editName: TextField
    @FXML lateinit var labelMessage: Label

Используйте любую из этих функций для выхода из программы (внутри класса MainController)
    fun closeApplication() = Platform.exit()
    fun closeWindow() = stage.close()

Используйте эту функцию для открытия другого окна приложения (внутри класса MainController)
    fun aboutWindow() = AboutController.start(stage)

Затем можно напрямую присвоить значение "closeApplication", "closeWindow" или "aboutWindow"
    свойству "Code / On Action" любой кнопки на визуальной форме main.fxml

Пример обработки закрытия окна с показом диалогового окна подтверждения (внутри класса MainController)
    override fun onCloseRequest(): Boolean {
        alert("Выйти?", type = Alert.AlertType.CONFIRMATION) {
            if (it.isDefaultButton) stage.close()
        }
        return false
    }

Также можно запрограммировать действия на любом из этапов жизни окна приложения (внутри класса MainController)
    override fun onShowing() { } // при показе окна
    override fun onShown() { }   // после показа окна
    override fun onHiding() { }  // при закрытии окна перед выходом
    override fun onHidden() { }  // после зарытия окна перед выходом
    override fun onStop() { }    // при закрытии приложения