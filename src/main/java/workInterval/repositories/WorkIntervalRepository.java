package workInterval.repositories;

import workInterval.entities.WorkIntervalEntity;
import lombok.AllArgsConstructor;

import java.sql.*;

@AllArgsConstructor
public class WorkIntervalRepository {
    private Connection conn;

    public int insertWorkInterval(WorkIntervalEntity workIntervalEntity) throws SQLException{
        String query = "insert into work_interval " +
                "(barber_shop_id, week_day, start, end) " +
                "values (?,?,?,?)";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1, workIntervalEntity.getBarberShopid());
        ps.setString(2, workIntervalEntity.getWeekDay());
        ps.setTimestamp(3, workIntervalEntity.getStart());
        ps.setTimestamp(4, workIntervalEntity.getEnd());
        return ps.executeUpdate();
    };
    
}
