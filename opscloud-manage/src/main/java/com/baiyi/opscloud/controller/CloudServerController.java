package com.baiyi.opscloud.controller;

import com.baiyi.opscloud.domain.DataTable;
import com.baiyi.opscloud.domain.HttpResult;
import com.baiyi.opscloud.domain.param.cloud.CloudServerParam;
import com.baiyi.opscloud.domain.vo.cloud.OcCloudServerVO;
import com.baiyi.opscloud.facade.CloudServerFacade;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * @Author baiyi
 * @Date 2020/2/17 9:30 上午
 * @Version 1.0
 */
@RestController
@RequestMapping("/cloud/server")
@Api(tags = "云服务器")
public class CloudServerController {

    @Resource
    private CloudServerFacade cloudserverFacade;

    @ApiOperation(value = "分页查询云主机列表")
    @GetMapping(value = "/page/query", produces = MediaType.APPLICATION_JSON_VALUE)
    public HttpResult<DataTable<OcCloudServerVO.CloudServer>> queryCloudServerPage(@Valid CloudServerParam.PageQuery pageQuery) {
        return new HttpResult<>(cloudserverFacade.queryCloudServerPage(pageQuery));
    }

    @ApiOperation(value = "删除指定的云主机")
    @DeleteMapping(value = "/del", produces = MediaType.APPLICATION_JSON_VALUE)
    public HttpResult<Boolean> deleteCloudServerById(@RequestParam int id) {
        return new HttpResult<>(cloudserverFacade.deleteCloudServerById(id));
    }

    @ApiOperation(value = "同步指定的云主机")
    @GetMapping(value = "/sync", produces = MediaType.APPLICATION_JSON_VALUE)
    public HttpResult<Boolean> syncCloudServerByKey(@RequestParam String key) {
        return new HttpResult<>(cloudserverFacade.syncCloudServerByKey(key));
    }
}
