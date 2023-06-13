package workInterval.repositories;

import workInterval.dtos.MinWorkIntervalDto;
import workInterval.dtos.FullWorkIntervalDto;
import workInterval.dtos.NewWorkIntervalDto;
import lombok.AllArgsConstructor;
import workInterval.models.WorkInterval;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@AllArgsConstructor
public class WorkIntervalRepository {
    private Connection conn;

    public int insertWorkInterval(NewWorkIntervalDto workIntervalDto) throws SQLException{
        String query = "insert into work_interval " +
                "(barber_shop_id, week_day, start, end) " +
                "values (?,?,?,?)";
        PreparedStatement ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        ps.setInt(1, workIntervalDto.getBarberShopId());
        Timestamp start = workIntervalDto.getStart();
        ps.setString(2, (new SimpleDateFormat("EEEE", Locale.US)).format(start.getTime()).toUpperCase());
        ps.setTimestamp(3, workIntervalDto.getStart());
        ps.setTimestamp(4, workIntervalDto.getEnd());
        ps.executeUpdate();

        try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
            if (generatedKeys.next()) {
                return generatedKeys.getInt(1);
            }
            else {
                throw new SQLException("Falha ao inserir periodo, nenhuma ID recuperada");
            }
        }
    }

    public int updateWorkInterval(FullWorkIntervalDto workIntervalDto) throws SQLException{
        String query = "update work_interval " +
                "set week_day = ?, start = ?, end = ? " +
                "where id_work_interval = ? and barber_shop_id = ?";
        PreparedStatement ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        Timestamp start = workIntervalDto.getStart();
        ps.setString(1, (new SimpleDateFormat("EEEE")).format(start.getTime()).toUpperCase());
        ps.setTimestamp(2, workIntervalDto.getStart());
        ps.setTimestamp(3, workIntervalDto.getEnd());
        ps.setInt(4, workIntervalDto.getIdWorkInterval());
        ps.setInt(5, workIntervalDto.getBarberShopid());
        return ps.executeUpdate();
    };

    public int deleteWorkInterval(MinWorkIntervalDto workIntervalDto) throws SQLException{
        String query = "delete from work_interval " +
                "where id_work_interval = ? and barber_shop_id = ?";
        PreparedStatement ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        ps.setInt(1, workIntervalDto.getIdWorkInterval());
        ps.setInt(2, workIntervalDto.getBarberShopid());
        return ps.executeUpdate();
    };

    public List<WorkInterval> getWorkIntervalsByBarberShop(Integer barberShopId) throws SQLException {
        PreparedStatement ps = conn.prepareStatement("select * from work_interval wi where wi.barber_shop_id = ?");
        ps.setInt(1, barberShopId);
        ps.execute();
        ResultSet rs = ps.getResultSet();
        List<WorkInterval> workIntervals = new ArrayList<>();
        while (rs.next()) {
            workIntervals.add(
                    WorkInterval.builder()
                            .idWorkInterval(rs.getInt(1))
                            .barberShopId(rs.getInt(2))
                            .weekDay(rs.getString(3))
                            .start(rs.getTime(4))
                            .end(rs.getTime(5))
                            .build()
            );
        }
        return workIntervals;
    }
}
