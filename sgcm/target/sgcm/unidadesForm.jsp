<%@ page pageEncoding="UTF-8" %>

<%@ page import="java.util.List" %>
<%@ page import="br.ufac.sgcm.model.Unidade" %>

<jsp:useBean
    id="controllerU"
    class="br.ufac.sgcm.controller.UnidadeController"
    scope="page" />
<jsp:useBean
    id="item"
    class="br.ufac.sgcm.model.Unidade"
    scope="page" />

<%

    String paramId = request.getParameter("id");
    if (paramId != null && !paramId.isEmpty()) {
        Long id = Long.parseLong(paramId);
        item = controllerU.get(id);
    }

    String submit = request.getParameter("submit");
    if (submit != null) {

        if (paramId != null && !paramId.isEmpty()) {
            Long id = Long.parseLong(request.getParameter("id"));
            item.setId(id);
        }

        item.setNome(request.getParameter("nome"));
        item.setEndereco(request.getParameter("endereco"));

        controllerU.save(item);
        pageContext.forward("unidades.jsp");

    }

%>

<!DOCTYPE html>
<html>
    <jsp:include page="include/head.jsp">
        <jsp:param name="head" value="UnidadesForm" />
    </jsp:include>
    <body>
        <%@ include file="include/header.jsp" %>
        <%@ include file="include/nav.jsp" %>
        <main>
            <form id="formCadastro" method="post">

                <div class="grid">

                    <input type="hidden" name="id" value="<%=item.getId() != null ? item.getId() : "" %>">

                    <label for="nome">Nome</label>
                    <input type="text" name="nome" id="nome" value="<%=item.getNome() != null ? item.getNome() : "" %>" required>

                     <label for="endereco">Endereço</label>
                    <input type="text" name="endereco" id="endereco" value="<%=item.getEndereco() != null ? item.getEndereco() : "" %>" required>

                </div>

                <input type="button" value="Cancelar" data-url="unidades.jsp">
                <input type="submit" name="submit" value="Salvar">

            </form>
        </main>
        <%@ include file="include/footer.jsp" %>
    </body>
</html>