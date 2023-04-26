<%@ page pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="br.ufac.sgcm.model.Especialidade" %>

<jsp:useBean
    id="controllerE"
    class="br.ufac.sgcm.controller.EspecialidadeController"
    scope="page" />

<jsp:useBean
    id="item"
    class="br.ufac.sgcm.model.Especialidade"
    scope="page" />
<%

    String paramId = request.getParameter("id");
    if (paramId != null && !paramId.isEmpty()) {
        Long id = Long.parseLong(paramId);
        item = controllerE.get(id);
    }

    String submit = request.getParameter("submit");
    if (submit != null) {

        if (paramId != null && !paramId.isEmpty()) {
            Long id = Long.parseLong(request.getParameter("id"));
            item.setId(id);
        }

        item.setNome(request.getParameter("nome"));

        controllerE.save(item);
        pageContext.forward("especialidades.jsp");

    }

%>

<!DOCTYPE html>
<html>
    <jsp:include page="include/head.jsp">
        <jsp:param name="head" value="EspecialidadeForm" />
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

                </div>

                <input type="button" value="Cancelar" data-url="especialidades.jsp">
                <input type="submit" name="submit" value="Salvar">

            </form>
        </main>
        <%@ include file="include/footer.jsp" %>
    </body>
</html>