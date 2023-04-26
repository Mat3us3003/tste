let botoesExcluir = document.querySelectorAll("a.botao.excluir");
for (let botao of botoesExcluir) {
    botao.addEventListener("click", evento => {
        if (!confirm("Deseja realmente excluir?")) {
            evento.preventDefault();
        }
    });
}

let botaoUrl = document.querySelector("input[data-url]");
if (botaoUrl) {
    botaoUrl.addEventListener("click", () => {
        let url = botaoUrl.getAttribute("data-url");
        window.location.href = url;
    });
}
