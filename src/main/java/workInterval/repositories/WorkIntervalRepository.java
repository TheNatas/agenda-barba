package workInterval.repositories;

import workInterval.dtos.NewWorkIntervalDto;
import lombok.AllArgsConstructor;

import java.sql.*;

@AllArgsConstructor
public class WorkIntervalRepository {
    private Connection conn;

    public int insertWorkInterval(NewWorkIntervalDto workIntervalEntity) throws SQLException{
        String query = "insert into work_interval " +
                "(barber_shop_id, week_day, start, end) " +
                "values (?,?,?,?)";
        PreparedStatement ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        ps.setInt(1, workIntervalEntity.getBarberShopid());
        ps.setString(2, workIntervalEntity.getWeekDay());
        ps.setTimestamp(3, workIntervalEntity.getStart());
        ps.setTimestamp(4, workIntervalEntity.getEnd());
        ps.executeUpdate();

        try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
            if (generatedKeys.next()) {
                return generatedKeys.getInt("id_work_interval");
            }
            else {
                throw new SQLException("Falha ao inserir periodo, nenhuma ID recuperada");
            }
        }
    };
    
}
