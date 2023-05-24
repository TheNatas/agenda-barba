package schedule.repositories;

import schedule.entities.ScheduleEntity;
import lombok.AllArgsConstructor;

import java.sql.*;
import java.util.ArrayList;


@AllArgsConstructor
public class ScheduleRepository {
    private Connection conn;

    public ArrayList<ScheduleEntity> getFullSchedule(Integer barberShopId) throws SQLException {
        String query = "select service_id, employee_id, user_id, "
                        + "date, schedule_status, barber_shop_id "
                        + "from schedule "
                        + "where barber_shop_id = ?"
                        + "and date > sysdate()";

        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1, barberShopId);
        ps.execute();
        ResultSet rs = ps.getResultSet();
        ArrayList<ScheduleEntity> scheduleList = new ArrayList<ScheduleEntity>();
        while(rs.next()){
            ScheduleEntity scheduleEntity = new ScheduleEntity();
            scheduleEntity.setServiceId(rs.getInt(1));
            scheduleEntity.setEmployeeId(rs.getInt(2));
            scheduleEntity.setUserId(rs.getInt(3));
            scheduleEntity.setDate(rs.getDate(4));
            scheduleEntity.setScheduleStatus(rs.getString(5));
            scheduleEntity.setBarberShopId(rs.getInt(6));
            scheduleList.add(scheduleEntity);
        }
        return scheduleList;
    }
}
