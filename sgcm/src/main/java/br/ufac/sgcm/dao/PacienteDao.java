package br.ufac.sgcm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.ufac.sgcm.model.Paciente;
import br.ufac.sgcm.model.Paciente.Sexo;

public class PacienteDao implements IDao<Paciente> {
    private Connection conexao;
    private PreparedStatement ps;
    private ResultSet rs;

    public PacienteDao() {
        conexao = ConexaoDB.getConexao();
    }

    @Override
    public List<Paciente> get() {
        List<Paciente> registros = new ArrayList<>();
        String sql = "SELECT * FROM sgcm.paciente";
        try {
            ps = conexao.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Paciente registro = new Paciente();
                registro.setId(rs.getLong("id"));
                registro.setCep(rs.getString("cep"));
                registro.setCidade(rs.getString("cidade"));
                registro.setDataNascimento(rs.getString("data_nascimento"));
                registro.setEmail(rs.getString("email"));
                registro.setEndereco(rs.getString("endereco"));
                registro.setEstado(rs.getString("estado"));
                registro.setGrupoSanguineo(rs.getString("grupo_sanguineo"));
                registro.setNome(rs.getString("nome"));
                // registro.setSexo(rs.getString("sexo"));
                registro.setSexo(Sexo.valueOf(rs.getString("sexo")));
                registro.setTelefone(rs.getString("telefone"));
                registros.add(registro);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return registros;
    }

    @Override
    public Paciente get(Long id) {
        Paciente registro = new Paciente();
        String sql = "SELECT * FROM sgcm.paciente WHERE id = ?";
        try {
            ps = conexao.prepareStatement(sql);
            ps.setLong(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                registro.setId(rs.getLong("id"));
                registro.setCep(rs.getString("cep"));
                registro.setCidade(rs.getString("cidade"));
                registro.setDataNascimento(rs.getString("data_nascimento"));
                registro.setEmail(rs.getString("email"));
                registro.setEndereco(rs.getString("endereco"));
                registro.setEstado(rs.getString("estado"));
                registro.setGrupoSanguineo(rs.getString("grupo_sanguineo"));
                registro.setNome(rs.getString("nome"));
                // registro.setSexo(rs.getString("sexo"));
                registro.setSexo(Sexo.valueOf(rs.getString("sexo")));
                registro.setTelefone(rs.getString("telefone"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return registro;
    }

    @Override
    public List<Paciente> get(String termoBusca) {
        List<Paciente> registros = new ArrayList<>();
        String sql = "SELECT * FROM sgcm.paciente" +
        " WHERE cep LIKE ?" +
        " OR cidade LIKE ?" +
        " OR data_nascimento LIKE ?" +
        " OR email LIKE ?" +
        " OR endereco LIKE ?" +
        " OR estado LIKE ?" +
        " OR grupo_sanguineo LIKE ?" +
        " OR nome LIKE ?" +
        " OR sexo LIKE ?" +
        " OR telefone LIKE ?";
        try {
            ps = conexao.prepareStatement(sql);
            ps.setString(1, "%" + termoBusca + "%");
            ps.setString(2, "%" + termoBusca + "%");
            ps.setString(3, "%" + termoBusca + "%");
            ps.setString(4, "%" + termoBusca + "%");
            ps.setString(5, "%" + termoBusca + "%");
            ps.setString(6, "%" + termoBusca + "%");
            ps.setString(7, "%" + termoBusca + "%");
            ps.setString(8, "%" + termoBusca + "%");
            ps.setString(9, "%" + termoBusca + "%");
            ps.setString(10, "%" + termoBusca + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                Paciente registro = new Paciente();
                registro.setId(rs.getLong("id"));
                registro.setCep(rs.getString("cep"));
                registro.setCidade(rs.getString("cidade"));
                registro.setDataNascimento(rs.getString("data_nascimento"));
                registro.setEmail(rs.getString("email"));
                registro.setEndereco(rs.getString("endereco"));
                registro.setEstado(rs.getString("estado"));
                registro.setGrupoSanguineo(rs.getString("grupo_sanguineo"));
                registro.setNome(rs.getString("nome"));
                // registro.setSexo(rs.getString("sexo"));
                registro.setSexo(Sexo.valueOf(rs.getString("sexo")));
                registro.setTelefone(rs.getString("telefone"));
                registros.add(registro);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return registros;
    }

    @Override
    public int insert(Paciente objeto) {
        int registrosAfetados = 0;
        String sql = "INSERT INTO sgcm.paciente (cep, cidade, data_nascimento, email, endereco, estado, grupo_sanguineo, nome, sexo, telefone) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?,?)";
        try {
            ps = conexao.prepareStatement(sql);
            ps.setString(1, objeto.getCep());
            ps.setString(2, objeto.getCidade());
            ps.setString(3, objeto.getDataNascimento());
            ps.setString(4, objeto.getEmail());
            ps.setString(5, objeto.getEndereco());
            ps.setString(6, objeto.getEstado());
            ps.setString(7, objeto.getGrupoSanguineo());
            ps.setString(8, objeto.getNome());
            ps.setString(9, objeto.getSexo().name());
            ps.setString(10, objeto.getTelefone());
            registrosAfetados = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return registrosAfetados;
    }

    @Override
    public int update(Paciente objeto) {
        int registrosAfetados = 0;
        String sql = "UPDATE sgcm.paciente SET" +
                " cep = ?," +
                " cidade = ?," +
                " data_nascimento = ?," +
                " email = ?, " +
                " endereco = ?," +
                " estado= ?," +
                " grupo_sanguineo = ?, " +
                " nome = ?," +
                " sexo = ?," + 
                " telefone = ?" +
                " WHERE id = ?";
        try {
            ps = conexao.prepareStatement(sql);
            ps.setString(1, objeto.getCep());
            ps.setString(2, objeto.getCidade());
            ps.setString(3, objeto.getDataNascimento());
            ps.setString(4, objeto.getEmail());
            ps.setString(5, objeto.getEndereco());
            ps.setString(6, objeto.getEstado());
            ps.setString(7, objeto.getGrupoSanguineo());
            ps.setString(8, objeto.getNome());
            // ps.setString(9, objeto.getSexo());
            ps.setString(9, objeto.getSexo().name());
            ps.setString(10, objeto.getTelefone());
            ps.setLong(11, objeto.getId());
            registrosAfetados = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return registrosAfetados;
    }

    @Override
    public int delete(Long id) {
        int registrosAfetados = 0;
        String sql = "DELETE FROM sgcm.paciente WHERE id = ?";
        try {
            ps = conexao.prepareStatement(sql);
            ps.setLong(1, id);
            registrosAfetados = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return registrosAfetados;
    }
}