<%@ page pageEncoding="UTF-8" %>
            <div id="comandos">
                <a href="<%=request.getParameter("link")%>"
                   id="add"
                   class="botao">Adicionar</a>
                <div>
                    <form method="post">
                        <label for="busca">Busca</label>
                        <input type="search" name="busca" id="busca"
                            placeholder="Digite para pesquisar...">
                        <input type="submit" value="Buscar" name="submit">
                    </form>
                </div>
            </div>