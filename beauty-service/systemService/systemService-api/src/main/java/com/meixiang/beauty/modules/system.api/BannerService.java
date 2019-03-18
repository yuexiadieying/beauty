package com.meixiang.beauty.modules.system.api;

import com.meixiang.beauty.common.dto.system.BannerDTO;

import java.util.List;

/**
 * Created by zbm84 on 2017/5/27.
 */
public interface BannerService {

    List<BannerDTO> getHomeBannerList();
}
