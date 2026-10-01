package ir.maktabsharif.library.repository.jdbc;

import ir.maktabsharif.library.entity.Member;
import ir.maktabsharif.library.repository.DbConaction;
import ir.maktabsharif.library.repository.MemberRepository;
import org.postgresql.replication.fluent.physical.PhysicalReplicationOptions;

import java.sql.*;
import java.util.List;

public class JdbcMembersRepository implements MemberRepository {
    @Override
    public void save(Member member) {
        String sql="insert into members(id, name, email) values (?,?,?)";
        try {
            Connection connection = DbConaction.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setInt(1,member.getId());
            ps.setString(2, member.getName());
            ps.setString(3, member.getEmail());
            ps.executeQuery();
            ps.execute();
        } catch (SQLException e) {
            //System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Member member) {

    }

    @Override
    public Member findById(int id) {
        return null;
    }

    @Override
    public List<Member> findAll() {
        return List.of();
    }

    public int count() {
        String sql = "select count(*) as member_count from members";
        try (Connection connection = DbConaction.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            resultSet.next();
            int memberCount = resultSet.getInt("member_count");
            return memberCount;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
