<%@ page pageEncoding="UTF-8" %>

<%@ page import="java.util.List" %>
<%@ page import="br.ufac.sgcm.model.Profissional" %>

<jsp:useBean
    id="controller"
    class="br.ufac.sgcm.controller.ProfissionalController"
    scope="page" />

<%

    String paramExcluir = request.getParameter("excluir");
    if (paramExcluir != null) {
        Long id = Long.parseLong(paramExcluir);
        controller.delete(id);
    }

    List<Profissional> registros;
    String paramBusca = request.getParameter("busca");
    if (paramBusca != null && !paramBusca.isEmpty()) {
        registros = controller.get(paramBusca);
    } else {
        registros = controller.get();
    }

%>

<!DOCTYPE html>
<html>
    <jsp:include page="include/head.jsp">
        <jsp:param name="head" value="Profissionais" />
    </jsp:include>
    <body>
        <%@ include file="include/header.jsp" %>
        <%@ include file="include/nav.jsp" %>
        <main>
            <jsp:include page="include/comandos.jsp">
                <jsp:param name="link" value="profissionaisForm.jsp"/>
            </jsp:include>
            <table>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Nome</th>
                        <th>Registro</th>
                        <th>Especialidade</th>
                        <th>Unidade</th>
                        <th>Telefone</th>
                        <th>E-mail</th>
                        <th>Ações</th>
                    </tr>
                </thead>
                <tbody>
                    <% for(Profissional item : registros) { %>
                    <tr>
                        <td class="fit"><%=item.getId()%></td>
                        <td><%=item.getNome()%></td>
                        <td><%=item.getRegistroConselho()%></td>
                        <td><%=item.getEspecialidade().getNome()%></td>
                        <td><%=item.getUnidade().getNome()%></td>
                        <td><%=item.getTelefone()%></td>
                        <td><%=item.getEmail()%></td>
                        <td>
                            <a href="profissionaisForm.jsp?id=<%=item.getId()%>"
                               class="botao">Editar</a>
                            <a href="profissionais.jsp?excluir=<%=item.getId()%>"
                               class="botao excluir">Excluir</a>
                        </td>
                    </tr>
                    <% } %>
                </tbody>
                <tfoot>
                    <tr>
                        <td colspan="8">Total de registros: <%=registros.size()%></td>
                    </tr>
                </tfoot>
            </table>
        </main>
        <%@ include file="include/footer.jsp" %>
    </body>
</html>