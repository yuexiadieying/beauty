package com.meixiang.beauty.common.dataSource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class DataSource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        return DataSourceSwitch.getDataSourceType();
    }

}