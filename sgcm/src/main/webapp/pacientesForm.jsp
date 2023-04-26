<%@ page pageEncoding="UTF-8" %>

<%@ page import="java.util.List" %>
<%@ page import="br.ufac.sgcm.model.Paciente" %>
<%@ page import="br.ufac.sgcm.model.Paciente.Sexo" %>

<jsp:useBean
    id="controller"
    class="br.ufac.sgcm.controller.PacienteController"
    scope="page" />
<jsp:useBean
    id="item"
    class="br.ufac.sgcm.model.Paciente"
    scope="page" />
    
<%

    String paramId = request.getParameter("id");
    if (paramId != null && !paramId.isEmpty()) {
        Long id = Long.parseLong(paramId);
        item = controller.get(id);
    }

    String submit = request.getParameter("submit");
    if (submit != null) {

        if (paramId != null && !paramId.isEmpty()) {
            Long id = Long.parseLong(request.getParameter("id"));
            item.setId(id);
        }

        item.setNome(request.getParameter("nome"));
        item.setDataNascimento(request.getParameter("data_nascimento"));
        item.setTelefone(request.getParameter("telefone"));
        item.setEmail(request.getParameter("email"));
        item.setCep(request.getParameter("cep"));
        item.setEndereco(request.getParameter("endereco"));
        item.setCidade(request.getParameter("cidade"));
        item.setEstado(request.getParameter("estado"));
        //item.setSexo(request.getParameter("sexo"));
        item.setSexo(Sexo.valueOf(request.getParameter("sexo")));
        item.setGrupoSanguineo(request.getParameter("grupo_sanguineo"));

        controller.save(item);
        pageContext.forward("pacientes.jsp");

    }

%>

<!DOCTYPE html>
<html>
    <jsp:include page="include/head.jsp">
        <jsp:param name="head" value="PacientesForm" />
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

                <label for="data_nascimento">Data Nascimento</label>
                <input type="date" name="data_nascimento" id="data_nascimento" min="1910-01-01" max="2023-12-31" value="<%=item.getDataNascimento() != null ? item.getDataNascimento() : "" %>" required>
                
                <label for="telefone">Telefone</label>
                <input type="tel" name="telefone" id="telefone" value="<%=item.getTelefone() != null ? item.getTelefone() : "" %>">
                
                <label for="email">E-mail</label>
                <input type="email" name="email" id="email" value="<%=item.getEmail() != null ? item.getEmail() : "" %>">
                
                <label for="cep">Cep</label>
                <input type="text" name="cep" id="cep" value="<%=item.getCep() != null ? item.getCep() : "" %>" required>

                <label for="endereco">Endereço</label>
                <input type="address" name="endereco" id="endereco" value="<%=item.getEndereco() != null ? item.getEndereco() : "" %>" required>
                
                <label for="estado">Estado</label>
                <select name="estado" id="estado" value="<%=item.getEstado() != null ? item.getEstado() : "" %>">
                    <option value="">Selecione</option>
                    <option value="AC">Acre</option>
                    <option value="AL">Alagoas</option>
                    <option value="AP">Amapá</option>
                    <option value="AM">Amazonas</option>
                    <option value="BA">Bahia</option>
                    <option value="CE">Ceará</option>
                    <option value="DF">Distrito Federal</option>
                    <option value="ES">Espirito Santo</option>
                    <option value="GO">Goiás</option>
                    <option value="MA">Maranhão</option>
                    <option value="MS">Mato Grosso do Sul</option>
                    <option value="MT">Mato Grosso</option>
                    <option value="MG">Minas Gerais</option>
                    <option value="PA">Pará</option>
                    <option value="PB">Paraíba</option>
                    <option value="PR">Paraná</option>
                    <option value="PE">Pernambuco</option>
                    <option value="PI">Piauí</option>
                    <option value="RJ">Rio de Janeiro</option>
                    <option value="RN">Rio Grande do Norte</option>
                    <option value="RS">Rio Grande do Sul</option>
                    <option value="RO">Rondônia</option>
                    <option value="RR">Roraima</option>
                    <option value="SC">Santa Catarina</option>
                    <option value="SP">São Paulo</option>
                    <option value="SE">Sergipe</option>
                    <option value="TO">Tocantins</option>
                </select>
                
                <label for="cidade">Cidade</label>
                <input type="text" name="cidade" id="cidade" value="<%=item.getCidade() != null ? item.getCidade() : "" %>" required>

                <label for="sexo">Sexo</label>
                <select name="sexo" id="sexo" value="<%=item.getSexo() != null ? item.getSexo() : "" %> " required>
                    <option value=""></option>
                    <option value="M" <%= Sexo.M.equals(item.getSexo()) ? "selected" : "" %>>Masculino</option>
                    <option value="F" <%= Sexo.F.equals(item.getSexo()) ? "selected" : "" %>>Feminino</option>
                </select>

                <label for="sanguineo">Grupo Sanguíneo</label>
                <select name="sanguineo" id="sanguineo" required>
                    <option value=""></option>
                    <option value="1">A+</option>
                    <option value="2">A-</option>
                    <option value="3">B+</option>
                    <option value="4">B-</option>
                    <option value="5">AB+</option>
                    <option value="6">AB-</option>
                    <option value="7">O+</option>
                    <option value="8">O-</option>
                </select>

                </div>

                <input type="button" value="Cancelar" data-url="pacientes.jsp">
                <input type="submit" name="submit" value="Salvar">

            </form>
        </main>
        <%@ include file="include/footer.jsp" %>
    </body>
</html>