package com.jc.param;

/**
 * FileName: RoleParams
 *
 * @author: haichaoyang3
 * @date: 2020/7/9 13:56
 * Description:
 * History:
 * since: 1.0.0
 */

public class RoleParams {

    private String roleName;
    private String note;
    private PageParam pageParam;

    public PageParam getPageParam() {
        return pageParam;
    }

    public void setPageParam(PageParam pageParam) {
        this.pageParam = pageParam;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
