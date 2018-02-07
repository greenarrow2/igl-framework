package com.igl.gov.common.param;

import io.swagger.annotations.ApiModelProperty;

public class PageParam {

    @ApiModelProperty(name = "page",value = "页码",required = true,dataType = "integer")
    private Integer page;

    @ApiModelProperty(name = "rows",value = "分页长度",required = true,dataType = "integer")
    private Integer rows;

    private Integer start;

    private Integer offset;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }

    public Integer getStart() {
        if(this.page <= 1){
            this.start = 0;
            return start;
        }
        this.start = (this.page - 1) * this.rows;
        return start;
    }

    public Integer getOffset() {
        offset = rows;
        return offset;
    }

}
