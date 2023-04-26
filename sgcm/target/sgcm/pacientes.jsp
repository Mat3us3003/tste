<%@ page pageEncoding="UTF-8" %>

<%@ page import="java.util.List" %> 
<%@ page import="br.ufac.sgcm.model.Paciente" %>

<jsp:useBean
    id="controller"
    class="br.ufac.sgcm.controller.PacienteController"
    scope="page" />

<%

    String paramExcluir = request.getParameter("excluir");
    if (paramExcluir != null) {
        Long id = Long.parseLong(paramExcluir);
        controller.delete(id);
    }

    List<Paciente> registros;
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
        <jsp:param name="head" value="Pacientes" />
    </jsp:include>
    <body>
        <%@ include file="include/header.jsp" %>
        <%@ include file="include/nav.jsp" %>
        <main>
            <jsp:include page="include/comandos.jsp">
                <jsp:param name="link" value="pacientesForm.jsp"/>
            </jsp:include>
            <table>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Nome</th>
                        <th>Nascimento</th>
                        <th>Telefone</th>
                        <th>E-mail</th>
                        <th>Cep</th>
                        <th>Endereço</th>
                        <th>Cidade</th>
                        <th>Estado</th>
                        <th>Sexo</th>
                        <th>Grupo Sanguíneo</th>
                        <th>Ações</th> 
                    </tr>
                </thead>
                <tbody> 
                    <% for(Paciente item : registros) { %>
                    <tr>
                        <td class="fit"><%=item.getId()%></td>
                        <td><%=item.getNome()%></td>
                        <td><%=item.getDataNascimento()%></td>
                        <td><%=item.getTelefone()%></td>
                        <td><%=item.getEmail()%></td>
                        <td><%=item.getCep()%></td>
                        <td><%=item.getEndereco()%></td>
                        <td><%=item.getCidade()%></td>
                        <td><%=item.getEstado()%></td>
                        <td><%=item.getSexo()%></td>
                        <td><%=item.getGrupoSanguineo()%></td>
                        <td>
                            <a href="pacientesForm.jsp?id=<%=item.getId()%>"
                               class="botao">Editar</a>
                            <a href="pacientes.jsp?excluir=<%=item.getId()%>"
                               class="botao excluir">Excluir</a>
                        </td>
                    </tr>
                    <% } %>
                </tbody>
                <tfoot>
                    <tr>
                        <td colspan="12">Total de registros: <%=registros.size()%></td>
                    </tr>
                </tfoot>
            </table>
        </main>
        <%@ include file="include/footer.jsp" %>
    </body>
</html>