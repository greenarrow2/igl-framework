package com.igl.gov.common.param;

import io.swagger.annotations.ApiModelProperty;

public class PageParam {

    @ApiModelProperty(name = "page",value = "页码",required = true,dataType = "integer")
    private Integer page=1;

    @ApiModelProperty(name = "pageSize",value = "分页长度",required = true,dataType = "integer")
    private Integer pageSize=20;

    private Integer start;

    private Integer offset;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getStart() {
        if(this.page <= 1){
            this.start = 0;
            return start;
        }
        this.start = (this.page - 1) * this.pageSize;
        return start;
    }

    public Integer getOffset() {
        offset = pageSize;
        return offset;
    }

}
