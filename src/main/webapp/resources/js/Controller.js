class Controller {
    onLoad() {
        document.getElementById("getSax").addEventListener("click",
            ()=> document.getElementById('formParse').submit());
    }
}