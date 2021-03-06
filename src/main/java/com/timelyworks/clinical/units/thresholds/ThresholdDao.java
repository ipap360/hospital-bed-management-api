package com.timelyworks.clinical.units.thresholds;

import com.google.common.base.CaseFormat;
import com.timelyworks.clinical.db.DB;
import com.timelyworks.clinical.db.DBMapMapper;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@NoArgsConstructor
public class ThresholdDao {

    public List<Map<String, Object>> list() {
        final String sql = "SELECT * FROM THRESHOLDS ORDER BY THRESHOLD ASC";
        return DB.get().withHandle(db -> db.createQuery(sql)
                .map(new DBMapMapper(CaseFormat.LOWER_CAMEL))
                .list());
    }

}
